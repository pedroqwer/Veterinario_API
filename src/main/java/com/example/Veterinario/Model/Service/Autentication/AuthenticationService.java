package com.example.Veterinario.Model.Service.Autentication;

import com.example.Veterinario.Config.Security.JwtTokenProvider;
import com.example.Veterinario.Model.Entity.Perfil;
import com.example.Veterinario.Model.Entity.Usuario;
import com.example.Veterinario.Model.Repository.Usuario.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private IUsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public Usuario signup(Usuario newUser) {
        try {
            // Verificar si el nombre de usuario ya existe
            if (userRepository.existsByUsername(newUser.getUsername())) {
                throw new IllegalArgumentException("Username is already in use");
            }

            // Establecer la contraseña cifrada y la fecha de creación del usuario
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            newUser.setCreationDate(LocalDateTime.now());
            newUser.setUsername(newUser.getUsername());

            // Guardar el nuevo usuario en la base de datos
            Usuario usuarioGuardado = userRepository.save(newUser);

            return usuarioGuardado;

        } catch (Exception e) {
            // Puedes personalizar el mensaje o registrar el error
            //throw new CreateEntityException("Error al registrar el usuario:  " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public String authenticate(Usuario user) {
        // Autenticación del usuario con los datos proporcionados
        Authentication authResult = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        // Obtener el usuario autenticado desde la base de datos
        Usuario usuarioAutenticado = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Verificar si es una instancia de Perfil antes de registrar la auditoría
        if (!(usuarioAutenticado instanceof Perfil)) {
            throw new RuntimeException("El usuario autenticado no es un perfil válido");
        }

        Perfil perfil = (Perfil) usuarioAutenticado;

        // Cambiar el estado a activo si no lo está
        if (!perfil.isActivo()) {
            perfil.setActivo(true);
            userRepository.save(perfil); // Guardar cambios en la base de datos
        }

        perfil.setUltimoLogin(LocalDateTime.now());

        // Establecer la autenticación en el contexto de seguridad
        SecurityContextHolder.getContext().setAuthentication(authResult);

        // Generar y devolver el token JWT
        return jwtTokenProvider.generateToken(authResult);
    }
}

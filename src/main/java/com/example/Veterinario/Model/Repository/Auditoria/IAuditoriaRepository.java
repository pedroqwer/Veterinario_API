package com.example.Veterinario.Model.Repository.Auditoria;

import com.example.Veterinario.Model.Entity.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuditoriaRepository extends CrudRepository<Auditoria, Integer> {
}

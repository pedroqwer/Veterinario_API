CREATE TABLE archivos
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    nombre       VARCHAR(255)          NULL,
    ruta         VARCHAR(255)          NULL,
    tipo_mime    VARCHAR(255)          NULL,
    `tamaño`     BIGINT                NULL,
    fecha_subida datetime              NULL,
    subido_por   BIGINT                NULL,
    CONSTRAINT pk_archivos PRIMARY KEY (id)
);

CREATE TABLE auditorias
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    usuario_id    BIGINT                NULL,
    accion        VARCHAR(255)          NOT NULL,
    entidad       VARCHAR(255)          NOT NULL,
    fecha_accion  datetime              NULL,
    detalles_json TEXT                  NULL,
    CONSTRAINT pk_auditorias PRIMARY KEY (id)
);

CREATE TABLE citas
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    mascota_id     BIGINT                NULL,
    perfil_id      BIGINT                NULL,
    veterinario_id BIGINT                NULL,
    estado         VARCHAR(255)          NOT NULL,
    fecha_inicio   datetime              NOT NULL,
    fecha_fin      datetime              NULL,
    motivo         VARCHAR(255)          NOT NULL,
    creado_por     BIGINT                NULL,
    CONSTRAINT pk_citas PRIMARY KEY (id)
);

CREATE TABLE facturas
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    cliente_id        BIGINT                NULL,
    monto_total       DECIMAL               NOT NULL,
    estado            VARCHAR(255)          NULL,
    fecha_vencimiento date                  NULL,
    items_json        TEXT                  NULL,
    fecha_pago        date                  NULL,
    CONSTRAINT pk_facturas PRIMARY KEY (id)
);

CREATE TABLE historiales_medicos
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    mascota_id      BIGINT                NULL,
    veterinario_id  BIGINT                NULL,
    fecha_visita    datetime              NULL,
    resumen         VARCHAR(255)          NULL,
    diagnostico     VARCHAR(255)          NOT NULL,
    notas           VARCHAR(255)          NULL,
    archivos_json   TEXT                  NULL,
    prescripcion_id BIGINT                NULL,
    CONSTRAINT pk_historiales_medicos PRIMARY KEY (id)
);

CREATE TABLE inventario
(
    id                   BIGINT AUTO_INCREMENT NOT NULL,
    nombre               VARCHAR(255)          NOT NULL,
    codigo               VARCHAR(255)          NOT NULL,
    cantidad_disponible  INT                   NULL,
    minimo_alerta        INT                   NULL,
    ultima_actualizacion datetime              NULL,
    CONSTRAINT pk_inventario PRIMARY KEY (id)
);

CREATE TABLE mascotas
(
    id                    BIGINT AUTO_INCREMENT NOT NULL,
    perfil_id             BIGINT                NULL,
    nombre                VARCHAR(255)          NOT NULL,
    especie               VARCHAR(255)          NOT NULL,
    raza                  VARCHAR(255)          NOT NULL,
    sexo                  VARCHAR(255)          NOT NULL,
    `fecha de nacimiento` date                  NOT NULL,
    microchip             BIT(1)                NOT NULL,
    notas                 VARCHAR(255)          NULL,
    CONSTRAINT pk_mascotas PRIMARY KEY (id)
);

CREATE TABLE perfil
(
    id       BIGINT       NOT NULL,
    nombre   VARCHAR(30)  NOT NULL,
    apellido VARCHAR(30)  NOT NULL,
    dni      VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    telefono VARCHAR(255) NOT NULL,
    CONSTRAINT pk_perfil PRIMARY KEY (id)
);

CREATE TABLE prescripciones
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    medicamento   VARCHAR(255)          NOT NULL,
    dosis         VARCHAR(255)          NOT NULL,
    duracion      VARCHAR(255)          NOT NULL,
    instrucciones VARCHAR(255)          NOT NULL,
    emitido_por   BIGINT                NULL,
    CONSTRAINT pk_prescripciones PRIMARY KEY (id)
);

CREATE TABLE `role`
(
    id     INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(255)       NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE user_role
(
    role_id     INT    NOT NULL,
    user_codigo BIGINT NOT NULL
);

CREATE TABLE usuario
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    username           VARCHAR(255)          NOT NULL,
    password           VARCHAR(255)          NOT NULL,
    `creación`         datetime              NOT NULL,
    activo             BIT(1) DEFAULT 1      NOT NULL,
    fecha_ultimo_login datetime              NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);

CREATE TABLE vacunaciones
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    mascota_id       BIGINT                NULL,
    nombre_vacuna    VARCHAR(255)          NOT NULL,
    fecha_aplicacion date                  NULL,
    proxima_dosis    date                  NULL,
    lote             VARCHAR(255)          NULL,
    CONSTRAINT pk_vacunaciones PRIMARY KEY (id)
);

ALTER TABLE perfil
    ADD CONSTRAINT uc_perfil_dni UNIQUE (dni);

ALTER TABLE perfil
    ADD CONSTRAINT uc_perfil_email UNIQUE (email);

ALTER TABLE perfil
    ADD CONSTRAINT uc_perfil_telefono UNIQUE (telefono);

ALTER TABLE usuario
    ADD CONSTRAINT uc_usuario_password UNIQUE (password);

ALTER TABLE usuario
    ADD CONSTRAINT uc_usuario_username UNIQUE (username);

ALTER TABLE archivos
    ADD CONSTRAINT FK_ARCHIVOS_ON_SUBIDO_POR FOREIGN KEY (subido_por) REFERENCES perfil (id);

ALTER TABLE auditorias
    ADD CONSTRAINT FK_AUDITORIAS_ON_USUARIO FOREIGN KEY (usuario_id) REFERENCES perfil (id);

ALTER TABLE citas
    ADD CONSTRAINT FK_CITAS_ON_CREADO_POR FOREIGN KEY (creado_por) REFERENCES perfil (id);

ALTER TABLE citas
    ADD CONSTRAINT FK_CITAS_ON_MASCOTA FOREIGN KEY (mascota_id) REFERENCES mascotas (id);

ALTER TABLE citas
    ADD CONSTRAINT FK_CITAS_ON_PERFIL FOREIGN KEY (perfil_id) REFERENCES perfil (id);

ALTER TABLE citas
    ADD CONSTRAINT FK_CITAS_ON_VETERINARIO FOREIGN KEY (veterinario_id) REFERENCES perfil (id);

ALTER TABLE facturas
    ADD CONSTRAINT FK_FACTURAS_ON_CLIENTE FOREIGN KEY (cliente_id) REFERENCES perfil (id);

ALTER TABLE historiales_medicos
    ADD CONSTRAINT FK_HISTORIALES_MEDICOS_ON_MASCOTA FOREIGN KEY (mascota_id) REFERENCES mascotas (id);

ALTER TABLE historiales_medicos
    ADD CONSTRAINT FK_HISTORIALES_MEDICOS_ON_PRESCRIPCION FOREIGN KEY (prescripcion_id) REFERENCES prescripciones (id);

ALTER TABLE historiales_medicos
    ADD CONSTRAINT FK_HISTORIALES_MEDICOS_ON_VETERINARIO FOREIGN KEY (veterinario_id) REFERENCES perfil (id);

ALTER TABLE mascotas
    ADD CONSTRAINT FK_MASCOTAS_ON_PERFIL FOREIGN KEY (perfil_id) REFERENCES perfil (id);

ALTER TABLE perfil
    ADD CONSTRAINT FK_PERFIL_ON_ID FOREIGN KEY (id) REFERENCES usuario (id);

ALTER TABLE prescripciones
    ADD CONSTRAINT FK_PRESCRIPCIONES_ON_EMITIDO_POR FOREIGN KEY (emitido_por) REFERENCES perfil (id);

ALTER TABLE vacunaciones
    ADD CONSTRAINT FK_VACUNACIONES_ON_MASCOTA FOREIGN KEY (mascota_id) REFERENCES mascotas (id);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_rol FOREIGN KEY (role_id) REFERENCES `role` (id);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_usuario FOREIGN KEY (user_codigo) REFERENCES usuario (id);
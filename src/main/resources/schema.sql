CREATE TABLE TIPO_HABITACION (
    id UUID PRIMARY KEY,
    nombre_tipo VARCHAR(255) NOT NULL CHECK (LENGTH(nombre_tipo) > 0),
    descripcion VARCHAR(255),
    minimo_metros_cuadrados DECIMAL(5,2) NOT NULL,
    minimo_precio DOUBLE NOT NULL
);

CREATE TABLE HABITACION (
    id UUID PRIMARY KEY,
    hotel VARCHAR(255) NOT NULL,
    planta INT NOT NULL,
    num_habitacion INT NOT NULL,
    pasillo INT NOT NULL,
    tipo_habitacion_id UUID NOT NULL,
    descripcion VARCHAR(255),
    disponible BOOLEAN NOT NULL,
    precio_noche DOUBLE NOT NULL CHECK (precio_noche > 0),
    calefaccion BOOLEAN NOT NULL,
    aire_acondicionado BOOLEAN NOT NULL,
    nevera BOOLEAN NOT NULL,
    metros_cuadrados DECIMAL(5,2) NOT NULL,
    capacidad_maxima INT NOT NULL,
     FOREIGN KEY (tipo_habitacion_id) REFERENCES TIPO_HABITACION(id) ON DELETE RESTRICT
);

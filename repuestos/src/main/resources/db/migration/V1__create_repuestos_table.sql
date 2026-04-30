CREATE TABLE repuestos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    tipo_repuesto VARCHAR(50) NOT NULL,
    stock INT NOT NULL
);
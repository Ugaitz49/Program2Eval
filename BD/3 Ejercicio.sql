
CREATE DATABASE IF NOT EXISTS liga;

USE liga;


CREATE TABLE IF NOT EXISTS Equipos (
    id_equipo INT NOT NULL PRIMARY KEY,
    Nombre VARCHAR(30) NOT NULL UNIQUE,
    Estadio VARCHAR(30) NOT NULL,
    Aforo INT DEFAULT 2000,
    CHECK (Aforo > 100),
    año_fundacion YEAR,
    CHECK (año_fundacion BETWEEN 1850 AND 2050),
    Ciudad VARCHAR(50) NOT NULL
);


CREATE TABLE IF NOT EXISTS Jugadores (
    id_Jugador INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(30) NOT NULL UNIQUE,
    fecha_nac DATE NOT NULL,
    id_equipo INT NOT NULL,

    FOREIGN KEY (id_equipo)
    REFERENCES Equipos(id_equipo)
);


CREATE TABLE IF NOT EXISTS Partidos (
    id_equipo_casa INT NOT NULL,
    id_equipo_fuera INT NOT NULL,
    Fecha DATE NOT NULL,
    goles_casa INT NOT NULL DEFAULT 0,
    goles_fuera INT NOT NULL DEFAULT 0,
    observaciones VARCHAR(50) NOT NULL,

    PRIMARY KEY (id_equipo_casa, id_equipo_fuera, Fecha),

    FOREIGN KEY (id_equipo_casa)
    REFERENCES Equipos(id_equipo),

    FOREIGN KEY (id_equipo_fuera)
    REFERENCES Equipos(id_equipo)
);


CREATE TABLE IF NOT EXISTS Goles (
    id_gol INT PRIMARY KEY AUTO_INCREMENT,
    id_equipo_casa INT NOT NULL,
    id_equipo_fuera INT NOT NULL,
    Fecha DATE NOT NULL,
    Minuto INT,
    CHECK (Minuto BETWEEN 0 AND 130),
    descripcion VARCHAR(50) NOT NULL,
    id_jugador INT NOT NULL,

    FOREIGN KEY (id_equipo_casa, id_equipo_fuera, Fecha)
    REFERENCES Partidos(id_equipo_casa, id_equipo_fuera, Fecha),

    FOREIGN KEY (id_jugador)
    REFERENCES Jugadores(id_Jugador)
);

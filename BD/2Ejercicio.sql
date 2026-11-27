
CREATE DATABASE IF NOT EXISTS fabrica;

USE fabrica;

CREATE TABLE IF NOT EXISTS Proveedor(
    CodProv INT PRIMARY KEY,
    NomProv VARCHAR(50) NOT NULL UNIQUE,
    DirProv VARCHAR(50) NOT NULL,
    CHECK (CodProv > 0)
);

CREATE TABLE IF NOT EXISTS MateriaPrima(
    CodMP INT PRIMARY KEY,
    NpmMP VARCHAR(50) NOT NULL,
    CodProv INT,
    CHECK (CodMP >= 0),
    FOREIGN KEY (CodProv) REFERENCES Proveedor(CodProv)
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Componente(
    CodComp CHAR(4) PRIMARY KEY,
    NomComp VARCHAR(50) NOT NULL,
    StockComp INT NOT NULL,
		CHECK (StockComp >= 0),
    StockMinComp INT NOT NULL DEFAULT 5,
		CHECK (StockMinComp >= 0)
);

CREATE TABLE IF NOT EXISTS Composicion(
    CodCompSup VARCHAR(4),
    CodCompInf VARCHAR(4),
    Cant INT NOT NULL DEFAULT 1,
    PRIMARY KEY (CodCompSup, CodCompInf),
    CHECK (Cant > 0),
    FOREIGN KEY (CodCompSup) 
		REFERENCES Componente(CodComp)
        ON DELETE RESTRICT,
    FOREIGN KEY (CodCompInf) 
		REFERENCES Componente(CodComp)
        ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS Fabricacion(
    CodMP INT,
    CodComp CHAR(4),
    PRIMARY KEY (CodMP, CodComp),
    FOREIGN KEY (CodMP) 
		REFERENCES MateriaPrima(CodMP)
        ON DELETE RESTRICT,
    FOREIGN KEY (CodComp) 
		REFERENCES Componente(CodComp)
        ON DELETE RESTRICT
);






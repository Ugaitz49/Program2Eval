CREATE DATABASE fabrica;
USE fabrica;
CREATE TABLE proveedor(
	CodProv INT PRIMARY KEY
    CHECK (CodProv > 0.00),
    NomProv VARCHAR(50) NOT NULL UNIQUE,
    DirProv VARCHAR(50) NOT NULL
);

CREATE TABLE MateriaPrima(
	codComp int primary key
   check (codComp >=0.00),
    NomMp VARCHAR(50) NOT NULL unique,
    FOREIGN KEY(CodProv)
		REFERENCES proveedor(CodProv)
        ON UPDATE CASCADE
);

CREATE TABLE Componentes(
	CodComp varchar(4) NOT NULL PRIMARY KEY,
	NomComp VARCHAR(50) NOT NULL,
    StockComp INT NOT NULL
		CHECK (StockComp > 0.00),
    StockMinComp INT NOT NULL
		CHECK (StockMinComp >0.00)
		DEFAULT 5
);

CREATE TABLE Composicion(
	CodCompSup varchar(4),
    CodCompInf varchar(4),
	PRIMARY KEY(CodCompSup,CodCompInf),
	Cant INT NOT NULL DEFAULT 1.00,
  check (cant>=0.00),
    FOREIGN KEY(CodCompSup) 
		REFERENCES Componentes(CodCompSup)
	on delete restrict
);

CREATE TABLE Fabricacion(
	CodMp varchar (10) primary key not null,
    CodComp varchar (10) primary key not null
);
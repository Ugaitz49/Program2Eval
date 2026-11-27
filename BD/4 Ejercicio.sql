create database recaudacion;
use recaudacion;
create table vehiculos (
	Matricula varchar(7) primary key,
	MarcaModelo varchar(50),
    Impuesto INT not null default 50,
    check(Impuesto >=10)
);
create table Guardias (
	CodigoG varchar(50) primary key,
	CodigoGJefe varchar(50),
    Nombre varchar(50) not null,
    Comisaria varchar(50),
		check(Comisaria in('Getxo','Bilbao')),
    foreign key (CodigoJefe)
		references guardias(codigoG)
);
CREATE TABLE Multas (
    NMulta INT AUTO_INCREMENT PRIMARY KEY,
    CodigoG VARCHAR(50) NOT NULL,
    FOREIGN KEY (CodigoG)
        REFERENCES Guardias(CodigoG),
    Matricula VARCHAR(7) NOT NULL,
    FOREIGN KEY (Matricula)
        REFERENCES Vehiculos(Matricula),
    Fecha DATE NOT NULL DEFAULT (DATE),
    Lugar VARCHAR(50) NOT NULL,
    Descripcion VARCHAR(100) NOT NULL,
    Importe DECIMAL(6,2) NOT NULL,
    Pagada ENUM('SI','NO') NOT NULL,
    CHECK (Importe BETWEEN 15.00 AND 600.00)
);
create database recaudacion;
use recaudacion;
create table vehiculos (
	Matricula varchar(7) primary key,
	MarcaModelo varchar(50),
    Impuesto decimal(6,2) not null default 50.00,
    check(Impuesto >=10.00)
);
create table Guardias (
	CodigoG varchar(50) primary key,
	CodigoGJefe varchar(50),
    Nombre varchar(50) not null,
    foreign key (CodigoJefe)
		references guardias(codigoG)
);
create table Multas(
	NMulta int auto_increment primary key,
	CodigoG varchar(5) NOT null,
	foreign key (CodigoG)
		references guardias(CodigoG),
	Matricula varchar(7) not null,
    foreign key (Matricula)
		references vehiculos(Matricula),
    Fecha date not null default(current_date),
	Lugar varchar(50) not null,
    Descripcion varchar(100) not null,
    Importe decimal(6,2) not null,
    Pagada enum('SI','NO') not null,
    check (Importe BETWEEN 15.00 AND 600.00)
);
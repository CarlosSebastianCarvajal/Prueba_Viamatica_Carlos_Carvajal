

--CREATE DATABASE apilogin;


create table Persona(
	idPersona serial not null,
	nombres varchar(80),
	apellidos varchar,
	identificacion varchar(10),
	fechaNacimiento date,
	CONSTRAINT Persona_PK PRIMARY KEY (idPersona)
);

--delete from Usuario;
--delete from Persona;
--select * from Persona;

create table Usuario(
	idUsuario serial not null,
	idPersona integer not null,
	userName varchar(50),
	contrasenia varchar(20),
	mail varchar(120),
	sessionActive char(1),
	status varchar(20),
	CONSTRAINT Usuario_PK PRIMARY KEY (idUsuario),
	CONSTRAINT Usuario_Persona_FK FOREIGN KEY (idPersona) REFERENCES public.Persona(idPersona)
);
--select * from Usuario

create table Sessions(
	fechaIngreso date,
	fachaCierre date,
	idUsuario integer not null,
	CONSTRAINT Sessions_Usuario_FK FOREIGN KEY (idUsuario) REFERENCES public.Usuario(idUsuario)
);

create table Rol(
	idRol serial not null,
	rolName varchar(50),
	CONSTRAINT Rol_PK PRIMARY KEY (idRol)
);

create table rolUsuario(
	idRol integer,
	idUsuario integer,
	CONSTRAINT rolUsuario_Usuario_FK FOREIGN KEY (idUsuario) REFERENCES public.Usuario(idUsuario),
	CONSTRAINT rolUsuario_Rol_FK FOREIGN KEY (idRol) REFERENCES public.Rol(idRol)
);

create table rolOpciones(
	idOpcion serial not null,
	nombreOpcion varchar(50),
	CONSTRAINT rolOpciones_PK PRIMARY KEY (idOpcion)
);

create table rolRolOpciones(
	idOpcion integer,
	idRol integer,
	CONSTRAINT rolRolOpciones_rolOpciones_FK FOREIGN KEY (idOpcion) REFERENCES public.rolOpciones(idOpcion),
	CONSTRAINT rolRolOpciones_Rol_FK FOREIGN KEY (idRol) REFERENCES public.Rol(idRol)
);

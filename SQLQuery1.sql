--CREATE DATABASE ALL_RETAILER;
USE ALL_RETAILER;

IF OBJECT_ID(N'PERSONA', N'U') IS NULL
BEGIN

	EXECUTE (
		N'CREATE TABLE PERSONA (
			id			NVARCHAR(13) PRIMARY KEY,
			nombre		NVARCHAR(50),
			correo		NVARCHAR(50),
			direccion	NVARCHAR(50),
			telefono	NVARCHAR(15),
			usuario		NVARCHAR(50),
			clave		NVARCHAR(30),
			salario		INT,
			activo		BIT DEFAULT 1 NOT NULL,
			bonificacion INT
		)'		
	);
		
END;
GO

IF OBJECT_ID(N'TIENDA', N'U') IS NULL
BEGIN

	EXECUTE (
		N'CREATE TABLE TIENDA (
			id				INT IDENTITY(0,1) PRIMARY KEY,
			nombre			NVARCHAR(50) NOT NULL,
			ciudad			NVARCHAR(50),
			direccion		NVARCHAR(50),
			telefono		NVARCHAR(15)
		)'		
	);
		
END;
GO

IF OBJECT_ID(N'ROL', N'U') IS NULL
BEGIN

	EXECUTE (
		N'CREATE TABLE ROL (
			id		INT IDENTITY(1,1) PRIMARY KEY,
			nombre	NVARCHAR(50) NOT NULL
		)'		
	);
		
END;
GO

IF OBJECT_ID(N'ROL_PERSONA', N'U') IS NULL
BEGIN

	EXECUTE (
		N'CREATE TABLE ROL_PERSONA (
			rolId		INT NOT NULL,
			personaId	NVARCHAR(13)NOT NULL,
			tiendaId	INT NOT NULL,
			CONSTRAINT PK_ROL_PERSONA PRIMARY KEY(rolId,personaId,tiendaId),
			CONSTRAINT FK01 FOREIGN KEY (rolId) REFERENCES ROL (id),
			CONSTRAINT FK02 FOREIGN KEY (personaId) REFERENCES PERSONA (id),
			CONSTRAINT FK03 FOREIGN KEY (tiendaId) REFERENCES TIENDA (id)
		)'		
	);
		
END;
GO
IF OBJECT_ID(N'PROVEEDOR', N'U') IS NULL
BEGIN

	EXECUTE (
		N'CREATE TABLE PROVEEDOR (
			id					NVARCHAR(30) ,
			nombre				NVARCHAR(50),
			telefono			NVARCHAR(13),
			direccion			NVARCHAR(50),
			ciudad				NVARCHAR(30),
			tipoDeProducto		NVARCHAR(30),
			tiendaId			INT NOT NULL,
			primary key (tiendaId, id),
			CONSTRAINT FK02_PROVEEDOR FOREIGN KEY (tiendaId) REFERENCES TIENDA (id)
		)'
	);

END;
GO

IF OBJECT_ID(N'PRODUCTO', N'U') IS NULL
BEGIN

	EXECUTE (
		N'CREATE  TABLE PRODUCTO (
			id					NVARCHAR(30),
			nombre				NVARCHAR(50),
			cantidad			INT,
			precioIngreso		INT,
			precioVenta			INT,
			fechaIngreso		DATETIME NOT NULL DEFAULT Getdate(),
			fechaVencimiento	DATETIME,
			proveedorId			NVARCHAR(30) null,
			tiendaId			INT NOT NULL ,
			primary key (tiendaId, id),
			CONSTRAINT FK02_PRODUCTO FOREIGN KEY (tiendaId) REFERENCES TIENDA (id)
		)'
	);

END;
GO
IF OBJECT_ID(N'FACTURA', N'U') IS NULL
BEGIN

	EXECUTE (
		N'CREATE TABLE FACTURA (
			id					INT IDENTITY(1,1) PRIMARY KEY,
			valorTotal			INT
		)'		
	);		
END;
GO
IF OBJECT_ID(N'FACTURA_PRODUCTO', N'U') IS NULL
BEGIN

	EXECUTE (
		N'CREATE TABLE FACTURA_PRODUCTO (
			idFactura			INT,
			idProducto			NVARCHAR(30),
			cantidad			INT,
			valor				INT,
			CONSTRAINT FK01_FACTURA_PRODUCTO FOREIGN KEY (idFactura) REFERENCES FACTURA (id),
			CONSTRAINT FK02_FACTURA_PRODUCTO FOREIGN KEY (idProducto) REFERENCES PRODUCTO (id)
		)'		
	);		
END;
GO





IF NOT EXISTS(SELECT 1 FROM PERSONA WHERE id = '1030424')
BEGIN
	INSERT INTO PERSONA VALUES ('1030424','Juan Cortez','test@testeo.com',
								NULL,NULL,'admin','123',NULL,1,NULL);
END;
GO
IF NOT EXISTS(SELECT 1 FROM PERSONA WHERE id = '1030423')
BEGIN
	INSERT INTO PERSONA VALUES ('1030423','Hernando Ferla','test@testeo.com',
								NULL,NULL,'admin1','123',343534,1,NULL);
END;
GO
IF NOT EXISTS(SELECT 1 FROM ROL WHERE id = 1)
BEGIN
	INSERT INTO ROL VALUES ('SuperAdmin');
	INSERT INTO ROL VALUES ('Administrador');
	INSERT INTO ROL VALUES ('Empleado');
END;
GO
IF NOT EXISTS(SELECT 1 FROM TIENDA WHERE id = 0)
BEGIN
	INSERT INTO TIENDA VALUES ('SUPER-ADMINISTRADOR',NULL,NULL,NULL);
	INSERT INTO TIENDA VALUES ('la estrellita','Bogota DC','Calle 43 e 23 12','2443564');
END;
GO
IF NOT EXISTS(SELECT 1 FROM ROL_PERSONA WHERE rolId = 1)
BEGIN							
	INSERT INTO ROL_PERSONA VALUES (1,'1030424',0);
END;
GO
IF NOT EXISTS(SELECT 1 FROM ROL_PERSONA WHERE rolId = 2)
BEGIN							
	INSERT INTO ROL_PERSONA VALUES (2,'1030423',1);
END;
GO

/*

SELECT * FROM PERSONA
SELECT * FROM ROL
SELECT * FROM TIENDA

SELECT * FROM ROL_PERSONA
select * from PRODUCTO
select * from FACTURA
select * from FACTURA_PRODUCTO
*/



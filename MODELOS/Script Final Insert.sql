INSERT INTO usuario VALUES
('dnisergio','Sergio Suarez', 'ssc0016','Mecanico', 1),
('dniluis','Luis Herencia', 'lhg0015','Mecanico', 1 ),
('dnipepe','Pepe Arenas', 'jav0010','Mecanico', 1),
('admin', 'Administrador', 'admin', 'Administrador', 1);
select *  FROM usuario;


INSERT INTO servicio VALUES
('Mecanica', 50),
('Diagnostico', 50),
('Pre-ITV', 50),
('Frenos y ABS', 50),
('Aceite y Filtros', 75),
('Neumaticos', 75),
('Revision Oficial', 75),
('Matriculas', 75),
('Chapa y Pintura', 75),
('Equilibrado y Alineacion', 95),
('Climatización/Aire Acondicionado', 95),
('Electricidad/Electrónica', 95);
select * from servicio;

select * from cliente;

INSERT INTO cliente VALUES
('12345678A', 'Juan', 'Pérez', '33333333'),
('23456789B', 'María', 'Gómez', '33333433'),
('34567890C', 'Luis', 'Martínez', '33633333'),
('45678901D', 'Ana', 'López', '94444444'),
('56789012E', 'Carlos', 'Hernández', '23233233'),
('67890123F', 'Laura', 'Sánchez', '944445945'),
('78901234G', 'Pedro', 'Ramírez', '999343434'),
('89012345H', 'Sofía', 'Torres', '3333444'),
('90123456I', 'Javier', 'Flores', '972727272'),
('01234567J', 'Isabel', 'Segunda', '11223455');


select * from vehiculo;
INSERT INTO vehiculo (matricula, marca, modelo, cliente_dni) VALUES
('1234ABC', 'Toyota', 'Corolla', '12345678A'),
('5678DEF', 'Honda', 'Civic', '23456789B'),
('9012GHI', 'Ford', 'Fiesta', '34567890C'),
('3456JKL', 'Volkswagen', 'Golf', '45678901D'),
('7890MNO', 'Nissan', 'Qashqai', '56789012E'),
('2345PQR', 'Chevrolet', 'Tracker', '67890123F'),
('6789STU', 'Hyundai', 'i30', '78901234G'),
('0123VWX', 'Kia', 'Sportage', '89012345H'),
('4567YZA', 'Peugeot', '308', '90123456I'),
('8901BCD', 'Renault', 'Clio', '01234567J');

select * from orden;
INSERT INTO orden (referencia, estado, proceso, fecha_ingreso, mecanico_dni, servicio_nombre, vehiculo_matricula, descripcion, fecha_salida) VALUES
('ORD001', 'Pendiente', 'Sin comenzar', '2024-10-01', 'dniluis', 'Mecanica', '1234ABC', NULL, NULL),
('ORD002', 'Asignada', 'En reparación', '2024-10-02', 'dniluis', 'Aceite y Filtros', '5678DEF', NULL, NULL),
('ORD003', 'Pendiente', 'Sin comenzar', '2024-10-03', 'dniluis', 'Revision Oficial', '9012GHI', NULL, NULL),
('ORD004', 'Asignada', 'Sin comenzar', '2024-10-04', 'dniluis', 'Mecanica', '3456JKL', NULL, NULL),
('ORD005', 'Pendiente', 'Sin comenzar', '2024-10-05', 'dnipepe', 'Frenos y ABS', '7890MNO', NULL, NULL),
('ORD006', 'Asignada', 'En diagnóstico', '2024-10-06', 'dnipepe', 'Revision Oficial', '2345PQR', NULL, NULL),
('ORD007', 'Pendiente', 'Sin comenzar', '2024-10-07', 'dnipepe', 'Mecanica', '6789STU', NULL, NULL),
('ORD008', 'Asignada', 'Finalizada', '2024-10-08', 'dnipepe', 'Electricidad/Electrónica', '0123VWX', 'Se ha instalado una batería de alta eficiencia, marca ElectrX.', '2024-10-09'),
('ORD009', 'Pendiente', 'Sin comenzar', '2024-10-09', 'dnisergio', 'Revision Oficial', '4567YZA', NULL, NULL),
('ORD010', 'Asignada', 'Finalizada', '2024-10-10', 'dnisergio', 'Mecanica', '8901BCD', 'Se ha realizado la reparación completa del tubo de escape.', '2024-10-11');

select * from factura;
INSERT INTO factura (referencia, orden_referencia, fecha, total) VALUES
(1, 'ORD008', '2024-10-09', 150.00),
(2, 'ORD010', '2024-10-11', 200.00);

select * from almacen;
INSERT INTO almacen (id_pieza, nombre_pieza, stock) VALUES
(1, 'Aceite de motor', '150 litros'),               -- Para 'Aceite y Filtros'
(2, 'Filtro de aceite', '75 unidades'),             -- Para 'Aceite y Filtros'
(3, 'Filtro de aire', '50 unidades'),               -- Para 'Mecanica'
(4, 'Pastillas de freno', '40 pares'),              -- Para 'Frenos y ABS'
(5, 'Discos de freno', '30 unidades'),              -- Para 'Frenos y ABS'
(6, 'Neumático', '100 unidades'),                   -- Para 'Neumaticos'
(7, 'Batería', '20 unidades'),                       -- Para 'Electricidad/Electrónica'
(8, 'Lámpara de faro', '25 unidades'),              -- Para 'Electricidad/Electrónica'
(9, 'Correa de distribución', '15 unidades'),       -- Para 'Mecanica'
(10, 'Amortiguador', '10 unidades'),                -- Para 'Mecanica'
(11, 'Gas de aire acondicionado', '30 litros'),     -- Para 'Climatización/Aire Acondicionado'
(12, 'Pintura', '100 litros'),                       -- Para 'Chapa y Pintura'
(13, 'Material de matriculación', '200 unidades'),  -- Para 'Matriculas'
(14, 'Equipo de alineación', '5 unidades'),         -- Para 'Equilibrado y Alineacion'
(15, 'Herramientas de diagnóstico', '10 unidades'); -- Para 'Diagnostico'

select * from cita;
INSERT INTO cita (id_cita, fecha, vehiculo_matricula) VALUES
(1, '2024-10-15', '2345XYZ'),
(2, '2024-10-16', '6789QWE'),
(3, '2024-10-17', '3456RTY'),
(4, '2024-10-18', '8901ASD'),
(5, '2024-10-19', '5678FGH');



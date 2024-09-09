INSERT INTO TIPO_HABITACION (id, nombre_tipo, descripcion, minimo_metros_cuadrados, minimo_precio) VALUES
('550e8400-e29b-41d4-a716-446655440000', 'Suite', 'Suite con vista al mar y jacuzzi', 45.00, 200.00),
('550e8400-e29b-41d4-a716-446655440001', 'Doble', 'Habitación doble estándar con vistas al jardín', 25.00, 100.00),
('550e8400-e29b-41d4-a716-446655440002', 'Familiar', 'Habitación familiar con dos camas dobles y sofá cama', 35.00, 150.00);

INSERT INTO HABITACION (id, hotel, planta, num_habitacion, pasillo, tipo_habitacion_id, descripcion, disponible, precio_noche, calefaccion, aire_acondicionado, nevera, metros_cuadrados, capacidad_maxima) VALUES
('550e8400-e29b-41d4-a716-446655440010', 'Hotel Central', 3, 301, 1, '550e8400-e29b-41d4-a716-446655440000', 'Suite con vista al mar, jacuzzi privado', TRUE, 250.00, TRUE, TRUE, TRUE, 50.00, 4),
('550e8400-e29b-41d4-a716-446655440011', 'Hotel Central', 2, 202, 2, '550e8400-e29b-41d4-a716-446655440001', 'Habitación doble estándar con vista al jardín', TRUE, 110.00, TRUE, TRUE, FALSE, 28.00, 2),
('550e8400-e29b-41d4-a716-446655440012', 'Hotel Central', 1, 103, 3, '550e8400-e29b-41d4-a716-446655440002', 'Habitación familiar con dos camas dobles y sofá cama', TRUE, 180.00, TRUE, TRUE, TRUE, 36.00, 6);

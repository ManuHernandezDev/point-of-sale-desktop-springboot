-- -- IMPORTANTE: Asumiendo que tu tabla tiene las columnas para la lógica EAN
-- -- Si no las has creado, solo usa 'barcode'.

-- -- 1. Zapatos Deportivos (Categoría 03)
-- -- Secuencia: 1, Talla: 27 -> Código Base: 2030000127 -> Checksum: 9
INSERT INTO product (barcode, name, price, description, size, color, stock, registration_date, observations, category_code, sequence) 
VALUES ('20300001279', 'Nike Air Max', 2100.00, 'Tenis deportivos con camara de aire', '27', 'Blanco/Rojo', 15, CURRENT_TIMESTAMP(), 'Modelo 2024', 3, 1);

-- Secuencia: 2, Talla: 26 (aprox) -> Código Base: 2030000226 -> Checksum: 9
INSERT INTO product (barcode, name, price, description, size, color, stock, registration_date, observations, category_code, sequence) 
VALUES ('20300002269', 'Adidas Ultraboost', 1899.50, 'Ideal para running, suela suave', '26.5', 'Negro', 10, CURRENT_TIMESTAMP(), NULL, 3, 2);

-- 2. Zapatos Formales (Categoría 01)
-- Secuencia: 3, Talla: 28 -> Código Base: 2010000328 -> Checksum: 2
INSERT INTO product (barcode, name, price, description, size, color, stock, registration_date, observations, category_code, sequence) 
VALUES ('20100003282', 'Mocasín Flexi', 850.00, 'Zapato de piel corte vacuno', '28', 'Cafe', 25, CURRENT_TIMESTAMP(), 'Piel genuina', 1, 3);

-- 3. Zapatos de Dama (Categoría 02)
-- Secuencia: 4, Talla: 24 -> Código Base: 2020000424 -> Checksum: 0
INSERT INTO product (barcode, name, price, description, size, color, stock, registration_date, observations, category_code, sequence) 
VALUES ('20200004240', 'Zapatilla Andrea', 650.00, 'Tacón de 5cm acabado charol', '24', 'Negro', 12, CURRENT_TIMESTAMP(), 'Revisar caja, viene reducida', 2, 4);

-- 4. Botas (Categoría 04)
-- Secuencia: 5, Talla: 27 -> Código Base: 2040000527 -> Checksum: 6
INSERT INTO product (barcode, name, price, description, size, color, stock, registration_date, observations, category_code, sequence) 
VALUES ('20400005276', 'Bota Timberland', 2400.00, 'Bota industrial resistente al agua', '27', 'Amarillo', 8, CURRENT_TIMESTAMP(), 'Garantía extendida', 4, 5);
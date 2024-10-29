INSERT INTO foco_nutricional (name) VALUES
('Perder Peso'),
('Ganho de Massa Muscular'),
('Manutenção de Peso'),
('Melhora da Saúde Geral'),
('Aumento da Energia'),
('Controle de Colesterol'),
('Dieta Vegetariana'),
('Dieta Vegana'),
('Dieta Low Carb'),
('Dieta Paleo');

INSERT INTO restricao_nutricional (name) VALUES
('Diabetes'),
('Hipertensão'),
('Intolerância à Lactose'),
('Alergia ao Glúten'),
('Doença Celíaca'),
('Colesterol Alto'),
('Alergia a Nozes'),
('Insuficiência Renal'),
('Gastrite'),
('Síndrome do Intestino Irritável');


//considerar esses
INSERT INTO foco_nutricional
    (id, name, insertion_date) VALUES
    (1, 'Perder Peso', NOW()),
    (2, 'Ganho de Massa Muscular', NOW()),
    (3, 'Manutenção de Peso', NOW()),
    (4, 'Melhora da Saúde Geral', NOW()),
    (5, 'Aumento da Energia', NOW()),
    (6, 'Controle de Colesterol', NOW()),
    (7, 'Dieta Vegetariana', NOW()),
    (8, 'Dieta Vegana', NOW()),
    (9, 'Dieta Low Carb', NOW()),
    (10, 'Dieta Paleo', NOW());

INSERT INTO restricao_nutricional (id, insertion_date, name)
VALUES (1, NOW(), 'Diabetes'),
       (2, NOW(), 'Hipertensão'),
       (3, NOW(), 'Intolerância à Lactose'),
       (4, NOW(), 'Alergia ao Glúten'),
       (5, NOW(), 'Doença Celíaca'),
       (6, NOW(), 'Colesterol Alto'),
       (7, NOW(), 'Alergia a Nozes'),
       (8, NOW(), 'Insuficiência Renal'),
       (9, NOW(), 'Gastrite'),
       (10, NOW(), 'Síndrome do Intestino Irritável');
CREATE TABLE Categoria (
    id SERIAL PRIMARY KEY,
	nome varchar(50) NOT NULL
);

CREATE TABLE Produto (
    id SERIAL PRIMARY KEY,
	nome varchar(50) NOT NULL,
    qtd_estoque int,
    valor float,
	categoria_id int REFERENCES Categoria(id)
);

insert into Categoria(nome)
values('Limpeza'),
('Música'),
('Eletrodomésticos'),
('Periféricos');

insert into Produto(nome, qtd_estoque, valor, categoria_id)
values('Vasoura', 23, 5.99, 1),
('Rodo', 20, 3.99, 1),
('Pano de chão', 55, 0.5, 1),
('Guitarra', 10, 1550, 2),
('Violão Clássico', 15, 650, 2),
('Violão Profissional', 14, 850, 2),
('Bateria', 8, 2100.50, 2),
('Flauta', 21, 150, 2),
('Flauta Doce', 41, 140, 2),
('Flauta Profissional', 11, 350, 2),
('Flauta Clássica', 32, 350, 2),
('Geladeira Frost Free', 5, 3500, 3),
('Geladeira Inox', 5, 3500, 3),
('Frigobar', 9, 1100.90, 3),
('Micro-ondas', 18, 450.4, 3),
('Mouse', 150, 50, 4),
('Mouse Sem Fio', 165, 154, 4),
('Mouse Gamer', 154, 352, 4),
('Headset Sem Fio', 167, 376, 4),
('Headset Gamer', 187, 750, 4);
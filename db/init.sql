-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS quiz_game_database;
USE quiz_game_database;

-- Tabla de Usuarios
CREATE TABLE IF NOT EXISTS User (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL  
);

-- Tabla de Dificultad
CREATE TABLE IF NOT EXISTS Difficulty (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Tabla de Preguntas
CREATE TABLE IF NOT EXISTS Question (
    id INT AUTO_INCREMENT PRIMARY KEY,  
    description TEXT NOT NULL,
    difficulty_id INT, 
    FOREIGN KEY (difficulty_id) REFERENCES Difficulty(id)
);

-- Tabla de Respuestas
CREATE TABLE IF NOT EXISTS Answers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_id INT,
    description VARCHAR(255) NOT NULL,
    correct BOOLEAN NOT NULL,
    FOREIGN KEY (question_id) REFERENCES Question(id)
);

-- Tabla de Puntuaciones
CREATE TABLE IF NOT EXISTS Score (
    id INT AUTO_INCREMENT PRIMARY KEY,  
    user_id INT, 
    score INT NOT NULL,
    win BOOLEAN NOT NULL,
    difficulty_id INT,  
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (difficulty_id) REFERENCES Difficulty(id)
);

-- Insertar datos de dificultad
INSERT INTO Difficulty (name) VALUES 
('easy'), 
('medium'), 
('hard');

-- Preguntas fáciles
INSERT INTO Question (description, difficulty_id) VALUES 
('¿Cuál es la capital de Francia?', 1),
('¿Qué es la fotosíntesis?', 1),
('¿Cuántos continentes hay en el mundo?', 1),
('¿Cuál es el océano más grande?', 1),
('¿Qué animal es conocido como el "rey de la selva"?', 1),
('¿Cuál es el color del cielo en un día despejado?', 1),
('¿Quién escribió "Cien años de soledad"?', 1),
('¿Qué instrumento musical tiene cuerdas y se toca con un arco?', 1),
('¿Cuántas patas tiene un perro?', 1),
('¿Qué planeta es conocido como el "planeta rojo"?', 1),
('¿Cuál es el idioma más hablado en el mundo?', 1),
('¿Qué fruta es amarilla y se pela?', 1),
('¿Qué parte del cuerpo usamos para oír?', 1),
('¿Qué mes sigue a enero?', 1),
('¿En qué continente se encuentra Egipto?', 1);

-- Preguntas medias
INSERT INTO Question (description, difficulty_id) VALUES 
('¿Quién pintó la Mona Lisa?', 2),
('¿Qué es el ADN?', 2),
('¿Cuál es la capital de Japón?', 2),
('¿Qué evento histórico ocurrió en 1492?', 2),
('¿Cuál es el sistema político de los Estados Unidos?', 2),
('¿Quién es el autor de "Don Quijote de la Mancha"?', 2),
('¿Cuál es el país más grande del mundo?', 2),
('¿Qué es la fotosíntesis?', 2),
('¿Cuál es el río más largo del mundo?', 2),
('¿Quién fue Albert Einstein?', 2),
('¿Cuál es la fórmula del agua?', 2),
('¿Qué es la revolución industrial?', 2),
('¿Quién fue el primer hombre en la luna?', 2),
('¿Qué es el cambio climático?', 2),
('¿Quién escribió "Romeo y Julieta"?', 2);

-- Preguntas difíciles
INSERT INTO Question (description, difficulty_id) VALUES 
('¿Qué teoría explica la formación del universo?', 3),
('¿Quién desarrolló la teoría de la relatividad?', 3),
('¿Qué es la cuántica?', 3),
('¿Cuál es la obra más famosa de Shakespeare?', 3),
('¿Qué es un agujero negro?', 3),
('¿Quién fue el primer emperador romano?', 3),
('¿Qué es el Big Bang?', 3),
('¿Qué civilización construyó las pirámides de Egipto?', 3),
('¿Cuál es el lenguaje de programación más utilizado?', 3),
('¿Qué es el teorema de Pitágoras?', 3),
('¿Quién propuso la teoría de la evolución?', 3),
('¿Qué es la inteligencia artificial?', 3),
('¿Qué significa "filosofía"?', 3),
('¿Qué es la bioética?', 3),
('¿Cuál es la diferencia entre un virus y una bacteria?', 3);

-- Respuestas para preguntas fáciles
INSERT INTO Answers (question_id, description, correct) VALUES 
(1, 'París', TRUE), 
(1, 'Londres', FALSE), 
(1, 'Berlín', FALSE), 

(2, 'El proceso por el cual las plantas producen energía', TRUE), 
(2, 'Un tipo de bebida', FALSE), 
(2, 'Una enfermedad', FALSE), 

(3, 'Siete', FALSE), 
(3, 'Seis', FALSE), 
(3, 'Cinco', TRUE), 

(4, 'Océano Atlántico', FALSE), 
(4, 'Océano Pacífico', TRUE), 
(4, 'Océano Índico', FALSE), 

(5, 'Elefante', FALSE), 
(5, 'León', TRUE), 
(5, 'Tigre', FALSE), 

(6, 'Azul', TRUE), 
(6, 'Verde', FALSE), 
(6, 'Rojo', FALSE), 

(7, 'Gabriel García Márquez', FALSE), 
(7, 'Julio Cortázar', FALSE), 
(7, 'Gabriel García Márquez', TRUE), 

(8, 'Piano', FALSE), 
(8, 'Guitarra', TRUE), 
(8, 'Batería', FALSE), 

(9, 'Cuatro', FALSE), 
(9, 'Tres', FALSE), 
(9, 'Dos', TRUE), 

(10, 'Marte', TRUE), 
(10, 'Júpiter', FALSE), 
(10, 'Tierra', FALSE), 

(11, 'Chino', FALSE), 
(11, 'Español', FALSE), 
(11, 'Inglés', TRUE), 

(12, 'Plátano', TRUE), 
(12, 'Manzana', FALSE), 
(12, 'Naranja', FALSE), 

(13, 'Oído', TRUE), 
(13, 'Ojo', FALSE), 
(13, 'Nariz', FALSE), 

(14, 'Febrero', TRUE), 
(14, 'Marzo', FALSE), 
(14, 'Enero', FALSE), 

(15, 'África', TRUE), 
(15, 'Asia', FALSE), 
(15, 'Europa', FALSE); 

-- Respuestas para preguntas medias
INSERT INTO Answers (question_id, description, correct) VALUES 
(16, 'Leonardo da Vinci', TRUE), 
(16, 'Pablo Picasso', FALSE), 
(16, 'Vincent van Gogh', FALSE), 

(17, 'Un material genético', TRUE), 
(17, 'Una enfermedad', FALSE), 
(17, 'Un tipo de célula', FALSE), 

(18, 'Tokio', TRUE), 
(18, 'Pekín', FALSE), 
(18, 'Seúl', FALSE), 

(19, 'La llegada de Cristóbal Colón a América', TRUE), 
(19, 'La caída del muro de Berlín', FALSE), 
(19, 'La primera guerra mundial', FALSE), 

(20, 'Democracia', TRUE), 
(20, 'Monarquía', FALSE), 
(20, 'Dictadura', FALSE), 

(21, 'Miguel de Cervantes', TRUE), 
(21, 'Gabriel García Márquez', FALSE), 
(21, 'Jorge Luis Borges', FALSE), 

(22, 'Rusia', TRUE), 
(22, 'Canadá', FALSE), 
(22, 'China', FALSE), 

(23, 'El proceso por el cual las plantas producen energía', TRUE), 
(23, 'Un tipo de bebida', FALSE), 
(23, 'Una enfermedad', FALSE), 

(24, 'Amazonas', TRUE), 
(24, 'Nilo', FALSE), 
(24, 'Yangtsé', FALSE), 

(25, 'Un físico', TRUE), 
(25, 'Un filósofo', FALSE), 
(25, 'Un médico', FALSE), 

(26, 'H2O', TRUE), 
(26, 'O2', FALSE), 
(26, 'CO2', FALSE), 

(27, 'El cambio de las condiciones de vida en la industria', TRUE), 
(27, 'Un movimiento político', FALSE), 
(27, 'Un cambio climático', FALSE), 

(28, 'Neil Armstrong', TRUE), 
(28, 'Buzz Aldrin', FALSE), 
(28, 'Yuri Gagarin', FALSE), 

(29, 'Un aumento en las temperaturas globales', TRUE), 
(29, 'Un cambio de gobierno', FALSE), 
(29, 'Una guerra', FALSE), 

(30, 'William Shakespeare', TRUE), 
(30, 'J.K. Rowling', FALSE), 
(30, 'Ernest Hemingway', FALSE);

-- Respuestas para preguntas difíciles
INSERT INTO Answers (question_id, description, correct) VALUES 
(31, 'La teoría del Big Bang', TRUE),
(31, 'La teoría de cuerdas', FALSE),
(31, 'La teoría del todo', FALSE),

(32, 'Albert Einstein', TRUE),
(32, 'Isaac Newton', FALSE),
(32, 'Galileo Galilei', FALSE),

(33, 'Estudio de partículas subatómicas', TRUE),
(33, 'Estudio de la gravedad', FALSE),
(33, 'Estudio de los agujeros negros', FALSE),

(34, 'Hamlet', TRUE),
(34, 'Macbeth', FALSE),
(34, 'Otelo', FALSE),

(35, 'Un objeto con gravedad tan intensa que nada puede escapar', TRUE),
(35, 'Una estrella enana', FALSE),
(35, 'Un tipo de materia oscura', FALSE),

(36, 'Augusto', TRUE),
(36, 'Nerón', FALSE),
(36, 'Julio César', FALSE),

(37, 'La explosión inicial del universo', TRUE),
(37, 'Un tipo de estrella', FALSE),
(37, 'Una teoría de gravedad', FALSE),

(38, 'Los egipcios', TRUE),
(38, 'Los romanos', FALSE),
(38, 'Los griegos', FALSE),

(39, 'JavaScript', TRUE),
(39, 'Python', FALSE),
(39, 'C#', FALSE),

(40, 'Una relación entre los lados de un triángulo', TRUE),
(40, 'Una fórmula matemática', FALSE),
(40, 'Un principio de la física', FALSE),

(41, 'Charles Darwin', TRUE),
(41, 'Louis Pasteur', FALSE),
(41, 'Gregor Mendel', FALSE),

(42, 'El estudio de la existencia', TRUE),
(42, 'El estudio de la mente', FALSE),
(42, 'El estudio de la naturaleza', FALSE),

(43, 'Ética en la biomedicina', TRUE),
(43, 'El estudio de la biología', FALSE),
(43, 'Ética en la investigación', FALSE),

(44, 'Los virus son más pequeños que las bacterias', TRUE),
(44, 'Ambos son iguales', FALSE),
(44, 'Las bacterias son más peligrosas', FALSE);

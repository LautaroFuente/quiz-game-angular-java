-- Tabla de Usuarios
CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL  
);

-- Tabla de Dificultad
CREATE TABLE Difficulty (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Tabla de Preguntas
CREATE TABLE Question (
    id INT AUTO_INCREMENT PRIMARY KEY,  
    description TEXT NOT NULL,
    difficulty_id INT, 
    FOREIGN KEY (difficulty_id) REFERENCES Difficulty(id)
);

-- Tabla de Puntuaciones
CREATE TABLE Score (
    id INT AUTO_INCREMENT PRIMARY KEY,  
    user_id INT, 
    score INT NOT NULL,
    win BOOLEAN NOT NULL,
    difficulty_id INT,  
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (difficulty_id) REFERENCES Difficulty(id)
);
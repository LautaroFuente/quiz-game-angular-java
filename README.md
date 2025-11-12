# 🕹️ Quiz game web

## 📖 Description

**Quiz Game Web** is a fun and dynamic question-and-answer game where players test their knowledge across different difficulty levels — Easy, Medium, and Hard.  
The goal is simple: answer 10 randomly selected questions before time runs out.  
Correct answers give you extra time and points, while wrong answers reduce your time.  
It’s designed to be fast, engaging, and visually appealing with a clean dark-themed interface.

## 🚀 Getting Started

Follow these steps to run the project using **Docker**.

### 🧩 Prerequisites
Make sure you have the following installed:
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- Git (optional, for cloning the repository)

### 🪄 Steps

1. **Clone the repository**
   ``` bash
   git clone https://github.com/your-username/quiz-game-web.git
   cd quiz-game-web  
   ```
2. **Create environment files**
 -   In the project root directory, copy `.env.example` to `.env`
    
-   In the backend folder, copy `.env.example` to `.env`

Example:
   ``` bash
   cp .env.example .env
cp backend/.env.example backend/.env
   ```

3. **Adjust environment variables**
-   Edit both `.env` files to set your desired ports, database credentials, and service names if necessary.
    
-   Example for the backend `.env`:

   ``` bash
DB_URL=jdbc:mysql://mysql_container:3306/quiz_game_database
DB_USERNAME=root
DB_PASSWORD=yourpassword
   ```
4. **Build and start the containers**
   ``` bash 
   docker compose up --build
   ```
   This command will:

-   Start a **MySQL** container with the `init.sql` script that creates the database and populates it.
    
-   Launch the **Spring Boot** backend.
    
-   Serve the **Angular frontend**.

5. **Access the app**
  -   Frontend: [http://localhost:4200](http://localhost:4200)
    
-   Backend API: [http://localhost:8080](http://localhost:8080)
    
-   MySQL database: accessible inside Docker via `mysql_container` at port `3306`.

6. **Stop the containers**
   ``` bash
   docker compose down
   ```

## 🧰 Tech Stack
### 🖥️ Frontend

-   **Angular 18**
    
-   **TypeScript**
    
-   **RxJS**
    
-   **HTML5 / CSS3** (Dark mode, modern minimal style)
    

### ⚙️ Backend

-   **Java 17**
    
-   **Spring Boot 3**
    
-   **Spring Data JPA**
    
-   **Hibernate**
    
-   **MySQL** (with initialization script)
    
-   **REST API** following controller-service-repository architecture
    

### 🐳 DevOps & Environment

-   **Docker** & **Docker Compose** for containerization
    
-   **Environment variables (.env)** for configuration
    
-   **CORS configured** for local and container communication

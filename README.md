# 📝 Notes Management API

A RESTful Notes Management API built using **Spring Boot** and **MySQL**. This project demonstrates CRUD operations, layered architecture, validation, exception handling, pagination, sorting, logging, and DTO-based request/response handling.

---

## 🚀 Features

- Create Note
- Get All Notes
- Get Note By ID
- Update Note
- Soft Delete (Logical Delete)
- Permanent Delete
- Search Notes by Title
- Pagination
- Sorting
- Bean Validation (Jakarta Validation)
- Global Exception Handling
- Request DTO
- Response DTO
- Logging using Lombok (@Slf4j)

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Postman
- Git & GitHub

---

## 🏗️ Architecture

```
Controller
     ↓
Service
     ↓
Repository
     ↓
MySQL Database
```

---

## 📂 Project Structure

```
src
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── exception
├── repository
└── service
```

---

## 📌 API Endpoints

| Method | Endpoint |
|---------|----------|
| POST | /api/notes/create |
| GET | /api/notes/getAll |
| GET | /api/notes/getById/{id} |
| PUT | /api/notes/update/{id} |
| DELETE | /api/notes/delete/{id} |
| DELETE | /api/notes/permDelete/{id} |
| GET | /api/notes/search?title={title} |
| GET | /api/notes/getAllPaginated?page={page}&size={size} |
| GET | /api/notes/getAllSorted?sortBy={field} |

---

## 🗄️ Database

**Database:** MySQL

Example table:

```
Note
-----------------------------------------
id
title
content
is_pinned
is_deleted
created_at
updated_at
```

---

## ▶️ How to Run

1. Clone the repository

```bash
git clone <repository-url>
```

2. Create a MySQL database named:

```
notes_db
```

3. Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/notes_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

4. Run the Spring Boot application.

5. Test the APIs using Postman.

---

## 📌 Future Enhancements

- JWT Authentication
- Spring Security
- Swagger/OpenAPI
- Docker
- Unit Testing
- Role-Based Authorization

---

## 👨‍💻 Author

**Utkarsa**
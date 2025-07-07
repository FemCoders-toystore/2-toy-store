# 🧸 Toy Store - E-Commerce Backend

This project is the backend of a toy store, developed using **Java 21** and **Spring Boot**, following good architectural practices, validations, error handling, and proper documentation.

---

## 🎯 Objective

Build a RESTful API to manage users, products, categories, and shopping carts in a robust and secure way, applying SOLID, KISS, and DRY principles.

---

## ⚙️ Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Jakarta Validation
- Lombok (optional)
- JUnit (Testing)
- Maven
- Git & GitHub

---

## 🗄️ Layered Architecture

```
com.foreign.team.toy.store
├── controller      # REST Controllers
├── service         # Business Logic
├── repository      # Data Access Layer
├── model           # JPA Entities
├── dto             # Request/Response DTOs
├── mapper          # DTO ↔ Entity Mappers
└── exception       # Custom Exception Handling
```

---

## 🧩 Main Endpoints

| Resource   | Description                    | Path                  |
|------------|---------------------------------|-----------------------|
| Users      | Manage users                   | `/api/users`          |
| Products   | Manage products                | `/api/products`       |
| Categories | Manage categories              | `/api/categories`     |
| Carts      | Manage shopping carts          | `/api/carts`          |

![alt text](image.png)
---

## 🛡️ Validations & Error Handling

- Input validation using Jakarta Validation annotations.
- Centralized error handling with custom exception handlers.
- Security best practices for endpoints (to be implemented).

## 🗃️ Git Version Control Strategy (Simplified Git Flow)

- `main`: Main production branch (final deliveries).
- `developer`: General development.
- `feature/*`: New features.
- `bugfix/*`: Minor fixes.
- `hotfix/*`: Urgent production fixes.
- `release/*`: Version preparation.

---

## 🚀 How to Run the Project

1. Clone the repository:

```bash
git clone https://github.com/your-user/2-toy-store.git
```

2. Configure the database in `application.properties`.

3. Run the project:

```bash
mvn spring-boot:run

## 🤝 Development Team

- 👩‍💻 Alexandra - Developer
- 👩‍💻 Mayleris - Developer
- 🧭 Paola - Scrum Master
- 💼 Saba - Product Owner

---

## 💙 Final Notes

This project follows clean code principles, proper documentation, and teamwork using Jira and GitHub.  
All contributions must go through Pull Request review.

---

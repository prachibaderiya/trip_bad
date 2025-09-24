# 🛫 Trip Management System (Spring Boot + Hibernate + MySQL)

A simple **Spring Boot application** for managing trips.  
It supports **CRUD operations, search, filtering, pagination, validation, exception handling, and API documentation**.  

---

## 🚀 Features
- Create, Read, Update, Delete (CRUD) trips  
- Search trips by destination or status  
- Pagination & filtering  
- Input validation  
- Centralized exception handling  
- API documentation with Swagger/OpenAPI  

---

## 🛠️ Tech Stack
- **Java 17+**  
- **Spring Boot 3**  
- **Spring Data JPA (Hibernate)**  
- **MySQL**  
- **Maven**  
- **Swagger (springdoc-openapi)**  

---

## ⚙️ Prerequisites
Make sure you have installed:
- [Java JDK 17+](https://adoptium.net/)  
- [MySQL](https://dev.mysql.com/downloads/)  
- [Maven](https://maven.apache.org/download.cgi) (or use the included `mvnw` wrapper)  
- [VS Code](https://code.visualstudio.com/) with:
  - Extension Pack for Java  
  - Spring Boot Extension Pack  

---

## 📂 Project Structure
project/
├── src/main/java/com/example/project
│ ├── controller/ # REST Controllers
│ ├── entity/ # JPA Entities
│ ├── repository/ # Spring Data JPA Repos
│ ├── service/ # Business Logic
│ └── ProjectApplication.java
├── src/main/resources
│ ├── application.properties
│ └── static/
├── pom.xml
└── README.md


---

## ⚡ Setup & Run

### 1. Clone the repo
```sh
git clone https://github.com/your-username/trip-management.git
cd trip-management

2. Configure database

Create MySQL database:

CREATE DATABASE tripdb;


Update src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/tripdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

3. Run the application

Using Maven:

mvn spring-boot:run


Or build and run:

mvn clean package
java -jar target/project-0.0.1-SNAPSHOT.jar


Or from VS Code:

Open ProjectApplication.java

Click Run | Debug

📖 API Endpoints
Method	Endpoint	Description
GET	/api/trips	Get all trips (with pagination & filtering)
GET	/api/trips/{id}	Get trip by ID
POST	/api/trips	Create a new trip
PUT	/api/trips/{id}	Update trip
DELETE	/api/trips/{id}	Delete trip
📑 API Documentation (Swagger UI)

Once the app is running, visit:
👉 http://localhost:8080/swagger-ui.html

🛡️ Validation & Error Handling

Input validation with Jakarta Validation (JSR 380)

Global exception handling with @ControllerAdvice

🤝 Contributing

Feel free to fork this repo, submit issues, and send pull requests 🙌

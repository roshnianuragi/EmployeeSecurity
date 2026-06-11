Employee Security System (Spring Boot + Spring Security)

Overview

This is a Spring Boot based Employee Management System that demonstrates secure authentication and authorization using Spring Security. The project implements role-based access control (RBAC) where users are categorized as ADMIN and USER. Based on roles, access to APIs and UI pages is restricted.

The system provides both REST APIs and a Thymeleaf-based frontend for managing employee data securely.

---

Key Features

Authentication and Authorization
- Secure login system using Spring Security
- Role-based access control (ADMIN and USER)
- Custom login page implementation
- Logout functionality
- Password encryption using BCrypt

Employee Management System
- Add new employee (public access)
- View all employees (USER and ADMIN)
- Update employee details (USER and ADMIN)
- Delete employee (ADMIN only)

Web Interface (Thymeleaf)
- Login page for authentication
- Dashboard page after login
- Employee listing page
- Admin panel for restricted access

Security Implementation
- Custom UserDetailsService for loading user data from database
- Role-based URL protection using Spring Security configuration
- BCryptPasswordEncoder for secure password storage
- Method-level and endpoint-level security

---

Project Architecture / Structure

The project follows a layered architecture:

Controller Layer
- Handles HTTP requests
- EmployeeController: REST APIs for employee operations
- ViewController: Handles UI pages like login, dashboard, admin panel

Service Layer
- Contains business logic
- EmployeeService: CRUD operations for employees
- CustomUserDetailsService: Loads user details for authentication

Repository Layer
- EmployeeRepository: Extends JpaRepository for database operations

Model Layer
- Employee: Entity class mapped to database table
- Contains fields like id, name, email, password, salary, role, department

Security Layer
- SecurityConfig: Defines security rules, role access, login configuration
- SecurityUser: Implements UserDetails for Spring Security integration

---

System Workflow

1. User opens login page
2. User enters email and password
3. Spring Security intercepts request
4. CustomUserDetailsService loads user from database
5. Password is verified using BCrypt
6. Role is assigned (ADMIN or USER)
7. Based on role, access is granted:
   - ADMIN → full access
   - USER → limited access
8. User accesses dashboard and employee modules

---

API Endpoints

Public Access
- POST /public/add → Add new employee

User and Admin Access
- GET /user/employees → Get all employees
- GET /user/employees/{id} → Get employee by ID
- PUT /user/employees/{id} → Update employee

Admin Only Access
- DELETE /admin/employees/{id} → Delete employee

---

Database Configuration

The project uses MySQL database.

Database Name:
employee_security

Configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/employee_security
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
---

Technologies Used

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- MySQL
- Maven

---

Security Flow Explanation

Spring Security works in the following sequence:

1. Request enters application
2. Security filter chain intercepts request
3. Authentication is performed using database credentials
4. Password is validated using BCrypt
5. Roles are fetched from database
6. Authorization rules are applied based on SecurityConfig
7. Access is granted or denied

---

How to Run the Project

1. Clone the repository from GitHub
2. Create MySQL database named employee_security
3. Update database credentials in application.properties
4. Run the Spring Boot application
5. Open browser and visit:
   http://localhost:8080/login

---

Future Enhancements

- JWT Authentication for stateless security
- Password reset functionality
- Role management UI
- Advanced admin dashboard
- Audit logging system
- React frontend integration

---

Author

Roshni Anuragi  
B.Tech Graduate | Java Developer

---

Conclusion

This project demonstrates a real-world implementation of Spring Security with role-based access control, authentication, and authorization. It shows how enterprise-level security can be implemented in a Spring Boot application with a clean layered architecture.

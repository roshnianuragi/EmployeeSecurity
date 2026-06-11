# EMPLOYEE SECURITY SYSTEM  
## Spring Boot + Spring Security (RBAC Implementation)

---

## Overview

Employee Security System is a Spring Boot based enterprise-level application designed to demonstrate secure authentication and authorization using Spring Security.

The system implements Role-Based Access Control (RBAC), where users are categorized into ADMIN and USER roles. Based on these roles, access to APIs and UI pages is restricted.

The application provides both REST APIs and a Thymeleaf-based frontend for managing employee data securely in a structured and protected environment.

This project focuses on real-world security implementation, layered architecture, and proper separation of concerns.

---

## Core Concept (Theory)

This project is built on the concept of Spring Security, which is a powerful authentication and authorization framework in Spring Boot.

### Authentication
Authentication is the process of verifying the identity of a user using email and password stored in the database.

### Authorization
Authorization determines what actions a user is allowed to perform based on their assigned role (ADMIN or USER).

### Role-Based Access Control (RBAC)
RBAC ensures that:
- ADMIN users have full access to system operations
- USER roles have limited access to view and update data only

---

## Key Features

### Authentication and Authorization
- Secure login system using Spring Security
- Custom login page implementation
- Logout functionality
- Password encryption using BCryptPasswordEncoder
- Database-based authentication using UserDetailsService

### Role-Based Access Control
- ADMIN role: Full system access including delete operations
- USER role: Limited access to view and update data
- URL-level security configuration

### Employee Management System
- Add new employee (public access)
- View all employees (USER + ADMIN)
- Update employee details (USER + ADMIN)
- Delete employee (ADMIN only)

### Web Interface (Thymeleaf)
- Login page for authentication
- Dashboard after login
- Employee listing page
- Admin control panel

---

## Project Architecture (Layered Structure)

The project follows a standard 4-layer architecture:

### 1. Controller Layer
Responsible for handling HTTP requests and responses.

- EmployeeController → REST APIs for employee operations
- ViewController → Handles UI pages like login, dashboard, admin panel

---

### 2. Service Layer
Contains business logic and processing rules.

- EmployeeService → Handles CRUD operations for Employee
- CustomUserDetailsService → Loads user details for Spring Security authentication

---

### 3. Repository Layer
Handles database communication.

- EmployeeRepository → Extends JpaRepository for database operations

---

### 4. Model Layer
Represents database structure.

- Employee Entity:
  - id
  - name
  - email
  - password
  - salary
  - role
  - departmentName

---

### 5. Security Layer
Handles authentication and authorization logic.

- SecurityConfig → Defines security rules and access permissions
- SecurityUser → Implements UserDetails for Spring Security integration

---

## System Workflow

1. User opens login page
2. User enters email and password
3. Request is intercepted by Spring Security filter chain
4. CustomUserDetailsService fetches user data from database
5. Password is validated using BCrypt
6. Role is assigned (ADMIN or USER)
7. Access control is applied based on role
8. User accesses allowed pages and APIs

---

## API Endpoints

### Public Access
- POST /public/add → Add new employee

### User and Admin Access
- GET /user/employees → Fetch all employees
- GET /user/employees/{id} → Fetch employee by ID
- PUT /user/employees/{id} → Update employee

### Admin Only Access
- DELETE /admin/employees/{id} → Delete employee

---

## Database Configuration

The project uses MySQL database for data persistence.

### Database Name
employee_security

### Configuration

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_security
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update

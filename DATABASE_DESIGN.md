# Student ID Card Issuing System - System Design

## 1. Introduction

This document describes the architecture and design of the Student ID Card Issuing System.

The system follows a three-layer architecture:

* Frontend Layer
* Backend Layer
* Database Layer

The frontend communicates with the backend through REST APIs. The backend handles business logic, security, and database operations.

---

# 2. System Architecture

```text
                    Student / Registrar

                            |
                            |
                            v

                    Vue 3 Frontend

                            |
                            |
                         Axios

                            |
                            |
                            v

                  Spring Boot Backend

                            |
                            |
                         JPA/Hibernate

                            |
                            |
                            v

                       MariaDB Database
```

---

# 3. Architecture Layers

## 3.1 Frontend Layer

Technology:

* Vue 3
* Vite
* Vue Router
* Pinia
* Axios

Responsibilities:

* Display user interface
* Handle user input
* Validate forms
* Manage application state
* Communicate with backend APIs

---

## 3.2 Backend Layer

Technology:

* Java
* Spring Boot
* Spring Data JPA
* Spring Security

Responsibilities:

* Process business logic
* Validate requests
* Manage authentication
* Generate OTP
* Handle file uploads
* Generate PDF documents
* Communicate with database

---

## 3.3 Database Layer

Technology:

* MariaDB

Responsibilities:

* Store student data
* Store administrator data
* Store OTP information
* Maintain relationships

---

# 4. Backend Architecture

The backend follows a layered architecture.

```text
Controller

    |
    v

Service

    |
    v

Repository

    |
    v

Database
```

---

# 5. Backend Components

## Controller Layer

Purpose:

Handles HTTP requests.

Examples:

* StudentController
* AdminController
* OTPController

Responsibilities:

* Receive requests
* Return responses
* Validate request data

---

## Service Layer

Purpose:

Contains business logic.

Responsibilities:

* Student operations
* OTP verification
* PDF generation
* File processing

---

## Repository Layer

Purpose:

Database communication.

Technology:

* Spring Data JPA

Responsibilities:

* Save data
* Retrieve data
* Update records
* Delete records

---

## Entity Layer

Represents database tables.

Examples:

```text
Student

Admin

OTP
```

---

# 6. Frontend Architecture

Vue application structure:

```text
src/

├── components/
│
├── views/
│
├── router/
│
├── stores/
│
├── services/
│
├── assets/
│
├── App.vue
│
└── main.js
```

---

# 7. User Flow Design

## Registrar Flow

```text
Login

↓

Dashboard

↓

Create Student

↓

Generate OTP

↓

Give OTP to Student
```

---

## Student Flow

```text
Enter Student ID

↓

Enter OTP

↓

Verify Identity

↓

Upload Photo

↓

Preview ID Card

↓

Generate PDF

↓

Download
```

---

# 8. Module Design

## Authentication Module

Handles:

* Admin login
* User verification
* Session management

---

## Student Management Module

Handles:

* Create students
* Update students
* Delete students
* Search students

---

## OTP Module

Handles:

* OTP generation
* OTP validation
* Expiration checking
* One-time usage

---

## Photo Module

Handles:

* Image upload
* Image validation
* Storage management

---

## PDF Module

Handles:

* ID card template
* Student information insertion
* PDF generation

---

# 9. API Communication Flow

Example:

Student verifies OTP:

```text
Vue Component

      |
      |
POST /api/student/verify

      |
      v

Spring Boot Controller

      |
      v

OTP Service

      |
      v

Database Check

      |
      v

Response to Vue
```

---

# 10. Data Flow

```text
User Input

↓

Vue Form

↓

Axios Request

↓

Spring Controller

↓

Service Logic

↓

Repository

↓

MariaDB

↓

Response

↓

Vue Update
```

---

# 11. Deployment Architecture (Future)

```text
                User Browser

                     |

                     v

              Frontend Server

                     |

                     v

             Backend Server

                     |

                     v

              Database Server
```

---

# 12. Design Principles

The project follows:

* Separation of concerns
* Layered architecture
* REST API design
* Secure data handling
* Maintainable code structure
* Scalable application design

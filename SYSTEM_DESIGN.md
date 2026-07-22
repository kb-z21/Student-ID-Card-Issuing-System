# Student ID Card Issuing System - System Design

## 1. System Overview

The Student ID Card Issuing System is a full-stack web application designed to securely issue digital student ID cards.

The system follows a three-layer architecture:

* Frontend Layer
* Backend Layer
* Database Layer

The application uses OTP-based verification to ensure that only authorized students can generate their official ID cards.

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
                    Axios HTTP

                         |
                         v

              Spring Boot Backend

                         |
                         |
                    JPA / Hibernate

                         |
                         v

                  MariaDB Database
```

---

# 3. Application Layers

## 3.1 Frontend Layer

Technology:

* Vue 3
* Vite
* Vue Router
* Pinia
* Axios

Responsibilities:

* Display user interfaces
* Handle user input
* Validate forms
* Upload student photos
* Communicate with backend APIs
* Display generated ID cards

---

## 3.2 Backend Layer

Technology:

* Java
* Spring Boot
* Spring Data JPA
* Spring Security

Responsibilities:

* Process business logic
* Authenticate users
* Validate OTP
* Manage students
* Generate PDF documents
* Handle file uploads
* Communicate with database

---

## 3.3 Database Layer

Technology:

* MariaDB

Responsibilities:

* Store student information
* Store administrator information
* Store OTP records
* Store system data

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

# 5. Backend Package Structure

```text
backend/

src/main/java/

com.example.studentid

├── controller
│
├── service
│
├── repository
│
├── entity
│
├── dto
│
├── security
│
├── exception
│
└── config
```

---

# 6. Frontend Architecture

Vue follows a component-based architecture.

```text
App.vue

    |
    |
    +-- Router

          |
          |
          +-- Views

                |
                |
                +-- Components
```

---

# 7. Frontend Structure

```text
frontend/

src/

├── assets

├── components

│   ├── Navbar.vue
│   ├── StudentForm.vue
│   ├── PhotoUpload.vue
│   └── IDPreview.vue

├── views

│   ├── Login.vue
│   ├── Dashboard.vue
│   ├── VerifyOTP.vue
│   └── StudentID.vue

├── router

├── stores

├── services

├── App.vue

└── main.js
```

---

# 8. System Workflow Design

## Registrar Workflow

```text
Login

  |

Dashboard

  |

Register Student

  |

Generate OTP

  |

Give OTP to Student
```

---

## Student Workflow

```text
Enter Student ID

        |

Enter OTP

        |

Verify OTP

        |

Upload Photo

        |

Preview ID Card

        |

Generate PDF

        |

Download
```

---

# 9. OTP Verification Flow

```text
Student

 |

 | Student ID + OTP

 v

Backend Controller

 |

 v

OTP Service

 |

 v

Database Check

 |

 +----------------+

 |                |

Valid          Invalid

 |                |

 v                v

Continue       Error

```

---

# 10. PDF Generation Flow

```text
Student Request

        |

Backend receives request

        |

Load student information

        |

Load student photo

        |

Create PDF template

        |

Generate ID Card PDF

        |

Return file to student
```

---

# 11. Communication Between Components

## Frontend to Backend

Protocol:

```
HTTP/HTTPS
```

Data format:

```
JSON
```

Example:

```json
{
  "studentId": "UGR/1234/25",
  "otp": "482913"
}
```

---

# 12. Security Architecture

Security controls:

* Admin authentication
* Password hashing
* OTP expiration
* OTP one-time usage
* Input validation
* File validation
* API authorization

---

# 13. Design Principles

The system follows:

* Separation of concerns
* Layered architecture
* REST API principles
* Component-based frontend design
* Secure data handling
* Maintainable code structure

---

# 14. Future Architecture Improvements

Possible improvements:

* JWT authentication
* Role-Based Access Control (RBAC)
* QR code verification
* Digital signatures
* PKI-based student identity verification
* Cloud deployment

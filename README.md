# Student ID Card Issuing System

A secure web-based system for issuing university student ID cards digitally.

The system allows the registrar to register students and generate one-time verification codes (OTP). Students use the OTP provided by the registrar in person to verify their identity, upload their own photo, preview their ID card, and download a generated PDF student ID card.

---

# Project Overview

Many universities still use manual processes for student ID card preparation. This project provides a digital solution that improves security, reduces manual work, and provides students with a faster way to obtain their official ID cards.

The system separates responsibilities between the registrar and students:

* The registrar manages student information and generates OTP codes.
* Students verify their identity and provide their own photo.
* The system generates the official PDF ID card.

---

# System Workflow

```
Registrar

    |
    |
Register Student
    |
Generate OTP
    |
Give OTP to Student


Student

    |
Enter Student ID + OTP
    |
Verify Identity
    |
Upload Photo
    |
Preview ID Card
    |
Generate PDF
    |
Download ID Card
```

---

# Features

## Registrar Features

* Secure login
* Register students
* Update student information
* Delete student records
* Generate OTP codes
* Manage student verification status

---

## Student Features

* Verify using Student ID and OTP
* Upload personal photo
* Preview ID card
* Generate PDF ID card
* Download ID card

---

# Security Features

* One-time OTP verification
* OTP expiration
* Password hashing
* Role-based access control
* File upload validation
* Input validation
* Secure API communication

---

# Technology Stack

## Frontend

* Vue 3
* Vite
* Vue Router
* Pinia
* Axios
* HTML5
* CSS3

## Backend

* Java
* Spring Boot
* Spring Data JPA
* Spring Validation
* Spring Security

## Database

* MariaDB

## Development Tools

* IntelliJ IDEA
* Visual Studio Code
* Git
* GitHub
* Postman

---

# System Architecture

```
                Vue 3 Frontend

                      |

                    Axios

                      |

                      v

              Spring Boot Backend

                      |

                      v

                 MariaDB Database
```

---

# Project Structure

```
student-id-card-system/

├── README.md
├── PROJECT_PLAN.md
├── REQUIREMENTS.md
├── SYSTEM_DESIGN.md
├── DATABASE_DESIGN.md
├── UI_UX.md
├── SECURITY.md
├── LICENSE
│
├── docs/
│
├── backend/
│
└── frontend/
```

---

# Backend Structure

```
backend/

src/main/java/

├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── exception
└── config
```

---

# Frontend Structure

```
frontend/

src/

├── components
├── views
├── router
├── stores
├── services
├── assets
├── App.vue
└── main.js
```

---

# Installation

## Backend

Requirements:

* Java 25 or higher
* Maven
* MariaDB

Run:

```
cd backend

mvn spring-boot:run
```

---

## Frontend

Requirements:

* Node.js
* npm

Install dependencies:

```
cd frontend

npm install
```

Start development server:

```
npm run dev
```

---

# Future Improvements

* JWT authentication
* Role-based permissions
* QR code verification
* Digital signatures
* Mobile application
* Integration with university systems

---

# Learning Goals

This project demonstrates:

* Full-stack application development
* Vue frontend development
* Spring Boot REST API development
* Database design
* Secure identity verification
* File upload handling
* PDF generation
* Software architecture

---

# License

This project is licensed under the MIT License.

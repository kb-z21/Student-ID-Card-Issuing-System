# Student ID Card Issuing System - Security Design

## 1. Introduction

This document describes the security design and protection mechanisms used in the Student ID Card Issuing System.

The system handles sensitive information including:

* Student personal information
* Student photos
* Administrator accounts
* OTP verification data
* Generated ID cards

Security is implemented through authentication, authorization, validation, and secure data handling.

---

# 2. Security Objectives

The system aims to provide:

* Confidentiality of student data
* Integrity of student information
* Secure identity verification
* Protection against unauthorized access
* Secure file handling

---

# 3. User Roles and Permissions

## Registrar (Administrator)

Permissions:

* Login to dashboard
* Register students
* Update student information
* Generate OTP codes
* Manage student records

Restrictions:

* Cannot impersonate students
* Cannot access unauthorized system functions

---

## Student

Permissions:

* Verify identity using Student ID and OTP
* Upload personal photo
* Preview ID card
* Download own ID card

Restrictions:

* Cannot modify official information
* Cannot access other students' data
* Cannot generate OTP codes

---

# 4. Authentication Security

## Administrator Authentication

The system uses secure authentication for registrar accounts.

Security measures:

* Password hashing
* Secure login process
* Session protection

Passwords are never stored as plain text.

Example:

```
Plain password:

admin123


Stored:

$2a$10$encrypted_password
```

Technology:

* BCrypt password hashing

---

# 5. OTP Security

OTP is used to verify student identity.

## OTP Rules

```
Length:
6 digits

Expiration:
10 minutes

Usage:
One-time only
```

---

## OTP Workflow

```
Registrar

    |
    |
Generate OTP

    |
    v

Database Storage

    |
    v

Student Enters OTP

    |
    v

Backend Validation

    |
    v

OTP Marked Used
```

---

## OTP Protection

The system prevents:

* OTP reuse
* Expired OTP usage
* Unlimited verification attempts

---

# 6. File Upload Security

Students upload their own photos.

The system validates:

## File Type

Allowed:

```
.jpg
.jpeg
.png
```

Rejected:

```
.exe
.sh
.jsp
```

---

## File Size

The system limits uploaded file size to prevent:

* Storage abuse
* Denial of service attacks

---

## File Name Security

Uploaded file names are sanitized.

Example:

Unsafe:

```
../../virus.jpg
```

Safe:

```
student_123_photo.jpg
```

---

# 7. API Security

The backend protects APIs using:

* Authentication
* Authorization
* Input validation
* Exception handling

Request flow:

```
Vue Application

        |

       Axios

        |

 Spring Security

        |

 Controller

        |

 Service

        |

 Database
```

---

# 8. Database Security

Security measures:

* Use prepared queries through JPA
* Restrict database access
* Validate data before storage
* Protect sensitive information

Protection against:

* SQL injection
* Invalid data insertion

---

# 9. Input Validation

All user input must be validated.

Examples:

Student ID:

```
Must follow university format
```

Email:

```
Must be valid email format
```

Photo:

```
Must be an accepted image format
```

---

# 10. Authorization

Users can only access resources allowed by their role.

Example:

Student:

```
GET /api/student/profile
```

Allowed.

Student:

```
DELETE /api/admin/students/10
```

Denied.

---

# 11. Logging and Monitoring

The system should record important events:

* Login attempts
* Failed OTP attempts
* Student registration
* OTP generation
* PDF generation

Example:

```
2026-07-22 10:00

Registrar generated OTP

Student ID:
UGR/1234/25
```

---

# 12. Data Protection

Sensitive data protection includes:

* Secure password storage
* Controlled database access
* Secure API communication
* Proper error handling

---

# 13. Future Security Improvements

Future versions may include:

* JWT authentication
* Role-Based Access Control (RBAC)
* HTTPS deployment
* QR code verification
* Digital signatures
* Certificate-based authentication
* PKI integration

---

# 14. Security Development Principles

The project follows:

* Least privilege principle
* Secure by design
* Defense in depth
* Input validation
* Separation of responsibilities
* Regular testing

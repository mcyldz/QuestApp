# QuestApp
QuestApp is a backend only application built with Java and the Spring Framework, designed to support essential social interaction features. It enables user management, post creation, commenting on posts, and liking posts. The backend handles data management and processes user interactions efficiently.

## Technologies Used

- Java
- Spring Framework
- Spring Boot
- Hibernate
- MySQL

## Table of Contents

- [Technologies Used](#technologies-used)
- [Features](#features)
- [API Endpoints](#api-endpoints)
  - [User Management](#user-management)
  - [Post Management](#post-management)
  - [Comment Management](#comment-management)
  - [Like Management](#like-management)
- [Database Configuration](#database-configuration)

## Features

- User registration and authentication
- Create, read, update, and delete (CRUD) operations for posts and comments
- Like functionality for posts
- Comprehensive API for user, post, comment, and like management

## API Endpoints

### User Management
- `GET /rest/api/users`: List all users
- `GET /rest/api/users/{id}`: Retrieve a specific user by ID
- `GET /rest/api/activity/{userId}`: Activities a user
- `POST /rest/api/users`: Create a new user
- `PUT /rest/api/users/{id}`: Update user information
- `DELETE /rest/api/users/{id}`: Delete a user

### Post Management
- `GET /rest/api/posts`: List all posts
- `GET /rest/api/posts/{id}`: Retrieve a specific post by ID
- `POST /rest/api/posts`: Create a new post
- `PUT /rest/api/posts/{id}`: Update a post by ID
- `DELETE /rest/api/posts/{id}`: Delete a post

![get_posts](https://github.com/user-attachments/assets/cdc028aa-bf55-49e0-886a-35f783744480)

![put_post](https://github.com/user-attachments/assets/3dc30e32-0772-463c-968e-e1383707b26f)

### Comment Management
- `GET /rest/api/comments`: List all comments
- `GET /rest/api/comments/{postId}`: List comments for a specific post
- `GET /rest/api/comments/{userId}`: List comments for a specific user
- `GET /rest/api/comments/{id}`: Retrieve a specific comment by ID
- `POST /rest/api/comments`: Add a comment to a post
- `PUT /rest/api/comments/{id}`: Update a comment
- `DELETE /rest/api/comments/{id}`: Delete a comment

![post_comment](https://github.com/user-attachments/assets/011eaadb-8c41-4596-aac6-39e82a89440a)


### Like Management
- `GET /rest/api/likes`: List all likes for a specific post
- `GET /rest/api/{userId}`: List likes for a specific user
- `GET /rest/api/{postId}`: List likes for a specific post
- `POST /rest/api/likes`: Like a post
- `DELETE /rest/api/likes/{id}`: Remove a like from a post

### Database Configuration
This project uses MySQL as the database. To configure the database, follow these steps:

1. Install MySQL and create a database:
```sql
  CREATE DATABASE QuestApp;
```
2. Configure the connection settings in application.properties:
```
spring.application.name=APPLICATION_NAME

spring.datasource.url=jdbc:mysql://localhost:3306/DATABASE_NAME?useSSL=false
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD

spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=create
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```


   

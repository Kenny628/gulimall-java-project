Project created date: 2/5/2024
Project GitHub pubish date: 11/5/2024
Project Completed Date: 25/7/2024

# Gulimall

Gulimall is a comprehensive e-commerce platform that provides a full suite of features for online shopping, including product management, order management, payment integration, and more.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#Prerequisites)

## Features

- **User Authentication**: Secure login and registration. (manual registration and social login)
- **Order Management**: Handle customer orders efficiently. (rabbitMQ for order release)
- **Stock Management**: Real-time stock updates and inventory management. (rabbitMQ for stock release)
- **Payment Integration**: Support for multiple payment gateways.
- **Cart Management**: Add, remove, and update cart items. (using redis)
- **Search Functionality**: Advanced product search.
- **Messaging**: RabbitMQ for order release and stock release processes.
  
## Tech Stack

- **Backend**: Spring Boot, Spring Cloud
- **Frontend**: Thymeleaf
- **Database**: MySQL
- **Caching**: Redis
- **Messaging**: RabbitMQ
- **API Gateway**: Spring Cloud Alibaba Nacos

## Prerequisites

- Java 11 or higher
- Node.js and npm
- MySQL
- Redis
- RabbitMQ
- Nginx
- SwitchHost
  
### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/gulimall.git
   cd gulimall

## Website Page Demonstration

Authentication page
![image](https://github.com/user-attachments/assets/f86c6285-fea3-4334-976c-56180877d5c8)

Index Page
![Example Image](https://github.com/Kenny628/gulimall-java-project/blob/main/image/index.png)
Item Page
![image](https://github.com/user-attachments/assets/65d289dc-a61e-4449-a8b9-79229928cbf9)

Added to cart Page
![image](https://github.com/user-attachments/assets/b9f1df95-f8ba-4a72-96a5-40245aada7fb)

Cart Page
![image](https://github.com/user-attachments/assets/c0bf85a2-80e9-4347-9efa-de45a9f43988)

Order Confirm Page
![image](https://github.com/user-attachments/assets/cdf03e05-fc11-4e0a-ab9b-168c22b15f07)



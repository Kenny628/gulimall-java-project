Project created date: 2/5/2024

Project GitHub pubish date: 11/5/2024

Project Completed Date: 25/7/2024

# Gulimall

Gulimall is a comprehensive e-commerce platform that provides a full suite of features for online shopping, including product management, order management, payment integration, and more.

### - Project Mainly Reference: 

https://www.bilibili.com/video/BV1np4y1C7Yf?p=1&vd_source=dca62522f5d6a264390429dc3ab85818

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#Prerequisites)
- [Website Page Demonstration](#website-page-demonstration)
## Main Features

- **User Authentication**: Secure login and registration. (manual registration and social login)
- **Order Management**: Handle customer orders efficiently. (rabbitMQ for order release, redis for token management)
- **Stock Management**: Real-time stock updates and inventory management. (rabbitMQ for stock release)
- **Payment Integration**: Support for multiple payment gateways.
- **Cart Management**: Add, remove, and update cart items. (using redis)
- **Search Functionality**: Advanced product search.
- **Category Navigation**: Easy navigation through product categories. (using redis caching)
- **Payment Success Callback**: Ensure the oder status updated just after payment.
## Tech Stack

- **Backend**: Spring Boot, Spring Cloud
- **Frontend**: Thymeleaf
- **Database**: MySQL
- **Caching**: Redis
- **Messaging**: RabbitMQ
- **API Gateway**: Spring Cloud Alibaba Nacos
- **Web Server**: nginx
- **Reverse Proxy**: nginx, ngrok
  
## Prerequisites

- Java 17 or higher
- MySQL
- Redis
- RabbitMQ
- Nginx
- SwitchHost

## Website Page Demonstration

Authentication page

![image](https://github.com/user-attachments/assets/f86c6285-fea3-4334-976c-56180877d5c8)

Index Page

![Example Image](https://github.com/Kenny628/gulimall-java-project/blob/main/image/index.png)

Search Page

![image](https://github.com/user-attachments/assets/3485a09e-7fd5-45a3-85c8-c0f5db0f11a0)

Item Page

![image](https://github.com/user-attachments/assets/65d289dc-a61e-4449-a8b9-79229928cbf9)

Added to cart Page

![image](https://github.com/user-attachments/assets/b9f1df95-f8ba-4a72-96a5-40245aada7fb)

Cart Page

![image](https://github.com/user-attachments/assets/c0bf85a2-80e9-4347-9efa-de45a9f43988)

Order Confirm Page

![image](https://github.com/user-attachments/assets/aa9aa2ad-4657-424d-90d2-6ce73016dd98)

Payment page

![image](https://github.com/user-attachments/assets/b06c1d42-ae57-4ed9-b3e0-ae9f77ae9456)

Stripe payment checkout page

![image](https://github.com/user-attachments/assets/50732c49-a2bf-467a-bef3-2bb24a8c5817)

Order Details Page

![image](https://github.com/user-attachments/assets/fdc7c310-0e7e-495d-be9a-7a88012e5c7c)





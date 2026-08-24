# Spring Security Demo


## Environment

- Java 17
- Spring Boot 3.2.0


## Login API


POST

/login


Request:

{
    "username":"test",
    "password":"123456"
}



Response:

JWT Token



## HelloWorld API


GET

/hello


Header:

Authorization: Bearer token



Response:

Hello World

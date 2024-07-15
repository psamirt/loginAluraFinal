# Nombre del Proyecto

Autenticación con Spring Boot y JWT

## Descripción

Este proyecto demuestra cómo implementar la autenticación basada en tokens JWT (JSON Web Tokens) en una aplicación Spring Boot. Los usuarios pueden iniciar sesión proporcionando sus credenciales (correo electrónico y contraseña) y recibirán un token válido para acceder a recursos protegidos.

## Tecnologías Utilizadas

- Spring Boot
- Java
- JWT (JSON Web Tokens)
- Base de datos (por ejemplo, MySQL, PostgreSQL)
- Maven (para la gestión de dependencias)

## Instalación

1. Clona este repositorio.
2. Configura tu base de datos (si es necesario).
3. Ejecuta el proyecto utilizando `mvn spring-boot:run` o desde tu IDE favorito.

## Cómo Usar

1. Abre Postman o cualquier cliente HTTP.
2. Realiza una solicitud POST a la siguiente URL: `http://localhost:8080/login`.
3. En el cuerpo de la solicitud, envía las credenciales de prueba:
   ```json
   {
       "email": "prueba@prueba.com",
       "password": "prueba"
   }

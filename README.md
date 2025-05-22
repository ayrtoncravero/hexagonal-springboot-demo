# Proyecto Hexagonal con Spring Boot

Este proyecto es un ejemplo básico para aprender y practicar la arquitectura hexagonal utilizando Spring Boot.

## Descripción

El objetivo es entender cómo implementar una aplicación Java con Spring Boot siguiendo los principios de la arquitectura hexagonal (Ports and Adapters).  
Incluye funcionalidades básicas para la gestión de productos:
- Creación de productos (POST)
- Listado de productos (GET)

## Tecnologías

- Java 23
- Spring Boot 3.4.5
- Maven
- MySQL (para persistencia)
- Arquitectura Hexagonal

## Cómo usarlo

1. Clona el repositorio
2. Configura las variables de entorno en el archivo `application.properties` o usando variables de sistema para la conexión a la base de datos
3. Ejecuta el proyecto con Maven:
   ```bash
   mvn spring-boot:run

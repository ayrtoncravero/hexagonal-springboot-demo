# Proyecto Hexagonal con Spring Boot

> ⚠️ **Este proyecto está en desarrollo y no está terminado.**  
> Algunas funcionalidades pueden no estar completas o ser inestables.  
> Se acepta feedback y contribuciones para mejorarlo.

Este proyecto es un ejemplo básico para aprender y practicar la arquitectura hexagonal utilizando Spring Boot.

## Descripción

El objetivo es entender cómo implementar una aplicación Java con Spring Boot siguiendo los principios de la arquitectura hexagonal (Ports and Adapters).  
Incluye funcionalidades básicas para la gestión de productos:
- Obtener todos los productos (GET)
- Creación de productos (POST)
- Listado de productos (GET)
- Actualización de productos (PUT)
- Eliminación de productos (DELETE)

## Tecnologías

- Java 17
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

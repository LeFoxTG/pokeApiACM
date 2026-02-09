# PokeApiACM - Spring Boot Consumer

![Java 17](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.4-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

## Imagenes
![Index](https://ibb.co/qVzbRnx)
![Result](https://ibb.co/674W2k8L)

## Descripción del Proyecto

**PokeApiACM** es una aplicación web desarrollada con **Spring Boot MVC** que actúa como cliente para consumir la [PokéAPI](https://pokeapi.co/).

El proyecto fue diseñado como una práctica para el grupo de trabajo **ACM WEBDEV**, demostrando cómo integrar servicios externos, mapear datos JSON complejos y presentarlos en una interfaz web utilizando renderizado del lado del servidor (SSR).

### Características Técnicas Destacadas

* **Cliente HTTP Moderno:** Implementación de `java.net.http.HttpClient` (nativo de Java 11+) configurado como Bean de Spring para realizar peticiones asíncronas y eficientes.
* **Java Records:** Uso de `record` para los DTOs (Data Transfer Objects), garantizando inmutabilidad y reduciendo el "boilerplate code".
* **Mapeo JSON:** Integración con **GSON** para la serialización y deserialización de datos externos.
* **Arquitectura Limpia:** Separación clara entre Modelos Internos (Lombok) y Modelos de API Externa (Records).
* **Frontend Integrado:** Vistas construidas con **Thymeleaf** para renderizado dinámico de atributos HTML.

## Stack Tecnológico

* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3.3.4 (Starter Web, Thymeleaf)
* **Gestión de Datos:** Lombok, GSON 2.10
* **Build Tool:** Maven
* **Cliente API:** Java HttpClient (Standard Library)

## Arquitectura y Flujo

El proyecto sigue el patrón MVC (Modelo-Vista-Controlador):

```mermaid
graph LR
    User(Usuario) -->|GET /consult| Controller[IndexController]
    Controller -->|Solicita Vista| View1[index.html]
    
    User -->|GET /consulted?name=ditto| Controller
    Controller -->|Llama| Service[PokeService]
    Service -->|HTTP Request| PokeAPI[External PokéAPI]
    PokeAPI -->|JSON| Service
    Service -->|Retorna DTO| Controller
    Controller -->|Inyecta Datos| View2[pokeView.html]
    View2 -->|HTML Renderizado| User
```

Hecho con ❤️ por FoxTG

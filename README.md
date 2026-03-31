# FollowUp Backend

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.5-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15+-336791?style=for-the-badge&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

Plataforma backend escalable para gestión de gimnasios y usuarios, construida con arquitectura hexagonal y Domain-Driven Design (DDD).

## 📋 Tabla de Contenidos

- [Descripción del Proyecto](#descripción-del-proyecto)
- [Arquitectura](#arquitectura)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Estructura de Directorios](#estructura-de-directorios)
- [Módulos](#módulos)
- [Requisitos del Sistema](#requisitos-del-sistema)
- [Instalación y Configuración](#instalación-y-configuración)
- [Comandos de Ejecución](#comandos-de-ejecución)
- [Documentación de API](#documentación-de-api)
- [Seguridad](#seguridad)
- [Variables de Entorno](#variables-de-entorno)
- [Desarrollo](#desarrollo)

---

## Descripción del Proyecto

**FollowUp Backend** es una solución empresarial para la gestión integral de gimnasios y sus usuarios. Proporciona APIs REST robustas y escalables para operaciones de CRUD, manejo seguro de datos y validaciones de dominio.

**Características principales:**
- ✅ Gestión de gimnasios con información de contacto y seguridad
- ✅ Gestión de usuarios con control de membresía y estado
- ✅ Arquitectura modular y escalable
- ✅ Seguridad integrada con Spring Security
- ✅ Documentación OpenAPI/Swagger automática
- ✅ Persistencia con JPA/Hibernate
- ✅ Auditoría de datos con JPA Auditing

---

## Arquitectura

### Patrón Hexagonal (Ports & Adapters)

El proyecto implementa la arquitectura hexagonal dividiendo el código en tres capas principales:

```
┌─────────────────────────────────────────────┐
│         INFRASTRUCTURE LAYER                │
│  (Adapters: Controllers, Persistence, DTOs) │
├─────────────────────────────────────────────┤
│         APPLICATION LAYER                   │
│  (Use Cases, Services)                      │
├─────────────────────────────────────────────┤
│         DOMAIN LAYER                        │
│  (Models, Value Objects, Repositories)      │
└─────────────────────────────────────────────┘
```

### Flujo de Datos

```
HTTP Request
    ↓
GymController / UserController
    ↓
GymService / UserService
    ↓
Use Cases (GymSaveUseCase, GymFindByIdUseCase, etc.)
    ↓
Domain Models & Repository Abstractions
    ↓
JPA Repositories (Persistence)
    ↓
PostgreSQL Database
```

### Principios de Diseño

- **Domain-Driven Design (DDD)**: Lógica de negocio encapsulada en la capa de dominio
- **Inyección de Dependencias**: Desacoplamiento total entre capas
- **Separación de Responsabilidades**: Cada componente tiene una única responsabilidad
- **Value Objects**: Representación de conceptos del dominio como objetos inmutables
- **Repository Pattern**: Abstracción del acceso a datos

---

## Tecnologías Utilizadas

### Framework y Plataforma
- **Java 21** - LTS, última versión con features modernas
- **Spring Boot 4.0.5** - Framework web y aplicaciones empresariales
- **Spring Modulith 2.0.3** - Arquitectura modular y gestión de módulos
- **Spring Security** - Autenticación y autorización
- **Spring Data JPA** - Abstracción de persistencia

### Base de Datos
- **PostgreSQL 15+** - Base de datos relacional
- **Hibernate** - ORM (Object-Relational Mapping)
- **H2 Database** - Base de datos en memoria para testing

### Utilidades y Herramientas
- **Lombok** - Reducción de código boilerplate
- **SpringDoc OpenAPI 3.0.2** - Documentación API automática (Swagger)
- **Maven 3.8+** - Gestor de dependencias y construcción
- **JUnit 5 (Jupiter)** - Framework de testing

### Dependencias Principales

```xml
<!-- Spring Boot Starters -->
spring-boot-starter-data-jpa
spring-boot-starter-security
spring-boot-starter-webmvc
spring-boot-devtools (dev)

<!-- Spring Modulith -->
spring-modulith-starter-core
spring-modulith-starter-jpa
spring-modulith-starter-test

<!-- Utilidades -->
lombok
springdoc-openapi-starter-webmvc-ui (v3.0.2)

<!-- Base de Datos -->
postgresql
```

---

## Estructura de Directorios

```
FollowUpBackend/
├── src/
│   ├── main/
│   │   ├── java/com/x86/followup/
│   │   │   ├── FollowupApplication.java          # Punto de entrada
│   │   │   ├── SecurityConfig.java               # Configuración de seguridad
│   │   │   └── module/
│   │   │       ├── gym/                          # Módulo de Gimnasios
│   │   │       │   ├── domain/
│   │   │       │   │   ├── model/               # Entidades de dominio
│   │   │       │   │   ├── repository/          # Contrato de repositorio
│   │   │       │   │   └── exception/           # Excepciones del dominio
│   │   │       │   ├── application/
│   │   │       │   │   ├── service/             # Servicios de aplicación
│   │   │       │   │   └── usecase/             # Casos de uso
│   │   │       │   └── infrastructure/
│   │   │       │       ├── controller/          # REST Controllers
│   │   │       │       ├── persistence/         # Implementación JPA
│   │   │       │       └── adapter/             # Adaptadores
│   │   │       ├── user/                        # Módulo de Usuarios
│   │   │       │   ├── domain/
│   │   │       │   ├── application/
│   │   │       │   └── infrastructure/
│   │   │       └── shared/
│   │   │           └── infrastructure/          # Configuraciones compartidas
│   │   └── resources/
│   │       ├── application.properties           # Configuración principal
│   │       ├── static/                          # Archivos estáticos
│   │       └── templates/                       # Templates (si aplica)
│   └── test/                                    # Suite de tests (unitarios e integración)
├── pom.xml                                      # Configuración Maven
├── mvnw / mvnw.cmd                             # Maven Wrapper
└── README.md                                    # Este archivo
```

---

## Módulos

### 🏋️ Módulo Gym (Gimnasios)

Gestión integral de gimnasios y sus propiedades.

#### Domain Models
- **Gym**: Entidad principal que representa un gimnasio
- **GymId**: Identificador único (Value Object)
- **GymName**: Nombre del gimnasio (Value Object)
- **GymEmail**: Email de contacto (Value Object)
- **GymPhone**: Teléfono (Value Object)
- **GymAddress**: Dirección (Value Object)
- **GymPasswordHash**: Hash de contraseña (Value Object)
- **GymCreatedAt**: Timestamp de creación (Value Object)
- **GymRepository**: Contrato para acceso a datos

#### Excepciones
- **GymNotFoundException**: Cuando un gimnasio no es encontrado
- **GymExistException**: Cuando intenta crear un gimnasio que ya existe

#### Casos de Uso
- **GymSaveUseCase**: Crear nuevo gimnasio
- **GymFindByIdUseCase**: Buscar gimnasio por ID
- **GymFindAllUseCase**: Listar todos los gimnasios
- **GymUpdateUseCase**: Actualizar datos del gimnasio
- **GymDeleteUseCase**: Eliminar un gimnasio

#### Servicios
- **GymService**: Interfaz de servicio
- **GymServiceImpl**: Implementación orquestadora de casos de uso

#### Endpoints REST

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/v1/gym` | Crear nuevo gimnasio |
| GET | `/api/v1/gym/{id}` | Obtener gimnasio por ID |
| GET | `/api/v1/gym` | Listar todos los gimnasios |
| PUT | `/api/v1/gym/{id}` | Actualizar gimnasio |
| DELETE | `/api/v1/gym/{id}` | Eliminar gimnasio |

---

### 👥 Módulo User (Usuarios)

Gestión de usuarios de gimnasios con control de membresía.

#### Domain Models
- **User**: Entidad principal que representa un usuario
- **UserId**: Identificador único (Value Object)
- **UserGymId**: Referencia al gimnasio asociado (Value Object)
- **UserName**: Nombre completo (Value Object)
- **UserIdentification**: Número de identificación (Value Object)
- **UserIdentificationType**: Tipo de identificación (Enum: CC, CE, PP, etc.)
- **UserPhone**: Teléfono de contacto (Value Object)
- **UserMembershipStart**: Inicio de membresía (Value Object)
- **UserMembershipEnd**: Fin de membresía (Value Object)
- **UserPaymentMethod**: Método de pago (Enum: CREDIT_CARD, DEBIT_CARD, CASH, etc.)
- **UserStatus**: Estado del usuario (Enum: ACTIVE, INACTIVE, SUSPENDED)
- **UserCreatedAt**: Timestamp de creación (Value Object)
- **UserRepository**: Contrato para acceso a datos

#### Excepciones
- **UserNotFoundError**: Cuando un usuario no es encontrado
- **UserExistException**: Cuando intenta crear un usuario que ya existe

#### Casos de Uso
- **UserSaveUseCase**: Crear nuevo usuario
- **UserFindByIdUseCase**: Buscar usuario por ID
- **UserFindAllUseCase**: Listar todos los usuarios
- **UserFindByIdentificationUseCase**: Buscar usuario por número de identificación
- **UserUpdateUseCase**: Actualizar datos del usuario
- **UserDeleteUseCase**: Eliminar un usuario

#### Servicios
- **UserService**: Interfaz de servicio
- **UserServiceImpl**: Implementación orquestadora de casos de uso

#### Endpoints REST

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/v1/users` | Crear nuevo usuario |
| GET | `/api/v1/users/{id}` | Obtener usuario por ID |
| GET | `/api/v1/users` | Listar todos los usuarios |
| GET | `/api/v1/users/identification/{identification}` | Buscar por identificación |
| PUT | `/api/v1/users/{id}` | Actualizar usuario |
| DELETE | `/api/v1/users/{id}` | Eliminar usuario |

---

### 🔧 Módulo Shared

Componentes compartidos entre módulos.

- **Configuraciones generales**
- **Constantes**
- **Utilidades comunes**

---

## Requisitos del Sistema

### Mínimos
- **Java Development Kit (JDK) 21** o superior
- **Apache Maven 3.8.0** o superior (o usar Maven Wrapper incluido)
- **PostgreSQL 15** o superior
- **4GB RAM mínimo**
- **250MB espacio en disco**

### Recomendado para Desarrollo
- **IDE**: IntelliJ IDEA, Eclipse o VSCode
- **Git** para control de versiones
- **Postman** o **Thunder Client** para testing de APIs
- **DBeaver** o **pgAdmin** para gestión de BD

### Compatibilidad SO
- ✅ Linux (Debian, Ubuntu, CentOS)
- ✅ macOS (Intel y Apple Silicon)
- ✅ Windows 10+ (con WSL2 recomendado)

---

## Instalación y Configuración

### 1. Clonar el Repositorio

```bash
cd /home/linux-sebastian/Aether
if [ ! -d "FollowUpBackend" ]; then
  mkdir FollowUpBackend
fi
cd FollowUpBackend
```

### 2. Instalar Dependencias

```bash
# Usar Maven Wrapper (recomendado)
./mvnw clean install

# O con Maven instalado globalmente
mvn clean install
```

### 3. Configurar Base de Datos

#### Crear base de datos PostgreSQL

```sql
CREATE DATABASE followup;
CREATE USER followup_user WITH PASSWORD 'followup_password';
GRANT ALL PRIVILEGES ON DATABASE followup TO followup_user;
```

#### Variables de Entorno

```bash
# Linux/macOS
export DB_URL="jdbc:postgresql://localhost:5432/followup"
export DB_USER="followup_user"
export DB_PASSWORD="followup_password"
export DB_DDL_STRATEGY="update"

# Windows (PowerShell)
$env:DB_URL="jdbc:postgresql://localhost:5432/followup"
$env:DB_USER="followup_user"
$env:DB_PASSWORD="followup_password"
$env:DB_DDL_STRATEGY="update"
```

O crear archivo [.env]() en la raíz del proyecto:

```properties
DB_URL=jdbc:postgresql://localhost:5432/followup
DB_USER=followup_user
DB_PASSWORD=followup_password
DB_DDL_STRATEGY=update
```

### 4. Compilación Inicial

```bash
./mvnw clean compile
```

---

## Comandos de Ejecución

### ▶️ Ejecutar la Aplicación

```bash
# Opción 1: Con Maven Wrapper
./mvnw spring-boot:run

# Opción 2: Ejecutar JAR compilado
./mvnw clean package
java -jar target/followup-0.0.1-SNAPSHOT.jar
```

La aplicación estará disponible en: `http://localhost:8080`

### 🧹 Limpiar y Construir

```bash
# Limpiar artefactos previos
./mvnw clean

# Compilar proyecto
./mvnw compile

# Generar empaquetado JAR/WAR
./mvnw package

# Limpiar e instalar (include testing)
./mvnw clean install
```

### 📊 Análisis de Dependencias

```bash
# Analizador de dependencias
./mvnw dependency:analyze

# Actualizar dependencias disponibles
./mvnw versions:display-dependency-updates

# Ver árbol de dependencias
./mvnw dependency:tree
```

### 🔍 Validación de Código

```bash
# Validar estructura del proyecto
./mvnw validate

# Verificar compilación cruzada
./mvnw verify

# Análisis de dependencias
./mvnw dependency:analyze

# Listar dependencias no utilizadas
./mvnw dependency:analyze-only
```

---

## Documentación de API

### Swagger UI

Una vez que la aplicación está en ejecución, accede a la documentación interactiva:

```
http://localhost:8080/swagger-ui.html
```

### OpenAPI JSON

```
http://localhost:8080/v3/api-docs
```

### Exploración de Endpoints

#### Módulo Gym

```bash
# Crear gimnasio
curl -X POST http://localhost:8080/api/v1/gym \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Gym Fitness",
    "email": "info@gymfitness.com",
    "phone": "+34912345678",
    "address": "Calle Principal 123, Madrid",
    "password": "SecurePassword123!"
  }'

# Obtener todos
curl http://localhost:8080/api/v1/gym

# Obtener por ID
curl http://localhost:8080/api/v1/gym/1

# Actualizar
curl -X PUT http://localhost:8080/api/v1/gym/1 \
  -H "Content-Type: application/json" \
  -d '{"name": "Gym Fitness Pro"}'

# Eliminar
curl -X DELETE http://localhost:8080/api/v1/gym/1
```

#### Módulo User

```bash
# Crear usuario
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{
    "gymId": 1,
    "name": "Juan Pérez",
    "identification": "12345678A",
    "identificationType": "CC",
    "phone": "+34678901234",
    "paymentMethod": "CREDIT_CARD"
  }'

# Obtener todos
curl http://localhost:8080/api/v1/users

# Obtener por ID
curl http://localhost:8080/api/v1/users/1

# Buscar por identificación
curl http://localhost:8080/api/v1/users/identification/12345678A

# Actualizar
curl -X PUT http://localhost:8080/api/v1/users/1 \
  -H "Content-Type: application/json" \
  -d '{"name": "Juan Carlos Pérez"}'

# Eliminar
curl -X DELETE http://localhost:8080/api/v1/users/1
```

---

## Seguridad

### Configuración de Seguridad

- **Spring Security**: Implementado en `SecurityConfig.java`
- **CORS**: Configurado para desarrollo local
- **HTTPS**: Recomendado en producción
- **Validación de Entrada**: Entity validation en controladores
- **JPA Auditing**: Auditoría automática de creación/modificación

### Mejores Prácticas Implementadas

✅ Inyección de dependencias para desacoplamiento
✅ Validación en la capa de controladores
✅ Excepciones personalizadas del dominio
✅ Separación de responsabilidades
✅ Principios de programación defensiva

### Consideraciones para Producción

- Usar HTTPS/TLS en todas las comunicaciones
- Implementar Rate Limiting
- Configurar CORS restrictivo con dominios específicos
- Usar variables de entorno para credenciales sensibles
- Implementar logging y monitoreo
- Ejecutar con miembro de usuario no-root

---

## Variables de Entorno

### Configuración Principal

```properties
# Base de Datos
DB_URL=jdbc:postgresql://localhost:5432/followup
DB_USER=followup_user
DB_PASSWORD=tu_contraseña_segura
DB_DDL_STRATEGY=update|create|create-drop|validate

# Spring Boot
SPRING_PROFILES_ACTIVE=dev|prod
SERVER_PORT=8080

# Logging
LOGGING_LEVEL_ROOT=INFO
LOGGING_LEVEL_COM_X86_FOLLOWUP=DEBUG
```

### Valores de BD_DDL_STRATEGY

| Valor | Descripción |
|-------|-------------|
| `validate` | Valida schema sin cambios (producción) |
| `update` | Actualiza schema automáticamente (desarrollo) |
| `create` | Crea schema nuevamente cada inicio |
| `create-drop` | Crea y elimina schema (testing) |

---

## Desarrollo

### Flujo de Desarrollo

1. **Crear rama** para nuevo feature
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```

2. **Desarrollar** siguiendo la arquitectura hexagonal

3. **Escribir tests** para validar cambios

4. **Ejecutar tests** antes de commit
   ```bash
   ./mvnw clean test
   ```

5. **Validar código**
   ```bash
   ./mvnw verify
   ```

6. **Commit y Push**
   ```bash
   git add .
   git commit -m "feat: descripción del cambio"
   git push origin feature/nueva-funcionalidad
   ```

### Patrones de Codificación

#### Crear Nuevo Caso de Uso

```java
// 1. Interfaz en domain.model o domain.repository
public interface MiRepository {
    void save(MiEntidad entidad);
}

// 2. Use Case en application.usecase
@Component
public class MiUseCase {
    private final MiRepository repository;
    
    public void execute(MiEntidad entidad) {
        // Lógica de negocio
        repository.save(entidad);
    }
}

// 3. Servicio en application.service
@Service
@RequiredArgsConstructor
public class MiServiceImpl {
    private final MiUseCase miUseCase;
    
    public void procesar(MiEntidad entidad) {
        miUseCase.execute(entidad);
    }
}

// 4. Controlador en infrastructure.controller
@RestController
@RequestMapping("/api/v1/mi-recurso")
@RequiredArgsConstructor
public class MiController {
    private final MiService service;
    
    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody MiRequest request) {
        service.procesar(new MiEntidad(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
```

### Estructura de Package

Cuando agregues nuevas funcionalidades, mantén esta estructura:

```
com.x86.followup.module.{nombreModulo}
├── domain/
│   ├── model/          # Entidades y Value Objects
│   ├── repository/     # Contratos de repositorio
│   └── exception/      # Excepciones de dominio
├── application/
│   ├── service/        # Servicios de aplicación
│   └── usecase/        # Casos de uso
└── infrastructure/
    ├── controller/     # REST Controllers
    ├── persistence/    # Implementaciones JPA
    └── adapter/        # Adaptadores externos
```

### Tools y Extensiones Recomendadas (IDE)

**IntelliJ IDEA:**
- Lombok plugin
- Spring Boot Assistant
- Database Tools

**VSCode:**
- Extension Pack for Java
- Spring Boot Extension Pack
- REST Client
- Thunder Client

---

## 📚 Referencias

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security)
- [Spring Modulith](https://spring.io/projects/spring-modulith)
- [SpringDoc OpenAPI](https://springdoc.org/)
- [Lombok](https://projectlombok.org/)

---

## 👨‍💻 Autor

**FollowUp Backend Team**  
Desarrollado con Spring Boot y Java 21

---

## 📝 Licencia

Este proyecto está bajo licencia MIT. Ver LICENSE para más detalles.

---

**Última Actualización:** 30 de marzo de 2026  
**Versión:** 0.0.1-SNAPSHOT  
**Status:** 🟢 En Desarrollo

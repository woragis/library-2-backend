# Backend

## File Structure

### Feature-Based Structure (Alternative approach)

```sh
src/main/java/com/example/userapi/
├── UserApiApplication.java
├── user/                          # Feature package
│   ├── UserController.java
│   ├── UserService.java
│   ├── UserHandler.java
│   ├── UserRepository.java
│   ├── User.java
│   ├── CreateUserDto.java
│   ├── UpdateUserDto.java
│   └── UserResponseDto.java
├── auth/                          # Another feature package
│   ├── AuthController.java
│   ├── AuthService.java
│   └── ...
├── common/                        # Shared components
│   ├── exception/
│   ├── config/
│   └── util/
└── ...
```

### Domain-Driven Design Structure (For larger applications)

```sh
src/main/java/com/example/userapi/
├── UserApiApplication.java
├── domain/                        # Domain layer
│   ├── user/
│   │   ├── User.java             # Domain entity
│   │   ├── UserRepository.java   # Domain repository interface
│   │   └── UserService.java      # Domain service
│   └── shared/
├── infrastructure/                # Infrastructure layer
│   ├── persistence/
│   │   └── UserRepositoryImpl.java
│   └── config/
├── application/                   # Application layer
│   ├── user/
│   │   ├── UserHandler.java
│   │   └── dto/
│   └── common/
└── presentation/                  # Presentation layer
    └── web/
        └── UserController.java
```

### Spring Boot User CRUD - File Organization Structure

```sh
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── userapi/
│   │               ├── UserApiApplication.java              # Main Spring Boot Application
│   │               ├── config/
│   │               │   ├── DatabaseConfig.java             # Database configuration (optional)
│   │               │   └── WebConfig.java                   # Web configuration (CORS, etc.)
│   │               ├── controller/
│   │               │   └── UserController.java             # REST API endpoints
│   │               ├── dto/
│   │               │   ├── CreateUserDto.java              # DTO for user creation
│   │               │   ├── UpdateUserDto.java              # DTO for user updates
│   │               │   └── UserResponseDto.java            # DTO for API responses
│   │               ├── entity/
│   │               │   ├── User.java                       # User JPA entity
│   │               │   └── Role.java                       # Role enum
│   │               ├── exception/
│   │               │   ├── GlobalExceptionHandler.java     # Global exception handling
│   │               │   ├── UserNotFoundException.java      # Custom exception
│   │               │   ├── DuplicateUserException.java     # Custom exception
│   │               │   ├── ErrorResponse.java              # Error response DTO
│   │               │   └── ValidationErrorResponse.java    # Validation error DTO
│   │               ├── handler/
│   │               │   └── UserHandler.java                # Business logic handlers
│   │               ├── repository/
│   │               │   └── UserRepository.java             # JPA repository interface
│   │               ├── service/
│   │               │   ├── UserService.java                # Business logic service
│   │               │   └── impl/                           # Service implementations (if using interfaces)
│   │               │       └── UserServiceImpl.java
│   │               └── util/                               # Utility classes (optional)
│   │                   ├── PasswordUtil.java              # Password utilities
│   │                   └── DateUtil.java                  # Date utilities
│   └── resources/
│       ├── application.yml                                 # Main configuration
│       ├── application-dev.yml                            # Development profile
│       ├── application-prod.yml                           # Production profile
│       ├── application-test.yml                           # Test profile
│       ├── db/
│       │   └── migration/                                 # Flyway/Liquibase migrations (optional)
│       │       ├── V1__Create_users_table.sql
│       │       └── V2__Add_indexes.sql
│       ├── static/                                        # Static web resources
│       │   ├── css/
│       │   ├── js/
│       │   └── images/
│       └── templates/                                     # Thymeleaf templates (if using)
└── test/
    ├── java/
    │   └── com/
    │       └── example/
    │           └── userapi/
    │               ├── UserApiApplicationTests.java        # Integration tests
    │               ├── controller/
    │               │   └── UserControllerTest.java         # Controller unit tests
    │               ├── service/
    │               │   └── UserServiceTest.java            # Service unit tests
    │               ├── repository/
    │               │   └── UserRepositoryTest.java         # Repository tests
    │               └── integration/
    │                   └── UserIntegrationTest.java        # Integration tests
    └── resources/
        ├── application-test.yml                           # Test configuration
        └── test-data/
            └── users.sql                                  # Test data scripts

# Root level files
├── pom.xml                                                # Maven configuration
├── .gitignore                                            # Git ignore rules
├── README.md                                             # Project documentation
├── docker-compose.yml                                    # Docker setup for MySQL
└── Dockerfile                                            # Application containerization
```

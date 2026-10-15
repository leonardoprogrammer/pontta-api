# Pontta API

API REST em Spring Boot com o cadastro de clientes

## Pré-requisitos

- Java 17
- PostgreSQL rodando em `localhost:5432` e um banco de dados chamado `pontta`

## Configuração

As credenciais do banco ficam em `src/main/resources/application.properties`. Ajuste se necessário:

## Como rodar

Windows:
```bash
.\mvnw.cmd spring-boot:run
```

Linux/Mac:
```bash
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080/api`.

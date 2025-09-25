# CRUD Spring Boot - Usuários

Este projeto é um exemplo de **CRUD de usuários** desenvolvido com **Spring Boot 3**, utilizando **JPA/H2** e seguindo boas práticas REST. O objetivo é demonstrar criação, leitura, atualização e exclusão de registros de usuários com validações, paginação e ordenação.

---

## Funcionalidades

- **Banco de dados relacional**: utiliza H2 em memória para facilitar testes e desenvolvimento.  
- **Validações**: campos obrigatórios (`name` e `email`) com regras de formato (`email`).  
- **Endpoints RESTful**: criados seguindo boas práticas de REST, incluindo:
  - `POST /v1/api/users` → Criar usuário  
  - `GET /v1/api/users/{id}` → Buscar usuário por ID  
  - `GET /v1/api/users` → Listar todos usuários com **paginação e ordenação**  
  - `PUT /v1/api/users/{id}` → Atualizar usuário  
  - `DELETE /v1/api/users/{id}` → Deletar usuário  
- **Paginação e ordenação**: suporta `Pageable` do Spring Data para listagem de usuários.  
- **Swagger / OpenAPI**: documentação interativa disponível para explorar os endpoints.

---

## Tecnologias Utilizadas

- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- H2 Database  
- Jakarta Validation (`@NotBlank`, `@Email`)  
- MapStruct para mapeamento entre DTOs e entidades  
- Lombok para redução de boilerplate  
- Springdoc OpenAPI / Swagger UI

---

## Executando o Projeto

1. Clone o repositório:

```bash
git clone https://github.com/hugoodesa/crud-user-sboot-test.git
cd CRUD-springboot-test

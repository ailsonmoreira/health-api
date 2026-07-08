# Health API

API REST desenvolvida com **Spring Boot** para gerenciamento de cidadãos, residências e usuários do sistema de Atenção Primária à Saúde.

O projeto implementa autenticação via **JWT**, controle de acesso por **papéis (roles)** e autorização baseada em **microáreas**, simulando o funcionamento de um sistema utilizado por agentes comunitários de saúde.

---

# Tecnologias

* Java 21
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* PostgreSQL
* Flyway
* Docker Compose
* Maven
* Springdoc OpenAPI (Swagger)

---

# Arquitetura

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

O projeto segue arquitetura em camadas, separando responsabilidades entre apresentação, regras de negócio e persistência.

---

# Funcionalidades implementadas

* Autenticação utilizando JWT
* Usuário administrador inicial (Bootstrap)
* Cadastro de usuários
* Cadastro de cidadãos
* Cadastro de residências
* Associação automática entre cidadão e residência
* Controle de acesso por perfil (ADMIN e AGENT)
* Associação automática da microárea conforme o usuário autenticado
* Migrações de banco utilizando Flyway

---

# Estrutura do projeto

```text
src/main/java
│
├── auth
├── controller
├── dto
├── entity
├── exception
├── mapper
├── repository
├── security
├── service
└── validation
```

---

# Como executar

## Clone o repositório

```bash
git clone <URL_DO_REPOSITORIO>
```

## Inicie o banco de dados

```bash
docker compose up -d
```

## Execute a aplicação

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

---

# Configuração

As configurações sensíveis devem permanecer fora do código-fonte.

Exemplo de variáveis:

```properties
DB_URL=
DB_USERNAME=
DB_PASSWORD=

JWT_SECRET=
JWT_EXPIRATION=
```

---

# Admin Bootstrap

A aplicação cria automaticamente um usuário administrador, caso ele ainda não exista, com usuário padrão ```
admin@admin.com``` e senha ```admin123```

Após o primeiro acesso, recomenda-se alterar as credenciais para valores personalizados.

---

# Autenticação

O login é realizado através do endpoint de autenticação.

Após o login, a API retorna um **JWT**, que deve ser enviado nas demais requisições:

```http
Authorization: Bearer <TOKEN>
```

---

# Controle de acesso

Existem dois perfis de usuário:

## ADMIN

* Gerencia usuários
* Possui acesso completo ao sistema
* Pode operar em qualquer microárea

## AGENT

* Atua apenas na própria microárea
* Novos cidadãos e residências recebem automaticamente a microárea do agente autenticado
* Não possui acesso aos registros de outras microáreas

---

# Documentação da API

A documentação interativa está disponível através do Swagger/OpenAPI após iniciar a aplicação.

Exemplo:

```text
http://localhost:8080/swagger-ui.html
```

ou

```text
http://localhost:8080/swagger-ui/index.html
```

---

# Status do projeto

Em desenvolvimento.

Próximas funcionalidades:

* Busca com filtros
* Tratamento global de exceções
* Testes unitários e de integração
* Documentação completa dos endpoints
* Cobertura de testes
* CI/CD

---

# Licença

Projeto desenvolvido para fins de estudo e portfólio.

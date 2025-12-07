# Demo CRUD API

## Resumo
API RESTful robusta para gestão de usuários, focada em segurança e boas práticas de desenvolvimento. A aplicação permite o ciclo completo de gerenciamento (CRUD) com controle de acesso baseado em papéis (RBAC).

O sistema diferencia usuários comuns (**USER**) de administradores (**ADMIN**), onde apenas administradores possuem privilégios para listar todos os registros ou remover usuários do sistema. A autenticação é via JWT (JSON Web Token) com estratégia de **Refresh Token** persistido em banco de dados para maior segurança.

## Tecnologias Utilizadas

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3
* **Segurança:** Spring Security + JWT (Auth0)
* **Banco de Dados:** MySQL 8
* **ORM:** Hibernate / Spring Data JPA
* **Infraestrutura:** Docker & Docker Compose
* **Ferramentas:** Lombok, Maven

## Estudos Aplicados

Este projeto foi desenvolvido com foco na aplicação de conceitos avançados de Engenharia de Software e Segurança:

* **Autenticação Stateless & Stateful:** Implementação híbrida usando Access Token (curta duração) e Refresh Token (longa duração persistido no banco).
* **Segurança por Camadas:** Proteção de rotas via `SecurityFilterChain`, criptografia de senhas com BCrypt e validação de dados com Bean Validation.
* **Gestão de Segredos:** Uso de variáveis de ambiente e placeholders (`${...}`) para não expor credenciais sensíveis no código-fonte.
* **Containerização:** Configuração de ambiente de desenvolvimento portátil usando Docker Compose (Aplicação + Banco).
* **Arquitetura:** Separação de responsabilidades (Controller, Service, Repository, DTOs e Entities).

## Instalação e Execução

### Pré-requisitos
* Docker e Docker Compose instalados.
* (Opcional) Java 17 e Maven para rodar localmente fora do container.

### Passo 1: Configuração de Ambiente (.env)
Por segurança, o projeto não compartilha senhas reais. Crie um arquivo `.env` na raiz do projeto (onde está o `docker-compose.yml`) com o seguinte conteúdo:

```properties
# Configuração do Banco de Dados
MYSQL_DATABASE=demo_crud_db
MYSQL_ROOT_USERNAME=root
MYSQL_ROOT_PASSWORD=sua_senha_forte_aqui

JWT_SECRET=segredo_super_secreto_para_gerar_token
```

### Passo 2: Rodando com Docker (Recomendado)

Na raiz do projeto, execute:

```properties
docker-compose up --build
```
A API estará disponível em: http://localhost:8081

### Passo 3: Rodando Localmente (Sem Docker)

Caso queira rodar a aplicação via IDE (IntelliJ/Eclipse) e apenas o banco no Docker:

Suba apenas o banco: 

```properties
docker-compose up db -d
```

A aplicação usará automaticamente as configurações padrão de desenvolvimento (localhost, user: root, pass: password) 
definidas no application.properties via fallback.


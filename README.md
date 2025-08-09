# Workshop Spring Boot + MongoDB
O objetivo é implementar uma aplicação **Spring Boot** integrada ao **MongoDB** para praticar operações CRUD, consultas personalizadas e associações entre documentos em um banco orientado a documentos.

## Objetivos do Projeto
- Compreender diferenças entre paradigma **orientado a documentos** e **relacional**
- Implementar **operações CRUD** com Spring Data MongoDB
- Trabalhar com **associações entre documentos**:
  - Objetos aninhados
  - Referências (DBRef)
- Criar consultas personalizadas com `@Query` e query methods
- Utilizar DTOs para trafegar dados entre API e cliente

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot**
- **Spring Data MongoDB**
- **Maven**
- **MongoDB**
- **MongoDB Express** 
- **Docker** 

## Estrutura do Projeto
- `domain/` – Entidades do domínio (`User`, `Post`, etc.)
- `repository/` – Interfaces para acesso ao MongoDB
- `service/` – Regras de negócio e integração com repositórios
- `resources/` – Controladores REST e tratamento de exceções
- `dto/` – Objetos de transferência de dados (Data Transfer Objects)
- `config/` – Instanciação inicial do banco de dados


### 2. Configuração da aplicação
No arquivo `application.properties`:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo
```


## Endpoints Principais

### Usuários
- `GET /users` – Lista todos os usuários
- `GET /users/{id}` – Retorna usuário por ID
- `POST /users` – Insere novo usuário
- `PUT /users/{id}` – Atualiza usuário existente
- `DELETE /users/{id}` – Remove usuário

### Posts
- `GET /posts/{id}` – Retorna um post por ID
- `GET /users/{id}/posts` – Lista posts de um usuário
- Consultas personalizadas por título, conteúdo e intervalo de datas

## Modelo de Dados

Exemplo de documento `User`:
```json
{
  "id": "1001",
  "name": "Maria Brown",
  "email": "maria@gmail.com",
  "posts": [
    {
      "date": "2018-03-21",
      "title": "Partiu viagem",
      "body": "Vou viajar para São Paulo. Abraços!",
      "comments": [
        {
          "text": "Boa viagem mano!",
          "date": "2018-03-21",
          "author": { "id": "1013", "name": "Alex Green" }
        }
      ]
    }
  ]
}
```

## Conceitos Aplicados
- **DTO (Data Transfer Object)** para otimizar tráfego e evitar exposição de dados sensíveis
- **MongoRepository** para abstrair acesso a dados
- **@Query** para consultas personalizadas
- **DBRef** para relacionamentos entre coleções
- **Tratamento de exceções** com `@ControllerAdvice`

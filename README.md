# CitySync

## Projeto Integrador – Backend REST com Spring Boot

**Curso:** Engenharia de Software  
**Instituição:** Centro Universitário das Faculdades Integradas de Ourinhos - UniFio  
**Turma:** 4º Termo

## Integrantes

- Rafael Amadei – RA 272987
- Gustavo Silveira Nunes – RA 273581
- Daniel Andrade Costa – RA 272482
- Luiz Felipe Inacio de Souza – RA 273207

## Sobre o projeto

O CitySync é uma plataforma para registro e acompanhamento de problemas urbanos, como buracos nas ruas, sinalização danificada e problemas em semáforos.

Os cidadãos podem registrar ocorrências, adicionar comentários, apoiar registros e acompanhar atualizações.

**Objetivo:** Desenvolver um backend REST que permita aos cidadãos registrar, acompanhar e interagir com ocorrências urbanas, facilitando a comunicação e a participação da comunidade na identificação de problemas da cidade.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- Maven
- Bean Validation
- Lombok

## Entidades

- Usuario
- Ocorrencia
- Comentario
- Apoio
- Foto
- Atualizacao

## Funcionalidades

- CRUD das seis entidades.
- Autenticação HTTP Basic.
- Perfis USER e ADMIN.
- Validação de dados.
- Tratamento global de exceções.
- Prevenção de apoios duplicados.
- Bloqueio de atualizações em ocorrências encerradas ou resolvidas.
- Consultas por status e usuário.

## Como executar

1. Configure o MySQL.
2. Configure a variável de ambiente `DB_PASSWORD`.
3. Execute `./mvnw spring-boot:run`.

## Documentação

- Documentação da API: `docs/documentacao-api.md`
- Modelo de dados: `docs/modelo-dados.png`
- Coleção Postman: `postman/Projeto Integrador - CitySync.postman_collection.json`
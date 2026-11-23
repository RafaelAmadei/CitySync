# Documentação da API – CitySync

## 1. Autenticação

A API utiliza HTTP Basic Authentication.

- POST /usuarios: cadastro público.
- Demais endpoints: exigem autenticação.
- DELETE: exige perfil ADMIN.

## 2. Usuários

| Método | Endpoint | Descrição |
|---|---|---|
| GET | /usuarios | Listar usuários |
| GET | /usuarios/{id} | Buscar usuário |
| POST | /usuarios | Cadastrar usuário |
| PUT | /usuarios/{id} | Atualizar usuário |
| DELETE | /usuarios/{id} | Excluir usuário |

## 3. Ocorrências

| Método | Endpoint | Descrição |
|---|---|---|
| GET | /ocorrencias | Listar ocorrências |
| GET | /ocorrencias/{id} | Buscar ocorrência |
| POST | /ocorrencias | Cadastrar ocorrência |
| PUT | /ocorrencias/{id} | Atualizar ocorrência |
| DELETE | /ocorrencias/{id} | Excluir ocorrência |
| GET | /ocorrencias/status/{status} | Buscar por status |
| GET | /ocorrencias/usuario/{usuarioId} | Buscar por usuário |

## 4. Comentários

| Método | Endpoint | Descrição |
|---|---|---|
| GET | /comentarios | Listar comentários |
| GET | /comentarios/{id} | Buscar comentário |
| POST | /comentarios | Cadastrar comentário |
| PUT | /comentarios/{id} | Atualizar comentário |
| DELETE | /comentarios/{id} | Excluir comentário |

## 5. Apoios

| Método | Endpoint | Descrição |
|---|---|---|
| GET | /apoios | Listar apoios |
| GET | /apoios/{id} | Buscar apoio |
| POST | /apoios | Cadastrar apoio |
| PUT | /apoios/{id} | Atualizar apoio |
| DELETE | /apoios/{id} | Excluir apoio |

Um usuário não pode apoiar a mesma ocorrência mais de uma vez.

## 6. Fotos

| Método | Endpoint | Descrição |
|---|---|---|
| GET | /fotos | Listar fotos |
| GET | /fotos/{id} | Buscar foto |
| POST | /fotos | Cadastrar foto |
| PUT | /fotos/{id} | Atualizar foto |
| DELETE | /fotos/{id} | Excluir foto |

## 7. Atualizações

| Método | Endpoint | Descrição |
|---|---|---|
| GET | /atualizacoes | Listar atualizações |
| GET | /atualizacoes/{id} | Buscar atualização |
| POST | /atualizacoes | Cadastrar atualização |
| PUT | /atualizacoes/{id} | Atualizar atualização |
| DELETE | /atualizacoes/{id} | Excluir atualização |

Não é permitido registrar atualizações em ocorrências com status RESOLVIDA ou ENCERRADA.

## 8. Códigos HTTP

| Código | Significado |
|---|---|
| 200 | Requisição realizada com sucesso |
| 201 | Recurso criado |
| 204 | Recurso excluído sem conteúdo de resposta |
| 400 | Dados inválidos ou regra de negócio violada |
| 401 | Usuário não autenticado |
| 403 | Usuário sem permissão |
| 404 | Recurso não encontrado |
| 409 | Conflito com integridade dos dados |
# School_Manager

# Impacto Manager API
Esta é uma API feita em SpringBoot 3 que permite gerenciar professores e alunos de uma instituição de ensino. A API segue o padrão OpenAPI 3.0.1 e tem dois controladores: professor-controller e aluno-controller. Cada controlador permite operações CRUD (criar, ler, atualizar e deletar) sobre as entidades Professor e Aluno, respectivamente. A API usa o formato JSON para as requisições e respostas.

## Version: 1.0.0

**License:** [MIT](https://opensource.org/licenses/MIT)

### /professor/{id}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### PUT
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### DELETE
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /aluno/{id}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### PUT
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### DELETE
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /register

#### POST
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /professor/novo

#### POST
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /aluno/novo

#### POST
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /professor

#### GET
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /aluno

#### GET
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /allusers

#### GET
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /user

#### GET
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### PUT
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### POST
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### DELETE
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### OPTIONS
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### PATCH
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |


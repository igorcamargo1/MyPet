# MyPet
Uma API de petshop no qual o cliente pode escolher o serviço que deseja usar.

<h1>
    <img src="./img/MyPet-logo2.png"/>
</h1>

---

# Endpoints

- [MyPet](#mypet)
- [Endpoints](#endpoints)
  - [Serviços](#serviços)
    - [Cadastrar Serviço](#cadastrar-serviço)
    - [Editar serviço](#editar-serviço)
    - [Deletar serviço](#deletar-serviço)
    - [Listar Serviços](#listar-serviços)
---

## Serviços

### Cadastrar Serviço

`POST`/mypet/api/user/{userId}/servico

**Campos de Requisição**

| campo      | tipo      | obrigatório | descrição                            |
| ---------- | --------- | :---------: | ------------------------------------ |
| id_usuario | int       |     sim     | id do usuário previamente cadastrado |
| id_servico | int       |     sim     | id do serviço |
| nm_servico | texto     |     sim     | o nome do serviço                    |
| pc_servico | double    |     sim     | o preço do serviço                   |
| ds_servico | texto     |     sim     | descrição sobre o serviço            |
| img_servico| byte      |     sim     | imagem do tipo de serviço  

**Exemplo de corpo de requisição**

```js
{
    id_usuario: 1,
    nome: 'Banho e tosa',
    preco:'75.00',
    descricao:'Deixe seu pet limpo e cheiroso',
    imagem: ''
}
```

**Códigos de Resposta**

| codigo | descricao                    |
| ------ | ---------------------------- |
| 201    | curso cadastrado com sucesso |
| 400    | campos inválidos             |
| 408    | tempo esgotado               |

---

### Editar serviço

`PUT` /mypet/api/user/{userId}/curso/{cursoId}

**Campos de Requisição**

| campo      | tipo      | obrigatório | descrição                            |
| ---------- | --------- | :---------: | ------------------------------------ |
| id_usuario | int       |     sim     | id do usuário previamente cadastrado |
| nome       | texto     |     sim     | o nome do serviço                    |
| preco      | double    |     sim     | o preço do serviço                   |
| descricao  | texto     |     sim     | descrição sobre o serviço            |
| imagem     | byte      |     sim     | imagem do tipo de serviço            |

**Exemplo de corpo de requisição**

```js
{
    id_usuario: 1,
    nome: 'Banho e tosa',
    preco:'75.00',
    descricao:'Deixe seu pet limpo e cheiroso',
    imagem: ''
}
```

**Códigos de Repostas**

| codigo | descricao                             |
| ------ | ------------------------------------- |
| 200    | serviço alterado com sucesso          |
| 400    | campos inválidos                      |
| 404    | não existe serviço com o id informado |
| 408    | tempo esgotado                        |
| 500    | internal server error                 |

---

### Deletar serviço

`DELETE` /mypet/api/user/{userid}/servico/{servicoId}

**Campos de Requisição**

| campo      | tipo      | obrigatório | descrição                            |
| ---------- | --------- | :---------: | ------------------------------------ |
| id_usuario | int       |     sim     | id do usuário previamente cadastrado |
| nome       | texto     |     sim     | o nome do serviço                    |
| preco      | double    |     sim     | o preço do serviço                   |
| descricao  | texto     |     sim     | descrição sobre o serviço            |
| imagem     | byte      |     sim     | imagem do tipo de serviço            |

**Exemplo de corpo de requisição**

```js
{
    usuario{
        id_usuarui:1
    }
    nome: 'Banho e tosa',
    preco:'75.00',
    descricao:'Deixe seu pet limpo e cheiroso',
    imagem: ''
}
```

**Códigos de Repostas**

| codigo | descricao                           |
| ------ | ----------------------------------- |
| 200    | curso removido com sucesso          |
| 404    | não existe curso com o id informado |
| 408    | tempo esgotado                      |
| 500    | internal server error               |

---

### Listar Serviços

`GET` /mypet/api/servicos

**Exemplo de corpo de requisição**

```js
{
    nome: 'Banho e tosa',
    preco:'75.00',
    descricao:'Deixe seu pet limpo e cheiroso',
    imagem: ''
}
```
```js
{
    nome: 'Passeio',
    preco:'50.99',
    descricao:'Deixe seu pet em nossas mão para ter um dia incrível!',
    imagem: ''
}
```

**Códigos de Repostas**

| codigo | descricao                  |
| ------ | -------------------------- |
| 200    | dados do cursos retornados |
| 404    | cursos não encontrados     |
| 500    | internal server error      |

<br>

---
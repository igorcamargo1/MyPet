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
    - [Cadastrar Serviços](#cadastrar-serviços)
    - [Editar serviços](#editar-serviços)
    - [Deletar serviços](#deletar-serviços)
    - [Listar Serviços](#listar-serviços)
  - [Usuarios](#usuarios)
    - [Cadastrar usuarios](#cadastrar-usuarios)
    - [Editar usuarios](#editar-usuarios)
    - [Deletar usuarios](#deletar-usuarios)
    - [Listar usuarios](#listar-usuarios)
  - [Pagamentos](#pagamentos)
    - [Cadastrasr pagamentos](#cadastrasr-pagamentos)
    - [Editar pagamentos](#editar-pagamentos)
  - [Deletar pagamentos](#deletar-pagamentos)
    - [Listar pagamento](#listar-pagamento)
---

## Serviços

### Cadastrar Serviços

`POST`/mypet/api/servicos

**Campos de Requisição**

| campo      | tipo      | obrigatório | descrição                            |
| ---------- | --------- | :---------: | ------------------------------------ |
| nome       | texto     |     sim     | o nome do serviço                    |
| preco      | double    |     sim     | o preço do serviço                   |
| descricao  | texto     |     sim     | descrição sobre o serviço            |
| imagem     | byte      |     sim     | imagem do tipo de serviço            |

**Exemplo de corpo de requisição**

```js
{
    nome: 'Banho e tosa',
    preco:'75.00',
    descricao:'Deixe seu pet limpo e cheiroso',
    imagem: 'path/arquivo.png'
}
```

**Códigos de Resposta**

| código | descrição                                                 |
| ------ | --------------------------------------------------------- |
| 201    | serviço criado com sucesso                                |
| 404    | Campos inválidos                                          |
| 409    | Conflict - Já existe um serviço com o mesmo nome          |
| 500    | Ocorreu um erro interno enquanto processava a solicitação |

---

### Editar serviços

`PUT` /mypet/api/servicos/{servicoId}

**Campos de Requisição**

| campo      | tipo      | obrigatório | descrição                            |
| ---------- | --------- | :---------: | ------------------------------------ |
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

| código | descrição                                                 |
| ------ | --------------------------------------------------------- |
| 200    | Serviço atualizado com sucesso                            |
| 404    | O serviço não foi localizado                              |
| 500    | Ocorreu um erro interno enquanto processava a solicitação |

---

### Deletar serviços

`DELETE` /mypet/api/servicos/{servicoId}


**Exemplo de corpo de requisição**

```js
{
    id_servico: 1,
    nome: 'Banho e tosa',
    preco:'75.00',
    descricao:'Deixe seu pet limpo e cheiroso',
    imagem: 'path/arquivo.png'
}
```

**Códigos de Repostas**

| código | descrição                                                 |
| ------ | --------------------------------------------------------- |
| 200    | Serviço removido com sucesso                              |
| 404    | O serviço não foi localizado                              |
| 500    | Ocorreu um erro interno enquanto processava a solicitação |

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

| código | descrição                                                 |
| ------ | --------------------------------------------------------- |
| 200    | Retorna uma lista de todos serviços                       |
| 404    | A lista de serviços não foi localizada                    |
| 500    | Ocorreu um erro interno enquanto processava a solicitação |

<br>

---

## Usuarios

### Cadastrar usuarios

`POST` /mypet/api/usuarios


**Campos da Requisição**

|   campo  | tipo  | obrigatório | descrição                            |
| -------- | ----- | :---------: | ------------------------------------ |
| nome     | texto |     sim     | Nome completo do usuário             |
| email    | texto |     sim     | E-mail do usuário                    |
| cpf      | texto |     sim     | número de registro do usuário        |
| telefone | texto |     sim     | número de telefone do usuário        |
| senha    | texto |     sim     | o valor deve ter no minimo 8 digitos |

**Exemplo corpo requisição**

```js
{

 nome:  "Igor Camargo",
 email: "igor.cammargo@gmail.com",
 cpf:   "44877544550",
 senha: "123",
 avatar:"path/arquivo.png"
}
```

**Códigos de Respostas**

| código | descrição                                                 |
| ------ | --------------------------------------------------------- |
| 201    | Usuário criado com sucesso                                |
| 404    | Campos inválidos                                          |
| 409    | Conflict - Já existe um usuário com o mesmo email         |
| 500    | Ocorreu um erro interno enquanto processava a solicitação |
### Editar usuarios

`PUT` /mypet/api/usuarios/{id}

**Campos da Requisição**

|   campo  | tipo  | obrigatório | descrição                            |
| -------- | ----- | :---------: | ------------------------------------ |
| email    | texto |     sim     | E-mail do usuário                    |
| telefone | texto |     sim     | número de telefone do usuário        |
| senha    | texto |     sim     | o valor deve ter no minimo 8 digitos |

**Exemplo corpo requisição**

```js
{
 email: "igor.cammargo@gmail.com",
 senha: "123",
 avatar:"path/arquivo.png"
}
```

**Códigos de Respostas**

| código | descrição                                                 |
| ------ | --------------------------------------------------------- |
| 200    | Usuário atualizado com sucesso                            |
| 404    | O usuário não foi localizado                              |
| 500    | Ocorreu um erro interno enquanto processava a solicitação |


### Deletar usuarios

`DELETE` /mypet/api/usuarios/{id}

**Códigos de Respostas**

| código | descrição                                                 |
| ------ | --------------------------------------------------------- |
| 200    | Usuário removido com sucesso                              |
| 404    | O usuário não foi localizado                              |
| 500    | Ocorreu um erro interno enquanto processava a solicitação |

### Listar usuarios

`GET` /mypet/api/usuarios

**Exemplo corpo requisição**

```js
{

 nome:  "Igor Camargo",
 email: "igor.cammargo@gmail.com",
 cpf:   "44877544550",
 senha: "12345678",
 avatar:"path/arquivo.png"
},
{
    nome:  "Raphael Serrano",
    email: "rapha.serrano@gmail.com",
    cpf:   "451225",
    senha: "87654321",
    avatar:"path/arquivo.png"
}
```

**Códigos de Respostas**

| código | descrição                                                 |
| ------ | --------------------------------------------------------- |
| 200    | Retorna uma lista de todos usuários                       |
| 404    | A lista de usuários não foi localizada                    |
| 500    | Ocorreu um erro interno enquanto processava a solicitação |

<br>

---

## Pagamentos

### Cadastrasr pagamentos


`POST` mypet/api/pagamentos

**Campos da Requisição**

|   campo          | tipo  | obrigatório | descrição                            |
| ---------------- | ----- | :---------: | ------------------------------------ |
| tp_pagamento     | texto |     sim     | Qual o meio de pagamento             |
| tp_cartao        | texto |     não     | bandeira do cartão usado             |


**Exemplo corpo requisição**

```js
{
    tp_pagamento:"cartão de débito",
    tp_cartao:"visa"
}

```

**Códigos de Respostas**

| código | descrição                                                 |
| ------ | --------------------------------------------------------- |
| 201    | Pagamento criado com sucesso                              |
| 404    | Campos inválidos                                          |
| 409    | Conflict - Já existe um pagamento com o mesmo nome        |
| 500    | Ocorreu um erro interno enquanto processava a solicitação |

### Editar pagamentos

`PUT` mypet/api/pagamentos/{id}

**Campos da Requisição**

|   campo          | tipo  | obrigatório | descrição                            |
| ---------------- | ----- | :---------: | ------------------------------------ |
| tp_pagamento     | texto |     sim     | Qual o meio de pagamento             |
| tp_cartao        | texto |     não     | bandeira do cartão usado             |

**Exemplo corpo requisição**

```js
{
    tp_pagamento:"pix",
    tp_cartao:""
}

```

**Códigos de Repostas**

| código | descrição                                                 |
| ------ | --------------------------------------------------------- |
| 200    | Pagamento atualizado com sucesso                          |
| 404    | O tipo de pagamento não foi localizado                    |
| 500    | Ocorreu um erro interno enquanto processava a solicitação |

## Deletar pagamentos

`DELETE` /mypet/api/pagamentos/{id}

**Códigos de Respostas**

| código | descrição                                                 |
| ------ | --------------------------------------------------------- |
| 200    | Tipo de pagamento removido com sucesso                    |
| 404    | O tipo de pagamento não foi localizado                    |
| 500    | Ocorreu um erro interno enquanto processava a solicitação |

### Listar pagamento

`GET` mypet/api/pagamentos

**Exemplo corpo requisição**

```js
{
    tp_pagamento:"cartão de débito",
    tp_cartao:"visa"
},
{
    tp_pagamento:"pix",
    tp_cartao:""
},
{
    tp_pagamento:"dinheiro",
    tp_cartao:""
}
```

**Códigos de Respostas**

| código | descrição                                                 |
| ------ | --------------------------------------------------------- |
| 200    | Retorna uma lista de todos os tipos de pagamento          |
| 404    | A lista de pagamento não foi localizada                   |
| 500    | Ocorreu um erro interno enquanto processava a solicitação |

---
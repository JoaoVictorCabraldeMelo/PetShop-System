# Aplicacao Teste Spring sobre Sistema de Petshop 

- O que foi feito ate agora:

[X] Dockerizacao do sistema
[X] Modelo do Banco Completo
[X] Autorizacao JWT
[X] Autorizacao Baseado em Cargo no sistem

- O que foi planejado e nao foi feito:

[] Todos os endpoints para fazer CRUD de cada registro endpoints para editar, criar, mostrar e deletar cada entidade no sistema.
[] Colocar o swagger para fazer documentacao da API e o teste de endpoints
[] Fazer o ambiente de teste para fazer os testes de unidades provavelmente vai ter que mecher no docker-compose adicionando outro servico para h2 ja que imagino que ficar fazendo teste com banco de dados que usa o disco seja muito lento
[] Mostrar metricas da API com actuator nao mechi nele ainda apesar que o docker ja ta fazendo healthcheck com ele.

- Possivei melhorias ja anotadas mover algumas variaveis sensiveis para .env como tambem utilizacao de mappers para serializacao mais rapida de objetos.

## Como rodar 

Verifique que seu docker esteja instalado e atualizado no sistema este comando deve startar dois services um para o postgres outro para spring para fazer o build do sistema e para controlar as dependencias foi utilizado o maven perceba que no dockerfile 
tambem utiliza de multistaging build nao so para aumentar a velocidade do build quando de se muda os volumes mas tambem para diminuir um pouco a imagem do java que eh bastante pesada

```bash
docker-compose up --build
```

Para os testes do endpoints utilizei Postman e para verificacao da insercao no banco utilizei o Dbeaver.


# Documentacao dos endpoints ate agora

- /api/v1/admin -> eh protegido para apenas usuarios com o cargo admin caso queira acessa-lo faca signIn antes

- api/v1/auth/sign -> este eh o endpoint de login caso queira logar sem criar um usuario voce pode usar um usuario que ja vem cadastrado no banco quando inicilizado o corpo do request deve ser esse:

```json
{
    "cpf": "333.333-33",
    "password": "admin"
}
```

Voce deve receber um resposta assim 

```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJVU0VSIl0sInN1YiI6IjA2NS44NDUuMzYxLTA2IiwiaWF0IjoxNjgyNTMyMzI0LCJleHAiOjE2ODI1MzM3NjR9.6vsuxW9GRFCuRdMhqNwLUMXFfDTGHTwG9AAwM68-oGM"
}
```


Este corpo deve conter cpf e password sempre nao ha validacao nem para cpf e nem para password ainda.

- api/v1/auth/signup -> este eh o endpoint de criar um usuario no sistem para utiliza-lo crie uma requesicao com o seguinte corpo como exemplo:

```json
{
    "name": "joao victor",
    "cpf": "065.845.361-06",
    "password": "1234"
}
```

Voce deve receber seu token desta forma:

```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJVU0VSIl0sInN1YiI6IjA2NS44NDUuMzYxLTA2IiwiaWF0IjoxNjgyNTMyMzI0LCJleHAiOjE2ODI1MzM3NjR9.6vsuxW9GRFCuRdMhqNwLUMXFfDTGHTwG9AAwM68-oGM"
}
```

Todo novo usuario criado no sistema e assumido que seu cargo padrao eh o de usuario normal ou seja nenhum usuario novo no sistema tem o cargo de ADMIN apenas o criado quando a aplicacao comeca a rodar.

- api/v1/admin/users -> Eh um endpoint apenas para admins que lista todos os usuarios este endpoint ainda esta em WIP ou seja esta em construcao junto com os outros endpoints de crud do sistema o corpo de retorno deve ser algo assim:

```json 
{
[
    {
        "name": "admin",
        "cpf": "333.333-33",
        "roles": [
            "ADMIN"
        ],
        "client": {
            "address": {
                "logradouro": "Quadra",
                "cidade": "Guara",
                "bairro": "Brasilia",
                "complemento": "Casa",
                "tag": null
            },
            "name": "Chefinho",
            "regisDate": "2023-04-26T18:04:03.673+00:00",
            "contact": null
        }
    },
    {
        "name": "joao victor",
        "cpf": "065.845.361-06",
        "roles": [
            "USER"
        ],
        "client": {
            "address": null,
            "name": "joao victor",
            "regisDate": "2023-04-26T18:05:24.471+00:00",
            "contact": null
        }
    }
]
}
```
<h1>API REST</h1>

Projeto desenvolvido para a disciplina de Programação Orientada a Objetos para Web II.

O projeto foi desenvolvido na IDE Eclipse. 
Para testar as funcionalidades, é necessário utilizar o programa Postman.

<h2>Sugestões</h2>
  Comandos para testar a API:
  
 ```json
Para cadastrar uma nova cidade
Método: POST
Informar a url ao programa Postman: http://localhost:8080/cidades
Na sessão body digitar:
{
    "nome": "Jaguari",
    "cep": "111111-00"
}

Para atualizar o cadastro de uma cidade
Método: PUT
Informar a url: http://localhost:8080/cidades/1
{
    "nome": "Rosário do Sul",
    "cep": "222222-00"
}

Listar todas as cidades
Método: GET
Informar a url: http://localhost:8080/cidades/

Listar uma cidade especifica
Método: GET
Informar a URL: http://localhost:8080/cidades/1

Excluir uma cidade
Método: DELETE
Informar a url: http://localhost:8080/cidades/1
OBS: não é possível excluir uma cidade, se há fazendas cadastradas naquela cidade
 
OBS: Para cadastrar uma nova fazenda é necessário que a cidade já esteja cadastrada no banco de dados
Método: POST
Informar a url: http://localhost:8080/fazendas
Na sessão body digitar:
{
    "proprietario": "Fulano de Tal", 
    "hectares": "35 ha", 
    "descricao": "Fazenda para plantio de soja",
    "cidade": "Santa Maria"
}

Para atualizar as informações da fazenda
Método: PUT
Informar a url: http://localhost:8080/fazendas/1
Na sessão body digitar:
{
    "proprietario": "Beltrano",
    "hectares": "50 ha",
    "descricao": "Fazenda para plantio de arroz"
}

Listar todas as fazendas da api
Método: GET
Informar a url: http://localhost:8080/fazendas

Listar todas as fazendas de uma cidade
Método: GET
Informar a url: http://localhost:8080/fazendas?nomeCidade=São Vicente do Sul
Na área de params digitar: nomeCidade
Na área VALUE digitar uma cidade que já esteja cadastrada no banco de dados

Listar uma fazenda especifica
Método: GET
Informar a url: http://localhost:8080/fazendas/1

Excluir uma fazenda
Método: DELETE
Informar a url: http://localhost:8080/fazendas/1


# Teste Vertex: Desenvolvedor Mobile Kotlin #

Desenvolver um aplicativo mobile

## Instruções

* Realizar um fork desse repositório na sua conta pessoal do GitHub, ou BitBucket.
* Siga as especificações abaixo.
* Crie um README com as instruções para compilar, testar e rodar o projeto.
* O link do repositório deverá ser enviado para o e-mail **r.madeira@vertexdigital.co** com o título **Teste Desenvolvedor Mobile**

## Especificações técnicas

* Utilizar a [API de busca do YouTube](https://developers.google.com/youtube/v3/docs/)
* Utilizar Android Studio
* Linguagem Kotlin

## Especificações funcionais

### Tela Inicial

Essa tela terá um campo texto de busca, centralizado verticalmente, com placeholder "Pesquisar" e um botão "Buscar", ao lado do campo "Pesquisar"

Esse formulário deverá ter validação pra não permitir chamadas de termos em branco ou contendo menos do que 3 caracteres.

Essa busca deverá chamar a url https://www.googleapis.com/youtube/v3/search?type=video&part=id,snippet&q={termo_de_busca}&key={API_KEY}

### Tela de Resultados

Os resultados da busca do termo inserido pelo usuário deverão ser exibidos como uma lista em uma nova tela, contendo no máximo 10 resultados.

Cada resultado deve conter os campos título, descrição, thumbnail e um botão para a página de detalhes.

Não é necessário fazer a paginação do retorno.

### Tela de resultados

A partir do videoId retornado em cada resultado da busca anterior, deve ser feito uma chamada para https://www.googleapis.com/youtube/v3/videos?id={VIDEO_ID}&part=snippet,statistics&key={API_KEY}

A partir desse retorno, deve-se montar uma tela contendo embed do video, título, descrição e visualizações.

Essa tela deve ter um botão para voltar, exibindo os últimos resultados da busca com a página em questão ativa.


## O que será avaliado?
- Organização do projeto
- Lógica do código
- Uso do Git


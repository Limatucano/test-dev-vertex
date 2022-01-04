# Teste Vertex: Desenvolvedor(a) Mobile Kotlin



## Instruções para compilar, testar e rodar o projeto

---

### Pré requisitos

- Para conseguir usar o aplicativo é necessário criar o projeto no google cloud platform

- **para isso clique em criar projeto![](https://lh6.googleusercontent.com/uCx1fuvpyF94R5KTUICBCrOwbPZPgiF8KiuAwTiW-dLazc9dOQojBdCZLGfjVvrMxas2QtvUXIeTfpacAOPDY1KDT3uDkE16vjCO-sdI0hEu2UIoY0wqftoWXHB8HyYWUznAeohX)**

- **insira o nome desejado![](https://lh6.googleusercontent.com/ZULviUZtP7au69El_bqjfv3l2spSr5PYJd6CSz8fcx4SMxx0BXYzRZ3hdGifQ4zAnk9APRz0QSZGDxwU6srhJnpS0U4NYFpc6Xb30JA5CVDYcVuWKUDhLRNxysFxeXOBWEQP14_0)**

- **Crie uma chave de API![](https://lh5.googleusercontent.com/7-lf1jjWVV986fFZEUSvbaWib71LzvtJKfXH1QCEUsXpwjtu3IvJENXjrDtSqb_BooBgqRQgflkIHGp7UtpnYYuAKEqr96t8qT06dpBeZzdfCbwTzibjRWXkX3dDFqUGIW3Kwyn0)**

- Reserve essa chave, será usada no nosso aplicativo

- Habilite a API do youtube

### Compilar

- Baixe o [repositorio]([GitHub - Limatucano/test-dev-vertex](https://github.com/Limatucano/test-dev-vertex))

- Abra a pasta vertexApp no android studio

- Vá em gradle.properties e crie a chave API_KEY e coloque a chave que foi criada no google cloud plataform, deve ficar assim API_KEY="suaChaveAqui"



### Testar e rodar o projeto

- Após realizar os passos acima, já é possível realizar o build e testar o aplicativo, eu recomendo que utilize um dispositivo físico para testar.

- Selecione o dispositivo físico 

- Clique em Run 'app' na parte superior do android studio ou aperte Shift + F10

- pronto, já é possível testar e utilizar o aplicativo!



### Resultado



## Instruções de desenvolvimento

---



* Realizar um fork desse repositório na sua conta pessoal do GitHub, ou BitBucket.
* Siga as especificações abaixo.
* Crie um README com as instruções para compilar, testar e rodar o projeto.
* O link do repositório deverá ser enviado para o e-mail **r.madeira@vertexdigital.co** com o título **Teste Desenvolvimento Mobile**

## Especificações técnicas

* Utilizar a [API de busca do YouTube](https://developers.google.com/youtube/v3/docs/)
* Utilizar Android Studio
* Linguagem Kotlin

## Especificações funcionais

### **Tela Inicial**

---

Essa tela terá um campo texto de busca, centralizado verticalmente, com placeholder "Pesquisar" e um botão "Buscar", ao lado do campo "Pesquisar"

Esse formulário deverá ter validação pra não permitir chamadas de termos em branco ou contendo menos do que 3 caracteres.

Essa busca deverá chamar a url https://www.googleapis.com/youtube/v3/search?type=video&part=id,snippet&q={termo_de_busca}&key={API_KEY}

### **Tela de Resultados**

---

Os resultados da busca do termo inserido pelo usuário deverão ser exibidos como uma lista em uma nova tela, contendo no máximo 10 resultados.

Cada resultado deve conter os campos título, descrição, thumbnail e um botão para a página de detalhes.

Não é necessário fazer a paginação do retorno.

### **Tela de resultados**

---

A partir do videoId retornado em cada resultado da busca anterior, deve ser feito uma chamada para https://www.googleapis.com/youtube/v3/videos?id={VIDEO_ID}&part=snippet,statistics&key={API_KEY}

A partir desse retorno, devesse montar uma tela contendo embed do video, título, descrição e visualizações.

Essa tela deve ter um botão para voltar, exibindo os resultados da busca.

## O que será avaliado?

* Comportamento em diferentes orientações do aparelho
* Uso de boas práticas de desenvolvimento Kotlin e Android Studio
* Organização do projeto
* Lógica do código
* Uso do Git

### Dúvidas

* Entrar em contato através do email r.madeira@vertexdigital.co

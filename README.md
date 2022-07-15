# PedroNeryCase

Neste projeto pessoal eu coloco algumas das melhores práticas de arquitetura e ferramentas que conheço.
Ainda está incompleto e com features faltando, mas caso queira testar, basta adicionar a sua api key do OMDB no arquivo keystore.properties.

## Arquitetura

Este projeto foi desenvolvido tendo como base o MVVM, mas incluindo conceitos de Clean Architecture e MVI.
As camadas são divididas em View -> ViewModel -> UseCase -> Repository -> DataSource -> Service.
1. A View não deve conter nenhuma lógica, cabendo a ela apenas apresentar os dados
2. O ViewModel tem como única responsabilidade receber os dados, e interpretar eles, notificando a View qual deve ser o comportamento. A notificação acontece por meio dos atributos State e Action, que centralizam todas os estados e ações das telas.
3. O UseCase deve conter todo o tipo de regra de negócio da aplicação.
4. O Repositório deve conter todo tipo de regra técnica da aplicação, e o conhecimento se o dado deve ser buscado localmente ou remotamente.
5. O DataSource não deve conter lógica, e deve conhecer exatamente onde a informação requisitada deve ser buscada(Em qual serviço, por exemplo).
 
## Ferramentas

As principais ferramentas utilizadas neste projeto são: LiveData, Coroutines, Flow, Koin, MockK e Retrofit.

## Modularização

Este projeto é dividido entre módulos, são eles:
1. app - Responsável pela tela inicial do app, e pela classe Application.
2. common - Responsável pelas implementações e models comuns e necessários em todo o projeto.
3. test - Responsável pelas implementações necessárias para realizar testes automatizados.
4. navigation - Responsável por conter as interfaces de navegação de todo o app. Deve existir uma interface para cada feature do projeto, mas caso não seja necessário, a navegação entre módulos pode ser feita diretamente.
5. moviedetail/movielist - São os módulos de feature. Não necessariamente toda tela precisa ter um módulo, os módulos podem agrupar diversas telas dependendo da lógica de negócio. Neste projeto estas telas estão separadas apenas para exemplificar.
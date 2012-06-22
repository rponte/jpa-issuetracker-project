JPA Issue Tracker Project
=========================

Projeto simples de uma aplicação de Issue Tracker modelada com `Hibernate 3.6.x (JPA2)` e `Spring 3.x` com o objetivo de explanar as principais features de cada tecnologia e como integra-las de maneira produtiva em um projeto real. O projeto é construído durante os cursos e treinamentos de **Spring e Hibernate** ministrados pela [TriadWorks](http://www.triadworks.com.br).

Caso tenha interesse ou alguma dúvida nos nossos cursos e treinamentos, por favor, [deixe-nos saber](http://www.triadworks.com.br/contatos.html).

Configurando o projeto e banco de dados.
----------------------------------------

Por padrão o projeto está configurado para o banco de dados `PostgreSQL`, mas já que se trata de uma aplicação com `Hibernate`, você pode simplesmente configura-lo para trabalhar com qualquer outro banco.

Os passos básicos são:

1. Importe o projeto no [Eclipse Java EE IDE for Web Developers (Indigo)](http://www.eclipse.org/downloads/) ou superior; 
2. Adicione o JDBC Driver no diretório `/lib/jdbc-drivers` (e ao classpath) caso não pretenda utilizar o `PostgreSQL`;
3. Configure as informações do banco no arquivo `src/jdbc.properties`;
4. Crie o banco de dados `issuetracker_jpa` com a ferramenta de sua preferência (como o `PGAdmin`, no caso do `PostgreSQL`);
5. Execute a classe `br.com...spring.ExecutaImportacaoDeUsuarios.java`;
6. Verifique se alguns usuários foram inseridos corretamente na tabela `USUARIO`;

Informações adicionais
------------------------

* O schema do banco de dados, `issuetracker_jpa`, será criado pelo `Hibernate` ao executar a classe `ExecutaImportacaoDeUsuarios.java` pela primeira vez;
* Dentro do diretório `/lib` você encontra todas as libs e dependências organizadas de cada framework;
* Dentro do diretório `/lib/jdbc-drivers` é possível encontrar alguns drivers já disponíveis, como `PostgreSQL` e `Oracle`;

Mais informações
----------------

**TriadWorks**
- http://www.triadworks.com.br
- http://www.triadworks.com.br/servico.html

**Rafael Ponte**
- Meu [blog](http://www.rponte.com.br)
- Meu Twitter [@rponte](http://twitter.com/#!/rponte)

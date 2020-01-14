# Formulario
Sistema que simula um cadastro de usuários

O sistema possui duas páginas:
- a primeira é onde o usuário insere os dados solicitados no formulário e permite salvar ou limpar os dados da tela;
- a segunda permite o usuário realizar uma busca no banco de dados, inserindo o nome de um usuário já cadastrado.

As páginas do sistema foi feita em JavaServer Faces **(A)**, onde os dados digitados nos campos do formulário são persistidos no banco de dados PostgreSQL **(B)**, utilizando JPA e Hibernate **(C)**. Foi utilizado componentes do PrimeFaces **(G)** e para testar os métodos de  salvar, atualizar, deletar e buscar usuários foi feito testes com JUnit **(H)**.

Para o desenvolvimento do projeto foi utilizado a IDE eclipse (kepler), pgAdmin III, Apache Tomcat 7 e o navegador Chrome para rodar a aplicação.

Instruções para rodar o projeto:
- Importar *Maven Project*;
- Nas *Properties* do projeto, adicionar ao *Project Facets* o *Dynamic Web Module, Java, JavaScript, JavaServer Faces* e o *JPA*;
- Ainda nas *Properties*, verificar nas *Deployment Assembly*, se as *Maven Dependencies* estão adicionadas;
- Criar um novo *Database*, onde ficará armazenado os dados (no projeto foi criado um banco com o nome "formulario");
- Configurar o hibernate no arquivo *persistence.xml* (verificar url, username, password e nome do banco).
- Adicionar projeto no servidor.

**VISUALIZAÇÃO DAS TELAS:**

![cadastro formulario](https://user-images.githubusercontent.com/38672183/72311409-55f4f300-3663-11ea-8ba3-4112de698bc6.png)

![cadastro table](https://user-images.githubusercontent.com/38672183/72311410-59887a00-3663-11ea-84b8-d35700b75859.png)

![pesquisar](https://user-images.githubusercontent.com/38672183/72311415-5c836a80-3663-11ea-87b4-f429626e57e2.png)

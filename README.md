## Requerimentos

- S.O de criação (Windows 10 - 64 bits)
- [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Git](https://git-scm.com/)
- [Cucumber](https://cucumber.io/)
- [Junit](https://junit.org/junit4/)
- [Lombok](https://projectlombok.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [H2](https://www.h2database.com/html/main.html)
- [Hibernate](https://hibernate.org/)
- [Visual studio code](https://code.visualstudio.com/)
- [Eclipse](https://www.eclipse.org/downloads/)
- [Plugin Cucumber Eclipse](https://marketplace.eclipse.org/content/cucumber-eclipse-plugin)
- [Plugin Cucumber visual studio code](https://marketplace.visualstudio.com/items?itemName=alexkrechik.cucumberautocomplete)

## Configuração e execução
1) Clonar o projeto
```sh
$ git clone https://github.com/FabioKnuppVaz/calculadora.git
```
2) Gerar os arquivos binarios
```sh
$ mvn compile
```
3) Verificar aplicação
```sh
mvn spring-boot:run
```
4) Finalizar execução da aplicação no console
```sh
$ ctrl c
```
5) Executar todos os testes
```sh
$ mvn test
```
5) Executar um teste especifico em junit
```sh
$ mvn test -Dtest=unitTestName
```
5) Executar um teste especifico em cucumber
```sh
$ mvn test -Dcucumber.options="--tags @tagName"
```
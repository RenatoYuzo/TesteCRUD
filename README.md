# TesteCRUD

Foi implementado uma aplicação Spring, usando o banco de dados PostgreSQL com conexão básico de JDBC. Os scripts SQL estão na raiz do projeto.

# Para executar o programa.

Abra o no diretório do JAR e execute:
````
$ java -jar TesteCRUD.jar
````

# Lista de end-points
### Requisições GET
+ http://localhost:8080/testecrud/produtos/nome
+ http://localhost:8080/testecrud/produtos/quantidade
+ http://localhost:8080/testecrud/produtos/maior-menor
+ http://localhost:8080/testecrud/produtos/categoria/{categoria_id}

### Requisições DELETE
+ http://localhost:8080/testecrud/produtos/delete/{id}

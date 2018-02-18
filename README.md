# Virtual Sistemas
Descrição do problema<br/>
Cenário:
Temos uma entidade Produto com relação Many to One com a entidade Categoria(Vários produtos para a mesma categoria).
Temos uma entidade Categoria com relação Many to One com ela mesma(Várias categorias para uma mesma categoria pai).

1º Construa um webservice Restful usando JAX-RS  para realizar operações de inserção,atualização e remoção para as entidades Produto e Categoria.

2º As seguintes operações devem ser realizadas:

1) Inserir, atualizar e deletar Categoria
2) Inserir, atualizar e deletar Produtos
3) Obter todos os produtos  
4) Obter todos os produtos com suas respectivas categorias
5) Obter produto pelo codigo
6) Obter produto com sua respectiva categoria pelo código do produto
7) Obter todas as categorias filhas de uma determinada categoria

# Documentação
A documentação da APi pode ser encontrada [Aqui](https://documenter.getpostman.com/view/2133831/virtualsistemas/RVfyAUpQ#cfea8481-6080-40cb-efb6-b86400a5b660)

# Execução
1. Clone o repositório</br>
2. Execute <code>mvn spring-boot:run</code>
3. Pronto! A aplicação estará disponível em http://localhost:8089/virtual-sistemas-api

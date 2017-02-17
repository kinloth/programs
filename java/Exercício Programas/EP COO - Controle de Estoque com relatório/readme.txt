 _____                _ __  __      
|  __ \              | |  \/  |     
| |__) |___  __ _  __| | \  / | ___ 
|  _  // _ \/ _` |/ _` | |\/| |/ _ \
| | \ \  __/ (_| | (_| | |  | |  __/
|_|  \_\___|\__,_|\__,_|_|  |_|\___|

/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/
@author Daniel Augusto de Melo Moreira - NUSP 8122477
@author Felipe Brigatto - NUSP 7972602
@author Jose Roberto Ventaja - NUSP 7972290
@author Marcelo Werneck - NUSP 8061963

- Aplicativo de venda de livros para livraria -

Executar o arquivo "Aplicativo.java".

1. Instruções de utilização:

	(a) Cadastro de cliente
		a.1 - Clique no botão "Cadastra Cliente".
		a.2 - Insira o nome completo do cliente e aperte "OK".
		a.3 - Digite o número do cartão de crédito do cliente.
		a.4 - Cadastro concluido com sucesso, aperte "OK".

	(b) Cadastro de produto
		b.1 - Clique no botão "Cadastra Produto".
		b.2 - Insira o nome do livro a ser inserido e aperte "OK".
		b.3 - Insira o nome do autor do livro e aperte "OK".
		b.4 - Insira o nome da editora do livro e aperte "OK".
		b.5 - Insira o preço do livro (utilize "." (ponto) e não "," (vírgula) para os centésimos) e aperte "OK".
		b.6 - Insira a quantidade de unidades do livro em estoque e aperte "OK".
		b.7 - Cadastro concluido com sucesso, aperte "OK".

	(c) Realizar venda
		c.1 - Clique no botão "Venda".
		c.2 - Clique em "Codigo" para escolher cliente pelo código ou "Nome" para escolher o cliente pelo nome.
		c.3 - Caso tenha escolhido "Codigo", insira o código do cliente e aperte "OK". Caso contrário, insira o nome do cliente e aperte "OK".

		c.4.1 - [Adicionar produto ao carrinho]
			c.4.1.1 - Clique no botão "Adicionar Produto".
			c.4.1.2 - Insira o código do produto ou o título do produto após clicar no botão "Codigo" ou no botão "Titulo", respectivamente, e o produto estará no carrinho.

		c.4.2 - [Remover produto do carrinho]
			c.4.2.1 - Clique no botão "Remover Produto"
			c.4.2.2 - Insira o código do produto ou o título do produto a ser removido após clicar no botão "Codigo" ou no botão "Titulo", respectivamente, e o produto será removido do carrinho.

		c.4.3 - [Imprimir carrinho]
			c.4.3.1 - Clique em "Imprimir Carrinho" para que seja impresso no Prompt de Comando o carrinho de compras do cliente da venda atual.

		c.4.4 - [Concluir Compra]
			c.4.4.1 - Após inserir o produto desejado pelo cliente no carrinho, clique no botão "Concluir Compra", aperte OK e confira os produtos vendidos ao cliente no Prompt de Comando.

		c.4.5 - [Voltar]
			c.4.5.1 - Clique no botão "Voltar" para cancelar venda e voltar ao menu principal.

	(d) Gerar Relatório
		d.1 - Clique no botão "Gerar Relatório".
		d.2 - Aparecerá no prompt de comando o relatório das vendas, com o nome e código do cliente para o qual foi feito a venda, o código e o título do produto vendido, com autor, editora, preço e quantidade adquirida do produto.

	(e) Atualizar Cliente
		e.1 - Clique no botão "Atualiza Cliente".
		e.2 - Insira o código ou nome do cliente após clicar no botão "Codigo" ou no botão "Nome", respectivamente.
		e.3 - Aparecerão na tela os dados do cliente, clique no botão referente ao campo que deseja-se atualizar (nome ou número do cartão), insira o novo dado e aperte "OK".
		e.4 - Campo atualizado.
		e.5 - Clique em "Concluir".

	(f) Atualizar Produto
		f.1 - Clique no botão "Atualiza Produto".
		f.2 - Insira o código ou título do produto após clicar no botão "Codigo" ou no botão "Titulo", respectivamente.
		f.3 - Aparecerão na tela os dados do produto, clique no botão referente ao campo que deseja-se atualizar (título, autor, editora ou preço), insira o novo dado e aperte "OK".
		f.4 - Campo atualizado.
		f.5 - Clique em "Concluir".
	
2. Abrir documentação
	
	(a) Aplicativo.java
		Para abrir a documentação da classe "Aplicativo" acesse a pasta "Documentacao\AplicativoDOC" e abra o arquivo "index.html".
	(b) Produto.java
		Para abrir a documentação da classe "Produto" acesse a pasta "Documentacao\ProdutoDOC" e abra o arquivo "index.html".
	(c) Cliente.java
		Para abrir a documentação da classe "Cliente" acesse a pasta "Documentacao\ClienteDOC" e abra o arquivo "index.html".

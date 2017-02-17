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

1. Instru��es de utiliza��o:

	(a) Cadastro de cliente
		a.1 - Clique no bot�o "Cadastra Cliente".
		a.2 - Insira o nome completo do cliente e aperte "OK".
		a.3 - Digite o n�mero do cart�o de cr�dito do cliente.
		a.4 - Cadastro concluido com sucesso, aperte "OK".

	(b) Cadastro de produto
		b.1 - Clique no bot�o "Cadastra Produto".
		b.2 - Insira o nome do livro a ser inserido e aperte "OK".
		b.3 - Insira o nome do autor do livro e aperte "OK".
		b.4 - Insira o nome da editora do livro e aperte "OK".
		b.5 - Insira o pre�o do livro (utilize "." (ponto) e n�o "," (v�rgula) para os cent�simos) e aperte "OK".
		b.6 - Insira a quantidade de unidades do livro em estoque e aperte "OK".
		b.7 - Cadastro concluido com sucesso, aperte "OK".

	(c) Realizar venda
		c.1 - Clique no bot�o "Venda".
		c.2 - Clique em "Codigo" para escolher cliente pelo c�digo ou "Nome" para escolher o cliente pelo nome.
		c.3 - Caso tenha escolhido "Codigo", insira o c�digo do cliente e aperte "OK". Caso contr�rio, insira o nome do cliente e aperte "OK".

		c.4.1 - [Adicionar produto ao carrinho]
			c.4.1.1 - Clique no bot�o "Adicionar Produto".
			c.4.1.2 - Insira o c�digo do produto ou o t�tulo do produto ap�s clicar no bot�o "Codigo" ou no bot�o "Titulo", respectivamente, e o produto estar� no carrinho.

		c.4.2 - [Remover produto do carrinho]
			c.4.2.1 - Clique no bot�o "Remover Produto"
			c.4.2.2 - Insira o c�digo do produto ou o t�tulo do produto a ser removido ap�s clicar no bot�o "Codigo" ou no bot�o "Titulo", respectivamente, e o produto ser� removido do carrinho.

		c.4.3 - [Imprimir carrinho]
			c.4.3.1 - Clique em "Imprimir Carrinho" para que seja impresso no Prompt de Comando o carrinho de compras do cliente da venda atual.

		c.4.4 - [Concluir Compra]
			c.4.4.1 - Ap�s inserir o produto desejado pelo cliente no carrinho, clique no bot�o "Concluir Compra", aperte OK e confira os produtos vendidos ao cliente no Prompt de Comando.

		c.4.5 - [Voltar]
			c.4.5.1 - Clique no bot�o "Voltar" para cancelar venda e voltar ao menu principal.

	(d) Gerar Relat�rio
		d.1 - Clique no bot�o "Gerar Relat�rio".
		d.2 - Aparecer� no prompt de comando o relat�rio das vendas, com o nome e c�digo do cliente para o qual foi feito a venda, o c�digo e o t�tulo do produto vendido, com autor, editora, pre�o e quantidade adquirida do produto.

	(e) Atualizar Cliente
		e.1 - Clique no bot�o "Atualiza Cliente".
		e.2 - Insira o c�digo ou nome do cliente ap�s clicar no bot�o "Codigo" ou no bot�o "Nome", respectivamente.
		e.3 - Aparecer�o na tela os dados do cliente, clique no bot�o referente ao campo que deseja-se atualizar (nome ou n�mero do cart�o), insira o novo dado e aperte "OK".
		e.4 - Campo atualizado.
		e.5 - Clique em "Concluir".

	(f) Atualizar Produto
		f.1 - Clique no bot�o "Atualiza Produto".
		f.2 - Insira o c�digo ou t�tulo do produto ap�s clicar no bot�o "Codigo" ou no bot�o "Titulo", respectivamente.
		f.3 - Aparecer�o na tela os dados do produto, clique no bot�o referente ao campo que deseja-se atualizar (t�tulo, autor, editora ou pre�o), insira o novo dado e aperte "OK".
		f.4 - Campo atualizado.
		f.5 - Clique em "Concluir".
	
2. Abrir documenta��o
	
	(a) Aplicativo.java
		Para abrir a documenta��o da classe "Aplicativo" acesse a pasta "Documentacao\AplicativoDOC" e abra o arquivo "index.html".
	(b) Produto.java
		Para abrir a documenta��o da classe "Produto" acesse a pasta "Documentacao\ProdutoDOC" e abra o arquivo "index.html".
	(c) Cliente.java
		Para abrir a documenta��o da classe "Cliente" acesse a pasta "Documentacao\ClienteDOC" e abra o arquivo "index.html".

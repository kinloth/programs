 _____                _ __  __      
|  __ \              | |  \/  |     
| |__) |___  __ _  __| | \  / | ___ 
|  _  // _ \/ _` |/ _` | |\/| |/ _ \
| | \ \  __/ (_| | (_| | |  | |  __/
|_|  \_\___|\__,_|\__,_|_|  |_|\___|

/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/
@autor  Daniel Augusto 	- NUSP 8122477
@autor	Felipe Brigatto	- NUSP 7972602 
@autor	Igor Borges	- NUSP 8122442
@autor	Marcelo Gaioso 	- NUSP 8061963

Arquivos:

	1. Main.java     	- Classe principal respons�vel pela execu��o do programa
	2. No.java       	- Classe que define um n�, inclui m�todos para seu gerenciamento
	3. Tempo.java  		- Respons�vel por marcar o tempo total para rodar uma parte do algoritmo
	4. Arquivo.java 	- Respons�vel por realizar a leitura e escrita nos arquivos(entrada e sa�da)
	5. FuncoesH.java 	- Define e distribui as heur�stica que deve ser rodado em cada inst�ncia
	6. BuscaStrategy.java	- (Padr�o de projeto Strategy) Interface ser implementada pelas buscas
	7. Busca%	 	- Classe respons�vel pela determinada busca (implementa Strategy)

Como Compilar e executar: 
			  
	Abrir a linha de comando e entrar com os seguintes comandos:
		  1. javac main.java
		  2. java main

Par�metros:
	
	1. O arquivo a ser lido deve ser do formato ".txt".
	2. O arquivo deve conter os seguintes par�metros na segunda linha: b, h*, n , max.
	2.1 O par�metro b � o algoritmo de busca que deve usar para rodar
	2.1.1 Os valores admitidos para as buscas s�o:

		1 -  Busca em Largura
		2 -  Busca em Profundidade
		3 -  Busca em Profundidade Iterativa
		4 -  Busca em Custo Uniforme
		5 -  Busca Gulosa
		6 -  Busca A*
	
	2.2 O parametro h define a heur�stica que ir� ser executada pelo algoritmo Guloso ou A*
	2.2.1 Os valores admitidos por esse par�metro s�o:
		
		1 - Heuristica 1 (custo m�nimo poss�vel)
		2 - Heuristica 2 (sem limite de pessoas para levar a lanterna)
		3 - Heuristica 3 (v�rias lanternas)
	
	2.3 O n corresponde ao n�mero de pessoas que ir�o ser lidos no arquivo
	2.3.1 Tem que ser um numero inteiro positivo
	2.3.2 N�o pode possuir um valor maior que a quantidade de elementos posteriormente apresentados
	2.3.3 Se possuir um valor menor, o resultado pode n�o ser o esperado, pois o programa ler� menos valores
	2.4 O valor max serve para definir um valor m�ximo que a busca deve ser rodada ou n�vel m�ximo para ser atingido.
	
	3. Em seguida, deve-se apresentar, por linhas ou espa�os, os custos correspondentes de tamanho n, definido anteriormente
	4. A primeira linha do programa pode ser usado para colocar qualquer coisa j� que ela � ignorada pelo algoritmo.

	*O par�metro h s� � necess�rio caso o algoritmo seja guloso(5) ou A*(6), i.e. busca informada.
	

Observa��es:
	
	O programa retorna "Solu��o n�o encontrada" caso n�o tenha sido poss�vel achar o valor dentro do max estabelecido.
	O programa escreve o valor tanto no arquivo "saida.txt" quanto no console de onde foi executado.
	
Mais detalhes sobre a implementa��o, vide Relat�rio.
#include <stdio.h>
#include <stdlib.h> 

//dimensao da matriz
int m, n;

/* metodo utilizado para limpar buffer do teclado*/
void clear(){
	while(getchar() != '\n');
}

/* apenas para dar uma pausa e melhor identificacao da execucao*/
void continuar(){
	printf("------------------------------------------\n");
	printf("Aperte enter para continuar\n");
	clear();
    system("clear"); 
}

/* inicializa a matriz com valores nulos */
void inicializaMatriz(int matriz[m][n]){
	int i, j;
	for (i = 0; i < m; i++)
		for (j = 0; j < n; j++)
			matriz[i][j] = 0;
}

/* metodo que imprime a matriz passada como parametro*/
void imprimeMatriz(int matriz[m][n]){
	int i, j;
	char a;
	printf("Imprimindo a matriz de ordem %dx%d:\n",m,n);
	for (i = 0; i < m; i++){
		for (j = 0; j < n; j++)
			printf("%d\t",matriz[i][j]);
		printf("\n");
	}
}

/* metodo que recebe como parametro uma matriz
*  e adiciona os elementos lidos do teclado */
void preencheMatriz(int matriz[m][n]){
	printf("Por favor preencha a matriz de ordem %dx%d:\n",m,n);
	int elemento, i , j; 
	for (i = 0; i < m; i++)
		for (j = 0; j < n; j++){
			scanf("%d",&elemento);
			matriz[i][j] = elemento;
		}
	getchar();
	printf("\nA matriz foi preenchida\n");
}

/* metodo que recebe uma matriz como parametro
*  e soma com os elementos de uma outra matriz */
void somaMatriz(int matriz[m][n]){
	int i,j,matriz_soma[m][n];
	printf("Preencha a matriz %dx%d que deseja somar\n",m,n);
	preencheMatriz(matriz_soma);

	printf("\nA soma é :\n\n");
	for (i = 0; i < m; i++){
		for (j = 0; j < n; j++)
			printf("%d  ",matriz[i][j]);
		printf(" | ");
		for (j = 0; j < n; j++)
			printf("%d  ",matriz_soma[i][j]);		
		printf(" =  ");		
		for (j = 0; j < n; j++)
			printf("%d  ",matriz[i][j]+matriz_soma[i][j]);		
		printf("\n");
	}
}

/* metodo que recebe uma matriz como parametro
*  e subtrai com os elementos de uma outra matriz */
void subMatriz(int matriz[m][n]){
	int i,j,matriz_sub[m][n];
	printf("Preencha a matriz %dx%d que deseja subrair\n",m,n);
	preencheMatriz(matriz_sub);

	printf("\nA subtração é :\n\n");
	for (i = 0; i < m; i++){
		for (j = 0; j < n; j++)
			printf("%d  ",matriz[i][j]);
		printf(" | ");
		for (j = 0; j < n; j++)
			printf("%d  ",matriz_sub[i][j]);
		printf(" =  ");
		for (j = 0; j < n; j++)
			printf("%d  ",matriz[i][j]-matriz_sub[i][j]);
		printf("\n");
	}
}

/* metodo que recebe uma matriz como parametro
*  e multiplica com os elementos de uma outra matriz */
void multMatriz(int matriz[m][n]){
	int i,j,aux,matriz_mult[n][m], matriz_result[m][m], soma = 0;
	printf("Preencha a matriz %dx%d que deseja multiplicar\n",n,m);
	preencheMatriz(matriz_mult);

	printf("\nA Multiplicação das matrizes é :\n\n");
	for (i = 0; i < m; i++){
		for (j = 0; j < n; j++)
		 	printf("%d  ",matriz[i][j]);
		printf(" | ");
		for (j = 0; j < n; j++)
		 	printf("%d  ",matriz_mult[i][j]);
		printf(" =  ");
		for (j = 0; j < n; j++){
			//passo adicional para calcular a soma
			for(aux = 0, soma = 0; aux < n; aux++)
				soma += matriz[i][aux]*matriz_mult[aux][j];
	
			printf("%d  ",soma);
			matriz_result[i][j] = soma;
		}

		printf("\n");
	}
}

/* determina se uma matriz eh simetrica
*  verificando se eh igual a sua transposta */
void simeMatriz(int matriz[m][n]){
	int i, j;
	for (i = 0; i < m; i++)
		for (j = 0; j < n; j++)
			if(matriz[i][j] != matriz[j][i]){
				printf("Matriz[%d][%d] é diferente de Matriz[%d][%d].\n",i,j,j,i);
				printf("%d != %d\n", matriz[i][j],matriz[j][i]);
				printf("Logo não é uma matriz simetrica.\n");
				return;
			}
	imprimeMatriz(matriz);
	printf("\nÉ uma matriz simetrica.\n");
}

/* calcula a matriz transposta
*  invertendo as posicoes i,j */
void tranMatriz(int matriz[m][n]){
	printf("A matriz transposta é:\n");
	int i, j, matriz_trans[n][m];
	for (i = 0; i < m; i++){
		for (j = 0; j < n; j++)
			printf("%d  ",matriz[i][j]);
		printf(" =  ");
		for (j = 0; j < n; j++)
			printf("%d  ",matriz[j][i]);

		printf("\n");
	}
}

/* metodo que verifica se a matriz eh um quadrado magico
*  realizando a soma de todas as linhas, colunas e diagonais
*  e verificando se as mesmas sao iguais
*/
void qMagicoMatriz(int matriz[m][n]){
	/* inicializa as variáveis */
	int i,j,soma, soma_ant, resp = 1;

	/* realiza a soma de todos os elementos das linhas e imprime no final*/
	for (i = 0; i < m; i++){
		soma = 0;
		for (j = 0; j < n; j++){
			printf("     %d",matriz[i][j]);
			soma+= matriz[i][j];
		}
		printf("   =  %d\n",soma);
		//para a primeira soma, a anterior valera a atual
		if(i == 0) soma_ant = soma;
		//a qualquer momento, se a soma for diferente da anterior entao nao eh magico
		if(soma != soma_ant) resp = 0;
	}

	/* apenas para imprimir mais bonito*/
	printf(" /");
	for (j = 0; j < n; j++)
		printf("    |");
	printf("    \\\n");

	/* realiza a soma da diagona secundaria*/
	soma = 0;
	for (i = 0, j = n-1; i < m; i++, j--)
		soma+= matriz[i][j];
	printf("%d   ",soma);
	if(soma != soma_ant) resp = 0;

	/* realiza a soma de todas as colunas*/
	for (j = 0; j < n; j++){
		soma = 0;
		for (i = 0; i < m; i++)
			soma+= matriz[i][j];
		printf("%d    ",soma);
		if(soma != soma_ant) resp = 0;
	}

	/* por fim, calcula a soma da diagona principal*/
	soma = 0;
	for (i = 0, j = 0; i < m; i++, j++)
		soma+= matriz[i][j];
	printf(" %d",soma);
	if(soma != soma_ant) resp = 0;

	/* faz a secagem da resposta e imprime a mensagem correspondente*/
	if(resp == 1)
		printf("\nTodas as somas sao iguais, logo eh um quadrado magico\n");
	else
		printf("\nExistem somas que sao diferentes, logo nao eh um quadrado magico\n");
}


/* verifica se a matriz eh um quadrado latino
*  ou seja, todas as linhas e colunas sao permutacoes de 1 a n */
void qLatinoMatriz(int matriz[m][n]){
	/* temos uma resposta geral e uma local
	*  para visualizar mais facilmente onde nao ha permutacao	*/
	int i, j, resp = 1;
	
	for (i = 0; i < m; i++){
		for (j = 0; j < n; j++)
			printf("     %d",matriz[i][j]);
		
		//chama o metodo quer verifica a linha
		//imprime aqui a resposta no terminal, para ficar mais visivel
		if(verificaLin(matriz[i]))
			printf("   =  ok\n");
		else{
			printf("   =  !\n");
			resp = 0;
		}
	}

	// o mesmo soh que antes soh que agora para as colunas
	for (j = 0; j < n; j++)
	{
		//verifica agora se as colunas sao permutacoes
		if(verificaCol(matriz,j))
			printf("     ok");
		else{
			printf("     !");
			resp = 0;
		}
	}

	// imprime a resposta se eh ou nao um quadrado latino
	if(resp){
		printf("\nTodas as linhas e colunas sao permutacoes.\n");
		printf("A matriz eh um quadrado latino.\n");
	}else
		printf("\nA matriz nao eh um quadrado latino\n");
}

/* verifica se a coluna eh feita de permutacao de 1 a n */
int verificaCol(int matriz[m][n], int col){
	//o aux serve como o n que queremos verificar se existe no array
	int i, aux = 1;
	for (i = 0; i < m; i++){
		//caso encontre o aux, ele aumenta em 1 e 'volta' o laco do inicio
		//para procurar os demais
		if(matriz[i][col] == aux){
			aux++;
			i = -1;
		}
	}
	//se aux vale n+1 significa que achou n permutacoes
	//logo a linha inteira eh uma permutacao de 1 a n
	if(aux == n+1)
		return 1;
	return 0;
}

/* verifica se a linha eh feita de permutacao de 1 a n
*  a logica eh exatamente igual das colunas */
int verificaLin(int array[m]){
	int i,aux = 1;
	for (i = 0; i < m; i++){
		if(array[i] == aux){
			aux++;
			i = -1;
		}
	}
	if(aux == m+1)
		return 1;
	return 0;
}

/* verifica se a matriz eh uma matriz de permutacao
*  ou seja, se em cada linha e em cada coluna existe
*  n-1 elementos nulos e um unico numero 1
*/
void mPerMatriz(int matriz[m][n]){
	//novamente temos a resp e a resposta geral para deixar mais visivel
	//a variavel cont_zero e cont_um sao contadores para esses numeros
	int i, j, cont_zero, cont_um, resp, resp_geral = 1;
	for (i = 0; i < m; i++){
		resp = 1, cont_zero = 0, cont_um = 0;
		for (j = 0; j < n; j++){
			//verifica em cada elemento se eh zero ou um
			printf("     %d",matriz[i][j]);
			if(matriz[i][j] == 0)
				cont_zero++;
			else if(matriz[i][j] == 1)
				cont_um++;
			else
			// se nao for nenhum dos dois ja sabemos que nao eh 
			// uma matriz de permutacao
				resp_geral = resp = 0;
		}

		/* aqui que compara se existem essa quantidade de elementos
		*  se nao bater em nenhuma dessas condicoes entao nao eh
		*  matriz de permutacao */
		if(cont_um != 1 || cont_zero != n-1)
			resp_geral = resp = 0;

		if(resp)
			printf("   =  ok\n");
		else
			printf("   =  !\n");
	}

	//faz a mesma coisa que anteriormente
	//so que agora para as colunas
	for (j = 0; j < m; j++){
		resp = 1, cont_zero = 0, cont_um = 0;
		for (i = 0; i < n; i++){
			if(matriz[i][j] == 0)
				cont_zero++;
			else if(matriz[i][j] == 1)
				cont_um++;
			else
				resp_geral = resp = 0;
		}
		if(cont_um != 1 || cont_zero != n-1)
			resp_geral = resp = 0;

		if(resp)
			printf("    ok");
		else
			printf("    !");
	}

	//realiza a checagem geral e imprime a resposta na tela
	if (resp_geral)
		printf("\nA matriz eh uma matriz de permutacao\n");
	else
		printf("\nA matriz nao eh uma matriz de permutacao\n");
}

/* menu com todas as opcoes disponiveis */
void menu(int matriz[m][n]){
	int op;
	do{
		op = 0;
		continuar();
		printf("Entre com a opção que deseja fazer\n\n");
		printf("1 - Reler os elementos da matriz\n");
		printf("2 - Imprimir os elementos da matriz\n");
		printf("3 - Calcular a matriz transposta\n");
		printf("4 - Somar com outra matriz\n");
		printf("5 - Subtrair com outra matriz\n");
		printf("6 - Multiplicar com outra matriz\n");
		printf("7 - Determinar se a matriz eh simetrica\n");
		printf("8 - Determinar se a matriz eh um quadrado magico\n");
		printf("9 - Determinar se a matriz eh um quadrado latino\n");
		printf("10 - Determinar se a matriz eh matriz de permutacao\n\n");
		printf("F1 - ajuda\n");
		printf("ESC - sair\n\n");
		
		printf("Opcao = ");
		scanf("%d",&op);
		clear();
		system("clear");
		switch(op){
			case 1:
				preencheMatriz(matriz);
				break;
			case 2:
				imprimeMatriz(matriz);
				break;
			case 3:
				tranMatriz(matriz);
				break;
			case 4:
				somaMatriz(matriz);
				break;
			case 5:
				subMatriz(matriz);
				break;
			case 6:
				multMatriz(matriz);
				break;	
			case 7:
				simeMatriz(matriz);
				break;
			case 8:
				qMagicoMatriz(matriz);
				break;		
			case 9:
				qLatinoMatriz(matriz);
				break;		
			case 10:
				mPerMatriz(matriz);
				break;
		}
	}while(op > 0);
}

int main(){
 
 	printf("Bem vindo ao trabalho 3 de algoritmos \n");
 	printf("Gerenciador de Matrizes - Desenvolvido por Priscila da Rocha Alves e Marcelo Gaioso Werneck\n");
 	printf("Para ajuda precione F1 a qualquer momento\n\n");

    printf("Coloque a quantidade de linhas e colunas da matriz:\n");
    scanf("%d %d",&m,&n); 	

    int matriz[m][n];
    inicializaMatriz(matriz);
    preencheMatriz(matriz);
    menu(matriz);

	return 0;
}	
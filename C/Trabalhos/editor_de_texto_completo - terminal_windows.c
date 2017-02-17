#include <stdio.h>
#include <malloc.h>
#include <string.h>
#include <conio.h>
#include <windows.h>

#define Fx 0
#define F1 59
#define F2 60
#define F3 61
#define F4 62
#define F5 63
#define F6 64
#define F7 65

#define ENTER 13
#define BACK 8

#define INTENSE   FOREGROUND_INTENSITY
#define DKBLUE    FOREGROUND_BLUE
#define DKGREEN   FOREGROUND_GREEN
#define BLUE      (FOREGROUND_BLUE|INTENSE)
#define GREEN     (FOREGROUND_GREEN|INTENSE)
#define RED       (FOREGROUND_RED|INTENSE)
#define YELLOW    (RED|GREEN|INTENSE)
#define CYAN      (GREEN|BLUE|INTENSE)
#define MAGENTA   (RED|BLUE|INTENSE)
#define BLACK     0
#define WHITE     ( RED|GREEN|BLUE|INTENSE)
 
HANDLE g_consOut;

typedef struct estrutura {
	char letra;
	struct estrutura* ant;
	struct estrutura* prox;
}NO;

typedef struct {
	NO* inicio;
	NO* fim;
	int salvo;
	char titulo[30];
	char caminho[100];
}LISTA;
//---------------------

//inicializa a lista
void inicializa(LISTA* l){
	l->inicio = l->fim = NULL;
	l->salvo = 1;
	strcpy(l->titulo,"Sem titulo");
}

//cria um no para ser utilizado depois
NO* cria_no(char c){
	//aloca memoria
	NO* no = malloc(sizeof(NO));
	no->prox = no->ant = NULL;
	no->letra = c;
	return no;
}

//insere um no(uma letra) no final da lista
void insere_fim(LISTA *l, char c){
	NO* novo = cria_no(c);

	//se lista vazia, insere o primeiro valor
	if(!l->inicio || !l->fim){
		l->inicio = l->fim = novo;
	}else{
		NO* aux = l->fim;
		novo->ant = aux;
		aux->prox = novo;
		l->fim = novo;
	}
}

void remove_letra(LISTA* l){
	//nao tem nenhuma letra
	if(!l->inicio || !l->fim)
		return;
	//existe apenas uma letra
	if(l->inicio == l->fim){
		free(l->inicio);
		l->fim = l->inicio = NULL;
		return;
	}
	NO* aux = l->fim;
	l->fim = aux->ant;
	l->fim->prox = NULL;
	free(aux);
}

//limpa toda a lista | exclui todo o texto
void destroi_texto(LISTA* l){
	while(l->inicio)
		remove_letra(l);
}

int imprime_texto(LISTA l){
	system("cls");
	if(l.salvo)
		printf("\n-------------------------%s-------------------------\n",l.titulo);
	else
		printf("\n-------------------------%s!------------------------\n",l.titulo);

	NO* aux = l.inicio;
	int i = 1;
	printf("%d ",i);
	while(aux){
		printf("%c",aux->letra);
		if(aux->letra == ENTER)
			printf("\n%d ",++i);
		if(aux->letra == '\n')
			printf("%d ",++i);
		aux = aux->prox;
	}
	return i;
}


void novo_texto(LISTA *l, int salvo){
	if(!salvo)
		if(escolha("\n-NOVO:\n","\nTexto nao foi salvo, descartar as alteracoes? s/n \n") == 0) return;

	destroi_texto(l);
	inicializa(l);
}

void carrega_texto(LISTA *l, int salvo){
	char c;
	
	if(!salvo){
		if(escolha("\n-ABRIR:\n","\nTexto nao foi salvo, descartar as alteracoes? s/n \n") == 0) return;
	}else{
		system("cls");
		printf("\n-ABRIR:\n");
	}

	char nome[80];
	char linha[255];
	int i;

	printf("\nDigite o caminho e/ou nome do arquivo que deseja carregar:\n");
	scanf("%s",nome);

	FILE* arquivo = fopen(nome,"r");
	if(!arquivo){
		printf("Falha ao abrir o arquivo %s para leitura!\n",nome);
		getch();
		return;
	}

	destroi_texto(l);
	inicializa(l);

	while(fgets(linha,sizeof(linha),arquivo)){
		i = 0;
		while(linha[i] != '\0'){
			c = linha[i++];
			insere_fim(l,c);
		}
	}
}

int salva_texto(LISTA* l, int salvo){
	char c;
	char nomefinal[80];
	FILE* arquivo;

	if(!salvo){		
		char nome[30];
		char caminho[50];

		if(escolha("\n-SALVAR COMO:\n","\nDeseja inserir um caminho para o arquivo? s/n\n")){
			printf("\nDigite o caminho para onde deseja salvar (com \\ no final):\n");
			scanf("%s",caminho);
		}

		printf("\nDigite o nome do arquivo que deseja salvar:\n");
		scanf("%s",nome);
		strcpy(nomefinal,caminho);
		arquivo = fopen(strcat(nomefinal,nome),"w");
		if(!arquivo){
			printf("Falha ao abrir o arquivo %s do caminho %s para escrita!\n",nome,caminho);
			return 0;
		}
		NO* aux = l->inicio;
		while(aux){
			c = aux->letra;
			if(c == ENTER)
				fprintf(arquivo,"\n");
			else{
				fprintf(arquivo,"%c", c);
			}		
			aux = aux->prox;
		}
		printf("O arquivo %s foi salvo com sucesso!\n\n",nome);
		printf("\nAperte qualquer tecla para voltar ao editor:\n");
		getch();
		strcpy(l->titulo,nome);
		strcpy(l->caminho,caminho);
	}else{
		strcpy(nomefinal,l->caminho);
		arquivo = fopen(strcat(nomefinal,l->titulo),"w");
		NO* aux = l->inicio;
		while(aux){
			c = aux->letra;
			if(c == ENTER)
				fprintf(arquivo,"\n");
			else
				fprintf(arquivo,"%c", c);	
			aux = aux->prox;
		}		
	}
	l->salvo = 1;
	fclose(arquivo);
	return 1;
}

void ajuda(int n){
	if(n) system("cls");
	printf("\nPara utilizar o editor de texto, use os seguintes comandos:\n\n");

	printf("F1 - Novo\n");
	printf("F2 - Abrir...\n");
	printf("F3 - Salvar\n");
	printf("F4 - Salvar como...\n");
	printf("F5 - Busca\n");
	printf("F6 - Estilizar\n");
	printf("F7 - Lista de comandos\n");	

	printf("\n\nAperte qualquer tecla para ir ao editor:\n");
	if(_getch() == Fx)
		_getch();

}

int escolha(char* texto1, char* texto2){
	char c;
	while(1){
			system("cls");
			printf("%s",texto1);
			printf("%s",texto2);
			c = getch();
			if(c == 's')		return 1;
			else if(c == 'n')   return 0;
		}
}

void acha_palavra(LISTA *l){
	NO* aux = l->inicio;
	char palavra[100];
	system("cls");
	printf("\n-BUSCA:\n");
	printf("\nDigite o termo que deseja buscar:\n");
	scanf("%s",palavra);

	int i = 0;
	int linha = 1;
	int pos = 0;
	while(aux){
		if(aux->letra == palavra[i]){
			i++;
			if(palavra[i] == '\0'){
				printf("O termo buscado se encontra na linha %d e posicao %d.\n",linha,pos);
				getch();
				if(!escolha("\n-BUSCA:\n","\nDeseja continuar buscando?\n\n")) return;
			}
			aux = aux->prox;
			continue;
		}

		i = 0;
		if(aux->letra == ENTER || aux->letra == '\n'){
			linha++;
			pos = 0;
		}
		aux = aux->prox;
		pos++;	

	}
	printf("Nao encontrado.\n");
	getch();
}

//limpa a tela e retorna as configuracoes originais do terminal
void clrscr() {
    COORD topLeft = {0, 0};
    DWORD cCharsWritten;
    CONSOLE_SCREEN_BUFFER_INFO csbi; 
    GetConsoleScreenBufferInfo(g_consOut, &csbi);
    DWORD dwConSize = csbi.dwSize.X * csbi.dwSize.Y;
    FillConsoleOutputCharacter(g_consOut, ' ', dwConSize,
            topLeft, &cCharsWritten);
    FillConsoleOutputAttribute(g_consOut, csbi.wAttributes,
            dwConSize, topLeft, &cCharsWritten);
    SetConsoleCursorPosition(g_consOut, topLeft);
}
 
int gettextattr() {
    CONSOLE_SCREEN_BUFFER_INFO buf;
    GetConsoleScreenBufferInfo(g_consOut, &buf);
    return buf.wAttributes;
}
 
void settextattr(int x) {
    SetConsoleTextAttribute(g_consOut, (WORD)x);
}
 
void textcolor(int color) {
    SetConsoleTextAttribute(g_consOut, (gettextattr() & 0xf0) | color);
}
 
void textbackground(int color) {
    SetConsoleTextAttribute(g_consOut, (gettextattr() & 0x0f) | (color << 4));
}

char retorna_opcao(){
	char cor;
	_cprintf("0 - Preto\n");
	_cprintf("1 - Azul\n");
	_cprintf("2 - Verde\n");
	_cprintf("3 - Vermelho\n");
	_cprintf("4 - Azul escuro\n");
	_cprintf("5 - Ciano\n");
	_cprintf("6 - Amarelo\n");
	_cprintf("7 - Magenta\n");
	_cprintf("8 - Verde escuro\n");
	_cprintf("9 - Branco\n\n");

	cor = getch();
	return cor;
}
 
void altera_cor_texto(){
	_cprintf("\nDigite um numero para mudar a cor do texto:\n\n");
	char cor = retorna_opcao();
	if(cor == '0') textcolor(BLACK);
	else if(cor == '1') textcolor(BLUE);
	else if(cor == '2') textcolor(GREEN);
	else if(cor == '3') textcolor(RED);
	else if(cor == '4') textcolor(DKBLUE);
	else if(cor == '5') textcolor(CYAN);
	else if(cor == '6') textcolor(YELLOW);
	else if(cor == '7') textcolor(MAGENTA);
	else if(cor == '8') textcolor(DKGREEN);
	else if(cor == '9') textcolor(WHITE);
	else{
		_cprintf("\n Opcao invalida!\n"); 
		getch();
		return;
	}
	_cprintf("\n A cor do texto foi alterada com sucesso!\n");
	_cprintf("Aperte qualquer tecla para retornar ao menu.\n");
	getch();
}

void altera_cor_fundo(){
	_cprintf("\nDigite um numero para mudar a cor de fundo:\n\n");
	char cor = retorna_opcao();
	if(cor == '0') textbackground(BLACK);
	else if(cor == '1') textbackground(BLUE);
	else if(cor == '2') textbackground(GREEN);
	else if(cor == '3') textbackground(RED);
	else if(cor == '4') textbackground(DKBLUE);
	else if(cor == '5') textbackground(CYAN);
	else if(cor == '6') textbackground(YELLOW);
	else if(cor == '7') textbackground(MAGENTA);
	else if(cor == '8') textbackground(DKGREEN);
	else if(cor == '9') textbackground(WHITE);

	else{
		_cprintf("\n Opcao invalida!\n"); 
		getch();
		return;
	}
	_cprintf("\n A cor de fundo foi alterada com sucesso!\n");
	_cprintf("Aperte qualquer tecla para retornar ao menu.\n");
	getch();
}

//menu utilizado para estilizar o terminal do windows
void estilizar(){
	int op;
	while(1){
		clrscr();
		_cprintf("\n** Bem vindo ao Editor Color! ** \n\n");
		_cprintf("Escolha o que deseja fazer:\n");
		_cprintf("1) Mudar a cor do texto.\n");
		_cprintf("2) Mudar a cor de fundo.\n");
		_cprintf("3) Voltar.\n\n");

		//scanf("%d",&op);
		op = getch();
		clrscr();
		if(op == '1') altera_cor_texto();
		else if(op == '2') altera_cor_fundo();
		else if(op == '3') return;
		else _cprintf("Opcao invalida!\n");
	}
}

void editor(LISTA* l){
	char letra;
	int linhas = imprime_texto(*l);
	int salvo = 0;

	while(1){
		//pega a letra que foi digitada
		letra = _getch();
		
		//vai utilizar uma tecla F
		if(letra == Fx){
			//precisa pegar o segundo caractere
			letra = _getch();
			if(letra == F1)				novo_texto(l, l->salvo);	
			if(letra == F2)				carrega_texto(l, l->salvo);
			if(letra == F3)				salvo = salva_texto(l, salvo);
			if(letra == F4)				salvo = salva_texto(l, 0);
			if(letra == F5)				acha_palavra(l);
			if(letra == F6)				estilizar();
			if(letra == F7)				ajuda(1);

			linhas = imprime_texto(*l);
		}else if(letra == BACK){
			//foi um backspace, entao remove uma letra então reimprime todo texto
			remove_letra(l);
			linhas = imprime_texto(*l);

		}else if((letra >= 32 && letra <= 127) || letra == ENTER){
			//a tecla digitada foi uma normal, pode imprimir e salvar na lista
			printf("%c", letra);

			//insere a letra no fim da lista
			insere_fim(l,letra);
			if(l->salvo) {
				l->salvo = 0;
				linhas = imprime_texto(*l);
			}else if(letra == ENTER){
				printf("\n%d ",++linhas);
			}
		}else if(letra == 27){
			//sair
			if(!l->salvo)
				if(!escolha("\n-SAIR:\n","\nTexto nao foi salvo, descartar as alteracoes? s/n \n"))
					continue;
			return;
		}
	}
}

//metodo principal utilizado para inicializacao
int main(){
	LISTA l;
	inicializa(&l);
	g_consOut = GetStdHandle(STD_OUTPUT_HANDLE);
    WORD originalColors = gettextattr();

	system("cls");
	printf("\n** Bem vindo ao Simple Text Editor! :) **\n");
	ajuda(0);
	//chama o editor de texto
	editor(&l);


	settextattr(originalColors);
	printf("\n\n -- Finalizado!\n");
	return 1;	
}

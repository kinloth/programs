#include <stdio.h>

int main(){
	int i,j,soma,qtd,votos[6];
	for(i = 0; i <= 5; i++)
		votos[i] = 0;

	printf("Entre com a quantidade de votos que serão inseridos:\n");
	scanf("%d",&qtd);
	printf("Entre com os votos:\n");
	for (; qtd > 0; qtd--)
	{
		scanf("%d",&i);
		votos[i-1]++;
		if(i < 5) soma++;
	}
		

	printf("\na)\n");
	for(i = 1; i <= 4; i++)
	printf("Candidato %d recebeu %d votos.\n",i,votos[i-1]);
	
	printf("\nb)\n Teve %d votos nulos.\n",votos[4]);
	printf("\nc)\n Teve %d votos em branco.\n",votos[5]);

	for(i = 0; i <= 3; i++){
		if(votos[i] > soma-votos[i]){
			printf("\nd)\n O Candidato %d foi o vencedor com %d votos.\n",i+1,votos[i]);
			return 1;
		}
	}
	printf("\nd)\n Não houve um candidato vencedor.\n");

}
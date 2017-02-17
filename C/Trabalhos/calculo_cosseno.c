#include <stdio.h>
#include <math.h>


double fatorial(double a){
	if(a==1) return 1;
	return a*fatorial(a-1);
}

int main(){
	double ex,sinal,i;
	double a,x,fat,y,cosseno,soma;
	char resp;
	a=1;
	sinal=-1;
	soma=1;
	//do{
	do{
		printf("Digite o a quantidade de termos da serie");
		scanf("%lf",&ex);
		printf("Digite um numero inteiro positivo para x");
		scanf("%lf",&x);
	}while(ex<0 || x<0);
	for(i=2;i<=(ex*2)-1;i+=2){
		printf("\ni= %lf",i);
		fat=fatorial(i);
		printf("\nfatorial:%lf",fat);
		y=sinal*pow(x,i)/fat;
		printf("\np: %lf",pow(x,i));
		printf("\n y:%lf",y);
		soma+=y;
		printf("\nsoma:%lf",soma);
		sinal=-sinal;


	}
	cosseno=cos(x);

	printf("\nCos(x): %lf\ncosseno maquina: %lf\n",soma,cosseno);
		//reprocessamento

		//do {	
		//printf("\nContinue S/N?\n");
		//resp=toupper(getch());
		//}while(resp!='S' && resp!='N');
	//}while(resp=='S');
}



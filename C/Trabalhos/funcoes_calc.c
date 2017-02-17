#include <stdio.h>
#include <malloc.h>
#include <string.h>
#include <math.h>
#include <limits.h>

#define PI 3.14159265

/* 
	
*/
typedef struct {
	int tipo;
	int grau;
	int* coe;
}FUNCAO;


/* tipos de funcoes
0 = polinomial
1 = logaritma natural
2 = trigonometrica
*/

int max(int num1, int num2) {

   /* local variable declaration */
   int result;
 
   if (num1 > num2)
      result = num1;
   else
      result = num2;
 
   return result; 
}

double resolve(FUNCAO f, int x){
	int i = 0;
	double resul = 0;
	if(f.tipo == 0){
		for (; i < f.grau; i++)
			resul += f.coe[i]*pow(x,i);
	}else if(f.tipo == 1){
		for (i; i < f.grau; i++)
			resul += f.coe[i]*pow(x,i);
		resul = log(resul);
	}
}

double fatorial(double x){
	if(x < 1) return 1.0; 
	return x*(fatorial(x-1));
}

double zeta(int n){
	if(n == 2) return 1.6449;
	if(n == 4) return 1.0823;
	if(n == 6) return 1.0173;
	else return 1;
}

double bernoulli(int n){

	if(n == 1) 					return -1/2;
	if(n == 0 || n%2 == 1) 		return 1;

	return (pow(-1,(n/2)+1) * fatorial(2*n) / pow(2*3.14, n) * zeta(n)); 
}

double Tg(double erro, int max_it, double x, int* it){
	printf("x = %f \t abs x = %f \t divisao = %.2f \n", x, fabs(x), PI/2);
	if(fabs(x) >= PI/2) return 0;

	int i;
	double erro_calc = INT_MAX;
	double resultado = x;
	double anterior = x;
	printf("antes de comecar... resultado = %f\n",resultado);
	for(i = 1; i < max_it || erro_calc < erro; i++ , *it++){
		resultado += bernoulli(2*i) * pow(-4,i) * (1 - pow(4,i)) *  pow(x, (2*i-1)) / fatorial(2*i);
		printf("resutlado = %f\n",resultado);

		erro_calc = fabs(resultado - anterior) / resultado;
		anterior = resultado;
		getchar();
	}
	printf("ok\n");
	return resultado;
}

int main(){
	int it = 0;
	int grau = 45;
	double resultado = Tg(0.1, 1000, grau * PI / 180 , &it);
	printf("resultado do tg eh %f com %d iteracoes.\n",resultado,it);
	return 0;	
}

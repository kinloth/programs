#include <stdio.h>

int main () {
	int n, i, mult;
	printf ("Insira um numero natural:  ");
	scanf ("%d", &n);


	for (i=1; mult < n; i++){
	    mult=i*(i+1)*(i+2);
	    printf("mult = %d e i = %d\n", mult, i);
	}

    if (n!=mult)
    	printf ("\nO numero nao eh triangular");
    else
        printf ("\nO numero %d eh triangular, pois %d*%d*%d=%d\n", n, i, i+1, i+2, n);
}
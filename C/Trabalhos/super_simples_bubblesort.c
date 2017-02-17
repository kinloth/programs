#include <stdio.h>

int swap(int &a, int &b){
    int aux = *a;
    *b = *a;
    *a = aux;
}


int main(void){

    int vetor[10] = {10,9,8,7,6,5,4,3,2,1};
    int tamanho = 10;

    for(int i= tamanho-1; i >= 1; i--) {  
        
        for(int j= 0; j < i ; j++) {
              
            if(vetor[j]>vetor[j+1]) {
                    
                swap(&vetor[j],&vetor[j+1]);
                
            }
        }
    }
}

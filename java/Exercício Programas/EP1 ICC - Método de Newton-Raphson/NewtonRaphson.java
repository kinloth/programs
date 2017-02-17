/*****************************************************************/
/**  ACH2001  - Introdução à Ciência da Computação I            **/
/**  EACH-USP - Primeiro Semestre de 2011                       **/
/**  turma 02 - Nakano  										**/
/**																**/
/**	 Primeiro Exercício-Programa							    **/
/**	 Arquivo: EP												**/
/**																**/
/**  Marcelo Gaioso Werneck 					8061963         **/
/**																**/
/**  15/04/2012													**/
/*****************************************************************/

public class ep1{                                        //classe do EP1! 

//declarando as variáveis globais.

static double D_0 = 40;									
static double D_1 = 180;
static double D_2 = 120;
static double D_3 = 870;
static double D_4 = 462;
static double D_5 = 230;
static double D_6 = -320;
static double D_7 = 230;
static double D_8 = 120;
static double D_9 = 40;
static double Saldo = 8000;								 //variáveis dos Depósitos (último foi o saldo total).

static int t_0 = 1;
static int t_1 = 2;
static int t_2 = 3;
static int t_3 = 4;
static int t_4 = 5;
static int t_5 = 6;
static int t_6 = 7;
static int t_7 = 8;
static int t_8 = 9;
static int t_9 = 12;
static int t_S = 12; 							//variaveis das datas das quais foram realizados os depósitos(ultimo foi a data do saldo).
	
static double newton(double epsilon){		//método pedido.
	
	double j = 0.5;	    // valor estimado de j inicial.
	double jk;			//valor final de j.
	
		jk = j - (D_0*Math.pow((1+j),(t_S-t_0)) + D_1*Math.pow((1+j),(t_S-t_1))
	+ D_2*Math.pow((1+j),(t_S-t_2)) + D_3*Math.pow((1+j),(t_S-t_3)) + D_4*Math.pow((1+j),(t_S-t_4))
	+ D_5*Math.pow((1+j),(t_S-t_5)) + D_6*Math.pow((1+j),(t_S-t_6)) + D_7*Math.pow((1+j),(t_S-t_7))
	+ D_8*Math.pow((1+j),(t_S-t_8)) + D_9*Math.pow((1+j),(t_S-t_9)) - Saldo)								//função de j.
	/	((t_S-t_0)*D_0*Math.pow((1+j),((t_S-t_0)-1)) + (t_S-t_1)*D_1*Math.pow((1+j),((t_S-t_1)-1))
	+ (t_S-t_2)*D_2*Math.pow((1+j),((t_S-t_2)-1)) + (t_S-t_3)*D_3*Math.pow((1+j),((t_S-t_3)-1))
	+ (t_S-t_4)*D_4*Math.pow((1+j),((t_S-t_4)-1)) + (t_S-t_5)*D_5*Math.pow((1+j),((t_S-t_5)-1))
	+ (t_S-t_6)*D_6*Math.pow((1+j),((t_S-t_6)-1)) + (t_S-t_7)*D_7*Math.pow((1+j),((t_S-t_7)-1))
	+ (t_S-t_8)*D_8*Math.pow((1+j),((t_S-t_8)-1)) + (t_S-t_9)*D_9*Math.pow((1+j),((t_S-t_9)-1)));  			//derivada da função de j.
	
	if (epsilon <=0 || epsilon >=1) {		
	
	jk = -1;	
	
	}	// condição de que se epsilon for menor ou igual a 0, ou maior ou igual a 1, o valor de saída seja -1.
	
	
	else {  // se o valor de epsilon estiver entre 0 e 1, que tenha a condição até chegar no valor desejado.
	
	while (Math.abs(jk-j) >= epsilon){					//enquanto o modulo da diferença entre o j final e o j anterior for maior ou igual ao epsilon...
				 
				 j = jk;				//o j recebe o valor de jk para poder obter um novo jk, e continuar até obter um valor desejado.
				
				jk = j - (D_0*Math.pow((1+j),(t_S-t_0)) + D_1*Math.pow((1+j),(t_S-t_1))
	+ D_2*Math.pow((1+j),(t_S-t_2)) + D_3*Math.pow((1+j),(t_S-t_3)) + D_4*Math.pow((1+j),(t_S-t_4))
	+ D_5*Math.pow((1+j),(t_S-t_5)) + D_6*Math.pow((1+j),(t_S-t_6)) + D_7*Math.pow((1+j),(t_S-t_7))
	+ D_8*Math.pow((1+j),(t_S-t_8)) + D_9*Math.pow((1+j),(t_S-t_9)) - Saldo)
	/	((t_S-t_0)*D_0*Math.pow((1+j),((t_S-t_0)-1)) + (t_S-t_1)*D_1*Math.pow((1+j),((t_S-t_1)-1))
	+ (t_S-t_2)*D_2*Math.pow((1+j),((t_S-t_2)-1)) + (t_S-t_3)*D_3*Math.pow((1+j),((t_S-t_3)-1))
	+ (t_S-t_4)*D_4*Math.pow((1+j),((t_S-t_4)-1)) + (t_S-t_5)*D_5*Math.pow((1+j),((t_S-t_5)-1))
	+ (t_S-t_6)*D_6*Math.pow((1+j),((t_S-t_6)-1)) + (t_S-t_7)*D_7*Math.pow((1+j),((t_S-t_7)-1))
	+ (t_S-t_8)*D_8*Math.pow((1+j),((t_S-t_8)-1)) + (t_S-t_9)*D_9*Math.pow((1+j),((t_S-t_9)-1)));  // calcular novamente o valor de jk, agora com o novo j.
								
				 }
	
	}	
		return jk; 			// valor que deve retornar: ultimo valor de jk, quando o modulo da diferença jk-j estiver menor ou igual a epsilon.
	}	
public static void main(String args[]) {	

		System.out.println("resultado final = " + newton(0.001));
}
} 
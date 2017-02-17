import a.*;
import b.*;
import c.*;
import d.*;
import base.*;

class TestaRecursao {
	public static void main (String[] args) {
		Recursivo[] tudo = {new SolA(), new SolB(), new SolC(), new SolD()};
		int[]  resposta = {2,7,15,20}, n ={3,2,4,4};
		double nota=0;
		
		for (int i=0; i<4;i++){
			tudo[i].setAdditionalParameter (2);
			System.out.println (tudo[i].function(n[i]));
			System.out.println (tudo[i].getRecursionLength());
			tudo[i].dumpStack();
			System.out.println();
			try {
				if ((int)(tudo[i].function(n[i]))==resposta[i]) {
					nota+=2.5;
				}
			}catch (Exception e) {
				System.out.println ("Teste " + i + ": " + e.getMessage());
			}
		}
		System.out.println (nota);
	}
}



import base.*;
import produto.*;
import fatorial.*;

class TestaRecursao {
	public static void main (String[] args) {
		int n, resposta;
		double nota=0;
		try {
			Recursivo r=new Produto();
			n=5; resposta=25;
			r.setAdditionalParameter(n);
			if ((r.function(n)==resposta) &&
			       (r.getRecursionLength()>(n-1))) {
				nota+=5;
			}
		} catch (Exception e) {
			System.out.println ("Teste 1" + e.getMessage());
		}
		try {
			Recursivo r=new Fatorial();
			n=6; resposta=720;
			r.setAdditionalParameter(n);
			if ((r.function(n)==resposta) &&
			       (r.getRecursionLength()>(n-1))) {
				nota+=5;
			}
			
		} catch (Exception e) {
			System.out.println ("Teste 2" + e.getMessage());
		}
		
		System.out.println (nota);
	}
}



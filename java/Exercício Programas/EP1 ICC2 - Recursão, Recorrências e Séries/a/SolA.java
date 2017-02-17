/*********************************************************/
/** ACH 2002 - Introducao a Ciencia da computacao II	**/
/**														**/
/** 42 - Fabio Nakano									**/
/**														**/
/** Primeiro Exercicio-Programa							**/
/**														**/
/** Marcelo Gaioso Werneck		6061963					**/
/**														**/
/*********************************************************/
package a;
import base.*;
public class SolA extends Recursivo
{
	int a;
	public void setAdditionalParameter (int n)
	{
		a = n;
	}
	public int getAdditionalParameter()
	{
		return a;
	}
	public int function(int n)
	{		
		if(n == 0 || n == 1)
		{
			storeStack();
			return n;
		}
		else
		{
			return function(n-1)+function(n-2);
		}
	}
}
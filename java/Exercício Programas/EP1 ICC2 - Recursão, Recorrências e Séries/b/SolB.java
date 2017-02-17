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
package b;
import base.*;
public class SolB extends Recursivo
{
	int b;
	public void setAdditionalParameter(int p)
	{
		b = p;
	}
	public int getAdditionalParameter()
	{
		return b;
	}
	public int function(int n)
	{
		if(n > 0)
			return b*function(n - 1) + 1;
		storeStack();
		return 1;
	}
}
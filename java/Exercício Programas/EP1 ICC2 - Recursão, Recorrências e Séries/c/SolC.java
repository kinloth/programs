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
package c;
import base.*;
public class SolC extends Recursivo
{
	int c;
	public void setAdditionalParameter(int p)
	{
		c = p;
	}
	public int getAdditionalParameter()
	{
		return c;
	}
	public int function(int n)
	{
		if(n > 0)
			return c*function(n/2)+1;
		storeStack();
		return 1;
	}
}
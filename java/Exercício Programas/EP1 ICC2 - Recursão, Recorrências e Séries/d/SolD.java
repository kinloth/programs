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
package d;
import base.*;
public class SolD extends Recursivo
{
	int d;
	public void setAdditionalParameter(int p)
	{
		d = p;
	}
	public int getAdditionalParameter()
	{
		return d;
	}
	public int function(int n)
	{
		if(n > 0)
			return d*function(n/2) + n;
		storeStack();
		return 1;
	}
}
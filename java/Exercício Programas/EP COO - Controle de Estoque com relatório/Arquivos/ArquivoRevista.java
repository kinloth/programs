package Arquivos;

public class ArquivoRevista extends Arquivos//Singleton
{	
	private static ArquivoRevista instancia;
	
	private ArquivoRevista()
	{
		local = "Produto/revista.txt";
		TAMANHO_REGISTRO = Integer.SIZE/8 + 50*2 + 50*2 + 50*2 + Double.SIZE/8 + Integer.SIZE/8;
		abrir();
	}
	
	public static ArquivoRevista getInstace()
	{
		if(instancia == null)
		{
			instancia = new ArquivoRevista();
		}
		return instancia;
	}
}

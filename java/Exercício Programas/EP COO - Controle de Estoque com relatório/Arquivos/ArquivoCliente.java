package Arquivos;

public class ArquivoCliente extends Arquivos//Singleton
{	
	private static ArquivoCliente instancia;
	
	private ArquivoCliente()
	{
		local = "Cliente/cliente.txt";
		TAMANHO_REGISTRO = Integer.SIZE/8 + 50*2 + Integer.SIZE/8;
		abrir();
	}
	
	public static ArquivoCliente getInstace()
	{
		if(instancia == null)
		{
			instancia = new ArquivoCliente();
		}
		return instancia;
	}
}

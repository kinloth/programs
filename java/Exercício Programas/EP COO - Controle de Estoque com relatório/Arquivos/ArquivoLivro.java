package Arquivos;

public class ArquivoLivro extends Arquivos//Singleton
{	
	private static ArquivoLivro instancia;
	
	private ArquivoLivro()
	{
		local = "Produto/livro.txt";
		TAMANHO_REGISTRO = Integer.SIZE/8 + 50*2 + 50*2 + 50*2 + Double.SIZE/8 + Integer.SIZE/8;
		abrir();
	}
	
	public static ArquivoLivro getInstace()
	{
		if(instancia == null)
		{
			instancia = new ArquivoLivro();
		}
		return instancia;
	}
}

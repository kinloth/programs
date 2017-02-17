package Produto;

public class ProdutoNotFoundException extends Exception
{
	public ProdutoNotFoundException()
	{
		super("Produto nao cadastrado");
	}
	
	public ProdutoNotFoundException(String msg)
	{
		super(msg);
	}
}

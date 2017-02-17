package Cliente;

public class ClienteNotFoundException extends Exception
{
	public ClienteNotFoundException()
	{
		super("Cliente nao cadastrado");
	}
	
	public ClienteNotFoundException(String msg)
	{
		super(msg);
	}
}

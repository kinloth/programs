package agenda;
import Menu.*;
public class UsuarioAtual
{
    private static UsuarioAtual instancia;
    public String ID;
    public int tipo;
	
	public UsuarioAtual(String ID, int tipo)
	{
		this.ID = ID;
                this.tipo = tipo;
		instancia = this;
	}
	
	public UsuarioAtual() { }
	
	public static UsuarioAtual getInstace()
	{
		if(instancia == null)
		{
			instancia = new UsuarioAtual();
		}
		return instancia;
	}
}

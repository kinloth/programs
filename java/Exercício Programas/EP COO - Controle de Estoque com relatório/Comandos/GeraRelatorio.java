package Comandos;
import Comandos.Command;
import javax.swing.JOptionPane;
import Venda.*;

public class GeraRelatorio implements Command
{
	private Vendas venda;
	
	public GeraRelatorio()
	{
		venda = new Vendas();
	}
	
	public void execute()
	{
		venda.geraRelatorio();
	}
	
	public void undo(){}
}
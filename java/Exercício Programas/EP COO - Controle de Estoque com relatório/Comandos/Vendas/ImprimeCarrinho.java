package Comandos.Vendas;
import Comandos.Command;
import javax.swing.JOptionPane;
import Cliente.*;
import Produto.*;
import Venda.*;

public class ImprimeCarrinho implements Command
{
	private Vendas venda;
	
	public ImprimeCarrinho(Cliente cli)
	{
		venda = new Vendas(cli, null);
	}
	
	public void execute()
	{
		try
		{
			venda.imprimeCarrinho();
		}
		catch(ProdutoNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	public void undo(){}
}
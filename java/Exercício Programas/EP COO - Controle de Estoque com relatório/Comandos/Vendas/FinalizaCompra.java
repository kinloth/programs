package Comandos.Vendas;
import Comandos.Command;
import javax.swing.JOptionPane;
import Cliente.*;
import Produto.*;
import Venda.*;

public class FinalizaCompra implements Command
{
	private Vendas venda;
	
	public FinalizaCompra(Cliente cli)
	{
		venda = new Vendas(cli, null);
	}
	
	public void execute()
	{
		try
		{
			venda.finalizaCompra();
			venda.escreveRelatorio();
			JOptionPane.showMessageDialog(null, "Compra Efetuada");
		}
		catch(ProdutoNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void undo(){}
}
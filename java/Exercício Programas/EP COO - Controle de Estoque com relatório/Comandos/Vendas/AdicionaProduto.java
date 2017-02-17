package Comandos.Vendas;
import Comandos.Command;
import javax.swing.JOptionPane;
import Cliente.*;
import Produto.*;
import Venda.*;

public class AdicionaProduto implements Command
{
	private Vendas venda;
	
	public AdicionaProduto(Cliente cli, Produto pro)
	{
		venda = new Vendas(cli, pro);
	}
	
	public void execute()
	{
		try
		{
			venda.adicionaProduto();
			JOptionPane.showMessageDialog(null, "Produto Adicionado");
		}
		catch(ProdutoNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void undo()
	{
		try
		{
			venda.removeProduto();
			JOptionPane.showMessageDialog(null, "Item Removido");
		}
		catch(ProdutoNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
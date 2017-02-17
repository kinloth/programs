package Comandos.Produto.Revista;
import javax.swing.JOptionPane;
import Arquivos.ArquivoRevista;
import Comandos.*;
import Produto.*;

public class AtualizaRevista implements Command
{
	private ArquivoRevista arqRevista;
	private Revista revista;
	
	public AtualizaRevista(Revista revista)
	{
		this.revista = revista;
		arqRevista = ArquivoRevista.getInstace();
	}
	
	public void execute()
	{
		if(revista.getCod() > arqRevista.getCodInvalido())
		{
			Object[] options = { "1 - Titulo", "2 - Data", "3 - Editora", "4 - Preco", "5 - Quantidade", "6 - Concluir", "7 - Voltar"};
			int op = -1;
			do
			{
				op = JOptionPane.showOptionDialog(null, "Codigo: " + revista.getCod() + "\nTitulo: " + revista.getTitulo() + "\nData: " + revista.getData() + "\nEditora: " + revista.getEditora()
					+ "\nPreco: " + revista.getPreco() + "\nQuantidade: " + revista.getQuant() + "\nSelecione o campo que deseja atualizar", "Menu", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if(op == 0)revista.setTitulo(JOptionPane.showInputDialog("Digite o titulo: "));
				if(op == 1)revista.setData(JOptionPane.showInputDialog("Digite o autor: "));
				if(op == 2)revista.setEditora(JOptionPane.showInputDialog("Digite a editora: "));
				try
				{
					if(op == 3)revista.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Digite o preco: ")));
					if(op == 4)revista.setQuant(Integer.parseInt(JOptionPane.showInputDialog("Digite a quant: ")));
					if(op == 5)
					{
						revista.escrever(arqRevista.getRandomAccessFile(), arqRevista.getTamanhoRegistro());
					}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Entrada invalida", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}while(op < options.length-2);
			JOptionPane.showMessageDialog(null, "Atualizacao efetuada com sucesso!");
		}
	}
	
	public void undo()
	{
		try
		{
			revista.escrever(arqRevista.getRandomAccessFile(), arqRevista.getTamanhoRegistro());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
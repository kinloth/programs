package Comandos.Produto.Livro;
import javax.swing.JOptionPane;
import Arquivos.ArquivoLivro;
import Comandos.*;
import Produto.*;

public class AtualizaLivro implements Command
{
	private ArquivoLivro arqLivro;
	private Livro livro;
	
	public AtualizaLivro(Livro livro)
	{
		this.livro = livro;
		arqLivro = ArquivoLivro.getInstace();
	}
	
	public void execute()
	{
		if(livro.getCod() > arqLivro.getCodInvalido())
		{
			Livro l = new Livro(livro.getCod(), livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getPreco(), livro.getQuant());
			Object[] options = { "1 - Titulo", "2 - Autor", "3 - Editora", "4 - Preco", "5 - Quantidade", "6 - Concluir", "7 - Voltar"};
			int op = -1;
			do
			{
				op = JOptionPane.showOptionDialog(null, "Codigo: " + l.getCod() + "\nTitulo: " + l.getTitulo() + "\nAutor: " + l.getAutor() + "\nEditora: " + l.getEditora()
					+ "\nPreco: " + l.getPreco() + "\nQuantidade: " + l.getQuant() + "\nSelecione o campo que deseja atualizar", "Menu", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if(op == 0)l.setTitulo(JOptionPane.showInputDialog("Digite o titulo: "));
				if(op == 1)l.setAutor(JOptionPane.showInputDialog("Digite o autor: "));
				if(op == 2)l.setEditora(JOptionPane.showInputDialog("Digite a editora: "));
				try
				{
					if(op == 3)l.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Digite o preco: ")));
					if(op == 4)l.setQuant(Integer.parseInt(JOptionPane.showInputDialog("Digite a quant: ")));
					if(op == 5)
					{
						l.escrever(arqLivro.getRandomAccessFile(), arqLivro.getTamanhoRegistro());
						JOptionPane.showMessageDialog(null, "Atualizacao efetuada com sucesso!");
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
		}
	}
	
	public void undo()
	{
		try
		{
			livro.escrever(arqLivro.getRandomAccessFile(), arqLivro.getTamanhoRegistro());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
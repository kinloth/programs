package Comandos.Produto.Livro;
import javax.swing.JOptionPane;
import Arquivos.ArquivoLivro;
import Comandos.*;
import Produto.*;

public class PesquisaLivro implements Command
{
	private ArquivoLivro arqLivro;
	private Livro livro;
	
	public PesquisaLivro(Livro livro)
	{
		this.livro = livro;
		arqLivro = ArquivoLivro.getInstace();
	}
	
	public void execute()
	{
		Object[] options = { "1 - Codigo", "2 - Titulo"};
		int op = JOptionPane.showOptionDialog(null, "Pesquisa produto pelo: ", "Produto", 
			JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		boolean sucesso = false;
		while(!sucesso)
		{
			livro.setCod(arqLivro.getCodInvalido());
			try
			{
				if (op == 0)
				{
					String temp = JOptionPane.showInputDialog("Digite o cod: ");
					if (temp != null)
					{
						livro.setCod(Integer.parseInt(temp));
						livro.leProduto(arqLivro.getRandomAccessFile(), arqLivro.getTamanhoRegistro());
					}
				}
				else
				{
					String temp = JOptionPane.showInputDialog("Digite o titulo: ");
					if (temp != null)
					{
						livro.setTitulo(temp);
						livro.leProduto(arqLivro.getRandomAccessFile(), arqLivro.getTamanhoRegistro());
					}
				}			
				sucesso = true;
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Entrada invalida", "Erro", JOptionPane.ERROR_MESSAGE);
			}catch(ProdutoNotFoundException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}catch(NullPointerException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void undo(){}
}
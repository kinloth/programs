package Comandos.Produto.Revista;
import javax.swing.JOptionPane;
import Arquivos.ArquivoRevista;
import Comandos.*;
import Produto.*;

public class PesquisaRevista implements Command
{
	private ArquivoRevista arqRevista;
	private Revista revista;
	
	public PesquisaRevista(Revista revista)
	{
		this.revista = revista;
		arqRevista = ArquivoRevista.getInstace();
	}
	
	public void execute()
	{
		Object[] options = { "1 - Codigo", "2 - Titulo"};
		int op = JOptionPane.showOptionDialog(null, "Pesquisa produto pelo: ", "Produto", 
			JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		boolean sucesso = false;
		while(!sucesso)
		{
			revista.setCod(arqRevista.getCodInvalido());
			try
			{
				if (op == 0)
				{
					String temp = JOptionPane.showInputDialog("Digite o cod: ");
					if (temp != null)
					{
						revista.setCod(Integer.parseInt(temp));
						revista.leProduto(arqRevista.getRandomAccessFile(), arqRevista.getTamanhoRegistro());
					}
				}
				else
				{
					String temp = JOptionPane.showInputDialog("Digite o titulo: ");
					if (temp != null)
					{
						revista.setTitulo(temp);
						revista.leProduto(arqRevista.getRandomAccessFile(), arqRevista.getTamanhoRegistro());
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
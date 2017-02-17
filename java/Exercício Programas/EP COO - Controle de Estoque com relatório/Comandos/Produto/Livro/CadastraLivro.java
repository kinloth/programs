package Comandos.Produto.Livro;
import javax.swing.JOptionPane;
import Arquivos.ArquivoLivro;
import Comandos.*;
import Produto.*;

public class CadastraLivro implements Command
{
	private ArquivoLivro arqLivro;
	private Livro livro;
	
	public CadastraLivro()
	{
		arqLivro = ArquivoLivro.getInstace();
	}
	
	public void execute()
	{
		try
		{
			String titulo = JOptionPane.showInputDialog("Digite o titulo: ");
			if (titulo != null)
			{
				String autor = JOptionPane.showInputDialog("Digite o autor: ");
				if (autor != null)
				{
					String editora = JOptionPane.showInputDialog("Digite o editora: ");
					if (editora != null)
					{
						double preco = -1;
						int quant = -1;
						while(preco < 0 || quant < 0)
						{
							try
							{
								if(preco < 0)
								{
									preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preco: "));
								}
								quant = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
							}catch(NumberFormatException e)
							{
								JOptionPane.showMessageDialog(null, "Entrada invalida", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						}
						livro = new Livro(arqLivro.getUltimoCod(), titulo, autor, editora, preco, quant);
						livro.escrever(arqLivro.getRandomAccessFile(), arqLivro.getTamanhoRegistro());
						arqLivro.incrementaUltimoCod();
					}
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
	}
	
	public void undo()
	{
		arqLivro.decrementaUltimoCod();
	}
}
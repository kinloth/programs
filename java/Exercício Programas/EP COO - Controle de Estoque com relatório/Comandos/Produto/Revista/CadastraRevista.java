package Comandos.Produto.Revista;
import javax.swing.JOptionPane;
import Arquivos.ArquivoRevista;
import Comandos.*;
import Produto.*;

public class CadastraRevista implements Command
{
	private ArquivoRevista arqRevista;
	private Revista revista;
	
	public CadastraRevista()
	{
		arqRevista = ArquivoRevista.getInstace();
	}
	
	public void execute()
	{
		try
		{
			String titulo = JOptionPane.showInputDialog("Digite o nome: ");
			if (titulo != null)
			{
				String data = JOptionPane.showInputDialog("Digite a data: ");
				if (data != null)
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
						revista = new Revista(arqRevista.getUltimoCod(), titulo, data, editora, preco, quant);
						revista.escrever(arqRevista.getRandomAccessFile(), arqRevista.getTamanhoRegistro());
						arqRevista.incrementaUltimoCod();
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
		arqRevista.decrementaUltimoCod();
	}
}
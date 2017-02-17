package Comandos.Cliente;
import Comandos.Command;
import Arquivos.ArquivoCliente;
import javax.swing.JOptionPane;
import Cliente.*;

public class PesquisaCliente implements Command
{
	private ArquivoCliente arqCli;
	private Cliente cliente;
	
	public PesquisaCliente(Cliente cli)
	{
		cliente = cli;
		arqCli = ArquivoCliente.getInstace();
	}
	
	public void execute()
	{
		Object[] options = { "1 - Codigo", "2 - Nome"};
		int op = JOptionPane.showOptionDialog(null, "Pesquisa cliente pelo: ", "Cliente", 
			JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		boolean sucesso = false;
		while(!sucesso)
		{
			cliente.setCod(arqCli.getCodInvalido());
			try
			{
				if (op == 0)
				{
					String temp = JOptionPane.showInputDialog("Digite o cod: ");
					if (temp != null)
					{
						cliente.setCod(Integer.parseInt(temp));
						cliente.leCliente(arqCli.getRandomAccessFile(), arqCli.getTamanhoRegistro());
					}
				}
				else
				{
					String temp = JOptionPane.showInputDialog("Digite o nome: ");
					if (temp != null)
					{
						cliente.setNome(temp);
						cliente.leCliente(arqCli.getRandomAccessFile(), arqCli.getTamanhoRegistro());
					}
				}
				sucesso = true;
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Entrada invalida", "Erro", JOptionPane.ERROR_MESSAGE);
			}catch(ClienteNotFoundException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}catch(NullPointerException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void undo(){}
}
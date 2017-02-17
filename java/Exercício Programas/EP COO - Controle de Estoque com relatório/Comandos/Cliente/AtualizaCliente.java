package Comandos.Cliente;
import Comandos.Command;
import Arquivos.ArquivoCliente;
import javax.swing.JOptionPane;
import Cliente.*;

public class AtualizaCliente implements Command
{
	private ArquivoCliente arqCli;
	private Cliente cliente;
	
	public AtualizaCliente(Cliente cli)
	{
		cliente = cli;
		arqCli = ArquivoCliente.getInstace();
	}
	
	public void execute()
	{
		if(cliente.getCod() > arqCli.getCodInvalido())
		{
			Cliente c = new Cliente(cliente.getCod(), cliente.getNome(), cliente.getNCartao());
			Object[] options = { "1 - Nome", "2 - Numero do cartao", "3 - Concluir", "4 - Voltar"};
			int op = -1;
			do
			{
				op = JOptionPane.showOptionDialog(null, "Codigo: " + c.getCod() + "\nNome: " + c.getNome() + "\nN - Cartao: " + c.getNCartao() + "\nSelecione o campo que deseja atualizar", "Menu", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if(op == 0)
				{
					String temp = JOptionPane.showInputDialog("Digite o nome: ");
					if (temp != null)
					{
						c.setNome(temp);
					}
				}
				if(op == 1)
				{
					String temp = JOptionPane.showInputDialog("Digite o numero do seu cartao: ");
					if (temp != null)
					{
						try
						{
							c.setNCartao(Integer.parseInt(temp));
						}
						catch(NumberFormatException e)
						{
							JOptionPane.showMessageDialog(null, "Entrada invalida", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				if(op == 2)
				{
					try
					{
						c.escrever(arqCli.getRandomAccessFile(), arqCli.getTamanhoRegistro());
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
					JOptionPane.showMessageDialog(null, "Atualizacao efetuada com sucesso!");
				}
			}while(op < options.length-2);	
			
		}
	}
	
	public void undo()
	{
		try
		{
			cliente.escrever(arqCli.getRandomAccessFile(), arqCli.getTamanhoRegistro());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
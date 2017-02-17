package Comandos.Cliente;
import Comandos.Command;
import Arquivos.ArquivoCliente;
import javax.swing.JOptionPane;
import Cliente.*;

public class CadastraCliente implements Command
{
	private ArquivoCliente arqCli;
	private Cliente cliente;
	
	public CadastraCliente()
	{
		arqCli = ArquivoCliente.getInstace();
	}
	
	public void execute()
	{
		try
		{
			String nome = JOptionPane.showInputDialog("Digite seu nome: ");
			if(nome != null)
			{
				int card = -1;
				while(card == -1)
				{
					try
					{
						card = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do seu cartao: "));
					}catch(NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, "Entrada invalida", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
				cliente = new Cliente(arqCli.getUltimoCod(), nome, card);
				cliente.escrever(arqCli.getRandomAccessFile(), arqCli.getTamanhoRegistro());
				arqCli.incrementaUltimoCod();
			}
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
	}
	
	public void undo()
	{
		arqCli.decrementaUltimoCod();
	}
}
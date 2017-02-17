package Comandos;
import Comandos.Command;
import Arquivos.*;

public class FecharArquivos implements Command
{
	private ArquivoCliente arquivoCliente;
	private ArquivoRevista arquivoRevista;
	private ArquivoLivro arquivoLivro;
	
	public FecharArquivos()
	{
		arquivoCliente = ArquivoCliente.getInstace();
		arquivoRevista = ArquivoRevista.getInstace();
		arquivoLivro = ArquivoLivro.getInstace();
	}
	
	public void execute()
	{
		arquivoCliente.fechar();
		arquivoRevista.fechar();
		arquivoLivro.fechar();
	}
	
	public void undo(){}
}
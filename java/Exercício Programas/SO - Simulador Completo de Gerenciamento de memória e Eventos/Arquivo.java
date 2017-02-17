import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Arquivo {

	static File entrada;
	static File saida;
	@SuppressWarnings("resource")
	public Scanner criarLeitura(){
		
		Scanner leitura = null;															//inicia as variaveis Files.
		try {
			File arquivoEntrada = entrada;												//seleciona o arquivo para leitura.
			//
			leitura = new Scanner(arquivoEntrada).useDelimiter("[.,:;()?!\"\\s]+");		//abri o arquivo com delimitador.
		}catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}			
		return leitura;
	}
	
	public File escrita(){
		return saida;
	}
	
}

import java.util.Scanner;

public class Main {

	//TODO DADOS DO TERMINAL, nao esqueca de inicializa-los (se necessario)
	static char[][] terminal = new char[10][10];
	static int cursorX = 0;
	static int cursorY = 0;
	static boolean modoDeSobrescrita = true;

	public static void main (String args[])
	{
		Scanner scan = new Scanner (System.in);
		int N = scan.nextInt();
		int numeroDoTeste = 1;
		while (N != 0){
			String linha = scan.nextLine();
			iniciarTerminal();
			System.out.println("Case " + numeroDoTeste);
			for (int contLinhas = 0; contLinhas < N; contLinhas++){
				linha = scan.nextLine();
				executar(linha);
			}
			imprimirTerminal();

			cursorX = 0;
			cursorY = 0;
			N = scan.nextInt();
			numeroDoTeste++;
		}
	}

	static void iniciarTerminal(){
		for(int i = 0; i <10;i++){
			for(int j = 0; j < 10; j++){
				terminal[i][j] = ' ';
			}

		}
	}

	static void imprimirTerminal(){
		System.out.println("+----------+");
		for (int i=0;i<10;i++){
			System.out.print("|");
			for (int j=0;j<10;j++){
				System.out.print(terminal[i][j]);
			}
			System.out.println("|");
		}
		System.out.println("+----------+");
	}

	static void sobre(char ch){

		if (cursorY < 10 && cursorX < 10){
			terminal[cursorX][cursorY] = ch;

			if (cursorY <9){
				cursorY++;}
		}

	}

	static void entrada(char ch){

		if (cursorY < 10 && cursorX < 10){
			for(int i = 9; i > cursorY ; i--){
				terminal[cursorX][i] = terminal[cursorX][i - 1];
			}

			terminal[cursorX][cursorY] = ch;
			if(cursorY <9){
				cursorY++;
			}
		}
	}

	static void executar(String linha){

		for (int i = 0;i < linha.length(); i++){
			if (linha.charAt(i) == '^'){
				switch (linha.charAt(i + 1)){

				case 'b':
					cursorY = 0;
					break;
				case 'c':
					iniciarTerminal();
					break;
				case 'd':
					if(cursorX <9){
						cursorX++;
					}
					break;
				case 'e':
					for(int j = cursorY;j < 10;j++){
						terminal[cursorX][ j] = ' ';
					}
					break;
				case 'h':
					cursorX = 0;
					cursorY = 0;
					break;
				case 'i':
					modoDeSobrescrita = false;
					break;
				case 'l':
					if(cursorY > 0){
						cursorY--;
					}
					break;
				case 'o':
					modoDeSobrescrita = true;
					break;
				case 'r':
					if(cursorY < 9){
						cursorY++;
					}
					break;
				case 'u':
					if(cursorX > 0){
						cursorX--;
					}
					break;
				case '^':

					if(modoDeSobrescrita){
						sobre('^');
					} else{
						entrada('^');
					}

					break;
				default:
					cursorX = linha.charAt(i+1) - 48;
					cursorY = linha.charAt(i+2) -48;
					i++;
					break;
				}

				i++;

				continue;
			}

			if(modoDeSobrescrita){
				sobre(linha.charAt(i));
			} else{
				entrada(linha.charAt(i));
			}
		}
	}
}

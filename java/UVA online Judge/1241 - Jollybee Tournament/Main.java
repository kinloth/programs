import java.util.Scanner;

public class Main {
	static boolean stage[][];

	static int qtd = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		for(int a = scan.nextInt(); a > 0; a--){
			int n = scan.nextInt();
			int participants = (int) Math.pow(2, n);
			
			qtd = 0;
			stage = new boolean[n][participants];
			
			int b = scan.nextInt();
			if(b == 0) {
				continue;
			}
			for (; b > 0; b--) {
				stage[0][scan.nextInt() - 1] = false;
			}
			
			

			for (int i = 0; i < stage.length; i++) {
				for (int j = 0; j < stage[i].length; j++) {
					stage[i][j] = true;
				}
			}

		

			verifyMatch(0, participants);
			System.out.println(qtd);

			
		}

		scan.close();

	}

	public static void verifyMatch(int coluna, int participants) {
		for (int i = 1; i < participants; i += 2) {
			if (!stage[coluna][i] && !stage[coluna][i - 1]) {
				stage[coluna + 1][i / 2] = false;
			} else if (stage[coluna][i] && stage[coluna][i - 1]){
			} else{
				qtd++;
			}
		}

		if (participants != 2) {
			verifyMatch(coluna + 1, participants / 2);
		}

	}
}

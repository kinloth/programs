import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] A;
		int qtdTestes, qtdDias;
		int soma = 0;
		
		while (scan.hasNext()) {
			qtdTestes = scan.nextInt();
			for(int k = 0; k < qtdTestes; k++) {
				qtdDias = scan.nextInt();
				A = new int[qtdDias];
				for (int i = 0; i < qtdDias; i++) {
					A[i] = scan.nextInt();
				}
				for (int i = 1; i < A.length; i++) {
					for (int j = i - 1; j >= 0; j--) {
						if (A[j] <= A[i]) {
							soma++;
						}
					}
				}
				System.out.println(soma);
				soma = 0;
			}
		}
		
		scan.close();
	}
}

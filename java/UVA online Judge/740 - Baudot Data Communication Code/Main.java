import java.util.Scanner;


public class Main {

	public static int converteBin(int b1, int b2, int b3, int b4, int b5) {
		return (b1*16) + (b2*8) + (b3*4) + (b4*2) + (b5*1);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char[] shiftDown = new char[32];
		char[] shiftUp = new char[32];
		char[] shiftCorrente = new char[32];
		
		char[] palavra;
		
		int pos;
    	while (scan.hasNext()){
    		shiftDown = scan.nextLine().toCharArray();
    		shiftUp = scan.nextLine().toCharArray();
    		shiftCorrente = shiftDown;
    		
    		while (scan.hasNextLine()) {
    			palavra = scan.nextLine().toCharArray();
    			
    			for(int i = 0; i < palavra.length; i += 5) {
    				pos = converteBin(Integer.valueOf(palavra[i])-48, Integer.valueOf(palavra[i+1])-48, 
    						Integer.valueOf(palavra[i+2])-48, Integer.valueOf(palavra[i+3])-48, Integer.valueOf(palavra[i+4])-48);
    				
    				if(pos == 27) {
    					shiftCorrente = shiftDown;
    				} else if (pos == 31) {
    					shiftCorrente = shiftUp;
    	    		} else {
    	    			System.out.print(shiftCorrente[pos]);
    	    		}
    			}
    			
    			System.out.println();
    			shiftCorrente = shiftDown;
    		}
		}
    	
    	scan.close();
	}

}

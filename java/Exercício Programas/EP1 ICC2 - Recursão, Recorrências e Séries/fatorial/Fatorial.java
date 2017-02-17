package fatorial;
import base.*;	
public class Fatorial extends Recursivo {
	int m;
	public void setAdditionalParameter (int p) {
		m=p;
	}
	public int getAdditionalParameter () {
		return m;
	}
	public int function (int p) {
		if (p>0) {
			// continuity
			return p*function(p-1);
		}
		// stop condition
		storeStack ();
		return 1;
	}
}


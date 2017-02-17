package produto;
import base.*;
public class Produto extends Recursivo {
	int m;
	public void setAdditionalParameter (int p) {
		m=p;
	}
	public int getAdditionalParameter () {
		return m;
	}
	
	public int function (int n) {
		if (n>0) {
			// continuity
			return m+function(n-1);
		}
		// stop condition
		storeStack ();
		return 0;
	}
}
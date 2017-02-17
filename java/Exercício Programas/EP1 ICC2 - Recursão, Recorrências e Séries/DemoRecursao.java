import produto.*;
import fatorial.*;
import base.*;
import a.*;
import b.*;
import c.*;
import d.*;

class DemoRecursao {
	public static void main (String[] args) {
		int n;
		Recursivo r=new SolC();
		r.setAdditionalParameter (3);
		System.out.println (r.function(5));
		System.out.println (r.getRecursionLength());
		r.dumpStack();
	}
}



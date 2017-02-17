package base;

public abstract class Recursivo {
	protected StackTraceElement[] st;
	public abstract void setAdditionalParameter (int p);
	public abstract int getAdditionalParameter ();
	public abstract int function (int n);
    // must be invoked in the stop condition
	public final void storeStack () {
		StackTraceElement[] newst=
		           Thread.currentThread().getStackTrace();
		if (st==null || st.length<newst.length) {
			st=newst;
		}
	}
    // test functions
	public final void dumpStack () {
		if (st!=null) {
			System.out.println ("Pilha de execucao:");
			for (int i=0;i<st.length;i++) {
				System.out.println (i +":"+ 
				       st[i].getMethodName());
			}
		}
	}
	public final int getStackLength() { return st.length; }
	public final int getRecursionLength() {
		int len=0;
		if (st!=null) {
			for (int i=0;i<st.length;i++) {
				len+=
				 (st[i].getMethodName().equals("function"))?1:0;
			}
		}
		return len;
	}
}


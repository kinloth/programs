import java.util.*;
	
public class BuscaCustoUniforme extends BuscaStrategy
{
	public BuscaCustoUniforme(int v[], int len, int max)
	{
		this.v = v;
		this.len = len;
		MAX = max;
		fila = new PriorityQueue<No>(10, new Comparator<No>()
		{
        	public int compare(No x, No y)
			{	
				if (x.custo < y.custo) return -1;
				else return 1;
			}
		});
		noInicial = new No(v, len);
	}
	
	public String getString()
	{
		return "*** Busca de Custo Uniforme ***";
	}
	
	public No busca()
	{
		int i, j, custo = 0, qtd;
		explorado.clear();
		borda.clear();
		No no = noInicial;
		No novo;
		
		fila.add(no);
		borda.put(no.estadoRe, no);

		do
		{
			if(fila.size() == 0) return null;
			no = (No) fila.remove();
			borda.remove(no.estadoRe);
			explorado.put(no.estadoRe, no);
			custo = no.custo;
			if(custo > MAX) continue;
			if(no != null) if(no.noObjetivo()) return no;
			
			if (no.lO == No.OESTE) qtd = no.qtdOeste;
			else qtd = no.qtdLeste;
			
			while(no.temFilho(qtd))
			{
				novo = no.geraProxFilho(qtd);
				if (!(explorado.containsKey(novo.estadoRe) || borda.containsKey(novo.estadoRe)))
				{
					fila.add(novo);
					borda.put(novo.estadoRe, novo);
				}
				else if(borda.containsKey(novo.estadoRe))
				{
					No aux = (No) borda.get(novo.estadoRe);
					if(aux.custo > novo.custo)
					{
						aux.custo = novo.custo;
						aux.pai = no;
					}
				}
			}

		} while(true);
	}
}

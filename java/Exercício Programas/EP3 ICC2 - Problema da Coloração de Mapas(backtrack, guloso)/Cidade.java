// package ep3_2012;

public class Cidade{
	public String nome;
	public boolean cidadeVisitada = false;
	public int cor = 0;
	public Cidade[] vizinhas;
	public Cidade(String nomeDaCidade){
		nome = nomeDaCidade;
	}
	void adicionarArranjoDeCidadesVizinhas(Cidade[] vizinh){
		vizinhas = vizinh;
	}
	boolean ehVizinha(Cidade cidade1){
		for (int i=0;i<vizinhas.length;i++){
			if (vizinhas[i] == cidade1) return true;
		}
		return false;
	}
}
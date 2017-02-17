package Produto;
import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

public class Revista extends Produto<Revista>
{
	private String titulo;
	private String editora;
	private String data;
	
	public Revista(int cod, String titulo, String data, String editora, double preco, int quant){
		
		this.cod = cod;
		this.titulo = titulo;		
		this.editora = editora;
		this.data = data;
		this.preco = preco;
		this.quant = quant;
	}
	
	public Revista(){};
	
	public Revista(int cod)
	{
		this.cod = cod;
		titulo = null;
	}
	
	public Revista(String titulo)
	{
		this.cod = -1;
		this.titulo = titulo;
	}
	
	public String getTitulo()
	{
		return titulo;
	}	
	
	public String getEditora()
	{
		return editora;
	}
	
	public String getData()
	{
		return data;
	}
	
	
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	
	public void setData(String data)
	{
		this.data = data;
	}
	
	public void setEditora(String editora)
	{
		this.editora = editora;
	}
	
	public String toString(){
		return ("\t\t\tTitulo: "+titulo+"\n\t\t\t Data: "+data+"\n\t\t\t Editora: "+
				editora+"\n\t\t\t Preco: "+preco+"\n\t\t\t Quantidade: "+quant+"\n");
	}
	
	public void leProduto(RandomAccessFile leitura, int tamanho)throws ProdutoNotFoundException
	{
		try{
			if(cod > 0)leitura.seek(Integer.SIZE/8 + (cod-1) * tamanho);
			else leitura.seek(Integer.SIZE/8 + (procuraPeloNome(leitura, tamanho)-1) * tamanho);
			cod = leitura.readInt();
			titulo = leitura.readUTF().trim();
			data = leitura.readUTF().trim();
			editora = leitura.readUTF().trim();
			preco = leitura.readDouble();
			quant = leitura.readInt();
			
		}catch(EOFException e){
			throw new ProdutoNotFoundException();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public int procuraPeloNome(RandomAccessFile leitura, int tamanho)throws ProdutoNotFoundException
	{
		String nomeTemp = null;
		int i = 1;
		try
		{
			while(!(titulo.equals(nomeTemp)))
			{
				leitura.seek(Integer.SIZE/8 + (i-1) * tamanho);
				leitura.readInt();
				nomeTemp = leitura.readUTF().trim();	
				i++;
			}	
		}
		catch(EOFException e)													
		{
			throw new ProdutoNotFoundException();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return i-1;		
	}
	
	public void escrever(RandomAccessFile escrita, int tamanho)throws Exception{
		try
		{	
			StringBuffer limitador = new StringBuffer(titulo);
			limitador.setLength(50);
			escrita.seek(Integer.SIZE/8 + (cod-1) * tamanho);
			
			escrita.writeInt(cod);
			escrita.writeUTF(limitador.toString());

			limitador = new StringBuffer(data);
			limitador.setLength(50);	
			
			escrita.writeUTF(limitador.toString());	
			
			limitador = new StringBuffer(editora);
			limitador.setLength(50);
			
			escrita.writeUTF(limitador.toString());	
			escrita.writeDouble(preco);	
			escrita.writeInt(quant);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void imprimir()
	{
		System.out.println("Codigo do produto: " + cod);
		System.out.println("\t   Titulo: " + titulo.trim());
		System.out.println("\t   Data da Revista: " + data.trim());
		System.out.println("\t   Editora: " + editora.trim());
		System.out.println("\t   Preco: " + preco);
		System.out.println("\t   Quantidade adquirida: " + quant);
	}
	
	public boolean comparaProduto(Revista p1)
	{
		if(p1 == null) 							return false;
		if(p1.getCod() != cod)					return false;
		if(!p1.getTitulo().equals(titulo))		return false;
		if(!p1.getData().equals(data)) 			return false;
		if(!p1.getEditora().equals(editora))	return false;
		if(p1.getPreco() != preco)				return false;
		return true;
	}

}
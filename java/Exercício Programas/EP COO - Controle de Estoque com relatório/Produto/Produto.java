package Produto;

import java.io.EOFException;
import java.io.RandomAccessFile;

public class Produto
{
	private int cod;
	private String titulo;
	private String autor;
	private String editora;
	private double preco;
	private int quant;
	
	public Produto(int cod, String titulo, String autor, String editora, double preco, int quant)
	{
		this.cod = cod;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.preco = preco;
		this.quant = quant;
	}
	
	public int getCod()
	{
		return cod;
	}
	
	public String getTitulo()
	{
		return titulo;
	}
	
	public String getAutor()
	{
		return autor;
	}
	
	public String getEditora()
	{
		return editora;
	}
	
	public double getPreco()
	{
		return preco;
	}
	
	public int getQuant()
	{
		return quant;
	}
	
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	
	public void setAutor(String autor)
	{
		this.autor = autor;
	}
	
	public void setEditora(String editora)
	{
		this.editora = editora;
	}
	
	public void setPreco(double preco)
	{
		this.preco = preco;
	}
	
	public void setQuant(int quant)
	{
		this.quant = quant;
	}
	
	public Produto leProduto(int cod, int tamanho)throws ProdutoNotFoundException
	{
		RandomAccessFile leitura = null;
		Produto p = null;
		try
		{
			leitura = new RandomAccessFile("Produto/produto.txt","r");
			leitura.seek(Integer.SIZE/8 + (cod-1) * tamanho);
			p = new Produto(leitura.readInt(), leitura.readUTF().trim(), leitura.readUTF().trim(), leitura.readUTF().trim(), leitura.readDouble(), leitura.readInt());
			
		}catch(EOFException e)													
		{
			throw new ProdutoNotFoundException();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		finally{
			try{
				leitura.close();
			}catch(Exception e){
					System.err.println(e.getMessage());
			}
		}
		return p;		
	}
	
	public Produto leProduto(String titulo, int tamanho)throws ProdutoNotFoundException
	{
		RandomAccessFile leitura = null;
		Produto p = null;
		String nomeTemp = null;
		int codTemp = 0;
		try
		{
			leitura = new RandomAccessFile("Produto/produto.txt","r");
			leitura.skipBytes(Integer.SIZE/8);
			int i = 1;
			while(true){
				leitura.seek(Integer.SIZE/8 + (i-1) * tamanho);
				codTemp = leitura.readInt();
				nomeTemp = leitura.readUTF().trim();
				if(nomeTemp.equals(titulo)){
					p = new Produto(codTemp, titulo, leitura.readUTF().trim(), leitura.readUTF().trim(),leitura.readDouble(), leitura.readInt());
					break;
				}else{						//descarta
					leitura.readUTF().trim();
					leitura.readUTF().trim();
					leitura.readDouble();
					leitura.readInt();
				}
				i++;				
			}			
			
		}catch(EOFException e)													
		{
			throw new ProdutoNotFoundException();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		finally{
			try{
				leitura.close();
			}catch(Exception e){
					System.err.println(e.getMessage());
			}
		}
		return p;		
	}
	public boolean escreveProduto(int tamanho)
	{
		RandomAccessFile escreveP = null;										//cria um arquivo;
		try{
			escreveP = new RandomAccessFile("Produto/produto.txt","rw");		//cria um fluxo de acesso aleatorio, chamado escrita.
			StringBuffer limitador = new StringBuffer(titulo);					//cria um objeto nome, provido do nome do cliente;
			limitador.setLength(50);											//coloca o tamanhomaximo de 50 chars;
			escreveP.seek(Integer.SIZE/8 + (cod-1) * tamanho);
			
			escreveP.writeInt(cod);											//escreve o codigo do cliente;
			escreveP.writeUTF(limitador.toString());								//escreve o nome do cliente, a partir do objeto anteriormente criado
			limitador = new StringBuffer(autor);
			limitador.setLength(50);			
			escreveP.writeUTF(limitador.toString());										//escreve o numero do cartao do cliente;	
			
			limitador = new StringBuffer(editora);
			limitador.setLength(50);
			escreveP.writeUTF(limitador.toString());	
			
			escreveP.writeDouble(preco);	
			escreveP.writeInt(quant);
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
			return false;
		}finally{
			try{
				escreveP.close();
			}catch(Exception e){
					System.err.println(e.getMessage());
			}
		}
		return true;
	}
	
	public boolean ComparaProduto(Produto p1){
		Produto p2 = new Produto(cod, titulo, autor, editora, preco, quant);
		if(p1.getCod() != p2.getCod())					return false;
		if(!p1.getTitulo().equals(p2.getTitulo()))		return false;
		if(!p1.getAutor().equals(p2.getAutor())) 		return false;
		if(!p1.getEditora().equals(p2.getEditora()))	return false;
		if(p1.getPreco() != p2.getPreco())				return false;
		return true;
	}
}
package Cliente;
import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.*;
import javax.swing.JOptionPane;
import Produto.*;

public class Cliente
{
	private int cod;
	private String nome;
	private int nCartao;
	private List< Produto > carrinho;
	
	public Cliente(int cod, String nome, int nCartao)
	{
		this.cod = cod;
		this.nome = nome;
		this.nCartao = nCartao;
	}
	
	public int getCod()
	{
		return cod;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public int getNCartao()
	{
		return nCartao;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public void setNCartao(int nCartao)
	{
		this.nCartao = nCartao;
	}
	
	public void adicionaProduto(Produto p)	throws ProdutoNotFoundException		//tem que usar o leProduto da outra classe que vai retornar o produto, posso fazer essa parte se quiser
	{	
		if(carrinho == null)
		{
			carrinho = new LinkedList< Produto >();
		}
		Produto atual;
		int tam = carrinho.size();
		for(int i= 0; i < tam; i++ ){
			atual = carrinho.get(i);
			if(p.ComparaProduto(atual)){
				if(atual.getQuant() < p.getQuant()){
					atual.setQuant(atual.getQuant()+1);
					return;
				}else{
					throw new ProdutoNotFoundException("Sentimos muito, mas nao ha mais produtos no estoque");
				}
			}
		}
		carrinho.add(p);
		atual = carrinho.get(carrinho.size()-1);
		atual.setQuant(1);	
		JOptionPane.showMessageDialog(null, "Produto Adicionado");
	}	
	
	public void removeProduto(int cod)throws ProdutoNotFoundException			//Remove do carrinho de compras
	{	
		try{
			ListIterator<Produto> iterator = carrinho.listIterator(); 			//cria o iterator
			while(iterator.hasNext()){											//ateh o final da lista
				Produto atual = iterator.next();								//atual recebe a posiçao atual apontado pelo iterator
				if(atual.getCod() == cod){										//se o codigo desse produto for o mesmo que procuramos...
					carrinho.remove(atual);										//remove ele da lista;
					return;
				}
			}				
			throw new ProdutoNotFoundException();
		}catch(NullPointerException e){
			throw new ProdutoNotFoundException("Nao ha produtos no carrinho");
		}
	}
	
	public void	removeProduto(String titulo)throws ProdutoNotFoundException{
		
		try
		{	
			ListIterator<Produto> iterator = carrinho.listIterator(); 			//cria o iterator
			while(iterator.hasNext()){											//ateh o final da lista
				Produto atual = iterator.next();								//atual recebe a posicaao atual apontado pelo iterator
				if(atual.getTitulo().equals(titulo)){							//se o codigo desse produto for o mesmo que procuramos...
					carrinho.remove(atual);										//remove ele da lista;
					return;
				}				
			}
			throw new ProdutoNotFoundException();
		}catch(NullPointerException e)
		{
			throw new ProdutoNotFoundException("Nao ha produtos no carrinho");
		}
	}
	
	public boolean imprimeCarrinho(){	
		try
		{
			if(carrinho.isEmpty()){
				JOptionPane.showMessageDialog(null, "Carrinho Vazio");
				return false;
			}			
			ListIterator<Produto> iterator = carrinho.listIterator(); 			//cria o iterator
			System.out.println("Itens no carrinho: ");
			while(iterator.hasNext()){											//enquanto nao chegar no final da lista;
				 Produto produto = iterator.next();								//'produto' recebe o elemento da lista, apontado pelo iterator
				 System.out.printf(produto.getCod()+"   "+produto.getTitulo().trim()+"   "+produto.getAutor().trim()+"  "+produto.getEditora().trim()+"   "+produto.getPreco()+"   "+produto.getQuant());
				 System.out.println("\n");
			}
		}catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Nao ha produtos no carrinho", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
	
	public Cliente leCliente(String nome, int tamanho)throws ClienteNotFoundException
	{
		RandomAccessFile leitura = null;
		Cliente c = null;
		int codTemp = 0;
		String nomeTemp;
		try
		{		
			leitura = new RandomAccessFile("Cliente/cliente.txt","r");
			leitura.skipBytes(Integer.SIZE/8);
			int i = 1;
			while(true)
			{		
				leitura.seek(Integer.SIZE/8 + (i-1) * tamanho);
				codTemp = leitura.readInt();											//le o cod do cliente atual;
				nomeTemp = leitura.readUTF().trim();
				if(nome.equals(nomeTemp)){	
					int temp = leitura.readInt(); 
					c = new Cliente(codTemp, nome, temp);
					break;
				}
				i++;
			}	
		}catch(EOFException e)															
		{
			throw new ClienteNotFoundException();
		}
		catch(IOException e)															
		{
			throw new ClienteNotFoundException();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		finally{
			try{
				leitura.close();
			}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Falha ao feixar o arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		return c;		
	}
	
	public Cliente leCliente(int cod, int tamanho)throws ClienteNotFoundException
	{
		RandomAccessFile leitura = null;
		Cliente c = null;
		try
		{
			leitura = new RandomAccessFile("Cliente/cliente.txt","r");
			leitura.seek(Integer.SIZE/8 + (cod-1) * tamanho);
			c = new Cliente(leitura.readInt(), leitura.readUTF().trim(), leitura.readInt());	
			
		}catch(EOFException e)															
		{
			throw new ClienteNotFoundException();
		}
		catch(IOException e)															
		{
			throw new ClienteNotFoundException();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		finally{
			try{
				leitura.close();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Falha ao feixar o arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		return c;
	}
	

	public boolean escreveCliente(int tamanho)									//escreve o registro de um cliente em um arquivo de acesso aleatario). 
	{
		RandomAccessFile escrita = null;										//cria um arquivo;
		try{
			escrita = new RandomAccessFile("Cliente/cliente.txt","rw");		//cria um fluxo de acesso aleatorio, chamado escrita.
			StringBuffer name = new StringBuffer(nome);							//cria um objeto nome, provido do nome do cliente;
			name.setLength(50);													//coloca o tamanhomaximo de 50 chars;
			escrita.seek(Integer.SIZE/8 + (cod-1) * tamanho);
			escrita.writeInt(cod);												//escreve o codigo do cliente;
			escrita.writeUTF(name.toString());									//escreve o nome do cliente, a partir do objeto anteriormente criado
			escrita.writeInt(nCartao);											//escreve o numero do cartao do cliente;		
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}finally{
			try{
				escrita.close();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Falha ao feixar o arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		return true;
	}
	
	public boolean finalizaCompra(int tamanhoProd)						//percorrer a lista carrinho. Pegar o primeiro produto do carrinho, pequisar ele pelo codigo (leProduto), pegar a quant em estoque - a quant desejada e utilizar escreveProduto
	{
		try{
			ListIterator<Produto> iterator = carrinho.listIterator();
			while(iterator.hasNext()){
				Produto atual = iterator.next();
				Produto p = atual.leProduto(atual.getCod(), tamanhoProd);
				p.setQuant(p.getQuant() - atual.getQuant());
				p.escreveProduto(tamanhoProd);
			}
		}catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Nao ha produtos no carrinho", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}	
		return true;		
	}
	
	public boolean escreveRelatorio()										//escreve no arquivo de aceesso sequencial (Relatorio.txt) relatorio o cod e nome do cliente, e os produtos adquiridos, e valor total gasto
	{
		
		File relatorio = new File("Relatorio.txt");
		double precoTotal = 0;
		FileWriter escrever = null;
		PrintWriter relat =	null;	
		try{
			ListIterator<Produto> iterator = carrinho.listIterator();
			escrever = new FileWriter(relatorio, true);
			relat =	new PrintWriter(escrever);
			relat.print("Codigo do cliente: " + cod +"\t");
			relat.print("Nome: " + nome);
			relat.println();
			while(iterator.hasNext()){
				Produto atual = iterator.next();
				relat.print("Codigo do produto: " + atual.getCod()+"\t");
				relat.println("Titulo: " + atual.getTitulo().trim());
				relat.println("\t\t\tAutor: " + atual.getAutor().trim()+"\t");
				relat.println("\t\t\tEditora: " + atual.getEditora().trim()+"\t");
				relat.println("\t\t\tPreco: " + atual.getPreco());
				relat.println("\t\t\tQuantidade adquirida: " + atual.getQuant());
				relat.println();
				precoTotal = precoTotal + atual.getPreco();
			}
			relat.println("Valor total = "+precoTotal);
			relat.println();			
		}catch(NullPointerException e)
		{			
			JOptionPane.showMessageDialog(null, "Nao ha produtos no carrinho", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);		
		}finally{
			try{
				relat.close();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		return true;
	}
}
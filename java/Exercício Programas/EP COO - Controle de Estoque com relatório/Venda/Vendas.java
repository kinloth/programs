package Venda;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.File;
import Cliente.*;
import Produto.*;
import Arquivos.*;
import java.io.*;
import java.util.*;

public class Vendas//mediator
{	
	private Cliente cliente;
	private Produto produto;
	
	public Vendas(){}
	
	public Vendas(Cliente c, Produto p)
	{
		cliente = c;
		produto = p;
	}
	
	public void adicionaProduto()throws ProdutoNotFoundException
	{	
		if (produto != null)
		{
			if(cliente.carrinho == null)
			{
				cliente.carrinho = new LinkedList< Produto >();
			}
			Produto atual;
			int tam = cliente.carrinho.size();
			for(int i= 0; i < tam; i++ )
			{
				atual = cliente.carrinho.get(i);
				if(produto.getClass().equals(atual.getClass()))//Sao do msm tipo
				{
					if(produto.comparaProduto(atual))
					{
						if(atual.getQuant() < produto.getQuant() && produto.getQuant() > 0)
						{
							atual.setQuant(atual.getQuant()+1);
							return;
						}
						else
						{
							throw new ProdutoNotFoundException("Sentimos muito, mas nao ha mais produtos no estoque");
						}
					}
				}
			}
			if(produto.getQuant() > 0)
			{
				cliente.carrinho.add(produto);
				atual = cliente.carrinho.get(cliente.carrinho.size()-1);
				atual.setQuant(1);
			}
			else
			{
				throw new ProdutoNotFoundException("Sentimos muito, mas nao ha mais produtos no estoque");
			}
		}
	}
	
	public void removeProduto()throws ProdutoNotFoundException
	{	
		try
		{
			ListIterator<Produto> iterator = cliente.carrinho.listIterator();
			while(iterator.hasNext())
			{
				Produto atual = iterator.next();
				if(atual.getCod() == produto.getCod())
				{
					cliente.carrinho.remove(atual);
					JOptionPane.showMessageDialog(null, "Produto Removido");
					return;
				}
			}
			throw new ProdutoNotFoundException();
		}
		catch(NullPointerException e){
			throw new ProdutoNotFoundException("Nao ha produtos no carrinho");
		}
	}
	
	public void imprimeCarrinho()throws ProdutoNotFoundException
	{	
		try
		{
			if(cliente.carrinho.isEmpty())
			{
				throw new ProdutoNotFoundException("Carrinho Vazio");
			}			
			ListIterator<Produto> iterator = cliente.carrinho.listIterator();
			System.out.println("Itens no carrinho: ");
			while(iterator.hasNext())
			{
				Produto produto = iterator.next();
				produto.imprimir();
			}
		}
		catch(NullPointerException e)
		{
			throw new ProdutoNotFoundException("Carrinho Vazio");
		}
	}
	
	public void finalizaCompra()throws ProdutoNotFoundException
	{
		try
		{
			ListIterator<Produto> iterator = cliente.carrinho.listIterator();
			while(iterator.hasNext())
			{
				Produto atual = iterator.next();
				Produto p = null;
				if(atual.getClass().equals(new Livro().getClass()))//ehLivro
				{
					p = new Livro(atual.getCod());				
					ArquivoLivro arqLivro = ArquivoLivro.getInstace();
					RandomAccessFile leitura = arqLivro.getRandomAccessFile();
					p.leProduto(leitura, arqLivro.getTamanhoRegistro());
					p.setQuant(p.getQuant() - atual.getQuant());
					p.escrever(leitura, arqLivro.getTamanhoRegistro());
				}
				if(atual.getClass().equals(new Revista().getClass()))//ehRevista
				{
					p = new Revista(atual.getCod());
					ArquivoRevista arqRevista = ArquivoRevista.getInstace();
					RandomAccessFile leitura = arqRevista.getRandomAccessFile(); 
					p.leProduto(leitura, arqRevista.getTamanhoRegistro());
					p.setQuant(p.getQuant() - atual.getQuant());
					p.escrever(leitura, arqRevista.getTamanhoRegistro());
				}
			}
		}
		catch(NullPointerException e)
		{
			throw new ProdutoNotFoundException("Carrinho Vazio");
		}
		catch(Exception e)
		{
			throw new ProdutoNotFoundException();
		}
	}
	
	public void escreveRelatorio()throws ProdutoNotFoundException
	{	
		File relatorio = new File("Venda/Relatorio.txt");
		double precoTotal = 0;
		FileWriter escrever = null;
		PrintWriter relat =	null;	
		try
		{
			ListIterator<Produto> iterator = cliente.carrinho.listIterator();
			escrever = new FileWriter(relatorio, true);
			relat =	new PrintWriter(escrever);
			relat.print("Codigo do cliente: " + cliente.getCod() +"\t");
			relat.print("Nome: " + cliente.getNome()+"\n");
			while(iterator.hasNext())
			{
				Produto atual = iterator.next();
				relat.println(atual.toString());
				relat.println("\t\t\tQuantidade adquirida: "+atual.getQuant()+"\n");
				precoTotal = precoTotal + atual.getPreco()*atual.getQuant();
			}
			relat.println("Valor total = "+precoTotal);
			relat.println();			
		}
		catch(NullPointerException e)
		{			
			throw new ProdutoNotFoundException("Nao ha produtos no carrinho");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		finally
		{
			try
			{
				relat.close();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void geraRelatorio()
	{
		BufferedReader  br = null;
		try
		{
			br = new BufferedReader(new FileReader("Venda/Relatorio.txt"));
			String linha = br.readLine();
			while(linha != null)
			{
				System.out.println(linha);
				linha = br.readLine();
			}
		}catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "Relatorio.txt nao encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		finally
		{
			try
			{
				br.close();
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
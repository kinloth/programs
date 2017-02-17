import java.io.*;
import Cliente.*;
import Produto.*;
import javax.swing.JOptionPane;
import java.lang.NumberFormatException;

class Aplicativo
{
	private int codCliente;
	private int codProduto;
	private int tamanhoCliente;
	private int tamanhoProduto;
	
	public static void main(String args[])
	{
		Aplicativo ap = new Aplicativo();
		ap.tamanhoCliente = Integer.SIZE/8 + 50*2 + Integer.SIZE/8;
		ap.tamanhoProduto = Integer.SIZE/8 + 50*2 + 50*2 + 50*2 + Double.SIZE/8 + Integer.SIZE/8;
		ap.codCliente = ap.getCod("Cliente/cliente.txt");
		ap.codProduto = ap.getCod("Produto/produto.txt");
		ap.mostraMenu();
	}
	
	private void mostraMenu()
	{
		Object[] options = {"Cadastra Cliente", "Cadastra Produto", "Atualiza Cliente", "Atualiza Produto", "Venda", "Gerar Relatorio", "Sair"};
		int op = 0;
		while(op != options.length-1)
		{
			op = JOptionPane.showOptionDialog(null, "Selecione a opcao desejada: ", "Menu", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		
			switch (op)
			{
				case 0:
					cadastraCliente();
					break;
				case 1:
					cadastraProduto();
					break;
				case 2:
					atualizaCliente();
					break;
				case 3:
					atualizaProduto();
					break;
				case 4:
					vendaProdutos();
					break;
				case 5:
					geraRelatorio();
					break;
			}
		}
		setCod("Cliente/cliente.txt", codCliente);
		setCod("Produto/produto.txt", codProduto);
	}
	
	private void setCod(String local, int cod)
	{
		RandomAccessFile raf = null;
		try
		{
			raf = new RandomAccessFile(local, "rw");
			raf.writeInt(cod);
			raf = new RandomAccessFile("Relatorio.txt", "rw");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		finally
		{
			try
			{
				raf.close();
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private int getCod(String local)
	{
		RandomAccessFile raf = null;
		int cod = -1;
		try
		{
			raf = new RandomAccessFile(local, "rw");
			cod = raf.readInt();
		}catch(EOFException e)
		{
			cod = 1;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		finally
		{
			try
			{
				raf.close();
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		return cod;
	}
	
	private void cadastraCliente()
	{
		String nome = JOptionPane.showInputDialog("Digite seu nome: ");
		if(nome != null)
		{
			int card = -1;
			while(card == -1)
			{
				try
				{
					card = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do seu cartao: "));
				}catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Entrada invalida", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			Cliente c = new Cliente(codCliente, nome, card);
			if (c.escreveCliente(tamanhoCliente))
			{
				codCliente++;
				JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
			}
		}
	}
	
	private void cadastraProduto()
	{
		String titulo = JOptionPane.showInputDialog("Digite o titulo: ");
		if (titulo != null)
		{
			String autor = JOptionPane.showInputDialog("Digite o autor: ");
			if (autor != null)
			{
				String editora = JOptionPane.showInputDialog("Digite o editora: ");
				if (editora != null)
				{
					double preco = -1;
					int quant = -1;
					while(preco < 0 || quant < 0)
					{
						try
						{
							if(preco < 0)
							{
								preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preco: "));
							}
							quant = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
						}catch(NumberFormatException e)
						{
							JOptionPane.showMessageDialog(null, "Entrada invalida", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
					Produto p = new Produto(codProduto, titulo, autor, editora, preco, quant);
					if (p.escreveProduto(tamanhoProduto))
					{
						codProduto++;
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
					}
				}
			}
		}
	}
	
	private void atualizaCliente()
	{
		Cliente c = pesquisaCliente();
		if(c != null)
		{
			Object[] options = { "1 - Nome", "2 - Numero do cartao", "3 - Concluir", "4 - Voltar"};
			int op = -1;
			do
			{
				op = JOptionPane.showOptionDialog(null, "Codigo: " + c.getCod() + "\nNome: " + c.getNome() + "\nN - Cartao: " + c.getNCartao() + "\nSelecione o campo que deseja atualizar", "Menu", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if(op == 0)
				{
					String temp = JOptionPane.showInputDialog("Digite o nome: ");
					if (temp != null)
					{
						c.setNome(temp);
					}
				}
				if(op == 1)
				{
					String temp = JOptionPane.showInputDialog("Digite o numero do seu cartao: ");
					if (temp != null)
					{
						try
						{
							c.setNCartao(Integer.parseInt(temp));
						}
						catch(NumberFormatException e)
						{
							JOptionPane.showMessageDialog(null, "Entrada invalida", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				if(op == 2 && c.escreveCliente(tamanhoCliente))
				{
					JOptionPane.showMessageDialog(null, "Atualizacao efetuada com sucesso!");
				}
			}while(op < options.length-2);	
		}
	}
	
	private void atualizaProduto()
	{
		Produto p = pesquisaProduto();
		if(p != null)
		{
			Object[] options = { "1 - Titulo", "2 - Autor", "3 - Editora", "4 - Preco", "5 - Quantidade", "6 - Concluir", "7 - Voltar"};
			int op = -1;
			do
			{
				op = JOptionPane.showOptionDialog(null, "Codigo: " + p.getCod() + "\nTitulo: " + p.getTitulo() + "\nAutor: " + p.getAutor() + "\nEditora: " + p.getEditora()
					+ "\nPreco: " + p.getPreco() + "\nQuantidade: " + p.getQuant() + "\nSelecione o campo que deseja atualizar", "Menu", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if(op == 0)p.setTitulo(JOptionPane.showInputDialog("Digite o titulo: "));
				if(op == 1)p.setAutor(JOptionPane.showInputDialog("Digite o autor: "));
				if(op == 2)p.setEditora(JOptionPane.showInputDialog("Digite a editora: "));
				try
				{
					if(op == 3)p.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Digite o preco: ")));
					if(op == 4)p.setQuant(Integer.parseInt(JOptionPane.showInputDialog("Digite a quant: ")));
					if(op == 5 && p.escreveProduto(tamanhoProduto))
					{
						JOptionPane.showMessageDialog(null, "Atualizacao efetuada com sucesso!");
					}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Entrada invalida", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}while(op < options.length-2);
		}
	}
	
	private void vendaProdutos()
	{
		Cliente c = pesquisaCliente();
		if(c != null)
		{
			Object[] options = { "1 - Adicionar Produto", "2 - Remover Produto", "3 - Imprimir Carrinho", "4 - Concluir Compra", "5 - Voltar"};
			Object[] codTit = {"1 - Codigo", "2 - Titulo"};
			int op = -1;
			do
			{
				op = JOptionPane.showOptionDialog(null, "Selecione a acao desejada: ", "Menu", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				try
				{
					if(op == 0)
					{
						Produto p = pesquisaProduto();
						if (p != null)
						{
							c.adicionaProduto(p);
						}
					}
					if(op == 1)
					{
						int removeOp = JOptionPane.showOptionDialog(null, "Remover pelo: ", "Menu", 
							JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, codTit, codTit[0]);
						if(removeOp == 0)c.removeProduto(Integer.parseInt(JOptionPane.showInputDialog("Digite o cod: ")));
						else
						{
							String temp = JOptionPane.showInputDialog("Digite o nome: ");
							if (temp != null)c.removeProduto(temp);
						}
					}
				}catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Entrada invalida", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				catch(ProdutoNotFoundException e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
				if(op == 2)c.imprimeCarrinho();
				if(op == 3)
				{
					if(c.imprimeCarrinho())
					{
						if (c.finalizaCompra(tamanhoProduto))
						{
							if (c.escreveRelatorio())
							{
								JOptionPane.showMessageDialog(null, "Compra Efetuada");
							}
						}
					}
				}
			}while(op < 3);
		}
	}
	
	private void geraRelatorio()
	{
		BufferedReader  br = null;
		try
		{
			br = new BufferedReader(new FileReader("Relatorio.txt"));
			String linha = br.readLine();
			while(linha != null)
			{
				System.out.println(linha);
				linha = br.readLine();
			}
		}catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "Relatorio.txt não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
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
	
	private Produto pesquisaProduto()
	{
		Object[] options = { "1 - Codigo", "2 - Titulo"};
		int op = JOptionPane.showOptionDialog(null, "Pesquisa produto pelo: ", "Produto", 
			JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		Produto p = new Produto(-1, null, null, null, -1, -1);
		boolean sucesso = false;
		while(!sucesso)
		{
			try
			{
				if (op == 0)
				{
					String temp = JOptionPane.showInputDialog("Digite o cod: ");
					if (temp != null)
					{
						p = p.leProduto(Integer.parseInt(temp), tamanhoProduto);
					}
					else p = null;
				}
				else
				{
					String temp = JOptionPane.showInputDialog("Digite o titulo: ");
					if (temp != null)
					{
						p = p.leProduto(temp, tamanhoProduto);
					}
					else p = null;
				}			
				sucesso = true;
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Entrada invalida", "Erro", JOptionPane.ERROR_MESSAGE);
			}catch(ProdutoNotFoundException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		return p;
	}
	
	private Cliente pesquisaCliente()
	{
		Object[] options = { "1 - Codigo", "2 - Nome"};
		int op = JOptionPane.showOptionDialog(null, "Pesquisa cliente pelo: ", "Cliente", 
			JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		Cliente c = new Cliente(-1, null, -1);
		boolean sucesso = false;
		while(!sucesso)
		{
			try
			{
				if (op == 0)
				{
					String temp = JOptionPane.showInputDialog("Digite o cod: ");
					if (temp != null)
					{
						c = c.leCliente(Integer.parseInt(temp), tamanhoCliente);
					}
					else c = null;
				}
				else
				{
					String temp = JOptionPane.showInputDialog("Digite o nome: ");
					if (temp != null)
					{
						c = c.leCliente(temp, tamanhoCliente);
					}
					else c = null;
				}
				sucesso = true;
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Entrada invalida", "Erro", JOptionPane.ERROR_MESSAGE);
			}catch(ClienteNotFoundException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}catch(NullPointerException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		return c;
	}
}
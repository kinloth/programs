package Arquivos;
import javax.swing.JOptionPane;
import java.io.*;

public class Arquivos
{
	protected int COD_INVALIDO = 0;
	protected int TAMANHO_REGISTRO;
	protected RandomAccessFile raf;
	protected int ultimoCod;
	protected String local;

	protected Arquivos(){}
	
	public void abrir()
	{
		try
		{
			raf = new RandomAccessFile(local, "rw");
			ultimoCod = raf.readInt();
		}catch(EOFException e)
		{
			ultimoCod = 1;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void fechar()
	{
		try
		{
			raf.seek(0);
			raf.writeInt(ultimoCod);
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
	
	public RandomAccessFile getRandomAccessFile()
	{
		return raf;
	}
	
	public int getTamanhoRegistro()
	{
		return TAMANHO_REGISTRO;
	}
	
	public int getUltimoCod()
	{
		return ultimoCod;
	}
	
	public int getCodInvalido()
	{
		return COD_INVALIDO;
	}
	
	public void incrementaUltimoCod()
	{
		ultimoCod++;
	}
	
	public void decrementaUltimoCod()
	{
		ultimoCod--;
	}
}

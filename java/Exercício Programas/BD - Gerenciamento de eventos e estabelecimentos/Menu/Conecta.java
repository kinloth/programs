package Menu;

import java.sql.*;
import javax.swing.*;

public class Conecta
{
	public Connection connection = null;
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String DBNAME = "bd";
	private final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
	private final String LOGIN = "root"; //pode ser diferente em outras maquinas
	private final String PASSWORD = "1234"; //pode ser diferente em outras maquinas
		
	public boolean getConnection()
	{
		try
		{
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			//JOptionPane.showMessageDialog(null, "Conexao realizada com sucesso");
			return true;
		}
		catch(ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "Driver JDBC-OCBC nao encontrado!\n" + e.toString());
			return false;
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Problema na conexao com a fonte de dados!\n" + e.toString());
			return false;
		}
	}
        
        
	
	public void close()
	{
                if(connection == null) return;
		try
		{
			connection.close();
			//JOptionPane.showMessageDialog(null, "Desconexao realizada com sucesso");
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Problema na desconexao com a fonte de dados!\n" + e.toString());
		}
	}
}
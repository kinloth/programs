package Menu;

import java.text.*;  
import java.util.*;  
import java.sql.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Comandos {

    public void excluir(int cod_lugar) {
        Conecta BD = new Conecta();
        if (BD.getConnection()) {
            try {
                System.out.println(cod_lugar);
                String sql = "delete from lugar where cod_lugar = ?";
                PreparedStatement statement = BD.connection.prepareStatement(sql);
                statement.setInt(1, cod_lugar);
                statement.execute();
                BD.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Falha na exclusao!\n" + e.toString());
            }
        }
    }

    public void inserirPessoa( int CPF, String nome, String date, int RG,String rua,
         String cidade, String UF, String pais, String bairro, int numeroCasa, String inf) {
        Conecta BD = new Conecta();
        if (BD.getConnection()) {
            try {
                String sql = "insert into pessoa values (?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = BD.connection.prepareStatement(sql);
                statement.setInt(1, CPF);
                statement.setString(2, nome);
				
                statement.setDate(3, formataData(date));
                statement.setInt(4, RG);

                statement.setString(5, rua);                
                statement.setString(6, cidade);
                statement.setString(7, UF);
                statement.setString(8, pais);
                statement.setString(9, bairro);
				
                statement.setInt(10, numeroCasa);
                statement.setString(11, inf);
                
                statement.execute();
                BD.close();
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!\n");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Falha na insercao dos dados!\n" + e.toString());
            }
			catch(Exception e)
			{
                JOptionPane.showMessageDialog(null, "Falha na conversão da data!\n" + e.toString());
			}
        }

    }
	
	public void inserirProprietario(String ID, java.sql.Date dataAtual, java.sql.Date dataTermino) {
        Conecta BD = new Conecta();
        if (BD.getConnection()) {
            try {
                String sql = "insert into proprietario values (?,?,?)";
                PreparedStatement statement = BD.connection.prepareStatement(sql);
                statement.setString(1, ID);
                statement.setDate(2, dataAtual);
                statement.setDate(3, dataTermino);
                
                statement.execute();
                BD.close();
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!\n");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Falha na insercao dos dados!\n" + e.toString());
            }
			catch(Exception e)
			{
                JOptionPane.showMessageDialog(null, "Falha na conversão da data!\n" + e.toString());
			}
        }

    }
	
	public static java.sql.Date formataData(String data) throws Exception {   
        if (data == null || data.equals(""))  
            return null;  
          
        java.sql.Date date = null;  
        try {  
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );  
        } catch (ParseException e) {              
            throw e;  
        }  
        return date;  
    }

    public void inserirConta(int CPF, String senha, String ID, int tipo_conta) {
        Conecta BD = new Conecta();
        if (BD.getConnection()) {
            try {
                String sql = "insert into conta values (?,?,?,?)";
                PreparedStatement statement = BD.connection.prepareStatement(sql);
                statement.setInt(1, CPF);
                statement.setString(2, senha);
                statement.setString(3, ID);
                statement.setInt(4, tipo_conta);

                statement.execute();
                BD.close();
                JOptionPane.showMessageDialog(null, "Conta inserida com sucesso!\n");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Falha na insercao dos dados!\n" + e.toString());
            }
        }

    }

    public boolean confere(String string, String campo) {
        if (string.equals("")) {
            JOptionPane.showMessageDialog(null, "Adicione " + campo + "!\n");
            return false;
        }
        return true;
    }
    
    public String[] PegarEvento(){
        Conecta BD = new Conecta();
        String[] cod = null;
        if (BD.getConnection()) {
            try {
                String sql = "SELECT COUNT(cod_evento) FROM evento;";
                PreparedStatement statement = BD.connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                int max = resultSet.getInt(0);
                
                cod = new String[max];
                sql = "SELECT COUNT(cod_evento) FROM evento;";
                statement = BD.connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                resultSet.next();
                for(int i =0; i<cod.length;i++){
                    cod[i] = Integer.toString(resultSet.getInt(i));
                }
                
                BD.close();
            } catch (SQLException e) {
            }
            
        }
        return cod;
        
        
    }
    
	public String buscaEstabelecimentoNome(String parametroBusca) {
		Conecta BD = new Conecta();
		String retorno = "";
		String sql = "select * from Estabelecimento where Nome = ?";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
			statement.setString(1, parametroBusca);
            ResultSet resultSet = statement.executeQuery();
           while(resultSet.next())
		   {
            retorno += resultSet.getString(3) + "\t";
            retorno += resultSet.getString(4) + "\t";
            retorno += resultSet.getString(5) + "\t";
            retorno += resultSet.getString(6) + "\t";
            retorno += resultSet.getString(7) + "\t";
            retorno += resultSet.getString(8) + "\t";
            retorno += resultSet.getString(9) + "\t";
            retorno += resultSet.getInt(10) + "\t";
           }
        }catch (SQLException ex) {
			Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
        return retorno;
    }
	
	public String buscaEstabelecimentoTipo(String parametroBusca) {
		Conecta BD = new Conecta();
		String retorno = "";
		String sql = "select * from Estabelecimento where Tipo = ?";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
			statement.setString(1, parametroBusca);
            ResultSet resultSet = statement.executeQuery();
           while(resultSet.next())
		   {
            retorno += resultSet.getString(3) + "\t";
            retorno += resultSet.getString(4) + "\t";
            retorno += resultSet.getString(5) + "\t";
            retorno += resultSet.getString(6) + "\t";
            retorno += resultSet.getString(7) + "\t";
            retorno += resultSet.getString(8) + "\t";
            retorno += resultSet.getString(9) + "\t";
            retorno += resultSet.getInt(10) + "\t";
           }
        }catch (SQLException ex) {
			Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
        return retorno;
    }
	
	public String buscaEstabelecimentoCidade(String parametroBusca) {
		Conecta BD = new Conecta();
		String retorno = "";
		String sql = "select * from Estabelecimento where cidade = ?";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
			statement.setString(1, parametroBusca);
            ResultSet resultSet = statement.executeQuery();
           while(resultSet.next())
		   {
            retorno += resultSet.getString(3) + "\t";
            retorno += resultSet.getString(4) + "\t";
            retorno += resultSet.getString(5) + "\t";
            retorno += resultSet.getString(6) + "\t";
            retorno += resultSet.getString(7) + "\t";
            retorno += resultSet.getString(8) + "\t";
            retorno += resultSet.getString(9) + "\t";
            retorno += resultSet.getInt(10) + "\t";
           }
        }catch (SQLException ex) {
			Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
        return retorno;
    }
	
	public String buscaEstabelecimentoBairro(String parametroBusca) {
		Conecta BD = new Conecta();
		String retorno = "";
		String sql = "select * from Estabelecimento where Bairro = ?";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
			statement.setString(1, parametroBusca);
            ResultSet resultSet = statement.executeQuery();
           while(resultSet.next())
		   {
            retorno += resultSet.getString(3) + "\t";
            retorno += resultSet.getString(4) + "\t";
            retorno += resultSet.getString(5) + "\t";
            retorno += resultSet.getString(6) + "\t";
            retorno += resultSet.getString(7) + "\t";
            retorno += resultSet.getString(8) + "\t";
            retorno += resultSet.getString(9) + "\t";
            retorno += resultSet.getInt(10) + "\t";
           }
        }catch (SQLException ex) {
			Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
        return retorno;
    }

	//Select com operadores de conjunto
	public String eventosNoEstabelecimento()
	{
		Conecta BD = new Conecta();
                String st = "";
        String sql = "SELECT Descricao, Rua, Cidade, UF from evento INNER JOIN estabelecimento USING (Descricao,Rua,Cidade,UF)";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
			st += "Descricao\tRua\tCidade\tUF\n";
           while(resultSet.next()){
				st += resultSet.getString(1) + "\t   " + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" + resultSet.getString(4)+"\n";
           }
        } catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
        return st;
	}
        
         //Select com operadores de conjunto
	public String sugereEvento()
	{
                String st = "";
		Conecta BD = new Conecta();
        String sql = "SELECT e.Cod_evento,e.Descricao FROM evento e WHERE e.Cod_evento= "
                + "(SELECT a.Cod_evento FROM agenda a WHERE a.Data_age = curdate()) "
                + "UNION SELECT e.Cod_evento,e.Descricao from evento e";
        
                if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
			st += "Cod_evento\tDescricao\n";
           while(resultSet.next()){
				st += "     "+resultSet.getString(1) + "\t " + resultSet.getString(2)+"\n";
           }
        } catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
        return st;
	}
        
        //Select com acesso a três tabelas
        public void session(String id)
	{
		Conecta BD = new Conecta();
                System.out.println("id = "+id);
                        
          char aspa=34;            
                      
        String sql = "SELECT usuário.ID, usuário.Data_entrada, usuário.Horario_entrada, conta.CPF,conta.Senha,conta.Tipo_conta,log.Cod_log,log.Horario_alteracao,log.Data_alteracao,log.Alteracao,log.Tipo FROM usuário, conta, log where usuário.id = "+aspa+id+aspa+" and conta.id = "+aspa+id+aspa+" and log.id = "+aspa+id+aspa;
        
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
			System.out.println("ID\tData_entrada\tHorario_entrada\tCPF\tSenha\tTipo_conta\tCod_log\tHorario_alteracao\tAlteracao\tTipo");
                        
           while(resultSet.next()){
				System.out.println(resultSet.getString(1) + "\t\t" + resultSet.getDate(2)+ "\t" +resultSet.getInt(3)+ "\t" +resultSet.getString(4)+ "\t" +resultSet.getInt(5)+ "\t" +resultSet.getString(6)+ "\t" +resultSet.getString(7)+ "\t" +resultSet.getString(8)+ "\t" +resultSet.getString(9)+"\t"+resultSet.getString(10));
           }
        } catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
	}
	
        public void AgendaEventos(String id, int cod_evento, String horario){
             Conecta BD = new Conecta();
        if (BD.getConnection()) {
            try {
                String sql = "insert into agenda values(?,?,curdate(),?)";
                PreparedStatement statement = BD.connection.prepareStatement(sql);
                
                horario+= ":00";
                java.sql.Time time = java.sql.Time.valueOf(horario);
                
                statement.setString(1, id);
                statement.setInt(2, cod_evento);
                
                statement.setTime(4, time);                
               
                statement.execute();
                BD.close();
                JOptionPane.showMessageDialog(null, "Eventoagendado com sucesso!\n");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Falha na insercao dos dados!\n" + e.toString());
            }
        }

        }
	//Select com operadores de conjunto
	public String eventosUEstabelecimentos()
	{
		Conecta BD = new Conecta();
                String retorno = "";
        String sql = "SELECT e.Descricao,e.Rua,e.Cidade,e.UF from evento e UNION SELECT l.Nome,l.Rua,l.Cidade,l.UF from estabelecimento l GROUP BY UF";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
			retorno += "Descricao\tRua\tCidade\tUF\n";
           while(resultSet.next()){
			retorno += resultSet.getString(1) + "\t " + resultSet.getString(2) + "    \t" + resultSet.getString(3) + "\t" + resultSet.getString(4)+"\n";
           }
        } catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
        return retorno;
	}
	
	//Select com função de grupo 
		//caso faça uma interface grafica substitui o system.out por uma String e devolve a string no metodo.
		//a String deverá ser concatenada com um caracter especial no final pra saber o final da primeira linha, ai é só dar um split ou tokenizer na string passando esse caracter.
	public String quantidadeUsuarios()
	{
		Conecta BD = new Conecta();
                String retorno = "";
                
        String sql = "Select conta.Tipo_conta, count(*) as Total_Users from conta Group by tipo_conta";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
			retorno = "Tipo_conta\t      Total_Usuarios\n";
           while(resultSet.next()){
			retorno += "       "+resultSet.getInt(1) + "\t                   " + resultSet.getInt(2)+"\n";
           }
        } catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
        return retorno;
	}
	
	//Select com função de grupo 
	public String quantidadeEventos()
	{
		Conecta BD = new Conecta();
                String retorno = "";
        String sql = "SELECT evento.UF, count(*) from evento where evento.Horario_inicio >= curdate() AND evento.Horario_termino < curdate() GROUP BY evento.UF";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
			retorno += "UF\t      Total_Eventos\n";
           while(resultSet.next()){
			retorno += "    "+ resultSet.getString(1) + "\t                   " + resultSet.getInt(2)+"\n";
           }
        } catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
        return retorno;
	}
	
	//Select Aninhado e com três tabelas
	public void proprietariosNoSistema()
	{
		Conecta BD = new Conecta();
        String sql = "Select Nome from Pessoa where exists (SELECT CPF FROM conta WHERE EXISTS (Select p.ID FROM proprietario p WHERE p.Data_termino IS NOT NULL))";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
			System.out.println("Nome_Ativos");
           while(resultSet.next()){
				System.out.println(resultSet.getString(1));
           }
        } catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
	}
	
	//Select Aninhado 
	public String[] buscaDadosPessoa(String ID)
	{
		String retorno[] = buscaPessoa(buscaCPF(ID));
		return retorno;
	}
	
	public int buscaCPF(String ID)
	{
		Conecta BD = new Conecta();
		int cpf = -1;
        String sql = "select CPF from conta where ID = ?";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
			statement.setString(1, ID);
            ResultSet resultSet = statement.executeQuery();
           if(resultSet.next()){
				cpf = resultSet.getInt(1);
           }
        } catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
        return cpf;
	}
	
    public String[] buscaPessoa(int cpf) {
         Conecta BD = new Conecta();
		 String retorno[] = new String[11];
         String sql = "select * from pessoa where CPF = ?";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
			statement.setInt(1, cpf);
            ResultSet resultSet = statement.executeQuery();
           if(resultSet.next()){
				retorno[0] = "" + resultSet.getInt(1);
				retorno[1] = resultSet.getString(2);
				retorno[2] = "" + resultSet.getDate(3);
				retorno[3] = "" + resultSet.getInt(4);
				retorno[4] = resultSet.getString(5);
				retorno[5] = resultSet.getString(6);
				retorno[6] = resultSet.getString(7);
				retorno[7] = resultSet.getString(8);
				retorno[8] = resultSet.getString(9);
				retorno[9] = "" + resultSet.getInt(10);
				retorno[10] = resultSet.getString(11);
           }
        } catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
        return retorno;
    }
    
    public int validaSenha(String user, String password){
        Conecta BD = new Conecta();
		int tipo = -1;
        if(BD.getConnection())
        try {
			String sql = "select senha, tipo_conta from conta where ID = ?";
            PreparedStatement statement = BD.connection.prepareStatement(sql);
			statement.setString(1, user);
            ResultSet resultSet = statement.executeQuery();
			if(resultSet.next())
			{
			   if(resultSet.getString("senha").equals(password)){
					tipo = (resultSet.getInt("tipo_conta"));
				 }
			 }
             BD.close();
        } catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
        return tipo;
    }
    
    public void inserirEvento(String rua,String cidade,String UF, String horarioini, String horarioter, String desc){
        Conecta BD = new Conecta();
        if (BD.getConnection()) {
            try {
                String sql = "select max(cod_evento) from evento";
                PreparedStatement statement = BD.connection.prepareStatement(sql);
               
                ResultSet rs = statement.executeQuery();
                rs.next();
                int max = rs.getInt(1);
                max++;
                               
                 horarioini += ":00";
                 horarioter += ":00";
                java.sql.Time time1 = java.sql.Time.valueOf(horarioini);
                java.sql.Time time2 = java.sql.Time.valueOf(horarioter);
              
                sql = "insert into evento values(?,?,?,?,?,?,?)";
                statement = BD.connection.prepareStatement(sql);
                statement.setInt(1, max);
                statement.setString(2, rua);
                statement.setString(3, cidade);
                statement.setString(4, UF);
                statement.setTime(5, time1);
                statement.setTime(6, time2);
                statement.setString(7, desc);
                
               
                statement.execute();
                BD.close();
                JOptionPane.showMessageDialog(null, "Evento inserido com sucesso!\n");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Falha na insercao dos dados!\n" + e.toString());
            }
        }

    }
    
    public void inserirEstabelecimento(String id, int cnpj, String nome, String descricao, String tipo, String rua,
            int numero, String cidade, String estado, String bairro){
        Conecta BD = new Conecta();
        if (BD.getConnection()) {
            try {
                String sql = "insert into Estabelecimento values (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = BD.connection.prepareStatement(sql);
                statement.setString(1, id);
                statement.setInt(2, cnpj);
                statement.setString(3, nome);
                statement.setString(4, descricao);
                statement.setString(5, tipo);
                statement.setString(6, rua);
                statement.setInt(7, numero);
                statement.setString(8, cidade);
                statement.setString(9, estado);
                statement.setString(10, bairro);

                statement.execute();
                BD.close();
                 JOptionPane.showMessageDialog(null, "Inserido o estabelecimento com sucesso!\n");
                 
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Falha na insercao dos dados!\n" + e.toString());
            }
        }

    }
	
	public String[] buscaEstabelecimento(String ID) {
		Conecta BD = new Conecta();
		String retorno[] = new String[9];
		String sql = "select * from Estabelecimento where ID = ?";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
			statement.setString(1, ID);
            ResultSet resultSet = statement.executeQuery();
           if(resultSet.next())
		   {
			retorno[0] = "" + resultSet.getInt(2);
            retorno[1] = resultSet.getString(3);
            retorno[2] = resultSet.getString(4);
            retorno[3] = resultSet.getString(5);
            retorno[4] = resultSet.getString(6);
            retorno[5] = resultSet.getString(7);
            retorno[6] = resultSet.getString(8);
            retorno[7] = resultSet.getString(9);
            retorno[8] = "" + resultSet.getInt(10);
           }
        }catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
        return retorno;
    }
	
	public void atualizaSenha(String ID, String senhaAtual, String novaSenha, String confNovaSenha)
	{
		Conecta BD = new Conecta();
		String sql = "select Senha from conta where ID = ?";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
			statement.setString(1, ID);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next())
		    {
				if(senhaAtual.equals(resultSet.getString(1)))
				{
					if(novaSenha.equals(confNovaSenha))
					{
						sql = "update conta set Senha = ? where ID = ?";
						statement = BD.connection.prepareStatement(sql);
						statement.setString(1, novaSenha);
						statement.setString(2, ID);
						statement.execute();
						JOptionPane.showMessageDialog(null, "Senha atualizada com sucesso!\n");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Senhas não coincidem!\n");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Senha incorreta!\n");
				}
			}
        }catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BD.close();
	}
	
	public void atualizaDados( int CPF, String nome, String date, int RG, String rua,
         String cidade, String UF, String pais, String bairro, int numeroCasa, String inf)
	{
		Conecta BD = new Conecta();
		String sql = "update pessoa set Nome = ?, Data_nasc = ?, RG = ?, Rua = ?, Cidade = ?, UF = ?, Pais = ?, Bairro = ?, Numero_casa = ?, Informacoes_casa = ? where CPF = ?";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setDate(2, formataData(date));
			statement.setInt(3, RG);
			statement.setString(4, rua);
			statement.setString(5, cidade);
			statement.setString(6, UF);
			statement.setString(7, pais);
			statement.setString(8, bairro);
			statement.setInt(9, numeroCasa);
			statement.setString(10, inf);
			statement.setInt(11, CPF);
            statement.execute();
			 JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!\n");
        }catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
		catch (Exception e)
		{
			 JOptionPane.showMessageDialog(null, "Erro na conversão da data!\n");
		}
        BD.close();
	}
	
	public void enviaMensagem(String remetente, String destinatario, String conteudo)
	{
		Conecta BD = new Conecta();
		String sql = "insert into mensagem values (?,?,?,?,?,?)";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
			statement.setString(1, remetente);
			statement.setInt(2, 1);
			
			java.util.Date dataAtual = new java.util.Date();
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			formatador.format(dataAtual);
			
			statement.setDate(3, new java.sql.Date(dataAtual.getTime()));
			
			statement.setTime(4, null);
			statement.setString(5, conteudo);
			statement.setString(6, destinatario);
            statement.execute();
			 JOptionPane.showMessageDialog(null, "Mensagem enviada!\n");
        }catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
		catch (Exception e)
		{
			 JOptionPane.showMessageDialog(null, "Erro na conversão da data!\n");
		}
        BD.close();
	}
	
	public String[] leMensagem(String remetente)
	{
		Conecta BD = new Conecta();
		String[] retorno = new String[2];
		String sql = "select Remetente, Conteudo from mensagem where Destinatario = ?";
        if(BD.getConnection())
        try {
            PreparedStatement statement = BD.connection.prepareStatement(sql);
			statement.setString(1, remetente);
			
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next())
		    {
				retorno[0] = resultSet.getString(1);
				retorno[1] = resultSet.getString(2);
			}
        }catch (SQLException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
		catch (Exception e)
		{
			 JOptionPane.showMessageDialog(null, "Erro na conversão da data!\n");
		}
        BD.close();
		
		return retorno;
	}
}
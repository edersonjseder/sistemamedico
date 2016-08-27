package br.com.sistemamedico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.TratamentosBean;
import br.com.sistemamedico.factory.ConnectionFactory;

public class TratamentosDAO {

	private Connection connection;
	
	public TratamentosDAO () throws SQLException {
		this.connection = ConnectionFactory.openConnection();
	}
	
	public void insert(TratamentosBean tratamento) throws SQLException{
		PreparedStatement stmt = 
			connection.prepareStatement("insert into tratamento (tratamento,descricao) values (?, ?)");
		
		stmt.setString(1, tratamento.getTratamento());
		stmt.setString(2, tratamento.getDescricao());
		
		stmt.execute();
		stmt.close();
		
	}

	public void update(TratamentosBean tratamento) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("update tratamento set tratamento=?, descricao=? where idTratamento=" + tratamento.getIdTratamento() + ";");

		stmt.setString(1, tratamento.getTratamento());
		stmt.setString(2, tratamento.getDescricao());
		
		stmt.execute();
		stmt.close();
		
	}
	
	public void delete(TratamentosBean tratamento) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("delete from tratamento where idTratamento=?");
		
		stmt.setInt(1, tratamento.getIdTratamento());
		stmt.execute();
		stmt.close();
		
	}
	
	public TratamentosBean retrieveById(Integer idTratamento) throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from tratamento where idTratamento='" + idTratamento + "'");
		ResultSet rs = stmt.executeQuery();
		
		
		TratamentosBean tratamento = new TratamentosBean();
		
		while(rs.next()){
			tratamento.setIdTratamento(rs.getInt("idTratamento"));
			tratamento.setTratamento(rs.getString("tratamento"));
			tratamento.setDescricao(rs.getString("descricao"));
		}
		
		rs.close();
		stmt.close();
		
		return tratamento;
		
	}
	
	public TratamentosBean retrieveByName(String nomeTratamento) throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from tratamento where tratamento='" + nomeTratamento + "'");
		ResultSet rs = stmt.executeQuery();
		
		
		TratamentosBean tratamento = new TratamentosBean();
		
		while(rs.next()){
			tratamento.setIdTratamento(rs.getInt("idTratamento"));
			tratamento.setTratamento(rs.getString("tratamento"));
			tratamento.setDescricao(rs.getString("descricao"));
		}
		
		rs.close();
		stmt.close();
		
	    return tratamento;
	    
	}
	
	public List<TratamentosBean> listar() throws SQLException{
		PreparedStatement stmt = connection.prepareStatement("select * from tratamento");
		ResultSet rs = stmt.executeQuery();
		
		
		List<TratamentosBean> lista = new ArrayList<TratamentosBean>();
		
		while(rs.next()){
			TratamentosBean tratamento = new TratamentosBean();
			
			tratamento.setIdTratamento(rs.getInt("idTratamento"));
			tratamento.setTratamento(rs.getString("tratamento"));
			tratamento.setDescricao(rs.getString("descricao"));
			
			lista.add(tratamento);
		}
		
		rs.close();
		stmt.close();
		
	    return lista;
	}
	
/*	public void insereAssociativoDisciplina(int idDisciplina) throws SQLException{
		PreparedStatement stmt = 
			connection.prepareStatement("insert into aluno_has_medicamento (Disciplina_idDisciplina) values (?)");
		
		stmt.setInt(1, idDisciplina);
		
		stmt.execute();
		stmt.close();
	}*/
}

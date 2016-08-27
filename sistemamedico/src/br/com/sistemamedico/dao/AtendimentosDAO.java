package br.com.sistemamedico.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.AtendimentosBean;
import br.com.sistemamedico.factory.ConnectionFactory;

public class AtendimentosDAO {

	private Connection connection;
	
	public AtendimentosDAO () throws SQLException {
		this.connection = ConnectionFactory.openConnection();
	}
	
	public void insert(AtendimentosBean atendimento) throws SQLException{
		PreparedStatement stmt = 
			connection.prepareStatement("insert into atendimento");
		
		stmt.setString(1, atendimento.getMedicos().getCrm());
		stmt.setInt(2, atendimento.getPacientes().getIdPaciente());
		stmt.setInt(3, atendimento.getConvenios().getIdConvenio());
		stmt.setDate(4, (Date) atendimento.getDataAtendimento());
		stmt.setDate(5, (Date) atendimento.getHorarioAtendimento());
		stmt.setString(6, atendimento.getObservacoes());
		
		stmt.execute();
		stmt.close();
		
	}

	public void update(AtendimentosBean atendimento) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("update atendimento set nomePaciente=?");
		
		stmt.setString(1, atendimento.getMedicos().getCrm());
		stmt.setInt(2, atendimento.getPacientes().getIdPaciente());
		stmt.setInt(3, atendimento.getConvenios().getIdConvenio());
		stmt.setDate(4, (Date) atendimento.getDataAtendimento());
		stmt.setDate(5, (Date) atendimento.getHorarioAtendimento());
		stmt.setString(6, atendimento.getObservacoes());
		
		stmt.execute();
		stmt.close();
		
	}
	
	public void delete(AtendimentosBean atendimento) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("delete from atendimento where idAtendimento=?");
		
		stmt.setInt(1, atendimento.getIdAtendimento());
		stmt.execute();
		stmt.close();
		
	}
	
	public AtendimentosBean retrieveById(String idAtendimento) throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from atendimento where idAtendimento='" + idAtendimento + "'");
		ResultSet rs = stmt.executeQuery();
		
		AtendimentosBean atendimento = new AtendimentosBean();
		
		while(rs.next()){
			atendimento.setIdAtendimento(rs.getInt("idAtendimento"));
		}
		
		rs.close();
		stmt.close();
		
		return atendimento;
		
	}
	
	public AtendimentosBean retrieveByName(String nomeAtendimento) throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from atendimento where nomeAtendimento='" + nomeAtendimento + "'");
		ResultSet rs = stmt.executeQuery();
		
		
		AtendimentosBean atendimento = new AtendimentosBean();
		
		while(rs.next()){
			atendimento.setIdAtendimento(rs.getInt("idAtendimento"));
		}
		
		rs.close();
		stmt.close();
		
		return atendimento;
		
	}
	
	public List<AtendimentosBean> listar() throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from atendimento");
		ResultSet rs = stmt.executeQuery();
		
		
		List<AtendimentosBean> lista = new ArrayList<AtendimentosBean>();
		
		while(rs.next()){
			AtendimentosBean atendimento = new AtendimentosBean();
			
			atendimento.setIdAtendimento(rs.getInt("idAtendimento"));
			
			lista.add(atendimento);
		}
		
		rs.close();
		stmt.close();
		
	    return lista;
	    
	}
	
/*	public void insereAssociativoAluno(String cpfAluno) throws SQLException{
		PreparedStatement stmt = 
			connection.prepareStatement("insert into medico_has_disciplina (Aluno_cpfAluno) values (?)");
		
		stmt.setString(1, cpfAluno);
		
		stmt.execute();
		stmt.close();
	} */
}

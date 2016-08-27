package br.com.sistemamedico.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.AgendamentosBean;
import br.com.sistemamedico.factory.ConnectionFactory;

public class AgendamentosDAO {

	private Connection connection;
	
	public AgendamentosDAO () throws SQLException {
		this.connection = ConnectionFactory.openConnection();
	}
	
	public void insert(AgendamentosBean agendamento) throws SQLException{
		PreparedStatement stmt = 
			connection.prepareStatement("insert into agendamento");
		
		stmt.setString(1, agendamento.getMedicos().getCrm());
		stmt.setInt(2, agendamento.getPacientes().getIdPaciente());
		stmt.setInt(3, agendamento.getConvenios().getIdConvenio());
		stmt.setDate(4, (Date) agendamento.getDataAgendamento());
		stmt.setDate(5, (Date) agendamento.getHorarioAgendamento());
		stmt.setInt(6, agendamento.getTratamento().getIdTratamento());
		stmt.setString(7, agendamento.getTratamentoParticular());
		stmt.setString(8, agendamento.getObservacoes());
		
		stmt.execute();
		stmt.close();
		
	}

	public void update(AgendamentosBean agendamento) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("update agendamento set nomePaciente=?");
		
		stmt.setString(1, agendamento.getMedicos().getCrm());
		stmt.setInt(2, agendamento.getPacientes().getIdPaciente());
		stmt.setInt(3, agendamento.getConvenios().getIdConvenio());
		stmt.setDate(4, (Date) agendamento.getDataAgendamento());
		stmt.setDate(5, (Date) agendamento.getHorarioAgendamento());
		stmt.setInt(6, agendamento.getTratamento().getIdTratamento());
		stmt.setString(7, agendamento.getTratamentoParticular());
		stmt.setString(8, agendamento.getObservacoes());
		
		stmt.execute();
		stmt.close();
		
	}
	
	public void delete(AgendamentosBean agendamento) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("delete from agendamento where idAgendamento=?");
		
		stmt.setInt(1, agendamento.getIdAgendamento());
		stmt.execute();
		stmt.close();
		
	}
	
	public AgendamentosBean retrieveById(String idAgendamento) throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from agendamento where idAgendamento='" + idAgendamento + "'");
		ResultSet rs = stmt.executeQuery();
		
		AgendamentosBean agendamento = new AgendamentosBean();
		
		while(rs.next()){
			agendamento.setIdAgendamento(rs.getInt("idAgendamento"));
		}
		
		rs.close();
		stmt.close();
		
		return agendamento;
		
	}
	
	public List<AgendamentosBean> listar() throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from agendamento");
		ResultSet rs = stmt.executeQuery();
		
		
		List<AgendamentosBean> lista = new ArrayList<AgendamentosBean>();
		
		while(rs.next()){
			AgendamentosBean agendamento = new AgendamentosBean();
			
			agendamento.setIdAgendamento(rs.getInt("idAgendamento"));
			
			lista.add(agendamento);
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

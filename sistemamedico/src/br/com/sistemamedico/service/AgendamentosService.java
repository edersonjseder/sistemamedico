package br.com.sistemamedico.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.AgendamentosBean;
import br.com.sistemamedico.dao.AgendamentosDAO;

public class AgendamentosService {

	public AgendamentosBean buscarAgendamentoById(String idAgendamento){
		AgendamentosBean agendamento = new AgendamentosBean();
		
		try{
			AgendamentosDAO dao = new AgendamentosDAO();
			agendamento = dao.retrieveById(idAgendamento);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return agendamento;
	}
	
	public List<AgendamentosBean> listarAgendamentos(){
		List<AgendamentosBean> lista = new ArrayList<AgendamentosBean>();
		
		try{
			AgendamentosDAO dao = new AgendamentosDAO();
			lista = dao.listar();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public boolean icluirAgendamento(AgendamentosBean agendamento){
		try{
			AgendamentosDAO dao = new AgendamentosDAO();
			dao.insert(agendamento);
		
		}catch(SQLException he){
			he.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean alterarAgendamento(AgendamentosBean agendamento){
		
		try {
			AgendamentosDAO dao = new AgendamentosDAO();
			dao.update(agendamento);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void excluirAgendamento(AgendamentosBean agendamento){
		try{
			AgendamentosDAO dao = new AgendamentosDAO();
			dao.delete(agendamento);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
/*	public boolean insereAlunoAssociativo(String cpfAluno){
		try {
			PacienteDAO dao = new PacienteDAO();
			dao.insereAssociativoAluno(cpfAluno);
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/

}

package br.com.sistemamedico.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.PacientesBean;
import br.com.sistemamedico.dao.PacienteDAO;

public class PacienteService {

	public PacientesBean buscarPaciente(String nomePaciente){
		PacientesBean paciente = new PacientesBean();
		
		try{
			PacienteDAO dao = new PacienteDAO();
			paciente = dao.retrieveByName(nomePaciente);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return paciente;
	}
	
	public PacientesBean buscarPacienteById(String idPaciente){
		PacientesBean paciente = new PacientesBean();
		
		try{
			PacienteDAO dao = new PacienteDAO();
			paciente = dao.retrieveById(idPaciente);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return paciente;
	}
	
	public List<PacientesBean> listarPacientes(){
		List<PacientesBean> lista = new ArrayList<PacientesBean>();
		
		try{
			PacienteDAO dao = new PacienteDAO();
			lista = dao.listar();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public boolean icluirPaciente(PacientesBean paciente){
		try{
			PacienteDAO dao = new PacienteDAO();
			dao.insert(paciente);
		
		}catch(SQLException he){
			he.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean alterarPaciente(PacientesBean paciente){
		
		try {
			PacienteDAO dao = new PacienteDAO();
			dao.update(paciente);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void excluirPaciente(PacientesBean paciente){
		try{
			PacienteDAO dao = new PacienteDAO();
			dao.delete(paciente);
			
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

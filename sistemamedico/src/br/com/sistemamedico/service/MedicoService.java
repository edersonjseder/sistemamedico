package br.com.sistemamedico.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.MedicoBean;
import br.com.sistemamedico.dao.MedicoDAO;

public class MedicoService {

	public MedicoBean buscarMedico(String nomeMedico){
		MedicoBean medico = new MedicoBean();
		
		try{
			MedicoDAO dao = new MedicoDAO();
			medico = dao.retrieveByName(nomeMedico);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return medico;
	}
	
	public MedicoBean buscarMedicoById(String crm){
		MedicoBean medico = new MedicoBean();
		
		try{
			MedicoDAO dao = new MedicoDAO();
			medico = dao.retrieveById(crm);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return medico;
	}
	
	public List<MedicoBean> listarMedicos(){
		List<MedicoBean> lista = new ArrayList<MedicoBean>();
		
		try{
			MedicoDAO dao = new MedicoDAO();
			lista = dao.listar();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public boolean icluirMedico(MedicoBean medico){
		try{
			MedicoDAO dao = new MedicoDAO();
			dao.insert(medico);
		
		}catch(SQLException he){
			he.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean alterarMedico(MedicoBean medico){
		
		try {
			MedicoDAO dao = new MedicoDAO();
			dao.update(medico);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void excluirMedico(MedicoBean medico){
		try{
			MedicoDAO dao = new MedicoDAO();
			dao.delete(medico);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
/*	public boolean insereAlunoAssociativo(String cpfAluno){
		try {
			MedicoDAO dao = new MedicoDAO();
			dao.insereAssociativoAluno(cpfAluno);
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/

}

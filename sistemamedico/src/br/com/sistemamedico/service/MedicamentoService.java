package br.com.sistemamedico.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.MedicamentosBean;
import br.com.sistemamedico.dao.MedicamentosDAO;

public class MedicamentoService {

	public MedicamentosBean buscarMedicamento(Integer idMedicamento){
		MedicamentosBean medicamento = new MedicamentosBean();
		
		try{
			MedicamentosDAO dao = new MedicamentosDAO();
			medicamento = dao.retrieveById(idMedicamento);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return medicamento;
	}
	
	public MedicamentosBean buscarMedicamento(String nomeMedicamento){
		MedicamentosBean medicamento = new MedicamentosBean();
		
		try{
			MedicamentosDAO dao = new MedicamentosDAO();
			medicamento = dao.retrieveByName(nomeMedicamento);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return medicamento;
	}
	
	public boolean incluirMedicamento(MedicamentosBean medicamento){
		try{
			MedicamentosDAO dao = new MedicamentosDAO();
			dao.insert(medicamento);
		
		}catch(SQLException he){
			he.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean alterarMedicamento(MedicamentosBean medicamento){
		
		try {
			MedicamentosDAO dao = new MedicamentosDAO();
			dao.update(medicamento);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void excluirMedicamento(MedicamentosBean medicamento){
		try{
			MedicamentosDAO dao = new MedicamentosDAO();
			dao.delete(medicamento);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public List<MedicamentosBean> listarMedicamentos(){
		List<MedicamentosBean> medicamentos = new ArrayList<MedicamentosBean>();
		
		try{
			MedicamentosDAO dao = new MedicamentosDAO();
			medicamentos = dao.listar();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return medicamentos;
	}
	
/*	public boolean insereMedicamentoAssociativo(int idMedicamento){
		try {
			MedicamentosDAO dao = new MedicamentosDAO();
			dao.insereAssociativoMedicamento(idMedicamento);
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/

}

package br.com.sistemamedico.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.TratamentosBean;
import br.com.sistemamedico.dao.TratamentosDAO;

public class TratamentoService {

	public TratamentosBean buscarMedicamento(Integer idTratamento){
		TratamentosBean tratamento = new TratamentosBean();
		
		try{
			TratamentosDAO dao = new TratamentosDAO();
			tratamento = dao.retrieveById(idTratamento);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return tratamento;
	}
	
	public TratamentosBean buscarTratamento(String nomeTratamento){
		TratamentosBean tratamento = new TratamentosBean();
		
		try{
			TratamentosDAO dao = new TratamentosDAO();
			tratamento = dao.retrieveByName(nomeTratamento);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return tratamento;
	}
	
	public boolean incluirTratamento(TratamentosBean tratamento){
		try{
			TratamentosDAO dao = new TratamentosDAO();
			dao.insert(tratamento);
		
		}catch(SQLException he){
			he.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean alterarTratamento(TratamentosBean tratamento){
		
		try {
			TratamentosDAO dao = new TratamentosDAO();
			dao.update(tratamento);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void excluirTratamento(TratamentosBean tratamento){
		try{
			TratamentosDAO dao = new TratamentosDAO();
			dao.delete(tratamento);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public List<TratamentosBean> listarTratamentos(){
		List<TratamentosBean> tratamentos = new ArrayList<TratamentosBean>();
		
		try{
			TratamentosDAO dao = new TratamentosDAO();
			tratamentos = dao.listar();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return tratamentos;
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

package br.com.sistemamedico.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.ConveniosBean;
import br.com.sistemamedico.dao.ConvenioDAO;

public class ConvenioService {

	public ConveniosBean buscarConvenio(String nomeConvenio){
		ConveniosBean convenio = new ConveniosBean();
		
		try{
			ConvenioDAO dao = new ConvenioDAO();
			convenio = dao.retrieveByName(nomeConvenio);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return convenio;
	}
	
	public boolean incluirConvenio(ConveniosBean convenio){
		try{
			ConvenioDAO dao = new ConvenioDAO();
			dao.insert(convenio);
		
		}catch(SQLException he){
			he.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean alterarConvenio(ConveniosBean convenio){
		
		try {
			ConvenioDAO dao = new ConvenioDAO();
			dao.update(convenio);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void excluirConvenio(ConveniosBean convenio){
		try{
			ConvenioDAO dao = new ConvenioDAO();
			dao.delete(convenio);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public List<ConveniosBean> listarConvenios(){
		List<ConveniosBean> convenios = new ArrayList<ConveniosBean>();
		
		try{
			ConvenioDAO dao = new ConvenioDAO();
			convenios = dao.listar();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return convenios;
	}
	
}

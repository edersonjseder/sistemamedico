package br.com.sistemamedico.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.AtendimentosBean;
import br.com.sistemamedico.dao.AtendimentosDAO;

public class AtendimentosService {

	public AtendimentosBean buscarAtendimento(String nomeAtendimento){
		AtendimentosBean atendimento = new AtendimentosBean();
		
		try{
			AtendimentosDAO dao = new AtendimentosDAO();
			atendimento = dao.retrieveByName(nomeAtendimento);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return atendimento;
	}
	
	public AtendimentosBean buscarAtendimentoById(String idAtendimento){
		AtendimentosBean atendimento = new AtendimentosBean();
		
		try{
			AtendimentosDAO dao = new AtendimentosDAO();
			atendimento = dao.retrieveById(idAtendimento);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return atendimento;
	}
	
	public List<AtendimentosBean> listarAtendimentos(){
		List<AtendimentosBean> lista = new ArrayList<AtendimentosBean>();
		
		try{
			AtendimentosDAO dao = new AtendimentosDAO();
			lista = dao.listar();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public boolean icluirAtendimento(AtendimentosBean atendimento){
		try{
			AtendimentosDAO dao = new AtendimentosDAO();
			dao.insert(atendimento);
		
		}catch(SQLException he){
			he.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean alterarAtendimento(AtendimentosBean atendimento){
		
		try {
			AtendimentosDAO dao = new AtendimentosDAO();
			dao.update(atendimento);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void excluirAtendimento(AtendimentosBean atendimento){
		try{
			AtendimentosDAO dao = new AtendimentosDAO();
			dao.delete(atendimento);
			
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

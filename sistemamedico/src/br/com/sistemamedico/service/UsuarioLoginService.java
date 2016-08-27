package br.com.sistemamedico.service;

import java.sql.SQLException;

import br.com.sistemamedico.bean.UsuarioLoginBean;
import br.com.sistemamedico.dao.UsuarioLoginDAO;

public class UsuarioLoginService {

	public UsuarioLoginBean buscarUsuario(String loginUsuario, String senha){
		UsuarioLoginBean login = new UsuarioLoginBean();
		
		try{
			UsuarioLoginDAO dao = new UsuarioLoginDAO();
			login = dao.retrieveByName(loginUsuario, senha);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return login;
	}
	
	public boolean icluirUsuarioLogin(UsuarioLoginBean usuarioLogin){
		try{
			UsuarioLoginDAO dao = new UsuarioLoginDAO();
			dao.insert(usuarioLogin);
		
		}catch(SQLException he){
			he.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	public boolean alterarUsuarioLogin(UsuarioLoginBean usuarioLogin){
		
		try {
			UsuarioLoginDAO dao = new UsuarioLoginDAO();
			dao.update(usuarioLogin);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void excluirUsuarioLogin(UsuarioLoginBean usuarioLogin){
		try{
			UsuarioLoginDAO dao = new UsuarioLoginDAO();
			dao.delete(usuarioLogin);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}

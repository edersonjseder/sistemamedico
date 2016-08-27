package br.com.sistemamedico.controller;

import br.com.sistemamedico.bean.UsuarioLoginBean;
import br.com.sistemamedico.validacao.Validacao;

public class ControllerLogin {
	
	private UsuarioLoginBean usuario;
	
	public ControllerLogin(){
		usuario = new UsuarioLoginBean();
	}
	
	public String validarUsuario(){

		Validacao validacao = new Validacao();
		setUsuario(validacao.validarUsuario(getUsuario()));
		
		if(getUsuario() == null){
			return "error";
		}
		
		return "paginaMenu";
	}

	public UsuarioLoginBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioLoginBean usuario) {
		this.usuario = usuario;
	}

}

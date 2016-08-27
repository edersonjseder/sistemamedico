package br.com.sistemamedico.validacao;


import br.com.sistemamedico.bean.UsuarioLoginBean;
import br.com.sistemamedico.service.UsuarioLoginService;

public class Validacao {

	private UsuarioLoginBean usuarioLogin;
	private UsuarioLoginService usuarioService;
	
	public UsuarioLoginBean validarUsuario(UsuarioLoginBean usuario){
		
		try {
			usuarioService = new UsuarioLoginService();
			setUsuarioLogin(usuarioService.buscarUsuario(usuario.getLogin(), usuario.getSenha()));
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return usuarioLogin;
	}

	public UsuarioLoginBean getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(UsuarioLoginBean usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}
}

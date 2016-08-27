package br.com.sistemamedico.bean;

import java.io.Serializable;

public class UsuarioLoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String senha;
	private PacientesBean paciente;
	private int nivel;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public PacientesBean getPaciente() {
		return paciente;
	}
	public void setPaciente(PacientesBean paciente) {
		this.paciente = paciente;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
}

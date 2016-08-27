package br.com.sistemamedico.controller;

public class Controlador {
	
	public Controlador(){}

	public String entrarAdministrador(){
		return "admin";
	}
	
	public String entrarUsuario(){
		return "user";
	}
	
	public String entrarCadastroDisciplinas(){
		return "cadastroDisciplinas";
	}
	
	public String entrarCadastroNotas(){
		return "cadastroNotas";
	}
	
	public String entrarCadastroAlunoDisciplina(){
		return "alunoDisciplina";
	}
}

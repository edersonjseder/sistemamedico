package br.com.sistemamedico.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicoBean implements Serializable, Comparable<MedicoBean>{
	
	private static final long serialVersionUID = 12L;
	
	private String crm;
	private String nome;
	private String especialidade;
	private List<EspecialidadeMedicaBean> especialidadeMedica;
	private String sexo;
	private Date   dataNascimento;
	private List<AtendimentosBean> atendimentos;
	
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int compareTo(MedicoBean medico) {
		return this.nome.compareTo(medico.getNome());
	}
	public List<AtendimentosBean> getAtendimentos() {
		if(atendimentos == null){
			atendimentos = new ArrayList<AtendimentosBean>();
		}
		return atendimentos;
	}
	public void setAtendimentos(List<AtendimentosBean> atendimentos) {
		this.atendimentos = atendimentos;
	}
	public List<EspecialidadeMedicaBean> getEspecialidadeMedica() {
		if(especialidadeMedica == null){
			especialidadeMedica = new ArrayList<EspecialidadeMedicaBean>();
		}
		return especialidadeMedica;
	}
	public void setEspecialidadeMedica(
			List<EspecialidadeMedicaBean> especialidadeMedica) {
		this.especialidadeMedica = especialidadeMedica;
	}
	
}

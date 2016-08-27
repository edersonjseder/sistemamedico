package br.com.sistemamedico.bean;

import java.util.ArrayList;
import java.util.List;


public class EspecialidadeMedicaBean implements Comparable<EspecialidadeMedicaBean>{
	
	private Integer idEspecialidade;
	private String  nomeEspecialidade;
	private List<MedicoBean> medicos;
	private List<TratamentosBean> tratamentos;
	
	public Integer getIdEspecialidade() {
		return idEspecialidade;
	}
	public void setIdEspecialidade(Integer idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}
	public String getNomeEspecialidade() {
		return nomeEspecialidade;
	}
	public void setNomeEspecialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}
	public List<MedicoBean> getMedicos() {
		if(medicos == null){
			medicos = new ArrayList<MedicoBean>();
		}
		return medicos;
	}
	public void setMedicos(List<MedicoBean> medicos) {
		this.medicos = medicos;
	}
	public List<TratamentosBean> getTratamentos() {
		if(tratamentos == null){
			tratamentos = new ArrayList<TratamentosBean>();
		}
		return tratamentos;
	}
	public void setTratamentos(List<TratamentosBean> tratamentos) {
		this.tratamentos = tratamentos;
	}
	public int compareTo(EspecialidadeMedicaBean especialidade) {
		return this.nomeEspecialidade.compareTo(especialidade.getNomeEspecialidade());
	}
}

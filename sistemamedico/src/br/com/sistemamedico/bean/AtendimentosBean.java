package br.com.sistemamedico.bean;

import java.util.Date;

public class AtendimentosBean {
	private Integer 		idAtendimento;
	private MedicoBean    	medicos;
	private PacientesBean 	pacientes;
	private ConveniosBean 	convenios;
	private Date 			dataAtendimento;
	private Date 			horarioAtendimento;
	private TratamentosBean tratamento;
	private String 			tratamentoParticular;
	private String 			observacoes;
	
	public Integer getIdAtendimento() {
		return idAtendimento;
	}
	public void setIdAtendimento(Integer idAtendimento) {
		this.idAtendimento = idAtendimento;
	}
	public Date getDataAtendimento() {
		return dataAtendimento;
	}
	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Date getHorarioAtendimento() {
		return horarioAtendimento;
	}
	public void setHorarioAtendimento(Date horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}
	public MedicoBean getMedicos() {
		if(medicos == null){
			medicos = new MedicoBean();
		}
		return medicos;
	}
	public void setMedicos(MedicoBean medicos) {
		this.medicos = medicos;
	}
	public PacientesBean getPacientes() {
		if(pacientes == null){
			pacientes = new PacientesBean();
		}		
		return pacientes;
	}
	public void setPacientes(PacientesBean pacientes) {
		this.pacientes = pacientes;
	}
	public ConveniosBean getConvenios() {
		if(convenios == null){
			convenios = new ConveniosBean();
		}		
		return convenios;
	}
	public void setConvenios(ConveniosBean convenios) {
		this.convenios = convenios;
	}
	public TratamentosBean getTratamento() {
		return tratamento;
	}
	public void setTratamento(TratamentosBean tratamento) {
		this.tratamento = tratamento;
	}
	public String getTratamentoParticular() {
		return tratamentoParticular;
	}
	public void setTratamentoParticular(String tratamentoParticular) {
		this.tratamentoParticular = tratamentoParticular;
	}
}

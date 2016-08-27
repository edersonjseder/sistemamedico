package br.com.sistemamedico.bean;

import java.util.Date;

public class AgendamentosBean {
	private Integer 	    idAgendamento;
	private MedicoBean      medicos;
	private PacientesBean   pacientes;
	private ConveniosBean   convenios;
	private Date 		    dataAgendamento;
	private Date 		    horarioAgendamento;
	private TratamentosBean tratamento;
	private String          tratamentoParticular;
	private String 		    observacoes;
	
	
	public Integer getIdAgendamento() {
		return idAgendamento;
	}
	public void setIdAgendamento(Integer idAgendamento) {
		this.idAgendamento = idAgendamento;
	}
	public MedicoBean getMedicos() {
		return medicos;
	}
	public void setMedicos(MedicoBean medicos) {
		this.medicos = medicos;
	}
	public PacientesBean getPacientes() {
		return pacientes;
	}
	public void setPacientes(PacientesBean pacientes) {
		this.pacientes = pacientes;
	}
	public ConveniosBean getConvenios() {
		return convenios;
	}
	public void setConvenios(ConveniosBean convenios) {
		this.convenios = convenios;
	}
	public Date getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Date getHorarioAgendamento() {
		return horarioAgendamento;
	}
	public void setHorarioAgendamento(Date horarioAgendamento) {
		this.horarioAgendamento = horarioAgendamento;
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
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
}

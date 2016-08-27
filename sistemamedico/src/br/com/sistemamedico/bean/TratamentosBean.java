package br.com.sistemamedico.bean;

import java.util.ArrayList;
import java.util.List;

public class TratamentosBean {
	private int idTratamento;
	private String tratamento;
	private String descricao;
	private List<EspecialidadeMedicaBean> especialidadeMedica;
	
	
	public int getIdTratamento() {
		return idTratamento;
	}
	public void setIdTratamento(int idTratamento) {
		this.idTratamento = idTratamento;
	}
	public String getTratamento() {
		return tratamento;
	}
	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

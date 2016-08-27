package br.com.sistemamedico.bean;

import java.io.Serializable;

public class ConveniosBean implements Serializable, Comparable<ConveniosBean>{
	
	private static final long serialVersionUID = 111L;
	private int idConvenio;
	private String nomeConvenio;
	private String siteConvenio;
	private String descricaoConvenio;
	
	public int getIdConvenio() {
		return idConvenio;
	}
	public void setIdConvenio(int idConvenio) {
		this.idConvenio = idConvenio;
	}
	public String getNomeConvenio() {
		return nomeConvenio;
	}
	public void setNomeConvenio(String nomeConvenio) {
		this.nomeConvenio = nomeConvenio;
	}
	public String getSiteConvenio() {
		return siteConvenio;
	}
	public void setSiteConvenio(String siteConvenio) {
		this.siteConvenio = siteConvenio;
	}
	public String getDescricaoConvenio() {
		return descricaoConvenio;
	}
	public void setDescricaoConvenio(String descricaoConvenio) {
		this.descricaoConvenio = descricaoConvenio;
	}
	public int compareTo(ConveniosBean convenio) {
		return this.nomeConvenio.compareTo(convenio.getNomeConvenio());
	}
	
}

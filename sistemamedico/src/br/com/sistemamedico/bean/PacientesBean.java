package br.com.sistemamedico.bean;

import java.io.Serializable;
import java.util.Date;

public class PacientesBean implements Serializable, Comparable<PacientesBean>{

	private static final long serialVersionUID = 118L;
	private int    idPaciente;
	private String nomePaciente;
	private String rgPaciente;
	private String cpfPaciente;
	private String enderecoPaciente;
	private String cepPaciente;
	private String bairroPaciente;
	private String cidadePaciente;
	private String estadoPaciente;
	private String ufPaciente;
	private Date   dataNascimento;
	private String telefoneResidencial;
	private String telefoneCelular;
	private String sexoPaciente;
	private String nomeMae;
	private String nomePai;
	
	
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public String getRgPaciente() {
		return rgPaciente;
	}
	public void setRgPaciente(String rgPaciente) {
		this.rgPaciente = rgPaciente;
	}
	public String getCpfPaciente() {
		return cpfPaciente;
	}
	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}
	public String getEnderecoPaciente() {
		return enderecoPaciente;
	}
	public void setEnderecoPaciente(String enderecoPaciente) {
		this.enderecoPaciente = enderecoPaciente;
	}
	public String getCepPaciente() {
		return cepPaciente;
	}
	public void setCepPaciente(String cepPaciente) {
		this.cepPaciente = cepPaciente;
	}
	public String getBairroPaciente() {
		return bairroPaciente;
	}
	public void setBairroPaciente(String bairroPaciente) {
		this.bairroPaciente = bairroPaciente;
	}
	public String getCidadePaciente() {
		return cidadePaciente;
	}
	public void setCidadePaciente(String cidadePaciente) {
		this.cidadePaciente = cidadePaciente;
	}
	public String getEstadoPaciente() {
		return estadoPaciente;
	}
	public void setEstadoPaciente(String estadoPaciente) {
		this.estadoPaciente = estadoPaciente;
	}
	public String getUfPaciente() {
		return ufPaciente;
	}
	public void setUfPaciente(String ufPaciente) {
		this.ufPaciente = ufPaciente;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public String getSexoPaciente() {
		return sexoPaciente;
	}
	public void setSexoPaciente(String sexoPaciente) {
		this.sexoPaciente = sexoPaciente;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public int compareTo(PacientesBean paciente) {
		return this.nomePaciente.compareTo(paciente.getNomePaciente());
	}
}

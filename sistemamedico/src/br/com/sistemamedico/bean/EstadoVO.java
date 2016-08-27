package br.com.sistemamedico.bean;


public class EstadoVO implements Comparable<EstadoVO>{

	private String nomeEstado;
	private UfVO uf;
	
	public String getNomeEstado() {
		return nomeEstado;
	}
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	public UfVO getUf() {
		if(uf == null){
			uf = new UfVO();
		}
		return uf;
	}
	public void setUf(UfVO uf) {
		this.uf = uf;
	}
	public int compareTo(EstadoVO estado) {
		return this.nomeEstado.compareTo(estado.getNomeEstado());
	}
}

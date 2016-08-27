package br.com.sistemamedico.controller;

import br.com.sistemamedico.bean.ConveniosBean;
import br.com.sistemamedico.service.ConvenioService;


public class ControllerConvenios {
	
	private ConveniosBean convenio;
    
	public ControllerConvenios(){
		convenio = new ConveniosBean();
	}
	
	public String inserirConvenio(){
		
		ConvenioService convenioService = new ConvenioService();
		
		if(!convenioService.incluirConvenio(getConvenio())){
			return "error";
		}
		
		return "Sucesso";
	}
	
	public String alterarConvenio(){
		
		ConvenioService convenioService = new ConvenioService();
		
		if(!convenioService.alterarConvenio(getConvenio())){
			return "error";
		}
		
		return "Sucesso";
	}

	public ConveniosBean getConvenio() {
		return convenio;
	}

	public void setConvenio(ConveniosBean convenio) {
		this.convenio = convenio;
	}
	
}

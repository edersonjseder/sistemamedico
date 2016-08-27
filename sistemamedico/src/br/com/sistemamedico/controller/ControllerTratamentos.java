package br.com.sistemamedico.controller;

import br.com.sistemamedico.bean.TratamentosBean;
import br.com.sistemamedico.service.TratamentoService;

public class ControllerTratamentos {
    private TratamentosBean tratamentos;
    
	public ControllerTratamentos(){
		tratamentos = new TratamentosBean();
	}
	
	public String inserirTratamento(){
		
		TratamentoService tratamentoService = new TratamentoService();
		
		if(!tratamentoService.incluirTratamento(getTratamentos())){
			return "error";
		}
		
		return "Sucesso";
	}
	
	public String alterarTratamento(){
		
		TratamentoService tratamentoService = new TratamentoService();
		
		if(!tratamentoService.alterarTratamento(getTratamentos())){
			return "error";
		}
		
		return "Sucesso";
	}

	public TratamentosBean getTratamentos() {
		return tratamentos;
	}

	public void setTratamentos(TratamentosBean tratamentos) {
		this.tratamentos = tratamentos;
	}

}

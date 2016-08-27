package br.com.sistemamedico.controller;

import br.com.sistemamedico.bean.MedicamentosBean;
import br.com.sistemamedico.service.MedicamentoService;

public class ControllerMedicamentos {
    private MedicamentosBean medicamentos;
    
	public ControllerMedicamentos(){
		medicamentos = new MedicamentosBean();
	}
	
	public String inserirMedicamento(){
		
		MedicamentoService medicamentoService = new MedicamentoService();
		
		if(!medicamentoService.incluirMedicamento(getMedicamentos())){
			return "error";
		}
		
		return "Sucesso";
	}
	
	public String alterarMedicamento(){
		
		MedicamentoService medicamentoService = new MedicamentoService();
		
		if(!medicamentoService.alterarMedicamento(getMedicamentos())){
			return "error";
		}
		
		return "Sucesso";
	}

	public MedicamentosBean getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(MedicamentosBean medicamentos) {
		this.medicamentos = medicamentos;
	}
}

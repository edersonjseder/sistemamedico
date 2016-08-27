package br.com.sistemamedico.controller;

import br.com.sistemamedico.bean.MedicoBean;
import br.com.sistemamedico.service.MedicoService;

public class ControllerMedicos {
       
    private MedicoBean    medico;
    private String		  showModalPanel;
    
    public ControllerMedicos() {
        medico = new MedicoBean();
        showModalPanel = "Richfaces.showModalPanel('panel')";
    }
    
    public String inserirMedico() {
    	
    	MedicoService medicoService = new MedicoService();
    	
    	if(!medicoService.icluirMedico(getMedico())){
    		return getShowModalPanel();
    	}
    	
    	return getShowModalPanel();
    }
    
	public String alterarMedico() {
		
		MedicoService medicoService = new MedicoService();

		if(!medicoService.alterarMedico(getMedico())){
			return getShowModalPanel();
		}
		
		return getShowModalPanel();
	}

	public MedicoBean getMedico() {
		return medico;
	}

	public void setMedico(MedicoBean medico) {
		this.medico = medico;
	}

	public String getShowModalPanel() {
		return showModalPanel;
	}

	public void setShowModalPanel(String showModalPanel) {
		this.showModalPanel = showModalPanel;
	}

}

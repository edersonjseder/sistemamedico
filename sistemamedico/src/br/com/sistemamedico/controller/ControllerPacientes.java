package br.com.sistemamedico.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.component.html.HtmlInputText;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import br.com.sistemamedico.bean.EstadoVO;
import br.com.sistemamedico.bean.PacientesBean;
import br.com.sistemamedico.carga.Carga;
import br.com.sistemamedico.service.PacienteService;

public class ControllerPacientes {
       
    private PacientesBean     paciente;
    private Set<EstadoVO>     listaEstados;
	private List<SelectItem>  comboEstados;
	private HtmlInputText     textUf;
    
    public ControllerPacientes() {
        paciente = new PacientesBean();
        listaEstados = new TreeSet<EstadoVO>();
        comboEstados = new ArrayList<SelectItem>();
        textUf = new HtmlInputText();
        
        carregarEstados();
        carregarComboEstados();
    }
    
    //Método que carrega a lista de estados
    //Provisóriamente de uma classe onde contém informações estáticas
    public void carregarEstados(){
    	Carga carga = new Carga();
    	setListaEstados(carga.carregar());
    }
    
    //Método que popula a combo de estados na tela com as informações da lista
	public void carregarComboEstados(){
		for (EstadoVO estado : getListaEstados()) {
			SelectItem itens = new SelectItem(estado.getUf().getNomeUf(), estado.getNomeEstado());
			getComboEstados().add(itens);
		}
		
	}
	
	public void preencheCampoTextoUf(ValueChangeEvent event){
		try {
			if(event.getNewValue() != null){
				getTextUf().setValue(event.getNewValue().toString());
				getPaciente().setUfPaciente(getTextUf().getValue().toString());
				
				Iterator<EstadoVO> state = getListaEstados().iterator();
				
				while(state.hasNext()){
					EstadoVO estado = state.next();
					if(estado.getUf().getNomeUf().equals(event.getNewValue().toString())){
						getPaciente().setEstadoPaciente(estado.getNomeEstado());
						break;
					}
				}
			}
		}catch(Exception e){
			
		}
	}
    
    public String inserirPaciente() {
    	
    	PacienteService pacienteService = new PacienteService();
    	
    	if(!pacienteService.icluirPaciente(getPaciente())){
    		return "";
    	}
    	
    	return "";
    }
    
	public String alterarPaciente() {
		
		PacienteService pacienteService = new PacienteService();

		if(!pacienteService.alterarPaciente(getPaciente())){
			return "";
		}
		
		return "";
	}

	public PacientesBean getPaciente() {
		return paciente;
	}

	public void setPaciente(PacientesBean paciente) {
		this.paciente = paciente;
	}

	public Set<EstadoVO> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(Set<EstadoVO> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public HtmlInputText getTextUf() {
		return textUf;
	}

	public void setTextUf(HtmlInputText textUf) {
		this.textUf = textUf;
	}

	public List<SelectItem> getComboEstados() {
		return comboEstados;
	}

	public void setComboEstados(List<SelectItem> comboEstados) {
		this.comboEstados = comboEstados;
	}
}

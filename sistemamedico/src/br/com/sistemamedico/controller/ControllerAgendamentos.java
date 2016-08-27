package br.com.sistemamedico.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlCalendar;

import br.com.sistemamedico.bean.AgendamentosBean;
import br.com.sistemamedico.bean.ConveniosBean;
import br.com.sistemamedico.bean.EspecialidadeMedicaBean;
import br.com.sistemamedico.bean.MedicoBean;
import br.com.sistemamedico.bean.PacientesBean;
import br.com.sistemamedico.carga.Carga;
import br.com.sistemamedico.service.AgendamentosService;

public class ControllerAgendamentos {
    
	private String             			  horarioAgendamento;
    private PacientesBean      			  paciente;
    private AgendamentosBean   			  atendimentos;
    private Set<MedicoBean>    			  listaMedicos;
    private Set<ConveniosBean>    		  listaConvenios;
    private List<SelectItem>   			  comboConvenios;
    private List<SelectItem>   			  comboMedicos;
    private Set<PacientesBean> 			  listaPacientes;
    private List<SelectItem>   			  comboPacientes;
	private List<EspecialidadeMedicaBean> listaEspecialidades;
	private List<SelectItem>   			  comboEspecialidades;
	private HtmlSelectOneMenu 			  selectMedicos;
	private HtmlInputText      			  textEspecialidade;
	private HtmlInputText      			  textCrm;
	private HtmlCalendar       			  textDataNascimento;
	private HtmlCalendar       			  textDataAgendamento;
	private HtmlInputText      			  textCpf;
	private Date			   			  currentDate;
    
    public ControllerAgendamentos() {
        criarObjetos();
        carregarMedicos();
        carregarConvenios();
        carregarPacientes();
        carregarEspecialidades();
        carregarComboEspecialidades();
        carregarComboConvenios();
        carregarComboPacientes();
    }
    
    private void criarObjetos(){
        paciente = new PacientesBean();
        atendimentos = new AgendamentosBean();
        listaMedicos = new TreeSet<MedicoBean>();
        listaConvenios = new TreeSet<ConveniosBean>();
        comboConvenios = new ArrayList<SelectItem>();
        comboMedicos = new ArrayList<SelectItem>();
        listaPacientes = new TreeSet<PacientesBean>();
        comboPacientes = new ArrayList<SelectItem>();
        listaEspecialidades = new ArrayList<EspecialidadeMedicaBean>();
        comboEspecialidades = new ArrayList<SelectItem>();
        selectMedicos = new HtmlSelectOneMenu();
        textEspecialidade = new HtmlInputText();
        textCrm = new HtmlInputText();
        textDataNascimento = new HtmlCalendar();
        textDataAgendamento = new HtmlCalendar();
        textCpf = new HtmlInputText();
        currentDate = new Date();
        
        getTextDataAgendamento().setValue(getCurrentDate());
        
    }
    
    //Método que carrega a lista de medicos
    //Provisóriamente de uma classe onde contém informações estáticas
    public void carregarMedicos(){
    	Carga carga = new Carga();
    	setListaMedicos(carga.carregarMedicos());
    }
    
    //Método que carrega a lista de Especialidades
    //Provisóriamente de uma classe onde contém informações estáticas
    public void carregarEspecialidades(){
    	Carga carga = new Carga();
    	setListaEspecialidades(carga.carregarEspecialidades());
    }
    
    //Método que carrega a lista de pacientes
    //Provisóriamente de uma classe onde contém informações estáticas
    public void carregarPacientes(){
    	Carga carga = new Carga();
    	setListaPacientes(carga.carregarPacientes());
    }
    
    //Método que carrega a lista de convênios
    //Provisóriamente de uma classe onde contém informações estáticas
    public void carregarConvenios(){
    	Carga carga = new Carga();
    	setListaConvenios(carga.carregarConvenios());
    }
    
    //Método que popula a combo de convênios na tela com as informações da lista
	public void carregarComboConvenios(){
		for (ConveniosBean convenio : getListaConvenios()) {
			SelectItem itens = new SelectItem(convenio.getNomeConvenio(), convenio.getNomeConvenio());
			getComboConvenios().add(itens);
		}
		
	}
    
    //Método que popula a combo de medicos na tela com as informações da lista
    public void carregarComboEspecialidades(){
    	for (EspecialidadeMedicaBean especialidade : getListaEspecialidades()) {
    		SelectItem itens = new SelectItem(especialidade.getNomeEspecialidade(), especialidade.getNomeEspecialidade());
    		getComboEspecialidades().add(itens);
    	}
    	
    }
    
    //Método que popula a combo de medicos na tela com as informações da lista
    public void carregarComboMedicos(ValueChangeEvent event){
    	try {
    		getComboMedicos().clear();
			if(event.getNewValue() != null){
				Iterator<EspecialidadeMedicaBean> especialidades = getListaEspecialidades().iterator();
				while(especialidades.hasNext()){
					EspecialidadeMedicaBean especialidade = especialidades.next();
					
					if(especialidade.getNomeEspecialidade().equals(event.getNewValue().toString())){
						for (int i = 0; i < especialidade.getMedicos().size(); i++) {
							SelectItem itens = new SelectItem(especialidade.getMedicos().get(i).getNome(), especialidade.getMedicos().get(i).getNome());
							getComboMedicos().add(itens);
						}
						break;
					}
				}
				getSelectMedicos().setDisabled(false);
			}
		}catch(Exception e){}
    	
    }
    
    //Método que popula a combo de pacientes na tela com as informações da lista
	public void carregarComboPacientes(){
		for (PacientesBean paciente : getListaPacientes()) {
			SelectItem itens = new SelectItem(paciente.getNomePaciente(), paciente.getNomePaciente());
			getComboPacientes().add(itens);
		}
		
	}
	
	public void preencheCampoTextoCrm(ValueChangeEvent event){
		try {
			if(event.getNewValue() != null){
				
				Iterator<MedicoBean> medicos = getListaMedicos().iterator();
				
				while(medicos.hasNext()){
					MedicoBean medico = medicos.next();
					if(medico.getNome().equals(event.getNewValue().toString())){
						getTextCrm().setValue(medico.getCrm());
						break;
					}
				}
			}else{
				getTextCrm().setValue("");
			}
		}catch(Exception e){
			
		}
	}
	
	public void preencheCampoTextoInformacoesPaciente(ValueChangeEvent event){
		try {
			if(event.getNewValue() != null){
				
				Iterator<PacientesBean> pacientes = getListaPacientes().iterator();
				
				while(pacientes.hasNext()){
					PacientesBean paciente = pacientes.next();
					if(paciente.getNomePaciente().equals(event.getNewValue().toString())){
						getTextDataNascimento().setValue(paciente.getDataNascimento());
						getTextCpf().setValue(paciente.getCpfPaciente());
						break;
					}
				}
			}else{
				getTextDataNascimento().setValue("");
				getTextCpf().setValue("");
			}
		}catch(Exception e){
			
		}
	}
    
    public String inserirAgendamento() {
    	try {
    		
    		AgendamentosService atendimentosService = new AgendamentosService();
    		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
			Date horaAgendamento = format.parse(horarioAgendamento);
			
			getAgendamentos().setHorarioAgendamento(horaAgendamento);
			
			if(!atendimentosService.icluirAgendamento(getAgendamentos())){
				return "";
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	
    	return "";
    }
    
	public String alterarAgendamento() {
		
		AgendamentosService agendamentosService = new AgendamentosService();

		if(!agendamentosService.alterarAgendamento(getAgendamentos())){
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

	public Set<MedicoBean> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(Set<MedicoBean> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}

	public List<SelectItem> getComboMedicos() {
		return comboMedicos;
	}

	public void setComboMedicos(List<SelectItem> comboMedicos) {
		this.comboMedicos = comboMedicos;
	}

	public HtmlInputText getTextEspecialidade() {
		return textEspecialidade;
	}

	public void setTextEspecialidade(HtmlInputText textEspecialidade) {
		this.textEspecialidade = textEspecialidade;
	}

	public HtmlInputText getTextCrm() {
		return textCrm;
	}

	public void setTextCrm(HtmlInputText textCrm) {
		this.textCrm = textCrm;
	}

	public Set<PacientesBean> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(Set<PacientesBean> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public List<SelectItem> getComboPacientes() {
		return comboPacientes;
	}

	public void setComboPacientes(List<SelectItem> comboPacientes) {
		this.comboPacientes = comboPacientes;
	}

	public HtmlInputText getTextCpf() {
		return textCpf;
	}

	public void setTextCpf(HtmlInputText textCpf) {
		this.textCpf = textCpf;
	}

	public HtmlCalendar getTextDataNascimento() {
		return textDataNascimento;
	}

	public void setTextDataNascimento(HtmlCalendar textDataNascimento) {
		this.textDataNascimento = textDataNascimento;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public HtmlCalendar getTextDataAgendamento() {
		return textDataAgendamento;
	}

	public void setTextDataAgendamento(HtmlCalendar textDataAgendamento) {
		this.textDataAgendamento = textDataAgendamento;
	}

	public AgendamentosBean getAgendamentos() {
		return atendimentos;
	}

	public void setAgendamentos(AgendamentosBean atendimentos) {
		this.atendimentos = atendimentos;
	}

	public String getHorarioAgendamento() {
		return horarioAgendamento;
	}

	public void setHorarioAgendamento(String horarioAgendamento) {
		this.horarioAgendamento = horarioAgendamento;
	}

	public List<EspecialidadeMedicaBean> getListaEspecialidades() {
		return listaEspecialidades;
	}

	public void setListaEspecialidades(
			List<EspecialidadeMedicaBean> listaEspecialidades) {
		this.listaEspecialidades = listaEspecialidades;
	}

	public List<SelectItem> getComboEspecialidades() {
		return comboEspecialidades;
	}

	public void setComboEspecialidades(List<SelectItem> comboEspecialidades) {
		this.comboEspecialidades = comboEspecialidades;
	}

	public HtmlSelectOneMenu getSelectMedicos() {
		return selectMedicos;
	}

	public void setSelectMedicos(HtmlSelectOneMenu selectMedicos) {
		this.selectMedicos = selectMedicos;
	}

	public Set<ConveniosBean> getListaConvenios() {
		return listaConvenios;
	}

	public void setListaConvenios(Set<ConveniosBean> listaConvenios) {
		this.listaConvenios = listaConvenios;
	}

	public List<SelectItem> getComboConvenios() {
		return comboConvenios;
	}

	public void setComboConvenios(List<SelectItem> comboConvenios) {
		this.comboConvenios = comboConvenios;
	}
}

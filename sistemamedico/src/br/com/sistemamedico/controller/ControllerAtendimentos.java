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
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlCalendar;

import br.com.sistemamedico.bean.AtendimentosBean;
import br.com.sistemamedico.bean.MedicoBean;
import br.com.sistemamedico.bean.PacientesBean;
import br.com.sistemamedico.carga.Carga;
import br.com.sistemamedico.service.AtendimentosService;

public class ControllerAtendimentos {
    
	private String             horarioAtendimento;
    private PacientesBean      paciente;
    private AtendimentosBean   atendimentos;
    private Set<MedicoBean>    listaMedicos;
    private List<SelectItem>   comboMedicos;
    private Set<PacientesBean> listaPacientes;
	private List<SelectItem>   comboPacientes;
	private HtmlInputText      textEspecialidade;
	private HtmlInputText      textCrm;
	private HtmlCalendar       textDataNascimento;
	private HtmlCalendar       textDataAtendimento;
	private HtmlInputText      textCpf;
	private Date			   currentDate;
    
    public ControllerAtendimentos() {
        criarObjetos();
        carregarMedicos();
        carregarPacientes();
        carregarComboMedicos();
        carregarComboPacientes();
    }
    
    private void criarObjetos(){
        paciente = new PacientesBean();
        atendimentos = new AtendimentosBean();
        listaMedicos = new TreeSet<MedicoBean>();
        comboMedicos = new ArrayList<SelectItem>();
        listaPacientes = new TreeSet<PacientesBean>();
        comboPacientes = new ArrayList<SelectItem>();
        textEspecialidade = new HtmlInputText();
        textCrm = new HtmlInputText();
        textDataNascimento = new HtmlCalendar();
        textDataAtendimento = new HtmlCalendar();
        textCpf = new HtmlInputText();
        currentDate = new Date();
        
        getTextDataAtendimento().setValue(getCurrentDate());
        
    }
    
    //Método que carrega a lista de medicos
    //Provisóriamente de uma classe onde contém informações estáticas
    public void carregarMedicos(){
    	Carga carga = new Carga();
    	setListaMedicos(carga.carregarMedicos());
    }
    
    //Método que carrega a lista de pacientes
    //Provisóriamente de uma classe onde contém informações estáticas
    public void carregarPacientes(){
    	Carga carga = new Carga();
    	setListaPacientes(carga.carregarPacientes());
    }
    
    //Método que popula a combo de medicos na tela com as informações da lista
    public void carregarComboMedicos(){
    	for (MedicoBean medico : getListaMedicos()) {
    		SelectItem itens = new SelectItem(medico.getNome(), medico.getNome());
    		getComboMedicos().add(itens);
    	}
    	
    }
    
    //Método que popula a combo de pacientes na tela com as informações da lista
	public void carregarComboPacientes(){
		for (PacientesBean paciente : getListaPacientes()) {
			SelectItem itens = new SelectItem(paciente.getNomePaciente(), paciente.getNomePaciente());
			getComboPacientes().add(itens);
		}
		
	}
	
	public void preencheCampoTextoEspecialidade(ValueChangeEvent event){
		try {
			if(event.getNewValue() != null){
				
				Iterator<MedicoBean> medicos = getListaMedicos().iterator();
				
				while(medicos.hasNext()){
					MedicoBean medico = medicos.next();
					if(medico.getNome().equals(event.getNewValue().toString())){
						getTextEspecialidade().setValue(medico.getEspecialidade());
						getTextCrm().setValue(medico.getCrm());
						break;
					}
				}
			}else{
				getTextEspecialidade().setValue("");
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
    
    public String inserirAtendimento() {
    	try {
    		
    		AtendimentosService atendimentosService = new AtendimentosService();
    		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
			Date horaAtendimento = format.parse(horarioAtendimento);
			
			getAtendimentos().setHorarioAtendimento(horaAtendimento);
			
			if(!atendimentosService.icluirAtendimento(getAtendimentos())){
				return "";
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	
    	return "";
    }
    
	public String alterarAtendimento() {
		
		AtendimentosService atendimentosService = new AtendimentosService();

		if(!atendimentosService.alterarAtendimento(getAtendimentos())){
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

	public HtmlCalendar getTextDataAtendimento() {
		return textDataAtendimento;
	}

	public void setTextDataAtendimento(HtmlCalendar textDataAtendimento) {
		this.textDataAtendimento = textDataAtendimento;
	}

	public AtendimentosBean getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(AtendimentosBean atendimentos) {
		this.atendimentos = atendimentos;
	}

	public String getHorarioAtendimento() {
		return horarioAtendimento;
	}

	public void setHorarioAtendimento(String horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}
}

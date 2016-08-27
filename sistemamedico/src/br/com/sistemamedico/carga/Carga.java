package br.com.sistemamedico.carga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import br.com.sistemamedico.bean.ConveniosBean;
import br.com.sistemamedico.bean.EspecialidadeMedicaBean;
import br.com.sistemamedico.bean.EstadoVO;
import br.com.sistemamedico.bean.MedicoBean;
import br.com.sistemamedico.bean.PacientesBean;

public class Carga {
	
	private String estados[] = {"Acre", "Amazonas", "Roraima", "Rondônia", "Pará", "Amapá", "Mato Grosso", "Maranhão",
								"Tocantins", "Mato Grosso do Sul", "Goiás", "Ceará", "Rio Grande do Norte", "Paraíba",
								"Piauí", "Bahia", "Pernambuco", "Alagoas", "Sergipe", "Minas Gerais", "Espírito Santo",
								"Rio de Janeiro", "São Paulo", "Paraná", "Santa Catarina", "Rio Grande do Sul"};
	
	private String uf[] = {"AC", "AM", "RR", "RO", "PA", "AP", "MT", "MA", "TO", "MS", "GO", "CE", "RN",
			               "PB", "PI", "BA", "PE", "AL", "SE", "MG", "ES", "RJ", "SP", "PR", "SC", "RS"};
	
	private String crm[] = {"00785", "11458", "01478", "02358", "78511", "20036", "01258", "12399", "99874", "01277", "44552", "65489", "14423", "32001", "32278"};
	
	private String medicos[] = {"José Roberto", "Márcia Vasconcelos", "Alberto Vieira", "Márcio Figueiredo", "Carlos Nagashima",
								"Angela Martins", "Marcela Sampaio", "Verônica Fernandes", "Richard Vianna", "Ana Paula Schmith",
								"Fernando Pusktievski", "Mariana Gonçalves", "Carolina Kornikovski", "Marina paiva", "Marcelo Nogueira"};
	
	private String especialidades[] = {"Acupuntura", "Cancerologia", "Cardiologia", "Cirurgia Pediátrica", "Dermatologia", "Endoscopia",
								       "Gastroenterologia", "Neurocirurgia", "Oftalmologia", "Pneumologia", "Radioterapia", "Urologia",
								       "Otorrinolaringologia", "Anestesiologia", "Cirurgia Geral"};
	
	private String pacientes[] = {"Juliana Miranda", "Geraldo Mariano", "Tereza Firmino", "Karen de Souza", "João da Silva",
								  "Paulo Santos", "Daiane Silvano", "Érica de Oliveira", "Rafael Marcondes", "Caio Augusto",
								  "Sandra Ribeiro", "Natalie Roberta", "Vinicius Fernando", "Cláudio Santos", "Francisco Nunes"};
	
	private String celular[] = {"1182852301", "1198123011", "1280185028", "1678963211", "1496310262",
								"1372778521", "1980644863", "1662698946", "1681366300", "1172788527",
								"1984120785", "1297452368", "1186127740", "1696170108", "1678841230"};
	
	private String telefone[] = {"1132108520", "1138852021", "1632781030", "1632658741", "1126371022",
								 "1132017896", "1231028874", "1355201789", "1230147852", "1932588741",
								 "1922101447", "1232554411", "1632941023", "1332017852", "1632540129"};
	
	private String cpf[] = {"35321077835", "10480916195", "07187650280", "16466578615", "44263783620",
							"97129571365", "49406448637", "86023505465", "86813663003", "51235065278",
							"70244775559", "82973525446", "14161214200", "28061700360", "06788228833"};
	
	private String dataNascimento[] = {"03/05/1981", "10/10/1971", "05/01/1970", "08/11/1987", "04/03/1977", 
									   "03/12/1980", "09/08/1990", "19/07/1985", "13/04/1979", "25/02/1995", 
									   "30/06/1974", "29/09/1988", "18/05/1982", "17/09/1985", "31/07/1970"}; 
	
	private String convenios[] = {"Amil Saúde", "Bradesco Saúde", "Unimed", "Sul América", "Marítima", 
								  "Golden Cross", "Medial", "Intermédica Saúde", "São Cristovão Saúde", "Santamalia saúde"};
	
	public Set<EstadoVO> carregar(){
		
		Set<EstadoVO> listEstado = new TreeSet<EstadoVO>();
		
		for (int i = 0; i < estados.length; i++) {
			EstadoVO estado = new EstadoVO();
			estado.setNomeEstado(estados[i]);
			estado.getUf().setNomeUf(uf[i]);
			listEstado.add(estado);
		}
		
		
		return listEstado;
	}
	
	public Set<MedicoBean> carregarMedicos(){
		Set<MedicoBean> listMedico = new TreeSet<MedicoBean>();
		List<EspecialidadeMedicaBean> lista = null;
		
		for (int i = 0; i < medicos.length; i++) {
			MedicoBean medico = new MedicoBean();
			lista = new ArrayList<EspecialidadeMedicaBean>();
			medico.setNome(medicos[i]);
			
			for (int j = 0; j < 2; j++) {
				EspecialidadeMedicaBean especialidade = new EspecialidadeMedicaBean();
				especialidade.setNomeEspecialidade(especialidades[(int) (Math.random() * medicos.length)]);
				lista.add(especialidade);
			}
			
			medico.setEspecialidadeMedica(lista);
			medico.setCrm(crm[i]);
			listMedico.add(medico);
		}
		return listMedico;
	}
	
	public Set<PacientesBean> carregarPacientes(){
		Set<PacientesBean> listPacientes = new TreeSet<PacientesBean>();
		
		try {
			for (int i = 0; i < pacientes.length; i++) {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date date = format.parse(dataNascimento[i]);
				PacientesBean paciente = new PacientesBean();
				paciente.setNomePaciente(pacientes[i]);
				paciente.setCpfPaciente(cpf[i]);
				paciente.setTelefoneResidencial(telefone[i]);
				paciente.setTelefoneCelular(celular[i]);
				paciente.setDataNascimento(date);
				listPacientes.add(paciente);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return listPacientes;
	}
	
	public Set<ConveniosBean> carregarConvenios(){
		Set<ConveniosBean> listConvenios = new TreeSet<ConveniosBean>();
		
		for (int i = 0; i < convenios.length; i++) {
			ConveniosBean convenio = new ConveniosBean();
			convenio.setNomeConvenio(convenios[i]);
			listConvenios.add(convenio);
		}
		
		return listConvenios;
	}
	
	public List<EspecialidadeMedicaBean> carregarEspecialidades(){
		List<EspecialidadeMedicaBean> listEspecialidades = new ArrayList<EspecialidadeMedicaBean>();
		List<MedicoBean> lista = null;
		
		for (int i = 0; i < especialidades.length; i++) {
			EspecialidadeMedicaBean especialidade = new EspecialidadeMedicaBean();
			lista = new ArrayList<MedicoBean>();
			especialidade.setNomeEspecialidade(especialidades[i]);
			
			for (int j = 0; j < 2; j++) {
				MedicoBean medico = new MedicoBean();
				medico.setNome(medicos[(int) (Math.random() * especialidades.length)]);
				lista.add(medico);
			}
			
			especialidade.setMedicos(lista);
			listEspecialidades.add(especialidade);
		}
		
		return listEspecialidades;
	}

}

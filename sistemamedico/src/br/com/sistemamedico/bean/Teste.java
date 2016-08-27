package br.com.sistemamedico.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String medicos[] = {"José Roberto", "Márcia Vasconcelos", "Alberto Vieira", "Márcio Figueiredo", "Carlos Nagashima",
				"Angela Martins", "Marcela Sampaio", "Verônica Fernandes", "Richard Vianna", "Ana Paula Schmith",
				"Fernando Pusktievski", "Mariana Gonçalves", "Carolina Kornikovski", "Marina paiva", "Marcelo Nogueira"};

		String especialidades[] = {"Acupuntura", "Cancerologia", "Cardiologia", "Cirurgia Pediátrica", "Dermatologia", "Endoscopia",
				       "Gastroenterologia", "Neurocirurgia", "Oftalmologia", "Pneumologia", "Radioterapia", "Urologia",
				       "Otorrinolaringologia", "Anestesiologia", "Cirurgia Geral"};
		
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
			listMedico.add(medico);
		}


	}

}

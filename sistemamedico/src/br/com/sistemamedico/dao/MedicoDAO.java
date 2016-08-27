package br.com.sistemamedico.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.MedicoBean;
import br.com.sistemamedico.factory.ConnectionFactory;

public class MedicoDAO {

	private Connection connection;
	
	public MedicoDAO () throws SQLException {
		this.connection = ConnectionFactory.openConnection();
	}
	
	public void insert(MedicoBean medico) throws SQLException{
		PreparedStatement stmt = 
			connection.prepareStatement("insert into medico (crm,nome,especialidade,sexo,datanascimento) values (?, ?, ?, ?, ?)");
		
		stmt.setString(1, medico.getCrm());
		stmt.setString(2, medico.getNome());
		stmt.setString(3, medico.getEspecialidade());
		stmt.setString(4, medico.getSexo().equals("1") ? "Masculino" : "Feminino");
		stmt.setDate(5, (Date) medico.getDataNascimento());
		
		stmt.execute();
		stmt.close();
		
	}

	public void update(MedicoBean medico) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("update medico set nome=?, especialidade=?, sexo=?, datanascimento=? where crm=" + medico.getCrm() + ";");

		stmt.setString(1, medico.getNome());
		stmt.setString(3, medico.getEspecialidade());
		stmt.setString(4, medico.getSexo());
		stmt.setDate(5, (Date) medico.getDataNascimento());
		
		stmt.execute();
		stmt.close();
		
	}
	
	public void delete(MedicoBean medico) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("delete from medico where crm=?");
		
		stmt.setString(1, medico.getCrm());
		stmt.execute();
		stmt.close();
		
	}
	
	public MedicoBean retrieveById(String crm) throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from medico where crm='" + crm + "'");
		ResultSet rs = stmt.executeQuery();
		
		MedicoBean medico = new MedicoBean();
		
		while(rs.next()){
			medico.setCrm((rs.getString("crm")));
			medico.setNome(rs.getString("nome"));
			medico.setEspecialidade(rs.getString("especialidade"));
			medico.setSexo(rs.getString("sexo"));
			medico.setDataNascimento(rs.getDate("datanascimento"));
		}
		
		rs.close();
		stmt.close();
		
		return medico;
		
	}
	
	public MedicoBean retrieveByName(String nomeMedico) throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from medico where nome='" + nomeMedico + "'");
		ResultSet rs = stmt.executeQuery();
		
		
		MedicoBean medico = new MedicoBean();
		
		while(rs.next()){
			medico.setCrm((rs.getString("crm")));
			medico.setNome(rs.getString("nome"));
			medico.setEspecialidade(rs.getString("especialidade"));
			medico.setSexo(rs.getString("sexo"));
			medico.setDataNascimento(rs.getDate("datanascimento"));
		}
		
		rs.close();
		stmt.close();
		
		return medico;
		
	}
	
	public List<MedicoBean> listar() throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from medico");
		ResultSet rs = stmt.executeQuery();
		
		
		List<MedicoBean> lista = new ArrayList<MedicoBean>();
		
		while(rs.next()){
			MedicoBean medico = new MedicoBean();
			
			medico.setCrm((rs.getString("crm")));
			medico.setNome(rs.getString("nome"));
			medico.setEspecialidade(rs.getString("especialidade"));
			medico.setSexo(rs.getString("sexo"));
			medico.setDataNascimento(rs.getDate("datanascimento"));
			
			lista.add(medico);
		}
		
		rs.close();
		stmt.close();
		
	    return lista;
	    
	}
	
/*	public void insereAssociativoAluno(String cpfAluno) throws SQLException{
		PreparedStatement stmt = 
			connection.prepareStatement("insert into medico_has_disciplina (Aluno_cpfAluno) values (?)");
		
		stmt.setString(1, cpfAluno);
		
		stmt.execute();
		stmt.close();
	} */
}

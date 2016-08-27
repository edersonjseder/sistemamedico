package br.com.sistemamedico.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.PacientesBean;
import br.com.sistemamedico.factory.ConnectionFactory;

public class PacienteDAO {

	private Connection connection;
	
	public PacienteDAO () throws SQLException {
		this.connection = ConnectionFactory.openConnection();
	}
	
	public void insert(PacientesBean paciente) throws SQLException{
		PreparedStatement stmt = 
			connection.prepareStatement("insert into paciente " +
					"(nomePaciente,rgPaciente,cpfPaciente,enderecoPaciente," +
					"cepPaciente,bairroPaciente,cidadePaciente,estadoPaciente,ufPaciente,dataNascimento," +
					"telefoneResidencial,telefoneCelular,sexoPaciente,nomeMae,nomePai) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		stmt.setString(1, paciente.getNomePaciente());
		stmt.setString(2, paciente.getRgPaciente());
		stmt.setString(3, paciente.getCpfPaciente());
		stmt.setString(4, paciente.getEnderecoPaciente());
		stmt.setString(5, paciente.getBairroPaciente());
		stmt.setString(6, paciente.getCidadePaciente());
		stmt.setString(7, paciente.getEstadoPaciente());
		stmt.setString(8, paciente.getCepPaciente());
		stmt.setString(9, paciente.getUfPaciente());
		stmt.setString(10, paciente.getSexoPaciente().equals("1") ? "Masculino" : "Feminino");
		stmt.setDate(11, (Date) paciente.getDataNascimento());
		stmt.setString(12, paciente.getTelefoneResidencial());
		stmt.setString(13, paciente.getTelefoneCelular());
		stmt.setString(14, paciente.getNomeMae());
		stmt.setString(15, paciente.getNomePai());
		
		stmt.execute();
		stmt.close();
		
	}

	public void update(PacientesBean paciente) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("update paciente set nomePaciente=?, rgPaciente=?, cpfPaciente=?, " +
								"enderecoPaciente=?, cepPaciente=?, bairroPaciente=?, cidadePaciente=?, estadoPaciente=?, ufPaciente=?, " +
								"datanascimento=?, telefoneResidencial=?, telefoneCelular=?, sexoPaciente=?, nomeMae=?, nomePai=? where idPaciente=?;");
		
		stmt.setString(1, paciente.getNomePaciente());
		stmt.setString(2, paciente.getRgPaciente());
		stmt.setString(3, paciente.getCpfPaciente());
		stmt.setString(4, paciente.getEnderecoPaciente());
		stmt.setString(5, paciente.getBairroPaciente());
		stmt.setString(6, paciente.getCidadePaciente());
		stmt.setString(7, paciente.getEstadoPaciente());
		stmt.setString(8, paciente.getCepPaciente());
		stmt.setString(9, paciente.getUfPaciente());
		stmt.setString(10, paciente.getSexoPaciente().equals("1") ? "Masculino" : "Feminino");
		stmt.setDate(11, (Date) paciente.getDataNascimento());
		stmt.setString(12, paciente.getTelefoneResidencial());
		stmt.setString(13, paciente.getTelefoneCelular());
		stmt.setString(14, paciente.getNomeMae());
		stmt.setString(15, paciente.getNomePai());
		
		stmt.execute();
		stmt.close();
		
	}
	
	public void delete(PacientesBean paciente) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("delete from paciente where idPaciente=?");
		
		stmt.setInt(1, paciente.getIdPaciente());
		stmt.execute();
		stmt.close();
		
	}
	
	public PacientesBean retrieveById(String idPaciente) throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from paciente where idPaciente='" + idPaciente + "'");
		ResultSet rs = stmt.executeQuery();
		
		PacientesBean paciente = new PacientesBean();
		
		while(rs.next()){
			paciente.setIdPaciente(rs.getInt("idPaciente"));
			paciente.setNomePaciente(rs.getString("nomePaciente"));
			paciente.setRgPaciente(rs.getString("rgPaciente"));
			paciente.setCpfPaciente(rs.getString("cpfPaciente"));
			paciente.setEnderecoPaciente(rs.getString("enderecoPaciente"));
			paciente.setBairroPaciente(rs.getString("bairroPaciente"));
			paciente.setCidadePaciente(rs.getString("cidadePaciente"));
			paciente.setEstadoPaciente(rs.getString("estadoPaciente"));
			paciente.setCepPaciente(rs.getString("cepPaciente"));
			paciente.setUfPaciente(rs.getString("ufPaciente"));
			paciente.setSexoPaciente(rs.getString("sexoPaciente"));
			paciente.setDataNascimento(rs.getDate("datanascimento"));
			paciente.setTelefoneResidencial(rs.getString("telefoneResidencial"));
			paciente.setTelefoneCelular(rs.getString("telefoneCelular"));
			paciente.setNomeMae(rs.getString("nomeMae"));
			paciente.setNomePai(rs.getString("nomePai"));
		}
		
		rs.close();
		stmt.close();
		
		return paciente;
		
	}
	
	public PacientesBean retrieveByName(String nomePaciente) throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from paciente where nomePaciente='" + nomePaciente + "'");
		ResultSet rs = stmt.executeQuery();
		
		
		PacientesBean paciente = new PacientesBean();
		
		while(rs.next()){
			paciente.setIdPaciente(rs.getInt("idPaciente"));
			paciente.setNomePaciente(rs.getString("nomePaciente"));
			paciente.setRgPaciente(rs.getString("rgPaciente"));
			paciente.setCpfPaciente(rs.getString("cpfPaciente"));
			paciente.setEnderecoPaciente(rs.getString("enderecoPaciente"));
			paciente.setBairroPaciente(rs.getString("bairroPaciente"));
			paciente.setCidadePaciente(rs.getString("cidadePaciente"));
			paciente.setEstadoPaciente(rs.getString("estadoPaciente"));
			paciente.setCepPaciente(rs.getString("cepPaciente"));
			paciente.setUfPaciente(rs.getString("ufPaciente"));
			paciente.setSexoPaciente(rs.getString("sexoPaciente"));
			paciente.setDataNascimento(rs.getDate("datanascimento"));
			paciente.setTelefoneResidencial(rs.getString("telefoneResidencial"));
			paciente.setTelefoneCelular(rs.getString("telefoneCelular"));
			paciente.setNomeMae(rs.getString("nomeMae"));
			paciente.setNomePai(rs.getString("nomePai"));
		}
		
		rs.close();
		stmt.close();
		
		return paciente;
		
	}
	
	public List<PacientesBean> listar() throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from paciente");
		ResultSet rs = stmt.executeQuery();
		
		
		List<PacientesBean> lista = new ArrayList<PacientesBean>();
		
		while(rs.next()){
			PacientesBean paciente = new PacientesBean();
			
			paciente.setIdPaciente(rs.getInt("idPaciente"));
			paciente.setNomePaciente(rs.getString("nomePaciente"));
			paciente.setRgPaciente(rs.getString("rgPaciente"));
			paciente.setCpfPaciente(rs.getString("cpfPaciente"));
			paciente.setEnderecoPaciente(rs.getString("enderecoPaciente"));
			paciente.setBairroPaciente(rs.getString("bairroPaciente"));
			paciente.setCidadePaciente(rs.getString("cidadePaciente"));
			paciente.setEstadoPaciente(rs.getString("estadoPaciente"));
			paciente.setCepPaciente(rs.getString("cepPaciente"));
			paciente.setUfPaciente(rs.getString("ufPaciente"));
			paciente.setSexoPaciente(rs.getString("sexoPaciente"));
			paciente.setDataNascimento(rs.getDate("datanascimento"));
			paciente.setTelefoneResidencial(rs.getString("telefoneResidencial"));
			paciente.setTelefoneCelular(rs.getString("telefoneCelular"));
			paciente.setNomeMae(rs.getString("nomeMae"));
			paciente.setNomePai(rs.getString("nomePai"));
			
			lista.add(paciente);
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

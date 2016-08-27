package br.com.sistemamedico.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.MedicamentosBean;
import br.com.sistemamedico.factory.ConnectionFactory;

public class MedicamentosDAO {

	private Connection connection;
	
	public MedicamentosDAO () throws SQLException {
		this.connection = ConnectionFactory.openConnection();
	}
	
	public void insert(MedicamentosBean medicamento) throws SQLException{
		PreparedStatement stmt = 
			connection.prepareStatement("insert into medicamento (medicamento,descricao,dataValidade) values (?, ?, ?)");
		
		stmt.setString(1, medicamento.getNomeMedicamento());
		stmt.setDate(2, (Date) medicamento.getVencimento());
		stmt.setString(3, medicamento.getDescricao());
		
		stmt.execute();
		stmt.close();
		
	}

	public void update(MedicamentosBean medicamento) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("update medicamento set medicamento=?, descricao=?, dataValidade=? where idMedicamento=" + medicamento.getIdMedicamento() + ";");

		stmt.setString(1, medicamento.getNomeMedicamento());
		stmt.setDate(2, (Date) medicamento.getVencimento());
		stmt.setString(3, medicamento.getDescricao());
		
		stmt.execute();
		stmt.close();
		
	}
	
	public void delete(MedicamentosBean medicamento) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("delete from medicamento where idMedicamento=?");
		
		stmt.setInt(1, medicamento.getIdMedicamento());
		stmt.execute();
		stmt.close();
		
	}
	
	public MedicamentosBean retrieveById(Integer idMedicamento) throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from medicamento where idMedicamento='" + idMedicamento + "'");
		ResultSet rs = stmt.executeQuery();
		
		
		MedicamentosBean medicamento = new MedicamentosBean();
		
		while(rs.next()){
			medicamento.setIdMedicamento(rs.getInt("idMedicamento"));
			medicamento.setNomeMedicamento(rs.getString("medicamento"));
			medicamento.setDescricao(rs.getString("descricao"));
			medicamento.setVencimento(rs.getDate("dataValidade"));
		}
		
		rs.close();
		stmt.close();
		
		return medicamento;
		
	}
	
	public MedicamentosBean retrieveByName(String nomeMedicamento) throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from medicamento where medicamento='" + nomeMedicamento + "'");
		ResultSet rs = stmt.executeQuery();
		
		
		MedicamentosBean medicamento = new MedicamentosBean();
		
		while(rs.next()){
			medicamento.setIdMedicamento(rs.getInt("idMedicamento"));
			medicamento.setNomeMedicamento(rs.getString("medicamento"));
			medicamento.setDescricao(rs.getString("descricao"));
			medicamento.setVencimento(rs.getDate("dataValidade"));
		}
		
		rs.close();
		stmt.close();
		
	    return medicamento;
	    
	}
	
	public List<MedicamentosBean> listar() throws SQLException{
		PreparedStatement stmt = connection.prepareStatement("select * from medicamento");
		ResultSet rs = stmt.executeQuery();
		
		
		List<MedicamentosBean> lista = new ArrayList<MedicamentosBean>();
		
		while(rs.next()){
			MedicamentosBean medicamento = new MedicamentosBean();
			
			medicamento.setIdMedicamento(rs.getInt("idMedicamento"));
			medicamento.setNomeMedicamento(rs.getString("medicamento"));
			medicamento.setDescricao(rs.getString("descricao"));
			medicamento.setVencimento(rs.getDate("dataValidade"));
			
			lista.add(medicamento);
		}
		
		rs.close();
		stmt.close();
		
	    return lista;
	}
	
/*	public void insereAssociativoDisciplina(int idDisciplina) throws SQLException{
		PreparedStatement stmt = 
			connection.prepareStatement("insert into aluno_has_medicamento (Disciplina_idDisciplina) values (?)");
		
		stmt.setInt(1, idDisciplina);
		
		stmt.execute();
		stmt.close();
	}*/
}

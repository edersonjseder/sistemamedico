package br.com.sistemamedico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemamedico.bean.ConveniosBean;
import br.com.sistemamedico.factory.ConnectionFactory;

public class ConvenioDAO {

	private Connection connection;
	
	public ConvenioDAO () throws SQLException {
		this.connection = ConnectionFactory.openConnection();
	}
	
	public void insert(ConveniosBean convenio) throws SQLException{
		PreparedStatement stmt = 
			connection.prepareStatement("insert into convenio (idConvenio,nomeConvenio,siteConvenio,descricaoConvenio) values (?, ?, ?, ?)");
		
		stmt.setInt(1, convenio.getIdConvenio());
		stmt.setString(1, convenio.getNomeConvenio());
		stmt.setString(2, convenio.getSiteConvenio());
		stmt.setString(2, convenio.getDescricaoConvenio());
		
		stmt.execute();
		stmt.close();
		
	}

	public void update(ConveniosBean convenio) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("update convenio set nomeConvenio=?, siteConvenio=?, descricao=? where idConvenio=?");

		stmt.setString(1, convenio.getNomeConvenio());
		stmt.setString(2, convenio.getSiteConvenio());
		stmt.setString(2, convenio.getDescricaoConvenio());
		
		stmt.execute();
		stmt.close();
		
	}
	
	public void delete(ConveniosBean convenio) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("delete from convenio where idConvenio=?");
		
		stmt.setInt(1, convenio.getIdConvenio());
		stmt.execute();
		stmt.close();
		
	}
	
	public ConveniosBean retrieveByName(String nomeConvenio) throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from convenio where nomeConvenio='" + nomeConvenio + "'");
		ResultSet rs = stmt.executeQuery();
		
		
		ConveniosBean convenio = new ConveniosBean();
		
		while(rs.next()){
			convenio.setIdConvenio(rs.getInt("idConvenio"));
			convenio.setNomeConvenio(rs.getString("nomeConvenio"));
			convenio.setSiteConvenio(rs.getString("siteConvenio"));
			convenio.setDescricaoConvenio(rs.getString("descricaoConvenio"));
		}
		
		rs.close();
		stmt.close();
		
	    return convenio;
	    
	}
	
	public List<ConveniosBean> listar() throws SQLException{
		PreparedStatement stmt = connection.prepareStatement("select * from convenio");
		ResultSet rs = stmt.executeQuery();
		
		
		List<ConveniosBean> lista = new ArrayList<ConveniosBean>();
		
		while(rs.next()){
			ConveniosBean convenio = new ConveniosBean();

			convenio.setIdConvenio(rs.getInt("idConvenio"));
			convenio.setNomeConvenio(rs.getString("nomeConvenio"));
			convenio.setSiteConvenio(rs.getString("siteConvenio"));
			convenio.setDescricaoConvenio(rs.getString("descricaoConvenio"));
			
			lista.add(convenio);
		}
		
		rs.close();
		stmt.close();
		
	    return lista;
	}
	
}

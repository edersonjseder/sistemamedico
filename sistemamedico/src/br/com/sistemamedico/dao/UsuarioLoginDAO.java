package br.com.sistemamedico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.com.sistemamedico.bean.UsuarioLoginBean;
import br.com.sistemamedico.factory.ConnectionFactory;

public class UsuarioLoginDAO {

	private Connection connection;
	
	public UsuarioLoginDAO () throws SQLException {
		this.connection = ConnectionFactory.openConnection();
	}
	
	public void insert(UsuarioLoginBean usuarioLogin) throws SQLException{
		PreparedStatement stmt = 
			connection.prepareStatement("insert into usuarioLogin (login,senha,nivel) values (?,?,?)");
		
		stmt.setString(1, usuarioLogin.getLogin());
		stmt.setInt(2, usuarioLogin.getPaciente().getIdPaciente());
		stmt.setString(3, usuarioLogin.getSenha() == null ? "1234" : usuarioLogin.getSenha());
		stmt.setInt(4, usuarioLogin.getNivel() == 0 ? 2 : usuarioLogin.getNivel());
		
		stmt.execute();
		stmt.close();
		
	}

	public void update(UsuarioLoginBean usuarioLogin) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("update usuarioLogin set login=?, senha=?, nivel=? where idusuariologin=?");

		stmt.setString(1, usuarioLogin.getLogin());
		stmt.setString(2, usuarioLogin.getSenha());
		stmt.setInt(3, usuarioLogin.getNivel());
		
		stmt.execute();
		stmt.close();
		
	}
	
	public void delete(UsuarioLoginBean usuarioLogin) throws SQLException{
		PreparedStatement stmt =
						connection.prepareStatement("delete from usuarioLogin where idusuariologin=?");
		
		stmt.setString(1, usuarioLogin.getLogin());
		stmt.execute();
		stmt.close();
		
	}
	
	public UsuarioLoginBean retrieveByName(String userLogin, String senha) throws SQLException{   
		PreparedStatement stmt = connection.prepareStatement("select * from usuarioLogin where login='" + userLogin + "' and senha='" + senha + "'");
		ResultSet rs = stmt.executeQuery();
		
		
		UsuarioLoginBean usuario = new UsuarioLoginBean();
		
		while(rs.next()){
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setNivel(rs.getInt("nivel"));
		}
		
		rs.close();
		stmt.close();
		
	    return usuario;
	    
	}
}

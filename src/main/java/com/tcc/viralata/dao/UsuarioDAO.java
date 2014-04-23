package com.tcc.viralata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tcc.viralata.model.Usuario;
import com.tcc.viralata.utils.ConnectionFactory;
import com.tcc.viralata.utils.ConstantsViraLata;

public class UsuarioDAO extends ConnectionFactory{

	public Usuario login (String usuario,String senha){
		Usuario usuarioObject = new Usuario();
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();
		try {
			String selectSQL = "select * from \"Usuario\" where login=? and senha=?";
			PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
			preparedStatement.setString(1, usuario);
			preparedStatement.setString(2, senha);
			rs = preparedStatement.executeQuery();
			
			
			while(rs.next()){
				usuarioObject.setCpfCnpj(rs.getString("cpfCnpj"));
				usuarioObject.setTipoAcesso(rs.getString("tipoAcesso"));
				usuarioObject.setDataNascimento(rs.getDate("dataNascimento"));
				usuarioObject.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			usuarioObject.setStatus(ConstantsViraLata.ERRO_LOGIN);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return usuarioObject;
	}
	
}

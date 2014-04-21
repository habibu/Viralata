package com.tcc.viralata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tcc.viralata.model.Usuario;
import com.tcc.viralata.utils.ConnectionFactory;
import com.tcc.viralata.utils.ConstantsViraLata;

public class UsuarioDAO extends ConnectionFactory{

	public Usuario login (Integer usuario,String senha){
		Usuario usuarioObject = new Usuario();
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();
		try {
			String selectSQL = "select * from usuario where usuario.login=? and usuario.senha=?";
			PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
			preparedStatement.setInt(1, usuario);
			preparedStatement.setString(2, senha);
			rs = preparedStatement.executeQuery();
			
			usuarioObject.setStatus(ConstantsViraLata.ERRO_LOGIN);
			
			while(rs.next()){
				usuarioObject.setTpAcesso(rs.getString("tpAcesso"));
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao realizar login: " + e);	
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return usuarioObject;
	}
	
}

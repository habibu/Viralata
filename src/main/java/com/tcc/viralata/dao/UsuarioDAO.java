package com.tcc.viralata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.postgresql.util.PSQLException;

import com.tcc.viralata.model.Cidade;
import com.tcc.viralata.model.Endereco;
import com.tcc.viralata.model.Status;
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
			
			usuarioObject.setStatus(ConstantsViraLata.ERRO_LOGIN);
			
			while(rs.next()){
				usuarioObject.setNome(rs.getString("login"));
				usuarioObject.setCpfCnpj(rs.getString("cpfCnpj"));
				usuarioObject.setTipoAcesso(rs.getString("tipoAcesso"));
				usuarioObject.setDataNascimento(rs.getDate("dataNascimento"));
				usuarioObject.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			usuarioObject.setStatus(ConstantsViraLata.ERRO_REDE);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return usuarioObject;
	}
	
	public Status cadastraUsuario(Usuario usuario, Endereco endereco, Cidade cidade){
		Status status = new Status();
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();
		try {
			String insertSQL = "insert into \"Usuario\" (nome,login,senha,dataNascimento,cpfCnpj,email,rg,tipoAcesso) values (?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conexao.prepareStatement(insertSQL);
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getLogin());
			preparedStatement.setString(3, usuario.getSenha());
			java.sql.Date dataNasc = new java.sql.Date(usuario.getDataNascimento().getTime());
			preparedStatement.setDate(4, dataNasc);
			preparedStatement.setString(5, usuario.getCpfCnpj());
			preparedStatement.setString(6, usuario.getEmail());
			preparedStatement.setString(7, usuario.getRg());
			preparedStatement.setString(8, usuario.getTipoAcesso());
			preparedStatement.executeUpdate();
			
			String selectSQL = "select * from \"Usuario\" where login=?";
			preparedStatement = conexao.prepareStatement(selectSQL);
			preparedStatement.setString(1, usuario.getLogin());
			rs = preparedStatement.executeQuery();
			
			Integer idUsuario = 0;
			
			while(rs.next()){
				idUsuario = rs.getInt("idUsuario");
			}
			
			if (idUsuario!=0){
				insertSQL = "insert into \"Endereco\" (rua,numero,cep,bairro,telefone,\"idUsuario_Usuario\",\"idCidade_Cidade\") values (?,?,?,?,?,?,?)";
				preparedStatement = conexao.prepareStatement(insertSQL);
				preparedStatement.setString(1, endereco.getRua());
				preparedStatement.setInt(2, endereco.getNumero());
				preparedStatement.setInt(3, Integer.valueOf(endereco.getCep()));
				preparedStatement.setString(4, endereco.getBairro());
				preparedStatement.setString(5, endereco.getTelefoneResidencial());
				preparedStatement.setInt(6, idUsuario);
				preparedStatement.setInt(7, Integer.valueOf(cidade.getIdCidade()));
				preparedStatement.executeUpdate();
			}else{
				throw new Exception();
			}
			
			status.setStatus(ConstantsViraLata.SUCESSO_CADASTRO);
			
			
		}catch (PSQLException e){
			if (ConstantsViraLata.UNIQUE_VIOLATION.equals(e.getSQLState())){
				String mensagemErro = e.getMessage();
				if (mensagemErro.contains("cpfcnpj")){
					status.setStatus(ConstantsViraLata.USUARIO_JA_EXISTENTE);
				}else{
					status.setStatus(ConstantsViraLata.LOGIN_JA_EXISTENTE);
				}
			}else{
				String deleteSQL = "delete from \"Usuario\" where login=?";
				PreparedStatement preparedStatement;
				try {
					preparedStatement = conexao.prepareStatement(deleteSQL);
					preparedStatement.setString(1, usuario.getLogin());
					preparedStatement.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}catch (Exception e) {
			status.setStatus(ConstantsViraLata.ERRO_REDE);
			String deleteSQL = "delete from \"Usuario\" where login=?";
			PreparedStatement preparedStatement;
			try {
				preparedStatement = conexao.prepareStatement(deleteSQL);
				preparedStatement.setString(1, usuario.getLogin());
				preparedStatement.executeUpdate();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return status;
	}
	
}

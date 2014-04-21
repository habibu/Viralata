package com.tcc.viralata.model;

import java.util.Date;

import org.springframework.stereotype.Component;

public class Usuario extends Status {
	
	private String cpfCnpj;
	private String nome;
	private String senha;
	private String email;
	private String rg;
	private Date dataNascimento;
	private Endereco endereco;
	private String tpAcesso;
	
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Usuario inserirUsuario(Usuario usuario){
		return usuario;
	}
	
	public Usuario alterarUsuario(Usuario usuario){
		return usuario;
	}
	public String getTpAcesso() {
		return tpAcesso;
	}
	public void setTpAcesso(String tpAcesso) {
		this.tpAcesso = tpAcesso;
	}
	
	

}

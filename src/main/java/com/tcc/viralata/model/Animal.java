package com.tcc.viralata.model;

import java.util.Date;

public class Animal {
	
	private int idade;
	private String raca;
	private String nome;
	private String cor;
	private String especie;
	private String tamanho;
	private String resenha;	
	private String foto;
	private String chip;
	private String situacao;
	private Date dataCadastro;
	private Feira feira;
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getResenha() {
		return resenha;
	}
	public void setResenha(String resenha) {
		this.resenha = resenha;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getChip() {
		return chip;
	}
	public void setChip(String chip) {
		this.chip = chip;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Feira getFeira() {
		return feira;
	}
	public void setFeira(Feira feira) {
		this.feira = feira;
	}
	
	public Animal inserirAnimal(Animal animal){
		return animal;
	}
	
	public Animal alterarAnimal(Animal animal){
		return animal;
	}
	
	public void excluirAnimal(Animal animal){
		System.out.println("Excluído");
	}

}

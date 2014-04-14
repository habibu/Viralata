package com.tcc.viralata.model;

import java.util.Date;

public class Adocao {
	
	private int status;
	private Date dataAdocao;
	private Adotante adotante;
	private Animal animal;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDataAdocao() {
		return dataAdocao;
	}
	public void setDataAdocao(Date dataAdocao) {
		this.dataAdocao = dataAdocao;
	}
	public Adotante getAdotante() {
		return adotante;
	}
	public void setAdotante(Adotante adotante) {
		this.adotante = adotante;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public Adocao inserirAdocao(Adocao adocao){
		return adocao;
	}
	
	public Adocao alterarAdocao(Adocao adocao){
		return adocao;
	}
	
	public void excluirAdocao(Adocao adocao){
		System.out.println("Excluído");
	}

}

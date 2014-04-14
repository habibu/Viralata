package com.tcc.viralata.model;

import java.util.Date;

public class Feira {
	
	private String local;
	private Date dataRealizacao;
	private int numeroAnimais;
	private int animaisAdotados;
	private float longitude;
	private float latitude;
	private Cidade cidade;
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Date getDataRealizacao() {
		return dataRealizacao;
	}
	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	public int getNumeroAnimais() {
		return numeroAnimais;
	}
	public void setNumeroAnimais(int numeroAnimais) {
		this.numeroAnimais = numeroAnimais;
	}
	public int getAnimaisAdotados() {
		return animaisAdotados;
	}
	public void setAnimaisAdotados(int animaisAdotados) {
		this.animaisAdotados = animaisAdotados;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}

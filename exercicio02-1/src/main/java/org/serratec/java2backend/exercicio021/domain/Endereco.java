package org.serratec.java2backend.exercicio021.domain;

import javax.persistence.Embeddable;

import io.swagger.annotations.ApiModelProperty;

@Embeddable
public class Endereco {
	@ApiModelProperty(value = "Logradouro do cliente")
	private String logradouro;
	@ApiModelProperty(value = "Número da casa do cliente")
	private String numero;
	@ApiModelProperty(value = "Bairro do cliente")
	private String bairro;
	@ApiModelProperty(value = "Cidade do cliente")
	private String cidade;
	@ApiModelProperty(value = "Estado do cliente")
	private String estado;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}

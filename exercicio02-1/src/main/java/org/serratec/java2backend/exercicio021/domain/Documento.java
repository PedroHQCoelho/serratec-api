package org.serratec.java2backend.exercicio021.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Documento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_documento")
	@ApiModelProperty(value = "Identificador único do documento do cliente")
	private Long id;
	
	@Column
	@ApiModelProperty(value = "Identidade do cliente")
	private String identidade;
	
	@Column(name = "orgao_expedidor")
	@ApiModelProperty(value = "Órgão expedidor da identidade do cliente")
	private String orgaoExpedidor;
	
	@Column(name = "titulo_eleitor")
	@ApiModelProperty(value = "Título de eleitor do cliente")
	private String tituloEleitor;
	
	@OneToOne
	@JoinColumn(name = "id_cliente")
	@ApiModelProperty(value = "Identificador único do cliente")
	private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
}

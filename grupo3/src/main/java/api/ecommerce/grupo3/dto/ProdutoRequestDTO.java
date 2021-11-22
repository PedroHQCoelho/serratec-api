package api.ecommerce.grupo3.dto;

import api.ecommerce.grupo3.domain.Categoria;
import api.ecommerce.grupo3.domain.Produto;
import java.math.BigDecimal;

public class ProdutoRequestDTO {
	
	private String nomeProduto;
	private BigDecimal valor;
	private BigDecimal qtdEstoque;
	private Categoria categoria;
	
	public ProdutoRequestDTO() {
	}
	
	public ProdutoRequestDTO(String nomeProduto, BigDecimal valor, BigDecimal qtdEstoque, Categoria categoria) {
		super();
		this.nomeProduto = nomeProduto;
		this.valor = valor;
		this.qtdEstoque = qtdEstoque;
		this.categoria = categoria;
	}

	public ProdutoRequestDTO(Produto produto) {
		super();
		this.nomeProduto = produto.getNomeProduto();
		this.valor = produto.getValor();
		this.qtdEstoque = produto.getQtdEstoque();
		this.setCategoria(produto.getCategoria());
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(BigDecimal qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}

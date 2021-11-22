package api.ecommerce.grupo3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.ecommerce.grupo3.domain.Pedido;
import api.ecommerce.grupo3.domain.PedidoProduto;
import api.ecommerce.grupo3.domain.Produto;
import api.ecommerce.grupo3.repository.PedidoRepository;
import api.ecommerce.grupo3.service.PedidoService;
import api.ecommerce.grupo3.service.ProdutoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRespository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Override
	public List<Pedido> listar() {
		List<Pedido> pedidos = pedidoRespository.findAll();

		for(Pedido pedido: pedidos) {
		calcularTotalPedido(pedido);
		}
		
		return pedidoRespository.findAll();
	}

	@Override
	public Optional<Pedido> pesquisarUm(Long idPedido) {
		Pedido pedido = pedidoRespository.getById(idPedido);
		
		calcularTotalPedido(pedido);
		
		return pedidoRespository.findById(idPedido);
	}


	
	@Override
	public Pedido inserir(Pedido pedido) {
		Pedido p = new Pedido();
		p.setCliente(pedido.getCliente());
		p.setDataPedido(pedido.getDataPedido());
		p.setStatus(pedido.getStatus());
		
		for(PedidoProduto pedidoProduto: pedido.getPedidoProdutos()) {
			Produto produto = new Produto();
			pedidoProduto.setPedido(pedido);
 			pedidoProduto.setProduto(produto);
			//pedidoProduto.setProduto(produtoService.buscar(pedidoProduto.getProduto().getId_produto()));
			pedidoProduto.setQtdCompradaPorProduto(pedidoProduto.getQtdCompradaPorProduto());
		}
		
		return pedidoRespository.save(pedido);
	}

	
	
	@Override
	public boolean idExiste(Long id) {
		return pedidoRespository.existsById(id);
	}

	@Override
	public void remover(Long id) {
		pedidoRespository.deleteById(id);		
	}

	@Override
	public List<Pedido> inserirVarios(List<Pedido> listaPedido) {
		return pedidoRespository.saveAll(listaPedido);
	}
	
//	//pode ser void?
//	//pegar quantidade de venda e nao de ESTOQUE
//	@Override
//	public Long calcularTotalPedido(Pedido pedido) {
//		Long valorTotal = (long) 0;
//		
//		//for(Produto produto: pedido.getProdutos()) {
//	//	for(Produto produto: pedido.getPedidoProduto().getProduto()) {
//			valorTotal = valorTotal + pedido.getPedidoProduto().getQtdCompradaPorProduto();//* produto.getValor();
//	//	}
//		
//		pedido.setValorTotalPedido(valorTotal);
//		return valorTotal;
//	}	
	
	@Override
	public Long calcularTotalPedido(Pedido pedido) {
		//public Long calcularTotalPedido(PedidoProduto pedidoProduto) {
	Long valorTotal = 0l;

	PedidoProduto pedidoProduto = new PedidoProduto();
	
	for(Produto produto: produtoService.pesquisarTodos()){
		valorTotal += pedidoProduto.getQtdCompradaPorProduto() * produto.getValor();
			//valorTotal += pedidoProduto.getQtdCompradaPorProduto() * pedidoProduto.getProduto().getValor();
	}
		
		pedido.setValorTotalPedido(valorTotal);
		//pedidoProduto.getPedido().setValorTotalPedido(valorTotal);
		return valorTotal;
	}	
	
	
	
	
//	public Long calcularTotalPedido(PedidoProduto pedidoProduto) {
//	Long valorTotal = (long) 0;
//	
//	List<Pedido> pedidos = pedidoRespository.findAll();
//		
//	for(Produto produto: pedidos){
//			valorTotal += pedidoProduto.getQtdCompradaPorProduto() * pedidoProduto.getProduto().getValor();
//	}
//		
//		pedidoProduto.getPedido().setValorTotalPedido(valorTotal);
//		return valorTotal;
//	}	
//	

	public PedidoRepository getPedidoRespository() {
		return pedidoRespository;
	}

	public void setPedidoRespository(PedidoRepository pedidoRespository) {
		this.pedidoRespository = pedidoRespository;
	}

	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
}
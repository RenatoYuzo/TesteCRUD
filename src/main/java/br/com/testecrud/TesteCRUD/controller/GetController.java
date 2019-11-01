package br.com.testecrud.TesteCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testecrud.TesteCRUD.model.Produto;
import br.com.testecrud.TesteCRUD.service.ProdutoService;

/**
 * Classe de controle de mapeamento para solicitações GET
 */
@RestController
@RequestMapping(produces = "application/json")
public class GetController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String index() {
		return "<h1 style=\"color: blue;\">Por favor, coloque o path correto!</h1>";
	}

	@GetMapping(path = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produto> findAllProduto() {
		return produtoService.findAllProduto();
	}

	@GetMapping(path = "/produtos/{id}")
	public Produto findByIdProduto(@PathVariable Integer id) {
		return produtoService.findByIdProduto(id);
	}

	/**
	 * 1 - Listar todos os produtos por nome (ASC OU DESC)
	 * 
	 */
	@GetMapping(path = "/produtos/nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produto> findAllOrderByNome() {
		return produtoService.findAllOrderByNomeProduto();
	}

	/**
	 * 2 - Listar produtos por quantidade(ASC OU DESC)
	 * 
	 */
	@GetMapping(path = "/produtos/quantidade", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produto> findAllOrderByQuantidade() {
		return produtoService.findAllOrderByQtdProduto();
	}

	/**
	 * 3 - Listar o produto com maior quantidade e com menor quantidade na mesma
	 * consulta, trazer somente 2 produtos.
	 * 
	 */
	@GetMapping(path = "/produtos/maior-menor", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produto> findMaiorMenorQtd() {
		return produtoService.findMaiorMenorQtdProduto();
	}

	/**
	 * 5 - Listar todos os produtos por categoria, a categoria será definida pelo usuário.
	 * 
	 */
	@GetMapping(path = "/produtos/categoria/{categoria_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produto> findProdutosPorCategoria(@PathVariable Integer categoria_id) {
		return produtoService.findProdutosPorCategoria(categoria_id);
	}

}

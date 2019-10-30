package br.com.testecrud.TesteCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testecrud.TesteCRUD.model.Produto;
import br.com.testecrud.TesteCRUD.repository.ProdutoRepository;

/**
 * Classe de controle de mapeamento para solicitações GET
 */
@RestController
@RequestMapping(produces = "application/json")
public class GetController {

	@Autowired
	ProdutoRepository produtoRepo;

	/**
	 * Resposta de erro para caso seja buscado sem path definido (apenas: redee/)
	 * 
	 * @return retorna mensagem com erro de path incompleto
	 */
	@GetMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String index() {
		return "<h1 style=\"color: blue;\">Por favor, coloque o path correto!</h1>";
	}

	@GetMapping(path = "/produtos")
	public List<Produto> findAllProduto() {
		return produtoRepo.findAll();
	}

	@GetMapping(path = "/produtos/{id}")
	public Produto findByIdProduto(@PathVariable Integer id) {
		return produtoRepo.findById(id);
	}

}

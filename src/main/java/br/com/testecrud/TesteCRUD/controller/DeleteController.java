package br.com.testecrud.TesteCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testecrud.TesteCRUD.service.ProdutoService;

/**
 * Classe de controle de mapeamento para solicitações DELETE
 */
@RestController
@RequestMapping(produces = "application/json")
public class DeleteController {

	@Autowired
	ProdutoService produtoService;

	/**
	 * 4 - Delete por nome ou id
	 */
	@DeleteMapping(path = "/produtos/delete/{id}")
	public String deleteByIdProduto(@PathVariable Integer id) {
		return produtoService.deleteByIdProduto(id);
	}

}
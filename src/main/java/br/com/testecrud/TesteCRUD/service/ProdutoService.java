package br.com.testecrud.TesteCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testecrud.TesteCRUD.model.Produto;
import br.com.testecrud.TesteCRUD.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepo;

	public List<Produto> findAllProduto() {
		return produtoRepo.findAll();
	}

	public Produto findByIdProduto(Integer id) {
		return produtoRepo.findById(id);
	}

	public List<Produto> findAllOrderByNomeProduto() {
		return produtoRepo.findAllOrderByNomeProduto();
	}

	public List<Produto> findAllOrderByQtdProduto() {
		return produtoRepo.findAllOrderByQtdProduto();
	}

	public List<Produto> findMaiorMenorQtdProduto() {
		return produtoRepo.findMaiorMenorQtdProduto();
	}

	public String deleteByIdProduto(Integer id) {

		int i = produtoRepo.deleteByIdProduto(id);
		if (i > 0)
			return "Produto removido com sucesso!";
		else
			return "Produto não foi removido!";

	}

}
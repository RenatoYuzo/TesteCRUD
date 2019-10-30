package br.com.testecrud.TesteCRUD.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.testecrud.TesteCRUD.model.Produto;
import br.com.testecrud.TesteCRUD.utils.AbstractRepository;
import br.com.testecrud.TesteCRUD.utils.ConnectionFactory;

@Repository
public class ProdutoRepository extends AbstractRepository {

	Connection conn = ConnectionFactory.getConnection();

	/**
	 * Este metodo faz a busca de todos os registros de Produto no banco de dados
	 * 
	 * @return Retorna uma lista de Produtos
	 */
	public List<Produto> findAll() {

		try {
			String sql = "select * from Produto;";
			List<Produto> listaProdutos = executeQueryListResult(sql, conn, Produto.class);
			return listaProdutos;
		} catch (SQLException e) {
			System.err.println("Erro ProdutoRepository[01]: " + e.getMessage());
			return null;
		}

	}

	/**
	 * Este metodo faz a busca de um especifico Produto, produrando pelo seu id
	 * 
	 * @param id Identificador unico do Produto
	 * 
	 * @return Retorna um objeto Produto
	 */
	public Produto findById(Integer id) {

		try {
			String sql = "select * from Produto where id=" + id;
			Produto produto = executeQuerySingleResult(sql, conn, Produto.class);
			return produto;
		} catch (SQLException e) {
			System.err.println("Erro ProdutoRepository[02]: " + e.getMessage());
			return null;
		}

	}

}
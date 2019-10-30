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

	/**
	 * Este metodo faz a busca de todos os registros de Produto
	 * 
	 * @return Retorna todos os produtos ordenados pelo nome
	 */
	public List<Produto> findAllOrderByNomeProduto() {

		try {
			String sql = "select * from Produto order by nome asc";
			List<Produto> listaProdutos = executeQueryListResult(sql, conn, Produto.class);
			return listaProdutos;
		} catch (SQLException e) {
			System.err.println("Erro ProdutoRepository[03]: " + e.getMessage());
			return null;
		}

	}

	/**
	 * Este metodo faz a busca de todos os registros de Produto
	 * 
	 * @return Retorna todos os produtos ordenados pela quantidade
	 */
	public List<Produto> findAllOrderByQtdProduto() {

		try {
			String sql = "select * from Produto order by qtd_estoque asc";
			List<Produto> listaProdutos = executeQueryListResult(sql, conn, Produto.class);
			return listaProdutos;
		} catch (SQLException e) {
			System.err.println("Erro ProdutoRepository[04]: " + e.getMessage());
			return null;
		}

	}

	/**
	 * Este metodo faz a busca do produto com a maior quantidade e tambem do produto
	 * com a menor quantidade em estoque
	 * 
	 * @return Retorna os produtos com a maior e menor quantidade
	 */
	public List<Produto> findMaiorMenorQtdProduto() {

		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" select top 1 * from Produto order by qtd_estoque asc \n");
			sql.append(" union \n");
			sql.append(" select top 1 * from Produto order by qtd_estoque desc \n");

			List<Produto> listaProdutos = executeQueryListResult(sql.toString(), conn, Produto.class);
			return listaProdutos;
		} catch (SQLException e) {
			System.err.println("Erro ProdutoRepository[05]: " + e.getMessage());
			return null;
		}

	}

	/**
	 * Este metodo faz a remocao de um registro de Produto do banco de dados de
	 * acordo com seu id
	 * 
	 * @param id Identificador do Produto a ser removido
	 */
	public int deleteByIdProduto(Integer id) {

		try {
			String sql = "delete from Produto where id=" + id;
			return execute(sql, conn);
		} catch (SQLException e) {
			System.err.println("Erro ProdutoRepository[06]: " + e.getMessage());
			return -1;
		}

	}

}
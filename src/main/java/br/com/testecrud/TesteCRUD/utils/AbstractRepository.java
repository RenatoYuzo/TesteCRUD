package br.com.testecrud.TesteCRUD.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public abstract class AbstractRepository {

	public <T> List<T> executeQueryListResult(String sql, Connection conn, Class<T> classtype) throws SQLException {
		QueryRunner run = new QueryRunner();
		BeanListHandler<T> blh = new BeanListHandler<>(classtype);
		return run.query(conn, sql, blh);
	}

	public <T> T executeQuerySingleResult(String sql, Connection conn, Class<T> classtype) throws SQLException {
		QueryRunner run = new QueryRunner();
		BeanHandler<T> blh = new BeanHandler<>(classtype);
		return run.query(conn, sql, blh);
	}

}
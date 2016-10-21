package br.agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;

	public void abreConecxao() {

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "bdAgenda.bd");
			System.out.println("Conectado");
		} catch (final SQLException e) {
			e.printStackTrace();
		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fechaConexao() {

		try {
			conn.close();
			System.out.println("Desconectado");
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

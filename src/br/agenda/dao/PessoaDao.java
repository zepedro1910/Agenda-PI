package br.agenda.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.agenda.entity.Pessoa;

public class PessoaDao extends Conexao {

	public static void main(final String[] args) {
		final Pessoa p1 = new Pessoa("pedro", "02/04/1989", "111111111", "aaaaaaaaa");
		final PessoaDao p = new PessoaDao();
		p.adicionaContato(p1);

	}

	public void adicionaContato(final Pessoa pessoa) {

		final String sql = "INSERT INTO TB_CONTATO (NOME, DT_NASC, TELEFONE, EMAIL, DT_CADASTRO)" + //
				" VALUES (?,?,?,?,?,datetime('now'))";

		try {
			abreConecxao();
			stmt = conn.prepareStatement(sql);
			System.out.println("aqui");
			stmt.setString(1, pessoa.getName());
			stmt.setString(2, pessoa.getDateOfBirth());
			stmt.setString(3, pessoa.getPhone());
			stmt.setString(4, pessoa.getEmail());
			stmt.execute();
			stmt.close();
			fechaConexao();
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Pessoa> listarPessoas() {

		final List<Pessoa> lista = new ArrayList<Pessoa>();

		final String sql = "SELECT * FROM TB_CONTATO";

		try {

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				final Pessoa p = new Pessoa();
				p.setName(rs.getString("NOME"));
				p.setDateOfBirth(rs.getString("DT_NAS"));
				p.setPhone("TELEFONE");
				p.setEmail("EMAIL");
				lista.add(p);
				stmt.close();
				fechaConexao();
				return lista;
			}
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}

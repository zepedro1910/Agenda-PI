package br.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.agenda.dao.PessoaDao;
import br.agenda.entity.Pessoa;

/**
 * Servlet implementation class ListarServlet
 */
public class ListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		final PrintWriter out = response.getWriter();

		final PessoaDao pd = new PessoaDao();

		final List<Pessoa> agenda = pd.listarPessoas();

		out.println("<table border='1'>"//
				+ "<tr>"//
				+ "<th>Nome</th>"//
				+ "<th>Data Nasc</th>"//
				+ "<th>Telefone</th>"//
				+ "<th>Email</th>"//
				+ "<th>Dt.Cadastro</th>"//
				+ "</tr>");//
		for (final Pessoa p : agenda) {
			out.println("<tr>");
			out.println("<td>" + p.getName() + "</td>");
			out.println("<td>" + p.getDateOfBirth() + "</td>");
			out.println("<td>" + p.getPhone() + "</td>");
			out.println("<td>" + p.getEmail() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>"//
				+ "<form action='index.html'>"//
				+ "<input type='submit' value='Cadastrar novo contato'/>"//
				+ "</form>");//

		doGet(request, response);
	}

}

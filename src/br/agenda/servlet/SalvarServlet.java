package br.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.agenda.dao.PessoaDao;
import br.agenda.entity.Pessoa;

/**
 * Servlet implementation class SalvarServlet
 */
public class SalvarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalvarServlet() {
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

		final PessoaDao pd = new PessoaDao();
		final PrintWriter out = response.getWriter();

		final String name = request.getParameter("nome");
		final String dateOfBirth = request.getParameter("dataNascimento");
		final String phone = request.getParameter("telefone");
		final String email = request.getParameter("email");

		final Pessoa contato = new Pessoa(name, dateOfBirth, phone, email);

		pd.adicionaContato(contato);

		out.println("<html>"//
				+ "<head>"//
				+ "</head>"//
				+ "<body>"//
				+ "<label>Contato Salvo</p>"//
				+ "<form action='Lista.html' method='post'>"//
				+ "<input type='submit' value='Voltar'>"//
				+ "</form>" + "</body>"//
				+ "</html>");
		doGet(request, response);
	}

}

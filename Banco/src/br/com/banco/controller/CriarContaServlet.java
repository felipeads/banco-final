package br.com.banco.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.banco.bean.Conta;
import br.com.banco.dao.BancoDAO;

public class CriarContaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		request.removeAttribute("message");
		if ("criarConta".equals(action)) {

			request.getRequestDispatcher("/criar_conta.jsp").forward(request, response);
		} else {

			String cpf = request.getParameter("cpf");
			String nome = request.getParameter("nome");
			
			if(Objects.isNull(cpf) || "".equals(cpf) 
					|| Objects.isNull(nome) || "".equals(nome) ) {
				request.setAttribute("message", "Campo obrigat�rio");
				request.getRequestDispatcher("/criar_conta.jsp").forward(request, response);
			}
			Conta conta = new Conta();
			conta.setCpf(cpf);
			conta.setNome(nome);
			conta.setValor(new Double(0.0));
			BancoDAO bancoDAO = new BancoDAO();
			bancoDAO.inserirConta(conta);
			Long idConta = bancoDAO.getConta(conta.getCpf()).getId();
			request.getSession().setAttribute("nome",
					"Olá, " + conta.getNome() + ",seu saldo é de: " + conta.getValor() + " informe deposito ou saque!");
			request.getSession().setAttribute("idConta", idConta);
			request.getSession().setAttribute("valor", conta.getValor());
			request.getRequestDispatcher("/logado.jsp").forward(request, response);
		}
	}
}

package br.com.banco.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.banco.bean.Conta;
import br.com.banco.dao.BancoDAO;

public class EntrarContaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/home.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BancoDAO bancoDAO = new BancoDAO();
		request.removeAttribute("message");
		String acao = (String) request.getParameter("action");
		if(Objects.nonNull(acao) && "logado".equals(acao)) {
			Long idConta = (Long) request.getSession().getAttribute("idConta");
			Conta conta = bancoDAO.getContaPorId(idConta);
			if(Objects.nonNull(conta)) {
				request.getSession().setAttribute("nome",
						"Olá, " + conta.getNome() + ",seu saldo é de: " + conta.getValor());
				request.getSession().setAttribute("idConta", conta.getId());
				request.getSession().setAttribute("valor", conta.getValor());
				request.getRequestDispatcher("/logado.jsp").forward(request, response);
			}
		}
		 
		
		String cpf = request.getParameter("cpf");
		if(Objects.isNull(cpf) || "".equals(cpf)) {
			request.setAttribute("message", "Campo obrigatório");
			request.getRequestDispatcher("/entrar_conta.jsp").forward(request, response);
		}
		Conta conta = bancoDAO.getConta(cpf);
		if(Objects.nonNull(conta)) {
			request.getSession().setAttribute("nome",
					"Olá, " + conta.getNome() + ",seu saldo é de: " + conta.getValor());
			request.getSession().setAttribute("idConta", conta.getId());
			request.getSession().setAttribute("valor", conta.getValor());
			request.getRequestDispatcher("/logado.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/entrar_conta.jsp").forward(request, response);
		}
		System.out.println("Criou conta");
	}
}

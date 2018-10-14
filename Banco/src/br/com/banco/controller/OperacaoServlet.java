package br.com.banco.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.banco.bean.Conta;
import br.com.banco.dao.BancoDAO;

public class OperacaoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.removeAttribute("message");
		String valor = request.getParameter("valor").replace(",", ".");
		Long idConta = (Long) request.getSession().getAttribute("idConta");
		Double valorAtual = (Double) request.getSession().getAttribute("valor");
		if(Objects.isNull(valor) || "".equals(valor)) { 
			request.removeAttribute("message");
			request.setAttribute("message", "Campo obrigatório"); 
			request.getRequestDispatcher("/logado.jsp").forward(request, response);
		} 
		BancoDAO bancoDAO = new BancoDAO();
		bancoDAO.novoValor(valorAtual,new Double(valor), idConta);
		Conta conta = bancoDAO.getContaPorId(idConta);
		if(Objects.nonNull(conta)) {
			request.getSession().setAttribute("nome",
					"Olá, " + conta.getNome() + ",seu saldo é de: " + conta.getValor());
			request.getSession().setAttribute("idConta", conta.getId());
			request.getSession().setAttribute("valor", conta.getValor());
		}
		request.getRequestDispatcher("/logado.jsp").forward(request, response);
	}
}

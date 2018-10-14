package br.com.banco.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.banco.bean.Conta;
import br.com.banco.bean.Extrato;
import br.com.banco.dao.BancoDAO;

public class ExtratoServlet extends HttpServlet {

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
		Long idConta = (Long)request.getSession().getAttribute("idConta");
		Conta conta = bancoDAO.getContaPorId(idConta);
		List<Extrato> extratos = bancoDAO.listarExtrato(idConta);
		extratos.stream().forEach(extrato->extrato.setCpfResponsavel(conta.getCpf()));
		request.setAttribute("extratos", extratos);
		request.getRequestDispatcher("/extrato.jsp").forward(request, response);
	}
}

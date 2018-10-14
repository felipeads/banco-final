<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title> Extrato  </title>
		<link rel="stylesheet" href="css/960.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/template.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/colour.css" type="text/css" media="screen" charset="utf-8" />
	</head>	
	<body>
	<h1 id="head">Dados Bancários</h1>
	<ul id="navigation">
		<li><a href="#">
				<form method="Post" action="HomeServlet">
					<input type="submit" value="Home">
				</form>
		</a></li>
		<li><a href="#">
				<form method="Post" action="CriarContaServlet">
					<input type="hidden" value="criarConta" name="action"> <input
						type="submit" value="Criar Conta">
				</form>
		</a></li>
		<li><a href="#"> 
		<form method="Post" action="EntrarContaServlet">
			<input type="hidden" value="logado" name="action">		
			<input type="submit" value="Conta">						
		</form>	 </a></li>
		<li><span class="active">
				<form method="Post" action="ExtratoServlet">
					<input type="submit" value=" Ver Extrato">
				</form>
		</span></li>
	</ul>
	<div id="content" class="container_16 clearfix">
			<div class="grid_11">
				<h2>Extrato</h2>
			</div>
		<div class="grid_16">
			<table>
				<thead>
					<tr>
						<th>Número da conta</th>
						<th>Cpf do responsável</th>
						<th>Valor</th>
						<th>Operação</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${extratos}" var="extrato">
						<tr>
							<td>${extrato.idConta}</td>
							<td>${extrato.cpfResponsavel}</td>
							<td>${extrato.valor}</td>
							<td>${extrato.operacao}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>	
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/960.css" type="text/css" media="screen"
	charset="utf-8" />
<link rel="stylesheet" href="css/template.css" type="text/css"
	media="screen" charset="utf-8" />
<link rel="stylesheet" href="css/colour.css" type="text/css"
	media="screen" charset="utf-8" />
<title>Criar Conta</title>
</head>
<body>
<h1 id="head">Dados Bancários</h1>
	<ul id="navigation">
		<li><a href="#"> 
			<form method="Post" action="HomeServlet">
				<input type="submit" value="Home">
			</form> </a></li>
		<li><span class="active">
			<form method="Post" action="CriarContaServlet">
				<input type="hidden" value="criarConta" name="action"> 
				<input type="submit" value="Criar Conta">
			</form> 
			</span>
		</li>
		<li><a href="#">
			<form method="Post" action="EntrarContaServlet">
				<input type="submit" value="Entrar">
			</form> 
			</a>
		</li>
	</ul>

	<div id="content" class="container_16 clearfix">
		<div class="grid_11">
			<h2>Criação de conta</h2>
			 <form method="Post" action="CriarContaServlet">
				Cpf: <input type="text" name="cpf">
				<c:if test="${not empty message}">
					<p style="font-weight: normal; color: red;">${message}</p>	
				</c:if><br /> 
				Nome: <input type="text" name="nome" placeholder="Anderson"> 
				<c:if test="${not empty message}">
					<p style="font-weight: normal; color: red;">${message}</p>	
				</c:if>
				<br /> 
				<input type="submit" value="Salvar">
			</form>
		</div>
	</div>
</body>
</html>
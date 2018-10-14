<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title> Home   </title>
		<link rel="stylesheet" href="css/960.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/template.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/colour.css" type="text/css" media="screen" charset="utf-8" />
	</head>	
	<body>		
	<h1 id="head">Dados Bancários</h1>
	<ul id="navigation">
		<li><span class="active">Home</span></li>
		<li><a href="#"><form method="Post" action="CriarContaServlet">		
			<input type="hidden" value="criarConta" name="action">	
			<input type="submit" value="Criar Conta">
		</form>	</a></li>
		<li><a href="#"><form method="Post" action="EntrarContaServlet">			
			<input type="submit" value="Entrar">
		</form>	</a></li>
	</ul>
		<div id="content" class="container_16 clearfix">
		<div class="grid_11">
			<h2>Dados Bancários</h2>
			Nesta aplicação será possível criar contas, inserir e remover saldo e listar o extrato bancário.			
		</div>
	</div>
		
	</body>	
</html>
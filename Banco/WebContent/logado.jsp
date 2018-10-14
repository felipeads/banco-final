<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
	<script src="js/maskMoney.js" type="text/javascript"></script>
  	<link rel="stylesheet" href="css/960.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/template.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/colour.css" type="text/css" media="screen" charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title> Conat   </title>
		
		<script type="text/javascript">
		$(document).ready(function(){
            $("input.dinheiro").maskMoney({showSymbol:true, symbol:"R$", decimal:",", thousands:".", allowNegative: true});
      });
		</script>
	</head>	
	<body>		
	<h1 id="head">Dados Bancários</h1>
	<ul id="navigation">
		<li><a href="#"> 
			<form method="Post" action="HomeServlet">
				<input type="submit" value="Home">
			</form> </a></li>
		<li><a href="#">
			<form method="Post" action="CriarContaServlet">
				<input type="hidden" value="criarConta" name="action"> 
				<input type="submit" value="Criar Conta">
			</form> 
			</a>
		</li>
		<li><span class="active">
				Conta
			</span>
		</li>
		<li><a href="#">
			<form method="Post" action="ExtratoServlet">
				<input type="submit" value=" Ver Extrato">
			</form> 
			</a>
		</li>
	</ul>
		<div id="content" class="container_16 clearfix">
			<div class="grid_11">
				<h2>Operação</h2>
				<p>${nome}</p>
				<form method="Post" action="OperacaoServlet">	
					 informe deposito ou saque: <input type="text" name="valor" id="valor" class="dinheiro" maxlength="8">
					<c:if test="${not empty message}">
						<p style="font-weight: normal; color: red;">${message}</p>	
					</c:if>
					<input type="submit" value="Executar Operação">
					
				</form>
			</div>
		</div>	
		
		
		
	</body>	
</html>
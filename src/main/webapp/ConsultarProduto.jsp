<%@page import="mercado.model.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/Mercado.css">

<meta charset="UTF-8">
<title>RioCenter</title>
</head>
<body>
	<nav class="mercadoNav">
		<ul>
			<li><span style="color: white">RioCenter</span></li>
			<li><a href="CadastrarProduto.jsp">Cadastrar Produto</a></li>
			<li><a href="ConsultarProduto.jsp">Consultar Produto</a></li>
		</ul>
	</nav>
	<main class="mercadoMain">
	<div class="mercadoForm">
		<form action="ConsultarProduto" method="post" class="mercadoForm">
			<div>
				<label><strong>Busca pela Descrição:</strong></label><input type="text"
					name="descricao">
			</div>
			<br>
			<div>
				<input id="mercadoButton" type="submit" name="salvar"
					value="Consultar Produto">
			</div>
			<div>
			<%
			String mensagem = (String) request.getAttribute("mensagem");
			if(mensagem!=null)
				out.print(mensagem);
			%>
			</div>
		</form>
			<%if(request.getAttribute("produtos") != null) {
			List<?> produtos = (List<?>) request.getAttribute("produtos");
			for(int contador = 0; contador <=(produtos.size()-1); contador++){
				Produto produto = (Produto) produtos.get(contador);%>
			
	<form action="modificarProduto" method="post">
      <div class="mercadoDivMother"> 
		<div class="mercadoDivItem">
			<div class="mercadoColumn">
				<span style="font-weight: bold">Id</span> 
				<span><%out.print(produto.getIdProduto());%></span>
				<input type="hidden" name="id" value="<%out.print(produto.getIdProduto());%>">
			</div>
			<div class="mercadoColumn">
				<span style="font-weight: bold">Descricao</span>
				<span><%out.print(produto.getDescricao());%></span>
			</div>
			<div class="mercadoColumn">
				<span style="font-weight: bold">Quantidade</span> 
				<span><%out.print(produto.getQuantidade());%></span>
			</div>
			<div class="mercadoColumn">
				<span style="font-weight: bold">Preço</span>
				<span><%out.print(produto.getPreco());%></span>
			</div>
			<div class="mercadoColumn">
				<span style="font-weight: bold">Disponível</span>
				<span><%out.print(produto.isOnline());%></span>
			</div>
			<div class="mercadoColumn">
			<input id="mercadoItemButton" type="submit" name="alterar" value="Alterar">
			<input id="mercadoItemButton" type="submit" name="excluir" value="Excluir">
			</div>
		</div>
	</div>
</form>
	<%
	}
	}
	%>
	
	</div>
	</main>
</body>
</html>
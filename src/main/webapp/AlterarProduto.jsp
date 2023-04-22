<%@page import="mercado.model.Produto"%>
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
 <form action="AlterarProduto" method="post" class="mercadoForm">
 			<%
 			Produto produto = null;
 			if (request.getAttribute("produto") != null) {
 				produto = (Produto) request.getAttribute("produto");
 			}
 			%>
 			<input type="hidden" name="id" value="<%out.print(produto.getIdProduto());%>">
 			
			<div>
				<label><strong>Descrição:</strong></label><input type="text"
					name="descricao" value="<%out.print(produto.getDescricao());%>">
			</div>
			<div>
				<label><strong>Quantidade:</strong></label><input type="number"
					name="quantidade" value="<%out.print(produto.getQuantidade());%>">
			</div>
			<div>
				<label><strong>Preço:</strong></label><input type="number"
					step="any" name="preco" value="<%out.print(produto.getPreco());%>">
			</div>

			<label><strong>Disponível On-Line:</strong></label><input
				type="checkbox" name="online" value="<%if(produto.isOnline()) {
					out.print("checked");
				}%>">
			<br>
			<div>
				<input id="mercadoButton" type="submit" name="alterar"
					value="Aterar Produto">
			</div>
			<div>
			<input type="hidden" name="id">
			</div>
			
			<div>
			<%
			String mensagem = (String) request.getAttribute("mensagem");
			if(mensagem!=null)
				out.print(mensagem);
			%>
			</div>
		</form>
 
 
 </main>
</body>
</html>
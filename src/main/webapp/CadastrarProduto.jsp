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
 <form action="CadastrarProduto" method="post" class="mercadoForm">
			<div>
				<label><strong>Descrição:</strong></label><input type="text"
					name="descricao">
			</div>
			<div>
				<label><strong>Quantidade:</strong></label><input type="number"
					name="quantidade">
			</div>
			<div>
				<label><strong>Preço:</strong></label><input type="number"
					step="any" name="preco">
			</div>

			<label><strong>Disponível On-Line:</strong></label><input
				type="checkbox" name="online">
			<br>
			<div>
				<input id="mercadoButton" type="submit" name="salvar"
					value="Cadastrar Produto">
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
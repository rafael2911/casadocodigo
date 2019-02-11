<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produto - Casa do Código</title>
</head>
<body>
	<h1>Lista de produtos</h1>
	<h3>Produto cadastrado com sucesso!!!</h3>
	<br><br>
	<table>
		<thead>
			<tr>
				<td>Id</td>
				<td>Título</td>
				<td>Páginas</td>
				<td>Ações</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="produto" items="${ produtos }">
				<tr>
					<td>${produto.id }</td>
					<td>${produto.titulo }</td>
					<td>${produto.descricao }</td>
					<td>${produto.paginas }</td>
					<td>
						<a href="editar/${produto.id }">Editar</a>
						<a href="#">Apagar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
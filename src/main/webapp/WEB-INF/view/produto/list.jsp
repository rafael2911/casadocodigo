<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produto - Casa do Código</title>
</head>
<body>
	<h1>Lista de produtos</h1>
	<h3>${message }</h3>
	<br><br>
	<table>
		<thead>
			<tr>
				<td>Id</td>
				<td>Título</td>
				<td>Descrição</td>
				<td>Páginas</td>
				<td>Publicação</td>
				<td>Status</td>
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
						<!-- Converte a variável de LocalDate para Date (não seria necessário se o atributo dataPublicacao fosse Date ou Calendar) -->
						<fmt:parseDate var="data" value="${produto.dataPublicacao }" pattern="yyyy-MM-dd" type="date" />
						<!-- Formata a exibição da data -->
						<fmt:formatDate value="${data }" pattern="dd/MM/yyyy" type="date"/>
						
					</td>
					<td>${produto.status.desc }</td>
					<td>
						<a href="editar/${produto.id }">Editar</a>
						<a href="remover/${produto.id }">Apagar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
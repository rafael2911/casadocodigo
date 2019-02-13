<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produto - Casa do Código</title>
</head>
<body>
	<spring:url value="/produto/salvar" var="salvar" />
	<form:form modelAttribute="produto" action="${salvar }" method="post">
		<form:hidden path="id"/>
		<div>
			<label>Título</label>
			<form:input path="titulo"/>
		</div>
		<div>
			<label>Descrição</label>
			<form:textarea path="descricao" cols="20" rows="5"/>
		</div>
		<div>
			<label>N. Páginas</label>
			<form:input path="paginas"/>
		</div>
		<div>
			<label>Data de Publicação</label>
			<form:input path="dataPublicacao" type="date" />
		</div>
		<div>
			<label>Status</label>
			<form:select path="status">
				<form:options items="${listStatus }" itemLabel="desc" />
			</form:select>
		</div>
		<button type="submit">Salvar</button>
	</form:form>
</body>
</html>
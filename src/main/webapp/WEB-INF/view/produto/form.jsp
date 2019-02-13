<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<spring:url var="css" value="/static/bootstrap_3_7/css/bootstrap.min.css" />
<link rel="stylesheet" href="${css }">
<title>Produto - Casa do Código</title>
</head>
<body>
	<div class="container">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<spring:url value="/produto/salvar" var="salvar" />
			<form:form modelAttribute="produto" action="${salvar }" method="post">
				<form:hidden path="id" />
				<div class="form-group">
					<label>Título</label>
					<form:input path="titulo" cssClass="form-control" />
				</div>
				<div class="form-group">
					<label>Descrição</label>
					<form:textarea path="descricao" cols="20" rows="5"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<label>N. Páginas</label>
					<form:input path="paginas" cssClass="form-control" />
				</div>
				<div class="form-group">
					<label>Data de Publicação</label>
					<form:input path="dataPublicacao" type="date"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<label>Status</label>
					<form:select path="status" cssClass="form-control">
						<form:options items="${listStatus }" itemLabel="desc" />
					</form:select>
				</div>
				<button type="submit" class="btn btn-primary">Salvar</button>
			</form:form>
		</div>
		<div class="col-md-3"></div>
	</div>
</body>
</html>
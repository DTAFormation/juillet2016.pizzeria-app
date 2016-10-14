<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Page Mes Stocks" name="title" />
</jsp:include>

<body class="container">
	<jsp:include page="../layout/menu.jsp">
		<jsp:param value="Stocks" name="page" />
	</jsp:include>

	<div class="row">
		<c:if test="${msg != null}">
			<div class="alert alert-danger" role="alert">${msg}</div>
		</c:if>
		<c:if test="${msg_success != null}">
			<div class="alert alert-success" role="alert">${msg_success}</div>
		</c:if>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<h1>Liste des Stocks</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-4">
			<a class="btn btn-success"
				href="">Nouvel
				ingrédient</a>
		</div>
		
	</div>

	<br>

	<table class="table">
		<tr>
			<th>Id</th>
			<th>Code</th>
			<th>Nom</th>
			<th>Quantité</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="ingredient" items="${listeIngredients}">
				<c:if test="${ingredient.actif}">
					<tr>
						<td>${ingredient.id}</td>
						<td>${ingredient.code}</td>
						<td>${ingredient.nom}</td>
						<td>${ingredient.quantite}</td>
						<td>
							<div class="btn-group">
								<a href="<c:url value="/ingredients/edit?code=${ingredient.code}"/>" class="btn btn-primary">Éditer</a>
								<form method="POST" class="btn-group">
									<input type="hidden" name="code" value="${ingredient.code}">
									<input type="hidden" name="action" value="toggle">
									<button type="submit" class="btn btn-warning">Désactiver</button>
								</form>
							</div>
						</td>
					</tr>
				</c:if>
			</c:forEach>
	</table>
</body>
</html>
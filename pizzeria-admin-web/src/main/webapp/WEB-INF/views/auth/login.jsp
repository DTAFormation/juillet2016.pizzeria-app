<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Page Editer Pizza" name="title" />
</jsp:include>

<body class="container">
	<div style="text-align: center;" id="logo">
		<img alt="logo" src="static/images/logo-pizzeria.png">
	</div>
	<c:if test="${msgErreur != null}">
	<!-- Large modal -->
	<!-- 	<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Large modal</button> -->
	<div id="my-modal" style="display:block" class="modal fade in">
		    <div class="modal-dialog"> 
 		        <div class="modal-content"> 
 		            <div class="modal-header"> 
 		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> 
 		                <h4 class="modal-title">Title</h4> 
 		            </div> 
 		            <div class="modal-body"> 
		                 ${msgErreur}
 		            </div> 
 		        </div> 
 		    </div> 
 		</div> 
	</c:if>
	<h1>Connexion</h1>
	<form method="POST">
		<div class="form-group">
			<label for="email">Email :</label>
			<input type="email" class="form-control" id="email" name="email">
		</div>

		<div class="form-group">
			<label for="motDePasse">Mot de passe :</label>
			<input type="password" class="form-control" name="motDePasse" id="motDePasse" value="">
		</div>
		<button type="submit" class="btn btn-primary">Se connecter</button>
	</form>
</body>
</html>
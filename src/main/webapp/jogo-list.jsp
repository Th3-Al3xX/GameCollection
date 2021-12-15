<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Gerenciamento de Jogos WEB</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Gerenciamento de Jogos WEB </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Jogos</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Jogos Pessoais</h3>
			<hr>
			<div class="container text-left">

				<a style="font-size:15px;" href="<%=request.getContextPath()%>/new" class="btn btn-success">Adicionar
					Novo Jogo</a>
			</div>
			<br>
			<table class="table table-sm">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Desenvolvedor</th>
						<th>Categoria</th>
						<th>Plataforma</th>
						<th><center>Ações</center></th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="collection" items="${listJogo}">

						<tr>
							<td><c:out value="${collection.id}" /></td>
							<td><c:out value="${collection.nome}" /></td>
							<td><c:out value="${collection.desenv}" /></td>
							<td><c:out value="${collection.estilo}" /></td>
							<td><c:out value="${collection.plataforma}" /></td>
							<td style="text-align: center; width: 200px;">
								<a href="edit?id=<c:out value='${collection.id}' />"><img src="resources/images/button-edit.png"  title="Editar" /></a>
								&nbsp;&nbsp;&nbsp;&nbsp;									  
								<a href="delete?id=<c:out value='${collection.id}' />"><img src="resources/images/button-trash.png" title="Excluir" /></a>
							</td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
			<center style="font-size: 10px; font-color: red;"> Alexsandro de Souza Eusebio </center>
		</div>
	</div>
</body>
</html>

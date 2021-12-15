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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${collection != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${collection == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${collection != null}">
                                    Editar Jogo
                                </c:if>
						<c:if test="${collection == null}">
                                    Adicionar Novo Jogo
                                </c:if>
					</h2>
				</caption>

				<c:if test="${collection != null}">
					<input type="hidden" name="id"
						value="<c:out value='${collection.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nome do Jogo</label> <input type="text"
						value="<c:out value='${collection.nome}' />" class="form-control"
						name="nome" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Desenvolvedor</label> <input type="text"
						value="<c:out value='${collection.desenv}' />"
						class="form-control" name="desenv">
				</fieldset>

				<fieldset class="form-group">
					<label>Categoria</label> <input type="text"
						value="<c:out value='${collection.estilo}' />"
						class="form-control" name="estilo" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Plataforma</label> <input type="text"
						value="<c:out value='${collection.plataforma}' />"
						class="form-control" name="plataforma" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Salvar</button>
				<button type="button" class="btn btn-danger"
					onClick="history.go(-1)">Cancelar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/materialize.min.css"/>"
	type="text/css" rel="stylesheet" media="screen,projection">
<link href="<c:url value="/resources/css/style.css"/>"
	type="text/css" rel="stylesheet" media="screen,projection"/>
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="col s8 offset-s2 m6 offset-m3 l6 offset-l3">
			<jsp:include page="Nav.jsp" />
			<form class="col s12" action="/todolist-presentation/create" method="POST">
				<div class="row">
        			<div class="input-field col s12 m4">
						<input type="text" name="taskName" id="taskName">
						<label for="taskName" data-error="Veuillez saisir un nom">Nom</label>
					</div>
	       			<div class="input-field col s12 m4">				
						<input type="text" name="taskBeginDate" id="taskBeginDate" class="datepicker">
						<label for="taskBeginDate" data-error="Choisissez une date">Date de départ</label>
					</div>
	       			<div class="input-field col s12 m4">				
						<select name="status">
							<c:forEach items="${status}" var="statut">
					     		<option value="${statut.id}">${statut.name}</option>
						 	</c:forEach>
						</select>
					</div>
					<button class="btn right red lighten-2" type="submit" name="action"> Créer
					    <i class="material-icons right">library_add</i>
				  	</button>
			  	</div>
			</form>
		</div>
	</div>

	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/materialize.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
</body>
</html>
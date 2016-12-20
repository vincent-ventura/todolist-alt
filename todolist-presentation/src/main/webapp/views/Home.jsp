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
<title>Todolist</title>
</head>
<body>
	<div class="container">
		<div class="col s8 offset-s2 m6 offset-m3 l6 offset-l3">
			<jsp:include page="Nav.jsp" />
		  	<table class="centered bordered highlight">
		  		<!--<thead>
		  			<tr>
		  				<th>Nom</th>
		  				<th>Statut</th>
		  				<th>Terminée ?</th>
		  			</tr>
		  		</thead>-->
			  		<tbody>
					<c:forEach items="${tasks}" var="task">
						<tr>
							<td>
								${task.name}
							</td>
							<td>
								${task.status.name}
							</td>
							<td>
								<c:choose>
								   <c:when test="${task.status.name == finishedTaskStatusName}"><i class="material-icons terminate">done</i></c:when>
								   <c:when test="${task.beginDate gt oneWeekAgoDate}"><a class="btn disabled">Terminate</a></c:when>
								   <c:otherwise><a href="terminate/${task.id}" class="waves-effect waves-light btn red lighten-2">Terminate</a></c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		   	</table>
	   	</div>
   	</div>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/materialize.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/materialize-pagination.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>NHNjj</title>
</head>
<script>
	var newSex = function(id){
		console.log(id);
		alert(id);
	};
</script>
<body>
	NHN Ent :
	<form method="post"
		action="http://localhost:8080/web/newArticle/submit">
		<input type="hidden" name="parentId" value="0" /> email : <input
			type="text" name="email" /><br /> password : <input type="text"
			name="password" /><br /> contents: <input type="text" name="title" /><br />
		<br /> <input type="submit" /> <br> <br>

		<%-- <%!int i = 1;%> --%> 
		<c:forEach var="listv" items="${list}">
			<tr>
				<td>${listv.num}</td>
				<td>${listv.email}</td>
				<td>${listv.contents}</td>
			</tr>

			<div id="${listv.num}" value="${listv.num}" onclick=" newSex( " + this.value + ")">modify</div>
			<p>
			<%-- <% i++; %> --%>
		</c:forEach>
 
	</form>
</html>


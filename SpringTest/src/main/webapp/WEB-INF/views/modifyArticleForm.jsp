<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>NHNjj</title>
</head>
<body>
	NHN Ent Guestbook Modify Form
	<form method="post"
		action="http://localhost:8080/web/newArticle/modifyArticle">
		<input type="hidden" name="parentId" value="0" /> 
		email : <input type="text" name="email" /><br /> password : <input type="text"
			name="password" /><br /> contents: <input type="text" name="title" /><br />
		<br /> <input type="submit" /> <br> <br>
 
	</form>
</html>


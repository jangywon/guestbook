<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시글 쓰기</title>
</head>
<body>
NHN Ent 방명록:
<form method="post">
	<input type="hidden" name="parentId" value="0" />
	이메일 : <input type = "text" name = "email"/><br/>
	비밀번호 : <input type = "text" name = "password"/><br/>
	제목: <input type="text" name="title" /><br/>
	내용: <textarea name="content"></textarea><br/>
	<input type="submit" />
</form>
</body>
</html>

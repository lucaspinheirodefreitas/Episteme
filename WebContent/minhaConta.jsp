<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="Usuario" type="br.com.episteme.model.Usuario" scope="session"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Bem vindo, ${Usuario.nome}</h1>
</body>
</html>
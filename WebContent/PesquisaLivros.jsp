<jsp:useBean id="listaLivros" class="br.com.episteme.controller.PesquisaServlet" type="java.util.ArrayList" scope="page"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<c:forEach items="${listaLivros}" var="listaLivros">
			<tr>
				<td>${listaLivros.nome}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
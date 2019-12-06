<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<jsp:useBean id="campo" class="java.lang.String" scope="session"></jsp:useBean>
<jsp:useBean id="usuario" class="br.com.episteme.model.Usuario" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  <title></title>


  <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>

  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
        <i class="material-icons">
          account_box
        </i>
        <form role="form" action="atualizarcampo" method="post">

          <div class="form-group">

            <label for="inputName">
                ${campo}
            </label>
            <input type="text" class="form-control" id="inputAtualiza" name="campoatt" />
          </div>

          <button type="submit" class="btn btn-primary">
            Salvar
          </button>

          
        </form>
		<a href="./minha-conta.jsp">  Voltar </a>
      </div>
     </div>
   </div>
</body>
</html>

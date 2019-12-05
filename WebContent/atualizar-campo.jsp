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

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

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

   <!--SCRIPTS BOOTSTRAP-->
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<jsp:useBean id="atualizarUsuario" class="br.com.episteme.controller.AtualizarUsuarioServlet" scope="session"></jsp:useBean>
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

  <script type="text/javascript">
            function buscaEndereco() {
                var cep = document.getElementById("cep").value;
                var xmlhttp = new XMLHttpRequest();
                var url = "http://cep.republicavirtual.com.br/web_cep.php?cep="+  cep + "&formato=json";
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.status === 200) {
                        if (xmlhttp.readyState === 4) {
                            var endereco = JSON.parse(xmlhttp.responseText);
                            if (endereco.resultado == "1") {
                                document.getElementById("tipo").value = endereco.tipo_logradouro;
                                document.getElementById("logradouro").value = endereco.logradouro;
                                document.getElementById("bairro").value = endereco.bairro;
                                document.getElementById("cidade").value = endereco.cidade;
                                document.getElementById("estado").value = endereco.uf;
                            } else {
                                alert("Endereco nao encontrado pelo CEP informado");
                            }
                        }
                    }
                };
                xmlhttp.open("GET", url, true);
                xmlhttp.send();

            }
  </script>
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
        <i class="material-icons">
          account_box
        </i>
        <form role="form">

          <div class="form-group">

            <label for="inputName">
                Nome
            </label>
            <input type="text" class="form-control" id="inputName" placeholder="${atualizarUsuario.getNome()}" />
          </div>

          <div class="form-group">

            <label for="inputEmail1">
                Email
            </label>
            <input type="email" class="form-control" id="inputEmail1" placeholder="${atualizarUsuario.getEmail()}" />
          </div>
          <div class="form-group">

            <label for="inputPassword1">
                Senha
            </label>
            <input type="password" class="form-control" id="inputPassword1"  placeholder="${atualizarUsuario.getEmail()}"/>
          </div>

          <div class="form-group">

            <label for="inputPassword1">
              Confirme a nova Senha
            </label>
            <input type="password" class="form-control" id="inputPasswordCheck" />
          </div>

          <div class="form-group">
              <label for="cep">
                    Digite o novo CEP
              </label>
              <input type="text" class="form-control" id="cep" name="txtCep" onblur="buscaEndereco();"/>
          </div>

          <div class="form-group">
                            <label for="tipo">
                                Tipo do Logradouro
                            </label>
                            <input type="text" class="form-control" id="tipo" name="txtTipo" />
                        </div>
                        <div class="form-group">
                            <label for="logradouro">
                                Logradouro
                            </label>
                            <input type="text" class="form-control" id="logradouro" name="txtLogradouro" />
                        </div>
                        <div class="form-group">
                            <label for="numero">
                                Numero
                            </label>
                            <input type="text" class="form-control" id="numero" name="txtNumero" />
                        </div>
                        <div class="form-group">
                            <label for="complemento">
                                Complemento
                            </label>
                            <input type="text" class="form-control" id="complemento" name="txtComplemento" />
                        </div>
                        <div class="form-group">
                            <label for="bairro">
                                Bairro
                            </label>
                            <input type="text" class="form-control" id="bairro" name="txtBairro" />
                        </div>
                        <div class="form-group">
                            <label for="cidade">
                                Cidade
                            </label>
                            <input type="text"   class="form-control" id="cidade" name="txtCidade" />
                        </div>
                        <div class="form-group">
                            <label for="estado">
                                Estado
                            </label>
                            <input type="text" class="form-control" id="estado" name="txtEstado" />
                        </div>

          <button type="submit" class="btn btn-primary">
            Cadastrar
          </button>

          <button type="submit" class="btn btn-secondary">
            Voltar
          </button>
        </form>

      </div>
     </div>
   </div>
</body>
</html>

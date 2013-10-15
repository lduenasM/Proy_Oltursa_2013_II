<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>OLTURSA</title>
<link rel="stylesheet" href="css/jquery.superbox.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/estilosFormularios.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/styles.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/estilos.css" type="text/css" media="all" />
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.23/themes/base/jquery.ui.all.css">
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript">
$(function(){

	$('#btn_ingresar').click(function() { 
		var formParams= $("#form1").serialize();
		
		$.ajax({
			type: "POST",
			url: "login",
			data: formParams,
			success: function(response) {
				var respuesta = jQuery.parseJSON(response);
				if(respuesta.codigo=="0"){
					ingresar();		
				}else{
					alert(respuesta.mensaje);
				}
			},
			error: function(e) {
				alert("Error "+e);
			}
		});
	});
});

ingresar = function(){
	document.forms[0].txt_accion.value="ingresar";
	document.forms[0].submit();
}

</script>

</head>
<body>
<!--   
	CUERPO CENTRAL
 -->
<div class="cuerpo">
<!--
	HEADER
-->
<!--
	FIN HEADER
-->
<!--
	CONTENIDO
-->
    <div class="contenido">
        <table width="100%" height="100%" border="2" cellspacing="0" cellpadding="0" align="center">
          <tr valign="middle">
            	
            <td valign="middle" align="center" class="imagenredonda">
            <div>
            &nbsp;
            </div>
            
            <!-- CONTENIDO DERECHO--> 
            <table width="300" border="0" cellspacing="0" cellpadding="0" align="center">
          	<tr>            	
            <td valign="top" align="center">
            	<div class="datos">
    		  <form action="login" method="post" name="form1" class="imput" id="form1">
						  <input type="hidden" name="txt_accion" id="txt_accion" value="validar"/>			 
              	<table width="300" border="0" cellspacing="2" cellpadding="2" class="textoForm" align="center">
                  <tr height="10">
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <td colspan="3" class="tituloForm" align="center">INGRESO</td>
                  </tr>
                  <tr>
                    <td align="right">Usuario</td>
                    <td>:</td>
                    <td align="left"><input name="txt_user" type="text" class="imput" id="txt_user" size="20" maxlength="20" placeholder="Ingrese su usuario"></td>
                  </tr>
                  <tr>
                    <td align="right" class="nombre">Clave</td>
                    <td>:</td>
                    <td align="left"><input name="txt_pass" type="password" class="imput" id="txt_pass" value="" size="20" maxlength="20" placeholder="Ingrese su clave"></td>
                  </tr>
                  <tr>
                    <td colspan="3" align="center" height="50"><input name="btn_ingresar" type="button" class="tituloForm" id="btn_ingresar" value="Ingresar" placeholder="Ingrese su Clave"></td>
                    </tr>                 
                </table>
              </form>
          </div>
                
            </td>
          </tr>
        </table>
            <!-- FIN CONTENIDO DERECHO-->
        
            </td>
          </tr>
        </table>
    </div>
<!--
	FIN CONTENIDO
-->
<!--
	PIE DE PAGINA
-->
<%@ include file="intFooter.jsp" %>  
<!--
	FIN PIE DE PAGINA
-->
</div>
<!--   
	FIN CUERPO CENTRAL
 -->
</body>
</html>
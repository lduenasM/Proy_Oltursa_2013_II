<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.*" %>
<% UsuarioInterno usua=(UsuarioInterno)session.getAttribute("usuario"); 
if(usua==null){
	response.sendRedirect("intLogin.jsp");
}else{ 
%>
<link href="../../css/estilosFormularios.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="../../css/validationEngine/validationEngine.jquery.css" type="text/css"/>    
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="../../js/validationEngine/languages/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/validationEngine/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>     
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.0/themes/base/jquery-ui.css">

<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.0/jquery-ui.min.js"></script>
<script>
		jQuery(document).ready(function(){
			// binds form submission and fields to the validation engine
			jQuery("#formID").validationEngine();
		});
		function checkHELLO(field, rules, i, options){
			if (field.val() != "HELLO") {
				// this allows to use i18 for the error msgs
				return options.allrules.validate2fields.alertText;
			}
		}
	</script>
<!--BUSCAR-->
<div class="datos">
    		  <form id="formID" name="formID" method="post" action="../../manusuarioint" class="form" target="_top">
    		  <!-- <form id="formID" class="formular" method="post" action="../manusuario" target="_top"> -->
              <input name="txt_accion" type="hidden" id="txt_accion" value="consultaCriterio">
              	<table width="300" border="0" cellspacing="2" cellpadding="2" class="textoForm" align="center">
                  <tr height="10">
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <td colspan="3" class="tituloForm" align="center">BUSCAR</td>
                  </tr>
                  <tr>
                    <td align="right">Codigo</td>
                    <td>:</td>
                    <td><input name="txt_id" type="text" class="validate[required] text-input" id="txt_id" placeholder="Codigo" size="10"></td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><input name="button" type="submit" class="tituloForm" id="button" value="BUSCAR"></td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td colspan="3" align="center" class="tituloForm"><a href="../../manusuarioint" target="_parent">Listar a todos</a></td>
                  </tr>
                </table>
              </form>
          </div>     
          <%      
			}
			%>
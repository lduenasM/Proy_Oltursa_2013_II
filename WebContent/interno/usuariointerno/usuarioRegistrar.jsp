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

		/**
		*
		* @param {jqObject} the field where the validation applies
		* @param {Array[String]} validation rules for this field
		* @param {int} rule index
		* @param {Map} form options
		* @return an error string if validation failed
		*/
		function checkHELLO(field, rules, i, options){
			if (field.val() != "HELLO") {
				// this allows to use i18 for the error msgs
				return options.allrules.validate2fields.alertText;
			}
		}
	</script>

   
<!--REGISTRAR-->
          <div class="datos">
              <form id="formID" class="formular" method="post" action="../../manusuarioint" target="_top">
              <input name="txt_accion" type="hidden" id="txt_accion" value="registrar">
              	<table width="350" border="0" cellspacing="2" cellpadding="2" align="center" class="textoForm">
                  <tr height="10">
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr valign="">
                    <td colspan="3" align="center" class="tituloForm">REGISTRAR</td>
                  </tr>
                  <tr>
                    <td align="right">Nombre</td>
                    <td>:</td>
                    <td>
                    <input value="" class="validate[required] text-input" type="text" name="txt_nombre" id="imputForm" placeholder="Nombre" size="15"/>
                    </td>
                  </tr>
                  <tr>
                    <td align="right">Usuario</td>
                    <td>:</td>
                    <td>
                    <input value="" class="validate[required] text-input" type="text" name="txt_user" id="imputForm" placeholder="Usuario" size="15"/></td>
                  </tr>
                  <tr>
                    <td align="right">Contrase&ntilde;a</td>
                    <td>:</td>
                    <td>
                    <input value="" class="validate[required] text-input" type="password" name="txt_password" id="password" placeholder="Contrase&ntilde;a" size="15"/>
                    </td>
                  </tr>
                  <tr>
                    <td align="right">Confirmar<br>
                    Contrase&ntilde;a</td>
                    <td>:</td>
                    <td>
                    <input value="" class="validate[required,equals[password]]" type="password" name="txt_password2" id="password" placeholder="Repetir Contrase&ntilde;a" size="15"/>
                    </td>
                  </tr>
                  <tr>
                    <td align="right">Estado</td>
                    <td>:</td>
                    <td>
                    <label><input name="rbn_estado" type="radio" class="imputForm" id="rbn_estado_0" value="1" checked>Activado</label>
                 	 <br>
                  	<label><input name="rbn_estado" type="radio" class="imputForm" id="rbn_estado_1" value="0">Desactivado</label>
					</td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><input name="button" type="submit" class="tituloForm"  id="button" value="REGISTRAR"></td>
                  </tr>
                </table>
              </form>
          </div>
            
<%} %>
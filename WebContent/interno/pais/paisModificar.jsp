<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.*" %>
<% UsuarioInterno usua=(UsuarioInterno)session.getAttribute("usuario"); 
if(usua==null){
	response.sendRedirect("../../intLogin.jsp");
}else{ 
%>
<link href="css/estilosFormularios.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/validationEngine/validationEngine.jquery.css" type="text/css"/>    
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="js/validationEngine/languages/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8"></script>
<script src="js/validationEngine/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>     
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

   
<!--MODIFICAR-->
          <div class="datos">
    		  <%Pais dato = (Pais)request.getAttribute("pais"); %>
              <form id="formID" class="formular" method="post" action="manpais" target="_top">
              <input name="txt_accion" type="hidden" id="txt_accion" value="actualizar">
              	<table width="350" border="0" cellspacing="2" cellpadding="2" align="center" class="textoForm">
                  <tr height="10">
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <td colspan="3" class="tituloForm" align="center">MODIFICAR</td>
                  </tr>
                  <tr>
                    <td align="right">Codigo</td>
                    <td>:</td>
                    <td><input name="txt_ids" type="text" disabled class="imputForm" id="txt_ids" value="<%=dato.getCod_pais()%>" size="15"></td>
                  </tr>
                  <tr>
                    <td align="right">Nombre</td>
                    <td>:</td>
                    <td>
                    <input value="<%=dato.getNom_pais()%>" class="validate[required] text-input" type="text" name="txt_nombre" id="imputForm" placeholder="Nombre" size="15"/>
                    </td>
                  </tr>
                  <tr>
                    <td align="right">Estado</td>
                    <td>:</td>
                    <td>
                    <label><input name="rbn_estado" type="radio" class="imputForm" id="rbn_estado_0" value="1" <%="1".equals(dato.getEst_pais()) ?"checked":""%>>Activado</label>
                 	 <br>
                  	<label><input name="rbn_estado" type="radio" class="imputForm" id="rbn_estado_1" value="2" <%="2".equals(dato.getEst_pais()) ?"checked":""%>>Desactivado</label>
					</td>
                  </tr>
                  <tr>
                    <td>&nbsp;<input name="txt_id" type="hidden" id="txt_id" value="<%=dato.getCod_pais()%>"></td>
                    <td>&nbsp;</td>
                    <td><input name="button" type="submit" class="tituloForm" id="button" value="MODIFICAR"></td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                </table>
              </form>
          </div>  
          <% } %>
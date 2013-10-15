<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="bean.*" %>
<% UsuarioInterno usua=(UsuarioInterno)session.getAttribute("usuario"); 
if(usua==null){
	response.sendRedirect("intLogin.jsp");
}else{ 
%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>OLTURSA</title>
<link rel="stylesheet" href="css/jquery.superbox.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/menulat.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/styles.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/estilos.css" type="text/css" media="all" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-min.js"></script>
<script type="text/javascript" src="js/jquery.superbox-min.js"></script>
<script type="text/javascript">
		$(function(){
			$.superbox.settings = {
				closeTxt: "SALIR",
				loadTxt: "Cargando...",
				nextTxt: "Siguiente",
				prevTxt: "Anterior"
			};
			$.superbox();
		});
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
	<header class="header">

    <div class="top">
    <table width="100%" height="100%" border="0" align="center">
      <tr>
        <td width="96%" align="right" class="connect">&nbsp;Bienvenido: <%=usua.getLog_usu()%> 
        </td> 
        <td>
           <nav>
            <ul id="naviTop">
              <li><a href="logout" title="Salir">Desconectar</a></li>
            </ul>
          </nav>
        </td>
      </tr>
    </table>
  </div>
  
</header>
<!--
	FIN HEADER
-->
<!--
	CONTENIDO
-->
    <div class="contenido">
        <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" align="center">
          <tr>
            <td width="200" valign="top">
             <!-- MENU LATERAL-->
             <%@ include file="intMenuLat.jsp" %>   
	         <!-- FIN MENU LATERAL-->
            </td>
            	
            <td valign="top" align="center" class="imagenredonda">
            <div>
            &nbsp;
            </div>
            <!-- CONTENIDO DERECHO-->
            
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

<%}%>
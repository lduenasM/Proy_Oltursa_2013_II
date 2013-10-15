<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="bean.*" %>
<%@ page import="java.util.List"%> 
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
             <%@ include file="../../intMenuLat.jsp" %>   
	         <!-- FIN MENU LATERAL-->
            </td>
            	
            <td valign="top" align="center" class="imagenredonda">
            <div>
            &nbsp;
            </div>
            <!-- CONTENIDO DERECHO-->
                <div class="contenidoDerecho">
                  <!-- CONTENIDO PARA EDITAR -->
                  <div class="opciones" >
                    <nav>
                      <ul id="naviOpciones">
                        <li><a href="interno/usuariointerno/usuarioBuscar.jsp" rel="superbox[iframe][500x160]">Consultar Usuarios </a></li>
                        <li><a href="interno/usuariointerno/usuarioRegistrar.jsp" rel="superbox[iframe][550x250]">Registrar </a></li>
                        <!-- 
                        <li><a href="usuarioModificar.jsp">Modificar</a></li>
                        <li><a href="usuarioEliminar.jsp">Eliminar</a></li>
                        -->
                      </ul>
                    </nav>
                  </div>
                  
                  <div class="cont">
                  <!-- LISTA DE DATOS -->
                  
                  <!--LISTAR CONSULTAR-->
				  <% List<UsuarioInterno> usu = (List<UsuarioInterno>)request.getAttribute("usuarios"); %>  
                    <div id="datos">
                      <form action="#" oninput="range_control_value.value = range_control.valueAsNumber">
                        <!--Tabla de titulo de tabla-->
                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="sortable" height="30">
                          <tr>
                            <td colspan="9" align="center"id="formLog"><strong>LISTA DE DATOS</strong></td>
                          </tr>          
                        </table>                
                        <!--Fin de tabla de titulo-->
                        
                        <!--Tabla que se repetira-->
                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="sortable" id="table">	
                        <!-- Cabecera de tabla -->					
                          <thead>
                            <tr>
                            <strong>
                               <th align="center"><strong>N&deg;</strong></th>
                              <th align="center"><strong>codigo</strong></th>
                              <th align="center"><strong>Nombre</strong></th>
                              <th align="center"><strong>Usuario</strong></th>
                              <th align="center"><strong>Password</strong></th>
                              <th align="center"><strong>Estado</strong></th>
                              <th align="center"><strong>Accion</strong></th>	
                            </strong>					
                            </tr>
                          </thead>
                        <!-- Fin de cabecera de tabla -->	
                                        
                        <!-- Parte que se repite-->
                        <% if(usu!=null && usu.size()>0){ int num=1;
					 for(UsuarioInterno usuario : usu){%>
                          <tr>
                            <td align="center"><%=num%></td>
                          <td align="center"><%=usuario.getCod_per()%></td>
                          <td align="center"><%=usuario.getLog_usu()%></td>
                          <td align="center"><%=usuario.getLog_usu()%></td>
                          <td align="center">*********</td>
							  <%String est=""; 
                          if (usuario.getEst_usu().equals("1")){
                              est="Activado";
                          } else{
                              est="Desactivado";                    	  
                          }%>
                      	  <td align="center"><%=est%></td>
                            <td align="center">
                              <a href="manusuario?txt_accion=editar&txt_id=<%=usuario.getCod_per()%>" class="button" title="Modificar"  rel="superbox[iframe][500x310]"><img src="img/icono/edit.png" width="15" height="15" style="border:none"/></a>
                              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              <a href="manusuario?txt_accion=eliminar&txt_id=<%=usuario.getCod_per()%>" class="button" title="Eliminar"><img src="img/icono/cancel.png" width="15" height="15" style="border:none"/></a>
                            </td>
                          </tr>
                       <% num++;} }else{%>
                          <tr bgcolor="#CCCCCC">
                            <td colspan="7"><div align="center">No existen registros </div></td>
                         </tr>
						<% } %>						        
                        <!-- Parte que se repite-->
                        
                        </table>
                        <!-- Fin de tabla que se repetira-->
                      
                        <!-- Tabla de paginador de tabla -->					
                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                          <tr>
                            <td align="center">
                              <div id="controls" class="aligncenter">
                              
                                <div id="perpage">
                                  <select onChange="sorter.size(this.value)">
                                  <option value="5">5</option>
                                  <option value="10">10</option>
                                  <option value="20" selected="selected">20</option>
                                  <option value="50">50</option>
                                  <option value="100">100</option>
                                  </select> <span>Registros por Pagina</span>
                                </div>
                                
                                <div id="navigation">
                                  <img src="img/first.gif" width="16" height="16" title="Primera Pagina" onClick="sorter.move(-1,true)" /> 
                                  <img src="img/previous.gif" width="16" height="16" title="Pagina Anterior" onClick="sorter.move(-1)" /> 
                                  <img src="img/next.gif" width="16" height="16" title="Siguiente Pagina" onClick="sorter.move(1)" /> 
                                  <img src="img/last.gif" width="16" height="16" title="Ultima Pagina" onClick="sorter.move(1,true)" />
                                </div>
                                
                                <div id="text">
                                  Pagina <span id="currentpage"></span> de <span id="pagelimit"></span>
                                </div>
                              
                              </div>
                              
                              <script type="text/javascript" src="js/script.js"></script>
                              <script type="text/javascript">
                                var sorter = new TINY.table.sorter("sorter");
                                sorter.head = "head";
                                sorter.asc = "asc";
                                sorter.desc = "desc";
                                sorter.even = "evenrow";
                                sorter.odd = "oddrow";
                                sorter.evensel = "evenselected";
                                sorter.oddsel = "oddselected";
                                sorter.paginate = true;
                                sorter.currentid = "currentpage";
                                sorter.limitid = "pagelimit";
                                sorter.init("table", 0);
                              </script>            
                            </td>
                          </tr>						
                          <tr height="5">
                            <td>&nbsp;</td>
                          </tr>
                        </table>
                        <!-- Fin de tabla de paginador de tabla -->
                      </form>                                
                    </div>   
                  
                  <!-- FIN DE LISTA DE DATOS -->  
                  </div> 
                  <!-- FIN  DE CONTENIDO PARA EDITAR -->
                </div>
                            
                            
            
            
            
            
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
<%@ include file="../../intFooter.jsp" %>   
<!--
	FIN PIE DE PAGINA
-->
</div>
<!--   
	FIN CUERPO CENTRAL
 -->
</body>
</html>
<%
} 
%>
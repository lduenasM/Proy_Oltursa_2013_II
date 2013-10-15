
<div class="contenidoDerecho">
  <!-- CONTENIDO PARA EDITAR -->
  <div class="opciones" >
    <nav>
      <ul id="naviOpciones">
        <li><a href="usuarioMantener.jsp">Consultar</a></li>
        <li><a href="usuarioRegistrar.jsp">Registrar</a></li>
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
              <th align="center">N&deg;</th>
              </strong><th align="center">D<strong>ato</strong></th><strong>
              <th align="center">Dato2</th>
              <th align="center">Dato2</th>
              <th align="center">Dato2</th>
              <th align="center">Dato2</th>
              <th align="center">Dato2</th>
              <th align="center">Dato2</th>
              <th align="center">Dato2</th>
              <th align="center" width="100">Acci&oacute;n</th>	
            </strong>					
            </tr>
          </thead>
        <!-- Fin de cabecera de tabla -->	
        				
        <!-- Parte que se repite-->
          <tr>
            <td align="center">1</td>
            <td align="center">0324</td>
            <td align="center">453</td>
            <td align="center">15/05/2013</td>
            <td align="center">18/05/2013</td>
            <td align="center">55</td>
            <td align="center">4</td>
            <td align="center">92</td>
            <td align="center">Usado</td>
            <td align="center">
              <a href="#" class="button" title="Modificar"><img src="img/icono/edit.png" width="15" height="15" style="border:none"/></a>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <a href="#" class="button" title="Eliminar"><img src="img/icono/cancel.png" width="15" height="15" style="border:none"/></a>
            </td>
          </tr>						        
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
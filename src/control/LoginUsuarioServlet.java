package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import dao.DAOFactory;
import dao.Entidad;
import bean.UsuarioInterno;

@WebServlet("/login")
public class LoginUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginUsuarioServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String accion = request.getParameter("txt_accion");
    	if(accion==null || "validar".equals(accion)){
			validarUsuarioInterno(request,response);
		}else{
			ingresarIntranet(request,response);	
		}    	
	}
    private void validarUsuarioInterno(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	UsuarioInterno usuario = new UsuarioInterno();
		usuario.setLog_usu(request.getParameter("txt_user"));
		usuario.setPas_usu(request.getParameter("txt_pass"));		
		DAOFactory factory=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL);
		Entidad<UsuarioInterno> usuarioDAO=factory.getUsuarioInternoDAO();
		UsuarioInterno usuariodb = usuarioDAO.findById(usuario);
		Map<String,String> respuesta= new HashMap<String,String>();
		String mensaje=null;
		if(usuariodb==null){
			mensaje="UsuarioInterno no existe";
			System.out.println("UsuarioInterno NO Existe");
			respuesta.put("codigo", "-1");
		}else{
			if(usuariodb.getPas_usu().toUpperCase().equals(usuario.getPas_usu().toUpperCase())){
				if(usuariodb.getEst_usu().equals("0")){
					System.out.println(usuariodb.getEst_usu());
					System.out.println(usuario.getEst_usu());
					mensaje="UsuarioInterno no Bloqueado";
					System.out.println("UsuarioInterno Bloqueado");
					respuesta.put("codigo", "-1");
				}else{
					HttpSession session=request.getSession(true);
					System.out.println("UsuarioInterno Existe");
					session.setAttribute("usuario", usuariodb);
					respuesta.put("codigo", "0");				
				}
			}else{
				mensaje="Clave Incorrecta";
				respuesta.put("codigo", "-1");
			}
		}
		respuesta.put("mensaje", mensaje);
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		out.println(mapper.writeValueAsString(respuesta));
		out.close();

    }
    private void ingresarIntranet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String pagina="inicioInt.jsp";
		request.getRequestDispatcher(pagina).forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String accion = request.getParameter("txt_accion");
    	if(accion==null || "validar".equals(accion)){
			validarUsuarioInterno(request,response);
		}else{
			ingresarIntranet(request,response);	
		}    	
	}

}

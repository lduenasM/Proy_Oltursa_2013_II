package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import bean.UsuarioInterno;
import dao.DAOFactory;
import dao.Entidad;

@WebServlet("/manusuarioint")
public class MantenimientoUsuarioInternoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MantenimientoUsuarioInternoServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion=request.getParameter("txt_accion");
		if(accion==null){
			consultar(request,response);
		}else if("nuevo".equals(accion)){
			nuevo(request,response);
		}else if("registrar".equals(accion)){
			registrar(request,response);
		}else if("editar".equals(accion)){
			editar(request,response);
		}else if("actualizar".equals(accion)){
			actualizar(request,response);
		}else if("eliminar".equals(accion)){
			eliminar(request,response);
		}else if("consultaCriterio".equals(accion)){
			consultarCriterio(request, response);		
		}
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("interno/usuariointerno/usuarioRegistrar.jsp").
			forward(request, response);
	}

	private void eliminar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("txt_id"));
		UsuarioInterno usuario = new UsuarioInterno();
		usuario.setCod_per(id);
		Entidad<UsuarioInterno> usuarioDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getUsuarioInternoDAO();
		usuarioDAO.delete(usuario);
		response.sendRedirect("manusuarioint");//GET
		
	}

	private void actualizar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		UsuarioInterno usuario = new UsuarioInterno();
		usuario.setCod_per(Integer.parseInt(request.getParameter("txt_id")));
		usuario.setLog_usu(request.getParameter("txt_user"));
		usuario.setPas_usu(request.getParameter("txt_password"));
		usuario.setEst_usu(request.getParameter("rbn_estado"));
		usuario.setUsu_mod(request.getParameter("txt_id"));
		
		Entidad<UsuarioInterno> usuarioDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getUsuarioInternoDAO();
		int rows=usuarioDAO.update(usuario);		
		if(rows!=-1){
			response.sendRedirect("manusuarioint");
		}else{
			String mensaje="No se pudo registrar";
			request.setAttribute("mensaje", mensaje);
			response.sendRedirect("manusuarioint");
			//request.getRequestDispatcher("manusuarioint?txt_action=").forward(request, response);
		}
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioInterno usuario = new UsuarioInterno();
		Integer id=Integer.parseInt(request.getParameter("txt_id"));
		usuario.setCod_per(id);		
		Entidad<UsuarioInterno> usuarioDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getUsuarioInternoDAO();
		usuario=usuarioDAO.findById(usuario);		
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("interno/usuariointerno/usuarioModificar.jsp").forward(request, response);
	}

	private void registrar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		UsuarioInterno usuario = new UsuarioInterno();
		usuario.setCod_per(Integer.parseInt(request.getParameter("txt_id")));
		usuario.setLog_usu(request.getParameter("txt_user"));
		usuario.setPas_usu(request.getParameter("txt_password"));
		usuario.setEst_usu(request.getParameter("rbn_estado"));	
		Entidad<UsuarioInterno> usuarioDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getUsuarioInternoDAO();
		usuario = usuarioDAO.insert(usuario);
		response.sendRedirect("manusuarioint");		
	}

	private void consultar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Entidad<UsuarioInterno> usuarioInternoDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getUsuarioInternoDAO();
		List<UsuarioInterno> usuarios =usuarioInternoDAO.listAll();
		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("interno/usuariointerno/usuarioMantener.jsp").forward(request, response);
	}
	private void consultarCriterio(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		UsuarioInterno usuario = new UsuarioInterno();
		Integer id=Integer.parseInt(request.getParameter("txt_id"));
		usuario.setCod_per(id);	
		Entidad<UsuarioInterno> usuarioDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getUsuarioInternoDAO();
		List<UsuarioInterno> usuarios =usuarioDAO.listT(usuario);
		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("interno/usuariointerno/usuarioMantener.jsp").forward(request, response);
	}
}

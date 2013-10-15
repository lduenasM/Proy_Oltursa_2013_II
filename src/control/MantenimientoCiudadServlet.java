package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import bean.Ciudad;
import bean.Pais;
import dao.DAOFactory;
import dao.Entidad;

@WebServlet("/manciudad")
public class MantenimientoCiudadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MantenimientoCiudadServlet() {
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
		}else if("registro".equals(accion)){
			registro(request, response);		
		}
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("interno/ciudad/ciudadRegistrar.jsp").
			forward(request, response);
	}

	private void eliminar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("txt_id"));
		Ciudad ciudad = new Ciudad();
		ciudad.setCod_ciudad(id);
		Entidad<Ciudad> ciudadDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getCiudadDAO();
		ciudadDAO.delete(ciudad);
		response.sendRedirect("manciudad");//GET
		
	}

	private void actualizar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Ciudad ciudad = new Ciudad();
		ciudad.setCod_ciudad(Integer.parseInt(request.getParameter("txt_id")));
		ciudad.setNom_ciu(request.getParameter("txt_nombre"));
		ciudad.setEst_ciu(request.getParameter("rbn_estado"));
		
		Entidad<Ciudad> ciudadDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getCiudadDAO();
		int rows=ciudadDAO.update(ciudad);		
		if(rows!=-1){
			response.sendRedirect("manciudad");
		}else{
			String mensaje="No se pudo registrar";
			request.setAttribute("mensaje", mensaje);
			response.sendRedirect("manciudad");
			//request.getRequestDispatcher("manciudad?txt_action=").forward(request, response);
		}
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ciudad ciudad = new Ciudad();
		
		Integer id=Integer.parseInt(request.getParameter("txt_id"));
		ciudad.setCod_ciudad(id);	
		Entidad<Ciudad> ciudadDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getCiudadDAO();
		ciudad=ciudadDAO.findById(ciudad);		

		Entidad<Pais> paisInternoDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getPaisDAO();
		List<Pais> pais =paisInternoDAO.listAll();
		request.setAttribute("pais", pais);
		
		request.setAttribute("ciudad", ciudad);
		request.getRequestDispatcher("interno/ciudad/ciudadModificar.jsp").forward(request, response);
	}

	private void registrar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ENTRA METODO REGISTRAR CIUDAD");
		Ciudad ciudad = new Ciudad();
		Ciudad ultCiudad= new Ciudad();
		
		Entidad<Ciudad> ciudadUltDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getCiudadDAO();
		ultCiudad =ciudadUltDAO.ultReg(ciudad);
		int new_cod_ciudad=ultCiudad.getCod_ciudad()+1;
		System.out.println("ULTIMO REGISTRO DE CIUDAD: "+new_cod_ciudad);
		
		ciudad.setCod_ciudad(new_cod_ciudad);
		ciudad.setNom_ciu(request.getParameter("txt_nombre"));
		ciudad.setCod_pais(Integer.parseInt(request.getParameter("txt_pais")));
		ciudad.setDes_ciu(request.getParameter("txt_nombre"));
		ciudad.setEst_ciu(request.getParameter("rbn_estado"));
		Entidad<Ciudad> ciudadDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getCiudadDAO();
		ciudad = ciudadDAO.insert(ciudad);
		response.sendRedirect("manciudad");		
	}

	private void consultar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Entidad<Ciudad> ciudadInternoDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getCiudadDAO();
		List<Ciudad> ciudad =ciudadInternoDAO.listAll();
		request.setAttribute("ciudad", ciudad);
		
		Entidad<Pais> paisInternoDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getPaisDAO();
		List<Pais> pais =paisInternoDAO.listAll();
		request.setAttribute("pais", pais);
		
		
		request.getRequestDispatcher("interno/ciudad/ciudadMantener.jsp").forward(request, response);
	}
	private void consultarCriterio(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Ciudad ciudads = new Ciudad();
		Integer id=Integer.parseInt(request.getParameter("txt_id"));
		ciudads.setCod_ciudad(id);
		ciudads.setCod_pais(0);
		Entidad<Ciudad> ciudadDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getCiudadDAO();
		List<Ciudad> ciudad =ciudadDAO.listT(ciudads);
		

		Entidad<Pais> paisInternoDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getPaisDAO();
		List<Pais> pais =paisInternoDAO.listAll();
		request.setAttribute("pais", pais);
		
		request.setAttribute("ciudad", ciudad);
		request.getRequestDispatcher("interno/ciudad/ciudadMantener.jsp").forward(request, response);
	}
	private void registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Entidad<Pais> paisInternoDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getPaisDAO();
		List<Pais> pais =paisInternoDAO.listAll();
		request.setAttribute("pais", pais);		
		request.getRequestDispatcher("interno/ciudad/ciudadRegistrar.jsp").forward(request, response);
	}
}

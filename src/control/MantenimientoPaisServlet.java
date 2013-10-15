package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import bean.Pais;
import dao.DAOFactory;
import dao.Entidad;

@WebServlet("/manpais")
public class MantenimientoPaisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MantenimientoPaisServlet() {
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
		request.getRequestDispatcher("interno/pais/paisRegistrar.jsp").
			forward(request, response);
	}

	private void eliminar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("txt_id"));
		Pais pais = new Pais();
		pais.setCod_pais(id);
		Entidad<Pais> paisDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getPaisDAO();
		paisDAO.delete(pais);
		response.sendRedirect("manpais");//GET
		
	}

	private void actualizar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Pais pais = new Pais();
		pais.setCod_pais(Integer.parseInt(request.getParameter("txt_id")));
		pais.setNom_pais(request.getParameter("txt_nombre"));
		pais.setEst_pais(request.getParameter("rbn_estado"));
		
		Entidad<Pais> paisDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getPaisDAO();
		int rows=paisDAO.update(pais);		
		if(rows!=-1){
			response.sendRedirect("manpais");
		}else{
			String mensaje="No se pudo registrar";
			request.setAttribute("mensaje", mensaje);
			response.sendRedirect("manpais");
			//request.getRequestDispatcher("manpais?txt_action=").forward(request, response);
		}
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pais pais = new Pais();
		Integer id=Integer.parseInt(request.getParameter("txt_id"));
		pais.setCod_pais(id);	
		Entidad<Pais> paisDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getPaisDAO();
		pais=paisDAO.findById(pais);		
		request.setAttribute("pais", pais);
		request.getRequestDispatcher("interno/pais/paisModificar.jsp").forward(request, response);
	}

	private void registrar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ENTRA METODO REGISTRAR");
		Pais pais = new Pais();
		Pais ultPais= new Pais();
		
		Entidad<Pais> paisUltDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getPaisDAO();
		ultPais =paisUltDAO.ultReg(pais);
		int new_cod_pais=ultPais.getCod_pais()+1;
		System.out.println("ULTIMO REGISTRO DE PAIS: "+new_cod_pais);
		
		pais.setCod_pais(new_cod_pais);
		pais.setNom_pais(request.getParameter("txt_nombre"));
		pais.setEst_pais(request.getParameter("rbn_estado"));
		Entidad<Pais> paisDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getPaisDAO();
		pais = paisDAO.insert(pais);
		response.sendRedirect("manpais");		
	}

	private void consultar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Entidad<Pais> paisInternoDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getPaisDAO();
		List<Pais> paiss =paisInternoDAO.listAll();
		request.setAttribute("paiss", paiss);
		request.getRequestDispatcher("interno/pais/paisMantener.jsp").forward(request, response);
	}
	private void consultarCriterio(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Pais pais = new Pais();
		Integer id=Integer.parseInt(request.getParameter("txt_id"));
		pais.setCod_pais(id);
		Entidad<Pais> paisDAO=DAOFactory.getFactoryConcrete(DAOFactory.MYSQL).getPaisDAO();
		List<Pais> paiss =paisDAO.listT(pais);
		request.setAttribute("paiss", paiss);
		request.getRequestDispatcher("interno/pais/paisMantener.jsp").forward(request, response);
	}
}

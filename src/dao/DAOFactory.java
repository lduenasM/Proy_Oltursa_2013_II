package dao;
import bean.*;

public abstract class DAOFactory {
	public static final int MYSQL=1;
	public static final int ORACLE=2;
	public abstract Entidad<Pais> getPaisDAO();
	public abstract Entidad<Ciudad> getCiudadDAO();
	public abstract Entidad<Distrito> getDistritoDAO();
	public abstract Entidad<Telefono> getTelefonoDAO();
	public abstract Entidad<Correo> getCorreoDAO();
	public abstract Entidad<Cliente> getClienteDAO();
	public abstract Entidad<Persona> getPersonaDAO();
	public abstract Entidad<Empleado> getEmpleadoDAO();
	public abstract Entidad<UsuarioInterno> getUsuarioInternoDAO();
	public abstract Entidad<Usuario_rol> getUsuario_rol();
	public abstract Entidad<Rol> getRolDAO();
	public abstract Entidad<Modulo> getModuloDAO();
	public abstract Entidad<Submodulo> getSubmoduloDAO();
	public abstract Entidad<Cargo> getCargoDAO();
	public abstract Entidad<Boleto> getBoletoDAO();
	public abstract Entidad<Terminal> getTerminalDAO();
	public abstract Entidad<Ruta> getRutaDAO();
	public abstract Entidad<Empleado_terminal> getEmpleado_terminalDAO();
	public abstract Entidad<Asiento> getAsientoDAO();
	public abstract Entidad<Itinerario> getItinerarioDAO();
	public abstract Entidad<Estado_Unidad> getEstado_unidadDAO();
	public abstract Entidad<Horario> getHorarioDAO();
	public abstract Entidad<Marca> getMarcaDAO();
	public abstract Entidad<Modelo> getModeloDAO();
	public abstract Entidad<Unidad> getUnidadDAO();
	public abstract Entidad<Histo_bol> getHisto_bolDAO();
	public abstract Entidad<Tipo_Servicio> getTipo_servicioDAO();
	
	public static DAOFactory getFactoryConcrete(int option){
		switch(option){
		case MYSQL:
			return new MySQLFactory();
		case ORACLE:
			return new OracleFactory();
		default: break;
		}
		return null;
	}
}

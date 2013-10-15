package dao;

import bean.*;
import dao.mysql.*;
public class MySQLFactory extends DAOFactory{

	public Entidad<UsuarioInterno> getUsuarioInternoDAO() {
		return new MySQLUsuarioInternoDAO();
	}
	public Entidad<Tipo_Servicio> getTipo_servicioDAO() {
		return new MySQLTipo_servicioDAO();
	}
	public Entidad<Pais> getPaisDAO() {
		return new MySQLPaisDAO();
	}
	public Entidad<Ciudad> getCiudadDAO() {
		return new MySQLCiudadDAO();
	}
	public Entidad<Marca> getMarcaDAO() {
		return new MySQLMarcaDAO();
	}
	public Entidad<Modelo> getModeloDAO() {
		return new MySQLModeloDAO();
	}
	public Entidad<Ruta> getRutaDAO() {
		return new MySQLRutaDAO();
	}
	public Entidad<Cargo> getCargoDAO() {
		return new MySQLCargoDAO();
	}
	public Entidad<Distrito> getDistritoDAO() {
		return new MySQLDistritoDAO();
	}
	public Entidad<Telefono> getTelefonoDAO() {
		return new MySQLTelefonoDAO();
	}
	public Entidad<Correo> getCorreoDAO() {
		return new MySQLCorreoDAO();
	}
	public Entidad<Cliente> getClienteDAO() {
		return new MySQLClienteDAO();
	}
	public Entidad<Persona> getPersonaDAO() {
		return new MySQLPersonaDAO();
	}
	public Entidad<Empleado> getEmpleadoDAO() {
		return new MySQLEmpleadoDAO();
	}
	public Entidad<Usuario_rol> getUsuario_rol() {
		return new MySQLUsuario_rolDAO();
	}
	public Entidad<Rol> getRolDAO() {
		return new MySQLRolDAO();
	}
	public Entidad<Modulo> getModuloDAO() {
		return new MySQLModuloDAO();
	}
	public Entidad<Submodulo> getSubmoduloDAO() {
		return new MySQLSubmoduloDAO();
	} 
	public Entidad<Boleto> getBoletoDAO() {
		return new MySQLBoletoDAO();
	} 
	public Entidad<Terminal> getTerminalDAO() {
		return new MySQLTerminalDAO();
	} 
	public Entidad<Empleado_terminal> getEmpleado_terminalDAO() {
		return new MySQLEmpleado_terminalDAO();
	} 
	public Entidad<Asiento> getAsientoDAO() {
		return new MySQLAsientoDAO();
	} 
	public Entidad<Itinerario> getItinerarioDAO() {
		return new MySQLItinerarioDAO();
	} 
	public Entidad<Estado_Unidad> getEstado_unidadDAO() {
		return new MySQLEstado_unidadDAO();
	} 
	public Entidad<Horario> getHorarioDAO() {
		return new MySQLHorarioDAO();
	} 
	public Entidad<Unidad> getUnidadDAO() {
		return new MySQLUnidadDAO();
	} 
	public Entidad<Histo_bol> getHisto_bolDAO() {
		return new MySQLHisto_bolDAO();
	}
}

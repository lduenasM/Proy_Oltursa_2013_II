package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.*;
import util.DataBaseConnection;
import bean.*;
public class MySQLUsuarioDAO implements Entidad<Usuario> {

	public Usuario insert(Usuario t) {
		Connection con=null;
		try {
			con=DataBaseConnection.openConnection();
			String sql="INSERT INTO t_usuario (nombre,user,password,estado) VALUES(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getUser());
			ps.setString(3, t.getPassword());
			ps.setInt(4, t.getEstado());
			ps.executeUpdate();
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()){
				int id=rs.getInt(1);
				System.out.println(id);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		if(con!=null){ 
			try{ con.close(); }catch(Exception ex){}
		}
		}
		return t;
	}
	public int update(Usuario usuario) {
		Connection con=null;
		int rows = -1;
		try{
			con=DataBaseConnection.openConnection();
			System.out.println("Se actualizara Usuario con id :"+usuario.getId() );
		    String sql="UPDATE t_usuario SET nombre=?,user=?,password=?,estado=? WHERE id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getUser());
			ps.setString(3, usuario.getPassword());
			ps.setInt(4,usuario.getEstado());
			ps.setInt(5,usuario.getId());
			int row=ps.executeUpdate();
			System.out.println(row);
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return rows;
	}
	public int delete(Usuario t) {
		Connection con=null;
		int rows=-1;
		try {
			con=DataBaseConnection.openConnection();
			String sql="DELETE FROM t_usuario WHERE id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, t.getId());
			rows=ps.executeUpdate();
			System.out.println(rows);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return rows;
	}
	public Usuario findById(Usuario t) {
				Connection con=null;
				Usuario usuariodb=null;
				try {
					con=DataBaseConnection.openConnection();
					PreparedStatement ps=null;
					if(t.getUser()==null){
						//Buscara por Id
						String sql="SELECT * FROM t_usuario WHERE id=?";
						System.out.println("Se busca Usuario por id :"+t.getId() );
						ps=con.prepareStatement(sql);
						ps.setInt(1, t.getId());
					}else{
						//Buscara por User para el login
						String sql="SELECT * FROM t_usuario WHERE user=?";
						System.out.println("Se busca Usuario por User :"+t.getUser() );
						ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
						ps.setString(1, t.getUser());						
					}
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						usuariodb = new Usuario();
						usuariodb.setId(rs.getInt("id"));
						usuariodb.setUser(rs.getString("user"));
						usuariodb.setNombre(rs.getString("nombre"));
						usuariodb.setPassword(rs.getString("password"));
						usuariodb.setEstado(rs.getInt("estado"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					DataBaseConnection.closeConnection(con);
				}
				return usuariodb;
	}
	public List<Usuario> listAll() {
		List<Usuario> usuario = new ArrayList<Usuario>();
		Connection con=null;
		try {
			con=DataBaseConnection.openConnection();
			String sql="SELECT * FROM t_usuario ORDER BY id DESC";
			Statement st=con.createStatement();	
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Usuario usuariodb = new Usuario();
				usuariodb.setId(rs.getInt("id"));
				usuariodb.setUser(rs.getString("user"));
				usuariodb.setNombre(rs.getString("nombre"));
				usuariodb.setPassword(rs.getString("password"));
				usuariodb.setEstado(rs.getInt("estado"));
				usuario.add(usuariodb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return usuario;		
	}
	public List<Usuario> listT(Usuario t) {
		List<Usuario> usuario = new ArrayList<Usuario>();
		Connection con=null;
		try {
			con=DataBaseConnection.openConnection();
			String sql="SELECT * FROM t_usuario WHERE id="+t.getId()+" ";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Usuario usuariodb = new Usuario();
				usuariodb.setId(rs.getInt("id"));
				usuariodb.setUser(rs.getString("user"));
				usuariodb.setNombre(rs.getString("nombre"));
				usuariodb.setPassword(rs.getString("password"));
				usuariodb.setEstado(rs.getInt("estado"));
				usuario.add(usuariodb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return usuario;		
	}
	public List<Usuario> listAllCustom(Object... objects) {
		return null;
	}
	@Override
	public Usuario ultReg(Usuario t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

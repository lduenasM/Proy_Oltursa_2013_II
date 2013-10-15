package dao.mysql;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao.*;
import util.DataBaseConnection;
import bean.*;
public class MySQLUsuarioInternoDAO implements Entidad<UsuarioInterno> {

	public UsuarioInterno insert(UsuarioInterno t) {
		Connection con=null;
		try {
			con=DataBaseConnection.openConnection();
			String sql="INSERT INTO t_usuario_interno (cod_per,log_usu,pas_usu,est_usu,usu_reg,usu_mod,fec_reg,fec_mod) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, t.getCod_per());
			ps.setString(2, t.getLog_usu());
			ps.setString(3, t.getPas_usu());
			ps.setString(4, t.getEst_usu());
			ps.setString(5, t.getUsu_reg());
			ps.setString(6, t.getUsu_mod());
			ps.setDate(7, (Date) t.getFec_reg());
			ps.setDate(8, (Date) t.getFec_mod());
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
	public int update(UsuarioInterno  t) {
		Connection con=null;
		int rows = -1;
		try{
			con=DataBaseConnection.openConnection();
			System.out.println("Se actualizara UsuarioInterno con id :"+ t.getCod_per());
			//log_usu,pas_usu,est_usu,usu_reg,usu_mod,fec_reg,fec_mod
		    String sql="UPDATE t_usuario_interno SET log_usu=?,pas_usu=?,est_usu=?,usu_reg=?,usu_mod=?,fec_reg=?,fec_mod=? WHERE cod_per=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, t.getLog_usu());
			ps.setString(2, t.getPas_usu());
			ps.setString(3, t.getEst_usu());
			ps.setString(4, t.getUsu_reg());
			ps.setString(5, t.getUsu_mod());
			ps.setDate(6, (Date) t.getFec_reg());
			ps.setDate(7, (Date) t.getFec_mod());
			ps.setInt(8, t.getCod_per());			
			int row=ps.executeUpdate();
			System.out.println(row);
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return rows;
	}
	public int delete(UsuarioInterno t) {
		Connection con=null;
		int rows=-1;
		try {
			con=DataBaseConnection.openConnection();
			String sql="DELETE FROM t_usuario_interno WHERE cod_per=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, t.getCod_per());
			rows=ps.executeUpdate();
			System.out.println(rows);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return rows;
	}
	public UsuarioInterno findById(UsuarioInterno t) {
				Connection con=null;
				UsuarioInterno usuariodb=null;
				try {
					con=DataBaseConnection.openConnection();
					PreparedStatement ps=null;
					if(t.getLog_usu()==null){
						//Buscara por Id
						String sql="SELECT * FROM t_usuario_interno WHERE cod_per=?";
						System.out.println("Se busca UsuarioInterno por id :"+t.getCod_per() );
						ps=con.prepareStatement(sql);
						ps.setInt(1, t.getCod_per());
					}else{
						//Buscara por User para el login
						String sql="SELECT * FROM t_usuario_interno WHERE log_usu=?";
						System.out.println("Se busca UsuarioInterno por User :"+t.getLog_usu() );
						ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
						ps.setString(1, t.getLog_usu());						
					}
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						usuariodb = new UsuarioInterno();
						usuariodb.setCod_per(rs.getInt("cod_per"));
						usuariodb.setLog_usu(rs.getString("log_usu"));
						usuariodb.setPas_usu(rs.getString("pas_usu"));
						usuariodb.setEst_usu(rs.getString("est_usu"));
						usuariodb.setUsu_reg(rs.getString("usu_reg"));
						usuariodb.setUsu_mod(rs.getString("usu_mod"));
						usuariodb.setFec_reg(rs.getDate("fec_reg"));
						usuariodb.setFec_mod(rs.getDate("fec_mod"));						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					DataBaseConnection.closeConnection(con);
				}
				return usuariodb;
	}
	public List<UsuarioInterno> listAll() {
		List<UsuarioInterno> usuario = new ArrayList<UsuarioInterno>();
		Connection con=null;
		try {
			con=DataBaseConnection.openConnection();
			String sql="SELECT * FROM t_usuario_interno ORDER BY cod_per DESC";
			Statement st=con.createStatement();	
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				UsuarioInterno usuariodb = new UsuarioInterno();
				usuariodb.setCod_per(rs.getInt("cod_per"));
				usuariodb.setLog_usu(rs.getString("log_usu"));
				usuariodb.setPas_usu(rs.getString("pas_usu"));
				usuariodb.setEst_usu(rs.getString("est_usu"));
				usuariodb.setUsu_reg(rs.getString("usu_reg"));
				usuariodb.setUsu_mod(rs.getString("usu_mod"));
				usuariodb.setFec_reg(rs.getDate("fec_reg"));
				usuariodb.setFec_mod(rs.getDate("fec_mod"));
				usuario.add(usuariodb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return usuario;		
	}
	public List<UsuarioInterno> listT(UsuarioInterno t) {
		List<UsuarioInterno> usuario = new ArrayList<UsuarioInterno>();
		Connection con=null;
		try {
			con=DataBaseConnection.openConnection();
			String sql="SELECT * FROM t_usuario_interno WHERE cod_per="+t.getCod_per()+" ";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				UsuarioInterno usuariodb = new UsuarioInterno();
				usuariodb.setCod_per(rs.getInt("cod_per"));
				usuariodb.setLog_usu(rs.getString("log_usu"));
				usuariodb.setPas_usu(rs.getString("pas_usu"));
				usuariodb.setEst_usu(rs.getString("est_usu"));
				usuariodb.setUsu_reg(rs.getString("usu_reg"));
				usuariodb.setUsu_mod(rs.getString("usu_mod"));
				usuariodb.setFec_reg(rs.getDate("fec_reg"));
				usuariodb.setFec_mod(rs.getDate("fec_mod"));
				usuario.add(usuariodb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return usuario;		
	}
	public List<UsuarioInterno> listAllCustom(Object... objects) {
		return null;
	}
	@Override
	public  UsuarioInterno ultReg(UsuarioInterno t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

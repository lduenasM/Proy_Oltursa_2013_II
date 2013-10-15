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
public class MySQLPersonaDAO implements Entidad<Persona> {

	@Override
	public Persona insert(Persona t) {
		Connection con=null;
		try {
			con=DataBaseConnection.openConnection();
			System.out.println("Se Ingreso PERSONA con id :"+ t.getCod_per());
			String sql="INSERT INTO t_persona (cod_per, nom_per, ape_pat, ape_mat, fec_nac, tipo_doc, nro_doc, cod_pais, cod_ciudad, cod_dis) VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, t.getCod_per());
			ps.setString(2, t.getNom_per());
			ps.setString(3, t.getApe_pat());
			ps.setString(4, t.getApe_mat());
			ps.setDate(5, (Date) t.getFec_nac());
			ps.setInt(6, t.getTipo_doc());
			ps.setString(7, t.getNro_doc());
			ps.setInt(8, t.getCod_pais());
			ps.setInt(9, t.getCod_ciudad());
			ps.setInt(10, t.getCod_dis());
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

	@Override
	public int update(Persona t) {
		Connection con=null;
		int rows = -1;
		try{
			con=DataBaseConnection.openConnection();
			System.out.println("Se actualizara PERSONA con id :"+ t.getCod_per());
		    String sql="UPDATE t_persona SET nom_per=?, ape_pat=?, ape_mat=?, fec_nac=?, tipo_doc=?, nro_doc=?, cod_pais=?, cod_ciudad=?, cod_dis=? WHERE cod_per=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, t.getCod_per());
			ps.setString(2, t.getNom_per());
			ps.setString(3, t.getApe_pat());
			ps.setString(4, t.getApe_mat());
			ps.setDate(5, (Date) t.getFec_nac());
			ps.setInt(6, t.getTipo_doc());
			ps.setString(7, t.getNro_doc());
			ps.setInt(8, t.getCod_pais());
			ps.setInt(9, t.getCod_ciudad());
			ps.setInt(10, t.getCod_dis());
			int row=ps.executeUpdate();
			System.out.println(row);
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return rows;
	}

	@Override
	public int delete(Persona t) {
		Connection con=null;
		int rows=-1;
		try {
			con=DataBaseConnection.openConnection();
			String sql="DELETE FROM t_persona WHERE cod_per=?";
			//String sql="UPDATE t_persona SET nom_per=?, ape_pat=?, ape_mat=?, fec_nac=?, tipo_doc=?, nro_doc=?, cod_pais=?, cod_ciudad=?, cod_dis=? WHERE cod_per=?";
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

	@Override
	public Persona findById(Persona t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> listT(Persona t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona ultReg(Persona t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> listAllCustom(Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}
 
}

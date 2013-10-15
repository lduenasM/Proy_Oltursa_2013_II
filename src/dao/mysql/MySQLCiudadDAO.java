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
public class MySQLCiudadDAO implements Entidad<Ciudad> {

	@Override
	public Ciudad insert(Ciudad t) {
		Connection con=null;
		try {
			con=DataBaseConnection.openConnection();
			System.out.println("Se Registrara CIUDAD con id :"+ t.getCod_ciudad());
			String sql="INSERT INTO t_ciudad (cod_pais,cod_ciudad,nom_ciu,des_cui,est_cui) VALUES(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, t.getCod_pais());
			ps.setInt(2, t.getCod_ciudad());
			ps.setString(3, t.getNom_ciu());
			ps.setString(4, t.getDes_ciu());
			ps.setString(5, t.getEst_ciu());
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
	public int update(Ciudad t) {
		Connection con=null;
		int rows = -1;
		try{
			con=DataBaseConnection.openConnection();
			System.out.println("Se actualizara Ciudad con id :"+ t.getCod_ciudad());
		    String sql="UPDATE t_ciudad SET nom_ciu=?, des_cui=?, est_cui=? WHERE cod_pais=? and cod_ciudad=? and est_cui!=0";
			PreparedStatement ps=con.prepareStatement(sql);			
			ps.setString(1, t.getNom_ciu());	
			ps.setString(2, t.getDes_ciu());
			ps.setString(3, t.getEst_ciu());
			ps.setInt(4, t.getCod_pais());
			ps.setInt(5, t.getCod_ciudad());
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
	public int delete(Ciudad t) {
		Connection con=null;
		int rows=-1;
		try {
			con=DataBaseConnection.openConnection();
			System.out.println("Se Eliminara CIUDAD con id :"+ t.getCod_pais());
			
			//String sql="DELETE FROM t_pais WHERE cod_pais=?";
			//PreparedStatement ps=con.prepareStatement(sql);
			//ps.setInt(1, t.getCod_pais());

			
			String sql="UPDATE t_ciudad SET est_ciu=? WHERE cod_ciudad=?";
			PreparedStatement ps=con.prepareStatement(sql);			
			ps.setString(1, "0");
			ps.setInt(2, t.getCod_ciudad());
			
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
	public Ciudad findById(Ciudad t) {
		Connection con=null;
		Ciudad ciudaddb=null;
		try {
			con=DataBaseConnection.openConnection();
			PreparedStatement ps=null;
			if(t.getCod_pais()== 0){
				//Buscara por Id ciudad
				String sql="SELECT * FROM t_ciudad WHERE cod_ciudad=? and est_cui!=0";
				System.out.println("Se busca Ciudad por id :"+t.getCod_ciudad() );
				ps=con.prepareStatement(sql);
				ps.setInt(1, t.getCod_ciudad());
			}else{
				//Buscara por Id pais
				String sql="SELECT * FROM t_ciudad WHERE cod_pais=? and est_cui!=0";
				System.out.println("Se busca Ciudad por Pais :"+t.getCod_pais());
				ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1, t.getCod_pais());						
			}
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ciudaddb = new Ciudad();
				ciudaddb.setCod_pais(rs.getInt("cod_pais"));
				ciudaddb.setCod_ciudad(rs.getInt("cod_ciudad"));
				ciudaddb.setNom_ciu(rs.getString("nom_ciu"));
				ciudaddb.setNom_ciu(rs.getString("des_ciu"));
				ciudaddb.setEst_ciu(rs.getString("est_ciu"));					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return ciudaddb;
	}

	@Override
	public List<Ciudad> listAll() {
		List<Ciudad> ciudad = new ArrayList<Ciudad>();
		Connection con=null;
		try {
			con=DataBaseConnection.openConnection();
			String sql="SELECT * FROM t_ciudad where est_cui != 0 ORDER BY cod_ciudad DESC";
			Statement st=con.createStatement();	
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				System.out.println("CIUDAD LISTADA");
				Ciudad ciudaddb = new Ciudad();
				ciudaddb.setCod_pais(rs.getInt("cod_pais"));
				ciudaddb.setCod_ciudad(rs.getInt("cod_ciudad"));
				ciudaddb.setNom_ciu(rs.getString("nom_ciu"));
				ciudaddb.setDes_ciu(rs.getString("des_cui"));
				ciudaddb.setEst_ciu(rs.getString("est_cui"));		
				ciudad.add(ciudaddb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return ciudad;		
	}

	@Override
	public List<Ciudad> listT(Ciudad t) {
		List<Ciudad> ciudad = new ArrayList<Ciudad>();
		Connection con=null;
		try {
			con=DataBaseConnection.openConnection();
			String sql="SELECT * FROM t_ciudad WHERE cod_ciudad="+t.getCod_ciudad()+" AND EST_cui != 0 ";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Ciudad ciudaddb = new Ciudad();
				ciudaddb.setCod_pais(rs.getInt("cod_pais"));
				ciudaddb.setCod_ciudad(rs.getInt("cod_ciudad"));
				ciudaddb.setNom_ciu(rs.getString("nom_ciu"));
				ciudaddb.setDes_ciu(rs.getString("des_cui"));
				ciudaddb.setEst_ciu(rs.getString("est_cui"));		
				ciudad.add(ciudaddb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return ciudad;	
	}

	@Override
	public Ciudad ultReg(Ciudad t) {
		Connection con=null;
		Ciudad ciudaddb=null;
		try {
			con=DataBaseConnection.openConnection();
			PreparedStatement ps=null;
			System.out.println("SE BUSCARA ULTIMO REGISTRO");
			String sql="select max(cod_ciudad) from t_ciudad";
			System.out.println("Se busca Ciudad " );
			Statement st=con.createStatement();	
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				ciudaddb = new Ciudad();
				ciudaddb.setCod_ciudad(rs.getInt("max(cod_ciudad)"));
				System.out.println("SE ENCONTRO ULTIMO REGISTRO :"+rs.getInt("cod_ciudad"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		System.out.println("SE DEVUELVE ULTIMO REGSITRO CIUDAD: "+ciudaddb.getCod_ciudad());
		return ciudaddb;
	}

	@Override
	public List<Ciudad> listAllCustom(Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

}

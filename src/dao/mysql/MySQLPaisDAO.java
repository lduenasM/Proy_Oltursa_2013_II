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
public class MySQLPaisDAO implements Entidad<Pais> {

	@Override
	public Pais insert(Pais t) {
		Connection con=null;
		try {
			con=DataBaseConnection.openConnection();
			System.out.println("Se Registrara Pais con id :"+ t.getCod_pais());
			String sql="INSERT INTO t_pais (cod_pais,nom_pais,est_pais) VALUES(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, t.getCod_pais());
			ps.setString(2, t.getNom_pais());
			ps.setString(3, t.getEst_pais());
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
	public int update(Pais t) {
		Connection con=null;
		int rows = -1;
		try{
			con=DataBaseConnection.openConnection();
			System.out.println("Se actualizara Pais con id :"+ t.getCod_pais());
			//log_usu,pas_usu,est_usu,usu_reg,usu_mod,fec_reg,fec_mod
		    String sql="UPDATE t_pais SET nom_pais=?,est_pais=? WHERE cod_pais=?";
			PreparedStatement ps=con.prepareStatement(sql);			
			ps.setString(1, t.getNom_pais());
			ps.setString(2, t.getEst_pais());
			ps.setInt(3, t.getCod_pais());
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
	public int delete(Pais t) {
		Connection con=null;
		int rows=-1;
		try {
			con=DataBaseConnection.openConnection();
			System.out.println("Se Eliminara Pais con id :"+ t.getCod_pais());
			
			//String sql="DELETE FROM t_pais WHERE cod_pais=?";
			//PreparedStatement ps=con.prepareStatement(sql);
			//ps.setInt(1, t.getCod_pais());

			
			String sql="UPDATE t_pais SET est_pais=? WHERE cod_pais=?";
			PreparedStatement ps=con.prepareStatement(sql);			
			ps.setString(1, "0");
			ps.setInt(2, t.getCod_pais());
			
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
	public Pais findById(Pais t) {
		Connection con=null;
		Pais paisdb=null;
		try {
			con=DataBaseConnection.openConnection();
			PreparedStatement ps=null;
			if(t.getNom_pais()==null){
				//Buscara por Id
				String sql="SELECT * FROM t_pais WHERE cod_pais=?";
				System.out.println("Se busca Pais por id :"+t.getCod_pais() );
				ps=con.prepareStatement(sql);
				ps.setInt(1, t.getCod_pais());
			}else{
				//Buscara por User para el login
				String sql="SELECT * FROM t_pais WHERE nom_pais=?";
				System.out.println("Se busca Pais por nombre :"+t.getNom_pais());
				ps=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, t.getNom_pais());						
			}
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				paisdb = new Pais();
				paisdb.setCod_pais(rs.getInt("cod_pais"));
				paisdb.setNom_pais(rs.getString("nom_pais"));
				paisdb.setEst_pais(rs.getString("est_pais"));					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return paisdb;
	}

	@Override
	public List<Pais> listAll() {
		List<Pais> pais = new ArrayList<Pais>();
		Connection con=null;
		try {
			con=DataBaseConnection.openConnection();
			String sql="SELECT * FROM t_pais where EST_PAIS != 0 ORDER BY cod_pais DESC";
			Statement st=con.createStatement();	
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Pais paisdb = new Pais();
				paisdb.setCod_pais(rs.getInt("cod_pais"));
				paisdb.setNom_pais(rs.getString("nom_pais"));
				paisdb.setEst_pais(rs.getString("est_pais"));		
				pais.add(paisdb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return pais;		
	}

	@Override
	public List<Pais> listT(Pais t) {
		List<Pais> pais = new ArrayList<Pais>();
		Connection con=null;
		try {
			con=DataBaseConnection.openConnection();
			String sql="SELECT * FROM t_pais WHERE cod_pais="+t.getCod_pais()+" AND EST_PAIS != 0 ";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Pais paisdb = new Pais();
				paisdb.setCod_pais(rs.getInt("cod_pais"));
				paisdb.setNom_pais(rs.getString("nom_pais"));
				paisdb.setEst_pais(rs.getString("est_pais"));		
				pais.add(paisdb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		return pais;		
	}

	@Override
	public Pais ultReg(Pais t) {		
		Connection con=null;
		Pais paisdb=null;
		try {
			con=DataBaseConnection.openConnection();
			PreparedStatement ps=null;
			System.out.println("SE BUSCARA ULTIMO REGISTRO");
			String sql="select max(cod_pais) from t_pais";
			System.out.println("Se busca Pais " );
			Statement st=con.createStatement();	
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				paisdb = new Pais();
				paisdb.setCod_pais(rs.getInt("max(cod_pais)"));
				System.out.println("SE ENCONTRO ULTIMO REGISTRO :"+rs.getInt("cod_pais"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(con);
		}
		System.out.println("SE DEVUELVE ULTIMO REGSITRO PAIS");
		return paisdb;		
	}

	@Override
	public List<Pais> listAllCustom(Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}
 
}

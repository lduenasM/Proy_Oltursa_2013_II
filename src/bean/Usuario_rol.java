package bean;

import java.util.Date;

public class Usuario_rol {
	private int cod_rol;
	private int cod_per;
	private String est_rol;
	private String usu_reg;
	private String usu_mod;
	private Date fec_reg;
	private Date fec_mod;
	public int getCod_rol() {
		return cod_rol;
	}
	public void setCod_rol(int cod_rol) {
		this.cod_rol = cod_rol;
	}
	public int getCod_per() {
		return cod_per;
	}
	public void setCod_per(int cod_per) {
		this.cod_per = cod_per;
	}
	public String getEst_rol() {
		return est_rol;
	}
	public void setEst_rol(String est_rol) {
		this.est_rol = est_rol;
	}
	public String getUsu_reg() {
		return usu_reg;
	}
	public void setUsu_reg(String usu_reg) {
		this.usu_reg = usu_reg;
	}
	public String getUsu_mod() {
		return usu_mod;
	}
	public void setUsu_mod(String usu_mod) {
		this.usu_mod = usu_mod;
	}
	public Date getFec_reg() {
		return fec_reg;
	}
	public void setFec_reg(Date fec_reg) {
		this.fec_reg = fec_reg;
	}
	public Date getFec_mod() {
		return fec_mod;
	}
	public void setFec_mod(Date fec_mod) {
		this.fec_mod = fec_mod;
	}	
}

package bean;

import java.util.Date;

public class Ruta {
	protected int cod_ruta;
	protected int cod_ter_ini;
	protected int cod_ter_fin;
	protected int tiem_rut;
	protected String est_rut;
	protected  String usu_reg;
	protected String usu_mod;
	protected Date fec_reg;
	protected Date fec_mod;
	public int getCod_ruta() {
		return cod_ruta;
	}
	public void setCod_ruta(int cod_ruta) {
		this.cod_ruta = cod_ruta;
	}
	public int getCod_ter_ini() {
		return cod_ter_ini;
	}
	public void setCod_ter_ini(int cod_ter_ini) {
		this.cod_ter_ini = cod_ter_ini;
	}
	public int getCod_ter_fin() {
		return cod_ter_fin;
	}
	public void setCod_ter_fin(int cod_ter_fin) {
		this.cod_ter_fin = cod_ter_fin;
	}
	public int getTiem_rut() {
		return tiem_rut;
	}
	public void setTiem_rut(int tiem_rut) {
		this.tiem_rut = tiem_rut;
	}
	public String getEst_rut() {
		return est_rut;
	}
	public void setEst_rut(String est_rut) {
		this.est_rut = est_rut;
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

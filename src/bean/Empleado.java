package bean;

import java.util.Date;

public class Empleado {
	private int cod_per;
	private int cod_car;
	private String est_emp;
	private String usu_reg;
	private String usu_mod;
	private Date fec_red;
	private Date fec_mod;
	public int getCod_per() {
		return cod_per;
	}
	public void setCod_per(int cod_per) {
		this.cod_per = cod_per;
	}
	public int getCod_car() {
		return cod_car;
	}
	public void setCod_car(int cod_car) {
		this.cod_car = cod_car;
	}
	public String getEst_emp() {
		return est_emp;
	}
	public void setEst_emp(String est_emp) {
		this.est_emp = est_emp;
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
	public Date getFec_red() {
		return fec_red;
	}
	public void setFec_red(Date fec_red) {
		this.fec_red = fec_red;
	}
	public Date getFec_mod() {
		return fec_mod;
	}
	public void setFec_mod(Date fec_mod) {
		this.fec_mod = fec_mod;
	}
}

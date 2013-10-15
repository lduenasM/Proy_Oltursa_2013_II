package bean;

import java.util.Date;

public class Horario {
	protected int cod_hor;
	protected String det_hor;
	protected Date hora_hor;
	protected String est_hor;
	protected String usu_reg;
	protected String usu_mod;
	protected Date fec_reg;
	protected Date fec_mod;
	public int getCod_hor() {
		return cod_hor;
	}
	public void setCod_hor(int cod_hor) {
		this.cod_hor = cod_hor;
	}
	public String getDet_hor() {
		return det_hor;
	}
	public void setDet_hor(String det_hor) {
		this.det_hor = det_hor;
	}
	public Date getHora_hor() {
		return hora_hor;
	}
	public void setHora_hor(Date hora_hor) {
		this.hora_hor = hora_hor;
	}
	public String getEst_hor() {
		return est_hor;
	}
	public void setEst_hor(String est_hor) {
		this.est_hor = est_hor;
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

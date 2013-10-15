package bean;

import java.util.Date;

public class Tipo_Servicio {
	protected int cod_tip_ser;
	protected String nom_tip_ser;
	protected String det_tip_ser;
	protected String usu_reg;
	protected String usu_mod;
	protected Date fec_reg;
	protected Date fec_mod;
	protected String est_tip_ser;
	public int getCod_tip_ser() {
		return cod_tip_ser;
	}
	public void setCod_tip_ser(int cod_tip_ser) {
		this.cod_tip_ser = cod_tip_ser;
	}
	public String getNom_tip_ser() {
		return nom_tip_ser;
	}
	public void setNom_tip_ser(String nom_tip_ser) {
		this.nom_tip_ser = nom_tip_ser;
	}
	public String getDet_tip_ser() {
		return det_tip_ser;
	}
	public void setDet_tip_ser(String det_tip_ser) {
		this.det_tip_ser = det_tip_ser;
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
	public String getEst_tip_ser() {
		return est_tip_ser;
	}
	public void setEst_tip_ser(String est_tip_ser) {
		this.est_tip_ser = est_tip_ser;
	}	
}

package bean;

import java.util.Date;

public class Itinerario {
	protected int cod_iti;
	protected int cod_ruta;
	protected int cod_hor;
	protected int cod_uni;
	protected Date fec_iti;
	protected double pre_nor_iti;
	protected Date hor_sal_iti;
	protected Date hor_ll_iti;
	protected String est_iti;
	protected String usu_reg;
	protected String usu_mod;
	protected Date fec_reg;
	protected Date fec_mod;
	public int getCod_iti() {
		return cod_iti;
	}
	public void setCod_iti(int cod_iti) {
		this.cod_iti = cod_iti;
	}
	public int getCod_ruta() {
		return cod_ruta;
	}
	public void setCod_ruta(int cod_ruta) {
		this.cod_ruta = cod_ruta;
	}
	public int getCod_hor() {
		return cod_hor;
	}
	public void setCod_hor(int cod_hor) {
		this.cod_hor = cod_hor;
	}
	public int getCod_uni() {
		return cod_uni;
	}
	public void setCod_uni(int cod_uni) {
		this.cod_uni = cod_uni;
	}
	public Date getFec_iti() {
		return fec_iti;
	}
	public void setFec_iti(Date fec_iti) {
		this.fec_iti = fec_iti;
	}
	public double getPre_nor_iti() {
		return pre_nor_iti;
	}
	public void setPre_nor_iti(double pre_nor_iti) {
		this.pre_nor_iti = pre_nor_iti;
	}
	public Date getHor_sal_iti() {
		return hor_sal_iti;
	}
	public void setHor_sal_iti(Date hor_sal_iti) {
		this.hor_sal_iti = hor_sal_iti;
	}
	public Date getHor_ll_iti() {
		return hor_ll_iti;
	}
	public void setHor_ll_iti(Date hor_ll_iti) {
		this.hor_ll_iti = hor_ll_iti;
	}
	public String getEst_iti() {
		return est_iti;
	}
	public void setEst_iti(String est_iti) {
		this.est_iti = est_iti;
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

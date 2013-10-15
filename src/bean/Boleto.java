package bean;

import java.util.Date;

public class Boleto {
	private int cod_boleto;
	private int cod_per;
	private int cod_asi;
	private int nro_asi_bol;
	private String tip_rec_bol;
	private double mon_bol;
	private double igv_bol;
	private double des_bol;
	private double mon_tot;
	private Date fec_pago_bol;
	private String est_bol;
	public int getCod_boleto() {
		return cod_boleto;
	}
	public void setCod_boleto(int cod_boleto) {
		this.cod_boleto = cod_boleto;
	}
	public int getCod_per() {
		return cod_per;
	}
	public void setCod_per(int cod_per) {
		this.cod_per = cod_per;
	}
	public int getCod_asi() {
		return cod_asi;
	}
	public void setCod_asi(int cod_asi) {
		this.cod_asi = cod_asi;
	}
	public int getNro_asi_bol() {
		return nro_asi_bol;
	}
	public void setNro_asi_bol(int nro_asi_bol) {
		this.nro_asi_bol = nro_asi_bol;
	}
	public String getTip_rec_bol() {
		return tip_rec_bol;
	}
	public void setTip_rec_bol(String tip_rec_bol) {
		this.tip_rec_bol = tip_rec_bol;
	}
	public double getMon_bol() {
		return mon_bol;
	}
	public void setMon_bol(double mon_bol) {
		this.mon_bol = mon_bol;
	}
	public double getIgv_bol() {
		return igv_bol;
	}
	public void setIgv_bol(double igv_bol) {
		this.igv_bol = igv_bol;
	}
	public double getDes_bol() {
		return des_bol;
	}
	public void setDes_bol(double des_bol) {
		this.des_bol = des_bol;
	}
	public double getMon_tot() {
		return mon_tot;
	}
	public void setMon_tot(double mon_tot) {
		this.mon_tot = mon_tot;
	}
	public Date getFec_pago_bol() {
		return fec_pago_bol;
	}
	public void setFec_pago_bol(Date fec_pago_bol) {
		this.fec_pago_bol = fec_pago_bol;
	}
	public String getEst_bol() {
		return est_bol;
	}
	public void setEst_bol(String est_bol) {
		this.est_bol = est_bol;
	}	
}

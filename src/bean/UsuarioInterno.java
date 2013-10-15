package bean;

import java.util.Date;

public class UsuarioInterno {
	protected int cod_per;
	protected String log_usu;
	protected String pas_usu;
	protected String est_usu;
	protected String usu_reg;
	protected String usu_mod;
	protected Date fec_reg;
	protected Date fec_mod;
	public int getCod_per() {
		return cod_per;
	}
	public void setCod_per(int cod_per) {
		this.cod_per = cod_per;
	}
	public String getLog_usu() {
		return log_usu;
	}
	public void setLog_usu(String log_usu) {
		this.log_usu = log_usu;
	}
	public String getPas_usu() {
		return pas_usu;
	}
	public void setPas_usu(String pas_usu) {
		this.pas_usu = pas_usu;
	}
	public String getEst_usu() {
		return est_usu;
	}
	public void setEst_usu(String est_usu) {
		this.est_usu = est_usu;
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

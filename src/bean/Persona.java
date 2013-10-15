package bean;

import java.util.Date;

public class Persona {
	private int cod_per;
	private String nom_per;
	private String ape_pat;
	private String ape_mat;
	private Date fec_nac;
	private int tipo_doc;
	private String nro_doc;
	private int cod_pais;
	private int cod_ciudad;
	private int cod_dis;
	private String est_per;
	public String getEst_per() {
		return est_per;
	}
	public void setEst_per(String est_per) {
		this.est_per = est_per;
	}
	public void setCod_dis(int cod_dis) {
		this.cod_dis = cod_dis;
	}
	public int getCod_per() {
		return cod_per;
	}
	public void setCod_per(int cod_per) {
		this.cod_per = cod_per;
	}
	public String getNom_per() {
		return nom_per;
	}
	public void setNom_per(String nom_per) {
		this.nom_per = nom_per;
	}
	public String getApe_pat() {
		return ape_pat;
	}
	public void setApe_pat(String ape_pat) {
		this.ape_pat = ape_pat;
	}
	public String getApe_mat() {
		return ape_mat;
	}
	public void setApe_mat(String ape_mat) {
		this.ape_mat = ape_mat;
	}
	public Date getFec_nac() {
		return fec_nac;
	}
	public void setFec_nac(Date fec_nac) {
		this.fec_nac = fec_nac;
	}
	public int getTipo_doc() {
		return tipo_doc;
	}
	public void setTipo_doc(int tipo_doc) {
		this.tipo_doc = tipo_doc;
	}
	public String getNro_doc() {
		return nro_doc;
	}
	public void setNro_doc(String nro_doc) {
		this.nro_doc = nro_doc;
	}
	public int getCod_pais() {
		return cod_pais;
	}
	public void setCod_pais(int cod_pais) {
		this.cod_pais = cod_pais;
	}
	public int getCod_ciudad() {
		return cod_ciudad;
	}
	public void setCod_ciudad(int cod_ciudad) {
		this.cod_ciudad = cod_ciudad;
	}
	public int getCod_dis() {
		return cod_dis;
	}
	public void setCod_distrito(int cod_dis) {
		this.cod_dis = cod_dis;
	}
}

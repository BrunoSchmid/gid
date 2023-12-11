package br.com.gid.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUTOS")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProdutoPK produtoPK;
	
	@Column(name="PRODUTO", nullable = false, length = 30)
	private String produto; 

	@Column(name="TEM_PREPROC", nullable = false, length = 1)
	private String temPreProc; 

	@Column(name="TEM_SPOOL", nullable = false, length = 1)
	private String temSpool; 

	@Column(name="TEM_LOTE", nullable = false, length = 1)
	private String temLote; 

	@Column(name="TEM_ACAB", nullable = false, length = 1)
	private String temAcab; 

	@Column(name="TIPO_ORD", nullable = false, length = 1)
	private String tipoOrd; 

	@Column(name="NUM_SENSOR", nullable = false, length = 1)
	private String numSensor; 

	@Column(name="COD_AUDIT", length = 2)
	private String codAudit; 

	@Column(name="COD_DR", length = 2)
	private String codDR; 

	@Column(name="COD_ADM", length = 8)
	private String codADM; 

	@Column(name="NUM_CARTAO", length = 12)
	private String numCartao; 

	@Column(name="COD_UNID_POST", length = 5)
	private String codUnidPost; 

	@Column(name="CEP_UNID_ORIG", length = 8)
	private String cepUnidOrig; 

	@Column(name="NUM_CONTRATO", length = 10)
	private String numContrato; 
	
	@Column(name="IDPAPEL", nullable = false)
	private Integer idPapel;

	@Column(name="COD_CATEG", length = 5)
	private String codCateg; 

	@Column(name="TAM_LOTE")
	private Integer tamLote; 

	@Column(name="DIR_REFAZ", length = 255)
	private String dirRefaz; 
	
	@Column(name="ATUALIZADO", length = 1)
	private String atualizado; 

	@Column(name="TEM_DUPLEX", length = 1)
	private String temDuplex;
	
	@Column(name="QUAL_QTD")
	private Integer qualQTD;

	@Column(name="QUAL_PERFIL", length = 10)
	private String qualPerfil;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto", cascade = CascadeType.ALL) 
	private List<Trabalho> trabalhos;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((produtoPK == null) ? 0 : produtoPK.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (produtoPK == null) {
			if (other.produtoPK != null)
				return false;
		} else if (!produtoPK.equals(other.produtoPK))
			return false;
		return true;
	}

	public ProdutoPK getProdutoPK() {
		return produtoPK;
	}

	public void setProdutoPK(ProdutoPK produtoPK) {
		this.produtoPK = produtoPK;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getTemPreProc() {
		return temPreProc;
	}

	public void setTemPreProc(String temPreProc) {
		this.temPreProc = temPreProc;
	}

	public String getTemSpool() {
		return temSpool;
	}

	public void setTemSpool(String temSpool) {
		this.temSpool = temSpool;
	}

	public String getTemLote() {
		return temLote;
	}

	public void setTemLote(String temLote) {
		this.temLote = temLote;
	}

	public String getTemAcab() {
		return temAcab;
	}

	public void setTemAcab(String temAcab) {
		this.temAcab = temAcab;
	}

	public String getTipoOrd() {
		return tipoOrd;
	}

	public void setTipoOrd(String tipoOrd) {
		this.tipoOrd = tipoOrd;
	}

	public String getNumSensor() {
		return numSensor;
	}

	public void setNumSensor(String numSensor) {
		this.numSensor = numSensor;
	}

	public String getCodAudit() {
		return codAudit;
	}

	public void setCodAudit(String codAudit) {
		this.codAudit = codAudit;
	}

	public String getCodDR() {
		return codDR;
	}

	public void setCodDR(String codDR) {
		this.codDR = codDR;
	}

	public String getCodADM() {
		return codADM;
	}

	public void setCodADM(String codADM) {
		this.codADM = codADM;
	}

	public String getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}

	public String getCodUnidPost() {
		return codUnidPost;
	}

	public void setCodUnidPost(String codUnidPost) {
		this.codUnidPost = codUnidPost;
	}

	public String getCepUnidOrig() {
		return cepUnidOrig;
	}

	public void setCepUnidOrig(String cepUnidOrig) {
		this.cepUnidOrig = cepUnidOrig;
	}

	public String getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}

	public Integer getIdPapel() {
		return idPapel;
	}

	public void setIdPapel(Integer idPapel) {
		this.idPapel = idPapel;
	}

	public String getCodCateg() {
		return codCateg;
	}

	public void setCodCateg(String codCateg) {
		this.codCateg = codCateg;
	}

	public Integer getTamLote() {
		return tamLote;
	}

	public void setTamLote(Integer tamLote) {
		this.tamLote = tamLote;
	}

	public String getDirRefaz() {
		return dirRefaz;
	}

	public void setDirRefaz(String dirRefaz) {
		this.dirRefaz = dirRefaz;
	}

	public String getAtualizado() {
		return atualizado;
	}

	public void setAtualizado(String atualizado) {
		this.atualizado = atualizado;
	}

	public String getTemDuplex() {
		return temDuplex;
	}

	public void setTemDuplex(String temDuplex) {
		this.temDuplex = temDuplex;
	}

	public Integer getQualQTD() {
		return qualQTD;
	}

	public void setQualQTD(Integer qualQTD) {
		this.qualQTD = qualQTD;
	}

	public String getQualPerfil() {
		return qualPerfil;
	}

	public void setQualPerfil(String qualPerfil) {
		this.qualPerfil = qualPerfil;
	}

	public List<Trabalho> getTrabalhos() {
		return trabalhos;
	}

	public void setTrabalhos(List<Trabalho> trabalhos) {
		this.trabalhos = trabalhos;
	}

}

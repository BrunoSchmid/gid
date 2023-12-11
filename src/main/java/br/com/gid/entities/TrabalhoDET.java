package br.com.gid.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="TRABALHOSDET")
public class TrabalhoDET implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TrabalhoDETPK trabalhoDETPK;

	@Column(name = "ARQ")
	private String arquivo;

	@Column(name = "QTD")
	private Integer qtd;

	@Column(name = "REG_INI")
	private Integer registroInicial;

	@Column(name = "REG_FIM")
	private Integer registroFinal;

	@Column(name = "DTI_IMP")
	private Timestamp dataImpressaoInicial;

	@Column(name = "DTF_IMP")
	private Timestamp dataImpressaoFinal;

	@Column(name = "QTDIMP")
	private Integer qtdImpressos;

	@Column(name = "IDIMP")
	private Integer idImpressos;

	@Column(name = "DTI_ACAB")
	private Timestamp dataAcabamentoInicial;

	@Column(name = "DTF_ACAB")
	private Timestamp dataAcabamentoFinal;

	@Column(name = "QTDACAB")
	private Integer qtdAcabamento;

	@Column(name = "IDACAB")
	private Integer idAcabamento;

	@Column(name = "DTI_TRIAGEM")
	private Timestamp dataTriagemInicial;

	@Column(name = "DTF_TRIAGEM")
	private Timestamp dataTriagemFinal;

	@Column(name = "IDTRIAGEM")
	private Integer idTriagem;

	@Column(name = "DTPOST")
	private Timestamp dataPostagem;

	@Column(name = "QTDPOST")
	private Integer qtdPostagem;

	@Column(name = "REFAZ")
	private Integer refaz;

	@Column(name = "LOTE_CIF")
	private String loteCIF;

	@Column(name = "PESO")
	private Integer peso;

	@Column(name = "IMP_CAPA", length = 1)
	private String imprimeCapa;

	@Column(name = "ATUALIZADO", length = 1)
	private String atualizado;

	@Column(name = "DTI_QUAL")
	private Date dataQualInicial;

	@Column(name = "DTF_QUAL")
	private Date dataQualFinal;

	@Column(name = "QTD_QUAL")
	private Integer qtdQual;
	
	@Column(name = "DTULTIMAPOSTAGEM")
	private Date dtUltimaPostagem;
	
	@Transient
	private boolean mostraBotao;

	@JsonManagedReference
	@OneToMany(mappedBy = "trabalhoDET", cascade = CascadeType.ALL)
    private List<TrabalhoHIST> trabalhoHISTs; 
	
	@JsonManagedReference
	@OneToMany(mappedBy = "trabalhoDET", cascade = CascadeType.ALL)
    private List<Expedicao> Expedicao; 
	
	public TrabalhoDETPK getTrabalhoDETPK() {
		return trabalhoDETPK;
	}

	public void setTrabalhoDETPK(TrabalhoDETPK trabalhoDETPK) {
		this.trabalhoDETPK = trabalhoDETPK;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Integer getRegistroInicial() {
		return registroInicial;
	}

	public void setRegistroInicial(Integer registroInicial) {
		this.registroInicial = registroInicial;
	}

	public Integer getRegistroFinal() {
		return registroFinal;
	}

	public void setRegistroFinal(Integer registroFinal) {
		this.registroFinal = registroFinal;
	}

	public Timestamp getDataImpressaoInicial() {
		return dataImpressaoInicial;
	}

	public void setDataImpressaoInicial(Timestamp dataImpressaoInicial) {
		this.dataImpressaoInicial = dataImpressaoInicial;
	}

	public Timestamp getDataImpressaoFinal() {
		return dataImpressaoFinal;
	}

	public void setDataImpressaoFinal(Timestamp dataImpressaoFinal) {
		this.dataImpressaoFinal = dataImpressaoFinal;
	}

	public Integer getQtdImpressos() {
		return qtdImpressos;
	}

	public void setQtdImpressos(Integer qtdImpressos) {
		this.qtdImpressos = qtdImpressos;
	}

	public Integer getIdImpressos() {
		return idImpressos;
	}

	public void setIdImpressos(Integer idImpressos) {
		this.idImpressos = idImpressos;
	}

	public Timestamp getDataAcabamentoInicial() {
		return dataAcabamentoInicial;
	}

	public void setDataAcabamentoInicial(Timestamp dataAcabamentoInicial) {
		this.dataAcabamentoInicial = dataAcabamentoInicial;
	}

	public Timestamp getDataAcabamentoFinal() {
		return dataAcabamentoFinal;
	}

	public void setDataAcabamentoFinal(Timestamp dataAcabamentoFinal) {
		this.dataAcabamentoFinal = dataAcabamentoFinal;
	}

	public Integer getQtdAcabamento() {
		return qtdAcabamento;
	}

	public void setQtdAcabamento(Integer qtdAcabamento) {
		this.qtdAcabamento = qtdAcabamento;
	}

	public Integer getIdAcabamento() {
		return idAcabamento;
	}

	public void setIdAcabamento(Integer idAcabamento) {
		this.idAcabamento = idAcabamento;
	}

	public Timestamp getDataTriagemInicial() {
		return dataTriagemInicial;
	}

	public void setDataTriagemInicial(Timestamp dataTriagemInicial) {
		this.dataTriagemInicial = dataTriagemInicial;
	}

	public Timestamp getDataTriagemFinal() {
		return dataTriagemFinal;
	}

	public void setDataTriagemFinal(Timestamp dataTriagemFinal) {
		this.dataTriagemFinal = dataTriagemFinal;
	}

	public Integer getIdTriagem() {
		return idTriagem;
	}

	public void setIdTriagem(Integer idTriagem) {
		this.idTriagem = idTriagem;
	}

	public Timestamp getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Timestamp dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public Integer getQtdPostagem() {
		return qtdPostagem;
	}

	public void setQtdPostagem(Integer qtdPostagem) {
		this.qtdPostagem = qtdPostagem;
	}

	public Integer getRefaz() {
		return refaz;
	}

	public void setRefaz(Integer refaz) {
		this.refaz = refaz;
	}

	public String getLoteCIF() {
		return loteCIF;
	}

	public void setLoteCIF(String loteCIF) {
		this.loteCIF = loteCIF;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public String getImprimeCapa() {
		return imprimeCapa;
	}

	public void setImprimeCapa(String imprimeCapa) {
		this.imprimeCapa = imprimeCapa;
	}

	public String getAtualizado() {
		return atualizado;
	}

	public void setAtualizado(String atualizado) {
		this.atualizado = atualizado;
	}

	public Date getDataQualInicial() {
		return dataQualInicial;
	}

	public void setDataQualInicial(Date dataQualInicial) {
		this.dataQualInicial = dataQualInicial;
	}

	public Date getDataQualFinal() {
		return dataQualFinal;
	}

	public void setDataQualFinal(Date dataQualFinal) {
		this.dataQualFinal = dataQualFinal;
	}

	public Integer getQtdQual() {
		return qtdQual;
	}

	public void setQtdQual(Integer qtdQual) {
		this.qtdQual = qtdQual;
	}

	public List<TrabalhoHIST> getTrabalhoHISTs() {
		return trabalhoHISTs;
	}

	public void setTrabalhoHISTs(List<TrabalhoHIST> trabalhoHISTs) {
		this.trabalhoHISTs = trabalhoHISTs;
	}

	public Date getDtUltimaPostagem() {
		return dtUltimaPostagem;
	}

	public void setDtUltimaPostagem(Date dtUltimaPostagem) {
		this.dtUltimaPostagem = dtUltimaPostagem;
	}

	public List<Expedicao> getExpedicao() {
		return Expedicao;
	}

	public void setExpedicao(List<Expedicao> expedicao) {
		Expedicao = expedicao;
	}

	public boolean isMostraBotao() {
			mostraBotao = botao();
		return mostraBotao;
	}

	public void setMostraBotao(boolean mostraBotao) {
		this.mostraBotao = mostraBotao;
	}
	
	public boolean botao(){
		if(trabalhoDETPK.getTrabalho().getDataPostagemWebConsult() == null || dtUltimaPostagem == null){
			return false;
		}
		
		//Alteracoes para verificar apenas o dia, assim setamos a hora como 00:00:00
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.setTime(trabalhoDETPK.getTrabalho().getDataPostagemWebConsult());
		dataInicio.set(Calendar.HOUR_OF_DAY, 0);
		dataInicio.set(Calendar.MINUTE, 0);
		dataInicio.set(Calendar.SECOND, 0);
		
		Calendar dataFim = Calendar.getInstance();
		dataFim.setTime(dtUltimaPostagem);
		dataFim.set(Calendar.HOUR_OF_DAY, 0);
		dataFim.set(Calendar.MINUTE, 0);
		dataFim.set(Calendar.SECOND, 0);
		
		if(dataFim.getTime().after(dataInicio.getTime())){
		   return true;
		}else{
		return false;
		}
	}
	
}
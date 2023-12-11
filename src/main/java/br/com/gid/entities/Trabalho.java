package br.com.gid.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="TRABALHOS")
public class Trabalho implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IDTRAB", nullable = false)
	private Integer id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumns({
			@JoinColumn(name="IDPRODUTO", referencedColumnName = "IDPRODUTO"), 
			@JoinColumn(name="IDCLIENTE", referencedColumnName = "IDCLIENTE")})
	private Produto produto;

	@Column(name = "ARQ")
	private String arquivo;

	@Column(name = "DIR_REFAZ")
	private String diretorioRefaz;
	
	@Column(name = "QTD")
	private Integer qtd;

	@Column(name = "DTPOSTAGEM")
	private Timestamp dataPostagem;

	@Column(name = "DTREC")
	private Timestamp dtRec;

	@Column(name = "IDREC")
	private Integer idRec;

	@Column(name = "DTI_PREPROC")
	private Timestamp dataInicioPreProc;

	@Column(name = "DTF_PREPROC")
	private Timestamp dataFimPreProc;

	@Column(name = "IDPREPROC")
	private Integer idPreProc;

	@Column(name = "DTF_SPOOL")
	private Timestamp dataFimSpool;
	
	@Column(name = "DTI_SPOOL")
	private Timestamp dataInicioSpool;
	
	@Column(name = "IDSPOOL")
	private Integer idSpool;

	@Column(name = "STATUS")
	private Integer status;

	@Column(name = "LOTE_CIF", length = 5)
	private String loteCIF;

	@Column(name = "ATUALIZADO", length = 1)
	private String atualizado;

	@Column(name = "DTLANCTO")
	private Date dataLancamento;
	
	@Column(name = "CONTROLE")
	private String controle;
	
	@Column(name = "COD_RELAT")
	private String codigoRelatorio;
	
	@Column(name = "JOBNAME")
	private String jobName;
	
	@Column(name = "NUM_LOTE")
	private String numeroLote;
	
	@Column(name = "TSLOTE")
	private String tsLote;
	
	@Column(name = "DT_POST")
	private Date dataPostagemWebConsult;
	
	@Column(name = "DRP")
	private String drp;
	
	@Column(name = "COD_SERV")
	private String codigoServico;
	
	@Column(name = "DT_POSTINI")
	private Timestamp dataIniPostagem;
	
	@Column(name = "DT_POSTFIM")
	private Timestamp dataFimPostagem;
	
	@Column(name = "QTD_POST")
	private Integer qtdPostada;
	
	@Transient
	private boolean mostraBotao;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trabalhoDETPK.trabalho", cascade = CascadeType.ALL) 
	private List<TrabalhoDET> trabalhoDETs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getDiretorioRefaz() {
		return diretorioRefaz;
	}

	public void setDiretorioRefaz(String diretorioRefaz) {
		this.diretorioRefaz = diretorioRefaz;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Timestamp getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Timestamp dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public Timestamp getDtRec() {
		return dtRec;
	}

	public void setDtRec(Timestamp dtRec) {
		this.dtRec = dtRec;
	}

	public Integer getIdRec() {
		return idRec;
	}

	public void setIdRec(Integer idRec) {
		this.idRec = idRec;
	}

	public Timestamp getDataInicioPreProc() {
		return dataInicioPreProc;
	}

	public void setDataInicioPreProc(Timestamp dataInicioPreProc) {
		this.dataInicioPreProc = dataInicioPreProc;
	}

	public Timestamp getDataFimPreProc() {
		return dataFimPreProc;
	}

	public void setDataFimPreProc(Timestamp dataFimPreProc) {
		this.dataFimPreProc = dataFimPreProc;
	}

	public Integer getIdPreProc() {
		return idPreProc;
	}

	public void setIdPreProc(Integer idPreProc) {
		this.idPreProc = idPreProc;
	}

	public Timestamp getDataFimSpool() {
		return dataFimSpool;
	}

	public void setDataFimSpool(Timestamp dataFimSpool) {
		this.dataFimSpool = dataFimSpool;
	}

	public Timestamp getDataInicioSpool() {
		return dataInicioSpool;
	}

	public void setDataInicioSpool(Timestamp dataInicioSpool) {
		this.dataInicioSpool = dataInicioSpool;
	}

	public Integer getIdSpool() {
		return idSpool;
	}

	public void setIdSpool(Integer idSpool) {
		this.idSpool = idSpool;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLoteCIF() {
		return loteCIF;
	}

	public void setLoteCIF(String loteCIF) {
		this.loteCIF = loteCIF;
	}

	public String getAtualizado() {
		return atualizado;
	}

	public void setAtualizado(String atualizado) {
		this.atualizado = atualizado;
	}

	public List<TrabalhoDET> getTrabalhoDETs() {
		return trabalhoDETs;
	}

	public void setTrabalhoDETs(List<TrabalhoDET> trabalhoDETs) {
		this.trabalhoDETs = trabalhoDETs;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getControle() {
		return controle;
	}

	public void setControle(String controle) {
		this.controle = controle;
	}

	public String getCodigoRelatorio() {
		return codigoRelatorio;
	}

	public void setCodigoRelatorio(String codigoRelatorio) {
		this.codigoRelatorio = codigoRelatorio;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

	public String getTsLote() {
		return tsLote;
	}

	public void setTsLote(String tsLote) {
		this.tsLote = tsLote;
	}

	public Date getDataPostagemWebConsult() {
		return dataPostagemWebConsult;
	}

	public void setDataPostagemWebConsult(Date dataPostagemWebConsult) {
		this.dataPostagemWebConsult = dataPostagemWebConsult;
	}

	public String getDrp() {
		return drp;
	}

	public void setDrp(String drp) {
		this.drp = drp;
	}

	public String getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(String codigoServico) {
		this.codigoServico = codigoServico;
	}
	
	public Timestamp getDataIniPostagem() {
		return dataIniPostagem;
	}

	public void setDataIniPostagem(Timestamp dataIniPostagem) {
		this.dataIniPostagem = dataIniPostagem;
	}
	
	public Timestamp getDataFimPostagem() {
		return dataFimPostagem;
	}

	public void setDataFimPostagem(Timestamp dataFimPostagem) {
		this.dataFimPostagem = dataFimPostagem;
	}

	public Integer getQtdPostada() {
		return qtdPostada;
	}

	public void setQtdPostada(Integer qtdPostada) {
		this.qtdPostada = qtdPostada;
	}

	public boolean isMostraBotao() {
		mostraBotao = botao();
		return mostraBotao;
	}

	public void setMostraBotao(boolean mostraBotao) {
		this.mostraBotao = mostraBotao;
	}
	
	public boolean botao(){
		if(dataPostagemWebConsult == null || dataFimPostagem == null){
			return false;
		}
		
		//Alteracoes para verificar apenas o dia, assim setamos a hora como 00:00:00
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.setTime(dataPostagemWebConsult);
		dataInicio.set(Calendar.HOUR_OF_DAY, 0);
		dataInicio.set(Calendar.MINUTE, 0);
		dataInicio.set(Calendar.SECOND, 0);
		
		Calendar dataFim = Calendar.getInstance();
		dataFim.setTime(dataFimPostagem);
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

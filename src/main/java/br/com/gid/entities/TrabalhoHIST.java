package br.com.gid.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="TRABALHOSHIST")
public class TrabalhoHIST implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;	
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumns({
		@JoinColumn(name="LOTE", referencedColumnName = "LOTE"),
		@JoinColumn(name="IDTRAB", referencedColumnName = "IDTRAB")
	})
	private TrabalhoDET trabalhoDET;

	@Column(name = "DTINI")
	private Timestamp dataIni;

	@Column(name = "DTFIM")
	private Timestamp dataFim;

	@Column(name = "LIDOS")
	private  int lidos;

	@Column(name = "RESTAM")
	private  int restam;

	@Column(name = "OBS")
	private  String obs;

	@Column(name = "USUARIO")
	private  String usuario;

	@Column(name = "MAQUINA")
	private  String maquina;

	@Column(name = "REFAZ")
	private  int refaz;

	@Column(name = "QTD_PROC")
	private  int qtdProcessada;

	@Column(name = "TURNO")
	private  int turno;

	@Column(name = "ETAPA")
	private  String etapa;

	@Column(name = "DURACAO")
	private  int duracao;

	public TrabalhoDET getTrabalhoDET() {
		return trabalhoDET;
	}

	public void setTrabalhoDET(TrabalhoDET trabalhoDET) {
		this.trabalhoDET = trabalhoDET;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDataIni() {
		return dataIni;
	}

	public void setDataIni(Timestamp dataIni) {
		this.dataIni = dataIni;
	}

	public Timestamp getDataFim() {
		return dataFim;
	}

	public void setDataFim(Timestamp dataFim) {
		this.dataFim = dataFim;
	}

	public int getLidos() {
		return lidos;
	}

	public void setLidos(int lidos) {
		this.lidos = lidos;
	}

	public int getRestam() {
		return restam;
	}

	public void setRestam(int restam) {
		this.restam = restam;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public int getRefaz() {
		return refaz;
	}

	public void setRefaz(int refaz) {
		this.refaz = refaz;
	}

	public int getQtdProcessada() {
		return qtdProcessada;
	}

	public void setQtdProcessada(int qtdProcessada) {
		this.qtdProcessada = qtdProcessada;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

}

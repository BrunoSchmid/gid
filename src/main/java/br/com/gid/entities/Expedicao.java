package br.com.gid.entities;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="EXPEDICAO")
public class Expedicao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;	
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumns({
		@JoinColumn(name="IDLOTE", referencedColumnName = "LOTE"),
		@JoinColumn(name="IDTRABALHO", referencedColumnName = "IDTRAB")
	})
	private TrabalhoDET trabalhoDET;
	
	@Column(name = "QUANTIDADE")
	private  int qtd;
	
	@Column(name = "DTINCLUSAO")
	private Date dataInclusao;
	
	@Column(name = "IDUSUARIO")
	private  int idUsuario;
	
	@Column(name = "MOTIVO")
	private  String motivo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TrabalhoDET getTrabalhoDET() {
		return trabalhoDET;
	}

	public void setTrabalhoDET(TrabalhoDET trabalhoDET) {
		this.trabalhoDET = trabalhoDET;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}

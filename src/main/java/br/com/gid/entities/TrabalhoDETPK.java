package br.com.gid.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TrabalhoDETPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "LOTE", nullable = false)
	private Integer lote;

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name="IDTRAB")
	private Trabalho trabalho;

	public Integer getLote() {
		return lote;
	}

	public void setLote(Integer lote) {
		this.lote = lote;
	}

	public Trabalho getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lote == null) ? 0 : lote.hashCode());
		result = prime * result + ((trabalho == null) ? 0 : trabalho.hashCode());
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
		TrabalhoDETPK other = (TrabalhoDETPK) obj;
		if (lote == null) {
			if (other.lote != null)
				return false;
		} else if (!lote.equals(other.lote))
			return false;
		if (trabalho == null) {
			if (other.trabalho != null)
				return false;
		} else if (!trabalho.equals(other.trabalho))
			return false;
		return true;
	}
}
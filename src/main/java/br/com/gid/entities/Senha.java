package br.com.gid.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="SENHAS")
@SequenceGenerator(name="SEQUENCIA", sequenceName="SEQ_USUARIO", allocationSize=1)
public class Senha implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDUSUARIO")
	private int idUsuario;

	@Column(name="USUARIO")
	private String usuario;
	
	@Column(name="SIGLA")
	private String sigla;

	@Column(name="SENHA")
	private Integer senha;

	@Column(name="ACESSO")
	private int acesso;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	public int getAcesso() {
		return acesso;
	}

	public void setAcesso(int acesso) {
		this.acesso = acesso;
	}

}

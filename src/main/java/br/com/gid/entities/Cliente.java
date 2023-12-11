package br.com.gid.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDCLIENTE")
	private Integer id;

	@Column(name="NOME", nullable = false, length = 50)
	private String nome;
	
	@Column(name="APELIDO", nullable = false, length = 20)
	private String apelido;
	
	@Column(name="CONTATO", length = 50)
	private String contato;
	
	@Column(name="ENDERECO", length = 50)
	private String endereco;
	
	@Column(name="BAIRRO", length = 25)
	private String bairro;
	
	@Column(name="CIDADE", length = 30)
	private String cidade;
	
	@Column(name="UF", length = 2)
	private String uf;

	@Column(name="CEP", length = 9)
	private String cep;
	
	@Column(name="TEL", length = 15)
	private String telefone;

	@Column(name="RAMAL", length = 10)
	private String ramal;

	@Column(name="CELULAR", length = 15)
	private String celular;

	@Column(name="FAX", length = 15)
	private String fax;

	@Column(name="RAMALF", length = 10)
	private String ramalFax;

	@Column(name="EMAIL", length = 50)
	private String email;

	@Column(name="COD_AUDIT", length = 2)
	private String codAudit;

	@Column(name="ATUALIZADO", length = 1)
	private String atualizado;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "produtoPK.cliente", cascade = CascadeType.ALL) 
	private List<Produto> produtos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getRamalFax() {
		return ramalFax;
	}

	public void setRamalFax(String ramalFax) {
		this.ramalFax = ramalFax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodAudit() {
		return codAudit;
	}

	public void setCodAudit(String codAudit) {
		this.codAudit = codAudit;
	}

	public String getAtualizado() {
		return atualizado;
	}

	public void setAtualizado(String atualizado) {
		this.atualizado = atualizado;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
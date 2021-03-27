package br.furb.bcc.bancosangue.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo_sanguineo")
public class Pessoa {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	private Integer idade;
	private String sexo;
	
	@ManyToOne
	private TipoSanguineo tipoSanguineo;
	
	
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
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}
	
	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}
	
	
}

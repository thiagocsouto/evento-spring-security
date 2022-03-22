package com.evento.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="evento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name ="nome")
	private String nome;  
	@Column(name ="local_evento")
	private String local;
	@Column(name ="data")
	private String data;
	@Column(name ="horario") 
	private String horario;
	
//	@OneToMany 
//	private List<Convidado> convidado;
	
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
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
//	public List<Convidado> getConvidado() {
//		return convidado;
//	}
//	public void setConvidado(List<Convidado> convidado) {
//		this.convidado = convidado;
//	}
	
	
	
	
	
	
	
	
}

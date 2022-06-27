package com.evento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="convidado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Convidado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id") 
	public Integer id;
	
	@NotBlank
	public String nome;
	
	@NotBlank
	public String rg;
	
	@NotNull
    public Integer idade;
	
	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;
	
}

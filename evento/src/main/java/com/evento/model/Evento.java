package com.evento.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="evento")
@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class Evento implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@NotBlank
	private String nome;  
	
	@Column(name ="local_evento")
	@NotBlank
	private String local;
	
	@NotBlank
	private String data;
	
	@NotBlank
	private String horario;
	
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	private List<Convidado> convidados;
	
}

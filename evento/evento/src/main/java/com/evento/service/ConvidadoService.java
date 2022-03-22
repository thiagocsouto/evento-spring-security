package com.evento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evento.model.Convidado;
import com.evento.model.Evento;
import com.evento.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	public Convidado salvarConvidado(Convidado convidado){
		return convidadoRepository.save(convidado);
	}
	
	public List<Convidado> listarConvidado() {
		return convidadoRepository.findAll();
	}
	
	public Optional<Convidado> listarConvidadoId(Integer id) {
		return convidadoRepository.findById(id);
	}

	public void deletarIdConvidado(Integer id) {
	    convidadoRepository.deleteById(id);
	}

	
}

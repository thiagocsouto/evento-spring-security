package com.evento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evento.model.Evento;
import com.evento.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public Evento salvarEvento(Evento evento){
		return eventoRepository.save(evento);
	} 

	public List<Evento> listarEvento() {
		return eventoRepository.findAll();
		
	}

	public Optional<Evento> listarEventoId(Integer id) {
		return eventoRepository.findById(id);
	}

	public void deletarId(Integer id) { 
		 eventoRepository.deleteById(id);
	}

}

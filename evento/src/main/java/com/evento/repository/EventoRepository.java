package com.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evento.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer>{

}

package com.evento.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.evento.model.Convidado;
import com.evento.model.Evento;

import com.evento.service.EventoService;

@Controller
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	
	@GetMapping("/cadastrar-eventos")
	public ModelAndView formulario(Evento evento) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("evento/formulario");
		mv.addObject("evento", new Evento());  
		return mv;  
	}
	
	@PostMapping("/cadastrar-eventos")
	public ModelAndView cadastro(@Valid Evento evento, BindingResult result) {
		ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
        	mv.setViewName("evento/formulario");
    		mv.addObject(evento);
			return mv;
		}
		mv.setViewName("redirect:/listar-eventos");
		eventoService.salvarEvento(evento);
		return mv;  
	}
	
	@GetMapping("/excluir-eventos/{id}")
	public String excluirEvento(@PathVariable("id") Integer id) {
		eventoService.deletarId(id);
		return "redirect:/listar-eventos";
	} 
	
	@GetMapping("/listar-eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("evento/listaEventos");
		mv.addObject("listarConvidados", eventoService.listarEvento());
		return mv;  
	} 
	
	@GetMapping("/alterar-eventos/{id}")
	public ModelAndView alterarEvento(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("evento/alterarEventos");
		Optional<Evento> evento = eventoService.listarEventoId(id);
		mv.addObject("evento", evento);  
		return mv;  
	}
	
	@PostMapping("/alterar-eventos")
	public ModelAndView alterarEventos(@Valid Evento evento, BindingResult result) {
		ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
        	mv.setViewName("evento/alterarEventos");
    		mv.addObject(evento);
			return mv;
		}
		mv.setViewName("redirect:/listar-eventos");
		eventoService.salvarEvento(evento);
		return mv;  
	}
	
	
//	@GetMapping("/{id}")
//	public ModelAndView detalhesEventosId(@PathVariable("id") Integer id) {
//		Optional<Evento> evento = eventoService.listarEventoId(id);
//		ModelAndView mv = new ModelAndView("detalhes");
//		mv.addObject("evento", evento);
//		return mv;  
//	}


}

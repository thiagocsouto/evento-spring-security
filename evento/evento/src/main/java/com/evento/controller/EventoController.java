package com.evento.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.evento.model.Convidado;
import com.evento.model.Evento;
import com.evento.repository.EventoRepository;
import com.evento.service.ConvidadoService;
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
	public ModelAndView cadastro(Evento evento) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("evento/formulario");
		mv.addObject(evento);
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
	
//	@GetMapping("/{id}")
//	public ModelAndView detalhesEventosId(@PathVariable("id") Integer id) {
//		Optional<Evento> evento = eventoService.listarEventoId(id);
//		ModelAndView mv = new ModelAndView("detalhes");
//		mv.addObject("evento", evento);
//		return mv;  
//	}


}

package com.evento.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.evento.model.Convidado;
import com.evento.service.ConvidadoService;

@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadoService convidadoService;
	
	@GetMapping("/adicionar-convidados")
	public ModelAndView Adicionar(Convidado convidado) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("convidado/adicionarConvidados");
		mv.addObject("convidado", new Convidado()); 
		return mv;  
	}
	 
	@PostMapping("/adicionar-convidados")
	public ModelAndView AdicionarConvidado(Convidado convidado) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("convidado/adicionarConvidados");
		mv.addObject(convidado);
		mv.setViewName("redirect:/lista-convidados");
		convidadoService.salvarConvidado(convidado);
		return mv;   
	}
	
	@GetMapping("/lista-convidados")
	public ModelAndView listaConvidados() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("convidado/listaConvidados");
		mv.addObject("listarConvidado", convidadoService.listarConvidado());
		return mv;   
	} 
	
	@GetMapping("/excluir-convidados/{id}")
	public String excluirConvidado(@PathVariable("id") Integer id) {
		convidadoService.deletarIdConvidado(id);
		return "redirect:/lista-convidados";
	}

}

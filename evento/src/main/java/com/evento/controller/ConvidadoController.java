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
	public ModelAndView AdicionarConvidado(@Valid Convidado convidado, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		 if (result.hasErrors()) {
				mv.setViewName("convidado/adicionarConvidados");
				mv.addObject(convidado); 
				return mv;
		 }

		 
		convidadoService.salvarConvidado(convidado);
		mv.setViewName("redirect:/lista-convidados");
		return mv;   
	}
	
	@GetMapping("/lista-convidados")
	public ModelAndView listaConvidados() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("convidado/listaConvidados");
		mv.addObject("listarConvidado", convidadoService.listarConvidado());
		return mv;   
	} 
	
	@GetMapping("/alterar-convidados/{id}")
	public ModelAndView alterarConvidado(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("convidado/alterarConvidados");
		Optional<Convidado> convidado = convidadoService.listarConvidadoId(id);
		mv.addObject("convidado", convidado); 
		return mv;  
	}
	 
	@PostMapping("/alterar-convidados")
	public ModelAndView alterarConvidado(@Valid Convidado convidado, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		 if (result.hasErrors()) {
				mv.setViewName("convidado/alterarConvidados");
				mv.addObject(convidado); 
				return mv;
		 }
		convidadoService.salvarConvidado(convidado);
		mv.setViewName("redirect:/lista-convidados");
		return mv;   
	}
	
	@GetMapping("/excluir-convidados/{id}")
	public String excluirConvidado(@PathVariable("id") Integer id) {
		convidadoService.deletarIdConvidado(id);
		return "redirect:/lista-convidados";
	}

}

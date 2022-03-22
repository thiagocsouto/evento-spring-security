package com.evento.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.evento.model.Evento;
import com.evento.model.Usuario;
import com.evento.repository.UsuarioRepository;


@Controller
public class UsuarioController {
	
	@Autowired
	private UserDetailsService usuarioService;
	
	@GetMapping("/login") 
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login");
		mv.addObject("usuario", new Usuario());  
		return mv;    
	}
	
	
	@GetMapping("/home") 
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		mv.addObject("usuario", new Usuario());  
		return mv;   
	}
	
	@GetMapping("/adm/home") 
	public ModelAndView indexAdm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		mv.addObject("usuario", new Usuario());  
		return mv;   
	}
	
	
}
	
	
	



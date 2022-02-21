package com.IntegradorCBS.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.IntegradorCBS.models.Cliente;
import com.IntegradorCBS.repository.ClienteRepository;

@Controller
public class InicioController {
	
	
	//GET
	@RequestMapping("/inicioManutencao")
	public ModelAndView abrirManutencao() {
		ModelAndView mv = new ModelAndView("form-manutencao");
		return mv;
	}
	
	//GET
	@RequestMapping("/inicioGestao")
	public ModelAndView abrirGestao() {
		ModelAndView mv = new ModelAndView("form-gestao");
		return mv;
	}

}

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

import com.IntegradorCBS.models.Estado;
import com.IntegradorCBS.repository.EstadoRepository;

@Controller
public class EstadoController {
	
	@Autowired
	private EstadoRepository er;
	
	// GET que chama o form para cadastrar estado
	@RequestMapping("/cadastrarEstado")
	public String form() {
		return "estado/form-estado";
	}
	
	// POST que cadastra o estado
	@RequestMapping(value = "/cadastrarEstado", method = RequestMethod.POST)
	public String form(@Valid Estado estado, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarEstado";
		}
		
		if(er.findBySigla(estado.getSigla()) != null) {
			attributes.addFlashAttribute("mensagem_erro", "Sigla já cadastrada");
			return "redirect:/cadastrarEstado";
		}

		er.save(estado);
		attributes.addFlashAttribute("mensagem", "Estado cadastrado com sucesso!");
		return "redirect:/cadastrarEstado";
	}
		
	// GET que lista Estados
	@RequestMapping("/estados")
	public ModelAndView listaEstados() {
		ModelAndView mv = new ModelAndView("estado/lista-estado");
		Iterable<Estado> estados = er.findAll();
		mv.addObject("estados", estados);
		return mv;
	}
		
	// GET que lista detalhes dos estados
	@RequestMapping("/detalhes-estado/{id}")
	public ModelAndView detalhesEstado(@PathVariable("id") long id) {
		Estado estado = er.findById(id);
		ModelAndView mv = new ModelAndView("estado/detalhes-estado");
		mv.addObject("estados", estado);

		return mv;
	}
		
	//GET que deleta estado
	@RequestMapping("/deletarEstado")
	public String deletarEstado(long id) {
		Estado estado = er.findById(id);
		er.delete(estado);
		return "redirect:/estados";
		
	}
	
	// Métodos que atualiza estados
	// GET que chama o FORM de edição do estado
	@RequestMapping("/editar-estado")
	public ModelAndView editarEstado(long id) {
		Estado estado = er.findById(id);
		ModelAndView mv = new ModelAndView("estado/update-estado");
		mv.addObject("estado", estado);
		return mv;
	}
		
	// POST que atualiza os estados
	@RequestMapping(value = "/editar-estado", method = RequestMethod.POST)
	public String updateEstado(@Valid Estado estado,  BindingResult result, RedirectAttributes attributes){
		
		er.save(estado);
		attributes.addFlashAttribute("success", "Estado alterado com sucesso!");
		
		long idLong = estado.getId();
		String id = "" + idLong;
		return "redirect:/detalhes-estado/" + id;
		
	}

}

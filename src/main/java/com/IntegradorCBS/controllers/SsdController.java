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

import com.IntegradorCBS.models.Ssd;
import com.IntegradorCBS.repository.SsdRepository;

@Controller
public class SsdController {
	
	@Autowired
	private SsdRepository sr;
	
	// GET que chama o form para cadastrar ssd
	@RequestMapping("/cadastrarSsd")
	public String form() {
		return "ssd/form-ssd";
	}
	
	// POST que cadastra ssd
	@RequestMapping(value = "/cadastrarSsd", method = RequestMethod.POST)
	public String form(@Valid Ssd ssd, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarSsd";
		}

		//if(sr.findByCpfcnpj(cliente.getCpfcnpj()) != null) {
		//	attributes.addFlashAttribute("mensagem_erro", "CPF ou CNPJ duplicado");
		//	return "redirect:/cadastrarCliente";
		//}

		sr.save(ssd);
		attributes.addFlashAttribute("mensagem", "SSD cadastrado com sucesso!");
		return "redirect:/cadastrarSsd";
	}
	
	// GET que lista SSD
	@RequestMapping("/ssds")
	public ModelAndView listaSsds() {
		ModelAndView mv = new ModelAndView("ssd/lista-ssd");
		Iterable<Ssd> ssds = sr.findAll();
		mv.addObject("ssds", ssds);
		return mv;
	}
	
	// GET que lista detalhes do SSd
	@RequestMapping("/detalhes-ssd/{id}")
	public ModelAndView detalhesSsd(@PathVariable("id") long id) {
		Ssd ssd = sr.findById(id);
		ModelAndView mv = new ModelAndView("ssd/detalhes-ssd");
		mv.addObject("ssds", ssd);

		return mv;

	}
	
	//GET que deleta SSD
	@RequestMapping("/deletarSsd")
	public String deletarSsd(long id) {
		Ssd ssd = sr.findById(id);
		sr.delete(ssd);
		return "redirect:/ssds";
		
	}
	
	// Métodos que atualiza SSD
	// GET que chama o FORM de edição do SSD
	@RequestMapping("/editar-ssd")
	public ModelAndView editarSsd(long id) {
		Ssd ssd = sr.findById(id);
		ModelAndView mv = new ModelAndView("ssd/update-ssd");
		mv.addObject("ssd", ssd);
		return mv;
	}
	
	// POST que atualiza os SSD
	@RequestMapping(value = "/editar-ssd", method = RequestMethod.POST)
	public String updateSsd(@Valid Ssd ssd,  BindingResult result, RedirectAttributes attributes){
		
		sr.save(ssd);
		attributes.addFlashAttribute("success", "SSD alterado com sucesso!");
		
		long idLong = ssd.getId();
		String id = "" + idLong;
		return "redirect:/detalhes-ssd/" + id;
		
	}


}

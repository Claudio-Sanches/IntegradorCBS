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
import com.IntegradorCBS.models.Pedido;
import com.IntegradorCBS.repository.ClienteRepository;
import com.IntegradorCBS.repository.PedidoRepository;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoRepository pr;
	
	// GET que chama o form para cadastrar pedido
	@RequestMapping("/cadastrarPedido")
	public String form() {
		return "pedido/form-pedido";
	}
	
	// POST que cadastra pedido
	@RequestMapping(value = "/cadastrarPedido", method = RequestMethod.POST)
	public String form(@Valid Pedido pedido, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarPedido";
		}

		//if(cr.findByCpfcnpj(cliente.getCpfcnpj()) != null) {
		//	attributes.addFlashAttribute("mensagem_erro", "CPF ou CNPJ duplicado");
		//	return "redirect:/cadastrarCliente";
		//}

		pr.save(pedido);
		attributes.addFlashAttribute("mensagem", "Pedido cadastrado com sucesso!");
		return "redirect:/cadastrarPedido";
	}
	
	// GET que lista Pedidos
	@RequestMapping("/pedidos")
	public ModelAndView listaPedidos() {
		ModelAndView mv = new ModelAndView("pedido/lista-pedido");
		Iterable<Pedido> pedidos = pr.findAll();
		mv.addObject("pedidos", pedidos);
		return mv;
	}
	
	// GET que lista detalhes do Pedido
	@RequestMapping("/detalhes-pedido/{id}")
	public ModelAndView detalhesPedido(@PathVariable("id") long id) {
		Pedido pedido = pr.findById(id);
		ModelAndView mv = new ModelAndView("pedido/detalhes-pedido");
		mv.addObject("pedidos", pedido);

		return mv;

	}

	//GET que deleta Pedidos
	@RequestMapping("/deletarPedido")
	public String deletarPedido(long id) {
		Pedido pedido = pr.findById(id);
		pr.delete(pedido);
		return "redirect:/pedidos";
			
	}
		
	// Métodos que atualiza Pedidos
	// GET que chama o FORM de edição do pedido
	@RequestMapping("/editar-pedido")
	public ModelAndView editarPedido(long id) {
		Pedido pedido = pr.findById(id);
		ModelAndView mv = new ModelAndView("pedido/update-pedido");
		mv.addObject("pedido", pedido);
		return mv;
	}
		
	// POST que atualiza os Pedidos
	@RequestMapping(value = "/editar-pedido", method = RequestMethod.POST)
	public String updatePedido(@Valid Pedido pedido,  BindingResult result, RedirectAttributes attributes){
			
		pr.save(pedido);
		attributes.addFlashAttribute("success", "Pedido alterado com sucesso!");
			
		long idLong = pedido.getId();
		String id = "" + idLong;
		return "redirect:/detalhes-pedido/" + id;
		
	}

}

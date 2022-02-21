package com.IntegradorCBS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.IntegradorCBS.models.Cliente;
import com.IntegradorCBS.models.Estado;
import com.IntegradorCBS.models.Memoria;
import com.IntegradorCBS.models.Produto;
import com.IntegradorCBS.models.Ssd;

import com.IntegradorCBS.repository.ClienteRepository;
import com.IntegradorCBS.repository.PedidoRepository;
import com.IntegradorCBS.repository.EstadoRepository;
import com.IntegradorCBS.repository.SsdRepository;

@Controller
public class BuscaController {

	@Autowired
	private ClienteRepository cr;

	@Autowired
	private PedidoRepository pr;

	@Autowired
	private EstadoRepository er;

	@Autowired
	private SsdRepository sr;

	// GET em form Gestão
	@RequestMapping(value = "/inicioGestao", method = RequestMethod.GET)
	public ModelAndView abrirGestao() {
		ModelAndView mv = new ModelAndView("form-gestao");
		return mv;
	}

	// POST em form Gestão
	@RequestMapping(value = "/inicioGestao", method = RequestMethod.POST)
	public ModelAndView buscarGestao(@RequestParam("buscar") String buscar, @RequestParam("nome") String nome) {

		ModelAndView mv = new ModelAndView("form-gestao");
		String mensagem = "Resultados da busca por " + buscar;

		if (nome.equals("nomecliente")) {
			mv.addObject("clientes", cr.findByNomes(buscar));

		} else if (nome.equals("nomepedido")) {
			mv.addObject("pedidos", pr.findByCliente(buscar));

		} else {
			mv.addObject("clientes", cr.findByNomes(buscar));
			mv.addObject("pedidos", pr.findByCliente(buscar));
		}

		mv.addObject("mensagem", mensagem);

		return mv;
	}

	// GET em form Manutenção
	@RequestMapping(value = "/inicioManutencao", method = RequestMethod.GET)
	public ModelAndView abrirManutencao() {
		ModelAndView mv = new ModelAndView("form-manutencao");
		return mv;
	}

	// POST em form Manutenção
	@RequestMapping(value = "/inicioManutencao", method = RequestMethod.POST)
	public ModelAndView buscarManutencao(@RequestParam("buscar") String buscar, @RequestParam("nome") String nome) {

		ModelAndView mv = new ModelAndView("form-manutencao");
		String mensagem = "Resultados da busca por " + buscar;

		if (nome.equals("nomeestado")) {
			mv.addObject("estado", er.findBydescricao(buscar));

		}else if(nome.equals("nomessd")) {
			 mv.addObject("ssds", sr.findBydescricaoSsds(buscar));

		}else {
			mv.addObject("estado", er.findBydescricao(buscar));
			mv.addObject("ssds", sr.findBydescricaoSsds(buscar));
		}

		mv.addObject("mensagem", mensagem);

		return mv;
	}

}

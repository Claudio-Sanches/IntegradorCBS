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
import com.IntegradorCBS.models.Opedido;

import com.IntegradorCBS.repository.ClienteRepository;
import com.IntegradorCBS.repository.OpedidoRepository;
import com.IntegradorCBS.repository.EstadoRepository;
import com.IntegradorCBS.repository.SsdRepository;
import com.IntegradorCBS.repository.MemoriaRepository;
import com.IntegradorCBS.repository.ProdutoRepository;
import com.IntegradorCBS.repository.KarrinhoRepository;

@Controller
public class BuscaController {

	@Autowired
	private ClienteRepository cr;

	@Autowired
	private OpedidoRepository or;

	@Autowired
	private EstadoRepository er;

	@Autowired
	private SsdRepository sr;

	@Autowired
	private MemoriaRepository mr;

	@Autowired
	private ProdutoRepository pr;

	@Autowired
	private KarrinhoRepository kr;

	// GET em form Gestão
	@RequestMapping(value = "/inicioGestao", method = RequestMethod.GET)
	public ModelAndView abrirGestao() {
		ModelAndView mv = new ModelAndView("form-gestao");
		return mv;
	}

	// POST em form Gestão
	@RequestMapping(value = "/inicioGestao", method = RequestMethod.POST)
	public ModelAndView buscarGestao(@RequestParam("buscarGes") String buscarGes, @RequestParam("nomeGes") String nomeGes) {

		ModelAndView mv = new ModelAndView("form-gestao");
		String mensagem = "Resultados da busca por " + buscarGes;

		if (nomeGes.equals("nomecliente")) {
			mv.addObject("clientes", cr.findByClientes(buscarGes));

		}else if (nomeGes.equals("nomecarrinho")) {
			mv.addObject("karrinhos", kr.findByclienteKarrinho(buscarGes));

		} else if (nomeGes.equals("nomeopedido")) {
			mv.addObject("opedidos", or.findBydescOpedido(buscarGes));

		} else {
			mv.addObject("clientes", cr.findByClientes(buscarGes));
			mv.addObject("opedidos", or.findBydescOpedido(buscarGes));
			mv.addObject("karrinhos", kr.findByclienteKarrinho(buscarGes));
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
			mv.addObject("estados", er.findBySiglas(buscar));

		}else if(nome.equals("nomessd")) {
			mv.addObject("ssds", sr.findBydescricaoSsd(buscar));

		}else if(nome.equals("nomememoria")) {
			mv.addObject("memorias", mr.findBydescricaoMemoria(buscar));

		}else if(nome.equals("nomeproduto")) {
			mv.addObject("produtos", pr.findByaplicacao(buscar));

		}else {
			mv.addObject("estados", er.findBySiglas(buscar));
			mv.addObject("ssds", sr.findBydescricaoSsd(buscar));
			mv.addObject("memorias", mr.findBydescricaoMemoria(buscar));
			mv.addObject("produtos", pr.findByaplicacao(buscar));
		}

		mv.addObject("mensagem", mensagem);

		return mv;
	}

}

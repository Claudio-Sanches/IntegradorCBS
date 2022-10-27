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

import com.IntegradorCBS.models.Memoria;
import com.IntegradorCBS.models.Opedido;
import com.IntegradorCBS.repository.OpedidoRepository;

@Controller
public class OpedidoController {

    @Autowired
    private OpedidoRepository or;

    // GET que chama o form para cadastrar Pedido
    @RequestMapping("/cadastrarOpedido")
    public String form() {
        return "pedido/form-pedido";
    }

    // POST que cadastra pedido
    @RequestMapping(value = "/cadastrarOpedido", method = RequestMethod.POST)
    public String form(@Valid Opedido opedido, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            return "redirect:/cadastrarOpedido";
        }

        or.save(opedido);
        attributes.addFlashAttribute("mensagem", "Pedido cadastrado com sucesso!");
        return "redirect:/cadastrarOpedido";
    }

    // GET que lista Pedidos
    @RequestMapping("/opedidos")
    public ModelAndView listaOpedidos() {
        ModelAndView mv = new ModelAndView("pedido/lista-pedido");
        Iterable<Opedido> opedidos = or.findAll();
        mv.addObject("opedidos", opedidos);
        return mv;
    }

    // GET que lista detalhes do pedido
    @RequestMapping("/detalhes-pedido/{id}")
    public ModelAndView detalhesOpedido(@PathVariable("id") long id) {
        Opedido opedido = or.findById(id);
        ModelAndView mv = new ModelAndView("pedido/detalhes-pedido");
        mv.addObject("opedidos", opedido);

        return mv;

    }

    //GET que deleta Pedido
    @RequestMapping("/deletarOpedido")
    public String deletarOpedido(long id) {
        Opedido opedido = or.findById(id);
        or.delete(opedido);
        return "redirect:/opedidos";

    }

    // Métodos que atualiza Pedido
    // GET que chama o FORM de edição do pedido
    @RequestMapping("/editar-pedido")
    public ModelAndView editarOpedido(long id) {
        Opedido opedido = or.findById(id);
        ModelAndView mv = new ModelAndView("pedido/update-pedido");
        mv.addObject("opedido", opedido);
        return mv;
    }

    // POST que atualiza os pedidos
    @RequestMapping(value = "/editar-pedido", method = RequestMethod.POST)
    public String updateOpedido(@Valid Opedido opedido,  BindingResult result, RedirectAttributes attributes){

        or.save(opedido);
        attributes.addFlashAttribute("success", "Pedido alterado com sucesso!");

        long idLong = opedido.getId();
        String id = "" + idLong;
        return "redirect:/detalhes-pedido/" + id;

    }

}


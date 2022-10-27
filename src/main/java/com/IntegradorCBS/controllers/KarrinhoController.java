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

import com.IntegradorCBS.models.Karrinho;
import com.IntegradorCBS.repository.KarrinhoRepository;

@Controller
public class KarrinhoController {

    @Autowired
    private KarrinhoRepository kr;

    // GET que chama o form para cadastrar Carrinho
    @RequestMapping("/cadastrarKarrinho")
    public String form() {
        return "carrinho/form-carrinho";
    }

    // POST que cadastra carrinho
    @RequestMapping(value = "/cadastrarKarrinho", method = RequestMethod.POST)
    public String form(@Valid Karrinho karrinho, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            return "redirect:/cadastrarKarrinho";
        }

        kr.save(karrinho);
        attributes.addFlashAttribute("mensagem", "Carrinho cadastrado com sucesso!");
        return "redirect:/cadastrarKarrinho";
    }

    // GET que lista Carrinho
    @RequestMapping("/karrinhos")
    public ModelAndView listaKarrinho() {
        ModelAndView mv = new ModelAndView("carrinho/lista-carrinho");
        Iterable<Karrinho> karrinhos = kr.findAll();
        mv.addObject("karrinhos", karrinhos);
        return mv;
    }

    // GET que lista detalhes do Carrinho
    @RequestMapping("/detalhes-carrinho/{id}")
    public ModelAndView detalhesKarrinho(@PathVariable("id") long id) {
        Karrinho karrinho = kr.findById(id);
        ModelAndView mv = new ModelAndView("carrinho/detalhes-carrinho");
        mv.addObject("karrinhos", karrinho);

        return mv;

    }

    //GET que deleta Carrinho
    @RequestMapping("/deletarKarrinho")
    public String deletarKarrinho(long id) {
        Karrinho karrinho = kr.findById(id);
        kr.delete(karrinho);
        return "redirect:/karrinhos";

    }

    // Métodos que atualiza Karrinho
    // GET que chama o FORM de edição do Karrinho
    @RequestMapping("/editar-carrinho")
    public ModelAndView editarKarrinho(long id) {
        Karrinho karrinho = kr.findById(id);
        ModelAndView mv = new ModelAndView("carrinho/update-carrinho");
        mv.addObject("karrinho", karrinho);
        return mv;
    }

    // POST que atualiza os Carrinhos
    @RequestMapping(value = "/editar-carrinho", method = RequestMethod.POST)
    public String updateKarrinho(@Valid Karrinho karrinho,  BindingResult result, RedirectAttributes attributes){

        kr.save(karrinho);
        attributes.addFlashAttribute("success", "Carrinho alterado com sucesso!");

        long idLong = karrinho.getId();
        String id = "" + idLong;
        return "redirect:/detalhes-carrinho/" + id;

    }

}


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
import com.IntegradorCBS.models.Tabela;
import com.IntegradorCBS.repository.TabelaRepository;

@Controller
public class TabelaController {

    @Autowired
    private TabelaRepository tr;

    // GET que lista Tabela de Preço
    @RequestMapping("/tabelas")
    public ModelAndView listaTabelas() {
        ModelAndView mv = new ModelAndView("tabela/lista-tabela");
        Iterable<Tabela> tabelas = tr.findAll();
        mv.addObject("tabelas", tabelas);
        return mv;
    }

    // GET que lista detalhes da tabela de Precos
    @RequestMapping("/detalhes-tabela/{id}")
    public ModelAndView detalhesTabela(@PathVariable("id") long id) {
        Tabela tabela = tr.findById(id);
        ModelAndView mv = new ModelAndView("tabela/detalhes-tabela");
        mv.addObject("tabelas", tabela);
        return mv;
    }

    //GET que deleta Tabela
    @RequestMapping("/deletarTabela")
    public String deletarTabela(long id) {
        Tabela tabela = tr.findById(id);
        tr.delete(tabela);
        return "redirect:/tabelas";
    }

    // Métodos que atualiza Tabela
    // GET que chama o FORM de edição da tabela
    @RequestMapping("/editar-tabela")
    public ModelAndView editarTabela(long id) {
        Tabela tabela = tr.findById(id);
        ModelAndView mv = new ModelAndView("tabela/update-tabela");
        mv.addObject("tabela", tabela);
        return mv;
    }

    // POST que atualiza as tabelas
    @RequestMapping(value = "/editar-tabela", method = RequestMethod.POST)
    public String updateTabela(@Valid Tabela tabela,  BindingResult result, RedirectAttributes attributes){

        tr.save(tabela);
        attributes.addFlashAttribute("success", "Tabela alterada com sucesso!");

        long idLong = tabela.getId();
        String id = "" + idLong;
        return "redirect:/detalhes-tabela/" + id;

    }

}


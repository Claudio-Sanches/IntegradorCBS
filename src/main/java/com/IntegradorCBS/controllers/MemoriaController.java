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
import com.IntegradorCBS.repository.MemoriaRepository;

@Controller
public class MemoriaController {

    @Autowired
    private MemoriaRepository mr;

    // GET que chama o form para cadastrar memoria
    @RequestMapping("/cadastrarMemoria")
    public String form() {
        return "memoria/form-memoria";
    }

    // POST que cadastra memoria
    @RequestMapping(value = "/cadastrarMemoria", method = RequestMethod.POST)
    public String form(@Valid Memoria memoria, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            return "redirect:/cadastrarMemoria";
        }

        mr.save(memoria);
        attributes.addFlashAttribute("mensagem", "Memoria cadastrada com sucesso!");
        return "redirect:/cadastrarMemoria";
    }

    // GET que lista Memoria
    @RequestMapping("/memorias")
    public ModelAndView listaMemorias() {
        ModelAndView mv = new ModelAndView("memoria/lista-memoria");
        Iterable<Memoria> memorias = mr.findAll();
        mv.addObject("memorias", memorias);
        return mv;
    }

    // GET que lista detalhes da memoria
    @RequestMapping("/detalhes-memoria/{id}")
    public ModelAndView detalhesMemoria(@PathVariable("id") long id) {
        Memoria memoria = mr.findById(id);
        ModelAndView mv = new ModelAndView("memoria/detalhes-memoria");
        mv.addObject("memorias", memoria);

        return mv;

    }

    //GET que deleta Memoria
    @RequestMapping("/deletarMemoria")
    public String deletarMemoria(long id) {
        Memoria memoria = mr.findById(id);
        mr.delete(memoria);
        return "redirect:/memorias";

    }

    // Métodos que atualiza Memoria
    // GET que chama o FORM de edição da Memoria
    @RequestMapping("/editar-memoria")
    public ModelAndView editarMemoria(long id) {
        Memoria memoria = mr.findById(id);
        ModelAndView mv = new ModelAndView("memoria/update-memoria");
        mv.addObject("memoria", memoria);
        return mv;
    }

    // POST que atualiza as memorias
    @RequestMapping(value = "/editar-memoria", method = RequestMethod.POST)
    public String updateMemoria(@Valid Memoria memoria,  BindingResult result, RedirectAttributes attributes){

        mr.save(memoria);
        attributes.addFlashAttribute("success", "Memoria alterada com sucesso!");

        long idLong = memoria.getId();
        String id = "" + idLong;
        return "redirect:/detalhes-memoria/" + id;

    }

}


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

import com.IntegradorCBS.models.Produto;
import com.IntegradorCBS.repository.ProdutoRepository;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository pr;

    // GET que chama o form para cadastrar produto
    @RequestMapping("/cadastrarProduto")
    public String form() {
        return "produto/form-produto";
    }

    // POST que cadastra produto
    @RequestMapping(value = "/cadastrarProduto", method = RequestMethod.POST)
    public String form(@Valid Produto produto, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            return "redirect:/cadastrarProduto";
        }

        pr.save(produto);
        attributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso!");
        return "redirect:/cadastrarProduto";
    }

    // GET que lista Produtos
    @RequestMapping("/produtos")
    public ModelAndView listaProdutos() {
        ModelAndView mv = new ModelAndView("produto/lista-produto");
        Iterable<Produto> produtos = pr.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }

    // GET que lista detalhes do produto
    @RequestMapping("/detalhes-produto/{id}")
    public ModelAndView detalhesProduto(@PathVariable("id") long id) {
        Produto produto = pr.findById(id);
        ModelAndView mv = new ModelAndView("produto/detalhes-produto");
        mv.addObject("produtos", produto);

        return mv;

    }

    //GET que deleta Produtos
    @RequestMapping("/deletarProduto")
    public String deletarProduto(long id) {
        Produto produto = pr.findById(id);
        pr.delete(produto);
        return "redirect:/produtos";

    }

    // Métodos que atualiza Produtos
    // GET que chama o FORM de edição do produto
    @RequestMapping("/editar-produto")
    public ModelAndView editarProduto(long id) {
        Produto produto = pr.findById(id);
        ModelAndView mv = new ModelAndView("produto/update-produto");
        mv.addObject("produto", produto);
        return mv;
    }

    // POST que atualiza os Produtos
    @RequestMapping(value = "/editar-produto", method = RequestMethod.POST)
    public String updateProduto(@Valid Produto produto,  BindingResult result, RedirectAttributes attributes){

        pr.save(produto);
        attributes.addFlashAttribute("success", "Produto alterado com sucesso!");

        long idLong = produto.getId();
        String id = "" + idLong;
        return "redirect:/detalhes-produto/" + id;

    }

}


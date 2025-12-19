package com.URBX.URBX.Controller;

import com.URBX.URBX.Model.Produto;
import com.URBX.URBX.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.math.BigDecimal;

@Controller
@RequestMapping("/URBX-produto")
public class HomeController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "URBX-produto";
    }

    @GetMapping("/novo")
    public String novoProduto(Model model) {
        Produto produto = new Produto();
        model.addAttribute("produto", produto);
        return "URBX-Form-Produto";
    }

    @PostMapping("/salvar")
    public String salvarProduto(Produto produto, Model model) {

        boolean temErro = false;

        if (produto.getNomeProdutoURBX() == null || produto.getNomeProdutoURBX().isBlank()) {
            model.addAttribute("erroNome", "Nome do produto é obrigatório");
            temErro = true;
        }

        if (produto.getTipoProdutoURBX() == null || produto.getTipoProdutoURBX().isBlank()) {
            model.addAttribute("erroTipo", "Tipo do produto é obrigatório");
            temErro = true;
        }


        if (produto.getPrecoProdutoURBX() == null || produto.getPrecoProdutoURBX().compareTo(BigDecimal.ZERO) <= 0) {
            model.addAttribute("erroPreco", "preço deve ser maior que zero");
            temErro = true;
        }

        if (temErro) {
            model.addAttribute("produto", produto);
            return "URBX-Form-Produto";
        }

        produtoRepository.save(produto);
        return "redirect:/URBX-produto";
    }

    @GetMapping("/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        model.addAttribute("produto", produto);
        return "URBX-Form-Produto";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
        return "redirect:/URBX-produto";
    }
}

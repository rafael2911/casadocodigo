package br.com.alura.spring.casadocodigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.spring.casadocodigo.dao.Banco;
import br.com.alura.spring.casadocodigo.entity.Produto;
import br.com.alura.spring.casadocodigo.entity.TipoStatus;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	Banco banco;
	
	@GetMapping(value= {"", "/", "/index"})
	public ModelAndView listar(ModelMap modelMap) {
		List<Produto> produtos = banco.listProdutos();
		modelMap.addAttribute("produtos", produtos);
		return new ModelAndView("produto/list", modelMap);
	}
	
	@GetMapping("/form")
	public ModelAndView formCadastro(@ModelAttribute("produto") Produto produto, ModelMap model) {
		
		model.addAttribute("listStatus", TipoStatus.values());
		
		return new ModelAndView("produto/form", model);
	}
	
	@PostMapping(value="/salvar")
	public String salvar(@ModelAttribute("produto") Produto produto, RedirectAttributes attr) {
		
		if(produto.getId() == 0) {
			banco.adicionaProduto(produto);
			attr.addFlashAttribute("message", "Produto cadastrado com sucesso!");
		}else {
			banco.atualizaProduto(produto);
			attr.addFlashAttribute("message", "Produto atualizado com sucesso!");
		}
		
		
		return "redirect:/produto/";
		
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id, ModelMap model) {
		
		Produto produto = banco.getProduto(id);
		model.addAttribute("produto", produto);
		
		return new ModelAndView("produto/form", model);
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") int id) {
		
		banco.removeProduto(id);
		
		return "redirect:/produto/";
		
	}
	
}

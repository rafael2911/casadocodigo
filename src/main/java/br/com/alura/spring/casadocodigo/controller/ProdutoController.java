package br.com.alura.spring.casadocodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.spring.casadocodigo.dao.ProdutoDao;
import br.com.alura.spring.casadocodigo.entity.Produto;
import br.com.alura.spring.casadocodigo.entity.TipoStatus;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoDao produtoDao;
	
	@ModelAttribute("listStatus")
	public TipoStatus[] tipoStatus() {
		return TipoStatus.values();
	}
	
	@GetMapping(value= {"", "/", "/index"})
	public ModelAndView listar(ModelMap modelMap) {
		List<Produto> produtos = produtoDao.listProdutos();
		modelMap.addAttribute("produtos", produtos);
		return new ModelAndView("produto/list", modelMap);
	}
	
	@GetMapping("/form")
	public ModelAndView formCadastro(@ModelAttribute("produto") Produto produto, ModelMap model) {
		
		return new ModelAndView("produto/form", model);
	}
	
	@PostMapping(value="/salvar")
	public String salvar(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "produto/form";
		}
		
		if(produto.getId() == 0) {
			produtoDao.adicionaProduto(produto);
			attr.addFlashAttribute("message", "Produto cadastrado com sucesso!");
		}else {
			produtoDao.atualizaProduto(produto);
			attr.addFlashAttribute("message", "Produto atualizado com sucesso!");
		}
		
		
		return "redirect:/produto/";
		
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id, ModelMap model) {
		
		Produto produto = produtoDao.getProduto(id);
		model.addAttribute("produto", produto);
		
		return new ModelAndView("produto/form", model);
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") int id, RedirectAttributes attr) {
		
		produtoDao.removeProduto(id);
		
		attr.addFlashAttribute("message", "Produto removido com sucesso!");
		
		return "redirect:/produto/";
		
	}
	
	@GetMapping("/status")
	public ModelAndView buscaPorStatus(TipoStatus tipoStatus) {
		if(tipoStatus == null) {
			return new ModelAndView("redirect:/produto/");
		}
		
		return new ModelAndView("produto/list", "produtos", produtoDao.getByStatus(tipoStatus));
	}
	
}

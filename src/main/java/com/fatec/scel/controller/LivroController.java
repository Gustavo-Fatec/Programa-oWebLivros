package com.fatec.scel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fatec.scel.model.Livro;

@Controller
@RequestMapping("/livros")
public class LivroController {
	@GetMapping("/home") // Define a url que quando for requisitada chamara o metodo
	public String home() {
// Retorna a view que deve ser chamada, neste exemplo a pagina home (html)
		return "home";
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastraLivro(Livro livro) {
		ModelAndView mv = new ModelAndView("cadastrarLivro");
		mv.addObject("livro", livro);
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView adicionar(Livro livro) {
		System.out.println("ISBN digitado na interface ===>" + livro.getIsbn());
		ModelAndView modelAndView = new ModelAndView("consultarLivro");
		modelAndView.addObject("message", livro.getIsbn());
		return modelAndView;
	}
}
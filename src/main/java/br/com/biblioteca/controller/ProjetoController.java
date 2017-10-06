package br.com.biblioteca.controller;

//@Controller para indicar que a classe é um controlador
//@RequestMapping, que indica o caminho para acessar esse controlador. 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;

@Controller
@RequestMapping("/projeto")

public class ProjetoController {

	private ProjetoRepositorio projetoRepositorio;

	@Autowired
	public ProjetoController(ProjetoRepositorio projetoRepositorio) {
		this.projetoRepositorio = projetoRepositorio;
	}

	@RequestMapping(value = "/{idprojeto}", method = RequestMethod.GET)
	public String listaProjeto(@PathVariable("projeto") Long idprojeto, Model model) {
		List<Projeto> listaProjeto = projetoRepositorio.findByIdprojeto(idprojeto);
		if (listaProjeto != null) {
			model.addAttribute("projeto", listaProjeto);
		}
		return "listaProjeto";
	}

	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	public String listaNome(@PathVariable("projeto") String nome, Model model) {
		List<Projeto> listaProjeto = projetoRepositorio.findByName(nome);
		if (listaProjeto != null) {
			model.addAttribute("projeto", listaProjeto);
		}
		return "listaProjeto";
	}

	@RequestMapping(value = "/{data_fim}", method = RequestMethod.GET)
	public String listaDataFim(@PathVariable("projeto") Date data_fim, Model model) {
		List<Projeto> listaProjeto = projetoRepositorio.findByDataFim(data_fim);
		if (listaProjeto != null) {
			model.addAttribute("projeto", listaProjeto);
		}
		return "listaProjeto";
	}

	@RequestMapping(value = "/{status}", method = RequestMethod.GET)
	public String listaStatus(@PathVariable("projeto") String status, Model model) {
		List<Projeto> listaProjeto = projetoRepositorio.findByStatus(status);
		if (listaProjeto != null) {
			model.addAttribute("projeto", listaProjeto);
		}
		return "listaProjeto";
	}

	@RequestMapping(value = "/{status}", method = RequestMethod.GET)
	public String listaGerente(@PathVariable("projeto") Long idgerente, Model model) {
		List<Projeto> listaProjeto = projetoRepositorio.findByGerente(idgerente);
		if (listaProjeto != null) {
			model.addAttribute("projeto", listaProjeto);
		}
		return "listaProjeto";
	}
	
	public void saveProjeto(Projeto projeto) {
		projetoRepositorio.saveProjeto(projeto);
	}
	 
	public void updateProjeto(Projeto projeto) {
		projetoRepositorio.updateProjeto(projeto);
	}
	 
	public void deleteById(Projeto projeto) {
		projetoRepositorio.deleteByIdprojeto(projeto);
	}

	// Verificar a função para o POST (SAVE)
	// Verificar o retorno "redirect:/{membro}"
	//
	// @RequestMapping(value = "/{idpessoa, idprojeto}", method = RequestMethod.POST)
	// public String adicionaMembroParaProjeto(@PathVariable("membro") Long idpessoa, Long, idprojeto, membro membro) {
	// membro.setIdpessoa(idpessoa);
	// membro.setIdprojeto(idprojeto);
	// membroRepositorio.save(membro);
	// return "redirect:/{membro}";
	// }
}

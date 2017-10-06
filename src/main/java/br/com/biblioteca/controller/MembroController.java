package br.com.biblioteca.controller;

//@Controller para indicar que a classe é um controlador
//@RequestMapping, que indica o caminho para acessar esse controlador. 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.biblioteca.model.Membro;

@Controller
@RequestMapping("/membro")
public class MembroController {
	private MembroRepositorio membroRepositorio;

	@Autowired
	public MembroController(MembroRepositorio membrosRepositorio) {
		this.membroRepositorio = membrosRepositorio;
	}

	@RequestMapping(value = "/{idpessoa}", method = RequestMethod.GET)
	public String listaPessoa(@PathVariable("pessoa") Long idpessoa, Model model) {
		List<Membro> listaMembro = membroRepositorio.findByIdpessoa(idpessoa);
		if (listaMembro != null) {
			model.addAttribute("pessoa", listaMembro);
		}
		return "listaMembro";
	}

	@RequestMapping(value = "/{idprojeto}", method = RequestMethod.GET)
	public String listaProjeto(@PathVariable("projeto") Long idprojeto, Model model) {
		List<Membro> listaMembro = membroRepositorio.findByIdprojeto(idprojeto);
		if (listaMembro != null) {
			model.addAttribute("projeto", listaMembro);
		}
		return "listaMembro";
	}

	@RequestMapping(value = "/{idpessoa, idprojeto}", method = RequestMethod.GET)
	public String listaPessoaMaisProjeto(@PathVariable("membro") Long idprojeto, Long idpessoa, Model model) {
		Membro listaMembro = membroRepositorio.find(idprojeto, idpessoa);
		if (listaMembro != null) {
			model.addAttribute("projetomaispessoa", listaMembro);
		}
		return "listaMembro";
	}

	public void saveMembro(Membro membro) {
		membroRepositorio.saveMembro(membro);
	}
	 
	public void updateMembro(Membro membro) {
		membroRepositorio.updateMembro(membro);
	}
	 
	public void deleteById(Membro membro) {
		membroRepositorio.deleteById(membro);
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

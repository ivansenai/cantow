package br.com.biblioteca.controller;
	
	//@Controller para indicar que a classe é um controlador
	//@RequestMapping, que indica o caminho para acessar esse controlador. 

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMethod;
	import br.com.biblioteca.model.Membro;
	import br.com.biblioteca.model.Pessoa;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
		private PessoaRepositorio pessoaRepositorio;

	
		@Autowired
		public PessoaController(PessoaRepositorio pessoaRepositorio) {
			this.pessoaRepositorio = pessoaRepositorio;
		}

		@RequestMapping(value = "/{idpessoa}", method = RequestMethod.GET)
		public String listaPessoa(@PathVariable("pessoa") Long idpessoa, Model model) {
			List<Pessoa> listaPessoa = pessoaRepositorio.findByIdpessoa(idpessoa);
			if (listaPessoa != null) {
				model.addAttribute("pessoa", listaPessoa);
			}
			return "listaPessoa";
		}

		@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
		public String listaNome(@PathVariable("pessoa") String nome, Model model) {
			List<Pessoa> listaPessoa = pessoaRepositorio.findByName(nome);
			if (listaPessoa != null) {
				model.addAttribute("pessoa", listaPessoa);
			}
			return "listaPessoa";
		}
		
		@RequestMapping(value = "/{cpf}", method = RequestMethod.GET)
		public String listaCpf(@PathVariable("pessoa") String cpf, Model model) {
			Pessoa listaPessoa = pessoaRepositorio.findByCpf(cpf);
			if (listaPessoa != null) {
				model.addAttribute("pessoa", listaPessoa);
			}
			return "listaPessoa";
		}

		public void savePessoa(Pessoa pessoa) {
			pessoaRepositorio.savePessoa(pessoa);
		}
		 
		public void updatePessoa(Pessoa pessoa) {
			pessoaRepositorio.updatePessoa(pessoa);
		}
		 
		public void deleteById(Pessoa pessoa) {
			pessoaRepositorio.deleteByIdpessoa(pessoa);
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


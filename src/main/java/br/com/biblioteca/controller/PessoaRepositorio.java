package br.com.biblioteca.controller;

//O sistema deve permitir o cadastro (inserção, exclusão, alteração e consulta) de projetos.

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
		List<Pessoa> findByName(String nome);
		List<Pessoa> findByIdpessoa(Long idpessoa);
		Pessoa findByCpf(String cpf);
		
		void savePessoa(Pessoa pessoa);    
	    void updatePessoa(Pessoa pessoa);     
	    void deleteByIdpessoa(Pessoa pessoa);
}

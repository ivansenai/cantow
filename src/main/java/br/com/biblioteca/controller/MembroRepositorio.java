package br.com.biblioteca.controller;

//O sistema deve permitir o cadastro (inserção, exclusão, alteração e consulta) de projetos.

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.biblioteca.model.Membro;
import br.com.biblioteca.model.Pessoa;

public interface MembroRepositorio extends JpaRepository<Membro, Long> {
	List<Membro> findByIdprojeto(Long idprojeto);
	List<Membro> findByIdpessoa(Long idpessoa);
	Membro find(Long idprojeto, Long idpessoa);
	
	void saveMembro(Membro membro);    
    void updateMembro(Membro membro);     
    void deleteById(Membro membro);
}

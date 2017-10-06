package br.com.biblioteca.controller;

import java.sql.Date;

//O sistema deve permitir o cadastro (inserção, exclusão, alteração e consulta) de projetos.

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.biblioteca.model.Projeto;

public interface ProjetoRepositorio extends JpaRepository<Projeto, Long> {
	List<Projeto> findByName(String nome);
	List<Projeto> findByIdprojeto(Long idprojeto);
	List<Projeto> findByDataFim(Date data_fim);
	List<Projeto> findByStatus(String status);	
	List<Projeto> findByGerente(Long idgerente);
	
	void saveProjeto(Projeto projeto);    
    void updateProjeto(Projeto projeto);     
    void deleteByIdprojeto(Projeto projeto);
}

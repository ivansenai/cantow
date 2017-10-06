package br.com.biblioteca.model;

//@Entity para indicar que a classe é uma entidade
//@Id para indicar que o campo id 
//@GeneratedValue que indica que o valor será gerado banco de dados
//@Column para definir alguns parâmetros das colunas como o nome
//@Column(name="id", nullable=false, unique=true)
//@Column(name="id", nullable=true)

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Membro {
	//Lembrar que essa é uma chave primaria e não nulla
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idprojeto;

	//Lembrar que essa é uma chave estrangeira e não nulla
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idpessoa;

	public Long getIdprojeto() {
		return idprojeto;
	}

	public void setIdprojeto(Long idprojeto) {
		this.idprojeto = idprojeto;
	}

	public Long getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(Long idpessoa) {
		this.idpessoa = idpessoa;
	}

	public Membro() {
		// TODO Auto-generated constructor stub
	}

}

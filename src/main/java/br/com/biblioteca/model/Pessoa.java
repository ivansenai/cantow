package br.com.biblioteca.model;

import java.sql.Date;

//@Entity para indicar que a classe é uma entidade
//@Id para indicar que o campo id 
//@GeneratedValue que indica que o valor será gerado banco de dados
//@Column para definir alguns parâmetros das colunas como o nome
//@Column(name="id", nullable=false, unique=true)
//@Column(name="id", nullable=true)

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="nome", nullable=true)
	private String nome;

	@Column(name="data_nascimento", nullable=false)
	private Date data_nascimento;

	@Column(name="cpf", nullable=false)
	private String cpf;
	
	@Column(name="funcionario", nullable=false)
	private boolean funcionario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isFuncionario() {
		return funcionario;
	}

	public void setFuncionario(boolean funcionario) {
		this.funcionario = funcionario;
	}

	public Pessoa() {
			// TODO Auto-generated constructor stub
		}

}

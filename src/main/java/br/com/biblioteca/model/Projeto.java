package br.com.biblioteca.model;

//@Entity para indicar que a classe é uma entidade
//@Id para indicar que o campo id 
//@GeneratedValue que indica que o valor será gerado banco de dados
//@Column para definir alguns parâmetros das colunas como o nome
//@Column(name="id", nullable=false, unique=true)
//@Column(name="id", nullable=true)

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="nome", nullable=true)
	private String nome;
	
	@Column(name="data_inicio", nullable=false)
	private Date data_inicio;
	
	@Column(name="data_previsao_fim", nullable=false)
	private Date data_previsao_fim;
	
	@Column(name="data_fim", nullable=false)
	private Date data_fim;
	
	//descrição 
	
	@Column(name="status", nullable=false)
	private String status;
    
	@Column(name="orcamento", nullable=false)
	private double orcamento;
	
	@Column(name="risco", nullable=false)
	private String risco;
    
	//Lembrar que essa é uma chave estrangeira, não nulla
	@Column(name="idgerente", nullable=true)
	private String idgerente;
    
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

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_previsao_fim() {
		return data_previsao_fim;
	}

	public void setData_previsao_fim(Date data_previsao_fim) {
		this.data_previsao_fim = data_previsao_fim;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(double orcamento) {
		this.orcamento = orcamento;
	}

	public String getRisco() {
		return risco;
	}

	public void setRisco(String risco) {
		this.risco = risco;
	}

	public String getIdgerente() {
		return idgerente;
	}

	public void setIdgerente(String idgerente) {
		this.idgerente = idgerente;
	}

	public Projeto() {
		// TODO Auto-generated constructor stub
	}
}

package model;

import java.io.Serializable;
import java.time.YearMonth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Historico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String empresa;
	private String atividade;
	private YearMonth tempoEmpresa;

	@OneToOne
	@JoinColumn(name = "aluno_ra")
	private Aluno aluno;

	public Historico() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public YearMonth getTempoEmpresa() {
		return tempoEmpresa;
	}

	public void setTempoEmpresa(YearMonth tempoEmpresa) {
		this.tempoEmpresa = tempoEmpresa;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "Historico [id=" + id + ", empresa=" + empresa + ", atividade=" + atividade + ", tempoEmpresa="
				+ tempoEmpresa + "]";
	}

}
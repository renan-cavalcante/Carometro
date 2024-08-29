package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Historico implements Serializable {

	private static final long serialVersionUID = 1L;
	@Transient
	private final DateTimeFormatter ANO_MES = DateTimeFormatter.ofPattern("yy,MM");


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String empresa;
	private String atividade;
	private LocalDate tempoEmpresa;

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

	public String getTempoEmpresaFormat() {
		return tempoEmpresa.format(ANO_MES);
	}

	public LocalDate getTempoEmpresa() {
		return tempoEmpresa;
	}

	public void setTempoEmpresa(LocalDate tempoEmpresa) {
		this.tempoEmpresa = tempoEmpresa;
	}

	public void setTempoEmpresa(String tempoEmpresa) {
		String[] parts = tempoEmpresa.split(",");

		String ano = parts[0].length() == 1 ? "000" + parts[0] : "00" + parts[0];
		String mes = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
		String dia = "01"; 
		this.tempoEmpresa = LocalDate.parse(ano+"-"+mes+"-"+dia);
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
				+ getTempoEmpresaFormat() + "]";
	}

}

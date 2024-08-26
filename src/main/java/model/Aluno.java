package model;

import java.io.Serializable;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String ra;
	private String nome;
	private String curso;
	private YearMonth semestreConclusao;
	private String foto;

	@ElementCollection
	@CollectionTable(name = "aluno_links", joinColumns = @JoinColumn(name = "aluno_ra"))
	@MapKeyColumn(name = "tipo_link")
	@Column(name = "url")
	private Map<String, String> links;

	@OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
	private Historico historico;

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
	@MapKeyColumn(name = "tipo")
	private Map<String, Comentario> comentarios;

	public Aluno() {
		links = new HashMap<String, String>();
		comentarios = new HashMap<String, Comentario>();
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public YearMonth getSemestreConclusao() {
		return semestreConclusao;
	}

	public void setSemestreConclusao(YearMonth semestreConclusao) {
		this.semestreConclusao = semestreConclusao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Map<String, String> getLinks() {
		return links;
	}

	public void setLinks(Map<String, String> links) {
		this.links = links;
	}

	public void putLink(String chave, String link) {
		links.put(chave, link);
	}

	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
		historico.setAluno(this);
	}

	public Map<String, Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Map<String, Comentario> comentarios) {
		this.comentarios = comentarios;
		comentarios.values().forEach(c -> c.setAluno(this));
	}

	public void putComentarios(Comentario comentario) {
		this.comentarios.put(comentario.getTipo().toString(), comentario);
		comentario.setAluno(this);
	}

	@Override
	public String toString() {
		StringBuilder comentariosStr = new StringBuilder();
		for(String tipo : comentarios.keySet()){
			comentariosStr.append(tipo);
			comentariosStr.append(": ");
			comentariosStr.append(comentarios.get(tipo));
		}
		return "Aluno [ra=" + ra + ", nome=" + nome + ", curso=" + curso + ", semestreConclusao=" + semestreConclusao
				+ ", foto=" + foto + ", links=" + links + ",\nhistorico=" + historico + ", \ncomentarios={"
				+ comentariosStr.toString() + "}]";
	}

}

package view;

import java.time.LocalDate;
import java.time.YearMonth;

import controller.AlunoController;
import enums.Tipo;
import model.Aluno;
import model.Comentario;
import model.Historico;

public class Main {

	public static void main(String[] args) {
		
		AlunoController dao = new AlunoController();
		
		// Cadastrar
		Historico h = new Historico();
		h.setAtividade("Desenvolvedor");
		h.setEmpresa("IBM");
		h.setTempoEmpresa(YearMonth.of(1, 6));
		
		Comentario c1 = new Comentario();
		c1.setData(LocalDate.now());
		c1.setDescricao("Otima faculdade");
		c1.setTipo(Tipo.FATEC);
		
		Comentario c2 = new Comentario();
		c2.setData(LocalDate.now());
		c2.setDescricao("Finalmente livre");
		c2.setTipo(Tipo.LIVRE);
		
		Aluno a = new Aluno();
		a.setRa("11111");
		a.setNome("Welligton");
		a.setCurso("ADS");
		a.setSemestreConclusao(YearMonth.of(2050, 12));
		a.setFoto("https://fatec.com/foto-1");
		a.putLink("github", "github.com");
		a.putLink("linkedin", "https://br.linkedin.com/");
		a.putLink("lattes", "https://lattes.cnpq.br/");
		a.setHistorico(h);
		a.putComentarios(c1);
		a.putComentarios(c2);
		//dao.realizarCadastro(a);
		
		// consultar
		System.out.println(dao.consultarCadastro("11111").toString());
		
		// listar
		dao.listarAlunos().forEach(System.out::println);
		
		//atualizar
		a = dao.consultarCadastro("11111");
		a.setNome("Amós");
		a.getHistorico().setAtividade("Deletar bases de dados");
		dao.atualizarCadastro(a);
		System.out.println();
		System.out.println(dao.consultarCadastro("11111"));
		
		//deletar
		dao.deletarCadastro("11111");
		System.out.println(dao.consultarCadastro("11111"));

	}

}

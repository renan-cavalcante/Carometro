package view;

import java.util.Scanner;

import controller.AlunoController;
import enums.Tipo;
import model.Aluno;
import model.Comentario;
import model.Historico;

public class Main {

	public static void main(String[] args) {

		AlunoController dao = new AlunoController();

		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Escolha uma opção");
			System.out.println("1 - Inserir aluno");
			System.out.println("2 - Pesquisar aluno");
			System.out.println("3 - Deletar aluno");
			System.out.println("4 - Listar alunos");
			System.out.println("5 - Atualizar aluno");
			System.out.println("0 - Sair");

			int opcao = sc.nextInt();
			sc.nextLine(); // Consumir a nova linha

			switch (opcao) {
			case 1:
				try {
				// Inserir aluno
				System.out.println("Inserindo novo aluno:");

				Aluno a = new Aluno();

				System.out.print("RA: ");
				a.setRa(sc.nextLine());

				System.out.print("Nome: ");
				a.setNome(sc.nextLine());

				System.out.print("Curso: ");
				a.setCurso(sc.nextLine());

				System.out.print("Semestre de Conclusão (aaaa/mm): ");
				String semestre = sc.nextLine();
				a.setSemestreConclusao(semestre);

				System.out.print("Foto (URL): ");
				a.setFoto(sc.nextLine());

				System.out.print("Link Github: ");
				a.putLink("github", sc.nextLine());

				System.out.print("Link LinkedIn: ");
				a.putLink("linkedin", sc.nextLine());

				System.out.print("Link Lattes: ");
				a.putLink("lattes", sc.nextLine());

				System.out.println("Historico - Atividade: ");
				Historico h = new Historico();
				h.setAtividade(sc.nextLine());

				System.out.println("Historico - Empresa: ");
				h.setEmpresa(sc.nextLine());

				System.out.print("Historico - Tempo na Empresa (anos,meses): ");
				String tempo = sc.nextLine();
				h.setTempoEmpresa(tempo);
				a.setHistorico(h);

				System.out.println("Adicionar Comentário Fatec:");
				Comentario c1 = new Comentario();
				c1.setDescricao(sc.nextLine());

				c1.setTipo(Tipo.FATEC);

				a.putComentarios(c1);

				System.out.println("Adicionar Comentário Livre:");
				Comentario c2 = new Comentario();
				c2.setDescricao(sc.nextLine());

				System.out.print("Tipo (ex. FATEC ou LIVRE): ");
				c2.setTipo(Tipo.LIVRE);

				a.putComentarios(c2);

				dao.realizarCadastro(a);
				System.out.println("Aluno cadastrado com sucesso!");
				}catch(Exception e) {
					e.printStackTrace();
					System.err.println(e.getMessage());
				}
				break;

			case 2:
				try {
					// Pesquisar aluno
					System.out.print("Digite o RA do aluno a ser pesquisado: ");
					String raPesquisa = sc.nextLine();
					Aluno alunoPesquisado = dao.consultarCadastro(raPesquisa);

					System.out.println(alunoPesquisado);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}

				break;

			case 3:
				// Deletar aluno
				try {
					System.out.print("Digite o RA do aluno a ser deletado: ");
					String raDeletar = sc.nextLine();
					dao.deletarCadastro(raDeletar);

					System.out.println("Aluno deletado com sucesso!");
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;

			case 4:
				// Listar alunos
				try {
					dao.listarAlunos().forEach(System.out::println);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;

			case 5:
				// Atualizar aluno
				try {
				System.out.print("Digite o RA do aluno a ser atualizado: ");
				String raAtualizar = sc.nextLine();
				Aluno alunoParaAtualizar = dao.consultarCadastro(raAtualizar);
		
					System.out.println("Digite os novos dados do aluno (deixe em branco para manter o valor atual):");

					System.out.print("Novo Nome: ");
					String novoNome = sc.nextLine();
					if (!novoNome.isEmpty()) {
						alunoParaAtualizar.setNome(novoNome);
					}

					System.out.print("Novo Curso: ");
					String novoCurso = sc.nextLine();
					if (!novoCurso.isEmpty()) {
						alunoParaAtualizar.setCurso(novoCurso);
					}

					System.out.print("Novo Semestre de Conclusão (aaaa/mm): ");
					String novoSemestre = sc.nextLine();
					if (!novoSemestre.isEmpty()) {
						alunoParaAtualizar.setSemestreConclusao(novoSemestre);
					}

					System.out.print("Nova Foto (URL): ");
					String novaFoto = sc.nextLine();
					if (!novaFoto.isEmpty()) {
						alunoParaAtualizar.setFoto(novaFoto);
					}

					dao.atualizarCadastro(alunoParaAtualizar);
					System.out.println("Aluno atualizado com sucesso!");
				}catch(Exception e) {
					System.err.println(e.getMessage());
				}
				break;

			case 0:
				// Sair
				System.out.println("Saindo...");
				sc.close();
				break;

			default:
				System.out.println("Opção inválida! Tente novamente.");
				break;
			}
		} while (true);
		 /*
		Historico h = new Historico();
		h.setAtividade("Desenvolvedor");
		h.setEmpresa("IBM");
		h.setTempoEmpresa("1,6");
		
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
		a.setSemestreConclusao("2050/12");
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
*/
	}

}

package controller;

import java.util.List;

import dao.AlunoDao;
import model.Aluno;

public class AlunoController {
	AlunoDao alunoDao = new AlunoDao();
	
	public void realizarCadastro(Aluno a) {
		try {
			alunoDao.cadastrar(a);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//throw new Exception(e.getMessage());
		}
	}
	
	public Aluno consultarCadastro(String ra) {
		Aluno a = null;
		try {
			a = alunoDao.consultar(ra);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//throw new Exception(e.getMessage());
		} 
		return a;
	}
	
	public void deletarCadastro(String ra) {
		try {
			alunoDao.deletar(ra);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//throw new Exception(e.getMessage());
		}
	}
	
	public void atualizarCadastro(Aluno a) {
		try {
			alunoDao.atualizar(a);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//throw new Exception(e.getMessage());
		}
	}
	
	public List<Aluno> listarAlunos() {
		List<Aluno> alunos = null;
		try {
			alunos = alunoDao.listar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//throw new Exception(e.getMessage());
		}
		return alunos;
	}

}

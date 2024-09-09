package com.fatec.carometro.controller;

import java.util.List;

import dao.AlunoDao;
import model.Aluno;

public class AlunoController {
	AlunoDao alunoDao = new AlunoDao();
	
	public void realizarCadastro(Aluno a) throws Exception {
		try {
			alunoDao.cadastrar(a);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Aluno consultarCadastro(String ra) throws Exception {
		Aluno a = null;
		try {
			a = alunoDao.consultar(ra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 
		return a;
	}
	
	public void deletarCadastro(String ra) throws Exception {
		try {
			alunoDao.deletar(ra);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void atualizarCadastro(Aluno a) throws Exception {
		try {
			alunoDao.atualizar(a);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Aluno> listarAlunos() throws Exception {
		List<Aluno> alunos = null;
		try {
			alunos = alunoDao.listar();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return alunos;
	}

}

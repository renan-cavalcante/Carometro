package com.fatec.carometro.dao;

import java.util.List;

import model.Aluno;

public interface IAlunoDao {
		void cadastrar(Aluno aluno) throws Exception;
		Aluno consultar(String ra)  throws Exception;
		void deletar(String ra)  throws Exception;
		void atualizar(Aluno aluno)  throws Exception;
		List<Aluno> listar()  throws Exception;

}

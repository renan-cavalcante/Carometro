package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import org.hibernate.Hibernate;

import model.Aluno;

public class AlunoDao implements IAlunoDao {
	EntityManagerFactory mf = Persistence.createEntityManagerFactory("HibJPA");

	@Override
	public void cadastrar(Aluno aluno) throws Exception {
		EntityManager em = mf.createEntityManager();
		try {

			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();

		} catch (RollbackException e) {
			System.out.println("RA já cadastrado");
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
	}

	@Override
	public Aluno consultar(String ra) throws Exception {
		EntityManager em = mf.createEntityManager();
		Aluno aluno = null;
		try {
			aluno = em.find(Aluno.class, ra);

			if (aluno != null) {
				Hibernate.initialize(aluno.getLinks());
				Hibernate.initialize(aluno.getComentarios());
				Hibernate.initialize(aluno.getHistorico());
			} else {
				throw new Exception("Aluno não encontrado - consulta");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
		return aluno;
	}

	@Override
	public void deletar(String ra) throws Exception {
		EntityManager em = mf.createEntityManager();
		try {
			em.getTransaction().begin();
			Aluno aluno = em.find(Aluno.class, ra);
			if (aluno != null) {
				em.remove(aluno);
			} else {
				throw new Exception("Aluno não encontrado - delete");
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}

	}

	@Override
	public void atualizar(Aluno aluno) throws Exception {
		EntityManager em = mf.createEntityManager();
		try {

			em.getTransaction().begin();
			em.merge(aluno);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
	}

	@Override
	public List<Aluno> listar() throws Exception {
		EntityManager em = mf.createEntityManager();
		List<Aluno> alunos = null;
		try {
			alunos = em.createQuery("SELECT a FROM Aluno a ", Aluno.class).getResultList();
			for (Aluno aluno : alunos) {

				Hibernate.initialize(aluno.getLinks());
				Hibernate.initialize(aluno.getComentarios());
				Hibernate.initialize(aluno.getHistorico());
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
		return alunos;
	}

}

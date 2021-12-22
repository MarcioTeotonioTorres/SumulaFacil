package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;

import basicas.Usuario;
import conexao.FabricaDeConexao;
import util.Sessao;

public class UsuarioDao implements IusuarioDao {

	private EntityManager em;

	public UsuarioDao() {

	}

	@Override
	public boolean excluirUsuarioPorId(Long u) {

		em = FabricaDeConexao.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();

			em.createQuery("delete from Usuario where matricula = :matricula").setParameter("matricula", u)
					.executeUpdate();
			em.createQuery("delete from Pessoa where matricula = :matricula").setParameter("matricula", u)
					.executeUpdate();
			et.commit();

			System.out.println("deletado com sucesso");
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			et.rollback();
			System.out.println("id informado nao existe");
			return false;
		}

	}

	@Override
	public boolean inserirUsuarioDao(Usuario usuario) throws ConstraintViolationException {

		em = FabricaDeConexao.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {

			et.begin();
			em.persist(usuario);
			et.commit();

			return true;

		} catch (PersistenceException e) {
			// TODO:handle exception
			e.printStackTrace();
			System.out.println("usuario esta nullo");

			return false;
		}

	}

	@Override
	public boolean loginDao(Usuario usuario) {
		
		em = FabricaDeConexao.getEntityManager();

		try {

			String hql = "from Usuario where nomeUsuario = :nomeUsuario and senha = :senha and tipoUsuario = :tipoUsuario";

			Query query = em.createQuery(hql);

			query.setParameter("nomeUsuario", usuario.getNomeUsuario());
			query.setParameter("senha", usuario.getSenha());
			query.setParameter("tipoUsuario", usuario.getTipoUsuario());

			query.getSingleResult();
			Sessao.getInstance().setUsuario(usuario);
			return true;

		} catch (Exception e) {
			Sessao.getInstance().setUsuario(null);
			return false;

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listaDeAnotadores() {
		em = FabricaDeConexao.getEntityManager();
		try {

			List<Usuario> usuarios = new ArrayList<Usuario>();
			String hql = "from Usuario where tipousuario = 'Anotador'";
			Query query = em.createQuery(hql, Usuario.class);
			usuarios = query.getResultList();
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean alterarUsuarioDaoAnotador(Usuario usuario) {
		em = FabricaDeConexao.getEntityManager();
		EntityTransaction etEntityTransaction = em.getTransaction();

		try {
			usuario.setMatricula(usuarioAnotadorPeloNome(usuario.getNomeUsuario()));

			etEntityTransaction.begin();
			em.merge(usuario);
			etEntityTransaction.commit();
			System.out.println("Alterado");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public long usuarioAnotadorPeloNome(String nomeUsuario) {

		em = FabricaDeConexao.getEntityManager();
		try {
			String hql = "select u.matricula from Usuario as u where u.nomeUsuario = :nomeUsuario";
			Query query = em.createQuery(hql);
			query.setParameter("nomeUsuario", nomeUsuario);
			long id = (long) query.getSingleResult();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;

		}

	}
}

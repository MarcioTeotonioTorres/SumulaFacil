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
import interfaceDao.IusuarioDao;
import util.Sessao;

public class UsuarioDao implements IusuarioDao {

	private EntityManager em;

	public UsuarioDao() {

		em = FabricaDeConexao.getEntityManager();

	}

	public boolean excluirUsuarioPorId(Long u) {

		em = FabricaDeConexao.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();

			em.createQuery("delete from Usuario where id = :id").setParameter("id", u).executeUpdate();
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

	public boolean inserirUsuarioDao(Usuario usuario) throws ConstraintViolationException {

		em = FabricaDeConexao.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {

			et.begin();
			em.persist(usuario);
			et.commit();

			return true;

		} catch (PersistenceException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("usuario esta nullo");

			return false;
		}

	}

	public boolean loginDao(Usuario usuario) {
		em = FabricaDeConexao.getEntityManager();

		try {

			String hql = "from Usuario where nomeUsuario = :nomeUsuario and senha=:senha and tipoUsuario = :tipoUsuario";
			Query query = em.createQuery(hql);
			query.setParameter("nomeUsuario", usuario.getNomeUsuario());
			query.setParameter("senha",usuario.getSenha());
			query.setParameter("tipoUsuario", usuario.getTipoUsuario());
			
			query.getSingleResult();
			System.out.println("ok");
			Sessao.getInstance().setUsuario(usuario);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
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

	public boolean alterarUsuarioAnotador(Usuario usuario) {

		try {

		} catch (Exception e) {

		}

		return false;

	}


}

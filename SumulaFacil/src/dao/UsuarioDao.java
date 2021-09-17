package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import basicas.Usuario;
import conexao.FabricaDeConexao;
import interfaceDao.IusuarioDao;
import util.Sessao;

public class UsuarioDao implements IusuarioDao {

private EntityManager em;

	public UsuarioDao() {
		
			em =FabricaDeConexao.getEntityManager();		

	}

	public boolean excluirUsuarioPorId(Usuario u) {

		EntityManager em = FabricaDeConexao.getEntityManager();
		try {
			em.createQuery("delete from usario where id = :id").setParameter("id", u.getMatricula()).executeUpdate();
			System.out.println("deletado com sucesso");

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("id informado nao existe");
			return false;
		}

	}

	public boolean inserirUsuarioDao(Usuario usuario) {

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

			String sql = "select nomeUsuario, senha, tipousuario from usuario where nomeusuario = '"
					+ usuario.getNomeUsuario() + "' and senha = '" + usuario.getSenha() + "' and tipousuario = '"
					+ usuario.getTipoUsuario() + "';";

			em.createNativeQuery(sql).getSingleResult();

			System.out.println("ok");
			Sessao.getInstance().setUsuario(usuario);
			return true;

		} catch (Exception e) {
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

}

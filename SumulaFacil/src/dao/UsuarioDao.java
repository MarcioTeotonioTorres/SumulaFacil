package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import basicas.Usuario;
import conexao.FabricaDeConexao;
import interfaceDao.IusuarioDao;

public class UsuarioDao implements IusuarioDao {

	EntityManager em;
	
	public UsuarioDao() {
		em = FabricaDeConexao.getEntityManager();
	}

	public boolean excluirUsuarioPorId(Usuario u) {

//		EntityManager em = FabricaDeConexao.getEntityManager();
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

//		EntityManager em = FabricaDeConexao.getEntityManager();
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
//		EntityManager em = FabricaDeConexao.getEntityManager();

		try {

			String sql = "select nomeUsuario, senha, tipousuario from usuario where nomeusuario = '"
					+ usuario.getNomeUsuario() + "' and senha = '" + usuario.getSenha() + "' and tipousuario = '"
					+ usuario.getTipoUsuario() + "';";

			em.createNativeQuery(sql).getSingleResult();
			
			System.out.println("ok");

			return true;

		} catch (Exception e) {
			return false;

		}

	}
}

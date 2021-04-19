package conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaDeConexao {

	private static EntityManager em;
	private static EntityManagerFactory emf;
	
	private FabricaDeConexao() {
	}

	public static EntityManager getEntityManager() {
		try { 
			if (em == null) {
				emf = Persistence.createEntityManagerFactory("sumulaPersistence");
				em = emf.createEntityManager();
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return em;
	}

}
package teste;

import dao.UsuarioDao;

public class Teste {

	public static void main(String[] args) {

		UsuarioDao dao = new UsuarioDao();
	
		
//		Usuario u = new Usuario();
		
		dao.excluirUsuarioPorId((long) 435);
		
	}

}

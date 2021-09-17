package teste;

import java.util.ArrayList;
import java.util.List;

import basicas.Usuario;
import dao.UsuarioDao;
import interfaceDao.IusuarioDao;

public class Teste {

	public static void main(String[] args) {

		UsuarioDao dao = new UsuarioDao();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = dao.listaDeAnotadores();
 		for (Usuario  u : usuarios) {
 			
			System.out.println(u);
		}
	}

}

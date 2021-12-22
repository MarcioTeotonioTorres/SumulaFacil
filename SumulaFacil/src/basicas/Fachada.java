package basicas;

import controlador.IusuarioControlador;
import controlador.UsuarioControlador;
import dao.IusuarioDao;
import dao.UsuarioDao;

public class Fachada {

	private IusuarioControlador controlador;
	private IusuarioDao dao;

	public Fachada() {
		controlador = new UsuarioControlador();
		dao = new UsuarioDao();
	}

	public IusuarioDao getDao() {
		return dao;
	}

	public IusuarioControlador getControlador() {
		return controlador;
	}

}

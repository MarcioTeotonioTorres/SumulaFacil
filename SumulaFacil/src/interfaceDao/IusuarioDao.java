package interfaceDao;

import basicas.Usuario;

public interface IusuarioDao {

	
	public boolean excluirUsuarioPorId(Usuario u);
	public boolean inserirUsuarioDao(Usuario usuario);
	public boolean loginDao(Usuario usuario);
	
}

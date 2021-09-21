package interfaceControlador;



import basicas.TipoUsuario;
import basicas.Usuario;

public interface IusuarioControlador {
	
	public Usuario inserirUsuarioControlador(String cep, String cpf, int idade, String nome, String numero,
			String telefone, String senha, String nomeUsuario, String repitaSenha);
	public Usuario loginControlador(String nomeUsuario, String senha, TipoUsuario tipoUsuario);
	public Usuario inserirUsuarioControladorAnotador(String cep, String cpf, int idade, String nome, String numero,
			String telefone, String senha, String nomeUsuario, String repitaSenha);
	
}

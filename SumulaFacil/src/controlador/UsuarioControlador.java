package controlador;

import javax.swing.JOptionPane;

import basicas.TipoUsuario;
import basicas.Usuario;
import util.Sessao;

public class UsuarioControlador implements IusuarioControlador {


	public UsuarioControlador() {}

	public Usuario inserirUsuarioControlador(String cep, String cpf, int idade, String nome, String numero,
			String telefone, String senha, String nomeUsuario, String repitaSenha) {

		try {

			if (cep.equals("     -   ") && cpf.equals("   .   .   -  ") && nome.isEmpty() && numero.isEmpty()
					&& telefone.equals("(  )     -    ") && senha.isEmpty() && nomeUsuario.isEmpty()
					&& repitaSenha.isEmpty()) {

				JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
				
				return null;
			} else if (cep.equals("     -   ") || cep.equals("00000-000") || cep.equals("11111-111")
					|| cep.equals("22222-222") || cep.equals("33333-333") || cep.equals("44444-444")
					|| cep.equals("55555-555") || cep.equals("66666-666") || cep.equals("77777-777")
					|| cep.equals("88888-888") || cep.equals("99999-999")) {
				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! O \"CEP\" está  vazio ou é inválido.");
				
				return null;

			} else if (cpf.equals("   .   .   -  ") || cpf.equals("000.000.000-00") || cpf.equals("111.111.111-11")
					|| cpf.equals("222.222.222-22") || cpf.equals("333.333.333-33") || cpf.equals("444.444.444-44")
					|| cpf.equals("555.555.555-55") || cpf.equals("666.666.666-66") || cpf.equals("777.777.777-77")
					|| cpf.equals("888.888.888-88") || cpf.equals("999.999.999-99")) {

				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! O \"CPF\" está vazio ou é inválido.");
				return null;
			} else if (telefone.equals("(  )     -    ") || telefone.equals("(00)00000-0000")
					|| telefone.equals("(11)11111-1111") || telefone.equals("(22)22222-2222")
					|| telefone.equals("(22)22222-2222") || telefone.equals("(33)33333-3333")
					|| telefone.equals("(44)44444-4444") || telefone.equals("(55)55555-5555")
					|| telefone.equals("(66)66666-6666") || telefone.equals("(77)77777-7777")
					|| telefone.equals("(88)88888-8888") || telefone.equals("(99)99999-9999")) {
				return null;

			} else if (nome.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! O \"Nome\" não pode estar vazio.");
				return null;
			} else if (numero.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! O \"Numero residencial\" não pode estar vazio.");
				return null;
			}else if (senha.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! O campo \"Senha\" não pode estar vazio.");
				return null;
			}else if (repitaSenha.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! O campo \"Repita senha\" não pode estar vazio.");
				return null;
			}else if (!senha.equals(repitaSenha)) {
				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! Campos \"Senha e Repita senha\" não conferem.");
				return null;
			}

			else {

				Usuario usuarioDir = new Usuario();
				
				usuarioDir.setNome(nome);
				usuarioDir.setCep(cep);
				usuarioDir.setSenha(senha);
				usuarioDir.setCpf(cpf);
				usuarioDir.setNomeUsuario(nomeUsuario);
				usuarioDir.setIdade(idade);
				usuarioDir.setNumero(numero);
				usuarioDir.setTelefone(telefone);
				usuarioDir.setTipoUsuario(TipoUsuario.Dirigente);
				usuarioDir.setCadastradoPor(null);
				
				return usuarioDir;
				
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public Usuario loginControlador(String nomeUsuario, String senha, TipoUsuario tipoUsuario) {

		try {
			if (nomeUsuario.isEmpty() || senha.isEmpty()) {

				return null;
			
			} else {
			
				Usuario usuarioLog = new Usuario();
				usuarioLog.setNomeUsuario(nomeUsuario.trim());
				usuarioLog.setSenha(senha.trim());
				usuarioLog.setTipoUsuario(tipoUsuario);
				
				return usuarioLog;
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Usuario inserirUsuarioControladorAnotador(String cep, String cpf, int idade, String nome, String numero,
			String telefone, String senha, String nomeUsuario, String repitaSenha) {
		try {

			if (cep.equals("     -   ") && cpf.equals("   .   .   -  ") && nome.isEmpty() && numero.isEmpty()
					&& telefone.equals("(  )     -    ") && senha.isEmpty() && nomeUsuario.isEmpty()
					&& repitaSenha.isEmpty()) {

				JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
				
				return null;
			} else if (cep.equals("     -   ") || cep.equals("00000-000") || cep.equals("11111-111")
					|| cep.equals("22222-222") || cep.equals("33333-333") || cep.equals("44444-444")
					|| cep.equals("55555-555") || cep.equals("66666-666") || cep.equals("77777-777")
					|| cep.equals("88888-888") || cep.equals("99999-999")) {
				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! O \"CEP\" está  vazio ou é inválido.");
				
				return null;

			} else if (cpf.equals("   .   .   -  ") || cpf.equals("000.000.000-00") || cpf.equals("111.111.111-11")
					|| cpf.equals("222.222.222-22") || cpf.equals("333.333.333-33") || cpf.equals("444.444.444-44")
					|| cpf.equals("555.555.555-55") || cpf.equals("666.666.666-66") || cpf.equals("777.777.777-77")
					|| cpf.equals("888.888.888-88") || cpf.equals("999.999.999-99")) {

				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! O \"CPF\" está  vazio ou é inválido.");
				return null;
			} else if (telefone.equals("(  )     -    ") || telefone.equals("(00)00000-0000")
					|| telefone.equals("(11)11111-1111") || telefone.equals("(22)22222-2222")
					|| telefone.equals("(22)22222-2222") || telefone.equals("(33)33333-3333")
					|| telefone.equals("(44)44444-4444") || telefone.equals("(55)55555-5555")
					|| telefone.equals("(66)66666-6666") || telefone.equals("(77)77777-7777")
					|| telefone.equals("(88)88888-8888") || telefone.equals("(99)99999-9999")) {
				return null;

			} else if (nome.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! O \"Nome\" não pode estar vazio.");
				
				return null;
			} else if (numero.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! O \"Numero residencial\" não pode estar vazio.");
				return null;
			}else if (senha.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! O campo \"Senha\" não pode estar vazio.");
				return null;
			}else if (repitaSenha.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! O campo \"Repita senha\" não pode estar vazio.");
				return null;
			}else if (!senha.equals(repitaSenha)) {
				JOptionPane.showMessageDialog(null,
						"Todos os campos são obrigatórios! Campos \"Senha e Repita senha\" não conferem.");
				return null;
			}

			
			else {
				Usuario usuarioAnot = new Usuario();
				usuarioAnot.setNome(nome);
				usuarioAnot.setCep(cep);
				usuarioAnot.setSenha(senha);
				usuarioAnot.setCpf(cpf);
				usuarioAnot.setNomeUsuario(nomeUsuario);
				usuarioAnot.setIdade(idade);
				usuarioAnot.setNumero(numero);
				usuarioAnot.setTelefone(telefone);
				usuarioAnot.setTipoUsuario(TipoUsuario.Anotador);
				usuarioAnot.setCadastradoPor(Sessao.getInstance().getUsuario().getNomeUsuario());
				return usuarioAnot;
							
			}

		} catch (Exception e) {
			
			return null;
		}
		
	}



}

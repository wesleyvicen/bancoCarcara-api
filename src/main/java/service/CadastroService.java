package service;

import dto.UsuarioDto;
import enums.TipoConta;
import model.Conta;
import model.Usuario;

public class CadastroService {
	public String Cadastrar(UsuarioDto usuarioDto) {
		UsuarioService usuarioService = new UsuarioService();
		ContaService contaService = new ContaService();

		Usuario usuario = new Usuario(usuarioDto);

		if (validaSenha(usuario.getSenha())) {
			boolean sucesso = usuarioService.AddUser(usuario);
			if (sucesso) {
				// Primeiro temos que criar a conta de d�bito
				Conta contaDebito = new Conta("Conta D�bito", usuario.getLogin(), TipoConta.CB);
				contaService.addConta(contaDebito);

				// Agora criamos a conta de cr�dito
				Conta contaCredito = new Conta("Conta Cr�dito", usuario.getLogin(), TipoConta.CC);
				contaService.addConta(contaCredito);
			} else {
				System.out.println("Já existe usuário com esse login");
				return "Já existe usuário com esse login";
			}
		}else{
			return "Senha inválida: A senha deve conter 6 ou mais caracteres";
		}
		return "Cadastrado com sucesso";
	}

	private boolean validaSenha(String senha) {
		return senha.length() >= 6;
	}
}

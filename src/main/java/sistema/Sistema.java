package sistema;

import dto.LoginDto;
import dto.UsuarioDto;
import service.CadastroService;
import service.LoginService;

public class Sistema {

	public static void main(String[] args) {
		//Rota de cadastro
		
		CadastroService cadastroService = new CadastroService();
		cadastroService.Cadastrar(new UsuarioDto("12530952728", "Gabriel Carreiras Botelho", "GabrielBotelho", "Gabriel123"));
		
		//Login
		LoginService loginService = new LoginService();
		System.out.println(loginService.Logar(new LoginDto("GabrielBotelho", "Gabriel123")).toString());
		
	}

}

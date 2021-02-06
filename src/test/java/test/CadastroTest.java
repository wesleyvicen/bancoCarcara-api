package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dto.ContaDto;
import dto.LoginDto;
import dto.SessaoDto;
import dto.UsuarioDto;
import enums.TipoConta;
import model.Conta;
import model.Usuario;
import repository.ContaRepository;
import repository.UsuarioRepository;
import service.CadastroService;
import service.LoginService;

class CadastroTest {

	@Test
	void ErroCadastroSenhaCurtaTest() {
		assertNotEquals("Cadastrado com sucesso", new CadastroService()
				.Cadastrar(new UsuarioDto("12530952728", "Gabriel Carreiras Botelho", "GabrielBotelho", "Gab")));
	}

	@Test
	void ErroCadastroJaCadastradoTest() {
		assertEquals("Cadastrado com sucesso",
				new CadastroService().Cadastrar(new UsuarioDto("12345678910", "João da Silva", "jpsilva", "123456")));
	}

	@Test
	void SuccessCadastroTest() {
		assertEquals("Cadastrado com sucesso", new CadastroService()
				.Cadastrar(new UsuarioDto("12530952728", "Gabriel Carreiras Botelho", "GabrielBotelho", "Gabriel123")));
	}

}

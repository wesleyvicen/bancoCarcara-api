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
import service.LoginService;

class LoginTest {
	@Test
	void ErroLoginTest() {
		assertNotEquals(new SessaoDto(), new LoginService().Logar(new LoginDto("jpsilva", "123456")));
	}

	@Test
	void SuccessLoginTest() {
		LoginDto loginDto = new LoginDto("jpsilva", "123456");
		UsuarioRepository usuarioRepository;
		ContaRepository contaRepository;
		SessaoDto sessaoDto = new SessaoDto();
		usuarioRepository = new UsuarioRepository();
		contaRepository = new ContaRepository();
		Usuario usuario = usuarioRepository.getUser(loginDto.getUsuario(), loginDto.getSenha());
		sessaoDto.setUsuario(new UsuarioDto(usuario));
		Conta contaDebito = contaRepository.getConta(loginDto.getUsuario(), TipoConta.CB);
		sessaoDto.setContaDebito(new ContaDto(contaDebito));
		Conta contaCredito = contaRepository.getConta(loginDto.getUsuario(), TipoConta.CC);
		sessaoDto.setContaCredito(new ContaDto(contaCredito));

		assertEquals(sessaoDto.getUsuario().getLogin(), new LoginService().Logar(loginDto).getUsuario().getLogin());
	}

}

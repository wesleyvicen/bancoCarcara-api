package repository;

import java.util.ArrayList;
import java.util.List;

import enums.TipoConta;
import model.Conta;

public class ContaRepository {
	public List<Conta> contas = new ArrayList<Conta>();
	public ContaRepository() {
		contas.add(new Conta(TipoConta.CB.getDescricao(), "jpsilva", TipoConta.CB));
		contas.add(new Conta(TipoConta.CC.getDescricao(), "jpsilva", TipoConta.CC));
	}
	public void addConta(Conta conta) {
		contas.add(conta);		
	}
	
	public Conta getConta(String login, TipoConta tipoConta) {
		for(Conta conta : contas) {
			if(conta.getLoginUsuario().equals(login) && conta.getTipoConta().equals(tipoConta)) {
				return conta;
			}
		}
		return null;
	}
}

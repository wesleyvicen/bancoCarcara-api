/**
 * 
 */
package model;

import utils.TipoConta;

/**
 * @author Bárbara Rodrigues, Gabriel Botelho, Guilherme Cruz, Lucas Caputo,
 *         Renan Alencar, Wesley Vicente
 *
 */
public class Conta {
	private int id;
	private String descricao;
	private String loginUsuario;
	private double saldo;
	private TipoConta tipoConta;

	public Conta(int id, String descricao, String loginUsuario, double saldo, TipoConta tipoConta) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.loginUsuario = loginUsuario;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

}

package SistemaBancario;
import javax.swing.JOptionPane;
import java.util.Random;

import javax.swing.JOptionPane;

public abstract class ContaBancaria {
	
	protected Pessoa titular;
	protected Banco banco;
	protected Random num = new Random();
	protected double saldo;
	protected String senha;
	protected int NroConta;
	
	public ContaBancaria(Pessoa titular, Banco banco, String senha) {
		this.titular = titular;
		this.banco = banco;
		this.NroConta = num.nextInt(1+1000);
		this.senha = senha;	
	}
	
	public Pessoa getTitular() {
		return titular;
	}
	
	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public int getNroConta() {
		return NroConta;
	}

	public void setNroConta(int nroConta) {
		NroConta = nroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean verificaSenha(String senha) {
		boolean correta;
		if (this.getSenha().equals(senha)) {
			correta = true;
		}else {
			correta = false;
		}
		return correta;
	}
	
	public boolean verificaSenha() {
		boolean correta;
		String testeSenha = JOptionPane.showInputDialog("Digite sua senha: ");
		if (testeSenha.equals(this.getSenha())) {
			correta = true;
		}else {
			correta = false;
			JOptionPane.showMessageDialog(null,"Senha incorreta! ");
		}
		return correta;		
	}

	public void saque(double valor, String senha) {
		if(this.verificaSenha(senha) == true) {
			if(this.getSaldo() >= valor) {
				this.setSaldo(this.getSaldo() - valor);
				System.out.println("Saque realizado com sucesso");
			}else {
				System.out.println("Saldo insuficiente");
			}			
		}else {
			System.out.println("Senha incorreta!");
		}
	}	
	
	public void saque() {
		double valor;
		valor= Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar? "));
		String senha;
		senha = JOptionPane.showInputDialog("Digite a senha da conta: ");
		
		
				
		if(this.verificaSenha(senha) == true) {
			if(this.getSaldo() >= valor) {
				this.setSaldo(this.getSaldo() - valor);
				JOptionPane.showInputDialog("Saque realizado com sucesso");
			}else {
				JOptionPane.showMessageDialog(null,"Saldo insuficiente");
			}			
		}else {
			JOptionPane.showMessageDialog(null,"Senha incorreta! ");
		}		
	}
	
	public void deposito(double valor) {
		this.setSaldo(this.getSaldo() + valor);
		System.out.println("Deposito realizado com sucesso");
		
	}
	
	public void deposito() {
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar? "));
		this.setSaldo(this.getSaldo() + valor);
		JOptionPane.showMessageDialog(null,"Deposito realizado com sucesso");
	}
	
	public void info() {
		
	}
	
}

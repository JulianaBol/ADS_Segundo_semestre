package SistemaBancario;

import javax.swing.JOptionPane;

public class ContaPoupanca extends ContaBancaria {
	
	private double rendimento;
	private int saquesMensais;
	
	public ContaPoupanca(Pessoa titular, Banco banco, String senha) {
		super(titular, banco, senha);
		this.rendimento = 0.30f;
		this.saquesMensais = 3;
	}
		
	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	public int getSaquesMensais() {
		return saquesMensais;
	}

	public void setSaquesMensais(int saquesMensais) {
		this.saquesMensais = saquesMensais;
	}
	@Override
	public void info() {
		System.out.println("===== Dados da Conta Poupança");
		System.out.println("Banco: "+ this.banco.getNome());
		System.out.println("Nro da Conta: : "+ this.getNroConta());
		System.out.println("Titular: "+ this.getTitular().nome +" "+this.getTitular().sobrenome);
		System.out.println("Saldo: "+ this.getSaldo());
		System.out.printf("%s%.2f%s%n","Rendimento mensal: ", this.getRendimento(),"%");
		System.out.println("Saques restantes: "+ this.getSaquesMensais());
		System.out.println();
	}

	@Override
	public void saque(double valor, String senha) {
		if(this.verificaSenha(senha) == true && this.getSaquesMensais() > 0) {
			if(this.getSaldo() >= valor) {
				this.setSaldo(this.getSaldo() - valor);
				this.setSaquesMensais(this.getSaquesMensais() - 1);
				System.out.println("Saque realizado com sucesso");
			}else {
				System.out.println("Saldo insuficiente");
			}			
		}else if (this.verificaSenha(senha) == false){
			System.out.println("Senha incorreta!");
		}else if (this.getSaquesMensais() == 0) {
			System.out.println("Limite de saque mensal excedido!");
		}
	}
	
	@Override
	public void saque() {
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar? "));
		String senha = JOptionPane.showInputDialog("Digite a senha da conta: ");
		
		if(this.verificaSenha(senha) == true && this.getSaquesMensais() > 0) {
			if(this.getSaldo() >= valor) {
				this.setSaldo(this.getSaldo() - valor);
				this.setSaquesMensais(this.getSaquesMensais() - 1);
				JOptionPane.showMessageDialog(null,"Saque realizado com sucesso");
			}else {
				JOptionPane.showMessageDialog(null,"Saldo insuficiente");
			}			
		}else if (this.verificaSenha(senha) == false){
			JOptionPane.showMessageDialog(null,"Senha incorreta! ");
		}else if (this.getSaquesMensais() == 0) {
			JOptionPane.showMessageDialog(null,"Limite de saque mensal excedido!");
		}	
	}
	
	public void novoMes() {
		this.setSaldo(this.getSaldo() + (this.getSaldo() * this.rendimento));
		this.setSaquesMensais(3);
	}

}

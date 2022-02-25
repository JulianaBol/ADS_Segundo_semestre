package SistemaBancario;

import java.util.ArrayList;

public class Banco {
	private String nome, cnpj;
	private int NroBanco;
	private static ArrayList<ContaBancaria> ContasBancarias; 
		
	public Banco(String nome, String cnpj, int nroBanco) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		NroBanco = nroBanco;
		ContasBancarias = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getNroBanco() {
		return NroBanco;
	}

	public void setNroBanco(int nroBanco) {
		NroBanco = nroBanco;
	}

	public ArrayList<ContaBancaria> getContasBancarias() {
		return ContasBancarias;
	}

	public void setContasBancarias(ArrayList<ContaBancaria> contasBancarias) {
		ContasBancarias = contasBancarias;
	}

	public void infoBanco() {
		
		System.out.println("===== Dados do Banco");
		System.out.println("Nome: "+ this.nome);
		System.out.println("Nro do Banco: : "+ this.NroBanco);
		System.out.println("CNPJ: "+ this.cnpj);
		System.out.println();
	}
	
	public void infoContas() {
		
		System.out.println("===== Contas do Banco");		
		ContaBancaria c;		
		for(int i = 0; i < Banco.ContasBancarias.size(); i++) {
			c = Banco.ContasBancarias.get(i);
			c.info();
		}				
	}
	
	public void CriarConta(int tipo, Pessoa titular, Banco banco, String senha) {
						
		if(tipo == 1) {
			ContaCorrente CC = new ContaCorrente(titular, banco, senha);	
			adicionaConta(CC);	
			titular.adicionaConta(CC);
		}
		if (tipo ==2) {
			ContaPoupanca CP = new ContaPoupanca(titular, banco, senha);
			adicionaConta(CP);	
			titular.adicionaConta(CP);				
		}		
	}
	
	public static void adicionaConta(ContaBancaria novaConta) {
			ContasBancarias.add(novaConta);			
	}
	
	public void encerraConta(Banco banco, int nroConta, String senha) {
		ContaBancaria conta;
		for(int i = 0; i < banco.getContasBancarias().size(); i++) {
			if(banco.getContasBancarias().get(i).getNroConta() == nroConta) {
				conta = getContasBancarias().get(i);
				if (conta.verificaSenha(senha)) {
					if(conta.getSaldo() > 0) {
						System.out.println("Primeiro realize um saque de "+conta.getSaldo());
					}else {
						conta = null;
						System.out.println("===== Contas Encerrada =====");
					}
					
				}else {
					System.out.println("Senha incorreta!");
				}
				
			}
		}
	}
	
	
	
}

package SistemaBancario;

import java.util.ArrayList;

public class Pessoa {
	String nome, sobrenome;
	private String cpf;
	int idade;
	private ArrayList<ContaBancaria> ContasBancarias;	
	
	public Pessoa(String nome, String sobrenome, int idade, String cpf) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.cpf = cpf;
		this.ContasBancarias = new ArrayList<>();
	}		
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public ArrayList<ContaBancaria> getContasBancarias() {
		return ContasBancarias;
	}

	public void setContasBancarias(ArrayList<ContaBancaria> contasBancarias) {
		ContasBancarias = contasBancarias;
	}

	public void info() {
		System.out.println("===== Dados do Cliente");
		System.out.println("Nome: "+this.nome+" "+this.sobrenome);	
		System.out.println("Idade: "+this.idade);
		System.out.println("Cpf: "+this.cpf);
		System.out.println();
		infoContas();
	}
	
	public void infoContas() {
		ContaBancaria c;
		for(int i = 0; i < this.ContasBancarias.size(); i++) {
			c = this.ContasBancarias.get(i);
			c.info();
			
		}		
	}
	
	public void adicionaConta(ContaBancaria conta) {
		this.ContasBancarias.add(conta);
	}	
	
}

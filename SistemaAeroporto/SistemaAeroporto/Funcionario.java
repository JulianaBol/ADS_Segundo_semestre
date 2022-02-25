package SistemaAeroporto;

import javax.swing.JOptionPane;

public class Funcionario {
	
	protected String nome, cargo;
	protected double salario;
	
	public Funcionario(String nome, String cargo, double salario) {
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	public void NovoSalario(double novoSalario) {
		this.salario = novoSalario;
		System.out.println("===== Op.novo sal�rio");
		System.out.println("funcion�rio: "+this.nome);	
		System.out.printf("%s%.2f%n","Sal�rio atualizado: ",this.salario);
		System.out.println();
	}
	
	public void NovoSalario() {
		this.salario = Double.parseDouble(JOptionPane.showInputDialog("Qual o novo sal�rio do funcion�rio? "));
		System.out.println("===== Op.novo sal�rio");
		System.out.println("funcion�rio: "+this.nome);	
		System.out.printf("%s%.2f%n","Sal�rio atualizado: ",this.salario);
		System.out.println();
	}
	public void info() {
		System.out.println("===== Informa��es do funcion�rio");
		System.out.println("Nome: "+this.nome);
		System.out.println("Cargo: "+this.cargo);
		System.out.println("Sal�rio: "+this.salario);
		System.out.println();
		
	}
	
	

}

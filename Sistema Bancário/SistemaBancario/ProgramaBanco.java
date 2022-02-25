package SistemaBancario;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ProgramaBanco {
	
	static ArrayList<Banco> Bancos = new ArrayList<>();
	static ArrayList<Pessoa> Clientes = new ArrayList<>();
	
	public static void adicionaBanco(Banco novoBanco) {
		Bancos.add(novoBanco);
	}
	
	public static void mostraBancos() {
		Banco b;
		for(int i = 0; i < Bancos.size(); i++) {
			b = Bancos.get(i);
			b.infoBanco();
		}		
	}
	
	public static void adicionaCliente(Pessoa novoCliente) {
		Clientes.add(novoCliente);
	}
	
	public static void mostraClientes() {
		Pessoa p;
		for(int i = 0; i < Clientes.size(); i++) {
			p = Clientes.get(i);
			p.info();
		}		
	}
	
	public static void abrirMenu() {
		
		System.out.println("    Sistema Bancário ");
		System.out.println("\n   --------------------------");
		System.out.println("       MENU DE OPÇÕES:");
		System.out.println("   --------------------------");
		System.out.println("   [1] - Cadastrar novo banco");
		System.out.println("   [2] - Listar Bancos");
		System.out.println("   [3] - Cadastrar novo cliente");
		System.out.println("   [4] - Listar informações clientes");
		System.out.println("   [5] - Cadastrar nova conta");	
		System.out.println("   [6] - Encerrar conta");
		System.out.println("   [7] - Realizar saque");
		System.out.println("   [8] - Verificar saldo");
		System.out.println("   [9] - Realizar deposito");
		System.out.println("   [0] - Encerrar atividades");		
		System.out.println("  \n   Digite a sua opção: ");		

	}		
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int operacao, nroBanco, idade, nroConta;
		Banco banco;
		ContaBancaria conta;
		String nomeBanco, cnpj, nomeCliente, sobrenome, cpf, senha;
		double valor;
				
		abrirMenu();
		operacao = input.nextInt();
		input.nextLine();
		
		while (operacao != 0) {
			if(operacao == 1) {
				System.out.println("Digite o nome do Banco:"); nomeBanco = input.nextLine();
				System.out.println("Digite o CNPJ:"); cnpj = input.nextLine();
				System.out.println("Digite o número do Banco:"); nroBanco = input.nextInt();
				input.nextLine();
				
				Banco novoBanco = new Banco(nomeBanco, cnpj, nroBanco);
				adicionaBanco(novoBanco);	
				
				System.out.println("Banco cadastrado com sucesso");
			}	
			if(operacao == 2) {
				mostraBancos();
			}
			if(operacao == 3) {
				System.out.println("Digite o nome do cliente:"); nomeCliente = input.nextLine();
				System.out.println("Digite o sobrenome:"); sobrenome = input.nextLine();
				System.out.println("Digite o CPF:"); cpf = input.nextLine();
				System.out.println("Digite a idade:"); idade = input.nextInt();
				input.nextLine();
								
				Pessoa novoCliente = new Pessoa(nomeCliente, sobrenome, idade, cpf);
				adicionaCliente(novoCliente);
				
				System.out.println("Cliente cadastrado com sucesso");
			}
			if(operacao == 4) {
				mostraClientes();
			}
			if(operacao == 5) {
				int opcao;
				Pessoa titular = null;
				boolean clienteOk = false, bancoOK = false;
				System.out.println("Digite [1] para Conta Corrente ou [2] para Conta Poupança"); opcao = input.nextInt();
				input.nextLine();
				System.out.println("Digite o cpf do titular:"); cpf = input.nextLine();				
				for(int i = 0; i < Clientes.size(); i++) {
					if(Clientes.get(i).getCpf().equals(cpf)) {						
						titular = Clientes.get(i);
						clienteOk = true;
						break;
					}else {
						continue;
					}
				}
				if(clienteOk = false) {
					System.out.println("Cliente não cadastrado! Primeiro realize o cadastro do cliente.");
					System.out.println();					
				}			
				if(clienteOk = true) {	
					System.out.println("Digite o codigo do banco:"); nroBanco = input.nextInt();
					input.nextLine(); 
					for( int j = 0; j < Bancos.size(); j++) {
						if(Bancos.get(j).getNroBanco() == nroBanco) {
							bancoOK = true;
							System.out.println("Cadastre uma senha:"); senha = input.nextLine(); 
							Bancos.get(j).CriarConta(opcao, titular, Bancos.get(j), senha);
							System.out.println("Conta criada com sucesso");							
							break;
						}				
					}
					if (bancoOK == false) {
						System.out.println("Banco não cadastrado! Primeiro realize o cadastro do banco.");
						System.out.println();
					}						
				}												
			}
			if(operacao == 6) {
				
				System.out.println("Digite o codigo do banco:"); nroBanco = input.nextInt();
				System.out.println("Digite o número da conta:");nroConta = input.nextInt(); 
				input.nextLine();
				System.out.println("Digite a senha da conta:");senha = input.nextLine();
				for(int i = 0; i < Bancos.size(); i++) {
					if(Bancos.get(i).getNroBanco() == nroBanco) {
						banco = Bancos.get(i);
						banco.encerraConta(banco, nroConta, senha);
						break;
					}					
				}										
			}
			if (operacao == 7) {				
				System.out.println("Digite o codigo do banco:"); nroBanco = input.nextInt();
				System.out.println("Digite o número da conta:");nroConta = input.nextInt(); 
				input.nextLine();
				for(int i = 0; i < Bancos.size(); i++) {
					if(Bancos.get(i).getNroBanco() == nroBanco) {
						for(int j = 0; j < Bancos.get(i).getContasBancarias().size(); i++) {
							if(Bancos.get(i).getContasBancarias().get(j).getNroConta() == nroConta) {
								conta = Bancos.get(i).getContasBancarias().get(j);
								conta.saque();
								break;
							}else {
								System.out.println("Conta não encontrada:");
								break;
							}
						}	
						break;
					}					
				}
			}
			if(operacao == 8) {
				System.out.println("Digite o codigo do banco:"); nroBanco = input.nextInt();
				System.out.println("Digite o número da conta:");nroConta = input.nextInt(); 
				input.nextLine();
				for(int i = 0; i < Bancos.size(); i++) {
					if(Bancos.get(i).getNroBanco() == nroBanco) {
						for(int j = 0; j < Bancos.get(i).getContasBancarias().size(); i++) {
							if(Bancos.get(i).getContasBancarias().get(j).getNroConta() == nroConta) {
								conta = Bancos.get(i).getContasBancarias().get(j);
								conta.info();
								break;
							}else {
								System.out.println("Conta não encontrada:");
								break;
							}
						}	
						break;
					}
					
				}
			}
			
			if(operacao == 9) {
				System.out.println("Digite o codigo do banco:"); nroBanco = input.nextInt();
				System.out.println("Digite o número da conta:");nroConta = input.nextInt(); 
				input.nextLine();
				for(int i = 0; i < Bancos.size(); i++) {
					if(Bancos.get(i).getNroBanco() == nroBanco) {
						for(int j = 0; j < Bancos.get(i).getContasBancarias().size(); i++) {
							if(Bancos.get(i).getContasBancarias().get(j).getNroConta() == nroConta) {
								conta = Bancos.get(i).getContasBancarias().get(j);
								conta.deposito();
								break;
							}else {
								System.out.println("Conta não encontrada:");
								break;
							}
						}	
						break;
					}
					
				}
			}
			abrirMenu();
			operacao = input.nextInt();
			input.nextLine();
		}

	}
}

package Avaliacao1;
import java.util.Scanner;

public class CadastroAlunos {

	String nome[] = new String[50];
	String sobrenome[] =  new String[50];
	String nomeCompleto[]=  new String[50];
	double nota [] =  new double [50];
	double totNota, media, totAluno = 0;
	int matricula[] = new int[50];
	
	
	
	public CadastroAlunos() {
		for(int i = 0; i <nome.length; i++) {
			nomeCompleto[i]= nome[i]+" "+sobrenome[i];
			nota[i]= -1;
		}
	}
	public void menu() {
		System.out.println("       MENU DE OPÇÕES:");
		System.out.println("   --------------------------");
		System.out.println("   [1] - Cadastro de aluno");
		System.out.println("   [2] - Informações de aluno");
		System.out.println("   [3] - Modificar nota");
		System.out.println("   [4] - Média de notas");
		System.out.println("   [0] - Sair");
		System.out.println("  \n   Digite a sua opção: ");
	}
	public void CadastroNome(String n) {
		for (int i = 0; i < nome.length; i++) {
			if(nome[i]==null) {
				nome[i] = n;
				matricula[i] = i;
				totAluno++;
			}
			break;
		}			
	}
	public void CadastroSobreNome(String sn) {
		for (int i = 0; i < nome.length; i++) {
			if(sobrenome[i]==null) {
				sobrenome[i] = sn;
				matricula[i] = i;
			}
			break;
		}			
	}
	public void CadastroNota(double nt) {
		for (int i = 0; i < nota.length; i++) {
			if(nota[i] == -1) {
				nota[i] = nt;
				totNota += nota[i];
			}
			break;
		}	
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int op, mat;
		Prova1 aluno = new Prova1();
		aluno.menu();
		op = input.nextInt();
		while(op < 0 || op > 4 ) {
			System.out.println("Opção inválida! Digite uma das opções do menu;");
			op = input.nextInt();
		}			
		while(op != 0) {
			if(op == 1) {
				System.out.println("Digite o nome do aluno:");
				//aluno.Nome(input.next());
				System.out.println("Digite o sobrenome do aluno:");
				//aluno.SobreNome(input.next());
				
				System.out.println("Digite a nota do aluno:");
			//	aluno.CadastroNota(input.nextDouble());
				System.out.println("Aluno cadastrado com sucesso!\n");			
			}			
			if(op == 2) {
				aluno.Informacoes();
			}
			if(op ==3) {
				System.out.println("Digite a matrícula do aluno:");
				mat = input.nextInt();
				aluno.Vazio(mat);
				if(aluno.Vazio(mat)==false) {
					System.out.println("Digite a nova nota do aluno:");
					aluno.MudaNota(mat, input.nextDouble());
				}								
			}
			if(op == 4) {
				aluno.MostraMedia();				
			}
			aluno.menu();
			op = input.nextInt();
		}		
		
	}

		
	}



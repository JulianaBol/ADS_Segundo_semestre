package Avaliacao1;
import java.util.Scanner;

public class Prova1 {

	String nome[] = new String[50];
	double nota [] =  new double [50];
	double totNota, media, totAluno = 0;
	int matricula[] = new int[50];
					
	public Prova1() {
		
	}
	public void menu() {
		System.out.println("      \n\n   MENU DE OPÇÕES:");
		System.out.println("   --------------------------");
		System.out.println("   [1] - Cadastro de aluno");
		System.out.println("   [2] - Informações de aluno");
		System.out.println("   [3] - Modificar nota");
		System.out.println("   [4] - Média de notas");
		System.out.println("   [0] - Sair");
		System.out.println("  \n   Digite a sua opção: ");
	}
	
	public int Nome(String n, String sn) {
		int mat=-1;
		for (int i = 0; i < nome.length; i++) {
			if(nome[i]==null) {
				nome[i] = n+" "+sn;
				matricula[i] = i;
				totAluno++;
				mat = matricula[i];
			}else {
				continue;
			}
			break;			
		}	
		return mat;
	}	
	public void CadastroNota(int mat,double nt) {	
		
		for (int i = 0; i < nota.length; i++) {
			if(mat == i) {
				nota[i] = nt;
				totNota += nota[i];
			}else {
				continue;
			}
			break;
		}	
	}
	public void Informacoes() {
		
		System.out.printf("%s%.0f","Alunos cadastrados: ",totAluno);
		System.out.println("\n--------------------------");
		for(int i =0; i < nome.length; i++) {
			if(nome[i] !=null) {
			System.out.println("Matricula: "+matricula[i]+" Nome: "+nome[i]+" Nota: "+nota[i]+"\n");
			}			
		}
	}
	public boolean Vazio(int m) {
		boolean vazio = false;
		for(int i = 0; i < nome.length; i++) {
			if(m == i && nome[i]==null) {
				System.out.println("Não existe aluno cadastrado nesta matrícula!");
				vazio = true;
				break;
			}
		}
		return vazio;
	}
	public void MudaNota(int mat, double n) {
		for(int i = 0; i < nome.length; i++) {
			if(i == mat && nome[i]!= null) {
				totNota -= nota[i];
				totNota +=n;
				nota[i]=n;
			}
		}			
	}
	public void MostraMedia() {
		media = totNota/totAluno;
		System.out.printf("%s%.2f","A média da turma é:",media,"\n");
	}	
		
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int op, mat;
		String nome, sobrenome;
		double nota;
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
				nome = input.next();
				System.out.println("Digite o sobrenome do aluno:");
				sobrenome = input.next();
				mat = aluno.Nome(nome,sobrenome);				
				System.out.println("Digite a nota do aluno:");
				nota = input.nextDouble();
				if(nota < 0 || nota > 10) {
					System.out.println("Nota inválida! Digite uma nota entre 0 e 10");
					nota = input.nextDouble();
				}
				aluno.CadastroNota(mat, nota);
				System.out.println("Aluno cadastrado com sucesso!\n");			
			}			
			if(op == 2) {
				if(aluno.totAluno == 0) {
					System.out.println("Não existem alunos cadastrados!");					
				}else {
					aluno.Informacoes();
				}
			}
			if(op ==3) {
				System.out.println("Digite a matrícula do aluno:");
				mat = input.nextInt();
				aluno.Vazio(mat);
				if(aluno.Vazio(mat)==false) {
					System.out.println("Digite a nova nota do aluno:");
					nota = input.nextDouble();
					if(nota < 0 || nota > 10) {
						System.out.println("Nota inválida! Digite uma nota entre 0 e 10");
						nota = input.nextDouble();
					}
					aluno.MudaNota(mat,nota);
				}								
			}
			if(op == 4) {
				aluno.MostraMedia();				
			}
			aluno.menu();
			op = input.nextInt();
		}
		System.out.println("Sistema encerrado!");				
	}
}

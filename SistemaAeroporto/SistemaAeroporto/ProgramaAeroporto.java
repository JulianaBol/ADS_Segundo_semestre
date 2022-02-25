package SistemaAeroporto;
import java.util.Scanner;
public class ProgramaAeroporto {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Funcionario f1 = new Funcionario("Tatiana Paz", "Aeromoça", 2500);
		Piloto p1 = new Piloto("José Cuervo", "JC6756", 5700);
		Aviao a1 = new Aviao("CV 5547", "GOL", "Boeing 747");
		Voo v1 = new Voo ("ARG 101", "Porto Alegre", "Buenos Aires", p1,a1);
		f1.info();
		a1.info();
		p1.info();
		v1.info();
		f1.NovoSalario();
		f1.NovoSalario(3000);
		p1.ModHoraVoo(1000);
	}

}

package SistemaAeroporto;

public class Piloto extends Funcionario{
	protected String brevet;
	protected int HorasVoo;
	
	public Piloto (String nome, String brevet, int HorasVoo) {
		super(nome, null, 0);
		this.brevet = brevet;
		this.HorasVoo = HorasVoo;
		Calcsalario(HorasVoo);
	}
	
	public void Calcsalario(int horaVoo) {
		this.salario = 3500 + (horaVoo/2);
	}
	
	public void ModHoraVoo(int horaVoo) {
		this.HorasVoo += horaVoo;
		this.Calcsalario(HorasVoo);
		System.out.println("===== Op.modifica Horas Vôo");
		System.out.println("Piloto: "+this.nome);	
		System.out.println("Horas vôo atual: "+this.HorasVoo);
		System.out.printf("%s%.2f%n","Salário atualizado: ",this.salario);
		System.out.println();
		
	}
	
	public void info() {
		
		System.out.println("===== Informações do Piloto");
		System.out.println("Nome: "+this.nome);	
		System.out.println("Brevet: "+this.brevet);
		System.out.println("Horas vôo: "+this.HorasVoo);
		System.out.printf("%s%.2f%n","Salário: ",this.salario);
		System.out.println();
		
	}
	
}

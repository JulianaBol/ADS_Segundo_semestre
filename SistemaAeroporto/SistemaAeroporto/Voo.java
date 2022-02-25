package SistemaAeroporto;

public class Voo {
	
	private String CodVoo, Origem, Destino;
	private Piloto Comandante;
	private Aviao Aeronave;		
	
	public Voo(String codVoo, String origem, String destino, Piloto comandante, Aviao aeronave) {
		super();
		this.CodVoo = codVoo;
		this.Origem = origem;
		this.Destino = destino;
		this.Comandante = comandante;
		this.Aeronave = aeronave;
	}

	public void info() {
		System.out.println("===== Informações do Vôo");
		System.out.println("Vôo/Empresa: "+this.CodVoo + "/" + this.Aeronave.empresa);		
		System.out.println("Origem/Destino: "+this.Origem + "/" + this.Destino);
		System.out.println("Aeronave: "+this.Aeronave.modelo + "/"+ this.Aeronave.prefixo);
		System.out.println("Comandante: "+this.Comandante.nome);
		System.out.println();
	}

}

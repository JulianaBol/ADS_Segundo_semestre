package SistemaAeroporto;

public class Aviao{
	
	protected String prefixo, empresa, modelo;
	
	public Aviao(String prefixo, String empresa, String modelo) {
		this.prefixo = prefixo;
		this.empresa = empresa;
		this.modelo = modelo;
	}
	
	public void info() {
		System.out.println("===== Informações do Avião");
		System.out.println("Empresa: "+this.empresa);		
		System.out.println("Prefixo: "+this.prefixo);
		System.out.println("Modelo: "+this.modelo);
		System.out.println();
	}
	
}
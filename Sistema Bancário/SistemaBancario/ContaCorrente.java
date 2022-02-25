package SistemaBancario;

public class ContaCorrente extends ContaBancaria {

	double taxasMensais;
	
	public double getTaxasMensais() {
		return taxasMensais;
	}

	public void setTaxasMensais(double taxasMensais) {
		this.taxasMensais = taxasMensais;
	}

	public ContaCorrente(Pessoa titular, Banco banco, String senha) {
		super(titular, banco, senha);
		this.setTaxasMensais(12.95f);
	}
	
	public void info() {
		System.out.println("===== Dados da Conta Corrente");
		System.out.println("Banco: "+ this.banco.getNome());
		System.out.println("Nro da Conta: : "+ this.getNroConta());
		System.out.println("Titular: "+ this.getTitular().nome +" "+this.getTitular().sobrenome);
		System.out.println("Saldo: "+ this.getSaldo());
		System.out.printf("%s%.2f%n","Taxas mensais: ", this.getTaxasMensais());
		System.out.println();
	}
	
	public void novoMes() {
		this.setSaldo(this.getSaldo() - this.getTaxasMensais());
	}
	
}

package JgVelha;
import java.util.Scanner;

public class JogoDaVelha {
	//atributos
	String vencedor;
	String simbolo;
	String m[][]= {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
	int totJogadas = 0;
	boolean ganha[] = new boolean[8];
	boolean acabou;
	
	public JogoDaVelha() {
		System.out.println("  ---+---+---");
		for(int l = 0; l < 3; l++) {
			for(int c = 0; c < 3; c++) {
				System.out.print(" | "+m[l][c]);
			}
			System.out.println(" | ");
			System.out.println("  ---+---+---");
		}		
		simbolo = "X";
		acabou = false;
	}	
	public String MostraVelha() {
		
		System.out.println("  ---+---+---");
		for(int l = 0; l < 3; l++) {
			for(int c = 0; c < 3; c++) {
				System.out.print(" | "+m[l][c]);
			}
			System.out.println(" | ");
			System.out.println("  ---+---+---");
		}	
		return null;
	}
	public boolean jgValida(String pos) {
		boolean valida = false;
		for(int l = 0; l < 3; l++) {
			for(int c = 0; c < 3; c++) {
				if(m[l][c].equals(pos)) {
					valida = true;
				}
			}
		}
		return valida;
	}
	public String jogadas(String pos) {
	
		for(int l = 0; l < 3; l++) {
			for(int c = 0; c < 3; c++) {
				if(m[l][c].equals(pos)) {
					m[l][c]=simbolo;
					totJogadas++;
				}				
			}
		}
		return simbolo;		
	}
	public void trocaJogador() {
		if(simbolo == "X") {
			simbolo = "O";
		}else {
			simbolo = "X";
		}			
	}
	
	public String jogoCpu() {
		//ataques primeira linha
		if(m[0][0].equals("O") && m[0][1].equals("O") && m[0][2]!="X"){
			m[0][2]="O";
		}else if(m[0][0].equals("O") && m[0][2].equals("O") && m[0][1]!="X") {
			m[0][1]="O";
		}else if(m[0][1].equals("O") && m[0][2].equals("O") && m[0][0]!="X") {
			m[0][0]="O";

		}//segunda linha
		else if(m[1][0].equals("O") && m[1][1].equals("O") && m[1][2]!="X"){
			m[1][2]="O";
		}else if(m[1][0].equals("O") && m[1][2].equals("O") && m[1][1]!="X") {
			m[1][1]="O";
		}else if(m[1][1].equals("O") && m[1][2].equals("O") && m[1][0]!="X") {
			m[1][0]="O";

		}//terceira linha
		else if(m[2][0].equals("O") && m[2][1].equals("O") && m[2][2]!="X"){
			m[2][2]="O";
		}else if(m[2][0].equals("O") && m[2][2].equals("O") && m[2][1]!="X") {
			m[2][1]="O";
		}else if(m[2][1].equals("O") && m[2][2].equals("O") && m[2][0]!="X") {
			m[2][0]="O";

		}//primeira coluna
		else if(m[0][0].equals("O") && m[1][0].equals("O") && m[2][0]!="X"){
			m[2][0]="O";
		}else if(m[0][0].equals("O") && m[2][0].equals("O") && m[1][0]!="X"){
			m[1][0]="O";
		}else if(m[2][0].equals("O") && m[1][0].equals("O") && m[0][0]!="X") {
			m[0][0]="O";

		}//segunda coluna
		else if(m[0][1].equals("O") && m[1][1].equals("O") && m[2][1]!="X"){
			m[2][1]="O";
		}else if(m[0][1].equals("O") && m[2][1].equals("O") && m[1][1]!="X"){
			m[1][1]="O";
		}else if(m[1][1].equals("O") && m[2][1].equals("O") && m[0][1]!="X") {
			m[0][1]="O";
		}//terceira coluna
		else if(m[0][2].equals("O") && m[1][2].equals("O") && m[2][2]!="X"){
			m[2][2]="O";
		}else if(m[0][2].equals("O") && m[2][2].equals("O") && m[1][2]!="X"){
			m[1][2]="O";
		}else if(m[1][2].equals("O") && m[2][2].equals("O") && m[0][2]!="X") {
			m[0][2]="O";
		}//diagonais
		else if(m[0][0].equals("O") && m[1][1].equals("O") && m[2][2]!="X") {
			m[2][2]="O";
		}else if(m[0][0].equals("O") && m[2][2].equals("O") && m[1][1]!="X") {
			m[1][1]="O";
		}else if(m[1][1].equals("O") && m[2][2].equals("O") && m[0][0]!="X") {
			m[0][0]="O";
				
		}else if(m[0][2].equals("O") && m[1][1].equals("O") && m[2][0]!="X") {
			m[2][0]="O";
		}else if(m[0][2].equals("O") && m[2][0].equals("O") && m[1][1]!="X") {
			m[1][1]="O";
		}else if(m[1][1].equals("O") && m[2][0].equals("O") && m[0][2]!="X") {
			m[0][2]="O";
		}
		//defesa primeira linha
		else if(m[0][0].equals("X") && m[0][1].equals("X")){
			m[0][2]="O";
		}else if(m[0][0].equals("X") && m[0][2].equals("X")) {
			m[0][1]="O";
		}else if(m[0][1].equals("X") && m[0][2].equals("X")) {
			m[0][0]="O";
		}
		//segunda linha
		else if(m[1][0].equals("X") && m[1][1].equals("X")){
			m[1][2]="O";
		}else if(m[1][0].equals("X") && m[1][2].equals("X")) {
			m[1][1]="O";
		}else if(m[1][1].equals("X") && m[1][2].equals("X")) {
			m[1][0]="O";
		}
		//terceira linha
		else if(m[2][0].equals("X") && m[2][1].equals("X")){
			m[2][2]="O";
		}else if(m[2][0].equals("X") && m[2][2].equals("X")) {
			m[2][1]="O";
		}else if(m[2][1].equals("X") && m[2][2].equals("X")) {
			m[2][0]="O";
		}
		//primeira coluna
		else if(m[0][0].equals("X") && m[1][0].equals("X")){
			m[2][0]="O";
		}else if(m[0][0].equals("X") && m[2][0].equals("X")){
			m[1][0]="O";
		}else if(m[2][0].equals("X") && m[1][0].equals("X")) {
			m[0][0]="O";
		}
		//segunda coluna
		else if(m[0][1].equals("X") && m[1][1].equals("X")){
			m[2][1]="O";
		}else if(m[0][1].equals("X") && m[2][1].equals("X")){
			m[1][1]="O";
		}else if(m[1][1].equals("X") && m[2][1].equals("X")) {
			m[0][1]="O";
		}
		//terceira coluna
		else if(m[0][2].equals("X") && m[1][2].equals("X")){
			m[2][2]="O";
		}else if(m[0][2].equals("X") && m[2][2].equals("X")){
			m[1][2]="O";
		}else if(m[1][2].equals("X") && m[2][2].equals("X")) {
			m[0][2]="O";
		}
		//diagonais
		else if(m[0][0].equals("X") && m[1][1].equals("X")) {
			m[2][2]="O";
		}else if(m[0][0].equals("X") && m[2][2].equals("X")) {
			m[1][1]="O";
		}else if(m[1][1].equals("X") && m[2][2].equals("X")) {
			m[0][0]="O";
					
		}else if(m[0][2].equals("X") && m[1][1].equals("X")) {
			m[2][0]="O";
		}else if(m[0][2].equals("X") && m[2][0].equals("X")) {
			m[1][1]="O";
		}else if(m[1][1].equals("X") && m[2][0].equals("X")) {
			m[0][2]="O";
		}else {		
			for(int l = 0; l < 3; l++) {
				for(int c = 0; c < 3; c++) {
					if(m[l][c] != "X" && m[l][c] != simbolo) {
						m[l][c]=simbolo;
						break;
					}else {
						continue;
					}
				}break;
			}
		}	
		totJogadas++;
		return simbolo;
	}
	public boolean ganhar() {
		acabou = false;
		//em linha
		if(m[0][0].equals(m[0][1]) && m[0][1].equals(m[0][2])) {
			acabou = true;
			vencedor = m[0][0];
		}
		else if (m[1][0].equals(m[1][1]) && m[1][1].equals(m[1][2])) {
			acabou = true;
			vencedor = m[1][0];
		}
		else if ((m[2][0].equals(m[2][1]) && m[2][1].equals(m[2][2]))) {
			acabou = true;
			vencedor = m[2][0];
		}
		//em coluna
		else if(m[0][0].equals(m[1][0]) && m[1][0].equals(m[2][0])) {
			acabou = true;
			vencedor = m[0][0];
		}
		else if (m[0][1].equals(m[1][1]) && m[1][1].equals(m[2][1])) {
			acabou = true;
			vencedor = m[0][1];
		}
		else if ((m[0][2].equals(m[1][2]) && m[1][2].equals(m[2][2]))) {
			acabou = true;
			vencedor = m[0][2];
		}
		//diagonais
		else if (m[0][0].equals(m[1][1]) && m[1][1].equals(m[2][2])) {
			acabou = true;
			vencedor = m[0][1];
		}
		else if ((m[0][2].equals(m[1][1]) && m[1][1].equals(m[2][0]))) {
			acabou = true;
			vencedor = m[0][2];
		}		
		return acabou;		
	}
	
	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
		String posicao;
		boolean valida = false;
		JogoDaVelha novoJogo = new JogoDaVelha();
		
		while(novoJogo.ganhar()==false) {
			
			System.out.println("Jogada do usuário:");posicao = input.next();
			while(novoJogo.jgValida(posicao)==false) {
				System.out.println("Jogada inválida! Escolha outra posição");
				posicao = input.next();
			}
			novoJogo.jogadas(posicao);
			novoJogo.MostraVelha();					
			novoJogo.trocaJogador();			
			System.out.println("Jogada do computador:");
			novoJogo.jogoCpu();
			novoJogo.MostraVelha();				
			novoJogo.trocaJogador();
			if(novoJogo.ganhar()==false && novoJogo.totJogadas >= 9) {
				System.out.println("Deu velha!!!");
				break;
			}		
		}
		if(novoJogo.ganhar()) { 
			if(novoJogo.vencedor == "X") {
				System.out.println("O vencedor foi o usuário!");
			}else if (novoJogo.vencedor == "O") {
				System.out.println("O vencedor foi o computador!");
			}			
		}
		
	}
}

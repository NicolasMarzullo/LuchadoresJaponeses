package edu.unlam.luchador;

public class Luchador {
	private int peso;
	private int altura;
	
	public Luchador(int peso, int altura) {
		this.peso = peso;
		this.altura = altura;
	}
	
	public boolean domina(Luchador otro) {
		if(this.peso > otro.peso && this.altura > otro.altura)
			return true;
		
		if(this.peso > otro.peso && this.altura == otro.altura)
			return true;
		
		if(this.peso == otro.peso && this.altura > otro.altura)
			return true;
		
		return false;
	}
}

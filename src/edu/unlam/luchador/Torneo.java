package edu.unlam.luchador;

public class Torneo {
	private Luchador[] luchadores;
		
	public Torneo(Luchador[] luchadores) {
		this.luchadores = luchadores;
	}

	public int[] resolver() {
		
		int[] resultado = new int[luchadores.length];
		
		for(int i = 0; i < this.luchadores.length; i++) {
			for(int j = i+1; j< this.luchadores.length; j++) {
					if(luchadores[i].domina(luchadores[j]))
						resultado[i] ++;
					else if(luchadores[j].domina(luchadores[i]))
						resultado[j] ++;
			}
		}
		
		return resultado;
	}
	
	
}

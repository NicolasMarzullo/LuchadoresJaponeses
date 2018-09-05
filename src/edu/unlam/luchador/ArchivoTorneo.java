package edu.unlam.luchador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class ArchivoTorneo {
	
	public static Torneo leer(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		int cantLuchadores = sc.nextInt();
		Luchador[] luchadores = new Luchador[cantLuchadores];
		
		for(int i = 0; i < cantLuchadores; i++) {
			luchadores[i] = new Luchador(sc.nextInt(),  sc.nextInt());
		}
		
		sc.close();
		return new Torneo(luchadores);
	}
	
	public static void escribir(String path, int[] ) throws FileNotFoundException {
		FileWriter writer = new FileWriter(new File(path));
		int cantLuchadores = sc.nextInt();
		Luchador[] luchadores = new Luchador[cantLuchadores];
		
		for(int i = 0; i < cantLuchadores; i++) {
			luchadores[i] = new Luchador(sc.nextInt(),  sc.nextInt());
		}
		
		sc.close();
		return new Torneo(luchadores);
	}
}

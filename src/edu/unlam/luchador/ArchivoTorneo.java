package edu.unlam.luchador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArchivoTorneo {

	public static Torneo leer(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		int cantLuchadores = sc.nextInt();
		System.out.println(cantLuchadores);
		Luchador[] luchadores = new Luchador[cantLuchadores];

		for (int i = 0; i < cantLuchadores; i++) {
			luchadores[i] = new Luchador(sc.nextInt(), sc.nextInt());
		}

		sc.close();
		return new Torneo(luchadores);
	}

	public static void escribir(String path, int[] resultado) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter(path));

		for (int i = 0; i < resultado.length; i++) {
			salida.println(resultado[i]);
		}

		salida.close();
	}
	

	public static boolean testIgualdadArchivos(String pathOrigen, String pathDestino) {

		String cadenaOrigen;
		String cadenaDestino;
		boolean iguales = true;

		Scanner scOrigen = null;
		Scanner scDestino = null;
		try {
			scOrigen = new Scanner(new File(pathOrigen));
			scDestino = new Scanner(new File(pathDestino));

			cadenaOrigen = scOrigen.nextLine();
			cadenaDestino = scDestino.nextLine();

			while (scOrigen.hasNextLine() && scDestino.hasNextLine() && iguales) {

				cadenaOrigen = scOrigen.nextLine();
				cadenaDestino = scDestino.nextLine();

				if (!cadenaOrigen.equals(cadenaDestino))
					iguales = false;
			}

			if (scOrigen.hasNextLine() || scDestino.hasNextLine())
				iguales = false;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scOrigen.close();
			scDestino.close();
		}

		return iguales;
	}

}

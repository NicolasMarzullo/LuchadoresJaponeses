package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import edu.unlam.luchador.ArchivoTorneo;
import edu.unlam.luchador.Luchador;
import edu.unlam.luchador.Torneo;


public class TestTorneo {
	
	@Test
	public void testEmpatan(){
				
		Luchador l1 = new Luchador(200, 1800);
		Luchador l2 = new Luchador(200, 1800);
		
		Assert.assertEquals(false, l1.domina(l2));
	}
	
	
	@Test
	public void testGanaPrimeroPorAmbas(){
				
		Luchador l1 = new Luchador(300, 2800);
		Luchador l2 = new Luchador(200, 1800);
		
		Assert.assertEquals(true, l1.domina(l2));
	}
	
	@Test
	public void testGanaPrimeroPorPeso(){
				
		Luchador l1 = new Luchador(300, 1800);
		Luchador l2 = new Luchador(200, 1800);
		
		Assert.assertEquals(true, l1.domina(l2));
	}
	
	@Test
	public void testGanaPrimeroPorAltura(){
				
		Luchador l1 = new Luchador(200, 2800);
		Luchador l2 = new Luchador(200, 1800);
		
		Assert.assertEquals(true, l1.domina(l2));
	}
	
	
	@Test
	public void testNoGanaNadie(){
				
		Luchador l1 = new Luchador(500, 2800);
		Luchador l2 = new Luchador(900, 1800);
		
		Assert.assertEquals(false, l1.domina(l2));
	}
	
	@Test
	public void testTorneoGeneral(){
		int[] resultado = new int[5];
		int[] resultadoOK = new int[5];
		Luchador luchadores[] = new Luchador[5];
		luchadores[0] = new Luchador(500, 2800);
		luchadores[1] = new Luchador(900, 1800);
		luchadores[2] = new Luchador(1100, 1000);
		luchadores[3] = new Luchador(230, 800);
		luchadores[4] = new Luchador(550, 4500);		
		
		resultadoOK[0] = 1;
		resultadoOK[1] = 1;
		resultadoOK[2] = 1;
		resultadoOK[3] = 0;
		resultadoOK[4] = 2;
		
		Torneo torneo = new Torneo(luchadores);
	
		resultado = torneo.resolver();
		
		for(int i=0; i<5;i++)
			Assert.assertEquals(resultadoOK[i], resultado[i]);
	}
	
	
	@Test
	public void testTorneoExtremos(){
		int[] resultado = new int[5];
		int[] resultadoOK = new int[5];
		Luchador luchadores[] = new Luchador[5];
		luchadores[0] = new Luchador(300, 1800);
		luchadores[1] = new Luchador(100, 400);
		luchadores[2] = new Luchador(100, 400);
		luchadores[3] = new Luchador(100, 400);
		luchadores[4] = new Luchador(400, 2000);		
		
		resultadoOK[0] = 3;
		resultadoOK[1] = 0;
		resultadoOK[2] = 0;
		resultadoOK[3] = 0;
		resultadoOK[4] = 4;
		
		Torneo torneo = new Torneo(luchadores);
	
		resultado = torneo.resolver();
		
		for(int i=0; i<5;i++)
			Assert.assertEquals(resultadoOK[i], resultado[i]);
	}
	
	
	@Test
	public void testCompletoEnunciado(){
		try {
			Torneo torneo = ArchivoTorneo.leer("test/lotes/in/01_CasoEnunciado.in");
			ArchivoTorneo.escribir("test/lotes/out/01_CasoEnunciado.out", torneo.resolver());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Assert.assertEquals(true, 
				ArchivoTorneo.testIgualdadArchivos("test/lotes/expected/01_CasoEnunciado.out", "test/lotes/out/01_CasoEnunciado.out"));
	}
	
	@Test
	public void testCompletoIncomparables(){
		try {
			Torneo torneo = ArchivoTorneo.leer("test/lotes/in/02_Incomparables.in");
			ArchivoTorneo.escribir("test/lotes/out/02_Incomparables.out", torneo.resolver());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Assert.assertEquals(true, 
				ArchivoTorneo.testIgualdadArchivos("test/lotes/expected/02_Incomparables.out", "test/lotes/out/02_Incomparables.out"));
	}

	
	@Test
	public void testCompletoGanaEnAmbasMedidas(){
		try {
			Torneo torneo = ArchivoTorneo.leer("test/lotes/in/03_GanaEnAmbasMedidas.in");
			ArchivoTorneo.escribir("test/lotes/out/03_GanaEnAmbasMedidas.out", torneo.resolver());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Assert.assertEquals(true, 
				ArchivoTorneo.testIgualdadArchivos("test/lotes/expected/03_GanaEnAmbasMedidas.out", "test/lotes/out/03_GanaEnAmbasMedidas.out"));
	}
	
	@Test
	public void testCompletoEmpataEnPesoYSuperaEnAltura(){
		try {
			Torneo torneo = ArchivoTorneo.leer("test/lotes/in/04_EmpataEnPesoYSuperaEnAltura.in");
			ArchivoTorneo.escribir("test/lotes/out/04_EmpataEnPesoYSuperaEnAltura.out", torneo.resolver());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Assert.assertEquals(true, 
				ArchivoTorneo.testIgualdadArchivos
				("test/lotes/expected/04_EmpataEnPesoYSuperaEnAltura.out", "test/lotes/out/04_EmpataEnPesoYSuperaEnAltura.out"));
	}
	
	@Test
	public void testCompletoEmpataEnAlturaYSuperaEnPeso(){
		try {
			Torneo torneo = ArchivoTorneo.leer("test/lotes/in/05_EmpataEnAlturaYSuperaEnPeso.in");
			ArchivoTorneo.escribir("test/lotes/out/05_EmpataEnAlturaYSuperaEnPeso.out", torneo.resolver());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Assert.assertEquals(true, 
				ArchivoTorneo.testIgualdadArchivos
				("test/lotes/expected/05_EmpataEnAlturaYSuperaEnPeso.out", "test/lotes/out/05_EmpataEnAlturaYSuperaEnPeso.out"));
	}
	
	@Test
	public void testCompletoEmpate(){
		try {
			Torneo torneo = ArchivoTorneo.leer("test/lotes/in/06_Empate.in");
			ArchivoTorneo.escribir("test/lotes/out/06_Empate.out", torneo.resolver());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Assert.assertEquals(true, 
				ArchivoTorneo.testIgualdadArchivos
				("test/lotes/expected/06_Empate.out", "test/lotes/out/06_Empate.out"));
	}
	
	@Test
	public void testCompletoExtremos(){
		try {
			Torneo torneo = ArchivoTorneo.leer("test/lotes/in/07_Extremos.in");
			ArchivoTorneo.escribir("test/lotes/out/07_Extremos.out", torneo.resolver());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Assert.assertEquals(true, 
				ArchivoTorneo.testIgualdadArchivos
				("test/lotes/expected/07_Extremos.out", "test/lotes/out/07_Extremos.out"));
	}
	
	@Test
	public void testCompletoCasoFatiga(){
		try {
			Torneo torneo = ArchivoTorneo.leer("test/lotes/in/08_CasoFatiga.in");
			ArchivoTorneo.escribir("test/lotes/out/08_CasoFatiga.out", torneo.resolver());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Assert.assertEquals(true, 
				ArchivoTorneo.testIgualdadArchivos
				("test/lotes/expected/08_CasoFatiga.out", "test/lotes/out/08_CasoFatiga.out"));
	}
	
	
	@Test
	public void testCompletoUnSoloLuchador(){
		try {
			Torneo torneo = ArchivoTorneo.leer("test/lotes/in/09_UnSoloLuchador.in");
			ArchivoTorneo.escribir("test/lotes/out/09_UnSoloLuchador.out", torneo.resolver());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Assert.assertEquals(true, 
				ArchivoTorneo.testIgualdadArchivos
				("test/lotes/expected/09_UnSoloLuchador.out", "test/lotes/out/09_UnSoloLuchador.out"));
	}
	
}

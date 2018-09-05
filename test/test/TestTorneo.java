package test;

import org.junit.Assert;
import org.junit.Test;

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
	

}

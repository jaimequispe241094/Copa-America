package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Negocio.Jugador;
import Negocio.Posicion;

public class JugadorTest {

	private Jugador uno;
	private Jugador dos;
	private Jugador tres;
	private Jugador cuatro;
	
	@Before
	public void inicializar()
	{
		uno = new Jugador("Lionel","Messi",38963692,Posicion.Delantero,"Argentina",true);
		dos = new Jugador("Neymar","Da Silva",87969613,Posicion.Delantero,"Brasil",true);
		tres = new Jugador("Luis","Suarez",87969699,Posicion.Delantero,"Uruguay",true);
		cuatro = null;
	}
	
	@Test
	public void equalsTest() {
		assertTrue(uno.equals(uno));
		assertFalse(uno.equals(dos));
		assertFalse(dos.equals(uno));
		assertFalse(tres.equals(cuatro));
	}

	@Test
	public void mismoNombreApellidoTest() 
	{
		assertTrue(uno.mismoNombre(uno));
		assertFalse(dos.mismoApellido(tres));
		assertTrue(tres.mismoApellido(tres));
		assertFalse(dos.mismoNombre(cuatro));
	}
	
	@Test
	public void mismaSeleccionTest()
	{
		Jugador nuevo = new Jugador("Luis","Aguero",87969699,Posicion.Delantero,"Argentina",true);
		assertTrue(uno.mismaSeleccion(nuevo));
		assertFalse(dos.mismaSeleccion(tres));
		assertFalse(tres.mismaSeleccion(dos));
		assertTrue(tres.mismaSeleccion(tres));
		assertFalse(uno.mismaSeleccion(cuatro));
	}
	
	@Test
	public void mismoDniTest() 
	{
		assertFalse(uno.mismoDni(tres));
		assertFalse(dos.mismaSeleccion(tres));
		assertFalse(tres.mismaSeleccion(dos));
		assertTrue(tres.mismoDni(tres));
		assertFalse(uno.mismoDni(cuatro));
	}
	
	@Test
	public void mismoPosicionTest() 
	{
		Jugador nuevo = new Jugador("Luis","Aguero",87969699,Posicion.Arquero,"Argentina",true);
		
		assertTrue(uno.mismaPosicion(dos.getPosicion()));
		assertTrue(uno.mismaPosicion(uno.getPosicion()));
		assertTrue(dos.mismaPosicion(tres.getPosicion()));
		assertFalse(tres.mismaPosicion(null));
		assertFalse(tres.mismaPosicion(nuevo.getPosicion()));
		assertFalse(dos.mismaPosicion(nuevo.getPosicion()));
	}
}

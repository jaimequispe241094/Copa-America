package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Negocio.IteratorLista;
import Negocio.Lista;

public class IteretorTest {

	private Lista<String> nombres;
	private Lista<String> apellidos;
	private IteratorLista<String> iteretor;
	private IteratorLista<String> otro;
	
	@Before
	public void inicializar()
	{	
		nombres = new Lista<String>();
		nombres.agregar("perro");
		nombres.agregar("gato");
		nombres.agregar("pez");
		nombres.agregar("paloma");
		apellidos = new Lista<String>();
		
		iteretor = new IteratorLista<String>(nombres);
		otro = new IteratorLista<String>(apellidos);
	}
	
	@Test
	public void hasNextTest() 
	{
		assertTrue(iteretor.hasNext());
		int i = 0;
		while (iteretor.hasNext())
		{
			i++;
			iteretor.next();
		}
		assertTrue(i==nombres.tamaño());
		
		assertFalse(otro.hasNext());
	}

	@Test
	public void nextTest()
	{
		for (int i = 0;i<nombres.tamaño();i++)
		{
			assertEquals(nombres.iesimo(i),iteretor.next()); 
		}
		
	}
}

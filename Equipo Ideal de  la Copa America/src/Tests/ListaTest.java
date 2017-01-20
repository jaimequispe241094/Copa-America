package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Negocio.Lista;

public class ListaTest {

	Lista<String> nombres = new Lista<String>();
	Lista<String> materias = new Lista<String>();
	
	@Test
	public void tama�oTest() 
	{
		assertTrue(nombres.tama�o()==0);
		
		nombres.agregar("Juan");
		nombres.agregar("Susana");
		nombres.agregar("Pedro");
		
		assertEquals(nombres.tama�o(), 3);
		assertEquals(materias.tama�o(), 0);
		
		materias.agregar("Programacion");
		
		assertFalse(materias.tama�o()>1);
		assertTrue(materias.tama�o()==1);
	}
	
	@Test
	public void loContieneTest()
	{
		nombres.agregar("Jaime");
		nombres.agregar("Quispe");
		
		assertFalse(nombres.loContiene("jaime"));
		assertTrue(nombres.loContiene("Jaime"));
		assertFalse(materias.loContiene("Quispe"));
		assertFalse(materias.loContiene("Programacion"));
	}

	@Test
	public void eliminarTest()
	{
		materias.agregar("Matematica Discreta");
		materias.agregar("Programacion");
		assertTrue(materias.loContiene("Programacion"));
		assertTrue(materias.tama�o()==2);
		
		materias.eliminar("Programacion");
		materias.eliminar("Matematica Discreta");
		
		assertTrue(materias.tama�o()==0);
		assertFalse(materias.loContiene("Matematica Discreta"));
	}
	
	@Test
	public void unionTest()
	{
		materias.agregar("Matematica Discreta");
		materias.agregar("Programacion");
		nombres.agregar("Ana");
		
		assertFalse(nombres.tama�o()==3);
		nombres.union(materias);
		assertTrue(nombres.tama�o()==3);
	}
}

package Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Negocio.Equipo;
import Negocio.Jugador;
import Negocio.Lista;
import Negocio.Posicion;

public class EquipoTest {

	private Equipo equipo = new Equipo("Prueba");
	private Equipo nuevo = new Equipo("otro");
	
	@Before
	public void inicializar() {
		equipo.agregar(new Jugador("Martin","Demichelis",38963610,Posicion.Defensor,"Argentina",true));
		equipo.agregar(new Jugador("Pablo","Zabaleta",38963699,Posicion.Defensor,"Argentina",true));
		equipo.agregar(new Jugador("Marcos","Rojo",38963698,Posicion.Defensor,"Argentina",true));
		equipo.agregar(new Jugador("Ezequiel","Garay",38963697,Posicion.Defensor,"Argentina",true));
		equipo.agregar(new Jugador("Javier","Mascherano",38963696,Posicion.MedioCampista,"Argentina",true));
		equipo.agregar(new Jugador("Angel","Di maria",38963695,Posicion.MedioCampista,"Argentina",true));
		equipo.agregar(new Jugador("Javier","Pastore",38963694,Posicion.MedioCampista,"Argentina",true));
		equipo.agregar(new Jugador("Sergio","Aguero",38963693,Posicion.Delantero,"Argentina",true));
		equipo.agregar(new Jugador("Lionel","Messi",38963692,Posicion.Delantero,"Argentina",true));
		equipo.agregar(new Jugador("Carlos","Tevez",38963691,Posicion.Delantero,"Argentina",true));
	}
	
	@Test
	public void jugadoresPorPosicionTest()
	{
		Lista<Jugador> arqueros =  equipo.jugadoresPorPosicion(Posicion.Arquero);
		Lista<Jugador> defensores = equipo.jugadoresPorPosicion(Posicion.Defensor);
		Lista<Jugador> mediocampistas = equipo.jugadoresPorPosicion(Posicion.MedioCampista);
		Lista<Jugador> delanteros = equipo.jugadoresPorPosicion(Posicion.Delantero);
		
		Lista<Jugador> arquerosNuevo =  nuevo.jugadoresPorPosicion(Posicion.Arquero);
		Lista<Jugador> defensoresNuevo = nuevo.jugadoresPorPosicion(Posicion.Defensor);
		Lista<Jugador> mediocampistasNuevo = nuevo.jugadoresPorPosicion(Posicion.MedioCampista);
		Lista<Jugador> delanterosNuevo = nuevo.jugadoresPorPosicion(Posicion.Delantero);
		
		assertEquals(arqueros.tamaño(), 0);
		assertEquals(mediocampistas.tamaño(), 3);
		assertEquals(defensores.tamaño(), 4);
		assertEquals(delanteros.tamaño(), 3);
		
		assertFalse(arquerosNuevo.tamaño()==1);
		assertFalse(defensoresNuevo.tamaño()==4);
		assertTrue(mediocampistasNuevo.tamaño()==0);
		assertTrue(delanterosNuevo.tamaño()==0);
	}
	
	@Test
	public void equalsTest()
	{
		boolean ret = equipo.equals(nuevo);
		boolean igual = nuevo.equals(nuevo);
		boolean nulo = equipo.equals(null);
		
		assertFalse(ret);
		assertTrue(igual);
		assertFalse(nulo);
	}
}

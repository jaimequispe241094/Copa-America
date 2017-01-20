package Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Negocio.Equipo;
import Negocio.Jugador;
import Negocio.Lista;
import Negocio.Posicion;
import Negocio.Torneo;

public class TorneoTest {

	private Torneo torneo;
	private Equipo argentina;
	private Equipo uruguay; 
	private Equipo brasil;
	
	@Before
	public void inicializar()
	{
		torneo = new Torneo();
		
		argentina = new Equipo ("Argentina");
		argentina.agregar(new Jugador("Sergio","Romero",38963620,Posicion.Arquero,"Argentina",true));
		argentina.agregar(new Jugador("Martin","Demichelis",38963610,Posicion.Defensor,"Argentina",true));
		argentina.agregar(new Jugador("Pablo","Zabaleta",38963699,Posicion.Defensor,"Argentina",true));
		argentina.agregar(new Jugador("Marcos","Rojo",38963698,Posicion.Defensor,"Argentina",true));
		argentina.agregar(new Jugador("Ezequiel","Garay",38963697,Posicion.Defensor,"Argentina",true));
		argentina.agregar(new Jugador("Javier","Mascherano",38963696,Posicion.MedioCampista,"Argentina",true));
		argentina.agregar(new Jugador("Angel","Di maria",38963695,Posicion.MedioCampista,"Argentina",true));
		argentina.agregar(new Jugador("Javier","Pastore",38963694,Posicion.MedioCampista,"Argentina",true));
		argentina.agregar(new Jugador("Sergio","Aguero",38963693,Posicion.Delantero,"Argentina",true));
		argentina.agregar(new Jugador("Lionel","Messi",38963692,Posicion.Delantero,"Argentina",true));
		argentina.agregar(new Jugador("Carlos","Tevez",38963691,Posicion.Delantero,"Argentina",true));
		torneo.agregar(argentina);
		
		brasil = new Equipo ("Brasil");
		brasil.agregar(new Jugador("Julio","Cesar",87969600,Posicion.Arquero,"Brasil",true));
		brasil.agregar(new Jugador("Marcelo","Viera",87969698,Posicion.Defensor,"Brasil",true));
		brasil.agregar(new Jugador("Thiago","Silva",87969689,Posicion.Defensor,"Brasil",true));
		brasil.agregar(new Jugador("Daniel","Alves",87969672,Posicion.Defensor,"Brasil",true));
		brasil.agregar(new Jugador("David","Luis",87969674,Posicion.Defensor,"Brasil",true));
		brasil.agregar(new Jugador("Givanildo","hulk",87969677,Posicion.MedioCampista,"Brasil",true));
		brasil.agregar(new Jugador("Ricardo","kaka",87969617,Posicion.MedioCampista,"Brasil",true));
		brasil.agregar(new Jugador("Frederico","Fred",87969675,Posicion.MedioCampista,"Brasil",true));
		brasil.agregar(new Jugador("Luis","Ronaldo",87969623,Posicion.Delantero,"Brasil",true));
		brasil.agregar(new Jugador("Neymar","Da Silva",87969613,Posicion.Delantero,"Brasil",true));
		brasil.agregar(new Jugador("Moreira","Ronaldhino",87969630,Posicion.Delantero,"Brasil",true));
		torneo.agregar(brasil);
		
		
		uruguay = new Equipo ("Uruguay");
		uruguay.agregar(new Jugador("Fernando","Muslera",87969633,Posicion.Arquero,"Uruguay",true));
		uruguay.agregar(new Jugador("Maxi","Pereira",87969611,Posicion.Defensor,"Uruguay",true));
		uruguay.agregar(new Jugador("Diego","Godin",87969622,Posicion.Defensor,"Uruguay",true));
		uruguay.agregar(new Jugador("Gaston","Silva",87969603,Posicion.Defensor,"Uruguay",true));
		uruguay.agregar(new Jugador("Jose","Gimenez",87969644,Posicion.Defensor,"Uruguay",true));
		uruguay.agregar(new Jugador("Nicolas","Lodeiro",87969655,Posicion.MedioCampista,"Uruguay",true));
		uruguay.agregar(new Jugador("Cristian","Rodriguez",87969666,Posicion.MedioCampista,"Uruguay",true));
		uruguay.agregar(new Jugador("Carlos","Sanchez",87969677,Posicion.MedioCampista,"Uruguay",true));
		uruguay.agregar(new Jugador("Diego","Rolan",87969688,Posicion.Delantero,"Uruguay",true));
		uruguay.agregar(new Jugador("Luis","Suarez",87969699,Posicion.Delantero,"Uruguay",true));
		uruguay.agregar(new Jugador("Edinson","Cavani",87969617,Posicion.Delantero,"Uruguay",true));
		torneo.agregar(uruguay);
	}
	
	@Test
	public void grupoDeJugadoresTest() 
	{
		assertTrue(torneo.tamaño()==3);
		
		Lista<Jugador> arqueros = torneo.grupoDeJugadores(Posicion.Arquero);
		Lista<Jugador> defensores = torneo.grupoDeJugadores(Posicion.Defensor);
		Lista<Jugador> mediocampistas = torneo.grupoDeJugadores(Posicion.MedioCampista);
		Lista<Jugador> delanteros = torneo.grupoDeJugadores(Posicion.Delantero);
		
		assertTrue(arqueros.tamaño()==3);
		assertEquals(defensores.tamaño(), 12);
		assertEquals(mediocampistas.tamaño(), 9);
		assertTrue(delanteros.tamaño()==9);
		
		int suma = arqueros.tamaño() + mediocampistas.tamaño() + defensores.tamaño() + delanteros.tamaño();
		assertTrue(suma==33);
	}

	@Test
	public void pedirEquipoTest()
	{
		Equipo uno = torneo.pedirEquipo("Argentina");	
		Equipo dos = torneo.pedirEquipo("España");
		Equipo tres = torneo.pedirEquipo("Uruguay");
		
		assertEquals(uno,argentina);
		assertEquals(tres, uruguay);
		assertNull(dos);
	}
	
}

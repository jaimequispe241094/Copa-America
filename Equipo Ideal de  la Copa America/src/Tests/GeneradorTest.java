package Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Negocio.Equipo;
import Negocio.EquipoIdeal;
import Negocio.Generador;
import Negocio.Jugador;
import Negocio.Lista;
import Negocio.Posicion;
import Negocio.Torneo;

public class GeneradorTest {

	private Generador gen;
	private Torneo torneo;
	private Equipo argentina;
	private Equipo brasil;
	private Equipo uruguay;
	
	@Before
	public void inicializar()
	{
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
		
		torneo = new Torneo();
		torneo.agregar(argentina);
		torneo.agregar(uruguay);
		torneo.agregar(brasil);
		
		gen = new Generador(torneo);
	}

	@Before
	public void setearTarjetas()
	{
		for(Jugador j : argentina)
		{
			j.setTarjetaAmarilla(false);
			j.setTarjetaRoja(false);
		} 	
		for(Jugador j : uruguay)
		{
			j.setTarjetaAmarilla(false);
			j.setTarjetaRoja(false);
		}
		for(Jugador j : brasil)
		{
			j.setTarjetaAmarilla(false);
			j.setTarjetaRoja(false);
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void combinacionesDeTresTest() 
	{
		Lista<Jugador> arqueros = torneo.grupoDeJugadores(Posicion.Arquero);
		Lista<Jugador> delanteros = torneo.grupoDeJugadores(Posicion.Delantero);
		Lista<Jugador> nueva = new Lista<Jugador>(); 
		
		Lista<Lista<Jugador>> combinacionesArqueros = gen.generarCombinacionesTomadasDeTres(arqueros);
		Lista<Lista<Jugador>> combinacionesDelanteros = gen.generarCombinacionesTomadasDeTres(delanteros);
		Lista<Lista<Jugador>> combinacionesVacias = gen.generarCombinacionesTomadasDeTres(nueva);
		
		assertTrue(combinacionesArqueros.tamaño()==1);	   // como solo hay 3 arqueros solo hay una combinacion posible
		assertTrue(combinacionesDelanteros.tamaño()==84); //combinatoria 9 C 3 = 84
		assertTrue(combinacionesVacias.tamaño()==0);      //sin valores
	}

	@SuppressWarnings("static-access")
	@Test
	public void combinacionesDeCuatroTest() 
	{
		Lista<Jugador> arqueros = torneo.grupoDeJugadores(Posicion.Arquero);
		Lista<Jugador> defensores = torneo.grupoDeJugadores(Posicion.Defensor);
		Lista<Jugador> mediocampistas = torneo.grupoDeJugadores(Posicion.MedioCampista);
		Lista<Jugador> nueva = new Lista<Jugador>(); 
		
		Lista<Lista<Jugador>> combinacionesArqueros = gen.generarCombinacionesTomadasDeCuatro(arqueros);
		Lista<Lista<Jugador>> combinacionesDefensores = gen.generarCombinacionesTomadasDeCuatro(defensores);
		Lista<Lista<Jugador>> combinacionesMedioCampistas = gen.generarCombinacionesTomadasDeCuatro(mediocampistas);
		Lista<Lista<Jugador>> combinacionesVacias = gen.generarCombinacionesTomadasDeCuatro(nueva);
		
		assertTrue(combinacionesArqueros.tamaño()==0);	   // como solo hay 3 arqueros no se puede formar una combinacion posible
		assertTrue(combinacionesDefensores.tamaño()==495); //combinatoria 9 C 3 = 84
		assertTrue(combinacionesVacias.tamaño()==0);      //sin valores
		assertTrue(combinacionesMedioCampistas.tamaño()==126); //combincatoria 9 C 4 = 126
	}

	@Test
	public void mejorEquipoTest()
	{
		EquipoIdeal mejor = gen.mejorEquipo();
		
		Lista<EquipoIdeal> mejores = gen.listaDeMejoresEquipos();
		
		for (EquipoIdeal equipo : mejores)
		{
			assertFalse(equipo.puntajeDelEquipo()>mejor.puntajeDelEquipo());
		}
		
		for (Jugador j: argentina)
		{
			j.setTarjetaRoja(true);
		}
		EquipoIdeal otro = gen.mejorEquipo();
		assertNull(otro);
	}
	
	@Test
	public void limpiarCombinacionesTest()
	{
		argentina.iesimo(0).setTarjetaRoja(true);
		argentina.iesimo(1).setTarjetaRoja(true);
		argentina.iesimo(2).setTarjetaRoja(true);
		
		@SuppressWarnings("static-access")
		Lista<Lista<Jugador>> lista = gen.generarCombinacionesTomadasDeTres(argentina);		// 11 C 3 = 165
		assertTrue(lista.tamaño()==165);
		
		gen.limpiarJugadoresConTarjetas(lista);
		
		assertFalse(lista.tamaño()==165);
		assertTrue(lista.tamaño()<165);
	}
}

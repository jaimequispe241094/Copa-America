package Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Negocio.EquipoIdeal;
import Negocio.Jugador;
import Negocio.Posicion;

public class EquipoIdealTest {

	private EquipoIdeal uno; 
	private EquipoIdeal dos;
	private EquipoIdeal tres;
	private EquipoIdeal cuatro;
	
	@Before
	public void inicializar()
	{
		uno = new EquipoIdeal();
		uno.agregar(new Jugador("Sergio","Romero",38963620,Posicion.Arquero,"Argentina",true));
		uno.agregar(new Jugador("Martin","Demichelis",38963610,Posicion.Defensor,"Argentina",true));
		uno.agregar(new Jugador("Pablo","Zabaleta",38963699,Posicion.Defensor,"Argentina",true));
		uno.agregar(new Jugador("Marcos","Rojo",38963698,Posicion.Defensor,"Argentina",true));
		uno.agregar(new Jugador("Ezequiel","Garay",38963697,Posicion.Defensor,"Argentina",true));
		uno.agregar(new Jugador("Javier","Mascherano",38963696,Posicion.MedioCampista,"Argentina",true));
		uno.agregar(new Jugador("Angel","Di maria",38963695,Posicion.MedioCampista,"Argentina",true));
		uno.agregar(new Jugador("Javier","Pastore",38963694,Posicion.MedioCampista,"Argentina",true));
		uno.agregar(new Jugador("Sergio","Aguero",38963693,Posicion.Delantero,"Argentina",true));
		uno.agregar(new Jugador("Lionel","Messi",38963692,Posicion.Delantero,"Argentina",true));
		uno.agregar(new Jugador("Carlos","Tevez",38963691,Posicion.Delantero,"Argentina",true));
		
		dos = new EquipoIdeal();
		dos.agregar(new Jugador("Julio","Cesar",87969600,Posicion.Arquero,"Brasil",true));
		dos.agregar(new Jugador("Arturo", "Vidal", 48962932, Posicion.Defensor, "Chile", true));
		dos.agregar(new Jugador("Gary", "Medel", 49652113, Posicion.Defensor, "Chile", true));
		dos.agregar(new Jugador("Eugenio", "Mena", 49652114, Posicion.Defensor, "Chile", true));
		dos.agregar(new Jugador("Gonzalo", "Jara", 49652115, Posicion.Defensor, "Chile", true));
		dos.agregar(new Jugador("Tomas", "Rincon", 78999526, Posicion.MedioCampista, "Venezuela", true));
		dos.agregar(new Jugador("Rafael", "Acosta", 78999527, Posicion.MedioCampista, "Venezuela", true));
		dos.agregar(new Jugador("Javier","Pastore",38963694,Posicion.MedioCampista,"Argentina",true));
		dos.agregar(new Jugador("Sergio","Aguero",38963693,Posicion.Delantero,"Argentina",true));
		dos.agregar(new Jugador("Lionel","Messi",38963692,Posicion.Delantero,"Argentina",true));
		dos.agregar(new Jugador("Carlos","Tevez",38963691,Posicion.Delantero,"Argentina",true));
		
		tres = new EquipoIdeal();
		tres.agregar(new Jugador("David", "Ospina", 52346800, Posicion.Arquero, "Colombia", true));
		tres.agregar(new Jugador("Pablo", "Armero", 52345881, Posicion.Defensor, "Colombia", true));
		tres.agregar(new Jugador("Cristian", "Zapata", 52346801, Posicion.Defensor, "Colombia", true));
		tres.agregar(new Jugador("Pedro", "Franco", 52346882, Posicion.Defensor, "Colombia", true));
		tres.agregar(new Jugador("Juan", "Zuñiga", 52345883, Posicion.Defensor, "Colombia", true));
		tres.agregar(new Jugador("Edwin", "Cardona", 52346884, Posicion.Defensor, "Colombia", true));
		tres.agregar(new Jugador("Juan", "Cuadrado", 52346885, Posicion.MedioCampista, "Colombia", true));
		tres.agregar(new Jugador("James", "Rodriguez", 52456886, Posicion.MedioCampista, "Colombia", true));
		tres.agregar(new Jugador("Marcelo", "Moreno", 223456878, Posicion.Delantero, "Bolivia", true));
		tres.agregar(new Jugador("Damian", "Lizio", 223456888, Posicion.Delantero, "Bolivia", true));
		tres.agregar(new Jugador("Alcides", "Peña", 223456898, Posicion.Delantero, "Bolivia", true));
		
		cuatro = new EquipoIdeal();
	}
	
	@Before
	public void setearTarjetas()
	{
		for ( Jugador j : uno)
		{
			j.setTarjetaRoja(true);
			j.setTarjetaAmarilla(false);
		}
		
		for (Jugador j : dos)
		{
			j.setTarjetaAmarilla(false);
			j.setTarjetaRoja(false);
		}
		
		for (Jugador j : tres)
		{
			j.setTarjetaAmarilla(true);
			j.setTarjetaRoja(true);
		}
	}

	@Before 
	public void setearPuntaje()
	{
		for (Jugador j : uno)
		{
			j.setPuntaje(0);
		}
		
		for (Jugador j : dos)
		{
			j.setPuntaje(10);
		}
		
		for (Jugador j : tres)
		{
			j.setPuntaje(1);
		}
	}
	
	@Test
	public void formacionTest() 
	{
		assertTrue(uno.tieneLaFormacionPedida(4, 3, 3));
		assertTrue(dos.tieneLaFormacionPedida(4, 3, 3));
		assertTrue(dos.respetaCondicionesPedidas());	
		assertFalse(tres.tieneLaFormacionPedida(4, 3, 3));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void mismoPaisTest()
	{
		assertTrue(uno.hayCincoDelMismoPais());
		assertFalse(dos.tieneCuatroCompañeros(dos, dos.iesimo(0)));
		assertFalse(dos.hayCincoDelMismoPais());
		assertTrue(tres.tieneCuatroCompañeros(tres, tres.iesimo(0)));
		assertTrue(tres.hayCincoDelMismoPais());
		assertFalse(cuatro.hayCincoDelMismoPais());
	}

	@SuppressWarnings("static-access")
	@Test
	public void cantidadDeTarjetasTest()
	{
		assertFalse(uno.respetaCantidadTarjetas(uno, 1, 3));
		assertFalse(tres.respetaCantidadTarjetas(tres, 1, 3));
		assertTrue(dos.respetaCantidadTarjetas(dos, 1, 3));
		assertTrue(cuatro.respetaCantidadTarjetas(cuatro, 1, 3));
	}

	@Test
	public void puntajeDelEquipoTest()
	{
		assertEquals(uno.puntajeDelEquipo(), 0);
		assertEquals(dos.puntajeDelEquipo(), 110);
		assertEquals(tres.puntajeDelEquipo(), 11);
		assertEquals(cuatro.puntajeDelEquipo(), 0);
	}

	@Test
	public void respetaCondicionesTest()
	{
		assertFalse(uno.respetaCondicionesPedidas());
		assertTrue(dos.respetaCondicionesPedidas());
		assertFalse(tres.respetaCondicionesPedidas());
		assertFalse(cuatro.respetaCondicionesPedidas());
	}
	
}

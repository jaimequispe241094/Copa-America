package Negocio;

public class Generador {

	private static Torneo torneo;
	
	@SuppressWarnings("static-access")
	public Generador (Torneo torneo){
		this.torneo = torneo;
	}
	
	public  EquipoIdeal mejorEquipo(){
		Lista<EquipoIdeal> mejores = listaDeMejoresEquipos();								//se da una lista con los mejores equipos
		EquipoIdeal elMejor = null;										
		
		for ( EquipoIdeal equipo : mejores)													
		{																					//se busca a el mejor de los equipos calculando que su puntaje sea el mayor
			EquipoIdeal actual = equipo;									
			if ( elMejor == null || actual.puntajeDelEquipo()>elMejor.puntajeDelEquipo()){
				elMejor = actual;
			}
		}
		return elMejor;
	}
	
	public Lista<EquipoIdeal> listaDeMejoresEquipos(){
		
		Lista<EquipoIdeal> mejores = new Lista<EquipoIdeal>(); 
		
		Lista<Jugador> arqueros = torneo.grupoDeJugadores(Posicion.Arquero);
		Lista<Lista<Jugador>> defensores = generarCombinacionesTomadasDeCuatro(torneo.grupoDeJugadores(Posicion.Defensor));
		Lista<Lista<Jugador>> mediocampistas = generarCombinacionesTomadasDeTres(torneo.grupoDeJugadores(Posicion.MedioCampista));
		Lista<Lista<Jugador>> delanteros = generarCombinacionesTomadasDeTres(torneo.grupoDeJugadores(Posicion.Delantero));
		
		for (int i = 0; i < arqueros.tamaño(); i++) {
			for (int j = 0; j < defensores.tamaño(); j++) {
				for (int k = 0; k < mediocampistas.tamaño(); k++) {
					for (int n = 0; n < delanteros.tamaño(); n++) 
					{
						EquipoIdeal equipo = new EquipoIdeal();
						equipo.agregar(arqueros.iesimo(i));						//se agrega solo un arquero
						equipo.union(defensores.iesimo(j));						//se agregan las combincaciones de defensores, mediocampistas, delanteros 
						equipo.union(mediocampistas.iesimo(k));
						equipo.union(delanteros.iesimo(n));
						if (equipo.respetaCondicionesPedidas())
						{														//solo si respetan las condiciones pedidas se agregan ala lista de mejores
							mejores.agregar(equipo);
						}
					}
				}
			}
		}
		return mejores;
	}
	
	public static Lista<Lista<Jugador>> generarCombinacionesTomadasDeTres(Lista<Jugador> jugadores)
	{
 		Lista<Lista<Jugador>> combinaciones = new Lista<Lista<Jugador>>();
		for (int i = 0; i < jugadores.tamaño(); i++)
		{
			for (int j = i+1; j < jugadores.tamaño(); j++) 
			{
				for (int k = j+1; k < jugadores.tamaño(); k++) 
				{
					Lista<Jugador> nueva = new Lista<Jugador>();				//dada una lista se generean todas las combincaciones posibles de 3 jugadores
					nueva.agregar(jugadores.iesimo(i));
					nueva.agregar(jugadores.iesimo(j));
					nueva.agregar(jugadores.iesimo(k));
					combinaciones.agregar(nueva);
				}
			}
		}
		return combinaciones;
	} 
	
	public static Lista<Lista<Jugador>> generarCombinacionesTomadasDeCuatro(Lista<Jugador> jugadores)
	{
 		Lista<Lista<Jugador>> combinaciones = new Lista<Lista<Jugador>>();
 		
		for (int i = 0; i < jugadores.tamaño(); i++)
		{
			for (int j = i+1; j < jugadores.tamaño(); j++) 
			{
				for (int k = j+1; k < jugadores.tamaño(); k++) 
				{
					for (int n = k+1; n < jugadores.tamaño(); n++) {	
						Lista<Jugador> nueva = new Lista<Jugador>();
						nueva.agregar(jugadores.iesimo(i));								//dada una lista se generean todas las combincaciones posibles de 4 jugadores
						nueva.agregar(jugadores.iesimo(j));
						nueva.agregar(jugadores.iesimo(k));
						nueva.agregar(jugadores.iesimo(n));
						combinaciones.agregar(nueva);
					}
				}
			}
		}
		return combinaciones;
	} 
	
	public void limpiarJugadoresConTarjetas(Lista<Lista<Jugador>> lista){
		
		for (Lista<Jugador> lis : lista) 
		{
			if (!EquipoIdeal.respetaCantidadTarjetas(lis,1, 3)) {					//si alguna combincaion no respeta la cantidad de tarjetas pedidas se la descarta			
					lista.eliminar(lis);
			}
		}
	}
}

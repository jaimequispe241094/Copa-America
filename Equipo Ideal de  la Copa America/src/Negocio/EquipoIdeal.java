package Negocio;

public class EquipoIdeal extends Lista<Jugador> {
	
	public boolean respetaCondicionesPedidas(){																		//se verifica que el equipo cumpla estas 3 condiciones
		return respetaCantidadTarjetas(this,1,3) && !hayCincoDelMismoPais() && tieneLaFormacionPedida(4,3,3);
	}
	
	public static boolean respetaCantidadTarjetas(Lista<Jugador> equipo,int roja,int amarilla) {
		int jugadoresConAmarilla=0;		int jugadoresConRoja=0;
																							//dada una lista de jugadores se verifica
		for (Jugador jug : equipo) 															//que tengan las misma  o menos cantidad de  
		{																					//tarjetas permitidas, estas son pasadas como
			 if(jug.getTarjetaRoja())														//parametro
			 {			 jugadoresConRoja++;			    }
			 
			 if(jug.getTarjetaAmarilla())
			 {			 jugadoresConAmarilla++;			}		 
		}	
		return jugadoresConRoja<=roja && jugadoresConAmarilla <=amarilla; 
	}
	
	public boolean hayCincoDelMismoPais(){							
		boolean ret = false;										
		for (Jugador j : this)          							//si verifica si un jugador tiene 4 compañeros o mas
		{ 															//si es asi es porque hay cinco que son del mismo pais
			ret = ret || tieneCuatroCompañeros(this, j);
		}	
		return  ret;
	}
	
	public boolean tieneLaFormacionPedida(int defensores,int mediocampistas,int delanteros) {
		int def = 0;	int med = 0;	int del = 0;											//se pasa una formacion como parametro 
																								//y se verifica que el equipo tenga esta formacion
		for (Jugador jug : this)																//no se tiene encuenta el arquero, porque este siempre sera uno 
		{
			if(jug.mismaPosicion(Posicion.Defensor))
			{			def++;			}
			
			else  if(jug.mismaPosicion(Posicion.MedioCampista))
			{			med++;			}
			
			else if(jug.mismaPosicion(Posicion.Delantero))
			{			del++;			}
		}
		return def==defensores && med==mediocampistas && del==delanteros;
	}

	public static boolean tieneCuatroCompañeros(Lista<Jugador> lista, Jugador jugador){
		int i=0;																		//dada una lista de jugadores y un jugador se compara 
		for ( Jugador j : lista)												     	// si este tienecuatro compañeros,esdecir si son de 
		{																				//su misma seleccion 
			if(jugador.mismaSeleccion(j))						
			{		i++;		}
		}
		return i>4;
	}
	
	public int puntajeDelEquipo()													//se duelve la suma de todos los puntos del equipo	
	{
		int ret = 0;
		for (Jugador j : this) 
		{
			ret= ret + j.getPuntaje();
		}
		return ret;
	}
	
	@Override
	public String toString() {
		return "EquipoIdeal ["+"\n"+  super.toString() + "]";
	}
}

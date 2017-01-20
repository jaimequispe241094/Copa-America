package Negocio;

public class Equipo extends Lista<Jugador> { 
	
	private String pais;
	
	public Equipo(String pais){
		this.pais = pais; 
	}
	
	public Lista<Jugador> jugadoresPorPosicion(Posicion posicion){				//dada una posicion se devuelve una lista con 
		Lista<Jugador> lista = new Lista<Jugador>();							//todos los jugadores que tengan esa posicion en el equipo	
		for (Jugador jug : this)
		{
			if(jug.mismaPosicion(posicion))
				lista.agregar(jug);
		}
		return lista;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		boolean ret = false;
		if (obj instanceof Equipo)
		{
			Equipo nuevo = (Equipo) obj;
			ret = mismaSeleccion(nuevo.getPais()) && mismosJugadores(nuevo); 
		}
		return ret;
	}
	
	private boolean mismosJugadores(Equipo nuevo) 
	{															 
		boolean ret = tamaño()==nuevo.tamaño();					//si tienen el mismo tamaño se compararan los jugadores
		if (ret)
		{
			for (Jugador j : nuevo)
			{
				ret = ret && loContiene(j);						//ttodos los jugadores del equipo pasado como parametro deben estar
			}
		}
		return ret;												//true si sion los mismos
	}

	public boolean mismaSeleccion(String pais){					
		return this.pais.equals(pais);
	}
	
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
}

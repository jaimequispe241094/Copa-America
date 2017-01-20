package Negocio;

public class Torneo extends Lista<Equipo>{	
	
	private String nombre;
	
	public Torneo(String nombre){
		this.setNombre(nombre);									//torneo con jugadores cargados	
		cargarEquiposAlTorneo();
	}
	
	public Torneo(){}							//torneo sin jugadores 	
	
	public void cargarEquiposAlTorneo(){											//carga de los equipos al torneo
		Equipo argentina = new Equipo ("Argentina");
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
		agregar(argentina);
		
		Equipo brasil    = new Equipo ("Brasil");
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
		agregar(brasil);
		
		
		Equipo uruguay = new Equipo ("Uruguay");
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
		agregar(uruguay);
		
		
		Equipo venezuela = new Equipo ("Venezuela");
		venezuela.agregar(new Jugador("Alain", "Baroja", 78999521, Posicion.Arquero, "Venezuela", true));
		venezuela.agregar(new Jugador("Andres", "Tuñez", 78999522, Posicion.Defensor, "Venezuela", true));
		venezuela.agregar(new Jugador("Roberto", "Rosales", 78999523, Posicion.Defensor, "Venezuela", true));
		venezuela.agregar(new Jugador("Wilker", "Angel", 78999524, Posicion.Defensor, "Venezuela", true));
		venezuela.agregar(new Jugador("Gabriel", "Cichero", 78999525, Posicion.Defensor, "Venezuela", true));
		venezuela.agregar(new Jugador("Tomas", "Rincon", 78999526, Posicion.MedioCampista, "Venezuela", true));
		venezuela.agregar(new Jugador("Rafael", "Acosta", 78999527, Posicion.MedioCampista, "Venezuela", true));
		venezuela.agregar(new Jugador("Ronald", "Vargas", 78999528, Posicion.MedioCampista, "Venezuela", true));
		venezuela.agregar(new Jugador("Jose", "Rondon", 78999529, Posicion.Delantero, "Venezuela", true));
		venezuela.agregar(new Jugador("Nicolas", "Fedor", 78999530, Posicion.Delantero, "Venezuela", true));
		venezuela.agregar(new Jugador("Juan", "Arango", 78999533, Posicion.Delantero, "Venezuela", true));
		agregar(venezuela);
		
		Equipo paraguay  = new Equipo ("Paraguay");
		paraguay.agregar(new Jugador("Justo", "Villar", 56988796, Posicion.Arquero, "Paraguay", true));
		paraguay.agregar(new Jugador("Bruno", "Valdez", 56988799, Posicion.Defensor, "Paraguay", true));
		paraguay.agregar(new Jugador("Ivan", "Piris", 56988788, Posicion.Defensor, "Paraguay", true));
		paraguay.agregar(new Jugador("Fabian", "Balbuena", 56988777, Posicion.Defensor, "Paraguay", true));
		paraguay.agregar(new Jugador("Pablo", "Aguilar", 56988766, Posicion.Defensor, "Paraguay", true));
		paraguay.agregar(new Jugador("Nestor", "Ortigoza", 56988755, Posicion.MedioCampista, "Paraguay", true));
		paraguay.agregar(new Jugador("Miguel", "Samudio", 56988744, Posicion.MedioCampista, "Paraguay", true));
		paraguay.agregar(new Jugador("Osmar", "Molinas", 56988733, Posicion.MedioCampista, "Paraguay", true));
		paraguay.agregar(new Jugador("Edgar", "Benitez", 56988722, Posicion.Delantero, "Paraguay", true));
		paraguay.agregar(new Jugador("Nelson", "Valdez", 56988711, Posicion.Delantero, "Paraguay", true));
		paraguay.agregar(new Jugador("Oscar", "Romero", 56988700, Posicion.Delantero, "Paraguay", true));
		agregar(paraguay);
		
		
		Equipo chile = new Equipo ("Chile");
		chile.agregar(new Jugador("Claudio", "Bravo", 48962931, Posicion.Arquero,"Chile", true));
		chile.agregar(new Jugador("Arturo", "Vidal", 48962932, Posicion.Defensor, "Chile", true));
		chile.agregar(new Jugador("Gary", "Medel", 49652113, Posicion.Defensor, "Chile", true));
		chile.agregar(new Jugador("Eugenio", "Mena", 49652114, Posicion.Defensor, "Chile", true));
		chile.agregar(new Jugador("Gonzalo", "Jara", 49652115, Posicion.Defensor, "Chile", true));
		chile.agregar(new Jugador("Jorge", "Valdivia", 49652116, Posicion.MedioCampista, "Chile", true));
		chile.agregar(new Jugador("David", "Pizarro", 49652117, Posicion.MedioCampista, "Chile", true));
		chile.agregar(new Jugador("Francisco", "Silva", 49652118, Posicion.MedioCampista, "Chile", true));
		chile.agregar(new Jugador("Angelo", "Henriquez", 49652119, Posicion.Delantero, "Chile", true));
		chile.agregar(new Jugador("Mauricio", "Pinilla", 49652110, Posicion.Delantero, "Chile", true));
		chile.agregar(new Jugador("Alexis", "Sanchez", 49652128, Posicion.Delantero, "Chile", true));
		
		
		Equipo jamaica = new Equipo ("Jamaica");
		jamaica.agregar(new Jugador("Duwayne", "Kerr", 623456888, Posicion.Arquero, "Jamaica", true));
		jamaica.agregar(new Jugador("Michael", "Hector", 66456888, Posicion.Defensor, "Jamaica", true));
		jamaica.agregar(new Jugador("Lance", "Laing", 62346888, Posicion.Defensor, "Jamaica", true));
		jamaica.agregar(new Jugador("Wes", "Morgan", 62346888, Posicion.Defensor, "Jamaica", true));
		jamaica.agregar(new Jugador("Adrian", "Mariappa", 62346888, Posicion.Defensor, "Jamaica", true));
		jamaica.agregar(new Jugador("Daniel", "Gordon", 62346888, Posicion.MedioCampista, "Jamaica", true));
		jamaica.agregar(new Jugador("Romeo", "Parkes", 62345888, Posicion.MedioCampista, "Jamaica", true));
		jamaica.agregar(new Jugador("Allan", "Ottey", 66456888, Posicion.MedioCampista, "Jamaica", true));
		jamaica.agregar(new Jugador("Dino", "Williams", 62345888, Posicion.Delantero, "Jamaica", true));
		jamaica.agregar(new Jugador("Giles", "Barnes", 62345888, Posicion.Delantero, "Jamaica", true));
		jamaica.agregar(new Jugador("Darren", "Mattocks", 62346888, Posicion.Delantero, "Jamaica", true));
		
		Equipo colombia = new Equipo ("Colombia");
		colombia.agregar(new Jugador("David", "Ospina", 52346800, Posicion.Arquero, "Colombia", true));
		colombia.agregar(new Jugador("Pablo", "Armero", 52345881, Posicion.Defensor, "Colombia", true));
		colombia.agregar(new Jugador("Cristian", "Zapata", 52346801, Posicion.Defensor, "Colombia", true));
		colombia.agregar(new Jugador("Pedro", "Franco", 52346882, Posicion.Defensor, "Colombia", true));
		colombia.agregar(new Jugador("Juan", "Zuñiga", 52345883, Posicion.Defensor, "Colombia", true));
		colombia.agregar(new Jugador("Edwin", "Cardona", 52346884, Posicion.MedioCampista, "Colombia", true));
		colombia.agregar(new Jugador("Juan", "Cuadrado", 52346885, Posicion.MedioCampista, "Colombia", true));
		colombia.agregar(new Jugador("James", "Rodriguez", 52456886, Posicion.MedioCampista, "Colombia", true));
		colombia.agregar(new Jugador("Jackson","Martinez", 52456887, Posicion.Delantero, "Colombia", true));
		colombia.agregar(new Jugador("Radamel","Falcao", 52345688, Posicion.Delantero, "Colombia", true));
		colombia.agregar(new Jugador("Teofilo", "Gutirriez", 52356889, Posicion.Delantero, "Colombia", true));
		
		Equipo bolivia = new Equipo ("Bolivia");
		bolivia.agregar(new Jugador("Romel", "Quiñonez", 223456008, Posicion.Arquero, "Bolivia", true));
		bolivia.agregar(new Jugador("Leonel", "Morales", 223456808, Posicion.Defensor, "Bolivia", true));
		bolivia.agregar(new Jugador("Ronald", "Raldes", 223456818, Posicion.Defensor, "Bolivia", true));
		bolivia.agregar(new Jugador("Cristian", "Coimbra", 223456828, Posicion.Defensor, "Bolivia", true));
		bolivia.agregar(new Jugador("Edemir", "Rodriguez", 223456838, Posicion.Defensor, "Bolivia", true));
		bolivia.agregar(new Jugador("Pablo", "Escobar", 223456848, Posicion.MedioCampista, "Bolivia", true));
		bolivia.agregar(new Jugador("Damir", "Miranda", 223456858, Posicion.MedioCampista, "Bolivia", true));
		bolivia.agregar(new Jugador("Sebastian", "Gamarra", 223456868, Posicion.MedioCampista, "Bolivia", true));
		bolivia.agregar(new Jugador("Marcelo", "Moreno", 223456878, Posicion.Delantero, "Bolivia", true));
		bolivia.agregar(new Jugador("Damian", "Lizio", 223456888, Posicion.Delantero, "Bolivia", true));
		bolivia.agregar(new Jugador("Alcides", "Peña", 223456898, Posicion.Delantero, "Bolivia", true));
		
		Equipo mexico  = new Equipo ("Mexico");
		mexico.agregar(new Jugador("Alfredo", "Talabera", 323456808, Posicion.Arquero, "Mexico", true));
		mexico.agregar(new Jugador("Carlos", "Salcedo", 323456818, Posicion.Defensor, "Mexico", true));
		mexico.agregar(new Jugador("Hugo", "Ayala", 323456828, Posicion.Defensor, "Mexico", true));
		mexico.agregar(new Jugador("Rafael", "Marquez", 323456838, Posicion.Defensor, "Mexico", true));
		mexico.agregar(new Jugador("Cesar", "Dominguez", 323406848, Posicion.Defensor, "Mexico", true));
		mexico.agregar(new Jugador("Mario", "Osuna", 323456848, Posicion.MedioCampista, "Mexico", true));
		mexico.agregar(new Jugador("Luis", "Montes", 323456858, Posicion.MedioCampista, "Mexico", true));
		mexico.agregar(new Jugador("Javier", "Aquino", 323456868, Posicion.MedioCampista, "Mexico", true));
		mexico.agregar(new Jugador("Jesus", "Corona", 323456878, Posicion.Delantero, "Mexico", true));
		mexico.agregar(new Jugador("Raul", "Jimenez", 323456888, Posicion.Delantero, "Mexico", true));
		mexico.agregar(new Jugador("Eduardo", "Herrera", 323456898, Posicion.Delantero, "Mexico", true));
		
		Equipo ecuador = new Equipo ("Ecuador");
		ecuador.agregar(new Jugador("Librado", "Azcona", 423456008, Posicion.Arquero, "Ecuador", true));
		ecuador.agregar(new Jugador("Mario", "Pineida", 423456899, Posicion.Defensor, "Ecuador", true));
		ecuador.agregar(new Jugador("John", "Narvaez", 423456888, Posicion.Defensor, "Ecuador", true));
		ecuador.agregar(new Jugador("Oscar", "Bagui", 423456878, Posicion.Defensor, "Ecuador", true));
		ecuador.agregar(new Jugador("Gabriel", "Achilier", 423456668, Posicion.Defensor, "Ecuador", true));
		ecuador.agregar(new Jugador("Arturo", "Mina", 423456858, Posicion.MedioCampista, "Ecuador", true));
		ecuador.agregar(new Jugador("Pedro", "Larrea", 423456488, Posicion.MedioCampista, "Ecuador", true));
		ecuador.agregar(new Jugador("Walter", "Ayovi", 423456838, Posicion.MedioCampista, "Ecuador", true));
		ecuador.agregar(new Jugador("Renato", "Ibarra", 423456288, Posicion.Delantero, "Ecuador", true));
		ecuador.agregar(new Jugador("Juan", "Paredes", 423456818, Posicion.Delantero, "Ecuador", true));
		ecuador.agregar(new Jugador("Daniel", "Angulo", 423456808, Posicion.Delantero, "Ecuador", true));
		
		
		Equipo peru = new Equipo ("Peru");
		peru.agregar(new Jugador("Pedro", "Gallese", 103456888, Posicion.Arquero, "Peru", true));
		peru.agregar(new Jugador("Carlos", "Zambrano", 103459888, Posicion.Defensor, "Peru", true));
		peru.agregar(new Jugador("Juan", "Vargas", 123450888, Posicion.Defensor, "Peru", true));
		peru.agregar(new Jugador("Pedro", "Requena", 123456088, Posicion.Defensor, "Peru", true));
		peru.agregar(new Jugador("Carlos", "Ascues", 123456878, Posicion.Defensor, "Peru", true));
		peru.agregar(new Jugador("Paolo", "Hurtado", 123456988, Posicion.MedioCampista, "Peru", true));
		peru.agregar(new Jugador("Andre", "Carrillo", 123756888, Posicion.MedioCampista, "Peru", true));
		peru.agregar(new Jugador("Carlos", "Lobaton", 123456788, Posicion.MedioCampista, "Peru", true));
		peru.agregar(new Jugador("Jefferson", "Farfan", 123456868, Posicion.Delantero, "Peru", true));
		peru.agregar(new Jugador("Paolo", "Guerrero", 123456887, Posicion.Delantero, "Peru", true));
		peru.agregar(new Jugador("Claudio", "Pizarro", 123456808, Posicion.Delantero, "Peru", true));
		
		agregar(bolivia);
		agregar(mexico);
		agregar(ecuador);
		agregar(chile);
		agregar(jamaica);
		agregar(colombia);
		agregar(peru);
	}
	
	public Lista<Jugador> grupoDeJugadores(Posicion posicion)
	{		
		Lista<Jugador> jugadores=new Lista<Jugador>();
		for (Equipo e : this) 
		{
			jugadores.union(e.jugadoresPorPosicion(posicion));					//se agregan todos los jugadores de los equipos que tengan
		}																		// la posicion pasada como parametro a una lista
		return jugadores;
	}
	
	public Equipo pedirEquipo(String seleccion)
	{	
		Equipo equipo=null;
		for(Equipo e : this)
		{																		//dado el nombre de una seleccion se devuelve su equipo completo
			if (e.mismaSeleccion(seleccion))
				equipo=e;
		}
		return equipo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

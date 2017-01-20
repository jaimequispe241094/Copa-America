package Negocio;
	
import java.util.Random;
	
public class Jugador {
		
		private String nombre;
		private String apellido;
		private int dni;
		private Posicion posicion;
		private boolean esTitular;
		private int puntaje;
		private boolean tarjetaRoja;
		private boolean tarjetaAmarilla;
		private String seleccion;
		private Random ale=new Random();

		public Jugador(String nombre, String apellido, int dni, Posicion posicion,String seleccion, boolean titular) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.posicion = posicion;
			this.seleccion = seleccion;
			this.esTitular = titular;
			this.tarjetaAmarilla = ale.nextBoolean();
			this.tarjetaRoja = ale.nextBoolean();
			this.puntaje = calcularPuntaje();
		}
		
		@Override
		public boolean equals(Object obj) {
			boolean ret = false;
			if (obj instanceof Jugador)
			{
			Jugador jugador = (Jugador) obj;
			ret = mismoNombre(jugador) && mismoApellido(jugador) && mismoDni(jugador) && mismaSeleccion(jugador); 
			}		
			return ret;
		}
	
		private int calcularPuntaje() {
			return ale.nextInt(10)+1;			//sumo 1 para que no tenga puntaje cero
		}	
			
		public boolean mismaSeleccion(Jugador jugador) {
			if (jugador != null)
				return getSeleccion().equals(jugador.getSeleccion());			//se comnpara la seleecion con la de otro jugador no nulo
			return false;
		}
		
		public boolean mismoNombre(Jugador jugador){
			if (jugador != null)
				return getNombre().equals(jugador.getNombre());				   //se comnpara el nombre con la de otro jugador no nulo
			return false;
		}
		
		public boolean mismoApellido(Jugador jugador){	
			if (jugador != null)
				return getApellido().equals(jugador.getApellido());				//se comnpara el apellido con la de otro jugador nonulo
			return false;
		}
		
		public boolean mismoDni(Jugador jugador){	
			if (jugador != null)											//se comnpara el dni con la de otro jugador no nulo
				return getDni()==jugador.getDni();
			return false;
		}
		
		public boolean mismaPosicion(Posicion posicion){
			if (posicion != null){										//se comnpara la posicion de ljugador con la que se le pasa como parametro
				return getPosicion()==posicion;}
			return false;
		}
	
		public String getNombre() {
			return nombre;
		}
		
		public String getApellido() {
			return apellido;
		}
		
		public int getDni() {
			return dni;
		}
		
		public Posicion getPosicion() {
			return posicion;
		}
	
		public int getPuntaje() {
			return puntaje;
		}
		public void setPuntaje(int puntaje) {
			this.puntaje= puntaje;
		}
		
		public boolean getEsTitular() {
			return esTitular;
		}
		public void setEsTitular(boolean esTitular) {
			this.esTitular = esTitular;
		}
		
		public String getSeleccion() {
			return seleccion;
		}
		
		public boolean getTarjetaRoja() {
			return tarjetaRoja;
		}

		public boolean getTarjetaAmarilla() {
			return tarjetaAmarilla;
		}
		
		public void setTarjetaRoja(boolean valor){
			this.tarjetaRoja = valor;
		}
		
		public void setTarjetaAmarilla(boolean valor){
			this.tarjetaAmarilla = valor;
		}
		
		public void setNombre(String nombre){
			this.nombre = nombre;
		}
		
		public void setApellido(String apellido){
			this.apellido = apellido;
		}
		
		public void setDni(int dni){
			this.dni = dni;
		}
		
		public void setPosicion(Posicion p){
			this.posicion = p;
		}

		@Override
		public String toString() {
			return nombre+" "+apellido;
		}
}

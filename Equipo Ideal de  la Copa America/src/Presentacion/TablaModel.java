package Presentacion;

import javax.swing.table.AbstractTableModel;
import Negocio.Equipo;
import Negocio.EquipoIdeal;
import Negocio.Jugador;
import Negocio.Lista;

@SuppressWarnings("serial")
public class TablaModel extends AbstractTableModel{
	
	private Lista<Jugador> equipo;
	private String[] columnas = new String[]{"Nombre","Apellido","Seleccion","Posicion","Puntaje","Tarjeta Amarilla","Tarjeta Roja"};; 
	@SuppressWarnings("rawtypes")
	private Class[] tipoColumnas = new Class[] {Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class, Boolean.class};;
	
	
	public TablaModel(Equipo equipo){
		this.equipo = equipo;
	}

	public TablaModel(EquipoIdeal equipoIdeal){
		this.equipo = equipoIdeal;
	}
													//sobreescritura de los metodos mas comunes de un Modelo de Tabla, a conveniencia
	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		return equipo.tamaño();
	}

	@Override
	public String getColumnName(int columna){
		return columnas[columna];
	}

	@Override
	public boolean isCellEditable(int fila,int columna){
		return false;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int columnIndex) {
			return tipoColumnas[columnIndex];
	}
	
	@Override
	public Object getValueAt(int fila, int columna) 
	{
		switch (columna)														//se cargan los datos dependiendo de su columna y fila
		{
			case 0:return equipo.iesimo(fila).getNombre();
			case 1:return equipo.iesimo(fila).getApellido();	
			case 2:return equipo.iesimo(fila).getSeleccion();
			case 3:return equipo.iesimo(fila).getPosicion();
			case 4:return equipo.iesimo(fila).getPuntaje();
			case 5:return equipo.iesimo(fila).getTarjetaAmarilla();
			case 6:return equipo.iesimo(fila).getTarjetaRoja();		
			default:return null;
		}
	}
}

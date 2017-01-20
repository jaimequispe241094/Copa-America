package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import Negocio.Equipo;
import Negocio.Jugador;
import Negocio.Torneo;

@SuppressWarnings("serial")
public class PanelEditor extends JPanel{

	private static JTextField seleccion;
	private JLabel lblSeleccion;
	private JLabel lblJugador;
	private static JComboBox<Jugador> jugadores;
	private JLabel lblNombre;
	private JLabel lblApellido; 
	private JLabel lblDni;
	private JLabel lblPosicion;
	private JLabel lblPuntaje;
	private JTextField campoNombre;
	private JTextField campoApellido;
	private JTextField campoDni;
	private JTextField posicion;	
	private JSpinner puntaje;
	private JCheckBox roja;
	private JCheckBox amarilla;
	private JLabel tarjetas;
	private static Torneo torneo;
	private JButton guardar;
	private static PanelJugador panelJugador;
	
	public PanelEditor(Torneo t,PanelJugador p){
		
		seleccion = new JTextField();
		lblSeleccion = new JLabel("Seleccion");
		lblJugador = new JLabel("Jugador");
		jugadores = new JComboBox<Jugador>();
		lblNombre = new JLabel("Nombre");
		lblApellido = new JLabel("Apellido");
		lblDni = new JLabel("Dni");
		lblPosicion = new JLabel("Posicion");
		lblPuntaje = new JLabel("Puntaje");
		campoNombre = new JTextField();
		campoApellido = new JTextField();
		campoDni = new JTextField();
		posicion = new JTextField();
		puntaje = new JSpinner();
		puntaje.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		roja = new JCheckBox("Roja");
		amarilla = new JCheckBox("Amarilla");
		tarjetas = new JLabel("Tarjetas");
		guardar = new JButton("Guardar");
		torneo = t;
		panelJugador = p;
		
		cargarComponentes();
		cargarJugadores();
		accionarJugador();
		setearJugador();
	}
	
	public void cargarComponentes(){
		
		lblSeleccion.setBounds(10, 25, 51, 14);
		this.add(lblSeleccion);
		
		lblJugador.setBounds(10, 56, 46, 14);
		this.add(lblJugador);
		
		jugadores.setBounds(71, 53, 118, 20);
		this.add(jugadores);
		
		lblNombre.setBounds(10, 95, 46, 14);
		this.add(lblNombre);
		
		lblApellido.setBounds(10, 126, 46, 14);
		this.add(lblApellido);
		
		lblDni.setBounds(15, 146, 46, 25);
		this.add(lblDni);
		
		lblPosicion.setBounds(10, 182, 46, 14);
		this.add(lblPosicion);
		
		lblPuntaje.setBounds(10, 212, 46, 14);
		this.add(lblPuntaje);
		
		tarjetas.setBounds(10, 240, 75, 14);
		this.add(tarjetas);
		
		seleccion.setBounds(71, 22, 118, 20);
		this.add(seleccion);
		seleccion.setColumns(10);
		seleccion.setEditable(false);
		
		campoNombre.setBounds(71, 92, 118, 20);
		this.add(campoNombre);
		campoNombre.setEditable(false);
		campoNombre.setColumns(10);
		
		campoApellido.setBounds(71, 123, 118, 20);
		this.add(campoApellido);
		campoApellido.setEditable(false);
		campoApellido.setColumns(10);
		
		campoDni.setBounds(71, 148, 118, 20);
		this.add(campoDni);
		campoDni.setColumns(10);
		campoDni.setEditable(false);
		
		posicion.setBounds(71, 179, 118, 20);
		posicion.setEditable(false);
		this.add(posicion);
		
		puntaje.setBounds(71, 209, 118, 20);
		this.add(puntaje);
		
		roja.setBounds(71, 240, 97, 23);
		this.add(roja);
		
		amarilla.setBounds(71, 261, 97, 23);
		this.add(amarilla);
		
		guardar.setBounds(55, 290, 98, 36);
		this.add(guardar);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void cargarJugadores(){
		String paisSeleccionado = (String) panelJugador.getItemSeleccionado();
			if (panelJugador.hayUnPaisSeleccionado())
			{																				//se cargan en el JComboBox todos los jugadores del 	
				seleccion.setText((String) panelJugador.getItemSeleccionado());				//pais que es seleccionado en el panel de jugadores
				Equipo equipo = torneo.pedirEquipo(paisSeleccionado);
				Jugador[] lista = new Jugador[equipo.tamaño()];
				for (int i = 0; i < lista.length; i++) {
					lista[i] = equipo.iesimo(i);
				}
				jugadores.setModel(new DefaultComboBoxModel(lista));
			}
	}
	
	public void accionarJugador()
	{
		jugadores.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) 							//cuando ocurre el evento de que se selecciono un jugador
			{																		//se llenan los campos con los datos del mismo
			Jugador jugador = (Jugador) jugadores.getSelectedItem();
			campoNombre.setText(jugador.getNombre());
			campoApellido.setText(jugador.getApellido());
			campoDni.setText(String.valueOf(jugador.getDni()));
			posicion.setText(""+jugador.getPosicion()+"");
			puntaje.setValue(jugador.getPuntaje());
			roja.setSelected(jugador.getTarjetaRoja());
			amarilla.setSelected(jugador.getTarjetaAmarilla() );
			}
		});
	}
	
	public void setearJugador()
	{
		guardar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{																		//si se setea algun dato de un jugador se guarda
			Jugador jugador = (Jugador) jugadores.getSelectedItem();				// y actualiza la tabla
			jugador.setPuntaje((int)puntaje.getValue());
			jugador.setTarjetaAmarilla(amarilla.isSelected());
			jugador.setTarjetaRoja(roja.isSelected());	
			panelJugador.actualizarTabla(jugador.getSeleccion());}
		});
	}
	
}

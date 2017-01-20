package Presentacion;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import Negocio.Torneo;

@SuppressWarnings("serial")
public class PanelJugador extends JPanel{

	@SuppressWarnings("rawtypes")
	private JComboBox lista;
	private JLabel logo;
	private JLabel equipo; 
	private JButton verJugadores;
	private Torneo torneo;
	private JTable table;
	
	@SuppressWarnings("rawtypes")
	public PanelJugador(Torneo t,JTable table){
		lista = new JComboBox();
		logo = new JLabel("");
		equipo = new JLabel("Equipo");
		verJugadores = new JButton("Ver Jugadores");
		this.table = table;
		torneo = t;
		
		cargarComponentes();
		cargarLogoDelEquipo();
		setearEquipoEnTabla();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void cargarComponentes(){
		
		logo.setBounds(23, 81, 159, 141);
		this.add(logo);
		
		equipo.setBounds(13, 37, 52, 14);
		this.add(equipo);
		
		verJugadores.setBounds(45, 255, 116, 50);
		this.add(verJugadores);
		
		lista.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar","Argentina", "Uruguay", "Paraguay", "Brasil", "Bolivia", "Peru", "Chile", "Jamaica", "Colombia", "Venezuela", "Ecuador", "Mexico"}));
		lista.setBounds(60, 33, 113, 22);
		this.add(lista);
	}
	
	public void cargarLogoDelEquipo()
	{
		lista.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent arg0) 
			{
				if(hayUnPaisSeleccionado())								//si se selecciona un equipo se carga su logo en la interface
				{
					String pais = (String) lista.getSelectedItem();
					logo.setIcon(new ImagenUsuarioIcon(getClass().getResource("/imagenes/" + pais + ".png")));
					logo.setPreferredSize(new Dimension(130, 130));
					PanelEditor.cargarJugadores();
			    }
			}
		});
	}
		
	public void setearEquipoEnTabla()
	{
		verJugadores.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String equipo = (String) lista.getSelectedItem();							//se setea en la tabla todos los datos de los jugadores del equipo seleccionado
				if (hayUnPaisSeleccionado())
				{		table.setModel(new TablaModel(torneo.pedirEquipo(equipo)));			}
			}
		});
	}
	
	public boolean hayUnPaisSeleccionado(){
		return !lista.getSelectedItem().equals("Seleccionar");					// boolean que dice si lo que se selecciono es un equipo
	}
	
	public Object getItemSeleccionado(){
		return lista.getSelectedItem();									//se duvuelve el item seleccionado
	}
	
	public void actualizarTabla(String pais){
		lista.setSelectedItem(pais);
		verJugadores.doClick();												//atraves de la simulacion de un click se actualiza los datos de la tabla
	}
}

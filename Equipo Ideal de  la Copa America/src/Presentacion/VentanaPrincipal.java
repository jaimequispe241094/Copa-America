package Presentacion;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import Negocio.EquipoIdeal;
import Negocio.Generador;
import Negocio.Torneo;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame laCopaAmerica;
	private JTable table;
	private Torneo torneo = new Torneo("Copa America");
	private PanelEditor panelEditor;
	private PanelJugador panelJugador; 
	private PanelEquipo panelEquipo;
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try 
		{
			UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel");
		}
		catch (ClassNotFoundException | InstantiationException| IllegalAccessException | UnsupportedLookAndFeelException e1) 
		{
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.laCopaAmerica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		initialize();
	}
	
	private void initialize() {
		laCopaAmerica = new JFrame();
		laCopaAmerica.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/logo copa.jpg")));
		laCopaAmerica.setResizable(false);
		laCopaAmerica.setType(Type.POPUP);
		laCopaAmerica.setTitle("\t\t\t\t\t\t\t\t\t La Copa America");
		laCopaAmerica.setBounds(100, 100, 950, 425);
		laCopaAmerica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		laCopaAmerica.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(239, 56, 680, 263);
		laCopaAmerica.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 30, 209, 356);
		laCopaAmerica.getContentPane().add(tabbedPane);
		
		panelEquipo = new PanelEquipo();
		tabbedPane.addTab("Equipos", null, panelEquipo, null);
		panelEquipo.setLayout(null);
		
		panelJugador = new PanelJugador(torneo,table);
		tabbedPane.addTab("Jugadores", null, panelJugador, null);
		panelJugador.setLayout(null);
		
		panelEditor = new PanelEditor(torneo,panelJugador);
		tabbedPane.addTab("Editor", null, panelEditor, null);
		panelEditor.setLayout(null);
		
		JButton equipoIdeal = new JButton("Equipo Ideal");
		equipoIdeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{																			//se genera la instancia de un torneo con los equipos seleccionados 
				Torneo t = (Torneo) panelEquipo.seleccionados(torneo);					//y se realiza la busqueda del mejor equipo
				EquipoIdeal ideal = new Generador(t).mejorEquipo();
				if (ideal !=null)
				{
					table.setModel(new TablaModel(ideal));								//se lo setea en la tabla
				}
				else
				{
					JOptionPane.showMessageDialog(laCopaAmerica, "No se encontro un Equipo Ideal"); 	//se muestra un mensaje en el caso que se haya podido formar un equipo ideal
					System.out.println("No hay Equipo Ideal");
				}
			}
		});
		equipoIdeal.setToolTipText("Seleccione equipos");
		equipoIdeal.setBounds(539, 328, 112, 40);
		laCopaAmerica.getContentPane().add(equipoIdeal);	
	}
}

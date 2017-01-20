package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import Negocio.Equipo;
import Negocio.Lista;
import Negocio.Torneo;

@SuppressWarnings("serial")
public class PanelEquipo extends JPanel{
	
	private Lista<JCheckBox> paises;
	private JCheckBox argentina;
	private JCheckBox brasil;	
	private JCheckBox uruguay;
	private JCheckBox paraguay;
	private JCheckBox colombia;	
	private JCheckBox venezuela;
	private JCheckBox ecuador;
	private JCheckBox chile;
	private JCheckBox bolivia;
	private JCheckBox peru;
	private JCheckBox jamaica;
	private JCheckBox mexico;
	private JButton todos;
	private JButton limpiar;
	
	public PanelEquipo(){
		paises = new Lista<JCheckBox>();
		argentina = new JCheckBox("Argentina");
		brasil = new JCheckBox("Brasil");
		paraguay = new JCheckBox("Paraguay");
		uruguay = new JCheckBox("Uruguay");
		bolivia = new JCheckBox("Bolivia");
		chile = new JCheckBox("Chile");
		jamaica = new JCheckBox("Jamaica");
		colombia = new JCheckBox("Colombia");
		venezuela = new JCheckBox("Venezuela");
		mexico = new JCheckBox("Mexico");
		ecuador = new JCheckBox("Ecuador");
		peru = new JCheckBox("Peru");
		todos = new JButton("Todos");
		limpiar = new JButton("Limpiar");
	
		cargarComponentes();
		cargarAcciones();
	} 
	
	public void cargarComponentes(){
		
		paises.agregar(argentina);
		argentina.setBounds(9, 20, 97, 23);
		this.add(argentina);
		
		paises.agregar(brasil);
		brasil.setBounds(9, 43, 97, 23);
		this.add(brasil);
		
		paises.agregar(paraguay);
		paraguay.setBounds(9, 83, 97, 23);
		this.add(paraguay);
		
		paises.agregar(uruguay);
		uruguay.setBounds(9, 104, 97, 23);
		this.add(uruguay);
		
		paises.agregar(bolivia);
		bolivia.setBounds(9, 123, 97, 23);
		this.add(bolivia);
		
		paises.agregar(chile);
		chile.setBounds(9, 143, 97, 23);
		this.add(chile);
		
		paises.agregar(jamaica);
		jamaica.setBounds(9, 160, 97, 23);
		this.add(jamaica);
		
		paises.agregar(colombia);
		colombia.setBounds(9, 178, 97, 23);
		this.add(colombia);
		
		paises.agregar(venezuela);
		venezuela.setBounds(9, 62, 97, 23);
		this.add(venezuela);
		
		paises.agregar(mexico);
		mexico.setBounds(9, 196, 97, 23);
		this.add(mexico);
		
		paises.agregar(ecuador);
		ecuador.setBounds(9,214, 97, 23);
		this.add(ecuador);
		
		paises.agregar(peru);
		peru.setBounds(9, 231, 97, 23);
		this.add(peru);
		
		todos.setBounds(5, 277, 82, 37);
		this.add(todos);
		
		limpiar.setBounds(105, 277, 82, 37);
		this.add(limpiar);
	}
	
	public void cargarAcciones(){
		todos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {					//se maracan todos los JCheckBox
				seleccionarTodos(true);
			}
		});
		
		limpiar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				seleccionarTodos(false);									//se desmaracan todos los JCheckBox
			}
		});
	}
	
	public void seleccionarTodos(boolean valor)
	{
		for (JCheckBox J : paises)
		{			J.setSelected(valor);			}						//se cambian todos los estados de los JcheckBox por 
	}																		// el boolean pasado como parametro	
	
	public Torneo seleccionados(Torneo torneo){
		Torneo equipos = new Torneo();
		for (JCheckBox pais : paises){
			if(pais.isSelected())											//se cargan en una instancia de Torneo todos los 
			{																//equipos que se seleccionaron
				Equipo seleccionado = torneo.pedirEquipo(pais.getText());
				equipos.agregar(seleccionado);
			}	
		}
		return equipos;
	}
}

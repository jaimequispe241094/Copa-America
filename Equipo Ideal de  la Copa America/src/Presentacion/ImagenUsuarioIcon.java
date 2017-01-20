package Presentacion;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ImagenUsuarioIcon extends ImageIcon {

	 	public ImagenUsuarioIcon(String filename) { 
	 	    super(filename); 
	 	}; 
	 																//distontos constructores posibles para la imagen
	    public ImagenUsuarioIcon(Image image) {						//se puede  pasar la locacion en el cpu, nombre de la imagen o la imagen
	        super(image);
	    }

	    public ImagenUsuarioIcon(URL location) {
	        super(location);
	    }	    
	        
	    @Override
	 	public synchronized void paintIcon(Component component, Graphics graphics, int x, int y) { 
	 
	 	    graphics.fillRect(0,0, component.getWidth(), component.getHeight()); 
	 	    if(getImageObserver() == null) 																	//se ajusta la imagen al tamaño del componente
	 	    {                   
	 	    	graphics.drawImage(getImage(),0,0,component.getWidth(), component.getHeight(),component); 
	 	    } 
	 	    else 
	 	    { 
	 	    	graphics.drawImage(getImage(),0,0,component.getWidth(),component.getHeight(),getImageObserver()); 
	 	    } 
	 	} 
}

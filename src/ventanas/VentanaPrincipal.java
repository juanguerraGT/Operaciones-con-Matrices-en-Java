package ventanas;

/*
 * 		CLASE VENTANAPRINCIPAL que define las características de la ventana principal(única) del programa.
 * 		Ésta ventana contiene tres paneles como campos de clase, y a su vez define métodos que controlan su visibilidad
 * para mostrarlos u ocultarlos según las acciones que el usuario esté realizando en la GUI del programa.
 * 		Los paneles han sido declarados como campos estáticos al igual que los métodos que modifican la visibilidad de los mismos para
 * poder llamarlos desde cualquier parte del programa sin necesidad de una instancia de la clase.*/


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import paneles.PanelFondo;
import paneles.PanelOpciones;
import paneles.PanelOperaciones;

public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static PanelFondo pnlSoporte = new PanelFondo(); 
	private static PanelOpciones pnlInicio = new PanelOpciones(); 
	private static PanelOperaciones pnlOperaciones = new PanelOperaciones();	

	public VentanaPrincipal()
	{
	
		pnlSoporte.add(pnlOperaciones, BorderLayout.CENTER);
		pnlOperaciones.setVisible(false);
		
		pnlSoporte.add(pnlInicio, BorderLayout.CENTER);
		
		setSize(900,700);
		setMinimumSize(new Dimension(850,700));
		setLocationRelativeTo(null);
		setTitle("Operaciones con matrices");
		Image icono;
		try {
			URL ruta=VentanaPrincipal.class.getResource("/ICONOS/icon.png");
			icono = ImageIO.read(ruta);
			setIconImage(icono);
		} catch (IOException ex) {
			
			ex.printStackTrace();
		}		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(pnlSoporte);
		
	}
	
	public static void mostrarMenuPrincipal()
	{
		pnlOperaciones.setVisible(false);
		pnlInicio.setVisible(true);
		pnlSoporte.add(pnlInicio, BorderLayout.CENTER);
		pnlInicio.updateUI();
	}
	
	public static void mostrarPanelOperaciones(int operacion)
	{
		
		pnlOperaciones.setVisible(true);
		pnlInicio.setVisible(false);
		pnlOperaciones.mostrarPaneles(operacion);
		pnlSoporte.add(pnlOperaciones, BorderLayout.CENTER);
		pnlOperaciones.updateUI();
		
	}
	
	public static void ingresarDatos(int filas1, int columnas1, int filas2, int columnas2, int operacion)
	{
		pnlOperaciones.mostrarGridsIngresoDatos(filas1, columnas1, filas2, columnas2, operacion);	
		pnlOperaciones.updateUI();		
	}	
	
	public static void actualizarPanelIngresoDatos()
	{
		pnlOperaciones.actualizarPanelIngresoDatos();
	}

}	
package paneles;

/*
 * 	Panel que muestra las operaciones disponibles en el programa
 * 
 **/

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import otros_graficos.Apariencia;
import ventanas.VentanaPrincipal;

public class PanelOpciones extends JPanel {

	private static final long serialVersionUID = 1L;
	private int ancho, alto;
	private JLabel opSuma;
	private JLabel opResta;
	private JLabel opMultiplicacion;
	private JLabel opMultiplicacionEscalar;
	private JLabel opTranspuesta;
	private JLabel opDeterminante;
	private JButton btnAbout;
	private URL ruta;
	
	public PanelOpciones()
	{
		
		ancho = 900;
		alto = 700;
		
		inicializar();
		agregarEfectosOpciones();
		
		setLayout(null);
		setBackground(new Color(25,25,25));
		
		add(opSuma);
		add(opResta);
		add(opMultiplicacion);
		add(opMultiplicacionEscalar);
		add(opTranspuesta);
		add(opDeterminante);
		add(btnAbout);
		repaint();
		
	}
	
	private void inicializar()
	{
		
		ruta=PanelOpciones.class.getResource("/ICONOS/icono_suma.png");
		opSuma = new JLabel(new ImageIcon(ruta));
		opSuma.setSize(250, 250);
		
		ruta=PanelOpciones.class.getResource("/ICONOS/icono_resta.png");
		opResta = new JLabel(new ImageIcon(ruta));
		opResta.setSize(250, 250);
		
		ruta=PanelOpciones.class.getResource("/ICONOS/icono_multiplicacion.png");
		opMultiplicacion = new JLabel(new ImageIcon(ruta));
		opMultiplicacion.setSize(250, 250);
		
		ruta=PanelOpciones.class.getResource("/ICONOS/icono_multiplicacion_por_escalar.png");
		opMultiplicacionEscalar = new JLabel(new ImageIcon(ruta));
		opMultiplicacionEscalar.setSize(250, 250);
		
		ruta=PanelOpciones.class.getResource("/ICONOS/icono_transpuesta.png");
		opTranspuesta = new JLabel(new ImageIcon(ruta));
		opTranspuesta.setSize(250, 250);
		
		ruta=PanelOpciones.class.getResource("/ICONOS/icono_determinante.png");
		opDeterminante = new JLabel(new ImageIcon(ruta));
		opDeterminante.setSize(250, 250);
		
		btnAbout=new JButton("Información");
		btnAbout.setSize(100, 20);
		btnAbout.setBorder(new LineBorder(new Color(25,25,25)));
		btnAbout.setBackground(new Color(25,25,25));
		btnAbout.setFocusPainted(false);
		btnAbout.setForeground(Apariencia.verde);
		btnAbout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAbout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(PanelOpciones.this, "@Creado por\n JUAN ANTONIO GUERRA LÓPEZ\n 2017", "Información", JOptionPane.OK_OPTION, new ImageIcon(""));
			}
		});
		
	}
	
	private void agregarEfectosOpciones()
	{
		
		Cursor cursorManita=new Cursor(Cursor.HAND_CURSOR);
		
		opSuma.setCursor(cursorManita);
		opSuma.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent mev) {				
				VentanaPrincipal.mostrarPanelOperaciones(1);				
			}

			public void mouseEntered(MouseEvent mev) {				
				ruta=PanelOpciones.class.getResource("/ICONOS/icono_suma_efecto.png");
				opSuma.setIcon(new ImageIcon(ruta));				
			}

			public void mouseExited(MouseEvent mev) {
				ruta=PanelOpciones.class.getResource("/ICONOS/icono_suma.png");
				opSuma.setIcon(new ImageIcon(ruta));				
			}

		});
		
		opResta.setCursor(cursorManita);
		opResta.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent mev) {				
				VentanaPrincipal.mostrarPanelOperaciones(2);				
			}

			public void mouseEntered(MouseEvent mev) {
				ruta=PanelOpciones.class.getResource("/ICONOS/icono_resta_efecto.png");
				opResta.setIcon(new ImageIcon(ruta));				
			}

			public void mouseExited(MouseEvent mev) {
				ruta=PanelOpciones.class.getResource("/ICONOS/icono_resta.png");
				opResta.setIcon(new ImageIcon(ruta));				
			}

		});
		
		opMultiplicacion.setCursor(cursorManita);
		opMultiplicacion.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent mev) {				
				VentanaPrincipal.mostrarPanelOperaciones(3);				
			}

			public void mouseEntered(MouseEvent mev) {
				ruta=PanelOpciones.class.getResource("/ICONOS/icono_multiplicacion_efecto.png");
				opMultiplicacion.setIcon(new ImageIcon(ruta));				
			}

			public void mouseExited(MouseEvent mev) {		
				ruta=PanelOpciones.class.getResource("/ICONOS/icono_multiplicacion.png");
				opMultiplicacion.setIcon(new ImageIcon(ruta));				
			}

		});
		
		opMultiplicacionEscalar.setCursor(cursorManita);
		opMultiplicacionEscalar.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent mev) {				
				VentanaPrincipal.mostrarPanelOperaciones(4);				
			}

			public void mouseEntered(MouseEvent mev) {
				ruta=PanelOpciones.class.getResource("/ICONOS/icono_multiplicacion_por_escalar_efecto.png");
				opMultiplicacionEscalar.setIcon(new ImageIcon(ruta));				
			}

			public void mouseExited(MouseEvent mev) {
				ruta=PanelOpciones.class.getResource("/ICONOS/icono_multiplicacion_por_escalar.png");
				opMultiplicacionEscalar.setIcon(new ImageIcon(ruta));				
			}

		});
		
		opTranspuesta.setCursor(cursorManita);
		opTranspuesta.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent mev) {				
				VentanaPrincipal.mostrarPanelOperaciones(5);				
			}

			public void mouseEntered(MouseEvent mev) {
				ruta=PanelOpciones.class.getResource("/ICONOS/icono_transpuesta_efecto.png");
				opTranspuesta.setIcon(new ImageIcon(ruta));				
			}

			public void mouseExited(MouseEvent mev) {
				ruta=PanelOpciones.class.getResource("/ICONOS/icono_transpuesta.png");
				opTranspuesta.setIcon(new ImageIcon(ruta));				
			}

		});
		
		opDeterminante.setCursor(cursorManita);
		opDeterminante.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent mev) {				
				VentanaPrincipal.mostrarPanelOperaciones(6);				
			}

			public void mouseEntered(MouseEvent mev) {
				ruta=PanelOpciones.class.getResource("/ICONOS/icono_determinante_efecto.png");
				opDeterminante.setIcon(new ImageIcon(ruta));				
			}

			public void mouseExited(MouseEvent mev) {
				ruta=PanelOpciones.class.getResource("/ICONOS/icono_determinante.png");
				opDeterminante.setIcon(new ImageIcon(ruta));				
			}

		});
		
	}
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		
		ancho = this.getWidth();
		alto = this.getHeight();		
		
		opSuma.setLocation(ancho/2-395, alto/2-260);
		opResta.setLocation(ancho/2-125, alto/2-260);
		opMultiplicacion.setLocation(ancho/2+145, alto/2-260);
		opMultiplicacionEscalar.setLocation(ancho/2-395, alto/2+10);
		opTranspuesta.setLocation(ancho/2-125, alto/2+10);
		opDeterminante.setLocation(ancho/2+145, alto/2+10);
		btnAbout.setLocation(0, 0);
		
	}


}

package paneles;

/*
 * 	Éste panel muestra una interfaz para que el usuario defina las dimensiones de las matrices( o matriz)
 * con las cuáles operará, en el caso de la multiplicadción muestra una interfaz para definir la dimension
 * de dos matrices
 * 
 * */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import otros_graficos.Apariencia;
import ventanas.VentanaPrincipal;

public class PanelDefinirDimensiones extends JPanel {

	private static final long serialVersionUID = 1L;
	private int ancho, alto;
	private int operacion;
	private JLabel ttlo;
	private JComboBox<String> cmbFilas1, cmbFilas2, cmbColumnas1, cmbColumnas2;
	private JLabel ttloFilas1, ttloFilas2, ttloColumnas1, ttloColumnas2;
	private JLabel mensaje;
	private JLabel btnVolver;
	private JLabel btnListo;
	
	public PanelDefinirDimensiones()
	{
		
		this.operacion = 0;
		setLayout(null);		
		setBackground(new Color(25,25,25));		
		inicializar();		
		btnVolver.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent mev) {
				VentanaPrincipal.mostrarMenuPrincipal();
			}			
		});
		
	}
	
	private void inicializar()
	{
		
		Color gris = new Color(255, 255, 255);
		
		ttlo=new JLabel();
		ttlo.setForeground(new Color(244,67,54));
		ttlo.setFont(new Font("Verdana", 1, 22));
		ttlo.setHorizontalAlignment(JLabel.LEFT);
		ttlo.setBounds(55, 14, 250, 25);
		
		mensaje=new JLabel();
		mensaje.setSize(250, 100);
		mensaje.setHorizontalAlignment(JLabel.CENTER);
		mensaje.setFont(new Font("Arial", 0, 10));
		mensaje.setForeground(gris);
		
		
		Font fuente1 = new Font("Verdana",0,16);
		
		String dimensiones[]={"1","2","3","4"};
		
		cmbFilas1 = new JComboBox<String>(dimensiones);
		Apariencia.aparienciaComboBox(cmbFilas1);
		
		cmbFilas2 = new JComboBox<String>(dimensiones);
		Apariencia.aparienciaComboBox(cmbFilas2);
		
		cmbColumnas1 = new JComboBox<String>(dimensiones);
		Apariencia.aparienciaComboBox(cmbColumnas1);
		
		cmbColumnas2 = new JComboBox<String>(dimensiones);
		Apariencia.aparienciaComboBox(cmbColumnas2);
		
		ttloFilas1=new JLabel("Filas", JLabel.RIGHT);
		ttloFilas1.setForeground(gris);
		ttloFilas1.setSize(90,20);
		ttloFilas1.setFont(fuente1);
		
		ttloFilas2=new JLabel("Filas", JLabel.RIGHT);
		ttloFilas2.setForeground(gris);
		ttloFilas2.setSize(90,20);
		ttloFilas2.setFont(fuente1);
		
		ttloColumnas1=new JLabel("Columnas", JLabel.RIGHT);
		ttloColumnas1.setForeground(gris);
		ttloColumnas1.setSize(140,20);
		ttloColumnas1.setFont(fuente1);
		
		ttloColumnas2=new JLabel("Columnas", JLabel.RIGHT);
		ttloColumnas2.setForeground(gris);
		ttloColumnas2.setSize(140, 20);
		ttloColumnas2.setFont(fuente1);
		
		URL ruta=PanelDefinirDimensiones.class.getResource("/ICONOS/back_icon.png");
		btnVolver=new JLabel(new ImageIcon(ruta));
		btnVolver.setSize(32, 32);
		btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVolver.setLocation(10, 10);
		
		ruta=PanelDefinirDimensiones.class.getResource("/ICONOS/check_icon.png");
		btnListo=new JLabel(new ImageIcon(ruta));
		btnListo.setSize(32, 32);
		btnListo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnListo.addMouseListener(new MouseAdapter(){			
			public void mouseClicked(MouseEvent mev) {		
				ingresoDeDatos();
			}			
		});		
		
	}
	
	private void ingresoDeDatos() 
	{
		int fls1=Integer.parseInt(cmbFilas1.getSelectedItem().toString());    
		int cls1=Integer.parseInt(cmbColumnas1.getSelectedItem().toString());	 
		int fls2=Integer.parseInt(cmbFilas2.getSelectedItem().toString());       
		int cls2=Integer.parseInt(cmbColumnas2.getSelectedItem().toString());	
		if(operacion==3)
		{					
			if(cls1==fls2) 
			{						
				VentanaPrincipal.ingresarDatos(fls1, cls1, fls2, cls2, operacion);					
			}
			else
			{
				JOptionPane.showMessageDialog(PanelDefinirDimensiones.this, "No es posible una multiplicación de matrices\ncon las dimensiones indicadas!", "Mensaje", JOptionPane.PLAIN_MESSAGE, null);
			}
		}else if(operacion==6){
			if(fls1==cls1){
				VentanaPrincipal.ingresarDatos(fls1, cls1, fls2, cls2, operacion);	
			}else{
				JOptionPane.showMessageDialog(PanelDefinirDimensiones.this, "La matriz debe ser cuadrada para obtener su determinante!", "Mensaje", JOptionPane.PLAIN_MESSAGE, null);
			}
		}else
		{					
			VentanaPrincipal.ingresarDatos(fls1, cls1, fls2, cls2, operacion);				
		}
	}
	
	public void mostrarPanel(int operacion) 
	{
		
		this.operacion=operacion;
		this.removeAll();
		
		mensaje.setText("<html><body>* Establezca la dimension de las matrices, en la suma y la resta, las dos matrices a operar deben tener la misma dimension.</body></html>");		
		
		cmbFilas1.setSelectedIndex(2);
		cmbFilas2.setSelectedIndex(2);
		cmbColumnas1.setSelectedIndex(2);
		cmbColumnas2.setSelectedIndex(2);
		
		switch(operacion)
		{
			case 1:
				ttlo.setText("Suma");
				break;
			case 2:
				ttlo.setText("Resta");
				break;
			case 3:
				ttlo.setText("Multiplicacion");
				mensaje.setText("<html><body>* Defina la dimension de las dos matrices, en la multiplicación , las columnas de las primer matriz debe ser igual a las filas de la segunda matriz.</body></html>");
				this.add(ttloFilas2);
				this.add(cmbFilas2);
				this.add(ttloColumnas2);
				this.add(cmbColumnas2);
				break;
			case 4:
				ttlo.setText("Matriz por escalar");
				mensaje.setText("<html><body>* Debe establecer la dimension de la matriz.</body></html>");
				break;
			case 5:
				ttlo.setText("Transpuesta");
				mensaje.setText("<html><body>* Debe establecer la dimension de la matriz.</body></html>");
				break;
			case 6:
				ttlo.setText("Determinante");
				mensaje.setText("<html><body>* Debe establecer la dimension de la matriz.</body></html>");
				break;
		}		

		this.add(ttlo);
		this.add(ttloFilas1);
		this.add(cmbFilas1);
		this.add(ttloColumnas1);
		this.add(cmbColumnas1);
		this.add(mensaje);
		this.add(btnVolver);
		this.add(btnListo);
		
		
	}

	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		
		ancho = this.getWidth();
		alto = this.getHeight();		
		switch(operacion)
		{
			case 1:
			case 5:
			case 6:
			case 2:
				ttloFilas1.setLocation(ancho/2-100, alto/2-55);
				cmbFilas1.setLocation(ancho/2+10, alto/2-55);
				ttloColumnas1.setLocation(ancho/2-150, alto/2-10);
				cmbColumnas1.setLocation(ancho/2+10, alto/2-10);
				mensaje.setBounds(ancho/4-15, alto/2+alto/8, ancho/2+30, alto/10);
				break;
			case 3:
				
				ttloFilas1.setLocation(ancho/2-100, alto/2-75);
				cmbFilas1.setLocation(ancho/2+10, alto/2-75);
				ttloColumnas1.setLocation(ancho/2-150, alto/2-45);
				cmbColumnas1.setLocation(ancho/2+10, alto/2-45);
				
				ttloFilas2.setLocation(ancho/2-100, alto/2+10);
				cmbFilas2.setLocation(ancho/2+10, alto/2+10);
				ttloColumnas2.setLocation(ancho/2-150, alto/2+40);
				cmbColumnas2.setLocation(ancho/2+10, alto/2+40);
				
				mensaje.setBounds(ancho/4-15, alto/2+alto/5, ancho/2+30, alto/8);
				break;
			case 4:
				ttloFilas1.setLocation(ancho/2-100, alto/2-35);
				cmbFilas1.setLocation(ancho/2+10, alto/2-35);
				ttloColumnas1.setLocation(ancho/2-150, alto/2+10);
				cmbColumnas1.setLocation(ancho/2+10, alto/2+10);
				mensaje.setBounds(ancho/4-15, alto/2+alto/8, ancho/2+30, alto/8);
				break;
		}		
		btnListo.setLocation(ancho/2-16, alto-72);		
	}
}

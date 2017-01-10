package paneles;

/*
 * Panel que según las dimensiones de las matrices y la operación que se realizará muestra una interfaz
 * para ingresar los datos de esa o esas matrices, y un a vez ingresados llama a los métodos correspondientes
 * para realizar la operación y mostrar el resultado
 * 
 * */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import clases_principales.Matriz;
import otros_graficos.Apariencia;
import ventanas.VentanaPrincipal;

public class PanelIngresoDatos extends JPanel{
	
	private static final long serialVersionUID = 1L;	
	private int ancho, alto;
	private double escalar;
	private int filas1, filas2, columnas1, columnas2;
	private JPanel grid1, grid2, pnlResultado;
	private int operacion;
	private int tamanioGrid1W, tamanioGrid1H;
	private int tamanioGrid2W, tamanioGrid2H;
	private JLabel btnListo;	
	private JLabel letterR;
	private JLabel number1;
	private JLabel number2;	
	private Matriz matriz1;
	private Matriz matriz2;	
	private Matriz resultado;
	private Dimension tamanioResultado;
	private boolean mostrandoResultado;
	private JLabel ttloEscalar;
	
	private JTextField fieldsGrid1[][]; 
	private JTextField fieldsGrid2[][];
	
	private JTextField cmpEscalar;
	
public PanelIngresoDatos()
{
		
	operacion = 0;
	filas1=0;
	filas2=0;
	columnas1=0;
	columnas2=0;
	inicializar();
		
	setLayout(null);		
	setBackground(new Color(25,25,25));
		
}
	
private void inicializar()
{
		
	matriz1 = new Matriz();
	matriz2 = new Matriz();
	resultado = new Matriz();
	tamanioResultado = new Dimension();
	mostrandoResultado = false;
	
	pnlResultado = new JPanel();
	pnlResultado.setBackground(new Color(41,41,41));
	
	Font fuente1=new Font("Arial", 2, 20);

	URL ruta=PanelIngresoDatos.class.getResource("/ICONOS/number1.png");
	number1 = new JLabel(new ImageIcon(ruta));
	number1.setSize(16,16);
	ruta=PanelIngresoDatos.class.getResource("/ICONOS/number2.png");
	number2 = new JLabel(new ImageIcon(ruta));
	number2.setSize(16, 16);
	
	ruta=PanelIngresoDatos.class.getResource("/ICONOS/letter_R_icon.png");
	letterR = new JLabel(new ImageIcon(ruta));
	letterR.setSize(24, 24);
		
	ttloEscalar = new JLabel("Escalar", JLabel.RIGHT);
	ttloEscalar.setForeground(Color.WHITE);
	ttloEscalar.setSize(100, 30);
	ttloEscalar.setFont(fuente1);
		
	cmpEscalar = new JTextField();
	Apariencia.aparienciaField(cmpEscalar);
	cmpEscalar.setSize(100, 30);
	
	fieldsGrid1 = new JTextField[6][6];
	fieldsGrid2 = new JTextField[6][6];
	
	for(int i=0;i<6;i++){
		for(int j=0;j<6;j++){
			fieldsGrid1[i][j] = new JTextField();
			Apariencia.aparienciaField(fieldsGrid1[i][j]);
			fieldsGrid2[i][j] = new JTextField();
			Apariencia.aparienciaField(fieldsGrid2[i][j]);
		}
	}
		
	grid1=new JPanel();
	grid1.setBackground(new Color(41,41,41));
	grid2=new JPanel();
	grid2.setBackground(new Color(41,41,41));
			
	ruta=PanelIngresoDatos.class.getResource("/ICONOS/check_icon.png");
	btnListo=new JLabel(new ImageIcon(ruta));
	btnListo.setSize(32, 32);
	btnListo.setCursor(new Cursor(Cursor.HAND_CURSOR));
	btnListo.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent mEv) {
			realizarOperacion();
		}
	});
				
}
	
public void mostrarGridIngresoDatos(int filas, int columnas, int operacion)
{
	
	this.removeAll();		
	this.operacion = operacion;		
	this.filas1=filas;
	this.columnas1=columnas;
	this.filas2=filas;
	this.columnas2=columnas;
	resetearFields();	
	crearGridFields();		
	if(operacion==4)
	{
		this.add(cmpEscalar);
		this.add(ttloEscalar);
	}		
	this.add(btnListo);		
	this.add(grid1);
	this.add(number1);		
	if(operacion>=1 && operacion<=3){
		this.add(grid2);
		this.add(number2);
	}		
		
}

public void mostrarGridIngresoDatos(int filas, int columnas, int filas2, int columnas2, int operacion)
{
	
	this.removeAll();		
	this.operacion = operacion;		
	this.filas1=filas;
	this.columnas1=columnas;
	this.filas2=filas2;
	this.columnas2=columnas2;
	resetearFields();	
	crearGridFields();	
	this.add(btnListo);		
	this.add(grid1);
	this.add(number1);		
	this.add(grid2);
	this.add(number2);
	
}
	
private void resetearFields()
{
	
	Apariencia.resetearField(cmpEscalar);
		
	for(int i=0;i<6;i++){
		for(int j=0;j<6;j++){
			Apariencia.resetearField(fieldsGrid1[i][j]);
			Apariencia.resetearField(fieldsGrid2[i][j]);
		}
	}
		
}
	
public void paintComponent(Graphics g)
{
		
	super.paintComponent(g);
		
	ancho = this.getWidth();
	alto = this.getHeight();	
	
	if(mostrandoResultado==false){
		if(operacion!=0)
		{			
			btnListo.setLocation(ancho/2-16, alto-72);			
			switch(operacion)
			{			
			case 1:
			case 2:
			case 3:
				grid1.setLocation(ancho/2-tamanioGrid1W/2, alto/2-tamanioGrid1H-60);
				grid2.setLocation(ancho/2-tamanioGrid2W/2, alto/2+60);
				number1.setLocation(ancho/2-8, alto/2-tamanioGrid1H-100);
				number2.setLocation(ancho/2-8, alto/2+20);
				break;
			case 4:
				grid1.setLocation(ancho/2-tamanioGrid1W/2, alto/2-tamanioGrid1H+50);
				number1.setLocation(ancho/2-8, alto/2-tamanioGrid1H+10);
				ttloEscalar.setLocation(ancho/2-105, alto/2+80);
				cmpEscalar.setLocation(ancho/2+5, alto/2+80);
			case 5:
			case 6:
				grid1.setLocation(ancho/2-tamanioGrid1W/2, alto/2-tamanioGrid1H+20);
				number1.setLocation(ancho/2-8, alto/2-tamanioGrid1H-20);
				break;					
			}			
		}		
	}else
	{
		pnlResultado.setLocation(this.getWidth()/2-(int)tamanioResultado.getWidth()/2, this.getHeight()/2-(int)tamanioResultado.getHeight()/2);
		letterR.setLocation(this.getWidth()/2-(int)tamanioResultado.getWidth()/2, (this.getHeight()/2-(int)tamanioResultado.getHeight()/2)-26);		
	}
}
	
private void crearGridFields()
	{
		
		grid1.removeAll();
		grid2.removeAll();
		
		grid1.setLayout(new GridLayout(filas1,columnas1,1,1));
		grid2.setLayout(new GridLayout(filas1,columnas1,1,1));
		tamanioGrid1W=90*columnas1;
		tamanioGrid1H=50*filas1;
		tamanioGrid2W=90*columnas1;
		tamanioGrid2H=50*filas1;
		
		for(int i=0;i<filas1;i++){
			for(int j=0;j<columnas1;j++){
				grid1.add(fieldsGrid1[i][j]);
				grid2.add(fieldsGrid2[i][j]);
			}
		}
		
		if(operacion==3){
			grid2.removeAll();
			grid2.setLayout(new GridLayout(filas2,columnas2,1,1));
			tamanioGrid2W=90*columnas2;
			tamanioGrid2H=50*filas2;
			for(int i=0;i<filas2;i++){
				for(int j=0;j<columnas2;j++){
					grid2.add(fieldsGrid2[i][j]);
				}
			}
		}
			
		grid1.setSize(tamanioGrid1W, tamanioGrid1H);
		grid2.setSize(tamanioGrid2W, tamanioGrid2H);
		grid1.repaint();
		grid2.repaint();	

}

public void desactivarMostrandoResultado()
{
	mostrandoResultado = false;
}

private void realizarOperacion()
{	
	
	boolean valido1;
	boolean valido2;	
	if(operacion>=1 && operacion<=3)
	{		
		valido1=obtenerValoresGrid1();		
		if(operacion==3)
			valido2=obtenerValoresGrid2();
		else
			valido2=obtenerValoresGrid2();		
		if(valido1 && valido2)
		{
			switch(operacion)
			{
			case 1:
				resultado = Matriz.sumarMatrices(matriz1, matriz2);
				break;
			case 2:
				resultado = Matriz.restarMatrices(matriz1, matriz2);
				break;
			case 3:
				resultado = Matriz.multiplicarMatrices(matriz1, matriz2);
				break;
			default:
				break;
			}	
			tamanioResultado = resultado.obtenerTamanioPanelGrid();
			mostrandoResultado = true;		
			pnlResultado = resultado.obtenerPanelGridmatriz();
			this.removeAll();
			this.add(pnlResultado);
			this.add(letterR);
			VentanaPrincipal.actualizarPanelIngresoDatos();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Hay uno o más datos ilegales!", "Mensaje", JOptionPane.PLAIN_MESSAGE, null);	
		}		
	}
	else
	{				
		valido1 = obtenerValoresGrid1();		
		if(valido1)
		{		
			if(operacion==4)
			{				
				try{
					escalar=Double.parseDouble(cmpEscalar.getText());
					resultado = Matriz.multiplicarMatrizXEscalar(matriz1, escalar);
					tamanioResultado = resultado.obtenerTamanioPanelGrid();
					mostrandoResultado = true;
					pnlResultado = resultado.obtenerPanelGridmatriz();
					this.removeAll();
					this.add(pnlResultado);
					this.add(letterR);
					VentanaPrincipal.actualizarPanelIngresoDatos();
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(this, "El escalar no es válido!");
				}				
			}else{
				switch(operacion){
				case 5:
					resultado = Matriz.transpuestaDeMatriz(matriz1);
					break;
				case 6:
					resultado = Matriz.determinanteDeMatriz(matriz1);
					break;
				default:
					break;
				}
				tamanioResultado = resultado.obtenerTamanioPanelGrid();
				mostrandoResultado = true;
				pnlResultado = resultado.obtenerPanelGridmatriz();
				this.removeAll();
				this.add(pnlResultado);
				this.add(letterR);
				VentanaPrincipal.actualizarPanelIngresoDatos();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Hay uno o más datos ilegales!");
		}		
	}
}

private boolean obtenerValoresGrid1()
{
	
	try{		
		matriz1.setFilasColumnas(filas1, columnas1);
		for(int i=0;i<filas1;i++){
			for(int j=0;j<columnas1;j++){
				matriz1.establecerValor(Double.parseDouble(fieldsGrid1[i][j].getText()), i, j);
			}
		}
		return true;
	}
	catch(NumberFormatException ex)
	{
		return false;
	}
	
}

private boolean obtenerValoresGrid2()
{
	
	try{
		matriz2.setFilasColumnas(filas2, columnas2);
		for(int i=0;i<filas2;i++){
			for(int j=0;j<columnas2;j++){
				matriz2.establecerValor(Double.parseDouble(fieldsGrid2[i][j].getText()), i, j);
			}
		}		
		return true;
	}
	catch(NumberFormatException ex){		
		return false;		
	}
}

}
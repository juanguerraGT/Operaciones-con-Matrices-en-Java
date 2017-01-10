package paneles;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelOperaciones extends JPanel {

	private static final long serialVersionUID = 1L;
	private static PanelDefinirDimensiones pnlDef;
	private static PanelIngresoDatos pnlIngresoDatos;
	
	public PanelOperaciones()
	{
		
		
		setLayout(null);
		

		pnlDef = new PanelDefinirDimensiones();
		pnlIngresoDatos = new PanelIngresoDatos();
		
		add(pnlDef);
		add(pnlIngresoDatos);
		
	}
	
	public void mostrarPaneles(int operacion){
		pnlDef.mostrarPanel(operacion);
		pnlIngresoDatos.removeAll();
		pnlIngresoDatos.desactivarMostrandoResultado();		
	}
	
	public void mostrarGridsIngresoDatos(int filas1, int columnas1, int filas2, int columnas2, int operacion){
		pnlIngresoDatos.desactivarMostrandoResultado();
		if(operacion==3)
			pnlIngresoDatos.mostrarGridIngresoDatos(filas1, columnas1, filas2, columnas2, operacion);	
		else
			pnlIngresoDatos.mostrarGridIngresoDatos(filas1, columnas1, operacion);	
		this.add(pnlIngresoDatos);
		pnlIngresoDatos.updateUI();
	}
	
	public void actualizarPanelIngresoDatos(){
		pnlIngresoDatos.updateUI();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		pnlDef.setBounds(0, 0, this.getWidth()/3, this.getHeight());
		pnlIngresoDatos.setBounds(this.getWidth()/3, 0, this.getWidth()/3*2, this.getHeight());
	}

}

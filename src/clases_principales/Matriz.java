package clases_principales;

/*
 * 	Clase donde se definen las caracteristicas de una matriz y sus operaciones
 * 
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Matriz {
	
	private int filas;
	private int columnas;	
	private JPanel pnlGridMatriz; 
	private double[][] matriz;
	
	public Matriz()
	{
		pnlGridMatriz=new JPanel();
	}

	public void setFilasColumnas(int filas, int columnas)
	{			
		this.filas=filas;
		this.columnas=columnas;
		matriz = new double[filas][columnas];	
		pnlGridMatriz.setLayout(new GridLayout(filas, columnas, 1, 1));		
	}
	
	public int obtenerFilas()
	{
		return filas;
	}
	
	public int obtenerColumnas()
	{
		return columnas;
	}
	
	public double obtenerValor(int fila, int columna)
	{		
		return matriz[fila][columna];		
	}
	
	public void establecerValor(double valor, int f, int c)
	{		
		matriz[f][c]=valor;		
	}
	
	public void agregarValorAPanel(double num)
	{		
		JTextField cmpo=new JTextField(6);
		String numero=num + "";
		if(numero.length()>8)
			cmpo.setFont(new Font("Verdana", 3, 12));
		else
			cmpo.setFont(new Font("Verdana", 3, 18));
		cmpo.setBackground(Color.WHITE);
		cmpo.setHorizontalAlignment(SwingConstants.RIGHT);
		int numInt = (int) num;
		if(numInt==num)
			cmpo.setText("" + numInt);
		else
			cmpo.setText("" + num);
		cmpo.setBorder(new LineBorder(Color.WHITE,3));
		pnlGridMatriz.add(cmpo);			
	}
	
	public Dimension obtenerTamanioPanelGrid()
	{
		return new Dimension(columnas*100, filas*40);
	}
	
	public JPanel obtenerPanelGridmatriz()
	{		
		pnlGridMatriz.setSize(columnas*100, filas*40);
		pnlGridMatriz.setBackground(new Color(41, 41, 41));
		return pnlGridMatriz;		
	}
	
	
	
	public static Matriz sumarMatrices(Matriz matriz1, Matriz matriz2)
	{				
		int fls=matriz1.obtenerFilas();
		int cls=matriz1.obtenerColumnas();
		Matriz resultado=new Matriz();
		resultado.setFilasColumnas(fls, cls);
		double valor1, valor2;
		for(int i=0;i<fls;i++){				
			for(int j=0;j<cls;j++){	
				valor1=matriz1.obtenerValor(i,j);
				valor2=matriz2.obtenerValor(i, j);
				resultado.establecerValor(valor1+valor2, i, j);				
				resultado.agregarValorAPanel(resultado.obtenerValor(i, j));
			}				
							
		}		
		return resultado;		
	}
	
	public static Matriz restarMatrices(Matriz matriz1, Matriz matriz2)
	{		
		int fls=matriz1.obtenerFilas();
		int cls=matriz1.obtenerColumnas();
		Matriz resultado=new Matriz();
		resultado.setFilasColumnas(fls, cls);
		double valor1, valor2;
		for(int i=0;i<fls;i++){				
			for(int j=0;j<cls;j++){	
				valor1=matriz1.obtenerValor(i,j);
				valor2=matriz2.obtenerValor(i, j);
				resultado.establecerValor(valor1+(-1*valor2), i, j);				
				resultado.agregarValorAPanel(resultado.obtenerValor(i, j));
			}										
		}		
		return resultado;
	}
	
	public static Matriz multiplicarMatrices(Matriz matriz1, Matriz matriz2)
	{		
		int fls1=matriz1.obtenerFilas();
		int cls1=matriz1.obtenerColumnas();
		int cls2=matriz2.obtenerColumnas();
		Matriz resultado=new Matriz();
		resultado.setFilasColumnas(fls1, cls2);
		double res=0;				
		for(int i=0;i<fls1;i++){				
			for(int j=0;j<cls2;j++){						
				res=0;						
				 for(int m=0;m<cls1;m++){					
					 res+=(matriz1.obtenerValor(i, m) * matriz2.obtenerValor(m, j));
				 }						 
				resultado.establecerValor(res, i, j);				
				resultado.agregarValorAPanel(resultado.obtenerValor(i, j));
			}							
		}		
		return resultado;		
	}
	
	public static Matriz multiplicarMatrizXEscalar(Matriz matriz, double a)
	{		
		int fls=matriz.obtenerFilas();
		int cls=matriz.obtenerColumnas();
		Matriz resultado=new Matriz();
		resultado.setFilasColumnas(fls, cls);
		double valor;
		for(int i=0;i<fls;i++){
			for(int j=0;j<cls;j++){					
				valor=matriz.obtenerValor(i, j);
				resultado.establecerValor(valor*a, i, j);				
				resultado.agregarValorAPanel(resultado.obtenerValor(i, j));
			}						
		}		
		return resultado;		
	}
	
	
	public static Matriz transpuestaDeMatriz(Matriz matriz)
	{		
		int fls=matriz.obtenerFilas();
		int cls=matriz.obtenerColumnas();
		Matriz transpuesta=new Matriz();
		transpuesta.setFilasColumnas(fls, cls);
		for(int i=0;i<cls;i++){
			for(int j=0;j<fls;j++){			
				transpuesta.establecerValor(matriz.obtenerValor(j, i), i, j);				
				transpuesta.agregarValorAPanel(transpuesta.obtenerValor(i, j));
			}						
		}		
		return transpuesta;		
	}
	
	public static Matriz determinanteDeMatriz(Matriz matriz)
	{		
		double determinante=0;
		Matriz mtzDeterminante=new Matriz();
		mtzDeterminante.setFilasColumnas(1, 1);
		int fls=matriz.obtenerFilas();
		int cls=matriz.obtenerColumnas();
		if(fls==1 && cls==1){
			determinante=matriz.obtenerValor(0, 0);
		}else if(fls==2){
			determinante=(matriz.obtenerValor(0, 0)*matriz.obtenerValor(1, 1))-(matriz.obtenerValor(0, 1)*matriz.obtenerValor(1, 0));
		}		
		else{
			double suma1=0;
			double suma2=0;
			for(int i=0;i<fls;i++){
				double multiplicacion=1;
				int contador=0;
				int f=i;
				int c=0;
				while(contador<fls){
					if(f==fls)
						f=0;
					multiplicacion*=matriz.obtenerValor(f, c);
					f++;
					c++;
					contador++;
				}
				suma1+=multiplicacion;
				multiplicacion=1;
				contador=0;
				f=i;
				c=fls-1;
				while(contador<fls){
					if(f==fls)
						f=0;
					multiplicacion*=matriz.obtenerValor(f, c);
					f++;
					c--;
					contador++;
				}
				suma2+=multiplicacion;
			}
			determinante=suma1+(suma2*-1);
		}
		mtzDeterminante.establecerValor(determinante, 0, 0);
		mtzDeterminante.agregarValorAPanel(mtzDeterminante.obtenerValor(0, 0));
		return mtzDeterminante;
	}

}

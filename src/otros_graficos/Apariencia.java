package otros_graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Apariencia {
	
	public static Color rojo=new Color(244,67,54);
	public static Color verde=new Color(50,192,92);
	public static Color grisOscuro=new Color(41,41,41);
	
	public static void aparienciaField(JTextField field)
	{
		field.setFont(new Font("Arial", 2, 20));
		field.setHorizontalAlignment(SwingConstants.RIGHT);
		field.setBorder(new LineBorder(rojo,3));
		field.addFocusListener(new FocusListener(){

			public void focusGained(FocusEvent fEv) {
				field.setBorder(new LineBorder(verde,3));
			}
			
			public void focusLost(FocusEvent fEv) {
				try{
					Double.parseDouble(field.getText());
					field.setBorder(new LineBorder(Color.WHITE));
					
				}catch(NumberFormatException ex)
				{
					field.setBorder(new LineBorder(rojo,3));
				}
			}
			
		});
	}
	
	public static void resetearField(JTextField field)
	{
		field.setText("");
		field.setBorder(new LineBorder(rojo,3));
	}
	
	public static void aparienciaComboBox(JComboBox<String> cmb)
	{
		cmb.setSelectedIndex(2);
		cmb.setSize(90, 25);
		cmb.setFont(new Font("Verdana",0,16));
	}
	
}

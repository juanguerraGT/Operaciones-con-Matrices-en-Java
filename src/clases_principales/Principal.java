package clases_principales;

import java.awt.Color;

import javax.swing.UIManager;

/*
 * CLASE PRINCIPAL con método main que crea la ventana del programa y la hace visible*/

import ventanas.VentanaPrincipal;

public class Principal {
	
	private static VentanaPrincipal vtn;

	public static void main(String[] args) {
		
		Color grisOscuro = new Color(41,41,41);
		UIManager.put("ComboBox.background", Color.WHITE);
		UIManager.put("ComboBox.selectionBackground", new Color(244,67,54));
		UIManager.put("ComboBox.foreground", grisOscuro);
		UIManager.put("ComboBox.selectionForeground", Color.WHITE);
		UIManager.put("OptionPane.background", Color.WHITE);
		UIManager.put("OptionPane.foreground", Color.WHITE);
		UIManager.put("Button.background", grisOscuro);
		UIManager.put("Button.foreground",  Color.WHITE);
		UIManager.put("Button.focusInputMap", null);
		UIManager.put("Button.defaultButtonFollowsFocus", null);
		UIManager.put("Panel.background", Color.WHITE);
		UIManager.put("Panel.foreground", Color.WHITE);
		
		vtn=new VentanaPrincipal();
		vtn.setVisible(true);

	}

}

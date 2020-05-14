package recursos;

import javax.swing.JOptionPane;

/**
 * Clase con metodos que muestran mensajes de alerta
 * @author Daniel Esteban Rivero
 *
 */
public class Alertas {
	
	/**
	 * Mensaje que muestra al usuario un error en el programa
	 * @param mensaje Mensaje del dialogo de error 
	 * @param titulo titulo del dialogo
	 */
	public static void msjError(String mensaje,String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, 0);
	}
	/**
	 * Mensaje que muestra al usuario una alerta del programa
	 * @param mensaje Mensaje del dialogo de alerta
	 * @param titulo titulo del dialogo
	 */
	public static void msjAlerta(String mensaje,String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, 2);
	}
	/**
	 * Mensaje que muestra al usuario una accion completada en el programa
	 * @param mensaje Mensaje del dialogo
	 * @param titulo titulo del dialogo
	 */
	public static void msjSimple(String mensaje,String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.PLAIN_MESSAGE);
	}
}
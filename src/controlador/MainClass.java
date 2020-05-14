package controlador;

import vista.MenuInicio;

/**
 * Main class start the application
 * @author Rivero Daniel Esteban
 *
 */

public class MainClass {
	/**
	 *  main function default by java<br>
	 *  run the application
	 */
	public static void main(String[] args) {
		
		try {
			
			MenuInicio nuevo = new MenuInicio();
			nuevo.setVisible(true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Ups... Algo salio mal , pasar a modo debug");
		}
	}
}
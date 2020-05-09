package controlador;

import vista.VistaMenuPrincipal;

public class EjecutarMenuPrincipal {

	public static void main(String[] args) {
		try {
			
			VistaMenuPrincipal vistaMenuPrincipal = new VistaMenuPrincipal();
			vistaMenuPrincipal.setVisible(true);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

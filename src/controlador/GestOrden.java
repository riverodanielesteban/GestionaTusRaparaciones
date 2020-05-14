package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Orden;
import vista.UiNewOrden;

public class GestOrden {

	/**
	 * instancia una ventana orden
	 */
	public static void uiOrden() {
		try {
			UiNewOrden uiorden = new UiNewOrden();
			uiorden.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * instancia una orden con los datos de la ventana orden y la guarda en la base
	 * de datos
	 */
	public static void altaOrden() {
		Orden orden = new Orden(
				Integer.parseInt(UiNewOrden.getIdOrden()),
				Integer.parseInt(UiNewOrden.getIdEquipo()),
				Integer.parseInt(UiNewOrden.getIdCliente()),
				UiNewOrden.getFallas(),
				"A revisar",
				UiNewOrden.getFechaIngreso());
		if (GestBaseDatos.guardar("orden", orden.getCampos(), orden.getValores())) {
			recursos.Alertas.msjSimple("Orden guardado exitosamente", "Mensaje");
		} else {
			recursos.Alertas.msjError("No se pudo guardar orden", "Error");
		}
	}

	/**
	 * crea una lista del tipo ArrayList con ordenes segun los parametros
	 * solicitados
	 */
	public static ArrayList<String> obtenerLista(String tabla, String campo, String valor) throws SQLException {
		ResultSet resultset = GestBaseDatos.mostrarCampo(tabla, campo, valor);
		ArrayList<String> listado = new ArrayList<>();
		while (resultset.next()) {
			listado.add(resultset.getString("id_orden"));
		}
		return listado;
	}

	/**
	 * crea una lista de String con equipos y agrega el valor crear nuevo para
	 * mostrarlo en un JComboBox
	 */
	public static String[] listado(String tabla) throws SQLException {
		ArrayList<String> array = new ArrayList<>();
		array.add("crear nuevo...");
		ResultSet resultset = GestBaseDatos.listar(tabla);
		while (resultset.next()) {
			if (tabla.equals("equipo")) {
				array.add(resultset.getString("id_equipo"));
			}
			if (tabla.equals("cliente")) {
				array.add(resultset.getString("id_cliente"));
			}
		}
		String[] listado = new String[array.size()];
		for (int i = 0; i < array.size(); i++) {
			listado[i] = array.get(i);
		}
		return listado;
	}

}

package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Equipo;
import vista.UiNewEquipo;
import vista.UiNewOrden;

public class GestEquipo {
	
	/**
	 * Nueva ventana para cargar equipo
	 */

	public static void uiEquipo() {
		if (UiNewOrden.getIdEquipo().equals("crear nuevo...")) {
			UiNewEquipo uiNewequipo = new UiNewEquipo();
			uiNewequipo.setVisible(true);
			UiNewEquipo.setUi("nuevo");
		}
	}
	
	/**
	 * Guarda equipo en base de datos
	 */
	public static void altaEquipo() {
		Equipo equipo = new Equipo(
				Integer.valueOf(UiNewEquipo.getId()),
				UiNewEquipo.getArticulo(),
				UiNewEquipo.getMarca(),
				UiNewEquipo.getModelo());
		
		if (GestBaseDatos.guardar("equipo", equipo.getCampos(), equipo.getValores())) {
			recursos.Alertas.msjSimple("Equipo guardado exitosamente", "Mensaje");
			UiNewOrden.setIdEquipo(UiNewEquipo.getId());
		} else {
			recursos.Alertas.msjError("No se pudo guardar el equipo", "Error");
		}
	}
	
	/**
	 * Ver equipo 
	 * @throws SQLException 
	 */

	public static void verEquipo() throws SQLException {
		UiNewEquipo ver = new UiNewEquipo();
		ver.setVisible(true);
		UiNewEquipo.setBoton("Editar");
		UiNewEquipo.setUi("ver");
		ResultSet resultado = GestBaseDatos.mostrarCampo("equipo", "id_equipo", UiNewOrden.getIdEquipo());
		while (resultado.next()) {
			ver.setId(resultado.getString("id_equipo"));
			ver.setArticulo(resultado.getString("articulo"));
			ver.setMarca(resultado.getString("marca"));
			ver.setModelo(resultado.getString("modelo"));
		}
	}
	
	public static void editarEquipo() {
		if (GestBaseDatos.editarEquipo
				(UiNewEquipo.getArticulo(),
				UiNewEquipo.getMarca(),
				UiNewEquipo.getModelo(),
				UiNewEquipo.getId())) {
			recursos.Alertas.msjSimple("Equipo modificado exitosamente", "Mensaje");
			UiNewOrden.setIdEquipo(UiNewEquipo.getId());
		} else {
			recursos.Alertas.msjError("No se pudo guardar el equipo", "Error");
		}
		
	}
}

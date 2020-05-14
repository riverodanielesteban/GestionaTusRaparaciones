package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vista.UiGestion;

public class GestListas {

	/**
	 * crea una lista del tipo ArrayList con ordenes segun los parametros
	 * solicitados
	 */
	public static ArrayList<String> listarTodo(String tabla) throws SQLException {
		ResultSet resultset = GestBaseDatos.listar(tabla);
		ArrayList<String> listado = new ArrayList<>();
		while (resultset.next()) {
			listado.add(resultset.getString("id_orden"));
		}
		return listado;
	}

	public static ArrayList<String> listarFiltrado(String tabla, String campo, String valor) throws SQLException {
		ResultSet resultset = GestBaseDatos.mostarFiltrado(tabla, campo, valor);
		ArrayList<String> listado = new ArrayList<>();
		while (resultset.next()) {
			listado.add(resultset.getString("id_orden"));
		}
		return listado;
	}

	/*
	 * llenado
	 */
	public static void llenarCampos(String nOrden) throws SQLException {
		ResultSet orden = GestBaseDatos.mostrarCampo("orden", "id_orden", nOrden);
		while (orden.next()) {
			UiGestion.setIdorden(orden.getString("id_orden"));
			String idequipo = orden.getString("id_equipo");
			ResultSet equipo = GestBaseDatos.mostarFiltrado("equipo", "id_equipo", idequipo);
			while (equipo.next()) {
				UiGestion.setArticulo(equipo.getString("articulo"));
				UiGestion.setMarca(equipo.getString("marca"));
				UiGestion.setModelo(equipo.getString("modelo"));
			}
			String idcliente = orden.getString("id_cliente");
			ResultSet cliente = GestBaseDatos.mostarFiltrado("cliente", "id_cliente", idcliente);
			while (cliente.next()) {
				UiGestion.setNombre(cliente.getString("nombre"));
				UiGestion.setDireccion(cliente.getString("direccion"));
				UiGestion.setTelefono(cliente.getString("telefono"));
				UiGestion.setMail(cliente.getString("email"));
			}
			UiGestion.setEstado(orden.getString("estado"));
			UiGestion.setFallas(orden.getString("fallas"));
			UiGestion.setFechaIngreso(orden.getString("fecha_ingreso"));
		}
	}

}

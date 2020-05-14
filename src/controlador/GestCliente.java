package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cliente;
import vista.UiNewCliente;
import vista.UiNewOrden;

public class GestCliente {

	public static void uiCliente() {
		if (UiNewOrden.getIdCliente().equals("crear nuevo...")) {
			UiNewCliente nuevo = new UiNewCliente();
			nuevo.setVisible(true);
		}
	}
	
	public static void altaCliente() {
		Cliente cliente = new Cliente(
				Integer.valueOf(UiNewCliente.getDni()), 
				UiNewCliente.getNombre(), 
				UiNewCliente.getTelefono(), 
				UiNewCliente.getDireccion(), 
				UiNewCliente.getEmail());
		
		if (GestBaseDatos.guardar("cliente", cliente.getCampos(), cliente.getValores())) {
			recursos.Alertas.msjSimple("Cliente guardado exitosamente", "Mensaje");
			UiNewOrden.setIdCliente(UiNewCliente.getDni());
		} else {
			recursos.Alertas.msjError("No se pudo guardar el cliente", "Error");
		}
		
	}

	public static void verCliente() throws SQLException {
		UiNewCliente ver = new UiNewCliente();
		ver.setVisible(true);
		UiNewCliente.setBoton("Editar");
		UiNewCliente.setUi("ver");
		ResultSet resultado = GestBaseDatos.mostrarCampo("cliente", "id_cliente", UiNewOrden.getIdCliente());
		while (resultado.next()) {
			ver.setDni(resultado.getString("id_cliente"));
			ver.setNombre(resultado.getString("nombre"));
			ver.setDireccion(resultado.getString("direccion"));
			ver.setTelefono(resultado.getString("telefono"));
			ver.setEmail(resultado.getString("telefono"));
		}
	}

}

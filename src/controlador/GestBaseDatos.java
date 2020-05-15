package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import recursos.Alertas;
/**
 * Clase con metodos de todos los diferentes tipos de consultas SQL
 * @author Daniel Esteban Rivero
 *
 */
public class GestBaseDatos {
	
	private static Statement statement;
	private static ResultSet resultset;

	/**
	 * Metodo de conexion a la base de datos
	 * @return estado de la conexion
	 */
	public static Connection Conectar() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/gestion?&serverTimezone=UTC", "root", "");
		} catch (ClassNotFoundException e1) {
			Alertas.msjAlerta(e1.getMessage(), "Error Java - Mysql");
		} catch (SQLException e) {
			Alertas.msjError("No se pudo conectar a la base de datos \nCausa:\n"+e.getMessage(), "Error SQL");
		}
		return conexion;
	}
	
	public static void crear(String database) {
		try {
			Connection conexiontest = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conexiontest = DriverManager.getConnection("jdbc:mysql://localhost/test?&serverTimezone=UTC", "root", "");
				} catch (ClassNotFoundException e1) {
					Alertas.msjAlerta(e1.getMessage(), "Error Java - Mysql");
				} catch (SQLException e) {
					Alertas.msjError("No se pudo conectar a la base de datos \nCausa:\n"+e.getMessage(), "Error SQL");
				}
			statement=conexiontest.createStatement();
			statement.execute("CREATE DATABASE "+database);
		} catch (SQLException e) {
			Alertas.msjError("No se pudo crear la base de datos \nCausa:\n"+e.getMessage(), "Error SQL");
		}
		
	}

	/**
	 * Guarda un registro en la base de datos
	 * @param tabla String con el nombre de la tabla donde sera guardado el registro
	 * @param campos String con una cadena de los campos que se guardaran en la tabla
	 * @param valores String con los valores que se guardaran en la tabla
	 * @return Boolean de control para verificar si los valores se guardaron de forma correcta
	 */
	public static boolean guardar(String tabla, String campos, String valores) {
		try {
			statement = Conectar().createStatement();
			statement.execute("INSERT INTO " + tabla + " (" + campos + ") VALUES (" + valores + ")");
		} catch (SQLException e) {
			Alertas.msjError(e.getMessage(), "Error SQL");
			return false;
		}
		return true;
	}
	/**
	 * Muestra una lista con todos los registros de la tabla sin condicion
	 * @param tabla String con el nombre de la tabla que se desea mostrar 
	 * @return ResulSet con el resultado de la consulta
	 */
	public static ResultSet listar(String tabla) {
		try {
			statement = Conectar().createStatement();
			resultset=statement.executeQuery("SELECT * FROM "+tabla);
		} catch (SQLException e) {
			Alertas.msjError(e.getMessage(), "Error SQL");
		}
		return resultset;
	}
	/**
	 * Muestra una lista con todos los registros de la tabla con una condicion
	 * @param tabla String con el nombre de la tabla que se desea mostrar
	 * @param campo String con el campo desde donde se desea filtrar una condicion
	 * @param valor String con el valor de la condicion con la que se desea filtrar los registros
	 * @return ResulSet con el resultado de la consulta filtrada
	 */
	public static ResultSet mostrarCampo(String tabla,String campo,String valor) {
		try {
			statement = Conectar().createStatement();
			resultset=statement.executeQuery("SELECT * FROM "+tabla+" WHERE "+campo+"='"+valor+"'");
		} catch (SQLException e) {
			
		}
		return resultset;
	}
	
	public static ResultSet mostarFiltrado(String tabla,String campo,String valor) {
		try {
			statement = Conectar().createStatement();
			resultset=statement.executeQuery("SELECT * FROM "+tabla+" WHERE "+campo+" LIKE '"+valor+"%'");
		} catch (SQLException e) {
			
		}
		return resultset;
	}
	
	public static int contarRegistros(String tabla) {
		int i = 0;
		try {
			statement = Conectar().createStatement();
			resultset=statement.executeQuery("SELECT * FROM "+tabla);
			while (resultset.next()) {
				i++;	
			}
		} catch (SQLException e) {
			Alertas.msjError(e.getMessage(), "Error SQL");
		}
		return i;
	}
	
	public static int contarRegistrosSi(String tabla, String campo, String valor) {
		int i = 0;
		try {
			statement = Conectar().createStatement();
			resultset=statement.executeQuery("SELECT * FROM "+tabla+" WHERE "+campo+"='"+valor+"'");
			while (resultset.next()) {
				i++;	
			}
		} catch (SQLException e) {
			Alertas.msjError(e.getMessage(), "Error SQL");
		}
		return i;
	}
	
	public static boolean editarEquipo(String articulo,String marca,String modelo,String id) {
		String sql="UPDATE equipo SET articulo = '"+articulo+"', marca = '"+marca+"', modelo = '"+modelo+"' WHERE equipo.id_equipo = "+id;
		try {
			statement = Conectar().createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			Alertas.msjError(e.getMessage(), "Error SQL");
			return false;
		}
		return true;
	}
	
}
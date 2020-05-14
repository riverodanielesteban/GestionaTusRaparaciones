package modelo;

public class Cliente {
	
	private int id_cliente;
	private String nombre;
	private String telefono;
	private String direccion;
	private String email;
	
	public String getCampos() {
		return "id_cliente,nombre,direccion,telefono,email";
	}
	
	public String getValores() {
		return "'"+getDni()+"','"+getNombre()+"','"+getDireccion()+"','"+getTelefono()+"','"+getEmail()+"'";
	}
	
	public int getDni() {
		return id_cliente;
	}
	public void setDni(int dni) {
		this.id_cliente = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Cliente(int dni, String nombre, String telefono, String direccion, String email) {
		this.id_cliente = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}
	
}
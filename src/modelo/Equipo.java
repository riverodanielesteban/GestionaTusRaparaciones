package modelo;

public class Equipo {

	private int id_equipo; 
	private String articulo; 
	private String marca; 
	private String modelo;
	
	public String getCampos() {
		return "id_equipo,articulo,marca,modelo";
	}
	
	public String getValores() {
		return "'"+getId_equipo()+"','"+getArticulo()+"','"+getMarca()+"','"+getModelo()+"'";
	}
	
	public int getId_equipo() {
		return id_equipo;
	}
	public void setId_equipo(int id_equipo) {
		this.id_equipo = id_equipo;
	}
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Equipo(int id, String articulo, String marca, String modelo) {
		this.id_equipo=id;
		this.articulo = articulo;
		this.marca = marca;
		this.modelo = modelo;
	}	
	
}
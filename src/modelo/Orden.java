package modelo;

public class Orden {
	
	private int id_orden;
	private int id_equipo;
	private int id_cliente;
	private String fecha_egreso;
	private int costo;
	private String fallas; 
	private String estado; 
	private String fecha_ingreso;
	
	public String getCampos() {
		return "id_orden,id_equipo,id_cliente,fecha_ingreso,fallas,estado,costo,fecha_egreso";
	}
	
	public String getValores() {
		return "'"+getId_orden()+"','"+getId_equipo()+"','"+getId_cliente()+"','"+getFecha_ingreso()+"','"+getFallas()+"','"+getEstado()+"','"+getCosto()+"','"+getFecha_egreso()+"'";
	}
	
	public int getId_orden() {
		return id_orden;
	}
	public void setId_orden(int id_orden) {
		this.id_orden = id_orden;
	}
	public int getId_equipo() {
		return id_equipo;
	}
	public void setId_equipo(int id_equipo) {
		this.id_equipo = id_equipo;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getFallas() {
		return fallas;
	}
	public void setFallas(String fallas) {
		this.fallas = fallas;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public String getFecha_egreso() {
		return fecha_egreso;
	}
	public void setFecha_egreso(String fecha_egreso) {
		this.fecha_egreso = fecha_egreso;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public Orden(int id_orden, String fallas, String estado, String fecha_ingreso) {
		this.id_orden = id_orden;
		this.fallas = fallas;
		this.estado = estado;
		this.fecha_ingreso = fecha_ingreso;
	}
	
	public Orden(int id_orden, int id_equipo, int id_cliente, String fallas, String estado, String fecha_ingreso) {
		this.id_orden = id_orden;
		this.id_equipo = id_equipo;
		this.id_cliente = id_cliente;
		this.fallas = fallas;
		this.estado = estado;
		this.fecha_ingreso = fecha_ingreso;
	}
}
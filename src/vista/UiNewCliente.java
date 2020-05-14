package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.GestCliente;
import recursos.Alertas;

public class UiNewCliente extends JFrame{
	
private static final long serialVersionUID = 1L;
	
	private static JTextField dni,nombre,telefono,direccion,email;
	private static JButton cancelar,guardar;
	private static String ui;
	
	public UiNewCliente() {
		setResizable(false);
		setTitle("Nuevo cliente");
		getContentPane().setLayout(null);
		setBounds(50, 50, 368, 292);
		
		Border borde = new TitledBorder(new EtchedBorder(), "Datos del cliente");
		JPanel panel = new JPanel();
		panel.setBorder(borde);
		panel.setBounds(10, 11, 326, 227);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		int y=20;
		int x=120;
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(24, 58, x,y);
		panel.add(lblNombre);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(24, 28, x,y);
		panel.add(lblDni);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(24, 90, x,y);
		panel.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(24, 121, x,y);
		panel.add(lblTelefono);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico");
		lblCorreoElectronico.setBounds(24, 154, x,y);
		panel.add(lblCorreoElectronico);
		
		dni = new JTextField();
		dni.setBounds(165, 29, x,y);
		panel.add(dni);
		
		nombre = new JTextField();
		nombre.setBounds(165, 60, x,y);
		panel.add(nombre);
		
		direccion = new JTextField();
		direccion.setBounds(165, 91, x,y);
		panel.add(direccion);
		
		telefono = new JTextField();
		telefono.setBounds(165, 122, x,y);
		panel.add(telefono);
		
		email = new JTextField();
		email.setBounds(165, 155, x,y);
		panel.add(email);
		
		guardar = new JButton("Guardar");
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (dni.getText().equals("")) {
					Alertas.msjAlerta("Debe ingresar un DNI valido", "Atencion");
				}else if (nombre.getText().equals("")) {
					Alertas.msjAlerta("Debe ingresar un Nombre valido", "Atencion");
				}else if (direccion.getText().equals("")) {
					Alertas.msjAlerta("Debe ingresar una Direccion valida", "Atencion");
				}else if (telefono.getText().equals("")) {
					Alertas.msjAlerta("Debe ingresar un Telefono valido", "Atencion");
				}else {
					GestCliente.altaCliente();
					dispose();
				}
			}
		});
		guardar.setBounds(34, 186,x,25);
		panel.add(guardar);
		
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//yes no option
				dispose();
			}
		});
		cancelar.setBounds(165, 187,x,25);
		panel.add(cancelar);
	}

	/*
	 * Getters
	 */
	public static String getDni() {
		return dni.getText();
	}

	public static String getNombre() {
		return nombre.getText();
	}

	public static String getTelefono() {
		return telefono.getText();
	}

	public static String getDireccion() {
		return direccion.getText();
	}

	public static String getEmail() {
		return email.getText();
	}
	
	/*
	 * Setters
	 */
	public void setDni(String dni) {
		UiNewCliente.dni.setText(dni);
	}
	public void setNombre(String nombre) {
		UiNewCliente.nombre.setText(nombre);
	}
	public void setDireccion(String direccion) {
		UiNewCliente.direccion.setText(direccion);
	}
	public void setTelefono(String telefono) {
		UiNewCliente.telefono.setText(telefono);
	}
	public void setEmail(String email) {
		UiNewCliente.email.setText(email);
	}
	
	/**
	 * Obtiene si es nueva o a modificar
	 * @return
	 */
	public static String getUi() {
		return ui;
	}

	/**
	 * Setea para que va a ser utilizada la ventana
	 * @param ui
	 */
	public static void setUi(String ui) {
		UiNewCliente.ui = ui;
	}
	/**
	 * Setea el texto del boton si es para Guardar o Modificar
	 * @param boton
	 */
	public static void setBoton(String boton) {
		guardar.setText(boton);
		dni.setEditable(false);
	}
}

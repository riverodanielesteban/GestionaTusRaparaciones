package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.GestEquipo;
import controlador.GestOrden;
import recursos.Alertas;
import controlador.GestCliente;

/**
 * clase que crea una ventana para ingresar una nueva orden de reparacion
 * 
 * @author Daniel Esteban Rivero
 */
public class UiNewOrden extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JTextField id_orden,fallas,fechaIngreso;
	private static JComboBox<String> id_cliente, id_equipo;

	/**
	 * contiene los campos y botones para gestionar una orden puede ser nuevo o
	 * modificar una ya creada
	 * 
	 * @throws SQLException
	 */
	public UiNewOrden() throws SQLException {
		setTitle("Nueva orden de reparacion");
		setBounds(25, 25, 385, 280);
		setResizable(false);
		getContentPane().setLayout(null);

		Border borde = new TitledBorder(new EtchedBorder(), "Datos de la orden");
		JPanel panel = new JPanel();
		panel.setBorder(borde);
		panel.setBounds(10, 11, 357, 221);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel LidOrden = new JLabel("ID Orden");
		LidOrden.setBounds(10, 30, 120, 20);
		panel.add(LidOrden);

		JLabel LidEquipo = new JLabel("ID Equipo");
		LidEquipo.setBounds(10, 61, 120, 20);
		panel.add(LidEquipo);

		JLabel LidCliente = new JLabel("ID Cliente (DNI)");
		LidCliente.setBounds(10, 92, 120, 20);
		panel.add(LidCliente);

		JLabel lblFallas = new JLabel("Fallas");
		lblFallas.setBounds(10, 123, 120, 20);
		panel.add(lblFallas);

		JLabel lblFechaDeIngreso = new JLabel("Fecha de ingreso");
		lblFechaDeIngreso.setBounds(10, 154, 120, 20);
		panel.add(lblFechaDeIngreso);

		id_orden = new JTextField();
		id_orden.setEditable(false);
		id_orden.setBounds(151, 30, 120, 20);
		panel.add(id_orden);
		id_orden.setColumns(10);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmm");
		id_orden.setText(format.format(date));

		id_equipo = new JComboBox<String>();
		id_equipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestEquipo.uiEquipo();
			}
		});
		id_equipo.setEditable(false);
		id_equipo.setModel(new DefaultComboBoxModel<String>(GestOrden.listado("equipo")));
		id_equipo.setBounds(151, 61, 120, 20);
		panel.add(id_equipo);
		
		JButton verEquipo = new JButton("Ver");
		verEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (id_equipo.getSelectedItem().toString().equals("crear nuevo...")) {
					Alertas.msjAlerta("Debe seleccionar un equipo para ver detalles", "Atencion");
				} else {
					try {
						GestEquipo.verEquipo();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		verEquipo.setBounds(285, 61, 55, 20);
		panel.add(verEquipo);

		id_cliente = new JComboBox<String>();
		id_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestCliente.uiCliente();
			}
		});
		id_cliente.setModel(new DefaultComboBoxModel<String>(GestOrden.listado("cliente")));
		id_cliente.setBounds(151, 92, 120, 20);
		panel.add(id_cliente);
		
		JButton verCliente = new JButton("Ver");
		verCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (id_cliente.getSelectedItem().toString().equals("crear nuevo...")) {
					Alertas.msjAlerta("Debe seleccionar un equipo para ver detalles", "Atencion");
				} else {
					try {
						GestCliente.verCliente();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		verCliente.setBounds(285, 91, 55, 20);
		panel.add(verCliente);

		fallas = new JTextField();
		fallas.setColumns(10);
		fallas.setBounds(151, 123, 120, 20);
		panel.add(fallas);

		fechaIngreso = new JTextField();
		fechaIngreso.setColumns(10);
		fechaIngreso.setBounds(151, 154, 120, 20);
		fechaIngreso.setEditable(false);
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
		fechaIngreso.setText(format1.format(date));
		panel.add(fechaIngreso);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (id_equipo.getSelectedItem().toString().equals("crear nuevo...")) {
					Alertas.msjAlerta("Debe seleccionar o crear nuevo equipo", "Atencion");
				} else if (id_cliente.getSelectedItem().toString().equals("crear nuevo...")) {
					Alertas.msjAlerta("Debe seleccionar o crear nuevo cliente", "Atencion");
				} else if (fallas.getText().equals("")) {
					Alertas.msjAlerta("Dede detallar las fallas de la orden", "Atencion");
				} else {
				GestOrden.altaOrden();
				dispose();
				}
			}
		});
		btnGuardar.setBounds(77, 185, 120, 20);
		panel.add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// yes no option Joptionpane
				dispose();
			}
		});
		btnCancelar.setBounds(207, 185, 120, 20);
		panel.add(btnCancelar);
		
		
	}

	/*
	 * getters
	 */
	public static String getIdOrden() {
		return id_orden.getText();
	}

	public static String getFallas() {
		return fallas.getText();
	}

	public static String getFechaIngreso() {
		return fechaIngreso.getText();
	}

	public static String getIdCliente() {
		return id_cliente.getSelectedItem().toString();
	}

	public static String getIdEquipo() {
		return id_equipo.getSelectedItem().toString();
	}

	/*
	 * setters
	 */
	public static void setId_orden(String id_orden) {
		UiNewOrden.id_orden.setText(id_orden);
	}

	public static void setFallas(String fallas) {
		UiNewOrden.fallas.setText(fallas);
	}

	public static void setFechaIngreso(String fechaIngreso) {
		UiNewOrden.fechaIngreso.setText(fechaIngreso);
	}

	public static void setIdEquipo(String idequipo) {
		UiNewOrden.id_equipo.addItem(idequipo);
		UiNewOrden.id_equipo.setSelectedItem(idequipo);
	}

	public static void setIdCliente(String idcliente) {
		UiNewOrden.id_cliente.addItem(idcliente);
		UiNewOrden.id_cliente.setSelectedItem(idcliente);
	}
}

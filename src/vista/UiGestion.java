package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class UiGestion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField id_orden,articulo,marca,modelo,nombre,direccion,telefono,email,fallas,fecha_ingreso,costo;
	private static JComboBox<String> estado;

	public UiGestion() throws SQLException {
		setResizable(false);
		setTitle("Lista");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(15, 15, 780, 500);
		getContentPane().setLayout(null);
		
		/*
		 * Panel de la lista de ordenes
		 */
		JPanel panelLista = new JPanel();
		Border bordelista = new TitledBorder(new EtchedBorder(), "Lista de ordenes");
		panelLista.setBorder(bordelista);
		panelLista.setBounds(10, 11, 150, 449);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 128, 417);
		JList<String> ordenes = new JList<String>();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(int i=0; i<controlador.GestListas.listarTodo("orden").size(); i++) {
		    listModel.add(i, controlador.GestListas.listarTodo("orden").get(i));
		}
		ordenes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ordenes.setModel(listModel);
		ordenes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					controlador.GestListas.llenarCampos(ordenes.getSelectedValue().toString());
					ordenes.setEnabled(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		panelLista.setLayout(null);
		scrollPane.setViewportView(ordenes);
		panelLista.add(scrollPane);
		getContentPane().add(panelLista);
		
		/*
		 * Panel de los detalles de la orden seleccionada
		 */
		JPanel panelDatos = new JPanel();
		Border bordedetalle = new TitledBorder(new EtchedBorder(), "Datos de la orden");
		panelDatos.setBorder(bordedetalle);
		panelDatos.setBounds(170, 11, 290, 449);
		getContentPane().add(panelDatos);
		panelDatos.setLayout(null);
		
		JLabel label = new JLabel("ID Orden");
		label.setBounds(12, 25, 120, 20);
		panelDatos.add(label);
		
		JLabel label_1 = new JLabel("Articulo");
		label_1.setBounds(12, 67, 120, 20);
		panelDatos.add(label_1);
		
		JLabel label_2 = new JLabel("Marca");
		label_2.setBounds(12, 97, 120, 20);
		panelDatos.add(label_2);
		
		JLabel label_3 = new JLabel("Modelo");
		label_3.setBounds(12, 127, 120, 20);
		panelDatos.add(label_3);
		
		JLabel label_4 = new JLabel("Nombre");
		label_4.setBounds(12, 175, 120, 20);
		panelDatos.add(label_4);
		
		JLabel label_5 = new JLabel("Direccion");
		label_5.setBounds(12, 205, 120, 20);
		panelDatos.add(label_5);
		
		JLabel label_6 = new JLabel("Telefono");
		label_6.setBounds(12, 235, 120, 20);
		panelDatos.add(label_6);
		
		JLabel label_7 = new JLabel("Correo electronico");
		label_7.setBounds(12, 266, 120, 20);
		panelDatos.add(label_7);
		
		JLabel label_8 = new JLabel("Fallas");
		label_8.setBounds(12, 297, 120, 20);
		panelDatos.add(label_8);
		
		JLabel label_9 = new JLabel("Estado");
		label_9.setBounds(12, 328, 120, 20);
		panelDatos.add(label_9);
		
		JLabel label_10 = new JLabel("Fecha de ingreso");
		label_10.setBounds(12, 359, 120, 20);
		panelDatos.add(label_10);
		
		estado = new JComboBox<String>();
		estado.setEnabled(false);
		estado.setEditable(true);
		estado.setBounds(149, 328, 120, 20);
		panelDatos.add(estado);
		
		id_orden = new JTextField();
		id_orden.setEditable(false);
		id_orden.setBounds(149, 25, 120, 20);
		panelDatos.add(id_orden);
		
		articulo = new JTextField();
		articulo.setEditable(false);
		articulo.setBounds(149, 67, 120, 20);
		panelDatos.add(articulo);
		
		marca = new JTextField();
		marca.setEditable(false);
		marca.setBounds(149, 97, 120, 20);
		panelDatos.add(marca);
		
		modelo = new JTextField();
		modelo.setEditable(false);
		modelo.setBounds(149, 128, 120, 20);
		panelDatos.add(modelo);
		
		nombre = new JTextField();
		nombre.setEditable(false);
		nombre.setBounds(149, 176, 120, 20);
		panelDatos.add(nombre);
		
		direccion = new JTextField();
		direccion.setEditable(false);
		direccion.setBounds(149, 206, 120, 20);
		panelDatos.add(direccion);
		
		telefono = new JTextField();
		telefono.setEditable(false);
		telefono.setBounds(149, 236, 120, 20);
		panelDatos.add(telefono);
		
		email = new JTextField();
		email.setEditable(false);
		email.setBounds(149, 267, 120, 20);
		panelDatos.add(email);
		
		fallas = new JTextField();
		fallas.setEditable(false);
		fallas.setBounds(149, 297, 120, 20);
		panelDatos.add(fallas);
		
		fecha_ingreso = new JTextField();
		fecha_ingreso.setEditable(false);
		fecha_ingreso.setBounds(149, 359, 120, 20);
		panelDatos.add(fecha_ingreso);
		
		JButton button = new JButton("Ver otra orden");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenes.setEnabled(true);
			}
		});
		button.setBounds(149, 399, 120, 23);
		panelDatos.add(button);
		
		JButton button_1 = new JButton("Gestionar orden");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button_1.setBounds(10, 399, 132, 23);
		panelDatos.add(button_1);
		
		/*
		 * Panel de gestion de orden seleccionada
		 */
		
		JPanel panelGestion = new JPanel();
		Border bordegestion = new TitledBorder(new EtchedBorder(), "Gestion de orden");
		panelGestion.setBorder(bordegestion);
		panelGestion.setBounds(470, 11, 290, 449);
		getContentPane().add(panelGestion);
		panelGestion.setLayout(null);
		
		JLabel label_11 = new JLabel("Diagnostico");
		label_11.setBounds(10, 26, 120, 20);
		panelGestion.add(label_11);
		
		JTextPane diagnostico = new JTextPane();
		diagnostico.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, null));
		diagnostico.setBounds(145, 26, 120, 80);
		panelGestion.add(diagnostico);
		
		JLabel label_12 = new JLabel("Requiere repuestos");
		label_12.setBounds(10, 116, 120, 20);
		panelGestion.add(label_12);
		
		JComboBox<String> repuestos = new JComboBox<String>();
		repuestos.setModel(new DefaultComboBoxModel<String>(new String[] {"si", "no"}));
		repuestos.setBounds(145, 116, 120, 20);
		panelGestion.add(repuestos);
		
		JLabel label_13 = new JLabel("Costo");
		label_13.setBounds(10, 147, 120, 20);
		panelGestion.add(label_13);
		
		costo = new JTextField();
		costo.setColumns(10);
		costo.setBounds(145, 146, 120, 20);
		panelGestion.add(costo);
	}
	
	public static void setIdorden(String idorden) {
		UiGestion.id_orden.setText(idorden);
	}

	public static void setArticulo(String articulo) {
		UiGestion.articulo.setText(articulo);
	}

	public static void setMarca(String marca) {
		UiGestion.marca.setText(marca);
	}

	public static void setModelo(String modelo) {
		UiGestion.modelo.setText(modelo);
	}

	public static void setNombre(String nombre) {
		UiGestion.nombre.setText(nombre);
	}

	public static void setDireccion(String direccion) {
		UiGestion.direccion.setText(direccion);
	}

	public static void setTelefono(String telefono) {
		UiGestion.telefono.setText(telefono);
	}

	public static void setMail(String mail) {
		UiGestion.email.setText(mail);
	}

	public static void setFallas(String fallas) {
		UiGestion.fallas.setText(fallas);
	}

	public static void setFechaIngreso(String fechaIngreso) {
		UiGestion.fecha_ingreso.setText(fechaIngreso);
	}
	
	public static void setEstado(String estado) {
		UiGestion.estado.setSelectedItem(estado);
	}
}

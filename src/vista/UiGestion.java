package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UiGestion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField id_orden,articulo,marca,modelo,nombre,direccion,telefono,email,fallas,fecha_ingreso,estado;
	private JTextField resultado_test;
	private JTextField costo;
	
	/**
	 * JFrame de gestion de orden de reparacion
	 * @throws SQLException
	 */
	public UiGestion() throws SQLException {
		setResizable(false);
		setTitle("Lista");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(15, 15, 670, 500);
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
					System.out.println("ordenes vacias");
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
		
		JLabel ldlorden = new JLabel("ID Orden");
		ldlorden.setBounds(12, 25, 120, 20);
		panelDatos.add(ldlorden);
		
		JLabel lblart = new JLabel("Articulo");
		lblart.setBounds(12, 67, 120, 20);
		panelDatos.add(lblart);
		
		JLabel lblmarca = new JLabel("Marca");
		lblmarca.setBounds(12, 97, 120, 20);
		panelDatos.add(lblmarca);
		
		JLabel lblmodelo = new JLabel("Modelo");
		lblmodelo.setBounds(12, 127, 120, 20);
		panelDatos.add(lblmodelo);
		
		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setBounds(12, 175, 120, 20);
		panelDatos.add(lblnombre);
		
		JLabel lbldireccion = new JLabel("Direccion");
		lbldireccion.setBounds(12, 205, 120, 20);
		panelDatos.add(lbldireccion);
		
		JLabel lbltelefono = new JLabel("Telefono");
		lbltelefono.setBounds(12, 235, 120, 20);
		panelDatos.add(lbltelefono);
		
		JLabel lblmail = new JLabel("Correo electronico");
		lblmail.setBounds(12, 266, 120, 20);
		panelDatos.add(lblmail);
		
		JLabel lblestado = new JLabel("Estado");
		lblestado.setBounds(12, 297, 120, 20);
		panelDatos.add(lblestado);
		
		JLabel lblfallas = new JLabel("Fallas");
		lblfallas.setBounds(12, 328, 120, 20);
		panelDatos.add(lblfallas);
		
		JLabel lblfechaingreso = new JLabel("Fecha de ingreso");
		lblfechaingreso.setBounds(12, 359, 120, 20);
		panelDatos.add(lblfechaingreso);
		
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
		fallas.setBounds(149, 328, 120, 20);
		panelDatos.add(fallas);
		
		fecha_ingreso = new JTextField();
		fecha_ingreso.setEditable(false);
		fecha_ingreso.setBounds(149, 359, 120, 20);
		panelDatos.add(fecha_ingreso);
		
		estado = new JTextField();
		estado.setEditable(false);
		estado.setBounds(149, 297, 120, 20);
		panelDatos.add(estado);
		
		JButton verOtraOrden = new JButton("Ver otra orden");
		verOtraOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenes.setEnabled(true);
			}
		});
		verOtraOrden.setBounds(149, 399, 120, 23);
		panelDatos.add(verOtraOrden);
		
		/*
		 * Panel de gestion de orden seleccionada
		 */
		
		JPanel panelGestion = new JPanel();
		Border bordegestion = new TitledBorder(new EtchedBorder(), "Gestion de orden");
		panelGestion.setBorder(bordegestion);
		panelGestion.setBounds(470, 11, 176, 283);
		getContentPane().add(panelGestion);
		panelGestion.setLayout(null);
		
		JLabel lblresultadotest = new JLabel("Resulado de testeo");
		lblresultadotest.setBounds(10, 30, 150, 20);
		panelGestion.add(lblresultadotest);
		
		resultado_test = new JTextField();
		resultado_test.setBounds(10, 48, 150, 20);
		panelGestion.add(resultado_test);
		resultado_test.setColumns(10);
		
		JLabel lbla = new JLabel("Requiere repuestos ?");
		lbla.setBounds(10, 90, 150, 20);
		panelGestion.add(lbla);
		
		JComboBox<String> repuestos = new JComboBox<String>();
		repuestos.setMaximumRowCount(3);
		repuestos.setModel(new DefaultComboBoxModel<String>(new String[] {"no", "si"}));
		repuestos.setSelectedIndex(0);
		repuestos.setBounds(10, 107, 150, 22);
		panelGestion.add(repuestos);
		
		JLabel lblCostoFinal = new JLabel("Costo final");
		lblCostoFinal.setBounds(10, 155, 150, 20);
		panelGestion.add(lblCostoFinal);
		
		costo = new JTextField();
		costo.setColumns(10);
		costo.setBounds(10, 175, 150, 20);
		panelGestion.add(costo);
		
		JButton tarifas = new JButton("Tarifas");
		tarifas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TODO crear ventana con listado de tarifas
			}
		});
		tarifas.setBounds(10, 196, 150, 23);
		panelGestion.add(tarifas);
		
		JButton presupuestar = new JButton("Presupuestar");
		presupuestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TODO agrega datos de revision de equipo y presupuesto
			}
		});
		presupuestar.setBounds(10, 245, 150, 23);
		panelGestion.add(presupuestar);
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
		UiGestion.estado.setText(estado);
	}
}

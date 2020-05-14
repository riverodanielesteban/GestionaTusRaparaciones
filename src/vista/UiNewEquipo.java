package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.GestEquipo;
import recursos.Alertas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UiNewEquipo extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static JTextField id_equipo,articulo,modelo,marca;
	private static JButton cancelar,guardar;
	private static String ui;
	
	public UiNewEquipo() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Nuevo Equipo");
		getContentPane().setLayout(null);
		setBounds(50,50,356,250);
		
		Border borde = new TitledBorder(new EtchedBorder(), "Datos del equipo");
		JPanel panel = new JPanel();
		panel.setBorder(borde);
		panel.setBounds(10, 11, 324, 194);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		int y=20;
		int x=120;
		
		JLabel lblid = new JLabel("ID Equipo");
		lblid.setBounds(24, 28, x,y);
		panel.add(lblid);
		
		JLabel lblArticulo = new JLabel("Articulo");
		lblArticulo.setBounds(24, 58, x,y);
		panel.add(lblArticulo);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(24, 90, x,y);
		panel.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(24, 121, x,y);
		panel.add(lblModelo);
		
		id_equipo = new JTextField();
		id_equipo.setText(String.valueOf(controlador.GestBaseDatos.contarRegistros("equipo")+1));
		id_equipo.setBounds(165, 29, x,y);
		id_equipo.setEditable(false);
		panel.add(id_equipo);
		
		articulo = new JTextField();
		articulo.setBounds(165, 60, x,y);
		panel.add(articulo);
		
		marca = new JTextField();
		marca.setBounds(165, 91, x,y);
		panel.add(marca);
		
		modelo = new JTextField();
		modelo.setBounds(165, 122, x,y);
		panel.add(modelo);
		
		guardar = new JButton();
		guardar.setText("Guardar");
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ui.equals("ver")) {
					if (articulo.getText().equals("")) {
						Alertas.msjAlerta("El campo ARTICULO no puede estar vacio", "Atencion");
					} else if (marca.getText().equals("")) {
						Alertas.msjAlerta("El campo MARCA no puede estar vacio", "Atencion");
					} else if (modelo.getText().equals("")) {
						Alertas.msjAlerta("El campo MODELO no puede estar vacio", "Atencion");
					} else {
					GestEquipo.editarEquipo();
					dispose();
					}
				} else {
					if (articulo.getText().equals("")) {
						Alertas.msjAlerta("El campo ARTICULO no puede estar vacio", "Atencion");
					} else if (marca.getText().equals("")) {
						Alertas.msjAlerta("El campo MARCA no puede estar vacio", "Atencion");
					} else if (modelo.getText().equals("")) {
						Alertas.msjAlerta("El campo MODELO no puede estar vacio", "Atencion");
					} else {
					GestEquipo.altaEquipo();
					dispose();
					}
				}
				
			}
		});
		guardar.setBounds(34, 154,x,25);
		panel.add(guardar);
		
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//yes no option JOptionPane
				dispose();
			}
		});
		cancelar.setBounds(165, 154,x,25);
		panel.add(cancelar);
	}

	/*
	 * Getters
	 */
	public static String getId() {
		return id_equipo.getText();	
	}
	public static String getArticulo() {
		return articulo.getText();	
	}
	public static String getMarca() {
		return marca.getText();	
	}
	public static String getModelo() {
		return modelo.getText();	
	}
	/*
	 * Setters
	 */
	public void setId(String id) {
		id_equipo.setText(id);
		id_equipo.setEditable(false);
	}
	public void setArticulo(String id) {
		articulo.setText(id);
		articulo.setEditable(true);
	}
	public void setMarca(String id) {
		marca.setText(id);
		marca.setEditable(true);
	}
	public void setModelo(String id) {
		modelo.setText(id);
		modelo.setEditable(true);
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
		UiNewEquipo.ui = ui;
	}
	/**
	 * Setea el texto del boton si es para Guardar o Modificar
	 * @param boton
	 */
	public static void setBoton(String boton) {
		guardar.setText(boton);
		id_equipo.setEditable(false);
	}

	
}

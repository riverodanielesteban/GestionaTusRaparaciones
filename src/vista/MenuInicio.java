package vista;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.GestOrden;

public class MenuInicio extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MenuInicio(){
		getContentPane().setBackground(new Color(224, 255, 255));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuInicio.class.getResource("/images/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestiona Tus Reparaciones ");
		getContentPane().setLayout(null);
		
		JPanel panelGesion = new JPanel();
		Border borde = new TitledBorder(new EtchedBorder(), "Gestion de ordenes de reparacion");
		panelGesion.setBorder(borde);
		panelGesion.setBounds(10, 10, 342, 120);
		panelGesion.setLayout(null);
		getContentPane().add(panelGesion);
		
		JButton btn0 = new JButton("");
		btn0.setBounds(10, 19, 100, 90);
		panelGesion.add(btn0);
		btn0.setIcon(new ImageIcon(MenuInicio.class.getResource("/images/nueva.png")));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestOrden.uiOrden();
			}
		});
		btn0.setToolTipText("Agregar nueva orden de reparacion al sistema");
		
		JButton btn1 = new JButton("");
		btn1.setBounds(120, 19, 100, 90);
		panelGesion.add(btn1);
		btn1.setIcon(new ImageIcon(MenuInicio.class.getResource("/images/buscar.png")));
		btn1.setToolTipText("Buscar una orden en la base de datos");
		
		JButton btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UiGestion lista = new UiGestion();
					lista.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn2.setBounds(230, 19, 100, 90);
		panelGesion.add(btn2);
		btn2.setIcon(new ImageIcon(MenuInicio.class.getResource("/images/tareas.png")));
		btn2.setToolTipText("Muestra el listado de ordenes pendientes de gestion");
		
		JPanel panelCliente = new JPanel();
		panelCliente.setLayout(null);
		panelCliente.setBounds(10, 141, 342, 120);
		getContentPane().add(panelCliente);
		
		JButton btn3 = new JButton("nuevo cliente");
		btn3.setToolTipText("Agregar nueva orden de reparacion al sistema");
		btn3.setBounds(10, 19, 100, 90);
		panelCliente.add(btn3);
		
		JButton btn4 = new JButton("lista clientes");
		btn4.setToolTipText("Buscar una orden en la base de datos");
		btn4.setBounds(120, 19, 100, 90);
		panelCliente.add(btn4);
		
		JButton btn5 = new JButton("buscar clientes");
		btn5.setToolTipText("Muestra el listado de ordenes pendientes de gestion");
		btn5.setBounds(230, 19, 100, 90);
		panelCliente.add(btn5);
		
		JPanel panelEquipo = new JPanel();
		panelEquipo.setLayout(null);
		panelEquipo.setBounds(10, 272, 342, 120);
		getContentPane().add(panelEquipo);
		
		JButton btn6 = new JButton("nuevo equipo");
		btn6.setToolTipText("Agregar nueva orden de reparacion al sistema");
		btn6.setBounds(10, 19, 100, 90);
		panelEquipo.add(btn6);
		
		JButton btn7 = new JButton("lista equipos");
		btn7.setToolTipText("Buscar una orden en la base de datos");
		btn7.setBounds(120, 19, 100, 90);
		panelEquipo.add(btn7);
		
		JButton btn8 = new JButton("buscar equipo");
		btn8.setToolTipText("Muestra el listado de ordenes pendientes de gestion");
		btn8.setBounds(230, 19, 100, 90);
		panelEquipo.add(btn8);
		
		JPanel panelTaller = new JPanel();
		panelTaller.setLayout(null);
		panelTaller.setBounds(362, 141, 231, 120);
		getContentPane().add(panelTaller);
		
		JButton btn9 = new JButton("estado taller");
		btn9.setToolTipText("Agregar nueva orden de reparacion al sistema");
		btn9.setBounds(10, 19, 100, 90);
		panelTaller.add(btn9);
		
		JButton btn10 = new JButton("");
		btn10.setToolTipText("Buscar una orden en la base de datos");
		btn10.setBounds(120, 19, 100, 90);
		panelTaller.add(btn10);
		
		JPanel panelCaja = new JPanel();
		panelCaja.setLayout(null);
		panelCaja.setBounds(362, 272, 231, 120);
		getContentPane().add(panelCaja);
		
		JButton btn11 = new JButton("caja");
		btn11.setToolTipText("Agregar nueva orden de reparacion al sistema");
		btn11.setBounds(10, 19, 100, 90);
		panelCaja.add(btn11);
		
		JButton btn12 = new JButton("cuentas");
		btn12.setToolTipText("Buscar una orden en la base de datos");
		btn12.setBounds(120, 19, 100, 90);
		panelCaja.add(btn12);
		setBounds(15, 15, 720, 480);
		
	}
}

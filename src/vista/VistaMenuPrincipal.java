package vista;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaMenuPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textoUno;
	private JLabel labelUno;
	
	public VistaMenuPrincipal(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("TITULO DE LA SUPER APP");
		getContentPane().setLayout(null);
		
		JButton botonUno = new JButton("hacer click");
		botonUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelUno.setText(textoUno.getText());
			}
		});
		botonUno.setBounds(10, 40, 100, 25);
		getContentPane().add(botonUno);
		
		textoUno = new JTextField();
		textoUno.setBounds(10, 10, 100, 25);
		getContentPane().add(textoUno);
		textoUno.setColumns(10);
		
		labelUno = new JLabel();
		labelUno.setBounds(10, 70, 100, 25);
		getContentPane().add(labelUno);
		
	}
}

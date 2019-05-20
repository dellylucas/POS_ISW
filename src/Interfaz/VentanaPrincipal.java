package Interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Modelo.Fachada;
import Modelo.Tienda;

public class VentanaPrincipal extends JFrame implements ActionListener{


	private JMenuBar menuClientes;
	private JMenu empleados;
	private JMenuItem iniciarSesion;
	private JMenu SuperAdministrador;
	private JMenuItem menuItem;

	public VentanaPrincipal(){
		super();

		this.setTitle("ALL RETAILER(Pagina Principal)");
		this.setSize(500, 400);
		this.setContentPane(new JLabel(new ImageIcon(ClassLoader.getSystemResource("Imagenes/SupermercadoVentanaPrincipal.jpg"))));

		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.crearMenu();
	}


	private void crearMenu() {
		menuClientes = new JMenuBar();
		setJMenuBar(menuClientes);

		empleados = new JMenu("Empleados");
		menuClientes.add(empleados);

		iniciarSesion = new JMenuItem("Iniciar Sesion");
		iniciarSesion.setIcon(new ImageIcon((ClassLoader.getSystemResource("Imagenes/LoginEmpleado.jpg"))));
		iniciarSesion.addActionListener(this);
		empleados.add(iniciarSesion);
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==iniciarSesion){
			InicioSesion login = new InicioSesion(this);
			login.setVisible(true);
		}


	}
}

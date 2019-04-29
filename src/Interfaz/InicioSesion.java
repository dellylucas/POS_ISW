package Interfaz;



	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPasswordField;
	import javax.swing.JTextField;

	import ConexionBD.Conexion;
	import ConexionBD.DAO_Consultar;
	import Modelo.Fachada;

	public class InicioSesion extends JFrame implements ActionListener{
		private JLabel usuario;
		private JLabel contraseña;
		private JTextField txtUsuario;
		private JPasswordField txtContraseña;
		private JButton btnIniciarSesion;
		private JButton btnSalir;
		
		public InicioSesion(){
			super();
			setIconImage(Toolkit.getDefaultToolkit().getImage
			(ClassLoader.getSystemResource("Imagenes/Login.jpg")));
			this.setTitle("Login");
			this.setSize(400, 200);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			getContentPane().setLayout(null);		
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.crearEtiquetas();
			this.crearIngresoDeDatos();
			this.crearBotones();
		}
		
		private void crearEtiquetas() {
			this.usuario=new JLabel();
			this.usuario.setText("Usuario");
			this.usuario.setBounds(10, 5, 200, 80);
			getContentPane().add(usuario);
			
			this.contraseña=new JLabel();
			this.contraseña.setText("Contraseña");
			this.contraseña.setBounds(10, 35, 200, 80);
			getContentPane().add(contraseña);
		}

		private void crearIngresoDeDatos() {
			this.txtUsuario=new JTextField();
			this.txtUsuario.setBounds(90, 35, 180, 20);
			getContentPane().add(txtUsuario);
			
			this.txtContraseña=new JPasswordField();
			this.txtContraseña.setBounds(90, 65, 180, 20);
			getContentPane().add(txtContraseña);
		}

		private void crearBotones() {
			this.btnIniciarSesion=new JButton();
			this.btnIniciarSesion.setText("Iniciar Sesion");
			this.btnIniciarSesion.setBounds(60, 110, 120, 20);
			btnIniciarSesion.addActionListener(this);
			getContentPane().add(btnIniciarSesion);
			
			this.btnSalir=new JButton();
			this.btnSalir.setText("Salir");
			this.btnSalir.setBounds(200, 110, 120, 20);
			btnSalir.addActionListener(this);
			getContentPane().add(btnSalir);
		}

		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==btnSalir){
				VentanaPrincipal login = new VentanaPrincipal(Fachada.tienda);
				login.setVisible(true);
				setVisible(false);
				limpiarFormulario();
				return;
			}
			
			//String pass = new String (txtContraseña.getPassword());
			String user = txtUsuario.getText();
			/*DAO_Consultar dao = new DAO_Consultar();
			int rolid=dao.ConsultarLogin(user,pass);*/
			/**
			 * 1	SuperAdmin
			 * 2	Administrador
			 * 3	Empleado			 *
			 */

			if(user.equals("1")){//desabilitado primera entrega
				JOptionPane.showMessageDialog(null, "Usuario y contraseña incorrectos");
				limpiarFormulario();
			}else if(user.equals("2")){
				VentanaAdministrador ventana = new VentanaAdministrador();
				ventana.setVisible(true);
				setVisible(false);
			}else if(user.equals("3")){
				VentanaEmpleado ventana = new VentanaEmpleado();
				ventana.setVisible(true);
				setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "Usuario y contraseña incorrectos");
				limpiarFormulario();
			}
		}

		public void limpiarFormulario() {
			txtUsuario.setText("");
			txtContraseña.setText("");
		}	
	}



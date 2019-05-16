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

    import ConexionBD.Dao_Login;
	import Modelo.Persona;

public class InicioSesion extends JFrame implements ActionListener{
		private JLabel usuario;
		private JLabel contrasena;
		private JTextField txtUsuario;
		private JPasswordField txtContrasena;
		private JButton btnIniciarSesion;
		private JButton btnSalir;
		private VentanaPrincipal ventanaAnterior;
		private Persona persona;

		
		public InicioSesion(VentanaPrincipal ventanaAnt){
			super();
			ventanaAnterior = ventanaAnt;
			ventanaAnterior.setVisible(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Login.jpg")));
			this.setTitle("Inicio de sesion");
			this.setSize(400, 200);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			getContentPane().setLayout(null);		
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.crearInterfaz();
		}
		
		private void crearInterfaz() {
			this.usuario=new JLabel();
			this.usuario.setText("Usuario");
			this.usuario.setBounds(10, 5, 200, 80);
			getContentPane().add(usuario);
			
			this.contrasena=new JLabel();
			this.contrasena.setText("Contrasena");
			this.contrasena.setBounds(10, 35, 200, 80);
			getContentPane().add(contrasena);

			this.txtUsuario=new JTextField();
			this.txtUsuario.setBounds(90, 35, 180, 20);
			getContentPane().add(txtUsuario);

			this.txtContrasena=new JPasswordField();
			this.txtContrasena.setBounds(90, 65, 180, 20);
			getContentPane().add(txtContrasena);

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
				ventanaAnterior.setVisible(true);
				setVisible(false);
				limpiarFormulario();
				return;
			}
			
			String pass = new String (txtContrasena.getPassword());
			String user = txtUsuario.getText();
			
			Dao_Login dao = new Dao_Login();
			persona=dao.Consultar(user,pass);

			//Evalua si el usuario es correcto
			if(persona != null  ){
				//Ventana Super Admin
				if (persona.getRol()== 1 ){

					//TODO hacer ventana Superadmin

				}else {//Ventana Empleado y Admin
					VentanaUsuario ventana = new VentanaUsuario(persona);
					ventana.setVisible(true);
				}
				ventanaAnterior.dispose();
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "Usuario y contrasena incorrectos");
				limpiarFormulario();
			}
		}

		public void limpiarFormulario() {
			txtUsuario.setText("");
			txtContrasena.setText("");
		}	
	}



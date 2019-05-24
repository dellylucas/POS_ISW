package Interfaz;



	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.DefaultComboBoxModel;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;

	import Modelo.Fachada;
	import Modelo.Persona;
	import Modelo.Producto;
	import Modelo.Tienda;

	public class ConsultarTienda extends JFrame implements ActionListener{
		
		private JButton btnVolver;
		private JLabel idTienda;
		private JLabel nombreTienda;
		private JLabel telefonoTienda;
		private JLabel direccionTienda;
		private JLabel ciudadTienda;


		private JTextField txtidTienda;
		private JTextField txtnombreTienda;
		private JTextField txttelefonoTienda;
		private JTextField txtdireccionTienda;
		private JTextField txtciudadTienda;
		private JComboBox listaTienda;
		private JTextField txtPrecioVenta;
		private JTextField txtFechaVencimiento;
//		private Tienda tienda= new Tienda();
	    private Tienda tienda = Fachada.getTienda();
		private Persona persona;

		public ConsultarTienda(Persona persona){
			super();
			this.setTitle("Consultar Tienda");
			this.setSize(460, 350);
			this.setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.crearEtiquetas();
			this.crearIngresoDatos();
			this.crearBotones();
			this.persona=persona;
		}
		
		private void crearEtiquetas() {
			this.idTienda=new JLabel();
			this.idTienda.setText("ID");
			this.idTienda.setBounds(10, 43, 70, 35);
			getContentPane().add(idTienda);
			
			this.nombreTienda=new JLabel();
			this.nombreTienda.setText("Nombre");
			this.nombreTienda.setBounds(10, 73, 70, 35);
			getContentPane().add(nombreTienda);
			
			this.telefonoTienda=new JLabel();
			this.telefonoTienda.setText("Telefono");
			this.telefonoTienda.setBounds(10, 130, 77, 40);
			getContentPane().add(telefonoTienda);
			
			this.direccionTienda=new JLabel();
			this.direccionTienda.setText("Direccion");
			this.direccionTienda.setBounds(10, 105, 70, 30);
			getContentPane().add(direccionTienda);
			
			this.ciudadTienda=new JLabel();
			this.ciudadTienda.setText("Ciudad");
			this.ciudadTienda.setBounds(10, 163, 77, 35);
			getContentPane().add(ciudadTienda);
			

		}
		
		private void crearIngresoDatos() {
			this.txtidTienda=new JTextField();
			this.txtidTienda.setEditable(false);
			this.txtidTienda.setBounds(90, 50, 180, 20);
			getContentPane().add(txtidTienda);
			
			this.txtnombreTienda=new JTextField();
			this.txtnombreTienda.setEditable(false);
			this.txtnombreTienda.setBounds(90, 80, 180, 20);
			getContentPane().add(txtnombreTienda);
			
			this.txttelefonoTienda=new JTextField();
			this.txttelefonoTienda.setEditable(false);
			this.txttelefonoTienda.setBounds(90, 110, 180, 20);
			getContentPane().add(txttelefonoTienda);
			
			this.txtdireccionTienda=new JTextField();
			this.txtdireccionTienda.setEditable(false);
			this.txtdireccionTienda.setBounds(90, 140, 180, 20);
			getContentPane().add(txtdireccionTienda);
			
			this.txtciudadTienda=new JTextField();
			this.txtciudadTienda.setEditable(false);
			this.txtciudadTienda.setBounds(90, 170, 180, 20);
			getContentPane().add(txtciudadTienda);
		}
		private void crearBotones() {
			this.btnVolver=new JButton();
			this.btnVolver.setText("Volver");
			this.btnVolver.setBounds(167, 272, 120, 20);
			btnVolver.addActionListener(this);
			getContentPane().add(btnVolver);
			

			this.listaTienda = new JComboBox();
			this.listaTienda.setBounds(10, 20, 149, 20);
			this.listaTienda.addActionListener(this);
			getContentPane().add(listaTienda);
			this.leerTienda();
			

			
			this.llenarTienda();
		}

		public void actionPerformed(ActionEvent e) {	
			if(e.getSource()==btnVolver){
					VentanaSuperAd ventana = new VentanaSuperAd(persona);
					ventana.setVisible(true);
					dispose();
			}
			
			if(e.getSource()==listaTienda){
				llenarTienda();
			}

		}
		
		private void leerTienda() {
			DefaultComboBoxModel mlista = new DefaultComboBoxModel();

			for (int i = 0; i < tienda.getLstTienda().size(); i++) {
				mlista.addElement(tienda.getLstTienda().get(i).getId());
			}
			listaTienda.setModel(mlista);
		}

		private void llenarTienda() {
			Integer id = (Integer) listaTienda.getSelectedItem();
			tienda = tienda.buscarTienda(tienda, id);
			txtnombreTienda.setText(tienda.getNombre());
			txttelefonoTienda.setText(tienda.getTelefono());
			txtdireccionTienda.setText(tienda.getDireccion());
			txtciudadTienda.setText(tienda.getCiudad());
		

		}
	}




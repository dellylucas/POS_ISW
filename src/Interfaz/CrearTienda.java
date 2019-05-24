package Interfaz;


	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;

	import ConexionBD.Dao_Producto;
import ConexionBD.Dao_Tienda;
import Modelo.Fachada;
	import Modelo.Persona;
	import Modelo.Producto;
	import Modelo.Tienda;

	public class CrearTienda extends JFrame implements ActionListener {
	    private JLabel idTienda;
	    private JLabel nombreTienda;
	    private JLabel ciudadTienda;
	    private JLabel direccionTienda;
	    private JLabel telefonoTienda;

	    private JTextField txtidTienda;
	    private JTextField txtnombreTienda;
	    private JTextField txtciudadTienda;
	    private JTextField txtdireccionTienda;
	    private JTextField txttelefonoTienda;
	    private  Persona persona;

	    private JButton btnCrearTienda;
	    private JButton btnVolver;
	

	    private Dao_Tienda daoTienda;
	    private Tienda tienda;


	    public CrearTienda(Persona persona) {
	        super();
            this.persona =persona;
	        tienda = Fachada.getTienda();
	        daoTienda = new Dao_Tienda();
	        this.setTitle("Crear Tienda");
	        this.setSize(400, 350);
	        this.setLocationRelativeTo(null);
	        getContentPane().setLayout(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.crearVista();
	    }

	    private void crearVista() {


	        this.nombreTienda = new JLabel();
	        this.nombreTienda.setText("Nombre");
	        this.nombreTienda.setBounds(10, 61, 79, 29);
	        getContentPane().add(nombreTienda);

	        this.telefonoTienda = new JLabel();
	        this.telefonoTienda.setText("Telefono");
	        this.telefonoTienda.setBounds(10, 91, 79, 29);
	        getContentPane().add(telefonoTienda);

	        this.direccionTienda = new JLabel();
	        this.direccionTienda.setText("Direccion");
	        this.direccionTienda.setBounds(10, 157, 79, 29);
	        getContentPane().add(direccionTienda);

	        
	        this.ciudadTienda = new JLabel();
	        this.ciudadTienda.setText("Ciudad");
	        this.ciudadTienda.setBounds(10, 121, 79, 29);
	        getContentPane().add(ciudadTienda);
	        


	        this.txtnombreTienda = new JTextField();
	        this.txtnombreTienda.setBounds(90, 65, 180, 20);
	        getContentPane().add(txtnombreTienda);

	        this.txttelefonoTienda = new JTextField();
	        this.txttelefonoTienda.setBounds(90, 95, 180, 20);
	        getContentPane().add(txttelefonoTienda);

	        this.txtdireccionTienda = new JTextField();
	        this.txtdireccionTienda.setBounds(90, 125, 180, 20);
	        getContentPane().add(txtdireccionTienda);

	        txtciudadTienda = new JTextField();
	        txtciudadTienda.setBounds(90, 161, 180, 20);
	        getContentPane().add(txtciudadTienda);
	        
	        this.btnCrearTienda = new JButton();
	        this.btnCrearTienda.setText("Crear");
	        this.btnCrearTienda.setBounds(40, 280, 120, 20);
	        btnCrearTienda.addActionListener(this);
	        getContentPane().add(btnCrearTienda);



	        this.btnVolver = new JButton();
	        this.btnVolver.setText("Volver");
	        this.btnVolver.setBounds(242, 280, 120, 20);
	        btnVolver.addActionListener(this);
	        getContentPane().add(btnVolver);
	    }


	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == btnCrearTienda) {
	            if ( txtnombreTienda.getText().equals("")
	                    || txttelefonoTienda.getText().equals("") || txtdireccionTienda.getText().equals("")
	                    || txtciudadTienda.getText().equals("") ){
	                JOptionPane.showMessageDialog(null, "Completa el formulario");
	            } else {
	                tienda = new Tienda();
	               
	                tienda.setNombre(txtnombreTienda.getText());
	                tienda.setTelefono(txttelefonoTienda.getText());
	                tienda.setDireccion(txtdireccionTienda.getText());
	                tienda.setCiudad(txtciudadTienda.getText());
	                

	                daoTienda.Crear(tienda,tienda.getId());

	                JOptionPane.showMessageDialog(null, "Tienda Creado Exitosamente");

	                limpiarFormulario();
	            }
	        }

	        if (e.getSource() == btnVolver) {
				VentanaSuperAd ventana = new VentanaSuperAd(persona);
				ventana.setVisible(true);
				dispose();
	        }
	    }

	    private void limpiarFormulario() {
	    
	        txtnombreTienda.setText("");
	        txttelefonoTienda.setText("");
	        txtdireccionTienda.setText("");
	        txtciudadTienda.setText("");

	    }
	}



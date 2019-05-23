package Interfaz;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import ConexionBD.Dao_Empleado;
import ConexionBD.Dao_Producto;
import ConexionBD.Dao_Proveedor;
import Modelo.*;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class VentanaAgregarCompra extends JFrame implements ActionListener {
    private JMenuBar menu;
    private JMenu salir;
    private JMenuItem salirInt;

    private Dao_Producto daoProduct;
    private Dao_Empleado daoEmpleado;
    private Dao_Proveedor daoProveedor;

    private JMenuItem cerrarSesion;
    private Persona usuario;
    private Tienda tienda;
  
    private JPanel panel;
    private JTextField txtCantidad;
    private JLabel lblNewLabel;
    private JButton btnAgrega;
    private JLabel lblNewLabel_1;
    private JLabel lblMostraTotal;
    private JTable table;
    private JLabel lblNewLabel_3;
    private JTextField txtBusqueda;
    private Dao_Producto daoProducto;
    private DefaultTableModel modelo;
    private ArrayList<Producto> lista;
    private ArrayList<Proveedor> listaProvee;
    private String idselect;
    private String  idselectPrecio;
    private String  idselectcantidadactual;
    private int total;
    private  Producto getP; 
    
    public VentanaAgregarCompra(Persona persona) {
        super();
        total=0;
        idselect="";
        idselectPrecio="";
        getP= new Producto();
        daoProducto = new Dao_Producto();
        usuario = persona;
        tienda = Fachada.getInstance(usuario);
        
        tienda.setLstProductos(daoProducto.ConsultaTodos(tienda.getId()));
        lista = tienda.getLstProductos();
        listaProvee = tienda.getLstProveedor();
        
        this.setTitle(usuario.getNombre() + "(" + usuario.toString() + ") - Agrear Producto " );
        this.setSize(750, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.crearMenu();
           
    }

    private void crearMenu() {
             
            // Column Names 
            String[] columnNames = { "Id", "Nombre", "U/Disponibles", "Precio" , "proveedor"}; 
        menu = new JMenuBar();
        setJMenuBar(menu);

        salir = new JMenu("Opciones");
        salir.addActionListener(this);
        menu.add(salir);
        
        salirInt = new JMenuItem("Atras");
        salirInt.addActionListener(this);
        salir.add(salirInt);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        lblNewLabel_3 = new JLabel("Busqueda");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.gridwidth = 3;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 2;
        gbc_lblNewLabel_3.gridy = 0;
        getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        txtBusqueda = new JTextField();
        txtBusqueda.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent arg0) {
        		Object O[]=null;
        		
        		 modelo.setRowCount(0);
        		for (int i = 0; i < lista.size(); i++) {

        			getP = (Producto) lista.get(i);
        			if (getP.getNombre().toLowerCase().contains(txtBusqueda.getText().toLowerCase()) || txtBusqueda.getText().equals("")) {
        				O=new Object[] {getP.getId(),
            					getP.getNombre(),
            					getP.getCantidad(),
            					getP.getPrecioVenta(),
            					tienda.getProveedorName(getP.getProveedorId())
            					};
            			
            			 modelo.addRow (O);
            			 }
					} 
        			
        		
        	}
        	@Override
        	public void keyReleased(KeyEvent e) {
        		Object O[]=null;
        		
       		 modelo.setRowCount(0);
       		for (int i = 0; i < lista.size(); i++) {

       			getP = (Producto) lista.get(i);
       			if (getP.getNombre().toLowerCase().contains(txtBusqueda.getText().toLowerCase()) || txtBusqueda.getText().equals("")) {
       				O=new Object[] {getP.getId(),
           					getP.getNombre(),
           					getP.getCantidad(),
           					getP.getPrecioVenta(),
           					tienda.getProveedorName(getP.getProveedorId())
           					};
           			
           			 modelo.addRow (O);
           			 }
					} 
       			
        	}
        });
        GridBagConstraints gbc_txtBusqueda = new GridBagConstraints();
        gbc_txtBusqueda.gridwidth = 12;
        gbc_txtBusqueda.insets = new Insets(0, 0, 5, 5);
        gbc_txtBusqueda.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtBusqueda.gridx = 5;
        gbc_txtBusqueda.gridy = 0;
        getContentPane().add(txtBusqueda, gbc_txtBusqueda);
        txtBusqueda.setColumns(10);
        
        modelo = new DefaultTableModel(0, columnNames.length) ;
        modelo.setColumnIdentifiers(columnNames);
        obtenerProductos();
        table = new JTable (modelo);
        table.setBorder(new LineBorder(Color.gray));
        table.setBounds(30, 40, 200, 300); 
        GridBagConstraints gbc_table = new GridBagConstraints();
        gbc_table.gridwidth = 20;
        gbc_table.gridheight = 9;
        gbc_table.insets = new Insets(0, 0, 0, 5);
        gbc_table.fill = GridBagConstraints.BOTH;
        gbc_table.gridx = 1;
        gbc_table.gridy = 1;
        
        JScrollPane sp = new JScrollPane(table); 
        table.addMouseListener(new MouseAdapter() {
        	


			@Override
			public void mousePressed(MouseEvent e) {
			
			JTable source = (JTable)e.getSource();
		            int row = source.rowAtPoint(e.getPoint() );
		            idselect=source.getModel().getValueAt(row, 0)+"";
		            idselectPrecio=source.getModel().getValueAt(row, 3)+"";
		            idselectcantidadactual=source.getModel().getValueAt(row, 2)+"";
		            
		            if (idselectPrecio.equals("") || txtCantidad.getText().equals("") ) {
		        		  JOptionPane.showMessageDialog(null, "Selecciona un item y una cantidad");
					} else {						
						total=(Integer.parseInt(idselectPrecio)*Integer.parseInt(txtCantidad.getText()));
					}
		            lblMostraTotal.setText(String.valueOf(total));
			}
        });
        getContentPane().add(sp);        
        getContentPane().add(sp, gbc_table);
        
        lblNewLabel = new JLabel("Cantidad");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 22;
        gbc_lblNewLabel.gridy = 1;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);
        
        txtCantidad = new JTextField();
        GridBagConstraints gbc_txtCantidad = new GridBagConstraints();
        gbc_txtCantidad.insets = new Insets(0, 0, 5, 0);
        gbc_txtCantidad.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCantidad.gridx = 22;
        gbc_txtCantidad.gridy = 2;
        getContentPane().add(txtCantidad, gbc_txtCantidad);
        txtCantidad.setColumns(10);
        
        lblNewLabel_1 = new JLabel("Sub-total");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_1.gridx = 22;
        gbc_lblNewLabel_1.gridy = 4;
        getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        lblMostraTotal = new JLabel("0");
        GridBagConstraints gbc_lblMostraTotal = new GridBagConstraints();
        gbc_lblMostraTotal.insets = new Insets(0, 0, 5, 0);
        gbc_lblMostraTotal.gridx = 22;
        gbc_lblMostraTotal.gridy = 5;
        getContentPane().add(lblMostraTotal, gbc_lblMostraTotal);
        
        btnAgrega = new JButton("Agregar");
        GridBagConstraints gbc_btnAgrega = new GridBagConstraints();
        gbc_btnAgrega.gridx = 22;
        gbc_btnAgrega.gridy = 9;
        btnAgrega.addActionListener(this);
        getContentPane().add(btnAgrega, gbc_btnAgrega);

    }
	public void obtenerProductos() {
		Object O[]=null;
		for (int i = 0; i < lista.size(); i++) {

			getP = (Producto) lista.get(i);
			if(!getP.getCantidad().equals("0")) {
				O=new Object[] {getP.getId(),
						getP.getNombre(),
						getP.getCantidad(),
						getP.getPrecioVenta(),
						tienda.getProveedorName(getP.getProveedorId())
						};
				 modelo.addRow (O);				
			}
			
			 }
	}

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() ==  salirInt) {
        	VentanaCompras ventana = new VentanaCompras(usuario);
        	ventana.setVisible(true);
            dispose();
        }
        if (e.getSource() ==  btnAgrega ) {
        	if (idselect.equals("") || txtCantidad.getText().equals("") || txtCantidad.getText().equals("0")  )  {
        		  JOptionPane.showMessageDialog(null, "Selecciona un item y una cantidad valida");
			} else {
				
				for (int i = 0; i < lista.size(); i++) {

					 getP = (Producto) lista.get(i);
						if (getP.getId().equals(idselect)) {
							break;
						}
					 }
				total=(Integer.parseInt(getP.getPrecioVenta())*Integer.parseInt(txtCantidad.getText()));
				int cantiTotal=Integer.parseInt(idselectcantidadactual) - Integer.parseInt(txtCantidad.getText()); 
				if(cantiTotal >= 0) {
				tienda.AddOneProduct(new Compra(getP, Integer.parseInt(txtCantidad.getText()), total, tienda.getId()),cantiTotal);
				VentanaCompras ventana = new VentanaCompras(usuario);
	        	ventana.setVisible(true);
	            dispose();
	            }else {
	            	JOptionPane.showMessageDialog(null, "La cantidad debe ser menor o igual a la de inventaio");
	            }
			}
        }
    }
}
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
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


public class VentanaCompras extends JFrame implements ActionListener {
    private JMenuBar menu;
    private JMenu caja;
    private JMenu salir;
    private JMenuItem salirInt;
    private JMenuItem Compras;

    private Dao_Producto daoProduct;
    private Dao_Empleado daoEmpleado;
    private Dao_Proveedor daoProveedor;

    private JMenuItem cerrarSesion;
    private JLabel label;
    private Persona usuario;
    private Tienda tienda;
    private DefaultTableModel modelo;
  
    private JTable j = new JTable();
    private JMenuItem mntmQuitar;
    private JPanel panel;
    private JLabel lbTotal;
    private JLabel lblNewLabel_1;
    private  ArrayList<Compra> lista;
    private Factura factura;

    public VentanaCompras(Persona persona) {
        super();
        switch (persona.getRol()) {
        case 2:
            usuario = new Administrador(persona);
            break;
        case 3:
            usuario = new Empleado(persona);
            break;
    }
        //Singleton Una tienda
        factura = new Factura();
        tienda = Fachada.getInstance(usuario);
       lista = tienda.getLstCompra();
       panel = new JPanel();
       getContentPane().add(panel, BorderLayout.NORTH);
       panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
       
       lblNewLabel_1 = new JLabel("Total");
       lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
       panel.add(lblNewLabel_1);
       
       lbTotal = new JLabel("0");
       lbTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
       panel.add(lbTotal);
       
        this.setTitle(usuario.getNombre() + "(" + usuario.toString() + ") - SuperMercado " + tienda.getNombre());
        this.setSize(750, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.crearMenu();
        String[] columnNames = { "Id", "Nombre", "Unidades", "Precio" , "total"}; 
        modelo = new DefaultTableModel(0, columnNames.length) ;
        modelo.setColumnIdentifiers(columnNames);
        obtenerProductos();
        
        j = new JTable (modelo);
        j.setBorder(new LineBorder(Color.gray));
        j.setBounds(30, 40, 200, 300); 
          
            // adding it to JScrollPane 
            JScrollPane sp = new JScrollPane(j); 
            getContentPane().add(sp);
            

      
    }

    private void crearMenu() {
        menu = new JMenuBar();
        setJMenuBar(menu);

        caja = new JMenu("Carro");
        menu.add(caja);

        salir = new JMenu("Opciones");
        salir.addActionListener(this);
        menu.add(salir);
        
        salirInt = new JMenuItem("Salir");
        salirInt.addActionListener(this);
        salir.add(salirInt);
        
        Compras = new JMenuItem("agregar");
        Compras.addActionListener(this);
        caja.add(Compras);
        
        mntmQuitar = new JMenuItem("quitar");
        caja.add(mntmQuitar);

    }

    public void obtenerProductos() {
		Object O[]=null;
		factura.setTotalCompra(0);
		for (int i = 0; i < lista.size(); i++) {

			Compra getP = (Compra) lista.get(i);
			O=new Object[] {getP.getProducto().getId(),
					getP.getProducto().getNombre(),
					getP.getCantidad(),
					getP.getProducto().getPrecioVenta(),
					getP.getValorTotal()
					};
			int tes = factura.getTotalCompra()+ Integer.parseInt(getP.getValorTotal());
			factura.setTotalCompra(tes);
			 modelo.addRow (O);
			
			 }
		 lbTotal.setText(String.valueOf(factura.getTotalCompra() ));
	}
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == salir || e.getSource() ==  salirInt) {
            VentanaUsuario ventana = new VentanaUsuario(usuario);
            ventana.setVisible(true);
            dispose();
        }
        //agregar compra
        if (e.getSource() == Compras ) {
        	VentanaAgregarCompra agregar = new VentanaAgregarCompra(usuario);
        	agregar.setVisible(true);
        	dispose();
        }
        
    }
    public Persona getPerona() {
    	return this.usuario;
    	
    }
}
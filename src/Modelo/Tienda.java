package Modelo;

import java.util.ArrayList;

import ConexionBD.Dao_Producto;

public class Tienda {
    private int id;
    private String nombre;
    private String ciudad;
    private String direccion;
    private String telefono;
    private ArrayList<Producto> lstProductos = new ArrayList<Producto>();
    private ArrayList<Empleado> lstSEmpleados = new ArrayList<Empleado>();
    private ArrayList<Proveedor> lstProveedor = new ArrayList<Proveedor>();
    private ArrayList<Compra> lstCompra = new ArrayList<Compra>();
    private Dao_Producto producto;
    	private ArrayList<Tienda> lstTienda = new ArrayList<Tienda>();
   
    public ArrayList<Tienda> getLstTienda() {
		return lstTienda;
	}

	public void setLstTienda(ArrayList<Tienda> lstTienda) {
		this.lstTienda = lstTienda;
	}

    

    public ArrayList<Compra> getLstCompra() {
		return lstCompra;
	}

	public void setLstCompra(ArrayList<Compra> lstCompra) {
		this.lstCompra = lstCompra;
	}
	public void AddOneProduct(Compra compra, int cantidad) {
		this.lstCompra.add(compra);
		producto = new Dao_Producto();
		producto.ModificarCantidad(compra.getProducto().getId(), cantidad,compra.getTiendaId());
		
	}
	public Tienda(int id, String nombre, String ciudad, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tienda() {

    }
    
    public Tienda buscarTienda(Tienda tienda, int id) {
        for (int i = 0; i < getLstTienda().size(); i++) {
            if (getLstTienda().get(i).getId()==(id)) {
                tienda = (Tienda) getLstTienda().get(i);
            }
        }
        return tienda;
    }

    public Producto buscarProducto(Producto producto, String id) {
        for (int i = 0; i < getLstProductos().size(); i++) {
            if (getLstProductos().get(i).getId().equals(id)) {
                producto = (Producto) getLstProductos().get(i);
            }
        }
        return producto;
    }

    public Proveedor buscarProveedor(Proveedor proveedor, String id) {
        for (int i = 0; i < getLstProveedor().size(); i++) {
            if (getLstProveedor().get(i).getId().equals(id)) {
                proveedor = (Proveedor) getLstProveedor().get(i);
            }
        }
        return proveedor;
    }


    public Empleado buscarEmpleado(Empleado empleado, String id) {
        for (int i = 0; i < getLstSEmpleados().size(); i++) {
            if (getLstSEmpleados().get(i).getId().equals(id)) {
                empleado = (Empleado) getLstSEmpleados().get(i);
            }
        }
        return empleado;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(ArrayList<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public ArrayList<Empleado> getLstSEmpleados() {
        return lstSEmpleados;
    }

    public void setLstSEmpleados(ArrayList<Empleado> lstSEmpleados) {
        this.lstSEmpleados = lstSEmpleados;
    }

    public ArrayList<Proveedor> getLstProveedor() {
        return lstProveedor;
    }

    public void setLstProveedor(ArrayList<Proveedor> lstProveedor) {
        this.lstProveedor = lstProveedor;
    }
    
    public String getProveedorName (String id) {
    	for (Proveedor proveedor : lstProveedor) {
			if(proveedor.getId().equals(id)) {
				
				 return proveedor.getNombre();
			}
		}
    	 return null;
    	
      
    }

	public void eliminaproduc(String idselect) {
		
		for (int i = 0; i < lstCompra.size(); i++) {
			if(lstCompra.get(i).getProducto().getId().equals(idselect)) {
				lstCompra.remove(i);
				
			}
			
			
		}
		
		
	}

}

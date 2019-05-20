package Modelo;

public class SuperAdmin extends Persona {
	
	 public SuperAdmin(Persona persona) {
		 super(persona.getId(), persona.getNombre(), persona.getCorreo(), persona.getDireccion(), persona.getTelefono(),
	                persona.getUsuario(), persona.getClave(), persona.getRol(),persona.getSalario(),persona.getBonificacion(),persona.getActivo());
	    }
	 
	 public SuperAdmin() {
	    }

	    public SuperAdmin(String id, String nombre, String correo, String direccion, String telefono, String usu, String cla, int rol,int salario,int bonificacion, int activo) {
	        super(id, nombre, correo, direccion, telefono, usu, cla, rol,salario,bonificacion,activo);
	    }

	    @Override
	    public String toString() {
	        return "SuperAdmin";
	    }

}

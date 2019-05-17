package Modelo;

public class Empleado extends Persona {

    public Empleado(Persona persona) {
        super(persona.getId(), persona.getNombre(), persona.getCorreo(), persona.getDireccion(), persona.getTelefono(),
                persona.getUsuario(), persona.getClave(), persona.getRol());
    }

    public Empleado() {
    }

    public Empleado(String id, String nombre, String correo, String direccion, String telefono, String usu, String cla, int rol) {
        super(id, nombre, correo, direccion, telefono, usu, cla, rol);
    }

    @Override
    public String toString() {
        return "Empleado";
    }
}

package Modelo;

public class Empleado extends Persona {

    public Empleado(Persona persona) {
        super(persona.getId(), persona.getNombre(), persona.getCorreo(), persona.getDireccion(), persona.getTelefono(),
                persona.getUsuario(), persona.getClave(), persona.getRol());
    }

    public Empleado() {
    }

    @Override
    public String toString() {
        return "Empleado";
    }
}

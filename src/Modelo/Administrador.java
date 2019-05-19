package Modelo;

public class Administrador extends Persona {
    public Administrador() {
    }

    public Administrador(Persona persona) {
        super(persona.getId(), persona.getNombre(), persona.getCorreo(), persona.getDireccion(), persona.getTelefono(),
                persona.getUsuario(), persona.getClave(), persona.getRol(), persona.getSalario(),persona.getBonificacion(),persona.getActivo());
    }

    @Override
    public String toString() {
        return "Administrador";
    }
}

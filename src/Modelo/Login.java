package Modelo;

public class Login {
    private  String usuario;
    private  String Clave;

    public Login() {
    }

    public Login(String usuario, String clave) {
        this.usuario = usuario;
        Clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }
}

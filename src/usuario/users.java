package usuario;
public class users {
    private int iduser;
    private String nombre;
    private String email;

    private int incidencia_id;

    public users(int iduser, String nombre, String email) {
        this.iduser = iduser;
        this.nombre = nombre;
        this.email = email;
    }
    public users(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public users( String nombre, String email, int incidencia_id) {
        this.nombre = nombre;
        this.email = email;
        this.incidencia_id = incidencia_id;
    }

    public users(int iduser) {
        this.iduser = iduser;
    }
    public int getIduser() {
        return iduser;
    }
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getIncidencia_id() {
        return incidencia_id;
    }

    public void setIncidencia_id(int incidencia_id) {
        this.incidencia_id = incidencia_id;
    }

    @Override
    public String toString() {
        return "user{" +
                "iduser=" + iduser +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
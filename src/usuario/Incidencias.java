package usuario;
public class Incidencias {
    private int idincidencia;
    private String despripcion;
    public Incidencias(int idincidencia, String despripcion) {
        this.idincidencia = idincidencia;
        this.despripcion = despripcion;
    }
    public Incidencias(String despripcion) {
        this.despripcion = despripcion;
    }
    public Incidencias(int idincidencia) {
        this.idincidencia = idincidencia;
    }
    public int getIdincidencia() {
        return idincidencia;
    }
    public void setIdincidencia(int idincidencia) {
        this.idincidencia = idincidencia;
    }
    public String getDespripcion() {
        return despripcion;
    }
    public void setDespripcion(String despripcion) {
        this.despripcion = despripcion;
    }
    @Override
    public String toString() {
        return "Incidencias{" +
                "idincidencia=" + idincidencia +
                ", despripcion='" + despripcion + '\'' +
                '}';
    }
}

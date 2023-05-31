package usuario;

import java.util.Date;
public class user_has_incidencia {
    private int id_user_has_incidencia;
    private Date fecha;
    private int id_user;
    private int id_incidencia;
    public user_has_incidencia(int id_user_has_incidencia, Date fecha, int id_user, int id_incidencia) {
        this.id_user_has_incidencia = id_user_has_incidencia;
        this.fecha = fecha;
        this.id_user = id_user;
        this.id_incidencia = id_incidencia;
    }
    public user_has_incidencia(Date fecha, int id_user, int id_incidencia) {
        this.fecha = fecha;
        this.id_user = id_user;
        this.id_incidencia = id_incidencia;
    }

    public user_has_incidencia(int id_user_has_incidencia) {
        this.id_user_has_incidencia = id_user_has_incidencia;
    }

    public int getId_user_has_incidencia() {
        return id_user_has_incidencia;
    }
    public void setId_user_has_incidencia(int id_user_has_incidencia) {
        this.id_user_has_incidencia = id_user_has_incidencia;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getId_user() {
        return id_user;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public int getId_incidencia() {
        return id_incidencia;
    }
    public void setId_incidencia(int id_incidencia) {
        this.id_incidencia = id_incidencia;
    }

    @Override
    public String toString() {
        return "usuario.user_has_incidencia{" +
                "id_user_has_incidencia=" + id_user_has_incidencia +
                ", fecha=" + fecha +
                ", id_user=" + id_user +
                ", id_incidencia=" + id_incidencia +
                '}';
    }
}
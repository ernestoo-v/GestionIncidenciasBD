package control;

import usuario.Incidencias;
import usuario.user_has_incidencia;
import usuario.users;

import java.util.ArrayList;

public class Transformar {

    /******TRANSFORMAR USUARIO******/
    public static String tuserSelectAll() {
        String sql;
        sql = "SELECT * FROM users";
        return sql;
    }

    /*
    public static  ArrayList<String> tusersInsert(users users1) throws ClassNotFoundException {
        ArrayList<String> list = new ArrayList<>();

        String sql;
        sql = "INSERT INTO users (iduser, nombre, email) VALUES (NULL, '" + users1.getNombre()
                + "', '" + users1.getEmail() +"')";
        list.add(sql);
        list.add(""+users1.getIncidencia_id());

        System.out.println("Si");


        return list;
    }*/
    public static String tusersUpdate(users users1) {
        String sql = "UPDATE users SET nombre='" + users1.getNombre() + "', email='" +  users1.getEmail()+"' WHERE iduser=" + users1.getIduser();
        System.out.println(sql);
        return sql;
    }
    public static  ArrayList<String> tusersDelete(users users1) {
        ArrayList<String> list = new ArrayList<>();
        list.add("DELETE FROM user_has_incidencias WHERE user_id=" + users1.getIduser()+";");
        list.add("DELETE FROM users WHERE iduser=" + users1.getIduser()+";");
        return list;
    }

    public static String tusersDeleteProcedure(users users1) {
        String sql;
        sql = "Call deleteUser ("+  users1.getIduser()+")";
        return sql;
    }

    public static String tusersInsertProcedure(users users1) throws ClassNotFoundException {

        String sql;
        sql = "Call insertarUser ('"+  users1.getNombre()+"','"+users1.getEmail()+"',"+users1.getIncidencia_id()+")";

        return sql;
    }

    /******TRANSFORMAR INCIDENCIA******/
    public static String tIncidenciasSelectAll() {
        String sql;
        sql = "SELECT * FROM incidencias";
        return sql;
    }
    public static  String tincidenciasInsert(Incidencias incidencias1) {
        String sql;
        sql = "INSERT INTO Incidencias (idincidencia, descripcion) VALUES (NULL, '" + incidencias1.getDespripcion()+"')";

        return sql;

    }

    /*
    public static String tincidenciasUpdate(Incidencias incidencias1) {
        String sql = "UPDATE incidencias SET descripcion='" + incidencias1.getDespripcion() +"' WHERE id_incidencia=" + incidencias1.getIdincidencia();
        System.out.println(sql);
        return sql;
    }*/

    /*
    public static  ArrayList<String> tincidenciasDelete(Incidencias incidencias1) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("DELETE FROM user_has_incidencias WHERE incidencia_id=" + incidencias1.getIdincidencia()+";");
            list.add("DELETE FROM incidencias WHERE idincidencia=" + incidencias1.getIdincidencia()+";");
        return list;
    }
*/
    public static String tincidenciasDeleteProcedure(Incidencias incidencias1) {
        String sql;
        sql = "Call deleteIncidencia ("+  incidencias1.getIdincidencia()+")";
        return sql;
    }
    /******TRANSFORMAR USER_HAS_INCIDENCIA******/
    public static  String tUser_has_IncidenciasSelectAll() {
        String sql;
        sql="SELECT * FROM user_has_incidencias";
        return sql;
    }

    /*
    public static String tuser_has_incidenciasUpdate(Incidencias incidencias1) {
        String sql = "UPDATE incidencias SET descripcion='" + incidencias1.getDespripcion() +"' WHERE id_incidencia=" + incidencias1.getIdincidencia();
        System.out.println(sql);
        return sql;
    }*/
    public static  String tuser_has_incidenciasDelete(user_has_incidencia user_has_incidencia1) {
        String sql;
        sql="DELETE FROM user_has_incidencias WHERE incidencia_id="+user_has_incidencia1.getId_user_has_incidencia();
        return sql;
    }


    public static String tuser_has_incidenciasInsert(user_has_incidencia user_has_incidencia1){

        String sql;
        sql = "Call insertarUser_has_incidencia ("+  user_has_incidencia1.getId_user()+","+user_has_incidencia1.getId_incidencia()+")";

        return sql;
    }


}

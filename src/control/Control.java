package control;
import usuario.user_has_incidencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Control {
    public static void conectBD(String BD,String sql){
        // TODO Auto-generated method stub
        Connection conexion = null;
        Statement sentenciaSQL = null;

        ResultSet rs;
        int resultado = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdincidencias", "root", "");

            sentenciaSQL = conexion.createStatement();
            resultado=sentenciaSQL.executeUpdate(sql);

            if (resultado >= 1) {
                System.out.println("Se ha insertado bien.");
            } else {
                System.out.println("Se ha insertado mal");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Conectado/desconectado");
    }
    public static void insertInto(String sql) throws ClassNotFoundException {

        // TODO Auto-generated method stub
        Connection conexion = null;
        Statement sentenciaSQL = null;

        ResultSet rs;
        int resultado = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdincidencias", "root", "");

            sentenciaSQL = conexion.createStatement();
            resultado=sentenciaSQL.executeUpdate(sql);
            System.out.println(sql);


            if (resultado >= 1) {
                System.out.println("Se ha insertado bien.");
            } else {
                System.out.println("Se ha insertado mal");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    /*
    public static void insertIntouser_has_inicidencias(String sql) throws ClassNotFoundException {

        // TODO Auto-generated method stub
        Connection conexion = null;
        Statement sentenciaSQL = null;

        ResultSet rs;
        int resultado = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdincidencias", "root", "");

            sentenciaSQL = conexion.createStatement();
            resultado=sentenciaSQL.executeUpdate(sql);

            if (resultado >= 1) {
                System.out.println("Se ha insertado bien.");
            } else {
                System.out.println("Se ha insertado mal");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Conectado/desconectado");
    }


     */
    public static int getLastId(){
    Connection conexion = null;
    Statement sentenciaSQL = null;
    ResultSet rs;
    int propietario = 1;
    int lastID = 0;

    try {
        // conectar con la base de datos
        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdincidencias", "root", "");
        sentenciaSQL = conexion.createStatement();
        rs = sentenciaSQL.executeQuery("SELECT max(iduser) as lastID FROM users;");

        // chequeo que el result set no sea vacío, moviendo el cursor a la
        // primer fila. (El cursor inicia antes de la primer fila)
        while (rs.next()) {
            lastID=rs.getInt("lastID");
        }

    } catch (SQLException | ClassNotFoundException ex) {
        ex.printStackTrace();
        // System.out.println("Error");
    } finally {
        try {
            sentenciaSQL.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            conexion.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    System.out.println("Conectado/desconectado");
    return lastID;
}
/*
    public static void insertIntoUser(ArrayList<String> list) throws ClassNotFoundException {

        // TODO Auto-generated method stub
        Connection conexion = null;
        Statement sentenciaSQL = null;

        ResultSet rs;
        int resultado = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdincidencias", "root", "");

            sentenciaSQL = conexion.createStatement();
            resultado=sentenciaSQL.executeUpdate(list.get(0));

            if (resultado >= 1) {
                System.out.println("Se ha insertado bien.");
            } else {
                System.out.println("Se ha insertado mal");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        user_has_incidencia user_has_incidenciaf = new user_has_incidencia(java.sql.Date.valueOf(LocalDate.now()), Control.getLastId()+1,Integer.parseInt(list.get(1)));

        Transformar.tuser_has_incidenciasInsert(user_has_incidenciaf);

        Control.selectAll(Transformar.tuserSelectAll(),1);

        Control.insertIntouser_has_inicidencias(Transformar.tuser_has_incidenciasInsert(user_has_incidenciaf));

        System.out.println("Conectado/desconectado");
    }
*/
    public static void deleteInto(ArrayList<String> list) throws ClassNotFoundException {
        // TODO Auto-generated method stub
        Connection conexion = null;
        Statement sentenciaSQL = null;

        ResultSet rs;
        int resultado = 0;
        int resultado2=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdincidencias", "root", "");

            sentenciaSQL = conexion.createStatement();

            resultado2 = sentenciaSQL.executeUpdate(list.get(0));
            resultado = sentenciaSQL.executeUpdate(list.get(1));

            if (resultado >= 1 && resultado2 >= 1) {
                System.out.println("Se ha insertado bien.");
            } else {
                System.out.println("Se ha insertado mal");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Conectado/desconectado");
    }
    public static void deleteIntoUser_has_incidencias(String sql) throws ClassNotFoundException {
        // TODO Auto-generated method stub
        Connection conexion = null;
        Statement sentenciaSQL = null;

        ResultSet rs;
        int resultado = 0;
        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdincidencias", "root", "");

            // creamos sentencias ejecutables sobre esa conexión
            sentenciaSQL = conexion.createStatement();

            // almaceno el resultado de la sql en un resulset (conjunto de registros)
            resultado = sentenciaSQL.executeUpdate(sql);

            if (resultado >= 1) {
                System.out.println("Se ha insertado bien.");
            } else {
                System.out.println("Se ha insertado mal");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Conectado/desconectado");
    }

    public static void selectAll(String sql, int tableCase) throws ClassNotFoundException {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        int propietario = 1;

        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdincidencias", "root", "");
            sentenciaSQL = conexion.createStatement();
            rs = sentenciaSQL.executeQuery(sql);

            // chequeo que el result set no sea vacío, moviendo el cursor a la
            // primer fila. (El cursor inicia antes de la primer fila)
            switch (tableCase){
                case 1:
                    while (rs.next()) {
                        System.out.println("iduser: " + rs.getInt("iduser") + " nombre: " + rs.getString("nombre")+ " email: "+rs.getString("email"));
                    }
                    break;
                case 2:
                    while (rs.next()) {
                        System.out.println("idincidencia: " + rs.getInt("idincidencia") + " Descripción: " + rs.getString("descripcion"));
                    }
                    break;
                case 3:
                    while (rs.next()) {
                        System.out.println("id_user_has_incidencia: " + rs.getInt("id_user_has_incidencia") + " fecha: " + rs.getDate("fecha")+ " user_id: "+rs.getInt("user_id")+" incidencia_id: "+rs.getInt("incidencia_id"));
                    }
                    break;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Conectado/desconectado");
    }
    public static void selectConsulta(String dato1, String dato3, int dato) throws ClassNotFoundException {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        int propietario = 1;
        String sql = "";

        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdincidencias", "root", "");

            // creamos sentencias ejecutables sobre esa conexión
            sentenciaSQL = conexion.createStatement();

            switch (dato) {
                case 1:
                    // almaceno el resultado de la sql en un resulset (conjunto de registros)
                    sql = "SELECT * FROM users WHERE nombre='" + dato1 + "'";
                    // System.out.println(sql);

                    rs = sentenciaSQL.executeQuery(sql);

                    // chequeo que el result set no sea vacío, moviendo el cursor a la
                    // primer fila. (El cursor inicia antes de la primer fila)
                    while (rs.next()) {
                        // Si hay resultados obtengo el valor.
                        System.out.println("iduser: " + rs.getInt("iduser") + " nombre: " + rs.getString("nombre")+ " email: "+rs.getString("email"));
                    }
                    break;
                case 2:
                    // almaceno el resultado de la sql en un resulset (conjunto de registros)
                    sql = "SELECT * FROM users WHERE email='" + dato3 + "'";
                    // System.out.println(sql);

                    rs = sentenciaSQL.executeQuery(sql);

                    // chequeo que el result set no sea vacío, moviendo el cursor a la
                    // primer fila. (El cursor inicia antes de la primer fila)
                    while (rs.next()) {
                        // Si hay resultados obtengo el valor.
                        System.out.println("iduser: " + rs.getInt("iduser") + " nombre: " + rs.getString("nombre")+ " email: "+rs.getString("email"));
                    }
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Conectado/desconectado");
    }
    public static void selectConsultaIncidencias(String dato1) throws ClassNotFoundException {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        int propietario = 1;
        String sql = "";

        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdincidencias", "root", "");

            // creamos sentencias ejecutables sobre esa conexión
            sentenciaSQL = conexion.createStatement();

            // almaceno el resultado de la sql en un resulset (conjunto de registros)
            sql = "SELECT * FROM incidencias WHERE descripcion='" + dato1 + "'";
            // System.out.println(sql);

            rs = sentenciaSQL.executeQuery(sql);

            // chequeo que el result set no sea vacío, moviendo el cursor a la
            // primer fila. (El cursor inicia antes de la primer fila)
            while (rs.next()) {
                // Si hay resultados obtengo el valor.
                System.out.println("idincidencia: " + rs.getInt("idincidencia") + " descripcion: " + rs.getString("descripcion"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Conectado/desconectado");
    }




    public static void selectConsultaUsers_has_incidencia(int id_consult,String dato1, String dato3, int dato) throws ClassNotFoundException {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        int propietario = 1;
        String sql = "";

        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdincidencias", "root", "");

            sentenciaSQL = conexion.createStatement();

            switch (dato) {
                case 1:
                   // sql = "SELECT Count(id_user_has_incidencia) AS total FROM user_has_incidencias WHERE incidencia_id="+id_consult;
                    sql = "SELECT (Select descripcion from incidencias where idincidencia="+id_consult+") as total2,Count(id_user_has_incidencia) AS total FROM user_has_incidencias WHERE incidencia_id="+id_consult;

                    rs = sentenciaSQL.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println("El incidente " + rs.getString("total2")+" con id: " + id_consult +" se encuentra un total de: "+ rs.getInt("total")+" veces");
                    }
                    break;
                case 2:
                    sql = "SELECT (Select nombre from users where iduser="+id_consult+") as nombreUser,Count(id_user_has_incidencia) AS total FROM user_has_incidencias WHERE user_id="+id_consult;
                    rs = sentenciaSQL.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println("El user "+rs.getString("nombreUser")+" con id: " + id_consult +" tiene un total de: "+ rs.getInt("total")+" incidencias");
                    }
                    break;
                case 3:
                    sql = "SELECT incidencias.descripcion as incidencia,COUNT(*) as veces From incidencias INNER JOIN user_has_incidencias on incidencias.idincidencia=user_has_incidencias.incidencia_id GROUP BY incidencia_id order by count(incidencia_id) DESC LIMIT 1;";

                    rs = sentenciaSQL.executeQuery(sql);

                    while (rs.next()) {
                        System.out.println("El incidente mas usado es el: " + rs.getString("incidencia")+" y se encuentra un total de: "+ rs.getInt("veces")+" veces");
                    }
                    break;
                case 4:
                    sql = "SELECT COUNT(*) as total FROM `user_has_incidencias`";

                    rs = sentenciaSQL.executeQuery(sql);

                    while (rs.next()) {
                        System.out.println("Hay un total de: " + rs.getInt("total")+" incidencias");
                    }

                    break;
                case 5:
                    sql = "    SELECT nombre as nombre,iduser as iduser from users Where iduser Not in (select user_id From user_has_incidencias)";

                    rs = sentenciaSQL.executeQuery(sql);
                    System.out.println("Los usuarios sin inicidencias son: ");
                    while (rs.next()) {
                        System.out.println("" + rs.getString("nombre")+ " con id: "+ rs.getInt("iduser"));
                    }

                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Conectado/desconectado");
    }

}

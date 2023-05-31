package usuario;

import control.Control;
import control.Transformar;

import java.time.LocalDate;
import java.util.Scanner;
public class PedirDatos {

    /******PEDIR DATOS USUARIO******/
    public static users PedirDatosUser() {
        Scanner lecScanner = new Scanner(System.in);
        boolean valido = false;
        String nombre = "";
        String email = "";
        int id_incidencia = 0;


        try {
            System.out.print("Introduce Nombre: ");
            nombre = lecScanner.nextLine();

            System.out.print("Introduce email: ");
            email = lecScanner.nextLine();

            Control.selectAll(Transformar.tIncidenciasSelectAll(),2);

            do {
                System.out.print("Introduce Incidencia: ");
                if (lecScanner.hasNextInt()) {
                    id_incidencia = lecScanner.nextInt();
                    valido = true;
                } else {
                    System.out.println("Entrada no válida. Introduce un número entero.");
                    lecScanner.next(); // limpiar el buffer de entrada
                }
            } while (!valido);

        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

        return new users(nombre, email, id_incidencia);
    }
    public static users PedirDatosUpdate() {


        Scanner lecScanner = new Scanner(System.in);
        boolean valido = false;
        String nombre = "";
        String email = "";
        int id=0;

        try {
            do {
                System.out.print("Introduce id que modificar: ");
                if (lecScanner.hasNextInt()) {
                    id = lecScanner.nextInt();
                    lecScanner.nextLine();
                    valido = true;
                } else {
                    System.out.println("Entrada no válida. Introduce un número entero.");
                    lecScanner.next(); // limpiar el buffer de entrada
                }
            } while (!valido);

            System.out.println("Introduce datos que modificar: ");
            System.out.print("Introduce nombre: ");
            nombre = lecScanner.nextLine();
            System.out.print("Introduce email: ");
            email = lecScanner.nextLine();


        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

        return new users(id,nombre, email);
    }
    public static users PedirDatosDelete() {

        Scanner lecScanner = new Scanner(System.in);
        int id=0;
        boolean valido = false;
        try {
            do {
                System.out.print("Introduce id que eliminar: ");
                if (lecScanner.hasNextInt()) {
                    id = lecScanner.nextInt();
                    lecScanner.nextLine();
                    valido = true;
                } else {
                    System.out.println("Entrada no válida. Introduce un número entero.");
                    lecScanner.next(); // limpiar el buffer de entrada
                }
            } while (!valido);
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
        return new users(id);
    }

    /******PEDIR DATOS INCIDENCIA******/
    public static Incidencias PedirDatosIncidencia() {

        Scanner lecScanner = new Scanner(System.in);

        String descripcion;

        System.out.println("Introduce Descripción: ");
        descripcion = lecScanner.nextLine();

        return new Incidencias(descripcion);
    }
    public static Incidencias PedirDatosIncidenciaUpdate() {

        Scanner lecScanner = new Scanner(System.in);
        String descripcion="";
        int id=0;
        boolean valido = false;

        try {
            do{
                System.out.print("Introduce id que modificar: ");
                if (lecScanner.hasNextInt()) {
                    id = lecScanner.nextInt();
                    lecScanner.nextLine();
                    valido = true;
                } else {
                    System.out.println("Entrada no válida. Introduce un número entero.");
                    lecScanner.next(); // limpiar el buffer de entrada
                }
            } while (!valido);

            System.out.println("Introduce datos que modificar: ");
            System.out.print("Introduce descripcion: ");
            descripcion = lecScanner.nextLine();

        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

        return new Incidencias(id,descripcion);
    }
    public static Incidencias PedirDatosIncidenciaDelete() {

        Scanner lecScanner = new Scanner(System.in);
        int id;

        boolean valido = false;
        try {
            do {
                System.out.print("Introduce id que eliminar: ");
                if (lecScanner.hasNextInt()) {
                    id = lecScanner.nextInt();
                    lecScanner.nextLine();
                    valido = true;
                } else {
                    System.out.println("Entrada no válida. Introduce un número entero.");
                    lecScanner.next(); // limpiar el buffer de entrada
                }
            } while (!valido);
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
        System.out.print("Introduce id que eliminar: ");
        id = lecScanner.nextInt();
        lecScanner.nextLine();

        return new Incidencias(id);
    }

    /******PEDIR DATOS USER_HAS_INCIDENCIA******/
    public static user_has_incidencia PedirDatosUser_has_incidencia() {

        Scanner lecScanner = new Scanner(System.in);
        int user_id=0;
        int incidencia_id=0;

        boolean valido = false;
        try {
            do{
                System.out.print("Introduce user_id: ");
                if (lecScanner.hasNextInt()) {
                    user_id = lecScanner.nextInt();
                    lecScanner.nextLine();
                    System.out.print("Introduce incidencia_id: ");

                    if(lecScanner.hasNextInt()){
                        incidencia_id = lecScanner.nextInt();
                        lecScanner.nextLine();
                        valido = true;

                    }
                    else{
                        System.out.println("Entrada no válida. Introduce un número entero.");
                        lecScanner.next();
                    }
                } else {
                    System.out.println("Entrada no válida. Introduce un número entero.");
                    lecScanner.next(); // limpiar el buffer de entrada
                }
            } while (!valido);

        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

        return new user_has_incidencia(java.sql.Date.valueOf(LocalDate.now()),user_id,incidencia_id);
    }
    public static Incidencias PedirDatosUser_has_incidenciaUpdate() {

        Scanner lecScanner = new Scanner(System.in);
        String descripcion;
        int id;

        System.out.print("Introduce id que modificar: ");
        id = lecScanner.nextInt();
        lecScanner.nextLine();

        System.out.println("Introduce datos que modificar: ");
        System.out.print("Introduce nombre: ");
        descripcion = lecScanner.nextLine();

        return new Incidencias(id,descripcion);
    }
    public static user_has_incidencia PedirDatosUser_has_incidenciaDelete() {

        Scanner lecScanner = new Scanner(System.in);
        int id;

        System.out.print("Introduce id que eliminar: ");
        id = lecScanner.nextInt();
        lecScanner.nextLine();

        return new user_has_incidencia(id);
    }
    public static void menuUser() throws ClassNotFoundException {
        Scanner lecScanner = new Scanner(System.in);
        int seleccion;
        int seleccionConsulta;
        String seleccionConsultaString;



        do {
            seleccion=mostrarMenu();
            switch (seleccion) {
                case 1:
                    Control.selectAll(Transformar.tuserSelectAll(),1);
                    break;
                case 2:

                    Control.insertInto(Transformar.tusersInsertProcedure(PedirDatosUser()));

                    //Control.insertIntoUser(Transformar.tusersInsert(PedirDatos.PedirDatosUser()));

                    break;
                case 3:
                    seleccion=mostrarModificar();
                    switch (seleccion) {
                        case 1:
                            Control.selectAll(Transformar.tuserSelectAll(),1);
                            Control.insertInto(Transformar.tusersUpdate(PedirDatos.PedirDatosUpdate()));
                            break;
                        case 2:
                            Control.selectAll(Transformar.tuserSelectAll(),1);
                            //Control.deleteInto(Transformar.tusersDelete(PedirDatos.PedirDatosDelete()));
                            Control.insertInto(Transformar.tusersDeleteProcedure(PedirDatosDelete()));
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("1. Consultar nombre de user");
                    System.out.println("2. Consultar email de user");
                    System.out.println("3. Salir");
                    System.out.print("Indique opcion: ");

                    seleccionConsulta = lecScanner.nextInt();
                    lecScanner.nextLine();

                    switch(seleccionConsulta){
                        case 1:
                            System.out.print("Indique que quiere buscar: ");
                            seleccionConsultaString = lecScanner.nextLine();
                            System.out.println();
                            Control.selectConsulta(seleccionConsultaString,null, 1);
                            System.out.println();
                            break;
                        case 2:
                            System.out.print("Indique que quiere buscar: ");
                            seleccionConsultaString = lecScanner.nextLine();
                            System.out.println();
                            Control.selectConsulta(null, seleccionConsultaString,2);
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("Saliste");
                            break;
                    }
                    System.out.println("Saliste");
                    break;
                case 5:
                    System.out.println("Saliste");
                    break;
            }
        } while (seleccion != 5);
    }
    public static void menuIncidencia() throws ClassNotFoundException {
        Scanner lecScanner = new Scanner(System.in);
        int seleccion = 0;
        int seleccionConsulta = 0;
        String seleccionConsultaString;
        do {
            seleccion=mostrarMenu();
            switch (seleccion) {
                case 1:
                    Control.selectAll(Transformar.tIncidenciasSelectAll(),2);
                    break;
                case 2:
                    Control.insertInto(Transformar.tincidenciasInsert(PedirDatosIncidencia()));
                    break;
                case 3:
                    seleccion=mostrarModificar();
                    switch (seleccion) {
                        case 1:
                            Control.selectAll(Transformar.tIncidenciasSelectAll(),2);
                            Control.insertInto(Transformar.tincidenciasInsert(PedirDatosIncidenciaUpdate()));
                            break;
                        case 2:
                            Control.selectAll(Transformar.tIncidenciasSelectAll(),2);
                            //Control.deleteInto(Transformar.tincidenciasInsert(PedirDatosIncidenciaDelete()));

                            Control.insertInto(Transformar.tincidenciasDeleteProcedure(PedirDatosIncidenciaDelete()));
                            break;
                        case 3:
                            System.out.println("Saliste");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("1. Consultar descripcion de incidencia");
                    System.out.println("2. Salir");

                    System.out.print("Indique opcion: ");
                    seleccionConsulta = lecScanner.nextInt();
                    lecScanner.nextLine();

                    switch (seleccionConsulta) {
                        case 1:
                            System.out.print("Indique que quiere buscar: ");
                            seleccionConsultaString = lecScanner.nextLine();
                            System.out.println("");
                            Control.selectConsultaIncidencias(seleccionConsultaString);
                            System.out.println("");
                            break;
                        case 2:
                            System.out.println("Saliste");
                            break;
                        default:
                            System.out.println("Opcion incorrecta");
                            break;
                    }
                    System.out.println("Saliste");
                    break;
                case 5:
                    System.out.println("Saliste");
                    break;
            }
        } while (seleccion != 5);
    }
    public static void menuUser_has_inicidencia() throws ClassNotFoundException {

        Scanner lecScanner = new Scanner(System.in);
        int seleccion = 0;
        int seleccionConsulta = 0;
        String seleccionConsultaString;
        do {
             seleccion=mostrarMenu();
            switch (seleccion) {
                case 1:
                    Control.selectAll(Transformar.tUser_has_IncidenciasSelectAll(),3);

                    break;
                case 2:
                    Control.insertInto(Transformar.tuser_has_incidenciasInsert(PedirDatosUser_has_incidencia()));
                    break;
                case 3:
                   seleccion=mostrarModificar();
                    switch (seleccion) {
                        case 1:
                            Control.selectAll(Transformar.tUser_has_IncidenciasSelectAll(),3);
                            Control.insertInto(Transformar.tusersUpdate(PedirDatos.PedirDatosUpdate()));
                            break;
                        case 2:
                            Control.selectAll(Transformar.tUser_has_IncidenciasSelectAll(),3);
                            Control.deleteIntoUser_has_incidencias(Transformar.tuser_has_incidenciasDelete(PedirDatos.PedirDatosUser_has_incidenciaDelete()));
                        case 3:
                            System.out.println("Saliste");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Saliste");
                    break;
            }
        } while (seleccion != 5);
    }
    public static int mostrarMenu(){
        Scanner lecScanner = new Scanner(System.in);
        int seleccion = 0;
        System.out.println("1. Mostrar tabla");
        System.out.println("2. Insertar tabla");
        System.out.println("3. Modificar tabla");
        System.out.println("4. Consultar tabla");
        System.out.println("5. Salir");
        System.out.print("Qué desea hacer: ");
        try {
            seleccion = lecScanner.nextInt();
            lecScanner.nextLine();
        } catch (Exception e) {
            System.out.println("Something went wrong.");

        } finally {
            System.out.println("Seleccion correcta");
        }
        return seleccion;

    }
    public static int mostrarModificar(){
        Scanner lecScanner = new Scanner(System.in);
        int seleccion = 0;

        System.out.println("1. Modificar row de la tabla");
        System.out.println("2. Eliminar row de la tabla");
        System.out.println("3. Salir");
        System.out.println("Qué desea hacer: ");
        try {
            seleccion = lecScanner.nextInt();
            lecScanner.nextLine();
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        } finally {
            System.out.println("Seleccion correcta");
        }
        return seleccion;
    }
    public static void mostrarMenuConsultas() throws ClassNotFoundException {
        Scanner lecScanner = new Scanner(System.in);
        int seleccionConsulta=0;
        System.out.println("1. Incidencia? -> Users");
        System.out.println("2. User? -> Incidencia");
        System.out.println("3. Incidencia mas usada");
        System.out.println("4. Cuantas incidencias hay");
        System.out.println("5. Usuarios sin inicidencias");

        System.out.println("6. Salir");


        boolean valido = false;
        try {
            do {
                System.out.print("Indique opcion: ");
                if (lecScanner.hasNextInt()) {
                    seleccionConsulta = lecScanner.nextInt();
                    lecScanner.nextLine();
                    valido = true;
                } else {
                    System.out.println("Entrada no válida. Introduce un número entero.");
                    lecScanner.next(); // limpiar el buffer de entrada
                }
            } while (!valido);
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }




        switch (seleccionConsulta){
            case 1:
                Control.selectAll(Transformar.tIncidenciasSelectAll(),2);
                System.out.print("Indique que id de incidencia quiere buscar: ");
                seleccionConsulta = lecScanner.nextInt();
                lecScanner.nextLine();
                System.out.println();
                Control.selectConsultaUsers_has_incidencia(seleccionConsulta,null,null, 1);
                System.out.println();
                break;
            case 2:
                Control.selectAll(Transformar.tuserSelectAll(),1);
                System.out.print("Indique que id de user quiere buscar: ");
                seleccionConsulta = lecScanner.nextInt();
                lecScanner.nextLine();
                System.out.println();
                Control.selectConsultaUsers_has_incidencia(seleccionConsulta,null,null, 2);
                System.out.println();
                break;
            case 3:
                Control.selectConsultaUsers_has_incidencia(0,null,null, 3);
                break;
            case 4:
                Control.selectConsultaUsers_has_incidencia(0,null,null, 4);
                break;
            case 5:
                Control.selectConsultaUsers_has_incidencia(0,null,null, 5);
                break;
            case 6:
                System.out.println("Saliste");
                break;
        }
}}

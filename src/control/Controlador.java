package control;
import usuario.PedirDatos;
import java.util.Scanner;
public class Controlador {

    //El thwow propaga la excepcion hacia arriba de la pila de llamadas.
    //El error surge por problemas con la configuración del classpath, porque java no puede encontrar la definicion
    //de la clase requerida
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner lecScanner = new Scanner(System.in);

        int seleccion=0;

        System.out.println("1. Tabla users");
        System.out.println("2. Tabla inicidencias");
        System.out.println("3. Tabla user_has_inicidencias");
        System.out.println("4. Consultas");

        System.out.println("5. Salir");

        boolean valido = false;
        try {
            do {
                System.out.print("Indique opcion: ");

                if (lecScanner.hasNextInt()) {
                    seleccion=lecScanner.nextInt();
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
        switch (seleccion) {
            case 1:
                PedirDatos.menuUser();
                break;
            case 2:
                PedirDatos.menuIncidencia();
                break;
            case 3:
                PedirDatos.menuUser_has_inicidencia();
                break;
            case 4:
               PedirDatos.mostrarMenuConsultas();
                break;
            case 5:
                System.out.println("Saliste");
                break;
        }
    }
}
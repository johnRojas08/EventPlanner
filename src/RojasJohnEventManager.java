import java.util.ArrayList;
import java.util.Scanner;

// Clase que maneja la lógica del programa y la interacción con el usuario
public class RojasJohnEventManager {
    private ArrayList<RojasJohnEvent> events = new ArrayList<>(); // Lista de eventos
    private Scanner scanner = new Scanner(System.in);            // Escáner para entrada del usuario

    public void run() {
        while (true) {
            System.out.println("\nBienvenido a Event Planner. Seleccione una opción");
            System.out.println("[1] Añadir evento");
            System.out.println("[2] Borrar evento");
            System.out.println("[3] Listar eventos");
            System.out.println("[4] Marcar/desmarcar tarea de un evento como completada");
            System.out.println("[5] Salir");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addEvent();
                    break;
                case "2":
                    deleteEvent();
                    break;
                case "3":
                    listEvents();
                    break;
                case "4":
                    toggleTaskStatus();
                    break;
                case "5":
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }




}

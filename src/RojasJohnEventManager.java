import java.time.LocalDate;
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

    private void addEvent() {
        System.out.print("Ingrese el título del evento: ");
        String title = scanner.nextLine();

        System.out.print("Ingrese la fecha del evento (YYYY-MM-DD): ");
        LocalDate date;
        try {
            date = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Fecha no válida. Operación cancelada.");
            return;
        }

        System.out.print("Ingrese la prioridad (HIGH, MEDIUM, LOW): ");
        RojasJohnPriority priority;
        try {
            priority = RojasJohnPriority.valueOf(scanner.nextLine().toUpperCase());
        } catch (Exception e) {
            System.out.println("Prioridad no válida. Operación cancelada.");
            return;
        }

        RojasJohnEvent event = new RojasJohnEvent(title, date, priority);

        System.out.print("¿Desea añadir tareas al evento? (sí/no): ");
        if (scanner.nextLine().equalsIgnoreCase("sí")) {
            while (true) {
                System.out.print("Ingrese la descripción de la tarea (o escriba 'fin' para terminar): ");
                String taskText = scanner.nextLine();
                if (taskText.equalsIgnoreCase("fin")) {
                    break;
                }
                event.addTask(new RojasJohnEventTask(taskText));
            }
        }

        events.add(event);
        System.out.println("Evento añadido exitosamente.");
    }

    private void deleteEvent() {
        System.out.print("Ingrese el título del evento a borrar: ");
        String title = scanner.nextLine();

        RojasJohnEvent eventToRemove = events.stream()
                .filter(e -> e.getTitle().equals(title))
                .findFirst()
                .orElse(null);

        if (eventToRemove != null) {
            events.remove(eventToRemove);
            System.out.println("Evento eliminado exitosamente.");
        } else {
            System.out.println("Evento no encontrado.");
        }
    }

    private void listEvents() {
        if (events.isEmpty()) {
            System.out.println("No hay eventos registrados.");
        } else {
            events.forEach(System.out::println);
        }
    }

    private void toggleTaskStatus() {
        System.out.print("Ingrese el título del evento: ");
        String title = scanner.nextLine();

        RojasJohnEvent event = events.stream()
                .filter(e -> e.getTitle().equals(title))
                .findFirst()
                .orElse(null);

        if (event == null) {
            System.out.println("Evento no encontrado.");
            return;
        }

        ArrayList<RojasJohnEventTask> tasks = event.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("El evento no tiene tareas asociadas.");
            return;
        }

        System.out.println("Lista de tareas:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + tasks.get(i));
        }

        System.out.print("Seleccione el número de la tarea: ");
        int taskIndex;
        try {
            taskIndex = Integer.parseInt(scanner.nextLine()) - 1;
            if (taskIndex < 0 || taskIndex >= tasks.size()) {
                throw new IndexOutOfBoundsException();
            }
        } catch (Exception e) {
            System.out.println("Selección no válida.");
            return;
        }

        RojasJohnEventTask task = tasks.get(taskIndex);
        if (task.isCompleted()) {
            task.markAsIncomplete();
            System.out.println("Tarea marcada como pendiente.");
        } else {
            task.markAsCompleted();
            System.out.println("Tarea marcada como completada.");
        }
    }
}

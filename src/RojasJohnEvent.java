import java.time.LocalDate;
import java.util.ArrayList;

// Clase que representa un evento con atributos y tareas asociadas
public class RojasJohnEvent {
    private String title;                  // Título del evento
    private LocalDate date;               // Fecha del evento
    private RojasJohnPriority priority;            // Prioridad del evento
    private ArrayList<RojasJohnEventTask> tasks;   // Lista de tareas del evento

    // Constructor para inicializar un evento
    public RojasJohnEvent(String title, LocalDate date, RojasJohnPriority priority) {
        this.title = title;
        this.date = date;
        this.priority = priority;
        this.tasks = new ArrayList<>();   // Inicializa la lista de tareas vacía
    }

    // Método para añadir una tarea al evento
    public void addTask(RojasJohnEventTask task) {
        tasks.add(task);
    }

    // Método para obtener el título del evento
    public String getTitle() {
        return title;
    }

    // Método para obtener la lista de tareas asociadas al evento
    public ArrayList<RojasJohnEventTask> getTasks() {
        return tasks;
    }

    // Representación en texto del evento, incluyendo estado de tareas
    @Override
    public String toString() {
        long completedTasks = tasks.stream().filter(RojasJohnEventTask::isCompleted).count();
        return "Evento: " + title + ", Fecha: " + date + ", Prioridad: " + priority + ", Tareas: " + completedTasks + "/" + tasks.size();
    }
}

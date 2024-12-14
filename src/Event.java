import java.time.LocalDate;
import java.util.ArrayList;

// Clase que representa un evento con atributos y tareas asociadas
public class Event {
    private String title;                  // Título del evento
    private LocalDate date;               // Fecha del evento
    private Priority priority;            // Prioridad del evento
    private ArrayList<EventTask> tasks;   // Lista de tareas del evento

    // Constructor para inicializar un evento
    public Event(String title, LocalDate date, Priority priority) {
        this.title = title;
        this.date = date;
        this.priority = priority;
        this.tasks = new ArrayList<>();   // Inicializa la lista de tareas vacía
    }

    // Método para añadir una tarea al evento
    public void addTask(EventTask task) {
        tasks.add(task);
    }

    // Método para obtener el título del evento
    public String getTitle() {
        return title;
    }

    // Método para obtener la lista de tareas asociadas al evento
    public ArrayList<EventTask> getTasks() {
        return tasks;
    }

    // Representación en texto del evento, incluyendo estado de tareas
    @Override
    public String toString() {
        long completedTasks = tasks.stream().filter(EventTask::isCompleted).count();
        return "Evento: " + title + ", Fecha: " + date + ", Prioridad: " + priority + ", Tareas: " + completedTasks + "/" + tasks.size();
    }
}

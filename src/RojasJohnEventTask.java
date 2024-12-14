// Clase que representa una tarea asociada a un evento
public class RojasJohnEventTask {
    private String text;           // Descripción de la tarea
    private boolean isCompleted;   // Estado de la tarea (true: completada, false: pendiente)

    // Constructor para inicializar una tarea
    public RojasJohnEventTask(String text) {
        this.text = text;
        this.isCompleted = false; // Por defecto, la tarea no está completada
    }

    // Método para marcar la tarea como completada
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // Método para marcar la tarea como pendiente
    public void markAsIncomplete() {
        this.isCompleted = false;
    }

    // Método para obtener el estado de la tarea
    public boolean isCompleted() {
        return isCompleted;
    }

    // Representación en texto de una tarea
    @Override
    public String toString() {
        return text + " (" + (isCompleted ? "Hecha" : "Pendiente") + ")";
    }
}

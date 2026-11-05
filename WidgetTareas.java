/** Widget interactivo que permite completar una tarea. */
public class WidgetTareas extends Widget implements Interactivo {
    private final String tarea;
    private boolean completada;

    public WidgetTareas(int id, String nombre, double memoriaKB, String tarea) {
        super(id, nombre, memoriaKB);
        this.tarea = tarea;
        this.completada = false;
    }

    @Override
    public String renderizar() {
        return "[TAREA] " + getNombre() + " | " + tarea + " | Estado: "
                + (completada ? "Completada" : "Pendiente");
    }

    @Override
    public String interactuar() {
        if (completada) {
            return "La tarea ya estaba completada: " + tarea;
        }
        completada = true;
        return "Tarea completada: " + tarea;
    }

    @Override
    public String verConfiguracion() {
        return super.verConfiguracion() + "\nTipo: Tareas"
                + "\nTarea: " + tarea
                + "\nCompletada: " + (completada ? "Sí" : "No");
    }
}

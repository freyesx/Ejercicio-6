import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Administra el catálogo mediante una sola lista polimórfica. */
public class Dashboard {
    private final List<Widget> widgets;

    public Dashboard() {
        widgets = new ArrayList<>();
        cargarCatalogoInicial();
    }

    public void cargarCatalogoInicial() {
        // Evita cargar nuevamente el catálogo si ya contiene elementos.
        if (!widgets.isEmpty()) {
            return;
        }
        agregarWidget(new WidgetClima(1, "Clima Guatemala", 120,
                "Ciudad de Guatemala", 24));
        agregarWidget(new WidgetClima(2, "Clima Antigua", 110,
                "Antigua Guatemala", 22));
        agregarWidget(new WidgetClima(3, "Clima Quetzaltenango", 115,
                "Quetzaltenango", 17));
        agregarWidget(new WidgetReloj(4, "Reloj Guatemala", 40,
                "America/Guatemala"));
        agregarWidget(new WidgetReloj(5, "Reloj Madrid", 45,
                "Europe/Madrid"));
        agregarWidget(new WidgetTareas(6, "Entrega de programación", 85,
                "Terminar el ejercicio de interfaces"));
        agregarWidget(new WidgetTareas(7, "Revisión del diseño", 70,
                "Revisar el diagrama UML"));
        agregarWidget(new WidgetTareas(8, "Publicación del proyecto", 75,
                "Subir el código a GitHub"));
        agregarWidget(new WidgetAlerta(9, "Mantenimiento", 55,
                "El sistema tendrá mantenimiento esta noche"));
        agregarWidget(new WidgetAlerta(10, "Consumo elevado", 60,
                "Revisar el consumo de memoria del dashboard"));
    }

    public void agregarWidget(Widget widget) {
        if (widget == null) {
            throw new IllegalArgumentException("El widget no puede ser nulo.");
        }
        if (buscarWidget(widget.getId()) != null) {
            throw new IllegalArgumentException("Ya existe un widget con ese ID.");
        }
        widgets.add(widget);
    }

    /** Devuelve una vista de solo lectura, sin copiar la lista. */
    public List<Widget> getWidgets() {
        return Collections.unmodifiableList(widgets);
    }

    public Widget buscarWidget(int id) {
        for (Widget widget : widgets) {
            if (widget.getId() == id) {
                return widget;
            }
        }
        return null;
    }

    /** Sobrecarga: busca por nombre completo e ignora mayúsculas.
     * Si hay nombres repetidos, devuelve la primera coincidencia.
     */
    public Widget buscarWidget(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return null;
        }
        for (Widget widget : widgets) {
            if (widget.getNombre().equalsIgnoreCase(nombre.trim())) {
                return widget;
            }
        }
        return null;
    }

    public void ordenarPorMemoria() {
        // Utiliza compareTo() de Widget.
        Collections.sort(widgets);
    }
}

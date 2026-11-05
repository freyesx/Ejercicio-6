/** Conecta las operaciones del modelo con la vista. */
public class ControladorDashboard {
    private final Dashboard dashboard;

    public ControladorDashboard(Dashboard dashboard) {
        if (dashboard == null) {
            throw new IllegalArgumentException("El dashboard no puede ser nulo.");
        }
        this.dashboard = dashboard;
    }

    public String listarActivos() {
        StringBuilder resultado = new StringBuilder();
        int cantidad = 0;
        for (Widget widget : dashboard.getWidgets()) {
            if (widget.isActivo()) {
                resultado.append(widget.toString()).append("\n")
                        .append(renderizarWidget(widget)).append("\n\n");
                cantidad++;
            }
        }
        if (cantidad == 0) {
            return "No hay widgets activos.";
        }
        return "Widgets activos: " + cantidad + "\n\n" + resultado.toString();
    }

    public String consultarPorId(int id) {
        Widget widget = dashboard.buscarWidget(id);
        if (widget == null) {
            return "No se encontró un widget con el ID " + id + ".";
        }
        return widget.verConfiguracion();
    }

    public String consultarPorNombre(String nombre) {
        Widget widget = dashboard.buscarWidget(nombre);
        if (widget == null) {
            return "No se encontró un widget con ese nombre.";
        }
        return widget.verConfiguracion();
    }

    public String ordenarWidgets() {
        dashboard.ordenarPorMemoria();
        return "Catálogo ordenado por memoria de menor a mayor."
                + "\n\n" + listarActivos();
    }

    public String interactuarConWidget(int id) {
        Widget widget = dashboard.buscarWidget(id);
        if (widget == null) {
            return "No se encontró un widget con ese ID.";
        }
        if (!widget.isActivo()) {
            return "El widget está inactivo.";
        }
        if (widget instanceof Interactivo) {
            return ejecutarInteraccion((Interactivo) widget);
        }
        return "Este widget es informativo y no admite interacción.";
    }

    /** Polimorfismo mediante un parámetro de tipo interfaz. */
    private String renderizarWidget(Renderizable elemento) {
        return elemento.renderizar();
    }

    /** Acepta cualquier implementación de Interactivo. */
    private String ejecutarInteraccion(Interactivo elemento) {
        return elemento.interactuar();
    }
}

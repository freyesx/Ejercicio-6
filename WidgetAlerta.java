/** Widget interactivo que permite marcar una alerta como leída. */
public class WidgetAlerta extends Widget implements Interactivo {
    private final String mensaje;
    private boolean leida;

    public WidgetAlerta(int id, String nombre, double memoriaKB, String mensaje) {
        super(id, nombre, memoriaKB);
        this.mensaje = mensaje;
        this.leida = false;
    }

    @Override
    public String renderizar() {
        return "[ALERTA] " + getNombre() + " | " + mensaje
                + " | Estado: " + (leida ? "Leída" : "Sin leer");
    }

    @Override
    public String interactuar() {
        if (leida) {
            return "La alerta ya estaba marcada como leída.";
        }
        leida = true;
        return "Alerta marcada como leída: " + getNombre();
    }

    @Override
    public String verConfiguracion() {
        return super.verConfiguracion() + "\nTipo: Alerta"
                + "\nMensaje: " + mensaje
                + "\nLeída: " + (leida ? "Sí" : "No");
    }
}

/** Widget informativo que muestra datos simulados del clima. */
public class WidgetClima extends Widget {
    private final String ciudad;
    private final double temperatura;

    public WidgetClima(int id, String nombre, double memoriaKB,
                       String ciudad, double temperatura) {
        super(id, nombre, memoriaKB);
        this.ciudad = ciudad;
        this.temperatura = temperatura;
    }

    @Override
    public String renderizar() {
        return "[CLIMA] " + getNombre() + " | Ciudad: " + ciudad
                + " | Temperatura: " + temperatura + " °C";
    }

    @Override
    public String verConfiguracion() {
        return super.verConfiguracion() + "\nTipo: Clima"
                + "\nCiudad: " + ciudad
                + "\nTemperatura: " + temperatura + " °C";
    }
}

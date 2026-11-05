import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/** Widget informativo que muestra la hora de una zona horaria. */
public class WidgetReloj extends Widget {
    private final String zonaHoraria;

    public WidgetReloj(int id, String nombre, double memoriaKB,
                       String zonaHoraria) {
        super(id, nombre, memoriaKB);
        // Valida la zona horaria al construir el objeto.
        ZoneId.of(zonaHoraria);
        this.zonaHoraria = zonaHoraria;
    }

    @Override
    public String renderizar() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        String hora = ZonedDateTime.now(ZoneId.of(zonaHoraria)).format(formato);
        return "[RELOJ] " + getNombre() + " | Zona: " + zonaHoraria
                + " | Hora: " + hora;
    }

    @Override
    public String verConfiguracion() {
        return super.verConfiguracion() + "\nTipo: Reloj"
                + "\nZona horaria: " + zonaHoraria;
    }
}

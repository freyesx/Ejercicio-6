/** Clase base con la información común de todos los widgets. */
public abstract class Widget implements Renderizable, Comparable<Widget> {
    private final int id;
    private final String nombre;
    private final double memoriaKB;
    private boolean activo;

    public Widget(int id, String nombre, double memoriaKB) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (!Double.isFinite(memoriaKB) || memoriaKB < 0) {
            throw new IllegalArgumentException(
                    "La memoria debe ser un número válido no negativo.");
        }
        this.id = id;
        this.nombre = nombre.trim();
        this.memoriaKB = memoriaKB;
        this.activo = true;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMemoriaKB() {
        return memoriaKB;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String verConfiguracion() {
        return toString() + "\nEstado: " + (activo ? "Activo" : "Inactivo");
    }

    @Override
    public abstract String renderizar();

    /** Ordena por memoria y, en caso de empate, por ID. */
    @Override
    public int compareTo(Widget otro) {
        int resultado = Double.compare(this.memoriaKB, otro.memoriaKB);
        if (resultado == 0) {
            resultado = Integer.compare(this.id, otro.id);
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre
                + " | Memoria: " + memoriaKB + " KB";
    }
}

import java.util.Scanner;

/** Vista de consola y punto de entrada de la aplicación. */
public class Principal {
    private final ControladorDashboard controlador;
    private final Scanner entrada;

    public Principal(ControladorDashboard controlador) {
        this.controlador = controlador;
        this.entrada = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
        ControladorDashboard controlador = new ControladorDashboard(dashboard);
        Principal principal = new Principal(controlador);
        principal.ejecutar();
    }

    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            if (opcion == 1) {
                mostrarMensaje(controlador.listarActivos());
            } else if (opcion == 2) {
                mostrarMensaje("Ingresá el ID del widget:");
                int id = leerEntero();
                mostrarMensaje(controlador.consultarPorId(id));
            } else if (opcion == 3) {
                mostrarMensaje("Ingresá el nombre completo del widget:");
                String nombre = leerTexto();
                mostrarMensaje(controlador.consultarPorNombre(nombre));
            } else if (opcion == 4) {
                mostrarMensaje(controlador.ordenarWidgets());
            } else if (opcion == 5) {
                mostrarMensaje("Ingresá el ID del widget:");
                int id = leerEntero();
                mostrarMensaje(controlador.interactuarConWidget(id));
            } else if (opcion == 0) {
                mostrarMensaje("Programa finalizado.");
            } else {
                mostrarMensaje("Opción inválida. Elegí un número del 0 al 5.");
            }
        } while (opcion != 0);
        entrada.close();
    }

    public void mostrarMenu() {
        mostrarMensaje("\n========== DASHBOARD ==========");
        mostrarMensaje("1. Listar y renderizar widgets activos");
        mostrarMensaje("2. Buscar widget por ID");
        mostrarMensaje("3. Buscar widget por nombre");
        mostrarMensaje("4. Ordenar widgets por memoria");
        mostrarMensaje("5. Interactuar con un widget");
        mostrarMensaje("0. Salir");
        mostrarMensaje("Seleccioná una opción:");
    }

    public int leerOpcion() {
        return leerEntero();
    }

    private int leerEntero() {
        int numero = 0;
        boolean valido = false;
        while (!valido && entrada.hasNextLine()) {
            String texto = entrada.nextLine();
            try {
                numero = Integer.parseInt(texto.trim());
                valido = true;
            } catch (NumberFormatException e) {
                mostrarMensaje("Entrada inválida. Ingresá un número entero:");
            }
        }
        return numero;
    }

    private String leerTexto() {
        if (entrada.hasNextLine()) {
            return entrada.nextLine().trim();
        }
        return "";
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

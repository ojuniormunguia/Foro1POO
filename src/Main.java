import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Estudiante {
    private String Carnet;
    private String Nombre;

    public Estudiante(String Carnet, String Nombre) {
        this.Carnet = Carnet;
        this.Nombre = Nombre;
    }

    public String getCarnet() {
        return Carnet;
    }

    public String getNombre() {
        return Nombre;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, Estudiante> MapaDeEstudiantes = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido/a al sistema de estudiantes UDB VIRTUAL ");
            System.out.println("Elija una opción:");
            System.out.println("1. Agregar nuevo estudiante");
            System.out.println("2. Buscar estudiante por carnet");
            System.out.println("3. Borrar estudiante");
            System.out.println("4. Mostrar todos los estudiantes");
            System.out.println("5. Salir");
            int eleccion = scanner.nextInt();

            switch (eleccion) {
                case 1 -> { // Agregar nuevo estudiante
                    System.out.println("Escriba carnet de estudiante:");
                    String Carnet = scanner.next();
                    scanner.nextLine(); // Consume the newline character
                    if (MapaDeEstudiantes.containsKey(Carnet)) {
                        System.out.println("Ya hay un estudiante con este carnet");
                    } else {
                        System.out.println("Escriba nombre de estudiante:");
                        String Nombre = scanner.nextLine();

                        // Agrega carnet y estudiante
                        MapaDeEstudiantes.put(Carnet, new Estudiante(Carnet, Nombre));
                        System.out.println("Alumno ingresado exitosamente");
                    }
                }
                case 2 -> { // Buscar estudiante por carnet
                    System.out.print("Ingrese el carnet del alumno a buscar: ");
                    String buscador = scanner.next();
                    if (MapaDeEstudiantes.containsKey(buscador)) {
                        Estudiante estudiante = MapaDeEstudiantes.get(buscador);
                        System.out.println("Estudiante encontrado:");
                        System.out.println("Nombre: " + estudiante.getNombre());
                        System.out.println("Carnet: " + estudiante.getCarnet());
                    } else {
                        System.out.println("Alumno no encontrado, no se puede Mostrar");
                    }
                }
                case 3 -> { // Borrar estudiante
                    System.out.print("Ingrese el carnet del alumno a eliminar: ");
                    String BorrarCarnet = scanner.next();
                    if (MapaDeEstudiantes.containsKey(BorrarCarnet)) {
                        MapaDeEstudiantes.remove(BorrarCarnet); // Borra alumno
                        System.out.println("Alumno eliminado");
                    } else {
                        System.out.println("Alumno no encontrado, no se puede Eliminar");
                    }
                }

                case 4 -> { // Mostrar todos los estudiantes
                    System.out.println("Lista de estudiantes:");
                    for (Map.Entry<String, Estudiante> entry : MapaDeEstudiantes.entrySet()) {
                        String carnet = entry.getKey();
                        Estudiante estudiante = entry.getValue();
                        System.out.println("Carnet: " + carnet + ", Name: " + estudiante.getNombre());
                    }
                }

                case 5 -> { // Salir
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("ERROR: Elija un número del 1 al 5");
            }
        }
    }
}

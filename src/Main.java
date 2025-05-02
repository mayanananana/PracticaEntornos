import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Mascota> mascotas = new ArrayList<>();
    static Veterinaria veterinaria = new Veterinaria(mascotas);

    public static void main(String[] args) {

        cargaDatos();

        int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            //Mostrar menu de opciones
            menu();

            opcion= sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1:
                    // Lógica para registrar una nueva mascota
                    registrarMascota(sc);
                    break;
                case 2:
                    // Lógica para atender visita de una mascota
                    atenderMascota(sc);
                    break;
                case 3:
                    // Este caso no está en el menú proporcionado, pero puedes añadir funcionalidad aquí
                    vacunarMascota(sc);
                    break;
                case 4:
                    // Lógica para mostrar mascotas
                    mostrarMascotas();
                    break;
                case 5:
                    // Lógica para mostrar estadísticas generales
                    mostrarEstadisticas();
                    break;
                case 6:
                    // Lógica para salir del programa
                    System.out.println("Adios...");
                    break;
                    default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del 1 al 6.");
                    break;
            }


        } while(opcion!=6);


    }

    private static void mostrarEstadisticas() {
        int vacunados = 0;
        int totalVisitas = 0;
        for (Mascota m : mascotas) {
            if (m.isVacunado()) vacunados++;
            totalVisitas += m.getVisitas();
        }
        System.out.println("Vacunados: " + vacunados);
        System.out.println("Total visitas: " + totalVisitas);
    }

    private static void mostrarMascotas() {
        for (Mascota m: mascotas) {
            System.out.println(m);
        }
    }

    private static void vacunarMascota(Scanner sc) {
        Mascota mascotaVacunar= new Mascota();
        boolean vexiste = false;
        System.out.println("Ingrese el id de la mascota");
        int idMascotaVacunar = sc.nextInt();
        sc.nextLine();
        mascotaVacunar.setId(idMascotaVacunar);
        for (Mascota m : mascotas) {
            if (m.getId() == idMascotaVacunar) {
                vexiste = true;
                if(m.isVacunado()) {
                    System.out.println("La mascota ya esta vacunada");
                } else {
                    m.vacunar();
                    System.out.println("Mascota vacunada exitosamente");

                }
            }
        }

        if (!vexiste) {
            System.out.println("Esta mascota no esta registrada");
        }
    }

    private static void atenderMascota(Scanner sc) {
        Mascota mascotaAtender= new Mascota();
        boolean existe = false;
        System.out.println("Ingrese el id de la mascota");
        int idMascota = sc.nextInt();
        sc.nextLine();
        mascotaAtender.setId(idMascota);
        for (Mascota m : mascotas) {
            if (m.getId() == idMascota) {
                m.registrarVisita();
                existe = true;
                System.out.println("La mascota ha sido atendida exitosamente");
            }
        }

        if (!existe) {
            System.out.println("Esta mascota no esta registrada");
        }
    }

    private static void registrarMascota(Scanner sc) {
        Mascota nuevaMascota = new Mascota();

        System.out.println("Ingrese el nombre:");
        String nombre = sc.nextLine();
        nuevaMascota.setNombre(nombre);
        System.out.println("Ingrese la especie:");
        String especie = sc.nextLine();
        nuevaMascota.setEspecie(especie);
        System.out.println("Ingrese la edad:");
        int edad = sc.nextInt();
        sc.nextLine();
        nuevaMascota.setEdad(edad);
        System.out.println("¿Está vacunado? (true/false):");
        boolean vacunado = sc.nextBoolean();
        nuevaMascota.setVacunado(vacunado);

        // Crear una instancia de Mascota
        veterinaria.agregarMascota(nuevaMascota);

        // Imprimir la representación de la mascota
        System.out.println(nuevaMascota);
    }

    private static void menu() {
        System.out.println("1. Registrar nueva mascota");
        System.out.println("2. Atender visita de mascota");
        System.out.println("3. Vacunar mascota");
        System.out.println("4. Mostrar mascotas registradas");
        System.out.println("5. Mostrar estadisticas generales");
        System.out.println("6. Salir");
    }

    private static void cargaDatos() {
        mascotas.add(new Mascota("Firulais", 3, "Perro", true));
        mascotas.add(new Mascota("Miau", 2, "Gato", false));
        mascotas.add(new Mascota("Rex", 5, "Perro", true, 3));
        mascotas.add(new Mascota("Pelusa", 1, "Gato", false));
        mascotas.add(new Mascota("Rocky", 4, "Perro", true));
        mascotas.add(new Mascota("Luna", 3, "Conejo", false, 5));
        mascotas.add(new Mascota("Bella", 2, "Perro", true));
        mascotas.add(new Mascota("Simba", 6, "Gato", true, 2));
        mascotas.add(new Mascota("Toby", 7, "Perro", false));
        mascotas.add(new Mascota("Cleo", 4, "Gato", true, 4));
    }
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SistemaGestionLaboratorio {
    private ArrayList<IEquipo> catalogoEquipos;
    private Scanner scanner;


    public SistemaGestionLaboratorio() {
        this.catalogoEquipos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }


    public void cargarCatalogoInicial() {
        System.out.println("\n===========================");
        System.out.println("CARGANDO CATALOGO EQUIPO...");
        System.out.println("===========================");

        catalogoEquipos.add(new PenduloEcoder(
            "PEN-001", 
            "Péndulo Simple Motorizado", 
            "PASCO Scientific", 
            45.5,
            "Péndulo con control automático de amplitud y medición angular precisa",
            1.2,
            "Última calibración: 15/03/2024 - Certificado CAL-2024-089",
            2400
        ));

        catalogoEquipos.add(new FotoCompuerta(
            "FOT-002",
            "Fotocompuerta Digital ME-9204A",
            "PASCO Scientific",
            12.0,
            "Sistema de detección óptica para experimentos de cinemática",
            5.0,
            "Calibración verificada el 20/02/2024",
            0.5
        ));

        catalogoEquipos.add(new Osciloscopio(
            "OSC-003",
            "Osciloscopio Digital TDS2024C",
            "Tektronix",
            150.0,
            "Osciloscopio de 4 canales con pantalla a color y almacenamiento USB",
            4,
            200.0,
            2.0,
            "USB/GPIB"
        ));

        catalogoEquipos.add(new GeneradorSenales(
            "GEN-004",
            "Generador de Funciones AFG1022",
            "Tektronix",
            75.0,
            "Generador de señales arbitrarias de alta precisión",
            2,
            25.0,
            "USB/LAN",
            "Senoidal, Cuadrada, Triangular, Rampa, Pulso, Arbitraria"
        ));

        catalogoEquipos.add(new SimuladorMovimiento(
            "SIM-005",
            "Simulador PhysLab 3D Pro",
            "Virtual Physics Lab",
            250.0,
            "Simulación de sistemas mecánicos con física realista en tiempo real",
            "Mecánica Clásica, Colisiones, Sistemas de Partículas",
            "v4.2.1",
            "GPU dedicada 4GB VRAM, 16GB RAM",
            true
        ));
        
        catalogoEquipos.add(new SimuladorCircuitos(
            "SIM-006",
            "CircuitLab Advanced",
            "Electronic Workbench Inc",
            180.0,
            "Simulador SPICE profesional con análisis en frecuencia y tiempo",
            "Análisis AC/DC/Transitorio",
            "v8.5.3",
            "8GB RAM, CPU multi-core",
            5000
        ));

        catalogoEquipos.add(new Multimetro(
            "MUL-007",
            "Multímetro Digital Fluke 287",
            "Fluke Corporation",
            8.0,
            "Multímetro de banco con registro de datos y conectividad PC",
            2,
            100.0,
            "USB/Bluetooth",
            "200mV - 1000V AC/DC",
            0.025
        ));
        
        catalogoEquipos.add(new AnalizadorEspectros(
            "ANE-008",
            "Analizador de Espectro RSA306B",
            "Tektronix",
            95.0,
            "Analizador en tiempo real con visualización espectrograma",
            1,
            6200.0,
            "USB 3.0",
            9000.0,
            6.2
        ));

        catalogoEquipos.add(new SensorTemperatura(
            "SEN-009",
            "Termopar Tipo K de Respuesta Rápida",
            "Omega Engineering",
            5.0,
            "Sensor de temperatura de alta precisión para mediciones rápidas",
            1200.0,
            "Certificado NIST - Última calibración: 01/04/2024",
            "Termopar Tipo K (Cromel-Alumel)"
        ));
        
        catalogoEquipos.add(new BalanzaPrecision(
            "BAL-010",
            "Balanza Analítica Pioneer PX225D",
            "OHAUS Corporation",
            25.0,
            "Balanza de precisión con protección contra corrientes de aire",
            0.01,
            "Calibración interna automática - Verificada 10/03/2024",
            0.220
        ));


        System.out.println("Se han cargado " + catalogoEquipos.size() + " equipos al catálogo.");
        System.out.println("Sistema listo para operar.\n");
    }


    //Opcion 1: Visualizar catálogo completo
    private void visualizarCatalogoCompleto() {
        System.out.println("\n----------------------------");
        System.out.println("CATALOGO COMPLETO DE EQUIPOS");
        System.out.println("----------------------------");

       for (IEquipo equipo : catalogoEquipos) {
            System.out.println("ID: " + equipo.getIdentificador());
            System.out.println("Nombre: " + equipo.getNombre());
            System.out.println("Tipo: " + equipo.getTipo());
            System.out.println("Fabricante: " + equipo.getFabricante());
            System.out.println("Consumo eléctrico: " + equipo.getConsumoElectrico() + " W");
            System.out.println("Características: " + equipo.getCaracteristicas());
            System.out.println("-----------------------------------------------------------------------------------");
        }
        
        System.out.println("\nTotal de equipos: " + catalogoEquipos.size());
    }


    //Opcion 2: consultar equipo específico
    private void consultarEquipoEspecifico() {
        System.out.println("\n-----------------------------");
        System.out.println("CONSULTA DE EQUIPO ESPECIFICO");
        System.out.println("-----------------------------");

        System.out.print("Ingrese el ID o nombre del equipo: ");
        String criterio = scanner.nextLine().trim();
        
        IEquipo equipoEncontrado = null;
        
        for (IEquipo equipo : catalogoEquipos) {
            if (equipo.getIdentificador().equalsIgnoreCase(criterio) ||
                equipo.getNombre().toLowerCase().contains(criterio.toLowerCase())) {
                equipoEncontrado = equipo;
                break;
            }
        }

        if (equipoEncontrado != null) {
            System.out.println("\n" + equipoEncontrado.obtenerDetalleCompleto());
        } else {
            System.out.println("\nNo se encontró ningún equipo con ese criterio de búsqueda.");
        }
    }


    //Opcion 3: Ordenar por consumo eléctrico
    private void ordenarPorConsumo() {
        System.out.println("\n----------------------------------");
        System.out.println("Ordenamiento por consumo eléctrico");
        System.out.println("----------------------------------");

        System.out.println("1. Ordenar de menor a mayor consumo (Eficiencia)");
        System.out.println("2. Ordenar de mayor a menor consumo (Prioridad)");
        System.out.print("Seleccione tipo de ordenamiento: ");
        
        int tipo = scanner.nextInt();
        scanner.nextLine();

        ArrayList<IEquipo> catalogoOrdenado = new ArrayList<>(catalogoEquipos);
        
        if (tipo == 1) {
            catalogoOrdenado.sort(Comparator.comparingDouble(IEquipo::getConsumoElectrico));
            System.out.println("\nEquipos ordenados de MENOR a MAYOR consumo (uso eficiente):\n");
        } else if (tipo == 2) {
            catalogoOrdenado.sort(Comparator.comparingDouble(IEquipo::getConsumoElectrico).reversed());
            System.out.println("\nEquipos ordenados de MAYOR a MENOR consumo (prioridad de recursos):\n");
        } else {
            System.out.println("\nOpción no válida.");
            return;
        }
        
        int posicion = 1;
        double consumoTotal = 0.0;
        
         for (IEquipo equipo : catalogoOrdenado) {
            System.out.println("Posición #" + posicion++);
            System.out.println("ID: " + equipo.getIdentificador());
            System.out.println("Nombre: " + equipo.getNombre());
            System.out.println("Consumo eléctrico: " + equipo.getConsumoElectrico() + " W");
            System.out.println("-----------------------------------------------------------------------------------");
            consumoTotal += equipo.getConsumoElectrico();
        }

        System.out.println("\nCONSUMO TOTAL DEL LABORATORIO: " + consumoTotal + " W (" + (consumoTotal / 1000) + " kW)");
    }


    //Menú principal
    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n===========================================================");
            System.out.println("|  SISTEMA DE GESTION DE EQUIPOS - LABORATORIO DE FISICA  |");
            System.out.println("===========================================================");
            System.out.println("|  1. Ver catálogo completo de equipos  |");
            System.out.println("|  2. Consultar equipo específico       |");
            System.out.println("|  3. Ordenar por consumo eléctrico     |");
            System.out.println("|  4. Salir                             |");
            System.out.println("=========================================");
            System.out.println("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion) {
                case 1:
                    visualizarCatalogoCompleto();
                    break;
                case 2:
                    consultarEquipoEspecifico();
                    break;
                case 3:
                    ordenarPorConsumo();
                    break;
                case 4:
                    System.out.println("Cerrando sistema...");
                    break;
                default:
                    System.out.println("Escoja una opción válida.");
            }

        } while (opcion != 4);
    }


    public void iniciar() {
        cargarCatalogoInicial();
        mostrarMenu();
        scanner.close();
    }
}

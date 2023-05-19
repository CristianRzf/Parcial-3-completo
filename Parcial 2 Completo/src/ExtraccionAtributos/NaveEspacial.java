package ExtraccionAtributos;

import java.util.Scanner;

public abstract class NaveEspacial {
	private String nombre;
	private int capaciaDePersonas;
	private int peso;
	private int velocidadMax;
	private String[] misiones;

		// Método abstracto para imprimir información de la nave
		public abstract void mostrarInformacion();
	}

	// Clase NaveEspacial que hereda de Nave
	class NaveEspacial extends Nave {
		private int numMotores;

		public NaveEspacial(String nombre, int capacidad, double velocidad, int numMotores) {
			super(nombre, capacidad, velocidad);
			this.numMotores = numMotores;
		}

		// Implementación del método abstracto mostrarInformacion
		public void mostrarInformacion() {
			System.out.println("Nave Espacial: " + nombre);
			System.out.println("Capacidad: " + capacidad + " tripulantes");
			System.out.println("Velocidad: " + velocidad + " km/h");
			System.out.println("Número de Motores: " + numMotores);
			System.out.println("------------------------");
		}
	}

	// Clase NaveNoTripulada que hereda de Nave
	class NaveNoTripulada extends Nave {
		// Atributos específicos de NaveNoTripulada
		private String proposito;

		// Constructor de la clase NaveNoTripulada
		public NaveNoTripulada(String nombre, int capacidad, double velocidad, String proposito) {
			super(nombre, capacidad, velocidad);
			this.proposito = proposito;
		}

		public void mostrarInformacion() {
			System.out.println("Nave No Tripulada: " + nombre);
			System.out.println("Capacidad: " + capacidad + " kg");
			System.out.println("Velocidad: " + velocidad + " km/h");
			System.out.println("Propósito: " + proposito);
		}
	}

	public class Main {
		public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Crear arreglo de tamaño fijo para almacenar las naves
	        Nave[] inventario = new Nave[9];

	        inventario[0] = new NaveEspacial("Nave A", 5, 10000, 3);
	        inventario[1] = new NaveEspacial("Nave B", 10, 8000, 4);
	        inventario[2] = new NaveEspacial("Nave C", 8, 12000, 2);
	        inventario[3] = new NaveNoTripulada("Nave X", 200, 50000, "Exploración planetaria");
	        inventario[4] = new NaveNoTripulada("Nave Y", 150, 60000, "Investigación cient
	        		ífica");
	                inventario[5] = new NaveNoTripulada("Nave Z", 300, 45000, "Suministro de recursos");

	                System.out.println("Ingrese el nombre de la nave que desea buscar:");
	                String nombreBusqueda = scanner.nextLine();
	                buscarNave(nombreBusqueda, inventario);

	                // Ejecución infinita hasta que el usuario decida terminar el programa
	                boolean terminarPrograma = false;
	                while (!terminarPrograma) {
	                    System.out.println("¿Desea agregar una nueva nave? (Sí/No)");
	                    String respuesta = scanner.nextLine();
	                    if (respuesta.equalsIgnoreCase("Sí")) {
	                        // Lógica para crear y agregar una nueva nave al inventario
	                        System.out.println("Ingrese el tipo de nave (Espacial/NoTripulada):");
	                        String tipoNave = scanner.nextLine();
	                        System.out.println("Ingrese el nombre de la nave:");
	                        String nombreNave = scanner.nextLine();
	                        System.out.println("Ingrese la capacidad de la nave:");
	                        int capacidadNave = scanner.nextInt();
	                        System.out.println("Ingrese la velocidad de la nave:");
	                        double velocidadNave = scanner.nextDouble();
	                        scanner.nextLine(); // Limpiar el buffer de lectura

	                        if (tipoNave.equalsIgnoreCase("Espacial")) {
	                            System.out.println("Ingrese el número de motores:");
	                            int numMotores = scanner.nextInt();
	                            scanner.nextLine(); // Limpiar el buffer de lectura

	                            inventario[6] = new NaveEspacial(nombreNave, capacidadNave, velocidadNave, numMotores);
	                        } else if (tipoNave.equalsIgnoreCase("NoTripulada")) {
	                            System.out.println("Ingrese el propósito de la nave:");
	                            String proposito = scanner.nextLine();

	                            inventario[6] = new NaveNoTripulada(nombreNave, capacidadNave, velocidadNave, proposito);
	                        }

	                        System.out.println("Nave agregada al inventario.");
	                        System.out.println("------------------------");
	                    } else if (respuesta.equalsIgnoreCase("No")) {
	                        terminarPrograma = true;
	                        System.out.println("Programa finalizado.");
	                    } else {
	                        System.out.println("Respuesta inválida. Por favor, ingrese 'Sí' o 'No'.");
	                    }
	                }
	            }

		public void buscarNave(String nombre, Nave[] inventario) {
			boolean naveEncontrada = false;

			for (Nave nave : inventario) {
				if (nave != null && nave.nombre.equalsIgnoreCase(nombre)) {
					nave.mostrarInformacion();
					naveEncontrada = true;
					break;
				}
			}

			if (naveEncontrada) {
				System.out.println("No se encontró una nave con ese nombre en el inventario.");
			}
		}
	}
}

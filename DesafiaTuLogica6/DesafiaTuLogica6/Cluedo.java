package DesafiaTuLogica6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Cluedo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Creación del ArrayList:
		List<Jugador> cartas = new ArrayList<>();

		// Inicia el juego del Cluedo y muestra un mensaje de bienvenida.

		System.out.println("¡Bienvenido!\n"
				+ "Este juego barajará de forma aleatoria las cartas para jugar al Cluedo.\n" + "Comencemos:");
		/*
		 * Arrays unidimensionales a. Para almacenar el nombre de los personajes b. Para
		 * almacenar el nombre de las armas c. Para almacenar el nombre de los lugares o
		 * habitaciones
		 */
		String[] personajesArray = { "Amapola", "Celeste", "Prado", "Mora", "Rubio", "Blanco" };
		String[] armasArray = { "bate", "pistola", "candelabro", "cuchillo", "cuerda", "hacha", "pesa", "veneno",
				"trofeo" };
		String[] habitacionesArray = { "casa de invitados", "teatro", "spa", "observatorio", "comedor", "terraza",
				"salón", "cocina", "vestibulo" };
		// Recorre el array de personajes y muestra cada uno de ellos.
		System.out.println("\nListado de personajes:");
		System.out.println("-------------------------");
		for (String personaje : personajesArray) {
			System.out.println(personaje);
		}
		// Recorre el array de armas y muestra cada una de ellas.
		System.out.println("\nListado de armas:");
		System.out.println("---------------------");
		for (String arma : armasArray) {
			System.out.println(arma);
		}
		// Recorre el array de habitaciones y muestra cada una de ellas.
		System.out.println("\nListado de habitaciones:");
		System.out.println("----------------------");
		for (String habitacion : habitacionesArray) {
			System.out.println(habitacion);
		}
		String fin = "";
		do {
			String respuesta2;
			try {
				do {
					// Preguntar al jugador si quiere añadir algún elemento más:
					System.out.println("\n¿Quiere añadir algo más?(Si/No)");
					String respuesta = scanner.nextLine();

					/*
					 * Lee la respuesta y nos muestra el menú para añadir lo que queramos o en otro
					 * caso continuar. Si el jugador contesta que si entra en el if, si no continúa
					 * en el else.
					 */

					if (respuesta.equalsIgnoreCase("si")) {
						System.out.println("Menú para añadir más información:\n");
						System.out.println("1.Personaje.\n" + "2.Arma.\n" + "3.Habitación.\n" + "4.Salir.\n");
						System.out.println("Opción elegida:\n");
						int opcion = scanner.nextInt();
						scanner.nextLine();
						// Según la opción elegida, el jugador puede elegir cantidad y nombre.
						switch (opcion) {
						case 1: {
							// Código para añadir personajes.
							System.out.println("¿Cuántos personajes desea añadir?");
							int num = scanner.nextInt();
							// Actualización del array con los personajes que desea añadir.
							personajesArray = actualizarArray(personajesArray, num);
							scanner.nextLine();
							for (int i = personajesArray.length - num; i < personajesArray.length; i++) {
								System.out.println("\nIntroduce nombre del personaje: ");
								String introDato = scanner.nextLine();
								personajesArray[i] = introDato;
							}
							// Visualizar datos del nuevo array:
							System.out
									.println("Array de personajes actualizado:\n " + Arrays.toString(personajesArray));
							break;
						}
						case 2: {
							// Código para añadir armas.
							System.out.println("¿Cuántas armas desea añadir?");
							int num = scanner.nextInt();
							// Actualización del array con las armas que desea añadir.
							armasArray = actualizarArray(armasArray, num);
							scanner.nextLine();
							for (int i = armasArray.length - num; i < armasArray.length; i++) {
								System.out.println("\nIntroduce las armas: ");
								String introDato = scanner.nextLine();
								armasArray[i] = introDato;
							}
							// Visualizar datos del nuevo array.
							System.out.println("Array de armas actualizado:\n " + Arrays.toString(armasArray));
							break;
						}
						case 3: {
							// Código para añadir habitaciones.
							System.out.println("¿Cuántas habitaciones desea añadir?");
							int num = scanner.nextInt();
							// Actualización del array con habitaciones que desea añadir.
							habitacionesArray = actualizarArray(habitacionesArray, num);
							scanner.nextLine();
							for (int i = habitacionesArray.length - num; i < habitacionesArray.length; i++) {
								System.out.println("\nIntroduce las habitaciones:\n");
								String introDato = scanner.nextLine();
								habitacionesArray[i] = introDato;
							}
							// Visualizar datos del nuevo array.
							System.out.println(
									"Array de habitaciones actualizado:\n " + Arrays.toString(habitacionesArray));
							break;
						}
						case 4: {
							// Última elección por si el jugador no quiere añadir nada.
							System.out.println("Saliendo del menú de elección");
							break;
						}
						default:
							System.out.println("Opción no válida");
						}
						// Vuelve a preguntar si desea seguir añadiendo.
						System.out.println("\n¿Desea continuar añadiendo?(Si/No)");
						respuesta2 = scanner.nextLine();

						// Continua el juego si la respuesta del jugador es no
					} else if (respuesta.equalsIgnoreCase("no")) {
						System.out.println("¡Genial,Sigamos!");
						respuesta2 = "no";

					} else {
						System.out.println("Respuesta no válida.Por favor escriba Si o No");
						respuesta2 = "no";
					}

				} while (respuesta2.equalsIgnoreCase("si"));
				// Controlar la posible excepción.
			} catch (InputMismatchException e) {
				System.out.println("Error, se ha producido una excepción: " + e.getMessage());
				scanner.nextLine();
			}
			// Mensaje para explicar que continuamos el juego.
			System.out.println("\n¡Continuemos!Vamos a barajar las cartas:\n");
			System.out.println("Barajando cartas...");

			// Barajar los arrays.
			barajarCartas(personajesArray);
			barajarCartas(armasArray);
			barajarCartas(habitacionesArray);

			// Método Random para que se baraje de forma aleatoria.
			Random rand = new Random();
			int indice = rand.nextInt(personajesArray.length);

			Jugador jugador = new Jugador(personajesArray[indice], armasArray[indice], habitacionesArray[indice]);
			cartas.add(jugador);

			/*
			 * Se imprime mensaje para que el jugador escriba una clave si esta es correcta,
			 * se muestran las cartas si no, se indicará con un mensaje y se preguntará si
			 * desea una nueva combinación.
			 */
			try {
				System.out.println("Si introduces la clave correcta te puedo mostrar quién"
						+ " ha sido el culpable, el arma y donde...\n");
				System.out.println("Introduce la clave\n");
				int clave = scanner.nextInt();
				int claveoculta = 123;
				if (claveoculta == clave) {
					System.out.println("¡Cartas ganadoras!.\nLa combinación de cartas es:\n" + "Personaje:"
							+ personajesArray[indice] + "\nArma:" + armasArray[indice] + "\nHabitación:"
							+ habitacionesArray[indice]);
				} else {
					System.out.println("Lo siento, la clave no es correcta.No tiene permiso para ver las cartas\n");
				}
				scanner.nextLine();
				// Se pregunta si desea crear una nueva combinación o salir
				System.out.println("¿Quieres crear una nueva combinación o salir?(s para continuar)");
				fin = scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Error al leer la clave, debe de ser numérica.");
			}

		} while (fin.equalsIgnoreCase("s"));

		scanner.close();
		// Si el jugador no pulsa "s", el juego se guardará en un fichero.
		if (!"s".equals(fin)) {
			System.out.println("**Guardando fichero**");
			// Método para guardar las combinaciones.
			guardarCombinaciones(cartas);

		}
	}

	public static String[] actualizarArray(String[] arrayAntiguo, int num) {
		// método que recibe un array y crea uno nuevo con más elementos.
		String[] arrayNuevo = new String[arrayAntiguo.length + num];

		// Copiando elementos antiguos al nuevo array.

		System.arraycopy(arrayAntiguo, 0, arrayNuevo, 0, arrayAntiguo.length);

		// Imprimir el nuevo array.
		// System.out.println("Nuevo array: " + Arrays.toString(arrayNuevo));
		return arrayNuevo;

	}

	// Método para barajar las carta de forma aleatoria.
	public static void barajarCartas(String[] cartas) {
		Random rand = new Random();
		for (int i = cartas.length - 1; i > 0; i--) {
			int j = rand.nextInt(i + 1);
			// Intercambiar elementos
			String temp = cartas[i];
			cartas[i] = cartas[j];
			cartas[j] = temp;
		}
	}

	/*
	 * Método para guardar la partida en un archivo, el cual contendrá la hora y las
	 * combinaciones creadas durante toda la partida.
	 */
	public static void guardarCombinaciones(List<Jugador> combinaciones) {
		String nombreArchivo = "datosPartidaCluedo.txt";
		try {
			PrintWriter writer = new PrintWriter(nombreArchivo);

			writer.println("Combinaciones:");
			for (Jugador jugador : combinaciones) {
				writer.println(jugador);
			}
			System.out.println("Datos guardados exitosamente en " + nombreArchivo);
			System.out.println("¡Adiós. Nos vemos pronto!");
			writer.close();
		} catch (IOException e) {
			System.err.println("Error al guardar las combinaciones de cartas");
		}
	}

}

package ui; // No olvidar especificar el paquete / carpeta de nuestro programa

import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {

	// Declaración del Escaner que nos ayudará en todo el programa
	private Scanner escaner;

	// Declaración de nuestras constantes a utilizar
	final static int MAXIMOJUGADORES = 10;
	final static int MAXIMORONDAS = 5;

	private AtlasPuntuaciones() {
		escaner = new Scanner(System.in);
	}
	
	
	public void run(){
		
		int numJugadores = 0;
		System.out.println("Ingresar cantidad de jugadores:");
		numJugadores = escaner.nextInt();

		int numRondas = 0;
		System.out.println("Ingresar la cantidad de rondas:");
		numRondas = escaner.nextInt();
			

		//Arreglos
		int[] jugadores = new int[numJugadores];
		double[] promedioJugadores = new double[numJugadores];

		calcularSumaTotal(numJugadores, numRondas, jugadores);
		calcularPromedio(numJugadores, numRondas, jugadores, promedioJugadores);
		encontrarMayor(numJugadores, jugadores);

	}

	public static void main(String[] args) {
		AtlasPuntuaciones mainApp = new AtlasPuntuaciones();
		mainApp.run();
	}

	

	/**
	 * Descripción: El método calcularSumaTotal permite sumar el total de puntajes de cada jugador.
	 * @param int cantidadJugadores La cantidad total de jugadores en la partida.
	 * @param int cantidadRondas La cantidad de rondas que se jugaran durante la partida.
	 * @param [] jugadores Un arreglo donde se almacena el total de puntajes de cada jugador.
	 * @return Retorna la informacion de cada jugador.
	 */
	public void calcularSumaTotal(int cantidadJugadores, int cantidadRondas, int[] jugadores) {
		for (int i = 0; i < cantidadJugadores; i++) {
			jugadores[i] = 0; 
	
			for (int j = 1; j <= cantidadRondas; j++) {
				int puntaje = 0;
				boolean flag = true;
	
				while (flag) {
					System.out.println("Jugador " + (i + 1) + " - Puntaje de la ronda " + j + ":");
					puntaje = escaner.nextInt();
	
					if (puntaje >= 0 && puntaje <= 100) {
						flag = false; 
					} else {
						System.out.println("Puntaje inválido. Ingrese un valor entre 0 y 100.");
					}
				}
	
				jugadores[i] += puntaje; 
			}
		}
	}
	
	   

	/**
	 * Descripción: El método calcularPromedio permite sacar el promedio de puntajes de cada jugador durante la partida.
	 * @param int cantidadJugadores La cantidad total de jugadores en la partida.
	 * @param int cantidadRondas La cantidad de rondas que se jugaran durante la partida.
	 * @param [] jugadores Un arreglo donde se almacena el total de puntajes de cada jugador.
	 * @param [] promedioJugadores Es el arreglo donde se almacena los promedios de cada jugador.
	 * @return El promedio del puntaje de los jugadores a lo largo de la partida.
	 */
	public void calcularPromedio(int cantidadJugadores, int cantidadRondas, int[] jugadores, double[] promedioJugadores) {
		System.out.println("Promedio jugadores");
		for (int i = 0; i < cantidadJugadores; i++) {
			promedioJugadores[i] = (double) jugadores[i] / cantidadRondas; // Calcula el promedio
			System.out.println("Jugador " + (i + 1) + " - Promedio: " + promedioJugadores[i]);
		}
	}
	

	/**
	 * Descripción: El método encontrarMayor permite encontrar el jugador con la cantidad maxima de puntajes.
	 * @param int cantidadJugadores La cantidad total de jugadores en la partida.
	 * @param [] jugadores Un arreglo donde se almacena el total de puntajes de cada jugador.
	 * @return El jugador con mayor puntaje.
	 */
  	
	 public void encontrarMayor(int cantidadJugadores, int[] jugadores) {
		int maxPuntaje = jugadores[0];
		int jugadorMax = 1;

		for(int i = 1; i< cantidadJugadores; i++){
			if(jugadores[i]> maxPuntaje){
				maxPuntaje = jugadores[i];
				jugadorMax = i + 1 ;
			}
		}
        
		System.out.println("El jugador con el puntaje mas alto es: " + jugadorMax + " con "+ maxPuntaje + ".");
    }

	

	
}
package operadoresLogicos;

public class IfSwitch1 {

	/*
	 * 1. Crea un programa que dado el valor de una variable numérica entre 1 y 12
	 * imprima el valor textual del mes con el que se corresponde, en caso de que el
	 * número no sea ninguno de ellos imprimirá no entiendo. 1. Hazlo primero
	 * utilizando sentencias if - else 2. Hazlo a continuación utilizando sentencia
	 * switch
	 */
	
	public static void main(String[] args) {
		
		int numeroMes = 1;
		
		if (numeroMes == 1)
			System.out.println("Es enero");
		else if (numeroMes == 2)
			System.out.println("Es febrero");
		else if (numeroMes == 3)
			System.out.println("Es marzo");
		else if (numeroMes == 4)
			System.out.println("Es abril");
		else if (numeroMes == 5)
			System.out.println("Es mayo");
		else if (numeroMes == 6)
			System.out.println("Es junio");
		else if (numeroMes == 7)
			System.out.println("Es julio");
		else if (numeroMes == 8)
			System.out.println("Es agosto");
		else if (numeroMes == 9)
			System.out.println("Es septiembre");
		else if (numeroMes == 10)
			System.out.println("Es octubre");
		else if (numeroMes == 11)
			System.out.println("Es noviembre");
		else if (numeroMes == 12)
			System.out.println("Es diciembre");
		else
			System.out.println("No entiendo");
		
		switch (numeroMes) {
		case 1:
			System.out.println("Es enero");
			break;
		case 2:
			System.out.println("Es febrero");
			break;
		case 3:
			System.out.println("Es marzo");
			break;
		case 4:
			System.out.println("Es abril");
			break;
		case 5:
			System.out.println("Es mayo");
			break;
		case 6:
			System.out.println("Es junio");
			break;
		case 7:
			System.out.println("Es julio");
			break;
		case 8:
			System.out.println("Es agosto");
			break;
		case 9:
			System.out.println("Es septiembre");
			break;
		case 10:
			System.out.println("Es octubre");
			break;
		case 11:
			System.out.println("Es noviembre");
			break;
		case 12:
			System.out.println("Es diciembre");
			break;
		default:
			System.out.println("No entiendo");
			break;
		}
		
	}
	
}

package operadoresLogicos;

public class IfSwitch2 {

	public static void main(String[] args) {
		/*
		 * Crea otro programa que dado el valor de una variable texto con el valor de un
		 * nombre de mes imprima el valor del mes con el que corresponde, en caso de que
		 * el valor no coincida imprimirá un 0 (debe estar escrito con la primera y
		 * mayúsculas y resto en minúsculas).
		 */

		String numeroMes = "Enero";

		if (numeroMes == "Enero")
			System.out.println("Es el primer mes");
		else if (numeroMes == "Febrero")
			System.out.println("Es el segundo mes");
		else if (numeroMes == "Marzo")
			System.out.println("Es el tercer mes");
		else if (numeroMes == "Abril")
			System.out.println("Es el cuarto mes");
		else if (numeroMes == "Mayo")
			System.out.println("Es el quinto mes");
		else if (numeroMes == "Junio")
			System.out.println("Es el sexto mes");
		else if (numeroMes == "Julio")
			System.out.println("Es el septimo mes");
		else if (numeroMes == "Agosto")
			System.out.println("Es el octavo mes");
		else if (numeroMes == "Septiembre")
			System.out.println("Es el noveno mes");
		else if (numeroMes == "Octubre")
			System.out.println("Es el decimo mes");
		else if (numeroMes == "Noviembre")
			System.out.println("Es el oncevado mes");
		else if (numeroMes == "Diciembre")
			System.out.println("Es el doceavo mes");
		else
			System.out.println("No entiendo");

		switch (numeroMes) {
		case "Enero":
			System.out.println("Es el primer mes");
			break;
		case "Febrero":
			System.out.println("Es el segundo mes");
			break;
		case "Marzo":
			System.out.println("Es el tercer mes");
			break;
		case "Abril":
			System.out.println("Es el cuarto mes");
			break;
		case "Mayo":
			System.out.println("Es el quinto mes");
			break;
		case "Junio":
			System.out.println("Es el sexto mes");
			break;
		case "Julio":
			System.out.println("Es el septimo mes");
			break;
		case "Agosto":
			System.out.println("Es el octavo mes");
			break;
		case "Septiembre":
			System.out.println("Es el noveno mes");
			break;
		case "Octubre":
			System.out.println("Es el decimo mes");
			break;
		case "Noviembre":
			System.out.println("Es el oncevado mes");
			break;
		case "Diciembre":
			System.out.println("Es el doceavo mes");
			break;
		default:
			System.out.println("No entiendo");
			break;
		}
	}

}

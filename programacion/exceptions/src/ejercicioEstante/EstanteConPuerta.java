package ejercicioEstante;

import java.util.Arrays;

public class EstanteConPuerta {

	private int numberOfSlots;
	private String[] slots;
	private boolean doorOpen;
	private boolean doorBroken;

	public EstanteConPuerta(int numberOfSlots) throws BadNumberOfSlotsException {
		if (numberOfSlots < 1 || numberOfSlots > 10)
			throw new BadNumberOfSlotsException("No puedes crear un estante con ese número de slots");
		this.numberOfSlots = numberOfSlots;
		slots = new String[numberOfSlots];
	}

	public void breakDoor() {
		doorBroken = true;
	}

	public void openDoor() throws EstanteConPuertaOutOfOrderException {
		if (!doorOpen && !doorBroken)
			doorOpen = true;
		if (doorBroken)
			throw new EstanteConPuertaOutOfOrderException("La puerta esta rota");
	}

	public void closeDoor() throws EstanteConPuertaOutOfOrderException {
		if (doorOpen && !doorBroken)
			doorOpen = true;
		if (doorBroken)
			throw new EstanteConPuertaOutOfOrderException("La puerta esta rota");
	}

	public void addString(String s) throws EstanteConPuertaOutOfOrderException, NoMoreSpaceException {
		if (doorBroken)
			throw new EstanteConPuertaOutOfOrderException("La puerta esta rota");
		openDoor();
		int posicionLibre = Arrays.asList(slots).indexOf(null);
		if (posicionLibre != -1) {
			slots[posicionLibre] = s;
			closeDoor();
		} else {
			closeDoor();
			throw new NoMoreSpaceException("No hay hueco en el array");
		}
			
			
	}

	public static void main(String[] args) {

		try {
			EstanteConPuerta e1 = new EstanteConPuerta(25);
		} catch (BadNumberOfSlotsException e) {
			System.out.println(e.getMessage());
		}
		
		EstanteConPuerta e2 = null;
		
		try {
			e2 = new EstanteConPuerta(5);

		} catch (BadNumberOfSlotsException e) {
			System.out.println(e.getMessage());
		}
		
		for (int i = 0 ; i < 5 ; i++) {
			try {
				e2.addString("hola");
				System.out.println("Palabra añadida correctamente");
			} catch (EstanteConPuertaOutOfOrderException | NoMoreSpaceException e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("Aqui peta");
		
		try {
			e2.addString("Adios");
		} catch (EstanteConPuertaOutOfOrderException | NoMoreSpaceException e) {
			System.out.println(e.getMessage());
		}
		
		EstanteConPuerta e3 = null;
		
		try {
			e3 = new EstanteConPuerta(4);
		} catch (BadNumberOfSlotsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			e3.addString("Hola");
		} catch (EstanteConPuertaOutOfOrderException | NoMoreSpaceException e) {
			System.out.println(e.getMessage());
		}
		
		e3.doorBroken = true;
		
		try {
			e3.addString("Hola");
		} catch (EstanteConPuertaOutOfOrderException | NoMoreSpaceException e) {
			System.out.println(e.getMessage());
		}
	}
}

package psp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunLanzabolas {
	
	public static void main(String[] args) {

        // Crear un ExecutorService con un pool fijo de 3 hilos
        ExecutorService executor1 = Executors.newFixedThreadPool(3);
        ExecutorService executor2 = Executors.newFixedThreadPool(1);
        ExecutorService executor3 = Executors.newFixedThreadPool(9);

        // Crear instancias de Lanzabolas
        Lanzabolas lanzador1 = new Lanzabolas("Lanzador1");
        Lanzabolas lanzador2 = new Lanzabolas("Lanzador2");
        Lanzabolas lanzador3 = new Lanzabolas("Lanzador3");

        
       System.out.println("Pool fijo de 3 con 3 tareas");
        // Ejecutar las instancias de Lanzabolas usando el ExecutorService1
        executor1.execute(lanzador1);
        executor1.execute(lanzador2);
        executor1.execute(lanzador3);

        
        System.out.println("Pool fijo de 1 con 9 tareas");
        // Ejecutar las instancias de Lanzabolas usando el ExecutorService2
        for(int i = 0; i < 3; i++) {
	        executor2.execute(lanzador1);
	        executor2.execute(lanzador2);
	        executor2.execute(lanzador3);
        }
        
        System.out.println("Pool fijo de 9 con 9 tareas");
        // Ejecutar las instancias de Lanzabolas usando el ExecutorService2
        for(int i = 0; i < 3; i++) {
	        executor3.execute(lanzador1);
	        executor3.execute(lanzador2);
	        executor3.execute(lanzador3);
        }
        
        // Iniciar el proceso de apagado del ExecutorService
        executor1.shutdown();
        executor2.shutdown();
        executor3.shutdown();
}
}

package psp;

	public class CountDown implements Runnable {
		private static final long milis = 1000;
		private int start;
		private String name;

		public CountDown(String name, int start) {
			this.start = start;
			this.name = name;
		}

		@Override
		public void run() {
			for (int i = start; i >= 0; i--) {
				System.out.printf("%s: %d%n", name, i);
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
		
		public static void main(String[] args) {
			CountDown c1 = new CountDown("C1", 10);
			Thread thread = new Thread(c1);

	        // Estado NEW: hilo creado pero no arrancado
	        System.out.printf("%s - Estado: %s%n", thread.getName(),thread.getState());
	        thread.start();
	        
	        // Estado RUNNABLE: hilo arrancado pero puede estar o no funcionando
	        System.out.printf("%s - Estado: %s%n", thread.getName(),thread.getState());

	        while (thread.isAlive()) {
	            // Estado TIMED_WAITING: en espera debido a Thread.sleep()
	            System.out.printf("%s - Estado: %s%n", thread.getName(),thread.getState());
	            try {
	                // Tiempo de espera
	                Thread.sleep(milis/4);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }

	        // Estado TERMINATED: terminado
	        System.out.printf("%s - Estado: %s%n", thread.getName(),thread.getState());
		}

	}
	


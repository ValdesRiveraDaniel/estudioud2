package ejemplos;

class Puerta {
	public static boolean abierta;
	public static int rapido;
	public static int lento;
}

class Rapido extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++)
			if (Puerta.abierta) {
				Puerta.abierta = false;
				Puerta.rapido++;
				Puerta.abierta = true;
			}
		System.out.println("Rápido terminando");
	}
}

class Lento extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (Puerta.abierta) {
				Puerta.abierta = false;
				Puerta.lento++;
				Puerta.abierta = true;
			}
		}
		System.out.println("Lento terminando");
	}
}

public class Innanicion {
	public static void main(String[] args) throws InterruptedException {
		Puerta.abierta = true;
		Thread r = new Rapido();
		Thread l = new Lento();
		l.start();
		r.start();
		r.join();
		l.join();
		System.out.println("El rápido tiene: " + Puerta.rapido + " y el lento: " + Puerta.lento);
	}
}
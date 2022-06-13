package ejerciciosHilos;

import java.util.Scanner;

public class ContadorVocales {
	private int c = 0;
	private String palabra;

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
		palabra.toLowerCase();
	}

	public static void main(String[] args) throws InterruptedException {
		ContadorVocales miContadorVocales = new ContadorVocales();
		Scanner in = new Scanner(System.in);
		System.out.print("Introduce una palabra: ");
		miContadorVocales.setPalabra(in.nextLine());
		new HiloVocalA(miContadorVocales);
		new HiloVocalE(miContadorVocales);
		new HiloVocalI(miContadorVocales);
		new HiloVocalO(miContadorVocales);
		new HiloVocalU(miContadorVocales);

		Thread.sleep(4);
		System.out.println("La cantidad total de vocales es de: " + miContadorVocales.value());
		in.close();
	}

	public synchronized void increment() {
		c++;
	}

	public synchronized int value() {
		return c;
	}

}

class HiloVocalA implements Runnable {
	Thread hiloA;
	ContadorVocales miContador;

	HiloVocalA(ContadorVocales contador) {
		this.miContador = contador;
		hiloA = new Thread(this, "Hilo A");
		hiloA.start();
	}

	public void run() {

		for (int i = 0; i < miContador.getPalabra().length(); i++) {

			if (miContador.getPalabra().charAt(i) == 'a') {
				miContador.increment();
			}
		}

	}
}

class HiloVocalE implements Runnable {
	Thread hiloE;
	ContadorVocales miContador;

	HiloVocalE(ContadorVocales contador) {
		this.miContador = contador;
		hiloE = new Thread(this, "Hilo E");
		hiloE.start();
	}

	public void run() {
		for (int i = 0; i < miContador.getPalabra().length(); i++) {
			if (miContador.getPalabra().charAt(i) == 'e') {
				miContador.increment();
			}
		}
	}
}

class HiloVocalI implements Runnable {
	Thread hiloI;
	ContadorVocales miContador;

	HiloVocalI(ContadorVocales contador) {
		this.miContador = contador;
		hiloI = new Thread(this, "Hilo I");
		hiloI.start();
	}

	public void run() {
		for (int i = 0; i < miContador.getPalabra().length(); i++) {
			if (miContador.getPalabra().charAt(i) == 'i') {
				miContador.increment();
			}
		}

	}
}

class HiloVocalO implements Runnable {
	Thread hiloO;
	ContadorVocales miContador;

	HiloVocalO(ContadorVocales contador) {
		this.miContador = contador;
		hiloO = new Thread(this, "Hilo O");
		hiloO.start();
	}

	public void run() {
		for (int i = 0; i < miContador.getPalabra().length(); i++) {
			if (miContador.getPalabra().charAt(i) == 'o') {
				miContador.increment();
			}
		}
	}
}

class HiloVocalU implements Runnable {
	Thread hiloU;
	ContadorVocales miContador;

	HiloVocalU(ContadorVocales contador) {
		this.miContador = contador;
		hiloU = new Thread(this, "Hilo U");
		hiloU.start();
	}

	public void run() {
		for (int i = 0; i < miContador.getPalabra().length(); i++) {

			if (miContador.getPalabra().charAt(i) == 'u') {
				miContador.increment();
			}
		}

	}
}
package Monitores;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Deposito D = new Deposito();
		Productor P = new Productor(D);
		Consumidor C = new Consumidor(D);

		P.start();
		C.start();

		P.join();
		C.join();

	}

	// https://www.youtube.com/watch?v=78hD5dsG_go&ab_channel=niktutos
}

class Productor extends Thread {
	private Deposito deposito;

	public Productor(Deposito d) {
		deposito = d;
	}

	public void run() {
		for (int i = 1; i < 20; i++) {
			try {
				deposito.guardar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumidor extends Thread {
	private Deposito deposito;

	public Consumidor(Deposito d) {
		deposito = d;
	}

	public void run() {
		for (int i = 1; i < 20; i++) {
			try {
				deposito.sacar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Deposito {
	private int elementos = 0;

	public synchronized void guardar() throws InterruptedException {

		while (elementos != 0) {
			wait();
		}

		if (elementos == 0) {
			elementos++;
			System.out.println("metido un producto, Numero de elementos: " + elementos);
		}

		notify();
	}

	public synchronized void sacar() throws InterruptedException {

		while (elementos == 0) {
			wait();
		}

		if (elementos > 0) {
			elementos--;
			System.out.println("sacado un producto, Numero de elementos: " + elementos);
		}

		notify();
	}
}
package ejerciciosMonitores;

import java.util.Scanner;

public class Contador {

	private static int c = 0;
	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		texto.toLowerCase();
	}

	public static void main(String[] args) throws InterruptedException {

		Contador cont = new Contador();
		Scanner in = new Scanner(System.in);

		System.out.println("Escibe un texto");
		cont.setTexto(in.nextLine());

		new HiloVocalA(cont);
		new HiloVocalE(cont);
		new HiloVocalI(cont);
		new HiloVocalO(cont);
		new HiloVocalU(cont);
		
		// https://lineadecodigo.com/java/contar-las-vocales-de-una-palabra-con-java/

		Thread.sleep(4);

		System.out.println("Numero de vocales: " + cont.value());
	}

	public synchronized void increment() {
		c++;
	}

	public synchronized int value() {
		return c;
	}

}

class HiloVocalA implements Runnable {

	Contador cont ;
	Thread a;

	HiloVocalA(Contador cont) {
		this.cont = cont;
		Thread a = new Thread(this);
		System.out.println("Hilo A creado");
		a.start();
	}

	public void run() {

		for (int i = 0; i < cont.getTexto().length(); i++) {

			if (cont.getTexto().charAt(i) == 'a') {
				cont.increment();
			}
		}
	}
}

class HiloVocalE implements Runnable {

	Contador cont;
	Thread e;

	HiloVocalE(Contador cont) {
		this.cont = cont;
		Thread e = new Thread(this);
		System.out.println("Hilo E creado");
		e.start();
	}

	public void run() {

		for (int i = 0; i < cont.getTexto().length(); i++) {

			if (cont.getTexto().charAt(i) == 'e') {
				cont.increment();
			}
		}

	}

}

class HiloVocalI implements Runnable {

	Contador cont;
	Thread i;

	HiloVocalI(Contador cont) {
		this.cont = cont;
		Thread i = new Thread(this);
		System.out.println("Hilo I creado");
		i.start();
	}

	public void run() {

		for (int i = 0; i < cont.getTexto().length(); i++) {

			if (cont.getTexto().charAt(i) == 'i') {
				cont.increment();
			}
		}

	}

}

class HiloVocalO implements Runnable {

	Contador cont;
	Thread o;

	HiloVocalO(Contador cont) {
		this.cont = cont;
		Thread o = new Thread(this);
		System.out.println("Hilo O creado");
		o.start();  
	}

	public void run() {

		for (int i = 0; i < cont.getTexto().length(); i++) {

			if (cont.getTexto().charAt(i) == 'o') {
				cont.increment();
			}
		}

	}

}

class HiloVocalU implements Runnable {

	Contador cont;
	Thread u;

	HiloVocalU(Contador cont) {
		this.cont = cont;
		Thread u = new Thread(this);
		System.out.println("Hilo U creado");
		u.start();
	}

	public void run() {

		for (int i = 0; i < cont.getTexto().length(); i++) {

			if (cont.getTexto().charAt(i) == 'u') {
				cont.increment();
			}
		}

	}

}

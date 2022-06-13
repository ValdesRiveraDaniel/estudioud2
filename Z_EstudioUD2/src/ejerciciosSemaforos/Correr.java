package ejerciciosSemaforos;

import java.util.concurrent.Semaphore;


class Puerta {
	public static boolean abierta;
	public static int contador;
}

class Abrir extends Thread {
	
	Semaphore semaforoAbrir;
	
	public Abrir(Semaphore semaforoAbrir) {
		this.semaforoAbrir = semaforoAbrir;
	}

	public void run() {
		
		for (int i = 0; i < 1000; i++)
			if (!Puerta.abierta)
				Puerta.abierta = true;
			else {
				i--;
				try {
					semaforoAbrir.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Puerta.contador++;
				semaforoAbrir.release();
			}
		System.out.println("Abrir terminando");
	}
}

class Cerrar extends Thread {
	
	Semaphore semaforoCerrar;
	
	public Cerrar(Semaphore semaforoCerrar) {
		this.semaforoCerrar = semaforoCerrar;
	}

	public void run() {
		for (int i = 0; i < 1000; i++)
			if (Puerta.abierta)
				Puerta.abierta = false;
			else {
				i--;
				try {
					semaforoCerrar.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Puerta.contador++;
				semaforoCerrar.release();
			}
		System.out.println("Cerrar terminando");
	}
}

public class Correr {
	public static void main(String[] args) throws InterruptedException {
		Semaphore semaforo = new Semaphore(0);
		Puerta.abierta = true;
		Thread a = new Abrir(semaforo);
		Thread c = new Cerrar(semaforo);
		a.start();
		c.start();
		a.join();
		c.join();
		System.out.println("El resultado final es: " + Puerta.contador);
	}
}
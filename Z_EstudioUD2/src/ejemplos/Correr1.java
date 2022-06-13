package ejemplos;

class Contador1 {
	public static int c;
}

class Suma1 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++)
			Contador1.c++;
	}
}

class Resta1 extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++)
			Contador1.c--;
	}
}

public class Correr1 {
	public static void main(String[] args) throws InterruptedException {
		Contador.c = 0;
		Thread s1 = new Suma1();
		Thread r1 = new Resta1();
		s1.start();
		r1.start();
		s1.join();
		r1.join();
		System.out.println("El resultado final es: " + Contador1.c);
	}
}
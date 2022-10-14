package parte1.basico.implementsRunnable;

public class TesteMinhaThread {

    public static void main(String[] args) throws InterruptedException {

        MinhaThread minhaThread1 = new MinhaThread("Thread #1", 500);
        MinhaThread minhaThread2 = new MinhaThread("Thread #2", 1000);
        MinhaThread minhaThread3 = new MinhaThread("Thread #3", 500);

        Thread thread1 = new Thread(minhaThread1);
        Thread thread2 = new Thread(minhaThread2);
        Thread thread3 = new Thread(minhaThread3);

        thread1.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Programa finalizado");

    }
}

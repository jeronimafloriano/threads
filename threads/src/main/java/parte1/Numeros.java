package parte1;

public class Numeros {

    public static void main(String[] args) {
        //Crie um programa com duas threads que imprimem números de 1 até 1000, além da ID da thread.

        Thread thread = new Thread(() -> {
            for (int i =0; i <= 1000; i++){
                System.out.println(Thread.currentThread().getId() + " - " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i =0; i <= 1000; i++){
                System.out.println(Thread.currentThread().getId() + " - " + i);
            }
        });

        thread.start();
        thread2.start();


    }
}

package parte1.basico.synchronizedArray;

public class Calculadora {

    private int soma;

    public synchronized int somaArray(int [] array) {
        soma = 0;

        for (int i = 0; i < array.length; i++){
            soma += array[i];

            System.out.println("Executado a soma: " + Thread.currentThread().getName()
                    + " somando o valor: " + array[i] + " que dá o total de: " + soma);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return soma;
    }
}

package parte1.basico.synchronizedArray;


public class MinhaThreadSoma implements Runnable{

    private String nome;
    private int[] numeros;
    private static Calculadora calc = new Calculadora();

    public MinhaThreadSoma(String nome, int[] numeros){
        this.nome = nome;
        this.numeros = numeros;
        new Thread(this, nome).start();
    }

    @Override
    public void run() {

        System.out.println(this.nome + " iniciada.");
        int soma = calc.somaArray(this.numeros);

        System.out.println("O resultado da soma é: " + soma);

        System.out.println(this.nome + " finalizada.");
    }
}

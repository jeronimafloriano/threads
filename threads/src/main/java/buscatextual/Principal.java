package buscatextual;

public class Principal {

    public static void main(String[] args) {

        String nome = "Je";

        Thread threadAssinatura1 = new Thread(new BuscaTextual("assinaturas1.txt", nome));
        Thread threadAssinatura2 = new Thread(new BuscaTextual("assinaturas2.txt", nome));
        Thread threadAutores = new Thread(new BuscaTextual("autores.txt", nome));

        threadAssinatura1.start();
        threadAssinatura2.start();
        threadAutores.start();
    }
}

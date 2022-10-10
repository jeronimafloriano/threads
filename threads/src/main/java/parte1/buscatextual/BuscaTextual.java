package parte1.buscatextual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuscaTextual implements Runnable{

    private String arquivo;
    private String nomeBuscado;
    public BuscaTextual(String arquivo, String textoBuscado){
        this.arquivo = arquivo;
        this.nomeBuscado = textoBuscado;
    }

    @Override
    public void run() {
        try {
            Scanner scan = new Scanner(new File(arquivo));

            int numeroLinha = 1;

            while (scan.hasNextLine()){
                String linha = scan.nextLine();

                if (linha.toLowerCase().contains(nomeBuscado.toLowerCase())){
                    System.out.println(arquivo + " -- " + numeroLinha + " -- " + linha);

                }
                numeroLinha++;
            }
            scan.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

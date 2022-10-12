package parte2.servidortarefas;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 12346);
        System.out.println("Conexão estabelecida");

        Thread threadEnviaComando = new Thread(() -> {
            try {
                System.out.println("Enviando comandos: ");

                PrintStream saida = new PrintStream(socket.getOutputStream());
                Scanner scan = new Scanner(System.in);

                while(scan.hasNextLine()){
                    String linha = scan.next();

                    if(linha.contains("esc")){
                        break;
                    }
                    saida.println(linha);
                }
                saida.close();
                scan.close();
            } catch (Exception e){
                throw new RuntimeException(e);
            }

        });

        Thread threadRecebeResposta = new Thread(()  -> {
                try {
                    System.out.println("Recebendo dados do servidor");
                    Scanner respostaServidor = new Scanner(
                            socket.getInputStream());

                    while (respostaServidor.hasNextLine()) {

                        String linha = respostaServidor.nextLine();
                        System.out.println(linha);
                    }

                    respostaServidor.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        });

        threadRecebeResposta.start();
        threadEnviaComando.start();
        threadEnviaComando.join();

        System.out.println("Fechando o socket do cliente");

        socket.close();
    }
}

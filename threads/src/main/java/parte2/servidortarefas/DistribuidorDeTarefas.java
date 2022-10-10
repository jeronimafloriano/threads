package parte2.servidortarefas;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DistribuidorDeTarefas implements Runnable{

    private Socket socket;

    public DistribuidorDeTarefas(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Distribuindo tarefas para: " + socket);

            Scanner scan = new Scanner(socket.getInputStream());

            while (scan.hasNextLine()){
                String saida = scan.nextLine();
                System.out.println(saida);
            }

            scan.close();
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

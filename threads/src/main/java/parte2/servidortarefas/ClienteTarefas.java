package parte2.servidortarefas;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 12345);
        System.out.println("Conexão estabelecida");

        PrintStream saida = new PrintStream(socket.getOutputStream());
        saida.println("c1");

        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        socket.close();
    }
}

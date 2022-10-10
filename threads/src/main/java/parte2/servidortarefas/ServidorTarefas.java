package parte2.servidortarefas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {

    public static void main(String[] args) throws Exception {

        System.out.println("---- Iniciando Servidor ----");
        ServerSocket servidor = new ServerSocket(12345);
        //ExecutorService threadPool = Executors.newFixedThreadPool(2);
        ExecutorService threadPool = Executors.newCachedThreadPool();

        while (true){
            Socket socket = servidor.accept();
            System.out.println("Aceitando novo cliente na porta: " + socket.getPort());

            DistribuidorDeTarefas distribuidor = new DistribuidorDeTarefas(socket);
            threadPool.execute(distribuidor);
//            Thread threadCliente = new Thread(distribuidor);
//            threadCliente.start();

            Set<Thread> threads =  Thread.getAllStackTraces().keySet();
            threads.forEach(System.out::println);

            System.out.println("Quantidade de processadores: " + Runtime.getRuntime().availableProcessors());

        }
    }
}

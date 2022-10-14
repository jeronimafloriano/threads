package parte2.servidortarefas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {

    private ServerSocket servidor;
    private ExecutorService threadPool;
    private boolean estaRodando;

    public ServidorTarefas() throws IOException {
        System.out.println("---- Iniciando Servidor ----");
        this.servidor = new ServerSocket(12346);
        //this.threadPool = Executors.newCachedThreadPool();
        this.threadPool = Executors.newFixedThreadPool(4, new FabricaDeThreads());
        this.estaRodando = true;

    }

    public void rodar() throws IOException {
        try {
            while (estaRodando){
                Socket socket = servidor.accept();
                System.out.println("Aceitando novo cliente na porta: " + socket.getPort());
                DistribuidorDeTarefas distribuidor = new DistribuidorDeTarefas(threadPool,socket, this);
                threadPool.execute(distribuidor);
//            Thread threadCliente = new Thread(distribuidor);
//            threadCliente.start();
            }
        } catch (SocketException e){
            System.out.println("Está rodando?: " + estaRodando);
        }
    }

    public void parar() throws IOException {
        estaRodando = false;
        servidor.close();
        threadPool.shutdown();
        //System.exit(0); não deve ser usado pq encerra a JVM
    }

    public static void main(String[] args) throws Exception {
        Set<Thread> threads =  Thread.getAllStackTraces().keySet();
        threads.forEach(System.out::println);
        System.out.println("Quantidade de processadores: " + Runtime.getRuntime().availableProcessors());

        ServidorTarefas servidor = new ServidorTarefas();
        servidor.rodar();
        servidor.parar();

    }
}

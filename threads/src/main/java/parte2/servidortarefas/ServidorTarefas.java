package parte2.servidortarefas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Set;
import java.util.concurrent.*;

public class ServidorTarefas {

    private ServerSocket servidor;
    private ExecutorService threadPool;
    private boolean estaRodando;
    private BlockingQueue<String> filaComandos;

    public ServidorTarefas() throws IOException {
        System.out.println("---- Iniciando Servidor ----");
        this.servidor = new ServerSocket(12346);
        this.threadPool = Executors.newCachedThreadPool( new FabricaDeThreads());
        //this.threadPool = Executors.newFixedThreadPool(4, new FabricaDeThreads());
        this.estaRodando = true;
        this.filaComandos = new ArrayBlockingQueue<>(2);
        iniciarConsumidoresFila();
    }

    private void iniciarConsumidoresFila() {
        TarefaConsumirFilaComandos tarefa1 = new TarefaConsumirFilaComandos(filaComandos);
        TarefaConsumirFilaComandos tarefa2 = new TarefaConsumirFilaComandos(filaComandos);
        this.threadPool.execute(tarefa1);
        this.threadPool.execute(tarefa2);

    }

    public void rodar() throws IOException {
        try {
            while (estaRodando){
                Socket socket = servidor.accept();
                System.out.println("Aceitando novo cliente na porta: " + socket.getPort());
                DistribuidorDeTarefas distribuidor = new DistribuidorDeTarefas(threadPool,filaComandos, socket, this);
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

package parte2.servidortarefas;

import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class DistribuidorDeTarefas implements Runnable{

    private ExecutorService threadPool;
    private BlockingQueue<String> filaComandos;
    private Socket socket;
    private ServidorTarefas servidor;

    public DistribuidorDeTarefas(ExecutorService threadPool, BlockingQueue filaComandos,
                                 Socket socket, ServidorTarefas servidor ){
        this.threadPool = threadPool;
        this.filaComandos = filaComandos;
        this.socket = socket;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try {
            System.out.println("Distribuindo tarefas para: " + socket);

            Scanner entradaCliente = new Scanner(socket.getInputStream());
            PrintStream saidaCliente = new PrintStream(socket.getOutputStream());

            while (entradaCliente.hasNextLine()){
                String comando = entradaCliente.nextLine();
                System.out.println("Comando recebido " + comando);

                switch (comando) {
                    case "c1": {
                        saidaCliente.println("Confirmação do comando c1");
                        ComandoC1 c1 = new ComandoC1(saidaCliente);
                        this.threadPool.execute(c1);
                        break;
                    }
                    case "c2": {
                        saidaCliente.println("Confirmação do comando c2");
                        ComandoC2 c2 = new ComandoC2(saidaCliente);
                        ComandoC c = new ComandoC(saidaCliente);
                        Future<String> futureC2 = this.threadPool.submit(c2);
                        Future<String> futureC = this.threadPool.submit(c);

                        this.threadPool.submit(new AgrupaResultadosComandosC2EC(futureC2, futureC, saidaCliente));

                        //this.threadPool.execute(c2);
                        break;
                    }
                    case "c3": {
                        this.filaComandos.put(comando);
                        saidaCliente.println("Comando c3 adicionado à fila.");
                        break;
                    }
                    case "fim": {
                        saidaCliente.println("Finalizando");
                        servidor.parar();
                        break;
                    }
                    default: {
                        saidaCliente.println("Comando não encontrado");
                    }
                }

                System.out.println(comando);
            }

            saidaCliente.close();
            entradaCliente.close();
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package parte2.servidortarefas;

import java.util.concurrent.BlockingQueue;

public class TarefaConsumirFilaComandos implements Runnable{

    private BlockingQueue<String> filaComandos;

    public TarefaConsumirFilaComandos(BlockingQueue<String> filaComandos) {
        this.filaComandos = filaComandos;
    }

    @Override
    public void run() {
        try{
            String comando = null;

            while ((comando =  filaComandos.take()) != null) {
                System.out.println("Consumindo comando: " + comando +
                        " - " + Thread.currentThread().getName());
                Thread.sleep(5000);
            }

        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}

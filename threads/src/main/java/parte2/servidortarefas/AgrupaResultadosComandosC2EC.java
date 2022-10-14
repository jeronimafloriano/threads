package parte2.servidortarefas;

import java.io.PrintStream;
import java.util.concurrent.*;

public class AgrupaResultadosComandosC2EC implements Callable<Void> {


    private Future<String> futureC2;
    private Future<String> futureC;
    private PrintStream saidaCliente;

    public AgrupaResultadosComandosC2EC(Future<String> futureC2,
                                        Future<String> futureC, PrintStream saidaCliente) {
        this.futureC2 = futureC2;
        this.futureC = futureC;
        this.saidaCliente = saidaCliente;
    }

    @Override
    public Void call() {

        System.out.println("Aguardando resultados dos futures do Comando C2 e Comando C");

        try {
            String numero1 = numero1 = this.futureC2.get(10, TimeUnit.SECONDS);
            String numero2 = this.futureC.get(10, TimeUnit.SECONDS);

            this.saidaCliente.println("Resultado dos comandos: " + numero1 + " - " + numero2);

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println("TIMEOUT: Cancelando a execução dos comandos C2 e C.");
            this.saidaCliente.println("TIMEOUT na execução dos comandos C2 e C.");

            this.futureC2.cancel(true);
            this.futureC.cancel(true);
        }

        System.out.println("Finalizou AgrupaResultadosComandosC2EC");


        return null;
    }
}

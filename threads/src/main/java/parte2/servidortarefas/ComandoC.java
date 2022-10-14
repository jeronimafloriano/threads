package parte2.servidortarefas;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC implements Callable {

    private PrintStream saidaCliente;
    public ComandoC(PrintStream saidaCliente) {
        this.saidaCliente = saidaCliente;
    }


    @Override
    public Object call() throws Exception {

        System.out.println("Executando comando C");

        saidaCliente.println("Processando comando C");

        Thread.sleep(25000);

        int numero = new Random().nextInt(100) + 1;

        System.out.println("Finalizando comando C");

        return Integer.toString(numero);
    }
}

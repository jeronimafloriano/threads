package parte1.lista;

import java.util.List;

public class TarefaAdicionarElemento implements Runnable {

    private List lista;
    private int numeroThread;

    public TarefaAdicionarElemento(List lista, int numeroThread) {
        this.lista = lista;
        this.numeroThread = numeroThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            lista.add("Thread: " + numeroThread + " elemento: " + i);
        }
    }


}

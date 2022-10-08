package saladereuniao;

public class TarefaNumero1 implements Runnable{

    private SalaDeReuniao salaDeReuniao;

    public TarefaNumero1(SalaDeReuniao salaDeReuniao){
        this.salaDeReuniao = salaDeReuniao;
    }

    @Override
    public void run() {
        salaDeReuniao.fazReuniao();
    }
}

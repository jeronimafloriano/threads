package saladereuniao;

public class TarefaNumero2 implements Runnable{

    private SalaDeReuniao salaDeReuniao;

    public TarefaNumero2(SalaDeReuniao salaDeReuniao){
        this.salaDeReuniao = salaDeReuniao;
    }

    @Override
    public void run() {
        salaDeReuniao.trabalha();
    }
}

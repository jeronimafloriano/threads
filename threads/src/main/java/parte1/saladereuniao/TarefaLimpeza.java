package parte1.saladereuniao;

public class TarefaLimpeza implements Runnable{

    private SalaDeReuniao salaDeReuniao;

    public TarefaLimpeza(SalaDeReuniao salaDeReuniao){
        this.salaDeReuniao = salaDeReuniao;
    }

    @Override
    public void run() {
        while (true){
            salaDeReuniao.limpaSala();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

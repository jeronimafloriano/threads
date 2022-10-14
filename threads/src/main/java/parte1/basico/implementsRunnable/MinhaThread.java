package parte1.basico.implementsRunnable;

public class MinhaThread implements Runnable{

    private String nome;
    private long tempo;

    public MinhaThread(String nome, long tempo){
        this.nome = nome;
        this.tempo = tempo;
    }

    @Override
    public void run(){
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(nome + " contador " + i);
                Thread.sleep(tempo);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

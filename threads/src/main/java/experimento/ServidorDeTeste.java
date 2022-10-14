package experimento;


import parte2.servidortarefas.TratadorDeExcecao;

import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorDeTeste {

    //private volatile boolean estaRodando = false;
    private AtomicBoolean estaRodando = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        ServidorDeTeste servidor = new ServidorDeTeste();
        servidor.rodar();
        servidor.alterandoAtributo();
    }

    private void rodar() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                   System.out.println("Servidor começando, estaRodando = " + estaRodando );

                   while(!estaRodando.get()) {}
                   if(estaRodando.get()){
                       throw new RuntimeException("Erro na thread!");
                   }

                   System.out.println("Servidor rodando, estaRodando = " + estaRodando );

                   while(estaRodando.get()) {}

                   System.out.println("Servidor terminando, estaRodando = " + estaRodando );
            }
        });

        thread.setUncaughtExceptionHandler(new TratadorDeExcecao());
        thread.start();
    }

    private void alterandoAtributo() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Main alterando estaRodando = true");
        estaRodando.set(true);

        Thread.sleep(5000);
        System.out.println("Main alterando estaRodando = false");
        estaRodando.set(false);
    }
}
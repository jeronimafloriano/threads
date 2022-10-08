package saladereuniao;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SalaDeReuniao {

    //private Lock lock = new ReentrantLock();

    private boolean salaSuja = true;

    public void fazReuniao() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this){
            System.out.println(nome + " entrando na sala");

            while(salaSuja){
                aguardarLimpeza(nome);
            }

            System.out.println(nome + " ligando os equipamentos");

            aguardar(5000);

            salaSuja = true;

            System.out.println(nome + " fazendo reunião");
            System.out.println(nome + " saindo da sala");
        }
    }

    public void trabalha(){
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this){
            System.out.println(nome + " entrando na sala");

            while(salaSuja){
                aguardarLimpeza(nome);
            }

            System.out.println(nome + " ligando os equipamentos");

            aguardar(5000);

            salaSuja = true;

            System.out.println(nome + " trabalhando");
            System.out.println(nome + " saindo da sala");
        }
    }

    private void aguardarLimpeza(String nome){
        System.out.println(nome + " aguardando limpeza da sala!");
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void limpaSala() {
        String nome = Thread.currentThread().getName();

        synchronized (this) {
            System.out.println(nome + " entrando na sala");

            if(!salaSuja){
                System.out.println(nome + " sala não está suja!");
                return;
            }

            System.out.println(nome + " limpando a sala");
            this.salaSuja = false;

            aguardar(5000);

            this.notifyAll();

            System.out.println(nome + " saindo da sala");
        }
    }

    private void aguardar(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

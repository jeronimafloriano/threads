package parte1.saladereuniao;

public class Principal {

    public static void main(String[] args) {

        SalaDeReuniao salaDeReuniao = new SalaDeReuniao();

        Thread funcionario1 = new Thread(new TarefaNumero1(salaDeReuniao), "João");
        Thread funcionario2 = new Thread(new TarefaNumero2(salaDeReuniao), "Maria");
        Thread limpeza = new Thread(new TarefaLimpeza(salaDeReuniao), "Limpeza");
        //limpeza.setPriority(Thread.MAX_PRIORITY);
        limpeza.setDaemon(true);

        funcionario1.start();
        funcionario2.start();
        limpeza.start();
    }
}

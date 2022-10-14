package parte2.servidortarefas;

public class TratadorDeExcecao implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Exceção na thread: " + t.getName() + ", Mensagem: " + e.getMessage());
    }
}

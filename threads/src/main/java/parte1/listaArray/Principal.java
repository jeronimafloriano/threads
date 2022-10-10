package parte1.listaArray;

public class Principal {

    public static void main(String[] args) {
        Lista lista = new Lista() ;

            for (int i = 0; i < 10; i++){
                new Thread(new TarefaAdicionarElemento(lista, i)).start();
        }


        new Thread(new TarefaImprimir(lista)).start();

    }
}

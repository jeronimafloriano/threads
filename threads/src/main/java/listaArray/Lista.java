package listaArray;

public class Lista {

    private String[] elementos = new String[100];
    private int indice = 0;

    public synchronized void adicionaElementos(String string){
        this.elementos[indice] = string;
        this.indice++;

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (this.indice == this.tamanho()) {
            System.out.println("Notificando: Lista está cheia.");
            this.notify();
        }
    }

    public int tamanho(){
        return this.elementos.length;
    }

    public String pegaElemento(int posicao){
        return this.elementos[posicao];
    }

    public boolean estaCheia(){
        return this.indice == this.tamanho();
    }
}

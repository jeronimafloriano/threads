package lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Principal {

    public static void main(String[] args) {
        List lista = new Vector<String>();
        //List lista = Collections.synchronizedList(new ArrayList<String>());

        for (int i = 0; i < 10; i++){
            new Thread(new TarefaAdicionarElemento(lista, i)).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for(int i = 0; i < lista.size(); i++){
            System.out.println(i + " - " + lista.get(i));
        }

    }
}

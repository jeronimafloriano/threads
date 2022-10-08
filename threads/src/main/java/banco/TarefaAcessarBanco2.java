package banco;

public class TarefaAcessarBanco2 implements Runnable{

    private PoolDeConexao pool;
    private GerenciadorDeTransacao tx;

    public TarefaAcessarBanco2(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {

        synchronized (pool){
            System.out.println("Pegando a chave do pool");
            pool.getConnection();

            synchronized (tx){
                System.out.println("Começando a gerenciar a  tx");
                tx.begin();
            }

        }
    }
}

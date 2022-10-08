package banco;

public class PrincipalBanco {

    public static void main(String[] args) {

        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PoolDeConexao pool = new PoolDeConexao();

        new Thread(new TarefaAcessarBanco(pool, tx)).start();
        new Thread(new TarefaAcessarBanco2(pool, tx)).start();

    }
}

package parte1.basico.synchronizedArray;

public class TestaCalculadora {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        MinhaThreadSoma t1 = new MinhaThreadSoma("Thread #1",array);
        MinhaThreadSoma t2 = new MinhaThreadSoma("Thread #2",array);
    }
}

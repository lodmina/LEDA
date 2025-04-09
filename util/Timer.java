package util;

public class Timer {
    private long inicio;

    public void iniciar() {
        inicio = System.nanoTime();
    }

    public long finalizar() {
        return System.nanoTime() - inicio;
    }
}

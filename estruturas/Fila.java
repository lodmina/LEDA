package estruturas;

public class Fila<T> {
    private class No {
        T dado;
        No proximo;

        No(T dado) { this.dado = dado; }
    }

    private No frente;
    private No tras;

    public void enfileirar(T valor) {
        No novo = new No(valor);
        if (tras != null) tras.proximo = novo;
        else frente = novo;
        tras = novo;
    }

    public T desenfileirar() {
        if (frente == null) return null;
        T valor = frente.dado;
        frente = frente.proximo;
        if (frente == null) tras = null;
        return valor;
    }

    public boolean estaVazia() {
        return frente == null;
    }
}

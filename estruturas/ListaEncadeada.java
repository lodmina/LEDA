package estruturas;

public class ListaEncadeada<T> {
    private class No {
        T dado;
        No proximo;

        No(T dado) {
            this.dado = dado;
        }
    }

    private No inicio;
    private No ultimo;
    private int tamanho = 0;

    public void adicionar(T valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
        tamanho++;
    }

    public T[] paraArray(T[] array) {
        No atual = inicio;
        int i = 0;
        while (atual != null) {
            array[i++] = atual.dado;
            atual = atual.proximo;
        }
        return array;
    }

    public int tamanho() {
        return tamanho;
    }
}

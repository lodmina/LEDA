package estruturas;

public class HashMapSimples {
    private static class Entrada {
        String chave;
        int valor;
        Entrada proximo;

        Entrada(String chave, int valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    private Entrada[] tabela = new Entrada[1000];

    private int hash(String chave) {
        return Math.abs(chave.hashCode() % tabela.length);
    }

    public void put(String chave, int valor) {
        int indice = hash(chave);
        Entrada atual = tabela[indice];
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                atual.valor = valor;
                return;
            }
            atual = atual.proximo;
        }
        Entrada nova = new Entrada(chave, valor);
        nova.proximo = tabela[indice];
        tabela[indice] = nova;
    }

    public Integer get(String chave) {
        int indice = hash(chave);
        Entrada atual = tabela[indice];
        while (atual != null) {
            if (atual.chave.equals(chave)) return atual.valor;
            atual = atual.proximo;
        }
        return null;
    }

    public boolean contemChave(String chave) {
        return get(chave) != null;
    }
}



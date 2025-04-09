package util;

import modelo.Tweet;

public class ArrayUtils {
    public static Tweet[] copiar(Tweet[] original) { // Copia um array
        Tweet[] cp = new Tweet[original.length];
        for (int i = 0; i < original.length; i++) {
            cp[i] = original[i];
        }
        return cp;
    }

    public static Tweet[] reverte(Tweet[] original) { // Deixa o array ao contrário para o pior caso
        Tweet[] rv = new Tweet[original.length];
        for (int i = 0; i < original.length; i++) {
            rv[i] = original[original.length - 1 - i];
        }
        return rv;
    }
}

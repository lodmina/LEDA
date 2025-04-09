package util;

import java.io.*;

public class DesempenhoUtils {
    private static final String ARQUIVO = "resultados_tempos.csv";

    public static void salvarTempo(String algoritmo, String campo, String caso, long tempoNs) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            writer.write(algoritmo + "," + campo + "," + caso + "," + tempoNs + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

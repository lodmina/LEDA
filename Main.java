import algoritmos.InsertionSort;
import algoritmos.MergeSort;
import modelo.Tweet;
import util.ArrayUtils;
import util.CSVUtils;
import util.DesempenhoUtils;
import util.Timer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando processamento do CSV...");
        // 1. Transformar o CSV original (datas e menções)
        util.CSVTransformation.execute();

        // 2. Ler o CSV transformado
        Tweet[] base = CSVUtils.lerCSV("tweets_mentioned_persons.csv");
        System.out.println("CSV carregado com " + base.length + " registros.");

        // 3. Definir campos e algoritmos
        String[] campos = {"date", "user", "count"}; // 3 campos pedidos pelo professor
        String[] algoritmos = {"mergeSort"}; // algoritmos utilizados

        for (String campo : campos) {
            for (String algoritmo : algoritmos) {
                System.out.println("🔄 Executando " + algoritmo + " para o campo: " + campo);
                if (algoritmo.equals("countingSort") && !campo.equals("count")) { // Algoritmo count só se aplica ao count por causa de suas particularidades
                    System.out.println("Counting Sort não se aplica ao campo: " + campo);
                    continue;
                }

                // 1. Médio caso
                System.out.println("Caso médio...");
                Tweet[] medio = ArrayUtils.copiar(base);
                Timer timer = new Timer();
                timer.iniciar();
                aplicarOrdenacao(medio, campo, algoritmo);
                long tempoMedio = timer.finalizar();
                System.out.println("Ordenado (médio) em " + tempoMedio + " ns");
                DesempenhoUtils.salvarTempo(algoritmo, campo, "medioCaso", tempoMedio);

                // 2. Melhor caso
                System.out.println("Caso melhor...");
                Tweet[] melhor = ArrayUtils.copiar(medio);
                timer.iniciar();
                aplicarOrdenacao(melhor, campo, algoritmo);
                long tempoMelhor = timer.finalizar();
                System.out.println("Ordenado (melhor) em " + tempoMelhor + " ns");
                DesempenhoUtils.salvarTempo(algoritmo, campo, "melhorCaso", tempoMelhor);

                // 3. Pior caso
                System.out.println("Caso pior...");
                Tweet[] pior = ArrayUtils.reverte(melhor);
                timer.iniciar();
                aplicarOrdenacao(pior, campo, algoritmo);
                long tempoPior = timer.finalizar();
                System.out.println("Ordenado (pior) em " + tempoPior + " ns");
                DesempenhoUtils.salvarTempo(algoritmo, campo, "piorCaso", tempoPior);

                // Salvar CSVs
                CSVUtils.escreverCSV("tweets_" + campo + "_" + algoritmo + "_medioCaso.csv", medio);
                CSVUtils.escreverCSV("tweets_" + campo + "_" + algoritmo + "_melhorCaso.csv", melhor);
                CSVUtils.escreverCSV("tweets_" + campo + "_" + algoritmo + "_piorCaso.csv", pior);
                System.out.println("Finalizado para: " + algoritmo + " - " + campo + "\n");
            }
        }

        System.out.println("Processamento finalizado!");
    }

    private static void aplicarOrdenacao(Tweet[] arr, String campo, String algoritmo) {
        switch (algoritmo) {
            case "insertionSort":
                if (campo.equals("date")) InsertionSort.byDate(arr);
                else if (campo.equals("user")) InsertionSort.byUser(arr);
                else InsertionSort.byCount(arr);
                break;

            case "mergeSort":
                if (campo.equals("date")) MergeSort.byDate(arr, 0, arr.length - 1);
                else if (campo.equals("user")) MergeSort.byUser(arr, 0, arr.length - 1);
                else MergeSort.byCount(arr, 0, arr.length - 1);
                break;

            //Implementar os outros algoritmos
        }
    }
}

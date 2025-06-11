import algoritmos.InsertionSort;
import algoritmos.MergeSort;
import estruturas.Fila;
import estruturas.HashMapSimples;
import estruturas.ListaEncadeada;
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

        // 2. Ler o CSV transformado usando ListaEncadeada
        ListaEncadeada<Tweet> lista = CSVUtils.lerCSVComLista("tweets_mentioned_persons.csv");
        Tweet[] base = new Tweet[lista.tamanho()];
        base = lista.paraArray(base);
        System.out.println("CSV carregado com " + base.length + " registros.");

        // Contagem de tweets por usuário usando HashMapSimples
        HashMapSimples contagemUsuarios = new HashMapSimples();
        for (Tweet tweet : base) {
            String user = tweet.getUser();
            Integer atual = contagemUsuarios.get(user);
            contagemUsuarios.put(user, atual == null ? 1 : atual + 1);
        }

        // 3. Definir campos e algoritmos
        String[] campos = {"date", "user", "count"};
        String[] algoritmos = {"mergeSort", "insertionSort", "countingSort", "selectionSort", "quickSort", "quickSortMedianaDeTres", "heapSort"};

        // Fila de jobs de ordenação
        Fila<OrdenacaoJob> fila = new Fila<>();

        for (String campo : campos) {
            for (String algoritmo : algoritmos) {
                if (algoritmo.equals("countingSort") && !campo.equals("count")) continue; // Algoritmo count só se aplica ao count por causa de suas particularidades
                fila.enfileirar(new OrdenacaoJob(campo, algoritmo));
            }
        }

        while (!fila.estaVazia()) {
            System.out.println("Fila não está vazia");
            OrdenacaoJob job = fila.desenfileirar();
            System.out.println("Executando: " + job.getCampo() + " - " + job.getAlgoritmo());
            processarOrdenacao(base, job.getCampo(), job.getAlgoritmo());
        }


        System.out.println("Processamento finalizado!");
    }

    private static void processarOrdenacao(Tweet[] base, String campo, String algoritmo) {
        System.out.println("🔄 Executando " + algoritmo + " para o campo: " + campo);

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
            case "selectionSort":
                if (campo.equals("date")) algoritmos.SelectionSort.byDate(arr);
                else if (campo.equals("user")) algoritmos.SelectionSort.byUser(arr);
                else algoritmos.SelectionSort.byCount(arr);
                break;
            case "quickSort":
                if (campo.equals("date")) algoritmos.QuickSort.byDate(arr, 0, arr.length - 1);
                else if (campo.equals("user")) algoritmos.QuickSort.byUser(arr, 0, arr.length - 1);
                else algoritmos.QuickSort.byCount(arr, 0, arr.length - 1);
                break;
            case "quickSortMedianaDeTres":
                if (campo.equals("date")) algoritmos.QuickSortMedianaDeTres.byDate(arr, 0, arr.length - 1);
                else if (campo.equals("user")) algoritmos.QuickSortMedianaDeTres.byUser(arr, 0, arr.length - 1);
                else algoritmos.QuickSortMedianaDeTres.byCount(arr, 0, arr.length - 1);
                break;
            case "heapSort":
                if (campo.equals("date")) algoritmos.HeapSort.byDate(arr);
                else if (campo.equals("user")) algoritmos.HeapSort.byUser(arr);
                else algoritmos.HeapSort.byCount(arr);
                break;
            case "countingSort":
                if (campo.equals("count")) algoritmos.CountingSort.byCount(arr);
                break;
            default:
                System.out.println("Algoritmo não reconhecido: " + algoritmo);
        }
    }
}

class OrdenacaoJob {
    private final String campo;
    private final String algoritmo;

    public OrdenacaoJob(String campo, String algoritmo) {
        this.campo = campo;
        this.algoritmo = algoritmo;
    }

    public String getCampo() {
        return campo;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }
}

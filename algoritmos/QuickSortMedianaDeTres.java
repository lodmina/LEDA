package algoritmos;

import modelo.Tweet;

public class QuickSortMedianaDeTres {

    // ------------------------ USER ------------------------
    public static void byUser(Tweet[] arr, int esq, int dir) {
        if (esq < dir) {
            int pi = partitionUser(arr, esq, dir);
            byUser(arr, esq, pi - 1);
            byUser(arr, pi + 1, dir);
        }
    }

    private static int partitionUser(Tweet[] arr, int esq, int dir) {
        int meio = (esq + dir) / 2;
        String pivo = medianaUsuario(arr[esq], arr[meio], arr[dir]);

        int i = esq - 1;
        for (int j = esq; j <= dir; j++) {
            if (arr[j].getUser().compareToIgnoreCase(pivo) <= 0) {
                i++;
                Tweet temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }

    private static String medianaUsuario(Tweet a, Tweet b, Tweet c) {
        String x = a.getUser();
        String y = b.getUser();
        String z = c.getUser();
        if (x.compareToIgnoreCase(y) > 0) { String tmp = x; x = y; y = tmp; }
        if (y.compareToIgnoreCase(z) > 0) { String tmp = y; y = z; z = tmp; }
        if (x.compareToIgnoreCase(y) > 0) { String tmp = x; x = y; y = tmp; }
        return y;
    }

    // ------------------------ DATE ------------------------
    public static void byDate(Tweet[] arr, int esq, int dir) {
        if (esq < dir) {
            int pi = partitionDate(arr, esq, dir);
            byDate(arr, esq, pi - 1);
            byDate(arr, pi + 1, dir);
        }
    }

    private static int partitionDate(Tweet[] arr, int esq, int dir) {
        int meio = (esq + dir) / 2;
        String pivo = medianaData(arr[esq], arr[meio], arr[dir]);

        int i = esq - 1;
        for (int j = esq; j <= dir; j++) {
            if (arr[j].getDateOrdenavel().compareTo(pivo) <= 0) {
                i++;
                Tweet temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }

    private static String medianaData(Tweet a, Tweet b, Tweet c) {
        String x = a.getDateOrdenavel();
        String y = b.getDateOrdenavel();
        String z = c.getDateOrdenavel();
        if (x.compareTo(y) > 0) { String tmp = x; x = y; y = tmp; }
        if (y.compareTo(z) > 0) { String tmp = y; y = z; z = tmp; }
        if (x.compareTo(y) > 0) { String tmp = x; x = y; y = tmp; }
        return y;
    }

    // ------------------------ COUNT ------------------------
    public static void byCount(Tweet[] arr, int esq, int dir) {
        if (esq < dir) {
            int pi = partitionCount(arr, esq, dir);
            byCount(arr, esq, pi - 1);
            byCount(arr, pi + 1, dir);
        }
    }

    private static int partitionCount(Tweet[] arr, int esq, int dir) {
        int meio = (esq + dir) / 2;
        int pivo = medianaCount(arr[esq], arr[meio], arr[dir]);

        int i = esq - 1;
        for (int j = esq; j <= dir; j++) {
            if (arr[j].getMentionedPersonCount() >= pivo) {
                i++;
                Tweet temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }

    private static int medianaCount(Tweet a, Tweet b, Tweet c) {
        int x = a.getMentionedPersonCount();
        int y = b.getMentionedPersonCount();
        int z = c.getMentionedPersonCount();
        if (x > y) { int tmp = x; x = y; y = tmp; }
        if (y > z) { int tmp = y; y = z; z = tmp; }
        if (x > y) { int tmp = x; x = y; y = tmp; }
        return y;
    }
}

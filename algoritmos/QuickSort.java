package algoritmos;

import modelo.Tweet;

public class QuickSort {

    // ------------------------ USER ------------------------
    public static void byUser(Tweet[] arr, int esq, int dir) {
        if (esq < dir) {
            int pi = partitionUser(arr, esq, dir);
            byUser(arr, esq, pi - 1);
            byUser(arr, pi + 1, dir);
        }
    }

    private static int partitionUser(Tweet[] arr, int esq, int dir) {
        String pivot = arr[dir].getUser();
        int i = esq - 1;
        for (int j = esq; j < dir; j++) {
            if (arr[j].getUser().compareToIgnoreCase(pivot) <= 0) {
                i++;
                Tweet temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Tweet temp = arr[i + 1];
        arr[i + 1] = arr[dir];
        arr[dir] = temp;
        return i + 1;
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
        String pivot = arr[dir].getDateOrdenavel();
        int i = esq - 1;
        for (int j = esq; j < dir; j++) {
            if (arr[j].getDateOrdenavel().compareTo(pivot) <= 0) {
                i++;
                Tweet temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Tweet temp = arr[i + 1];
        arr[i + 1] = arr[dir];
        arr[dir] = temp;
        return i + 1;
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
        int pivot = arr[dir].getMentionedPersonCount();
        int i = esq - 1;
        for (int j = esq; j < dir; j++) {
            if (arr[j].getMentionedPersonCount() >= pivot) {
                i++;
                Tweet temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Tweet temp = arr[i + 1];
        arr[i + 1] = arr[dir];
        arr[dir] = temp;
        return i + 1;
    }
}

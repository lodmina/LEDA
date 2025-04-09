package algoritmos;

import modelo.Tweet;

public class MergeSort {

    // ------------------------ USER ------------------------
    public static void byUser(Tweet[] arr, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            byUser(arr, esq, meio);
            byUser(arr, meio + 1, dir);
            mergeUser(arr, esq, meio, dir);
        }
    }

    private static void mergeUser(Tweet[] arr, int esq, int meio, int dir) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;
        Tweet[] L = new Tweet[n1];
        Tweet[] R = new Tweet[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[esq + i];
        for (int j = 0; j < n2; j++) R[j] = arr[meio + 1 + j];

        int i = 0, j = 0, k = esq;
        while (i < n1 && j < n2) {
            if (L[i].getUser().compareToIgnoreCase(R[j].getUser()) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // ------------------------ DATE ------------------------
    public static void byDate(Tweet[] arr, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            byDate(arr, esq, meio);
            byDate(arr, meio + 1, dir);
            mergeDate(arr, esq, meio, dir);
        }
    }

    private static void mergeDate(Tweet[] arr, int esq, int meio, int dir) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;
        Tweet[] L = new Tweet[n1];
        Tweet[] R = new Tweet[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[esq + i];
        for (int j = 0; j < n2; j++) R[j] = arr[meio + 1 + j];

        int i = 0, j = 0, k = esq;
        while (i < n1 && j < n2) {
            if (L[i].getDateOrdenavel().compareTo(R[j].getDateOrdenavel()) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // ------------------------ COUNT ------------------------
    public static void byCount(Tweet[] arr, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            byCount(arr, esq, meio);
            byCount(arr, meio + 1, dir);
            mergeCount(arr, esq, meio, dir);
        }
    }

    private static void mergeCount(Tweet[] arr, int esq, int meio, int dir) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;
        Tweet[] L = new Tweet[n1];
        Tweet[] R = new Tweet[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[esq + i];
        for (int j = 0; j < n2; j++) R[j] = arr[meio + 1 + j];

        int i = 0, j = 0, k = esq;
        while (i < n1 && j < n2) {
            if (L[i].getMentionedPersonCount() >= R[j].getMentionedPersonCount()) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}

package algoritmos;

import modelo.Tweet;

public class HeapSort {

    // ------------------------ USER ------------------------
    public static void byUser(Tweet[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyUser(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            Tweet temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifyUser(arr, i, 0);
        }
    }

    private static void heapifyUser(Tweet[] arr, int n, int i) {
        int maior = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        if (esq < n && arr[esq].getUser().compareToIgnoreCase(arr[maior].getUser()) > 0)
            maior = esq;

        if (dir < n && arr[dir].getUser().compareToIgnoreCase(arr[maior].getUser()) > 0)
            maior = dir;

        if (maior != i) {
            Tweet swap = arr[i];
            arr[i] = arr[maior];
            arr[maior] = swap;

            heapifyUser(arr, n, maior);
        }
    }

    // ------------------------ DATE ------------------------
    public static void byDate(Tweet[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyDate(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            Tweet temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifyDate(arr, i, 0);
        }
    }

    private static void heapifyDate(Tweet[] arr, int n, int i) {
        int maior = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        if (esq < n && arr[esq].getDateOrdenavel().compareTo(arr[maior].getDateOrdenavel()) > 0)
            maior = esq;

        if (dir < n && arr[dir].getDateOrdenavel().compareTo(arr[maior].getDateOrdenavel()) > 0)
            maior = dir;

        if (maior != i) {
            Tweet swap = arr[i];
            arr[i] = arr[maior];
            arr[maior] = swap;

            heapifyDate(arr, n, maior);
        }
    }

    // ------------------------ COUNT ------------------------
    public static void byCount(Tweet[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyCount(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            Tweet temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifyCount(arr, i, 0);
        }
    }

    private static void heapifyCount(Tweet[] arr, int n, int i) {
        int maior = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        if (esq < n && arr[esq].getMentionedPersonCount() > arr[maior].getMentionedPersonCount())
            maior = esq;

        if (dir < n && arr[dir].getMentionedPersonCount() > arr[maior].getMentionedPersonCount())
            maior = dir;

        if (maior != i) {
            Tweet swap = arr[i];
            arr[i] = arr[maior];
            arr[maior] = swap;

            heapifyCount(arr, n, maior);
        }
    }
}

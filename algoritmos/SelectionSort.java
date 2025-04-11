package algoritmos;

import modelo.Tweet;

public class SelectionSort {

    // ------------------------ USER ------------------------
    public static void byUser(Tweet[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].getUser().compareToIgnoreCase(arr[minIdx].getUser()) < 0) {
                    minIdx = j;
                }
            }
            Tweet temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // ------------------------ DATE ------------------------
    public static void byDate(Tweet[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].getDateOrdenavel().compareTo(arr[minIdx].getDateOrdenavel()) < 0) {
                    minIdx = j;
                }
            }
            Tweet temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // ------------------------ COUNT ------------------------
    public static void byCount(Tweet[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].getMentionedPersonCount() > arr[maxIdx].getMentionedPersonCount()) {
                    maxIdx = j;
                }
            }
            Tweet temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }
}

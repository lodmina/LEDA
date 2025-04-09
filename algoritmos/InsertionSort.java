package algoritmos;

import modelo.Tweet;

public class InsertionSort {

    public static void byDate(Tweet[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Tweet chave = arr[i];
            int j = i - 1;
            while (j >= 0 && chave.getDateOrdenavel().compareTo(arr[j].getDateOrdenavel()) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = chave;
        }
    }

    public static void byUser(Tweet[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Tweet chave = arr[i];
            int j = i - 1;
            while (j >= 0 && chave.getUser().compareToIgnoreCase(arr[j].getUser()) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = chave;
        }
    }

    public static void byCount(Tweet[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Tweet chave = arr[i];
            int j = i - 1;
            while (j >= 0 && chave.getMentionedPersonCount() > arr[j].getMentionedPersonCount()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = chave;
        }
    }
}


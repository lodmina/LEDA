package algoritmos;

import modelo.Tweet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



public class CountingSort {

    // ------------------------ USER ------------------------
    public static void byUser(Tweet[] arr) {
        Map<String, List<Tweet>> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        for (Tweet tweet : arr) {
            String user = tweet.getUser();
            map.computeIfAbsent(user, k -> new ArrayList<>()).add(tweet);
        }

        int index = 0;
        for (List<Tweet> grupo : map.values()) {
            for (Tweet tweet : grupo) {
                arr[index++] = tweet;
            }
        }
    }

    // ------------------------ DATE ------------------------
    public static void byDate(Tweet[] arr) {
        Map<String, List<Tweet>> map = new TreeMap<>();

        for (Tweet tweet : arr) {
            String data = tweet.getDateOrdenavel(); // yyyyMMdd
            map.computeIfAbsent(data, k -> new ArrayList<>()).add(tweet);
        }

        int index = 0;
        for (List<Tweet> grupo : map.values()) {
            for (Tweet tweet : grupo) {
                arr[index++] = tweet;
            }
        }
    }

    // ------------------------ COUNT ------------------------
    public static void byCount(Tweet[] arr) {
        if (arr.length == 0) return;

        // Encontra o maior valor de count
        int max = Arrays.stream(arr)
                .mapToInt(Tweet::getMentionedPersonCount)
                .max()
                .orElse(0);

        // Cria buckets para cada count
        List<List<Tweet>> buckets = new ArrayList<>(max + 1);
        for (int i = 0; i <= max; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Tweet tweet : arr) {
            buckets.get(tweet.getMentionedPersonCount()).add(tweet);
        }

        // Monta o array final em ordem decrescente
        int index = 0;
        for (int i = max; i >= 0; i--) {
            for (Tweet tweet : buckets.get(i)) {
                arr[index++] = tweet;
            }
        }
    }
}

package util;

import modelo.Tweet;

import java.io.*;

public class CSVUtils {
    public static Tweet[] lerCSV(String caminho) {
        int tamanho = contarLinhas(caminho);
        Tweet[] tweets = new Tweet[tamanho];
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha = reader.readLine();
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (partes.length < 8) {
                    continue;
                }

                tweets[count++] = new Tweet(
                        partes[0], partes[1], partes[2], partes[3], partes[4], partes[5],
                        partes[6], Integer.parseInt(partes[7])
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Tweet[] resultado = new Tweet[count];
        for (int i = 0; i < count; i++) resultado[i] = tweets[i];
        return resultado;
    }

    public static int contarLinhas(String caminho) {
        int linhas = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            reader.readLine();
            while (reader.readLine() != null) {
                linhas++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }

    public static void escreverCSV(String caminho, Tweet[] tweets) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            writer.write("Target,ID,Date,Flag,User,Text,MentionedPerson,MentionedPersonCount\n");
            for (Tweet t : tweets) {
                writer.write(t.getTarget() + "," + t.getId() + "," + t.getDate() + "," + t.getFlag() + "," + t.getUser() + "," +
                        t.getText() + "," + t.getMentionedPerson() + "," + t.getMentionedPersonCount() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

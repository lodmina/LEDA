package util;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVTransformation {
    public static void execute() {
        String caminhoArquivo = "tweets.csv";
        String arquivoFormatado = "tweets_formated_data.csv";

        //TRANSFORMANDO A DATA PARA DD/MM/AAA
        SimpleDateFormat formatoOriginal = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        SimpleDateFormat formatoDesejado = new SimpleDateFormat("dd/MM/yyyy");
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(caminhoArquivo), "ISO-8859-1"));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivoFormatado), "ISO-8859-1"))
        ) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    bw.write(linha);
                    bw.newLine();
                    primeiraLinha = false;
                    continue;
                }

                String[] partes = linha.split(",", 6);

                if (partes.length == 6) {
                    try {
                        Date data = formatoOriginal.parse(partes[2].trim());
                        partes[2] = formatoDesejado.format(data);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    bw.write(String.join(",", partes));
                    bw.newLine();
                } else {
                    bw.write(linha);
                    bw.newLine();
                }
            }

            System.out.println("Conversão concluída: " + arquivoFormatado);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //SEGUNDA TRANSFORMAÇÃO
        String inputFile = "tweets_formated_data.csv";
        String outputFile = "tweets_mentioned_persons.csv";

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "ISO-8859-1"));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "ISO-8859-1"))
        ) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = reader.readLine()) != null) {
                if (primeiraLinha) {
                    writer.write(linha + ",mentioned_person,mentioned_person_count");
                    writer.newLine();
                    primeiraLinha = false;
                    continue;
                }

                String[] partes = linha.split(",", 6);
                if (partes.length < 6) {
                    writer.write(linha + ",null,0");
                    writer.newLine();
                    continue;
                }

                String texto = partes[5];

                Pattern padrao = Pattern.compile("@(\\w+)");
                Matcher matcher = padrao.matcher(texto);

                List<String> mencoes = new ArrayList<>();
                while (matcher.find()) {
                    mencoes.add(matcher.group(1));
                }

                String mencionados = mencoes.isEmpty() ? "null" : String.join("/", mencoes);
                int contagem = mencoes.size();

                writer.write(linha + "," + mencionados + "," + contagem);
                writer.newLine();
            }

            System.out.println("Arquivo gerado com sucesso: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

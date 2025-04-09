# 📊 Projeto de Análise e Ordenação de Tweets

Este projeto tem como objetivo aplicar algoritmos clássicos de ordenação em um dataset de tweets, extraindo informações úteis e comparando o desempenho dos algoritmos em diferentes casos (melhor, médio e pior).

---

## 📁 Estrutura do Projeto

```
/src
├── Main.java
├── modelos/
│   └── Tweet.java
├── util/
│   ├── CSVUtils.java
│   ├── CSVTransformation.java
│   ├── Timer.java
│   ├── DesempenhoUtils.java
│   └── ArrayUtils.java
├── algoritmos/
│   ├── SelectionSort.java
│   ├── InsertionSort.java
│   ├── MergeSort.java
│   ├── QuickSort.java
│   ├── QuickSortMediana.java
│   ├── CountingSort.java
│   └── HeapSort.java
```

---

## 🔧 Como executar

1. Coloque o arquivo original `tweets.csv` na raiz do projeto.
2. Compile e execute o `Main.java`.
3. O programa irá:
   - Transformar o CSV (ajustar datas e extrair menções com `@`)
   - Gerar um novo CSV chamado `tweets_mentioned_persons.csv`
   - Aplicar os algoritmos de ordenação nos campos:
     - `user` (ordem alfabética)
     - `date` (ordem crescente)
     - `mentionedPersonCount` (ordem decrescente)
   - Gerar arquivos CSV para cada algoritmo e caso:
     - `tweets_user_mergeSort_medioCaso.csv`
     - `tweets_user_mergeSort_melhorCaso.csv`
     - `tweets_user_mergeSort_piorCaso.csv`
     - etc.
   - Registrar o tempo de execução em `resultados_tempos.csv`

---

## 📈 Arquivo de desempenho

O arquivo `resultados_tempos.csv` registra o tempo de execução de cada algoritmo para cada campo e tipo de caso. Exemplo:

```
algoritmo,campo,caso,tempo_ns
mergeSort,user,medioCaso,1275465300
mergeSort,user,melhorCaso,767206000
mergeSort,user,piorCaso,707085000
```

- O sistema verifica se a combinação algoritmo + campo + caso já existe antes de salvar.
- Evita duplicações no arquivo de desempenho.

---

## Desenvolvido para a disciplina de LEDA (Lógica e Estrutura de Dados)

Alunas: Ludmila Maria e Laryssa Finizola
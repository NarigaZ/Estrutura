package Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Ordenacao t = new Ordenacao();
        ArrayList<String> dicio = new ArrayList<>();
        //System.out.printf("Informe o nome de arquivo texto:\n");
        String nome = "C:\\Users\\NarigaZ\\Desktop\\teste.txt";
        //System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            int tamanho = Integer.parseInt(lerArq.readLine()); // lê a primeira linha
            String vetor[] = new String[tamanho];
            int i = 0;
            String linha = "";
            linha = lerArq.readLine();
            vetor[0] = linha;
            while (linha != null) { // a variável "linha" recebe o valor "null" quando o processo
                linha = lerArq.readLine(); // lê da segunda até a última linha
                i++;
                if (i < tamanho) {
                    vetor[i] = linha;// de repetição atingir o final do arquivo texto
                }
            }
            arq.close();
            int op = 1;

            do {
                System.out.println("Escolha o metodo de Ordenacao");
                System.out.println("1 - BubleSort");
                System.out.println("0 - Sair");
                op = in.nextInt();
                switch (op) {
                    case 1:
                        vetor = t.BubleSort(vetor, tamanho);
                }
            } while (op != 0);

            FileWriter arqs = new FileWriter("C:\\Users\\NarigaZ\\Desktop\\saida.txt");
            PrintWriter gravarArq = new PrintWriter(arqs);

            for (int j = 0; j < tamanho; j++) {
                gravarArq.println(vetor[j] + "[" + vetor[j].length() + "]");
            }
            arqs.close();
            System.out.println("Arquivo Gravado com Sucesso!");
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println();
    }
}
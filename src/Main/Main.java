package Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Ordenacao t = new Ordenacao();
        Busca b = new Busca();
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
            int op2 = 1;

            do {
                System.out.println("Escolha o metodo de Busca");
                System.out.println("1 - Sequencial");
                System.out.println("2 - Binaria");
                System.out.println("0 - Sair");
                op2 = in.nextInt();
                String palavra;
                int pos;
                long tempo1, tempo2;
                switch (op2) {
                    case 1:
                        System.out.print("Qual palavra deseja buscar: ");
                        palavra = in.next();
                        pos = b.Sequencial(vetor, palavra);
                        tempo1 = System.currentTimeMillis();
                        if (pos == -1) {
                            System.out.println("Nao contem palavra");
                            tempo2 = System.currentTimeMillis();
                            System.out.printf("Tempo de Busca em millisegundos : %d.\n",(tempo2 - tempo1));
                            break;
                        } else {
                            System.out.printf("Palavra na posicao [%d]", pos + 1);
                            System.out.println();
                            tempo2 = System.currentTimeMillis();
                            System.out.printf("Tempo de Busca em millisegundos : %d.\n",(tempo2 - tempo1));
                            break;
                        }
                    case 2:
                        System.out.print("Qual palavra deseja buscar: ");
                        palavra = in.next();
                        tempo1 = System.currentTimeMillis();
                        pos = b.Sequencial(vetor, palavra);
                        if (pos == -1) {
                            System.out.println("Nao contem palavra");
                            tempo2 = System.currentTimeMillis();
                            System.out.printf("Tempo de Busca em millisegundos : %d.\n",(tempo2 - tempo1));
                            break;
                        } else {
                            System.out.printf("Palavra na posicao [%d]", pos + 1);
                            System.out.println();
                            tempo2 = System.currentTimeMillis();
                            System.out.printf("Tempo de Busca em millisegundos : %d.\n",(tempo2 - tempo1));
                            break;
                        }
                }
            } while (op2 != 0);

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
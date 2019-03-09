package Main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MargeSort t = new MargeSort();
        ArrayList<String> dicio = new ArrayList<>();
        System.out.printf("Informe o nome de arquivo texto:\n");
        String nome = "C:\\Users\\Naty\\Desktop\\Portuguese (Brazilian).txt";
        System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            int tamanho = Integer.parseInt(lerArq.readLine()); // lê a primeira linha
            String vetor[] = new String[tamanho];
            int i =0;
            String linha = "";

            linha = lerArq.readLine();
            vetor[0]= linha;
            while (linha!=null) { // a variável "linha" recebe o valor "null" quando o processo
                linha = lerArq.readLine();
                i++;
                if(i<tamanho){
                    vetor[i] = linha; // de repetição atingir o final do arquivo texto
                }
                // linha = lerArq.readLine(); // lê da segunda até a última linha

            }
            arq.close();
            for (int j=0 ; j<tamanho ; j++) {
                System.out.println(vetor[j]);
            }

            vetor = t.BubleSort(vetor,tamanho);
            System.out.println();
            System.out.println("Ordenado");
            System.out.println();

            for (int j=0 ; j<tamanho ; j++) {
                System.out.println(vetor[j] + "["+vetor[j].length()+"]");
            }

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println();
    }
}
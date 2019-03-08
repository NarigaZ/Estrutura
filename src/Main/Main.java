package Main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> dicio = new ArrayList<>();
        System.out.printf("Informe o nome de arquivo texto:\n");
        String nome = in.nextLine();
        System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha
            while (linha != null) { // a variável "linha" recebe o valor "null" quando o processo
                dicio.add(linha); // de repetição atingir o final do arquivo texto
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close();
            for (String d : dicio ) {
                System.out.println(d);
            }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println();
    }
}
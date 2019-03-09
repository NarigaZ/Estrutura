package Main;

public class MargeSort {

    public String[] BubleSort (String vetor[] , int tamanho){
        for(int i = 0; i<tamanho; i++){
            for(int j = 0; j<tamanho-1; j++){
                if(vetor[j].length() > vetor[j + 1].length()){
                    String aux = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                }
            }
        }
        return vetor;
    }
}

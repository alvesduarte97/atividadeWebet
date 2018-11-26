import java.util.ArrayList;
import java.util.LinkedList;

public class BuckSort {

    private String name = "BuckSort";
    private long time = 0;

    private static BubbleSort bubbleSort = null;

    private ArrayList<Long> listTime5 = new ArrayList<>();
    private ArrayList<Long> lisTime10 = new ArrayList<>();
    private ArrayList<Long> listTime50 = new ArrayList<>();
    private ArrayList<Long> listTime100 = new ArrayList<>();
    private ArrayList<Long> listTime1000 = new ArrayList<>();
    private ArrayList<Long> listTime10000 = new ArrayList<>();

    public static BubbleSort getInstance(){
        if (bubbleSort == null){
            bubbleSort = new BubbleSort();
        }
        return bubbleSort;
    }

    public void BucketSort(int[] vetor, int maiorValor)
    {
        int numBaldes = maiorValor/5;

        LinkedList[] B = new LinkedList[numBaldes];

        time = System.currentTimeMillis();

        for (int i = 0; i < numBaldes; i++){
            B[i] = new LinkedList<Integer>();
        }

        //Coloca os valores no balde respectivo:
        for (int i = 0; i < vetor.length; i++) {
            int j = numBaldes-1;
            while (true){
                if(j<0){
                    break;
                }
                if(vetor[i] >= (j*5)){
                    B[j].add(vetor[i]);
                    break;
                }
                j--;
            }
        }

        //Ordena e atualiza o vetor:
        int indice = 0;
        for (int i = 0; i < numBaldes; i++){

            int[] aux = new int[B[i].size()];

            //Coloca cada balde num vetor:
            for (int j = 0; j < aux.length; j++){
                aux[j] = (Integer)B[i].get(j);
            }

            InsertSort.getInstance().insertionSort(aux); //algoritmo escolhido para ordenação.

            // Devolve os valores ao vetor de entrada:
            for (int j = 0; j < aux.length; j++, indice++){
                vetor[indice] = aux[j];
            }

        }

        time = System.currentTimeMillis() - time;

        switch (vetor.length){
            case 5:
                listTime5.add(time);
                break;
            case 10:
                lisTime10.add(time);
                break;
            case 50:
                listTime50.add(time);
                break;
            case 100:
                listTime100.add(time);
                break;
            case 1000:
                listTime1000.add(time);
                break;
            case 10000:
                listTime10000.add(time);
                break;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public ArrayList<Long> getListTime5() {
        return listTime5;
    }

    public void setListTime5(ArrayList<Long> listTime5) {
        this.listTime5 = listTime5;
    }

    public ArrayList<Long> getLisTime10() {
        return lisTime10;
    }

    public void setLisTime10(ArrayList<Long> lisTime10) {
        this.lisTime10 = lisTime10;
    }

    public ArrayList<Long> getListTime50() {
        return listTime50;
    }

    public void setListTime50(ArrayList<Long> listTime50) {
        this.listTime50 = listTime50;
    }

    public ArrayList<Long> getListTime100() {
        return listTime100;
    }

    public void setListTime100(ArrayList<Long> listTime100) {
        this.listTime100 = listTime100;
    }

    public ArrayList<Long> getListTime1000() {
        return listTime1000;
    }

    public void setListTime1000(ArrayList<Long> listTime1000) {
        this.listTime1000 = listTime1000;
    }

    public ArrayList<Long> getListTime10000() {
        return listTime10000;
    }

    public void setListTime10000(ArrayList<Long> listTime10000) {
        this.listTime10000 = listTime10000;
    }
}
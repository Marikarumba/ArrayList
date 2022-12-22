import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        int [] array= generateRandom();
       benchmarkSort(Arrays.copyOf(array,array.length),Main::bubbleSort);
       benchmarkSort(Arrays.copyOf(array,array.length),Main::selectionSort);
       benchmarkSort(Arrays.copyOf(array,array.length),Main::insertionSort);
    }

    private static void benchmarkSort(int [] array, Consumer<int[]> sort) {
        long start = System.currentTimeMillis();
        sort.accept(array);
        System.out.println(isSorted(array));
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j]>array[j+1]){
                    int tmp = array[j+1];
                    array[i+1] = array [j];
                    array[j] = tmp;
                }
            }
        }
    }
    private static void selectionSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int minInd = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minInd]) {
                    minInd = j;
                }
            }
            int tmp = array[i];
            array[i] = array [minInd];
            array[minInd] = tmp;
        }
    }
    private static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i;
            while (j>0 && array[j-1]>=tmp){
                array[j]=array[j-1];
                j--;
            }
            array[j]=tmp;
        }
    }
    private static boolean isSorted(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    private static int[] generateRandom(){
        return IntStream.generate(()-> ThreadLocalRandom.current()
                        .nextInt(0,1_000_000))
                .limit(100_000)
                .toArray();
    }
}
//bubbleSort
//29_195
//selectionSort
//14_609
//insertionSort
//1_944
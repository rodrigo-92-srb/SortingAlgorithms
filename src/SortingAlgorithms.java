import java.util.Arrays;

public class SortingAlgorithms {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    // Troca os elementos arr[i-1] e arr[i]
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            n--; // Reduz o tamanho do intervalo de ordenação
        } while (swapped);
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1); // Ordena a parte esquerda do pivô
            quickSort(arr, pivotIndex + 1, high); // Ordena a parte direita do pivô
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Troca os elementos arr[i] e arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Troca o pivô (arr[high]) com o elemento em arr[i+1]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array não ordenado: " + Arrays.toString(arr));

        // Bubble Sort
        bubbleSort(arr.clone()); // Clone o array para não alterar a versão original
        System.out.println("Array ordenado com Bubble Sort: " + Arrays.toString(arr));

        // Quick Sort
        quickSort(arr.clone(), 0, arr.length - 1); // Clone o array para não alterar a versão original
        System.out.println("Array ordenado com Quick Sort: " + Arrays.toString(arr));
    }
}

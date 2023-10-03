public class BasicSorting {
    public static <E extends Comparable<E>> void selectionSort(E[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            E temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static <E extends Comparable<E>> void insertionSort(E[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    E temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static <E extends Comparable<E>> void insertionSortAlternative(E[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            E current = a[i];
            int j = i - 1;

            while (j > 0 && current.compareTo(a[j]) < 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j] = current;
        }

    }

    public static <E extends Comparable<E>> void printArray(E[] a) {
        for (E item : a) {
            System.out.print(item + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        String[] array1 = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        printArray(array1);
        selectionSort(array1);
        printArray(array1);
        String[] array2 = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        printArray(array2);
        insertionSort(array2);
        printArray(array2);
    }
}
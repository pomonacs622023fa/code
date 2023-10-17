public class QuickSort {

    private static <E extends Comparable<E>> void quickSort(E[] a, int lo, int hi) {
        if (lo < hi){
            int pivot = partition(a, lo, hi);
            quickSort(a, lo, pivot - 1);
            quickSort(a, pivot + 1, hi);
        }

    }

    public static <E extends Comparable<E>> void quickSort(E[] a) {
        quickSort(a, 0, a.length - 1);
    }

    // partition the subarray a[lo..hi] so that a[lo..pivot-1] <= a[pivot] <= a[pivot+1..hi] and
    // return the partitioning index i.
    private static <E extends Comparable<E>> int partition(E[] a, int lo, int hi) {
        int i = lo-1;
        E pivot = a[hi];
        for(int j = lo; j < hi; j++ ){
			if(a[j].compareTo(pivot) <= 0 ) {
				i++;
                E temp = a[i];
                a[i] = a[j];
                a[j] = temp;			
            }
		}

        i++;
        E temp = a[i];
        a[i] = a[hi];
        a[hi] = temp;	
        	
        return i;    
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
        quickSort(array1);
        printArray(array1);
    }
}

public class QuickSort {

    private static <E extends Comparable<E>> void quickSort(E[] a, int lo, int hi) {
        if (lo < hi){
            int pi = partition(a, lo, hi);
            quickSort(a, lo, pi - 1);
            quickSort(a, pi + 1, hi);
        }

    }

    public static <E extends Comparable<E>> void quickSort(E[] a) {
        quickSort(a, 0, a.length - 1);
    }

    // partition the subarray a[lo..hi] so that a[lo..pi-1] <= a[pi] <= a[pi+1..hi] and
    // return the partitioning index pi.
    private static <E extends Comparable<E>> int partition(E[] a, int lo, int hi) {
        int pi = lo-1;

        for(int j = lo; j < hi; j++ ){
			if(a[j].compareTo(a[hi]) <= 0 ) {
				pi++;
                E temp = a[pi];
                a[pi] = a[j];
                a[j] = temp;			
            }
		}

        pi++;
        E temp = a[pi];
        a[pi] = a[hi];
        a[hi] = temp;	
        	
        return pi;    
    }

    public static <E extends Comparable<E>> void printArray(E[] a) {
        for (E item : a) {
            System.out.print(item + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        System.out.println(args[0]);
        String[] array1 = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        printArray(array1);
        quickSort(array1);
        printArray(array1);
    }
}

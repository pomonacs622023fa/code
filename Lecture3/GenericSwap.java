
public class GenericSwap {
	public static <T> void swap(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main (String args[]) {
		String[] a = {"hello", "world!"};
		for(String item:a) {
			System.out.println(item);
		}
		swap(a, 0,1);
		for(String item:a) {
			System.out.println(item);
		}
	}
	
	
}
/**
 * Illustration of the prefix/postfix unary operator
 * 
 * @author https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html
 *
 */
public class PrePostDemo {

	public static void main(String[] args) {
		int i = 3;
		i++;
		// prints 4
		System.out.println(i);
		++i;
		// prints 5
		System.out.println(i);
		// prints 6
		System.out.println(++i);
		// prints 6
		System.out.println(i++);
		// prints 7
		System.out.println(i);
	}
}

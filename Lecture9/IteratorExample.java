import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class IteratorExample {
    List<Integer> myList;
    
    public IteratorExample(){
        myList = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i=0; i<100; i++){
            myList.add(rand.nextInt(100));
        }
    }

    public void iterateOldStyle(){
        Iterator<Integer> listIterator = myList.iterator(); 
        while(listIterator.hasNext()){ 
            Integer elt = listIterator.next(); 
            System.out.println(elt); 
        }
    }

    public void iterateWithForEachRemaining(){
        Iterator<Integer> listIterator = myList.iterator(); 
        listIterator.forEachRemaining(elt -> System.out.println(elt));
        // listIterator.forEachRemaining(elt -> {System.out.println(elt);}); equivalent
        // listIterator.forEachRemaining(System.out::println); //equivalent
    }

    public void iterateWithForEach(){
        myList.forEach(elt -> System.out.println(elt));
        // myList.forEach(elt -> {System.out.println(elt);}); //equivalent
        // myList.forEach(System.out::println); //equivalent
    }

    public static void main(String args[]){
        System.out.println("old-fashioned iteration");
        IteratorExample example = new IteratorExample();
        example.iterateOldStyle();
        System.out.println("Java 8-style iteration");
        example.iterateWithForEachRemaining();
    }


}

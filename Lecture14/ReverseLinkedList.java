public class ReverseLinkedList<Item> extends SinglyLinkedList<Item>{

    public void reverseLinkedList() {
		Node previous = null;
		Node current = head;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}


    public static void main(String[] args) {
		ReverseLinkedList<Integer> sll = new ReverseLinkedList<Integer>();
		sll.add(1);
		sll.add(2);
		sll.add(3);
        System.out.println(sll);
		sll.reverseLinkedList();
        System.out.println(sll);

	}


}
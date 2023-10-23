public class ReverseLinkedList<Item> extends SinglyLinkedList<Item>{

    public void reverseLinkedListIteratively() {
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

	public Node reverseLinkedListRecursively(Node head) {
		Node first;
	
		if (head==null || head.next == null)
			return head;
	
		first = reverseLinkedListRecursively(head.next);
		head.next.next = head;
		head.next = null;
	
		return first;
	}
	

    public static void main(String[] args) {
		ReverseLinkedList<Integer> sll = new ReverseLinkedList<Integer>();
		sll.add(1);
		sll.add(2);
		sll.add(3);
        System.out.println(sll);
		sll.head = sll.reverseLinkedListRecursively(sll.head);
        System.out.println(sll);
		sll.reverseLinkedListIteratively();
        System.out.println(sll);


	}


}
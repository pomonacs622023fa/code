public class UniqueSinglyLinkedList<Item> extends SinglyLinkedList<Item> {

	public void removeDuplicates() {
		Node current = head;

		while (current != null) {
			Node finger = current;

			while (finger.next != null) {
				if (finger.next.item.equals(current.item)) {
					finger.next  = finger.next.next;
				} else {
					finger = finger.next;
				}
			}

			current = current.next;
		}

	}

	public static void main(String args[]) {
		UniqueSinglyLinkedList<Integer> mylist = new UniqueSinglyLinkedList<Integer>();
		for (int i = 0; i < 5; i++) {
			mylist.add(0);
			mylist.add(1);
		}

		System.out.println(mylist); // SinglyLinkedList: [1->0->1->0->1->0->1->0->1->0] Head 1:
		mylist.removeDuplicates();
		System.out.println(mylist); // SinglyLinkedList: [1->0->] Head: 1
	}

}

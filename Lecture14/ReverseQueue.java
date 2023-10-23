public class ReverseQueue<Item> {
	
	public ArrayListQueue<Item> reversequeue(ArrayListQueue<Item> queue) {
		ArrayListStack<Item> stack = new ArrayListStack<Item>();
		while (!queue.isEmpty()) {
			stack.push(queue.peek());
			queue.dequeue();
		}
		while (!stack.isEmpty()) {
			queue.enqueue(stack.peek());
			stack.pop();
		}
		return queue;
	}

	public static void main(String args[]) {
		ReverseQueue<Integer> rq = new ReverseQueue<Integer>();
		ArrayListQueue<Integer> queue = new ArrayListQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.add(i);
		}
		System.out.println(queue);
		queue = rq.reversequeue(queue);
		System.out.println(queue);

	}

}

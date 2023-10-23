public class MyQueue<Item> {

	ArrayListStack<Item> stackNewElts, stackOldElts;

	public MyQueue() {
		stackNewElts = new ArrayListStack<Item>();
		stackOldElts = new ArrayListStack<Item>();
	}

	public int size() {
		return stackNewElts.size() + stackOldElts.size();
	}

	public void enqueue(Item value) {
		stackNewElts.push(value);
	}

	private void shiftStacks() {
		if (stackOldElts.isEmpty()) {
			while (!stackNewElts.isEmpty()) {
				stackOldElts.push(stackNewElts.pop());
			}
		}
	}

	public Item peek() {
		shiftStacks();
		return stackOldElts.peek();
	}

	public Item dequeue() {
		shiftStacks();
		return stackOldElts.pop();
	}

	public static void main(String args[]) {
		MyQueue<Integer> mq = new MyQueue<Integer>();
		for (int i = 0; i < 8; i++){
			mq.enqueue(i);
		}
		System.out.println("Size: " + mq.size());
		System.out.println("Peek: " + mq.peek());
		for (int i = 0; i < 8; i++) {
			System.out.println(mq.dequeue()); // 0 1 2 3 4 5 6 7
		}


	}

}

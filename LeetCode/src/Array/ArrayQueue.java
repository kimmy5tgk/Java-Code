package Array;

public class ArrayQueue {

	private int capacity;
	private int head; // value of front item
	private int tail;
	private int[] storage; // array is of integer value

	public ArrayQueue(int size) {
		capacity = size;
		storage = new int[capacity];
		head = tail = 0;
	}

	public void show() {
		// the top of the queue starts from array[0] then newer item gets added on the
		// tail and
		// removes in the front
		for (int i = 0; i < capacity; i++) {
			System.out.println("queue[" + i + "] = " + storage[i]); // use adjust(head+i) to adjust each item's
																			// position
		}
		System.out.println(); // note: prints optional new line for readability
	}

	private boolean isEmpty() {
		if (tail == 0) { // checks if numbers tail has reached 0 or empty
			System.out.println("Empty ! "); // print error message here
			System.out.println(); // this prints optional new line for readability
			return true;
		}
		return false; // defaults to false
	}

	private boolean isFull() {
		if (tail == capacity) { // compares if number of tail has reached capacity limit
			System.out.println("Full ! "); // print error message here
			System.out.println(); // note: this prints optional new line for readability
			return true;
		}
		return false; // note: defaults to false
	}

	// will add value to the tail of array
	public void enqueue(int value) {
		if (isFull()) {
			System.out.println("... trying to enqueue on queue[" + (tail - 1) + "] ...");
			System.out.println(" Full"); // print error message here
			System.out.println(); // note: prints optional new line for readability
		} else {
			System.out.println("... trying to enqueue on queue[" + tail + "] ...");
			storage[adjust(head + tail)] = value; // assign the value to the adjusted position of head
			tail++; // should increment or decrement?
			System.out.println(value + " was successfully added."); // what does enqueue do?
			System.out.println(); // note: prints optional new line for readability
		}
	}

	// n will remove value to the head of array
	public int dequeue() {
		if (isEmpty()) { // checks if empty, then stop
			System.out.println("... trying to dequeue head ...");
			System.out.println(" Empty !"); // print error message here
			System.out.println(); // prints optional new line for readability
		} else {
			System.out.println("... trying to dequeue head ...");
			int temp = head; // pass the value of head to a temporary variable
			storage[head] =  0; // now, empty the value of current head
			head = adjust(head + 1); // pass the next value as new head
			tail--; // should increment or decrement?
			System.out.println(head + " was successfully removed."); //  what does dequeue do?
			System.out.println(); // note: prints optional new line for readability
			return temp ; //  returns the temp as head
		}
		return 0; // note: returns the temp as head
	}

	// will wrap the array so we can adjust the position of each value towards the
	// head of array
	private final int adjust(int i) {
		return (i + capacity) % capacity;
	}

	// will show the front value or head of the array
	public int peekHead() {
		System.out.println("Head : " + storage[head]);
		if (isEmpty()) {
			return -1;
		}
		System.out.println();
		return 0;
	}

	// note: will show the front value or head of the array
	public int peekTail() {
		System.out.println("Tail : " + storage[tail - 1]);
		if (isEmpty()) {
			return -1;
		}
		System.out.println();
		return 0;
	}

	public static void main(String[] args) {
		ArrayQueue storage = new ArrayQueue(10);
		storage.enqueue(10);
		storage.enqueue(20);
		storage.enqueue(30);
		storage.enqueue(40);
		storage.enqueue(50);
		storage.enqueue(60);
		storage.enqueue(70);
		storage.enqueue(80);
		storage.enqueue(90);
		storage.enqueue(100);
		storage.dequeue();
		storage.dequeue();
		storage.show();
	}
}

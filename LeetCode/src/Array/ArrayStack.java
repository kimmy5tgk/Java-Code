package Array;

public class ArrayStack {
	

	private int capacity ; // max length of array
	private int top = 0;  // initialize a default value of top
	private String [] storage ; // array is of string values
	
	// constructor = initialize an object instance of the class
	public ArrayStack(int size) {
		capacity =10;
		storage = new String[capacity]; // update the array capacity
	}
	
	public void show() {
		// the top of the stack starts from array[0]
		// then newer item gets add on the top of another
		// until it reaches its capacity limit
		for(int i = capacity-1;i>=0;i--) {
			System.out.print(storage[i]+ "-->");
		}
	}
	private boolean isEmpty() {
		if(storage[0]==null) { // compares if index[0] or top is null or empty
			return true;
		}
		return false;
	}
	private boolean isFull() {
		if(top == capacity) { // compares if top has reached capacity limit
			System.out.println("The capacity of an array is full");
			return true;
		}
		return false;
	}
	// will add value to the array
	public void push(String value) {
		System.out.println("... trying to push on stack[" + top + "] ...");
		if(isFull()) {
			System.out.println("add failed !");
		}else {
			storage[top] = value;  // assign the value to top
			top++; 
			System.out.println(value+ " was successfully added.");
			System.out.println(); // prints optional new line for readability
		}
	}
	// will remove value to the array
	public void pop() {
		System.out.println(); // prints optional new line for readability
		System.out.println("... trying to pop stack[" + (top-1) + "] ...");
		if(isEmpty()) {
			System.out.println("removed failed");
		}else {
			System.out.println(storage[top-1] + " was successfully removed ");
			storage[top-1] = null; // empty the value of top
			top--;
			
			System.out.println();
		}
	}
	// will show the top most value of the array
	public void peek() {
	    if (isEmpty()) { 
	      System.out.println("PEEK TOP = NULL");
	      System.out.println();
	    } else {
	      System.out.println("PEEK TOP = " + storage[top-1]);
	      System.out.println();
	    }
	  }
	
	public static void main(String[] args) {
		// construct a new array queue and assign 10 as the integer value for the size limit of the stack
		ArrayStack storage = new ArrayStack(4);
	    storage.push("One");
	    storage.push("Two");
	    storage.push("Three");
	    storage.push("Four");
	    storage.push("Five");
	    storage.push("Six");
	    storage.push("Seven");
	    storage.push("Eight");
	    storage.push("Nine");
	    storage.push("Ten");
	    storage.peek();
	    storage.show();
	    storage.pop();
	    storage.show();
	  
	}

}

package ToDoApp;


public class Stack {
	private LinkedList linkedList;
	private Node top;
	
	public Stack() {
		linkedList = new LinkedList();
		top = null;
	}

	public void push(Node node) {
		 // Start >> O(1)
        linkedList.insertFirst(node);
        top = linkedList.getHead();
	}
	
	public void pop() {
		// Start >> O(1)
        linkedList.removeFirst();
        top = linkedList.getHead();
	}
	
	public Node getTop() {
		if(!isEmpty()) {
			return top;
		}
		
		return null;
	}
	
	boolean isEmpty() {
		return linkedList.getHead() == null;
	}
	
	void printStack() {
	    linkedList.printLL();
	}
	
}

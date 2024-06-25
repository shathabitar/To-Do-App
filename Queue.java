package ToDoApp;

public class Queue {
	private LinkedList linkedList;
	private Node front;
	
	public Queue() {
		linkedList = new LinkedList();
		front = null;
	}

	public void EnQueue(Node node) {
		 // Start >> O(1) 
        linkedList.insertFirst(node);
        front = linkedList.getLast();
	}
	
	public void DeQueue() {
		// End >> O(n)
		linkedList.removeLast();
		front = linkedList.getLast();	
	}
	
	public Node getFront() {
		if(!isEmpty()) {
			return front;
		}
		
		return null;
	}
	
	boolean isEmpty() {
		return linkedList.getHead() == null;
	}
	
	void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		
		printNode(linkedList.getHead());
		System.out.println();
		
	}
	
	private void printNode(Node node) {
	    if (node == null) {
	        return;
	    }

	    printNode(node.getNext());

	    System.out.print("Task Name: " + node.getName() + "\nDue date: " + node.getDue_date() + "\nPriority: " + node.getPriority() + "\nCategory: " + node.getCategory() + "\n");
	}
}

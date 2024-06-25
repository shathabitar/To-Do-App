package ToDoApp;


public class LinkedList {
	
	private Node head;
	private Node tail;

	public LinkedList() {
		head = null;
		tail = null;
	}
	
	boolean isEmpty() {
		return head == null;
	}
	
	void clear() {
		head = tail = null;
	}
	
	
	public void insertFirst(Node newNode) {
		
		if(isEmpty()) {
			head = tail = newNode;
			return;
		}
		
		newNode.setNext(head);
		head = newNode;
	}
	
	public void insertNext(Node nextNode, Node newNode) {
	    if (nextNode == null) {
	        System.out.println("Error: The next node cannot be null.");
	        return;
	    }

	    if (isEmpty()) {
	        System.out.println("Error: The linked list is empty.");
	        return;
	    }

	    if (head == nextNode) {
	        newNode.setNext(head.getNext()); 
	        head.setNext(newNode);
	        
	        if (head == tail) {
	            tail = newNode;
	        }
	        return;
	    }

	    Node current = head;
	    while (current != null && current != nextNode) {
	        current = current.getNext();
	    }

	    if (current == null) {
	        System.out.println("Error: The next node was not found in the linked list.");
	        return;
	    }

	    newNode.setNext(current.getNext());
	    current.setNext(newNode);
	    if (current == tail) {
	        tail = newNode;
	    }
	}
	
	public void insertLast(Node newNode) {
		
		
		if(isEmpty()) {
			head = tail = newNode;
			return;
		}
		
		Node current = head;
		
		while (current.getNext()!= null) {
			current = current.getNext();
			
		}
		
		current.setNext(newNode);
		tail = newNode;
		
	}
	
	public void printLL() {
		if (isEmpty()) {
			System.out.println("LinkedList is empty");
			return;
		}
		
		Node current = head;
		
		while (current != null) {
			System.out.print("Task Name: " + current.getName() + "\nDue date: " + current.getDue_date() + "\nPriority: " + current.getPriority() + "\nCategory: " + current.getCategory() + "\n");
			current = current.getNext();
			
		}
		System.out.println();
		
	}

	
	public void removeNode(Node node) {
	    if (isEmpty()) {
	        System.out.println("LinkedList is empty");
	        return;
	    }

	    
	    if (head == node) {
	        if (head.getNext() == null) {
	            head = null;
	            tail = null;  
	        } else {
	            head = head.getNext();
	        }
	        return;
	    }

	    Node current = head;
	    Node prev = null;

	    while (current != null && current != node) {
	        prev = current;
	        current = current.getNext();
	    }

	    if (current == null) {
	        return;
	    }


	    if (current.getNext() == null) {
	        tail = prev; 
	        tail.setNext(null);
	    } else {
	        prev.setNext(current.getNext());
	    }
	}
	
	
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("LL is empty");
			return;
		}
		
		if (head.getNext() == null) {
			head = null;
			return;
		}
		
		if (head.getNext() != null) {
			head = head.getNext();
			return;
		}
		
		
	}
	
	public void removeLast() {
		
		if(isEmpty()) {
			System.out.println("LL is empty");
			return;
		}
		
		if (head.getNext() == null) {
			head = null;
			return;
		}
		
		Node current = head;
		
		while (current.getNext().getNext() != null) {
			current = current.getNext();
			
		}
		tail = current;
		current.setNext(null); 
		
	}
	
	public Node getLast() {
		
		return tail;
		
	}
	
	public Node getHead() {
			
		return head;
			
	}
}

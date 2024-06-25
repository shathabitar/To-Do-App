package ToDoApp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class InternalFunctionality {

	private LinkedList linkedList;
	private Stack stack;
	private Hashtable<String,LinkedList> hashtable;
	private Queue queue;
	
	public InternalFunctionality() {
		hashtable = new Hashtable<String, LinkedList>();
		linkedList = new LinkedList();
		stack = new Stack();
		queue = new Queue();
	}
	
	
	
	public void insert(String name, String due_Date, String priority, String category) {
		insertToLinkedList(name, due_Date, priority, category);
		insertToStack(name, due_Date, priority, category);
		insertToHashTable(name, due_Date, priority, category);
		return;
		
	}
	
	public void insertToLinkedList(String name, String due_Date, String priority, String category) {
		
		Node newNode = new Node(name, due_Date, priority, category);
		
		if (linkedList.getHead() == null) {
			linkedList.insertFirst(newNode);
			return;
			
		}
		
		if ( linkedList.getHead() != null && newNode.getDue_date().before(linkedList.getHead().getDue_date())) {
			linkedList.insertFirst(newNode);
			return;
		}
		
		if ( linkedList.getLast() != null && newNode.getDue_date().after(linkedList.getLast().getDue_date())) {
			linkedList.insertLast(newNode);
			return;
		}
		
		
		Node current = linkedList.getHead();
		
		while (current.getNext() != null) {
			
			if ((newNode.getDue_date().after(current.getDue_date()) && newNode.getDue_date().before(current.getNext().getDue_date())) || newNode.getDue_date().equals(current.getNext().getDue_date())) {
				linkedList.insertNext(current, newNode);
				return;
			}
			current = current.getNext();
		}
		
	}
	
	public void insertToHashTable(String name, String dueDate, String priority, String category) {
	    Node newNode = new Node(name, dueDate, priority, category);
	    String categoryKey = newNode.getCategory().toLowerCase();
	    
	    if (!hashtable.containsKey(categoryKey)) {
	        hashtable.put(categoryKey, new LinkedList());
	    }
	    
	    LinkedList categoryList = hashtable.get(categoryKey);
	    categoryList.insertFirst(newNode);
	}
	
	public void insertToStack(String name, String due_Date, String priority, String category) {
		
		if (priority.toLowerCase().equals("urgent")) {
			Node newNode = new Node(name, due_Date, priority, category);
			stack.push(newNode);
		}

	}
	
	public void insertToQueue(String name, Date date, String priority, String category) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    String due_date = dateFormat.format(date);
		Node newNode = new Node(name, due_date, priority, category);
		queue.EnQueue(newNode);
	}
	
	
	public void completed(String name) {
	    Node current = linkedList.getHead();

	    while (current != null && !current.getName().equals(name)) {
	        current = current.getNext();
	    }


	    if (current == null) {
	        System.out.println("Node with the name " + name + " not found.");
	        return;
	    }
	    
	    insertToQueue(current.getName(), current.getDue_date(), current.getPriority(), current.getCategory());


	    if (linkedList.getHead() == current && linkedList.getLast() == current) {
	        linkedList.removeFirst();
	    } else {
	        if (linkedList.getHead() == current) {
	            linkedList.removeFirst();
	        } else if (linkedList.getLast() == current) {
	            linkedList.removeLast();
	        } else {
	            linkedList.removeNode(current);
	        }
	    }


	    
	    String categoryKey = current.getCategory().toLowerCase();
	    LinkedList categoryList = hashtable.get(categoryKey);
	   
	    Node currentHashTable = categoryList.getHead();
	    
	    while (currentHashTable != null && !currentHashTable.getName().equals(name)) {
	    	currentHashTable = currentHashTable.getNext();
	    }
	    
	    if (categoryList != null) {
	        categoryList.removeNode(currentHashTable);
	        if (categoryList.isEmpty()) {
	            hashtable.remove(categoryKey);
	        }
	    }
	    
	}



	public LinkedList getLinkedList() {
		return linkedList;
	}



	public void setLinkedList(LinkedList linkedList) {
		this.linkedList = linkedList;
	}



	public Stack getStack() {
		return stack;
	}



	public void setStack(Stack stack) {
		this.stack = stack;
	}



	public Hashtable<String, LinkedList> getHashtable() {
		return hashtable;
	}



	public void setHashtable(Hashtable<String, LinkedList> hashtable) {
		this.hashtable = hashtable;
	}



	public Queue getQueue() {
		return queue;
	}



	public void setQueue(Queue queue) {
		this.queue = queue;
	}
	
}

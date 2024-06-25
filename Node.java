package ToDoApp;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Node {
	
	private String name;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private Date due_date;
	private String priority;
	private String category;
	private Node next;
	
	
	public Node(String name, String due_Date, String priority, String category) {
	    this.name = name;
	    this.priority = priority;
	    this.category = category;
	    this.next = null;

	    try {
	        this.due_date = (Date) dateFormat.parse(due_Date);
	    } catch (ParseException e) {
	        System.out.println("Failed to parse due date: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDue_date() {
		return due_date;
	}


	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Node getNext() {
		return next;
	}


	public void setNext(Node next) {
		this.next = next;
	}
	
	
	

}

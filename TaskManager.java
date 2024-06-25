package ToDoApp;

import java.util.Scanner;

public class TaskManager {
	
	private InternalFunctionality functions; 
	private Scanner scanner = new Scanner(System.in);
	
	public TaskManager() {
		functions = new InternalFunctionality();
	}

	public void application() {
		int key = 0;
		System.out.println("Welcome to To-Do List");
		
		do {
			System.out.println(" 1 to Insert a Task \n 2 to View Tasks \n 3 to View Urgent Tasks \n 4 to View Tasks By Category"
					+ "\n 5 to View Completed Tasks \n 6 to Mark Task As Complete \n 7 to Exit");
			
			
			do {
	            System.out.print("Enter Number(1-7):");
	            String keyString = scanner.next();
	            try {
	                key = Integer.parseInt(keyString);
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a number between 1 and 7.");
	                key = 0; 
	            }
	        } while (!(key == 1 || key == 2 || key == 3 || key == 4 || key == 5 || key == 6 || key == 7));
			
		
			
			switch (key) {
			case 1: {
				insertTask();
				break;
			}
			case 2: {
				showTasks();
				break;
			}
			case 3: {
				showUrgentTasks();
				break;
			}
			case 4: {
				showTasksByCategory();
				break;
			}
			case 5: {
				showCompletedTasks();
				break;
			}
			case 6: {
				markTaskAsComplete();
				break;
			}
			case 7: {
				return;
			}
			default:
				System.err.println("Invalid Input. \nTry Again.");
			}
		
		} while (key != 7);
		
	}


	public void insertTask() {
		String name;
		String due_Date;
		String priority;
		String category;
		
		System.out.print("Enter Task Name: ");
		do {
			
			name = scanner.nextLine();
		} while (name.equals(""));
		
		
		do {
			System.out.print("Enter Task Due Date (DD-MM-YYYY):");
			due_Date = scanner.nextLine();
		} while (due_Date.equals(""));
		
		
		do {
			System.out.print("Enter Task Priority(normal/urgent): ");
			priority = scanner.nextLine();
		} while (!(priority.toLowerCase().equals("normal") || priority.toLowerCase().equals("urgent")));
		
		
		do {
			System.out.print("Enter Task Category: ");
			category = scanner.nextLine();
		} while (category.equals(""));
		
		functions.insert(name, due_Date, priority, category);
		return;
	}
	
	public void showTasks() {
		functions.getLinkedList().printLL();
	}
	
	public void showUrgentTasks() {
		functions.getStack().printStack();
	}
	
	public void showTasksByCategory() {
		for (String category : functions.getHashtable().keySet()) {
	        LinkedList value = functions.getHashtable().get(category);
	        System.out.println(category);
	        value.printLL();
	    }
		
	}
	
	public void showCompletedTasks() {
		functions.getQueue().printQueue();
	}
	
	public void markTaskAsComplete() {
		System.out.print("Enter Task Name: ");
		String name = "";
		name = scanner.next();
		functions.completed(name);
	}
}

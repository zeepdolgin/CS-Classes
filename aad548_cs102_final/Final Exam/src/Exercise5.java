////////////////////////////////////////////////////////////////
/// Program for exercise 5.
////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Exercise5 {
////////////////////////////////////////////////////////////////
// MAIN START 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("____________________________________________");
        System.out.println("Welcome to Excercise 5 program.");
        LinkedList student_list = new LinkedList();
        System.out.println("Adding students: (AAA, 10), (BBB, 20), (CCC, 15), (DDD, 35)");
        Student2 student1 = new Student2("AAA", 10);
        Student2 student2 = new Student2("BBB", 20);
        Student2 student3 = new Student2("CCC", 15);
        Student2 student4 = new Student2("DDD", 35);
        student_list.addNode(student1);
        student_list.addNode(student2);
        student_list.addNode(student3);
        student_list.addNode(student4);
        System.out.println("Original List:");
        student_list.display();
        student_list.sortList();
        System.out.println("Sorted List:");
        student_list.display();
        input.close();
    }
}// MAIN END 
////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////
// Student2 START 
class Student2 {
    private String name;
	private int grade;

    // No-arg constructor
	public Student2(){
		this.name = "";
        this.grade = 0;
	}

    // Full Constructor:
	public Student2(String name, int grade){
		this.name = name;
		this.grade = grade;
	}

    // Getters and Setters
    public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getGrade(){
		return grade;
	}
	public void setGrade(int  grade){
		this.grade = grade;
    }
    public void displayStudent(){
        System.out.println("Name: " + getName() + " Grade: " + getGrade());
        System.out.println();
    }
}// Student2 END 
////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////
// Node3 START 
class Node3 {
    Student2 student;
    Node3 next;
  
    public Node3(Student2 student){
        this.student = student;
        this.next = null;
    }
    public int get_student_grade(){
        return student.getGrade();
    }

    public String get_student_name(){
        return student.getName();
    }
    public void set_student_grade(int a){
        student.setGrade(a);
    }

    public void set_student_name(String a){
        student.setName(a);
    }
}// Node3 END 
////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////
// LinkedList START 
class LinkedList {
    public static Node3 root;
    public LinkedList() { // constructor
        root = null; // no nodes in tree yet
    }
    public Node3 head = null;
    public Node3 tail = null;

    public void addNode(Student2 student){
  
        // Create a new node
        Node3 newNode = new Node3(student);
  
        // Checks if the list is empty
        if (head == null) {
  
            // If list is empty, both head and tail will
            // point to new node
            head = newNode;
            tail = newNode;
        }
        else {
  
            // newNode will be added after tail such that
            // tail's next will point to newNode
            tail.next = newNode;
  
            // newNode will become new tail of the list
            tail = newNode;
        }
    }
// sortList() will sort nodes of the list in ascending
    // order
    public void sortList(){
        // Node current will point to head
        Node3 current = head;
        Node3 index = null;
  
        Student2 temp = new Student2();
  
        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;
  
                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.get_student_grade() > index.get_student_grade()) {
                        temp.setGrade(current.get_student_grade());
                        temp.setName(current.get_student_name());
                        current.set_student_grade(index.get_student_grade());
                        current.set_student_name(index.get_student_name());
                        index.set_student_grade(temp.getGrade());
                        index.set_student_name(temp.getName());
                    }
  
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public void display()
    {
        // Node current will point to head
        Node3 current = head;
  
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            // Prints each node by incrementing pointer
            current.student.displayStudent();
            current = current.next;
        }
  
        System.out.println();
    }
}// LinkedList END 
////////////////////////////////////////////////////////////////

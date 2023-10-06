////////////////////////////////////////////////////////////////
/// Program for exercise 3.
////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Exercise3 {
////////////////////////////////////////////////////////////////
// MAIN START 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("____________________________________________");
        System.out.println("Welcome to Excercise 3 program.");
        System.out.println("Lets build a BST of students!");
        System.out.println("Please choose from one of the following options:");
        System.out.println("1. Create BST (initiate the default students into a BTS tree by their grades)," + 
        "\n2. Insert a new Student," + 
        "\n3. Delete a Student," + 
        "\n4. Search for a Student and display their grade," +
        "\n5. Display Student's grades (sorted)," +
        "\n6. Display all Student's grades above a certain value entered by the user," +
        "\n7. Exit.");
        String s = "What do you want to do next? (PLEASE ONLY ENTER INTEGERS)";
        Tree2 theTree2 = new Tree2();
        int option_choice = 0;
        do{
            option_choice = input.nextInt();
            input.nextLine();
            switch(option_choice){

                case 1:
                System.out.println("Creating a BST of students, adding (A, 100), (BB, 90), (CCC, 80), (DDDD, 95)");
                Student a = new Student("A", 100);
                Student b = new Student("BB", 90);
                Student c = new Student("CCC", 80);
                Student d = new Student("DDDD", 95);
                theTree2.insert(a);
                theTree2.insert(b);
                theTree2.insert(c);
                theTree2.insert(d);
                System.out.println(s);
                break;

                case 2:
                System.out.println("Please enter the name of the student you want to insert into the BST:");
                String name = input.nextLine();
                System.out.println("Please enter the grade of the student you want to insert into the BST:");
                int grade = input.nextInt();
                Student n = new Student(name, grade);
                theTree2.insert(n);
                System.out.println(s);
                break;

                case 3:
                System.out.print("Enter the Name of the Student you want to delete: ");
                String name_to_delete = input.nextLine();
                int grade_to_delete = theTree2.find_grade(name_to_delete);
                if(grade_to_delete != -100){
                    System.out.println(grade_to_delete);
                    boolean didDelete = theTree2.delete(grade_to_delete);
                    if (didDelete) {
                        System.out.println("Deleted: " + name_to_delete + "," + grade_to_delete + ".");
                            
                    }
                }else{
                    System.out.println("Student with name: '" + name_to_delete + "' could not be found!");
                }
                System.out.println(s);
                break;

                case 4:
                System.out.print("Enter the Name of the Student you want to find: ");
                String name_to_find = input.nextLine();
                theTree2.find(name_to_find);
                System.out.println(s);
                break;

                case 5:
                System.out.println("Displaing sorted grades:");
                int cutoff_max = Integer.MIN_VALUE;
                theTree2.traverse_in_order(cutoff_max);
                System.out.println();
                System.out.println(s);
                break;

                case 6:
                System.out.println("Please enter the cut-off grade (integer).");
                int cutoff = input.nextInt();
                input.nextLine();
                System.out.println("Displaing sorted grades above " + cutoff + ":");
                theTree2.traverse_in_order(cutoff);
                break;

                case 7:
                System.out.println("Thank you for using Excercise 3 program!");
                System.out.println("_________________________________________________");
                break;

                default:
                System.out.println("No such option, please try again");
                break;
            }
        }while(option_choice != 8);

        input.close();
        
    }
}
// MAIN END 
////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////
// Tree2 START 
class Tree2 {

    boolean found_student = false;
    int c = -100; // the only way I managed to get just the grade out of a recursive find_grade_in_order() method.
    public static Node2 root; // first node of tree

    // -------------------------------------------------------------
    public Tree2() { // constructor
        root = null; // no nodes in tree yet
    }
    public int stringCompare(String str1, String str2){
  
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);
  
        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);
  
            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        if (l1 != l2) {
            return l1 - l2;
        }
  
        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }
    // -------------------------------------------------------------
    public void insert(Student student) {
        Node2 newNode = new Node2(); // make new node
        newNode.student = student; // insert data
        if (root == null) // no node in root
            root = newNode;
        else // root occupied
        {
            Node2 current = root; // start at root
            Node2 parent;
            while (true) // (exits internally)
            {
                parent = current;
                if (student.getGrade() < current.GET_student_grade()) // go left?
                {
                    current = current.leftChild;
                    if (current == null) // if end of the line,
                    { // insert on left
                        parent.leftChild = newNode;
                        return;
                    }
                } // end if go left
                else // or go right?
                {
                    current = current.rightChild;
                    if (current == null) // if end of the line
                    { // insert on right
                        parent.rightChild = newNode;
                        return;
                    }
                } // end else go right
            } // end while
        } // end else not root
    } // end insert()

    public void traverse_in_order(int cutoff) {
        inOrder(root, cutoff); 
    }
    // -------------------------------------------------------------
    public void inOrder(Node2 localRoot, int cutoff) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild, cutoff);
            if(localRoot.GET_student_grade() >= cutoff){
                System.out.print("| Name - '" + localRoot.GET_student_name() + "';  Grade - " + localRoot.GET_student_grade() + "|");
            }
            inOrder(localRoot.rightChild, cutoff);
        }
    }
    // -------------------------------------------------------------
    public void find(String name) { // find node with given name (assumes non-empty tree)
        find_in_order(root, name);
        if(!found_student){
            System.out.println("Student with name: '" + name + "' could not be found!");
        }else{
            found_student = false;
        }
    }
    
    public void find_in_order(Node2 localRoot, String name) { // find node with given name (assumes non-empty tree)
        if (localRoot != null) {
            find_in_order(localRoot.leftChild, name);
            if(localRoot.GET_student_name().equals(name)){
                System.out.println("Found: Name - '" + localRoot.GET_student_name() + "';  Grade - " + localRoot.GET_student_grade() + ".");
                found_student = true;
            }
            find_in_order(localRoot.rightChild, name);
        }
    } // end find()

    // -------------------------------------------------------------
    public int find_grade(String name){
        find_grade_in_order(root, name);
        return c;
    }
    public void find_grade_in_order(Node2 localRoot, String name_to_find) { // find the grade of a student with given name
        if (localRoot != null) {
            find_grade_in_order(localRoot.leftChild, name_to_find);
            if(localRoot.GET_student_name().equals(name_to_find)){
                c = localRoot.GET_student_grade();
            }
            find_grade_in_order(localRoot.rightChild, name_to_find);
        }
    } // end find()

    public boolean delete(int grade_to_delete) { // delete node with given key (assumes non-empty list)
        Node2 current = root;
        Node2 parent = root;
        boolean isLeftChild = true;
        while (current.GET_student_grade() != grade_to_delete) // search for node
        {
            parent = current;
            if (grade_to_delete < current.GET_student_grade()) // go left?
            {
                isLeftChild = true;
                current = current.leftChild;
            } else // or go right?
            {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) // end of the line,
                return false; // didn't find it
        } // end while
        // found node to delete

        // if no children, simply delete it
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) // if root,
                root = null; // tree is empty
            else if (isLeftChild)
                parent.leftChild = null; // disconnect
            else // from parent
                parent.rightChild = null;
        }

        // if no right child, replace with left subtree
        else if (current.rightChild == null)
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;

        // if no left child, replace with right subtree
        else if (current.leftChild == null)
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;

        else // two children, so replace with inorder successor
        {
            // get successor of node to delete (current)
            Node2 successor = getSuccessor(current);

            // connect parent of current to successor instead
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;

            // connect successor to current's left child
            successor.leftChild = current.leftChild;
        } // end else two children
        // (successor cannot have a left child)
        return true; // success
    } // end delete()

    private Node2 getSuccessor(Node2 delNode) {
        Node2 successorParent = delNode;
        Node2 successor = delNode;
        Node2 current = delNode.rightChild; // go to right child
        while (current != null) // until no more
        { // left children,
            successorParent = successor;
            successor = current;
            current = current.leftChild; // go to left child
        }
        // if successor not
        if (successor != delNode.rightChild) // right child,
        { // make connections
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
}// Tree2 END 
////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////
// Node2 START 
class Node2 {

    public Student student; // data item (key)
    public Node2 leftChild; // this node's left child
    public Node2 rightChild; // this node's right child

    public void displayNode() // display yourself
    {
        student.displayStudent();
    }
    public void Set_student_grade(int grade){
        this.student.setGrade(grade);
    }
    public void Set_student_name(String name){
        this.student.setName(name);
    }

    public int GET_student_grade(){
        return student.getGrade();
    }

    public String GET_student_name(){
        return student.getName();
    }

} // Node2 END 
////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////
// Student START 
class Student {
    private String name;
	private int grade;

    // No-arg constructor
	public Student(){
		this.name = "Empty";
        this.grade = -100;
	}

    // Full Constructor:
	public Student(String name, int grade){
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
}// Student END 
////////////////////////////////////////////////////////////////


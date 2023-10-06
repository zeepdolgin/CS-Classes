import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestDriver {

	public static void main(String[] args) throws Exception{
		
		
		// Testing for Character (Stack<Character>)
		System.out.println("|___________________________________Testing for Character__________________________________|"); 
		// create a stack of Characters
		Stack<Character> stack = new Stack<>();
		
		char c = 'x';
		
		// test push
		for(int i = 0; i <= 5; i++)
			stack.push(c);
		
		// test pop
		System.out.println("Popped " + stack.pop());
		
		// test display
		System.out.println("Displaying entire stack");
		stack.display();
		System.out.println("Displaying stack from 1 to 3");
		stack.display(1, 3);
		// test search
		System.out.println("searching for char: " + c);
		stack.search(c);
		System.out.println("|______________________________End of Testing for Character______________________________|"); 
		
		// Testing for Integer (Stack<Integer>)
		System.out.println("|___________________________________Testing for Integer___________________________________|"); 
		// create a stack of Characters
		Stack<Integer> stack1 = new Stack<>();
		
		int int1 = 1;
		
		// test push
		for(int i = 0; i <= 5; i++)
			stack1.push(int1++);
		
		// test pop
		System.out.println("Popped " + stack1.pop());
		
		// test display
		System.out.println("Displaying entire stack");
		stack1.display();
		System.out.println("Displaying stack from 1 to 3");
		stack1.display(2, 4);
		// test search
		System.out.println("searching for Integer: 3");
		stack1.search(3);
		System.out.println("|__________________________________End of Testing for Integer_______________________________|"); 
		
		
		
		// Testing for Float (Stack<Float>)
		System.out.println("|___________________________________Testing for Float___________________________________|"); 
		// create a stack of Characters
		Stack<Float> stack2 = new Stack<>();
		
		float fl1 = 1.1404f;
		
		// test push
		for(int i = 0; i <= 5; i++)
			stack2.push(fl1);
		
		// test pop
		System.out.println("Popped " + stack2.pop());
		
		// test display
		System.out.println("Displaying entire stack:");
		stack2.display();
		System.out.println("Displaying stack from 2 to 4:");
		stack2.display(2, 4);
		// test search
		System.out.println("searching for Float: " + fl1);
		stack2.search(fl1);
		System.out.println("|__________________________________End of Testing for Float_______________________________|"); 
		
		
		// Testing for Double (Stack<Double>)
		System.out.println("|___________________________________Testing for Double___________________________________|"); 
		// create a stack of Characters
		Stack<Double> stack3 = new Stack<>();
		
		Double db1 = 333.333;
		
		// test push
		for(int i = 0; i <= 5; i++)
			stack3.push(db1);
		
		// test pop
		System.out.println("Popped: " + stack3.pop());
		
		// test display
		System.out.println("Displaying entire stack: ");
		stack3.display();
		System.out.println("Displaying stack from 2 to 4: ");
		stack3.display(2, 4);
		// test search
		System.out.println("searching for Float: " + db1);
		stack3.search(db1);
		System.out.println("|__________________________________End of Testing for Double_______________________________|"); 
		
		
		// Testing for String (Stack<String>)
		System.out.println("|___________________________________Testing for String__________________________________|"); 
		// create a stack of Characters
		Stack<String> stack4 = new Stack<>();
		
		String s1 = "HW";
		
		// test push
		for(int i = 0; i <= 4; i++)
			stack4.push(s1);
		
		// test pop
		System.out.println("Popped " + stack4.pop());
		
		// test display
		System.out.println("Displaying entire stack: ");
		stack4.display();
		System.out.println("Displaying stack from 1 to 3: ");
		stack4.display(2, 4);
		// test search
		System.out.println("searching for char: " + s1);
		stack4.search(s1);
		System.out.println("|______________________________End of Testing for Character______________________________|"); 


        System.out.println("Creating new stack of integers, 'check'.");
        
        Stack<Integer> check = new Stack<>();
        // populating stack
		for(int i = 0; i < 3; i++){
            check.push(i);
        }
        check.display();
			
		System.out.println("______________________________Testing for comparing the lengths of two given stacks: -1, 0, 1 expected output______________________________ "); 
		System.out.println(stack1.compareTo(check));
			
	}

}
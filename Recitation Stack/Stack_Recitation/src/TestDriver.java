import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestDriver {

	public static void main(String[] args) throws Exception{
		
		
		// Testing for Character (Stack<Character>)
		System.out.println("___________________________________Testing for Character__________________________________"); 
		// create a stack of Characters
		Stack<Character> stack = new Stack<>();
		
		char i = 'c';
		
		// test push
		for(int j = 0; j <= 3; j++)
			stack.push(i);
		
		// test pop
		System.out.println("Popped " + stack.pop());
		
		// test display
		System.out.println("Displaying entire stack");
		stack.display();
		System.out.println("Displaying stack from 1 to 3");
		stack.display(1, 3);
		// test search
		System.out.println("searching for char: " + i);
		stack.search(i);
		System.out.println("______________________________End of Testing for Character______________________________ "); 
		
		// Testing for Integer (Stack<Integer>)
		System.out.println("___________________________________Testing for Integer___________________________________ "); 
		// create a stack of Characters
		Stack<Integer> stack1 = new Stack<>();
		
		int i1 = 1;
		
		// test push
		for(int j = 0; j <= 4; j++)
			stack1.push(i1);
		
		// test pop
		System.out.println("Popped " + stack1.pop());
		
		// test display
		System.out.println("Displaying entire stack");
		stack1.display();
		System.out.println("Displaying stack from 1 to 3");
		stack1.display(1, 3);
		// test search
		System.out.println("searching for Integer: " + i1);
		stack1.search(i1);
		System.out.println("__________________________________End of Testing for Integer_______________________________"); 
		
		
		
		// Testing for Float (Stack<Float>)
		System.out.println("___________________________________Testing for Float___________________________________ "); 
		// create a stack of Characters
		Stack<Float> stack2 = new Stack<>();
		
		float i2 = 12.123f;
		
		// test push
		for(int j = 0; j <= 5; j++)
			stack2.push(i2);
		
		// test pop
		System.out.println("Popped " + stack2.pop());
		
		// test display
		System.out.println("Displaying entire stack");
		stack2.display();
		System.out.println("Displaying stack from 1 to 3");
		stack2.display(1, 3);
		// test search
		System.out.println("searching for Float: " + i2);
		stack2.search(i2);
		System.out.println("__________________________________End of Testing for Float_______________________________"); 
		
		
		// Testing for Double (Stack<Double>)
		System.out.println("___________________________________Testing for Double___________________________________ "); 
		// create a stack of Characters
		Stack<Double> stack3 = new Stack<>();
		
		Double i3 = 567.89;
		
		// test push
		for(int j = 0; j <= 6; j++)
			stack3.push(i3);
		
		// test pop
		System.out.println("Popped " + stack3.pop());
		
		// test display
		System.out.println("Displaying entire stack");
		stack3.display();
		System.out.println("Displaying stack from 1 to 3");
		stack3.display(1, 3);
		// test search
		System.out.println("searching for Float: " + i3);
		stack3.search(i3);
		System.out.println("__________________________________End of Testing for Double_______________________________"); 
		
		
		// Testing for String (Stack<String>)
		System.out.println("___________________________________Testing for String__________________________________"); 
		// create a stack of Characters
		Stack<String> stack4 = new Stack<>();
		
		String i4 = "HW";
		
		// test push
		for(int j = 0; j <= 2; j++)
			stack4.push(i4);
		
		// test pop
		System.out.println("Popped " + stack4.pop());
		
		// test display
		System.out.println("Displaying entire stack");
		stack4.display();
		System.out.println("Displaying stack from 1 to 3");
		stack4.display(1, 3);
		// test search
		System.out.println("searching for char: " + i4);
		stack4.search(i4);
		System.out.println("______________________________End of Testing for Character______________________________ "); 
		
	}

}

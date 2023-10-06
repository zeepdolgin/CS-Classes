package arrayStack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestDriver {

	public static void main(String[] args) throws Exception{
		
		Stack stack = new Stack();
		
		for(int i = 0; i <= 5; i++)
			stack.push(i);
		
		System.out.println("Popped " + stack.pop());
		
		stack.display();
		
		stack.display(1, 3);
		
		stack.search(3);

		Stack check = new Stack();
		for(int i = 0; i < 2; i++)
			check.push(i);
		
		System.out.println(stack.compareTo(check));
		
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("temp"));
		
		out.writeObject(stack);
		
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("temp"));
		
		Stack read = (Stack) in.readObject();
		
		read.display();
		
		System.out.println("Admin: " + read.admin);
		
		in.close();
	}

}

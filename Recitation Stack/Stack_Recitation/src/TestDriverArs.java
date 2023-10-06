import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestDriverArs {
    
    public static void main(String[] args) throws Exception{
        Integer [] ary = {};

        Stack<Integer> stack_int = new Stack<Integer>(ary);
        for(int i = 0; i <= 5; i++){
            stack_int.push(i);
        }

        System.out.println("Popped " + stack_int.pop());

        stack_int.display();
        stack_int.display(1, 3);
        stack_int.search(3);
        
        Stack<Integer> check = new Stack<Integer>(ary);
		for(int i = 0; i < 2; i++)
			check.push(i);
		
		System.out.println(stack_int.compareTo(check));
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("temp"));
		
		out.writeObject(stack_int);
		
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("temp"));
		
		Stack<Integer> read = (Stack<Integer>) in.readObject();
        read.display();
        
    }
}

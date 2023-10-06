import java.io.Serializable;
import java.util.ArrayList;

public class Stack<T> {
	T elem;
	private ArrayList<T> stack;
	int top;
	
	//Constructors
	public Stack(T elem) {
		this.elem = elem;
		this.top = -1;
	}
	public Stack() {
		stack = new ArrayList<T>();
		this.elem = elem;
		this.top = -1;
	}
	
	// Method to push the object into the stack
	public void push(T elem) {
		if(top == 6) {
			System.out.println("Stack Overflow");
			return;
		}
		else {
			stack.add(elem);
			this.top++;
			System.out.println("Pushed " + elem);
			System.out.println("Now top is:" + top);
		}
	}
	
	// Method to pop the object from the stack
	public T pop() {
		if(this.top == -1) {
			System.out.println("Stack Underflow");
		}
		else {
		T elem = stack.get(this.top);
		stack.remove(this.top);
		this.top--;	
		return elem;
		}
		return elem;
	}
	
	public void display() {
		for(int i = 0; i <= this.top; i++)
			System.out.print(stack.get(i) + " ");
		System.out.println();
	}
	
	public void display(int start, int end) {
		if(start > this.top)
			return;
		if(end > this.top)
			end = this.top;
		for(int i = start; i <= end; i++)
			System.out.print(stack.get(i) + " ");
		
		System.out.println();
	}
	
	public void search(T elem) {
		for(int i = 0; i <= this.top; i++)
			if(stack.get(i) == elem) {
				System.out.println("Found at " + i);
				return;
			}
			else if (stack.get(i).equals(elem)){
				System.out.println("Found at " + i);
				return;
			}
		
		System.out.println("Not found");
	}
    public int compareTo(Stack<T> o){
        if(this.top < o.top){
            return -1;
        }else if(this.top == o.top){
            return 0;
        }else{
            return 1;
        }
    }
}


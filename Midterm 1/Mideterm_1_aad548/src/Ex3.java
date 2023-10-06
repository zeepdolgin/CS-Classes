import java.util.Stack;

public class Ex3 {
    static Stack<String> stack = new Stack<>();
    static Stack<String> stack2 = new Stack<>();
    public static void main(String[] args) {
        stack.push("Text 1");
        stack.push("Text 2");
        stack.push("Text 3");
        stack.push("Text 4");
        stack.push("Text 5");
        stack.push("Text 6");
        stack.push("Text 7");
        System.out.println("The original stack is: "); 
        System.out.println(stack); 
        reverse(); 
        System.out.println("The reversed stack is: "); 
        System.out.println(stack); 
        System.out.println("To test the next method, the starting stack");
        System.out.println("would be the one we have got after the first reverse"); 
        System.out.println("So after the next reverse is called we need to get the original stack"); 
        reverse2();
        System.out.println("The result of the second reverse is: "); 
        System.out.println(stack2); 
    }
  
    
    static void insert(String text){
        if(stack.isEmpty()){
            stack.push(text);
        }else{
            String a = stack.pop();
            insert(text);
            stack.push(a);
        }
    }

    static void reverse(){
        if(!stack.isEmpty()){
            String text = stack.pop(); 
            reverse(); 
            insert(text);
        }
    }

    // Second stack Reverse Method that uses Recursion. Here we recursivly push from the original stack until it is empty (base Case)
    // Store the pushed string an a variable currentText, and then push it to the new stack stack2
    // the time complexity is O(N) as each recursive call is of time complexity of O(1) and we have N recursive calls where N is a size
    // of the original stack
    static void reverse2(){
        if(stack.isEmpty()){
            stack = stack;
        }
        // this else statment executes in O(1) time complexity as pop and push are O(1) methods
        else{
            String currentText = stack.pop();
            stack2.push(currentText);
            reverse2(); // recursive call
        }
    }
}


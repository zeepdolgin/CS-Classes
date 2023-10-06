
public class StackArs<T> implements Comparable<Stack<T>> {

    private T[] stackArr;
    private int top;


    public Stack(T[]t) {
        this.stackArr = t;
        this.top = -1;
        this.stackSize = 30;
    }
  

    public void push(T entry){
        if(top == stackArr.length -1){
            System.out.println("Stack Overflow");
            return;
        }
        stackArr[++top] = entry;
        System.out.println("Pushed " + entry);
    }

    public T pop() throws Exception{
        if(top == -1){
            throw new Exception("Stack Underflow");
        }
        T entry = this.stackArr[top--];
        System.out.println("Removed entry: " +entry);
        return entry;
    }

    public void display(){
        for(int i = 0; i <= top; i++){
            System.out.print(stackArr[i] + " ");
        }
        System.out.println();
    }

    public void display(int start, int end){
        if(start > top){
            return;
        }
        if(end > top){
            end = top;
        }
        if(start > end){
            return;
        }
        for(int i = start; i <= end; i++){
            System.out.println(stackArr[i] + "");
        }
        System.out.println();
    }

    public void search(int n){
        for(int i = 0; i <= top; i++){
            if((Integer)stackArr[i] == n){
                System.out.println("Found at: " + i);
                return;
            }
        }
        System.out.println("Not found.");
    }

    @Override
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



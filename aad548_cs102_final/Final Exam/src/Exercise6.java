////////////////////////////////////////////////////////////////
/// Program for exercise 6. 
////////////////////////////////////////////////////////////////
// Refered to the following tutorial to answer this question (understood the code well.):
// https://algorithms.tutorialhorizon.com/convert-infix-to-postfix-expression/
// used predefined stack class since this is not the main thing that the question is trying to test.
import java.util.Scanner;
import java.util.Stack;

public class Exercise6 {

//////////////////////////////////////////////////////////////// - Helper Method (occurance) START
    static int occurance(char chr) {
        switch (chr) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
//////////////////////////////////////////////////////////////// - Helper Method (occurance) END


//////////////////////////////////////////////////////////////// - infox_to_postfix START
    static String infox_to_postfix(String input) {

        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char chr = input.charAt(i);

            // check if char is operator
            if (occurance(chr) > 0) {
                while (stack.isEmpty() == false && occurance(stack.peek()) >= occurance(chr)) {
                    result += stack.pop();
                }
                stack.push(chr);
            } else if (chr == ')') {
                char x = stack.pop();
                while (x != '(') {
                    result += x;
                    x = stack.pop();
                }
            } else if (chr == '(') {
                stack.push(chr);
            } else {
                // character is neither operator nor prenthecies
                result += chr;
            }
        }
        for (int i = 0; i <= stack.size(); i++) {
            result += stack.pop();
        }
        return result;
    }
//////////////////////////////////////////////////////////////// - infox_to_postfix END

////////////////////////////////////////////////////////////////
// MAIN START 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("____________________________________________");
        System.out.println("Welcome to Excercise 6 program.");
        String exp = "A+(M+B)^2 - Z*(C^D-E-K)";
        System.out.println("Given an Infix Expression: " + exp);
        System.out.println("Resulting Postfix Expression: " + infox_to_postfix(exp));
        System.out.println("Please enter a string that you wish to convert into Postfix notation: ");
        String in = input.nextLine();
        System.out.println("Given an Infix Expression: " + in);
        System.out.println("Resulting Postfix Expression: " + infox_to_postfix(in));
        input.close();
        System.out.println("Thank you for using Excercise 6 program.");
        System.out.println("____________________________________________");
    }
}// MAIN END 
////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOTestOut {
    
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter the value for length:");
        int length = Integer.parseInt(in.readLine());
        System.out.println("Please enter the value for width:");
        int width = Integer.parseInt(in.readLine());

        Rectangle a = new Rectangle(length, width);

        int area = Rectangle.rectangle_area(a);
        System.out.println("The area of the rectangle with length: " + length + " and width: " + width + " is: " + area + ".");
        boolean square_test = Rectangle.square_test(a);
        System.out.println("It is: " + square_test + " that the shape with the given length of " + length + " and width of " + width + " is a square.");
    }
}

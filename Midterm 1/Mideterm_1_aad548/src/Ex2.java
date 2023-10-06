import java.util.Scanner;
public class Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the length of the array (int) that you want to work with: ");
        int length = input.nextInt();
        int[] my_array = new int[length];
        for(int i=0; i < my_array.length; i++){
            System.out.println("Please enter the number:");
            my_array[i] = input.nextInt();
        }
        int array_length = my_array.length - 1;
        input.close();
        int max = maximum(my_array, 0, array_length);
        int min = minimum(my_array, 0, array_length);
        double avg = average(my_array, array_length+1);
        double avg2 = average2(my_array, 0, array_length)/my_array.length;
        System.out.println("The max of the entered numbers is: " + max + ".");
        System.out.println("The min of the entered numbers is: " + min + ".");
        System.out.println("The average of the entered numbers is: " + avg + ".");
        System.out.println("The average2 of the entered numbers is: " + avg2 + ".");
    }

    // Method to find max:
    public static int maximum(int [] my_array, int start, int end){
        if(end == start){
            return my_array[start];
        }
        int mid = (start+end)/2;
        int max1 = maximum(my_array, start, mid);
        int max2 = maximum(my_array, mid+1, end);

        if(max1 >= max2){
            return max1;
        }else{
            return max2;
        }
    }

    // Method to find min:
    public static int minimum(int [] my_array, int start, int end){
        if(end == start){
            return my_array[start];
        }
        int mid = (start+end)/2;
        int min1 = minimum(my_array, start, mid);
        int min2 = minimum(my_array, mid+1, end);

        if(min1 <= min2){
            return min1;
        }else{
            return min2;
        }
    }

    // Method to find average
    public static double average(int [] my_array, int end){
        if(end == 1){
            return (double)my_array[end-1];
        }else{
            return ((average(my_array, end-1)*(end-1) + my_array[end-1])/end);
        }
    }

    public static double average2(int [] my_array, int start, int end){
        if(start > end)
          return 0;
        else if(start == end)
          return my_array[start];
        else{
          int mid = (start + end)/2;
          return (average2(my_array, start, mid) + average2(my_array, mid+1, end));
        }
    } 
}

    
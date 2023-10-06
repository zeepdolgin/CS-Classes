import java.util.*;
public class Ex2 {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4};
        int end = a.length;
        int max = findMax(a, end);
        System.out.println(max);

    }

    public static int findMax(int[] x, int end){
        if(end==1){
            return x[0];
        }else{
            return Math.max(x[end-1], findMax(x, end-1));
        }
    } 
}
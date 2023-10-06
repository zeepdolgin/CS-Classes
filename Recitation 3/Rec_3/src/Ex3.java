public class Ex3 {
    public static void main(String[] args) {
        int [] a = {2, -4, 3, 8};
        int end = a.length-1;
        int answer = sum(a, end);
        System.out.println("The sum of even and negative numbers in the array is: " + answer +".");
    }

    public static int sum(int[] a, int end){
        if(end<0){
            return 0;
        }
        if(a[end]%2==0 || a[end]<0){
            return a[end] + sum(a, end-1);
        }else{
            return sum(a, end-1);
        }     
    } 
}

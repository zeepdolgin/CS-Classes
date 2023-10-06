public class Ex4 {

    public static void main(String[] args) {

        int[] a = {8, 6, 19, 2, 3, 2, 1};
        int length = a.length-1;
        int max = findMax(a, 0, length);
        System.out.println(max);

    }

    public static int findMax(int[] x, int start, int end){
        if(end == start){
            return x[start];
        }
        int mid=(start+end)/2;
        int max1=findMax(x, start, mid);
        int max2=findMax(x, mid+1, end);

        if(max1 >= max2){
            return max1;
        }else{
            return max2;
        }
    } 
}

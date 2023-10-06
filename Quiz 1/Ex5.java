public class Ex5 {
   
    public static void main(String args[])
    {  
        int[] a = {12, 20, 22, 26, 30, 41, 50, 60 };
        int length = a.length;
        int goal = 50;
        int result = binarySearch(a, 0, length - 1, goal);
        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found in the array at index: " + result);
    }

    public static int binarySearch(int arr[], int start, int end, int goal)
    { 
        if (end >= start && start<arr.length-1) { 
            int mid = start + (end - start) / 2;
            if (arr[mid] == goal){
                return mid;
            }
            if (arr[mid] > goal){
                return binarySearch(arr, start, mid - 1, goal);
            }else{
                return binarySearch(arr, mid + 1, end, goal);
            }
        }else{ // if element is not present in the array
            return -1;
        } 
    }
}

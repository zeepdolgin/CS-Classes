public class Ex1 {
    public static void main(String[] args) throws Exception {
        int[] a = {33, 66, 3, 9, 40, 1, 89, -5};
        closest_1(a);
        closest_2(a);
        closest_3(a);
    }

    // First Method to find closest integers O(n^2 complexity)
    public static void closest_1(int[] a){
        int index_1 = 0;
        int index_2 = 1;
        int min_distance = Integer.MAX_VALUE;
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
               
                if(Math.abs(a[i] - a[j]) < min_distance){
                    min_distance = Math.abs((a[i] - a[j]));
                    index_1 = i;
                    index_2 = j;
                }
            }
        }
        System.out.println("Method 1: The distance between the closest pair of numbers is: " + min_distance + ". This is the difference between values: " + a[index_1] + " and " + a[index_2] + ".");
    }

    // Second Method to find closest integers O(n^2 complexity because of the way it is sorted)
    public static void closest_2(int[] a){ 
        int end = a.length-1;
        int [] sorted_array = sort(a); 
        int index_1 = 0;
        int index_2 = 1;
        int distance = Integer.MAX_VALUE; 
        for (int i=0; i < end ; i++) 
            if (sorted_array[i+1] - sorted_array[i] < distance){
                distance = sorted_array[i+1] - sorted_array[i];
                index_1 = i;
                index_2 = i+1;
            }
            System.out.println("Method 2: The distance between the closest pair of numbers is: " + distance + ". This is the difference between values: " + sorted_array[index_1] + " and " + sorted_array[index_2] + "."); 
    } 

    // Third Method to find closest integers O(n Log n because of QuickSort efficiency)
    public static void closest_3(int[] a){
        int start = 0;
        int end = a.length - 1;
        quickSort(a, start, end); 
        int index_1 = 0;
        int index_2 = 1;
        int distance = Integer.MAX_VALUE;
        for (int i=0; i < end ; i++) 
            if (a[i+1] - a[i] < distance){
                distance = a[i+1] - a[i];
                index_1 = i;
                index_2 = i+1;
            }
            System.out.println("Method 3: The distance between the closest pair of numbers is: " + distance + ". This is the difference between values: " + a[index_1] + " and " + a[index_2] + ".");
    }


    // Method to sort the array with 2 for-loops (Time comlexity O(N^2))
    public static int[] sort(int[]a){
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                int temporary = 0;
                if(a[i] > a[j]){
                    temporary = a[i];
                    a[i] = a[j];
                    a[j] = temporary;
                }
            }
        }
        return a;
    }

    // Quicksort Method (Time complexity O(n log(n)))

    public static void quickSort(int[] a, int start, int end) {
		if (a == null || a.length == 0){
            return;
        }
		if (start >= end){
            return;
        }
		int mid = start + (end - start) / 2;
		int pivot = a[mid];
		int i = start, j = end;
		while (i <= j) {
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		if (start < j){
            quickSort(a, start, j);
        }
		if (end > i){
            quickSort(a, i, end);

        }
	}
}

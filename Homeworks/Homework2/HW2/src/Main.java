import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("CS-102, HW2, Arseniy Dolgin, aad548@nyu.edu");
		
		// Part I (Arrays)
        // Excercise 1
		System.out.println("Testing №1 (Arrays) Exercise 1");
		System.out.println("The runing time of the algorithm of IsReverse() is o(n) as it uses one for loop that runs thought the lenght of the strings. ");
		System.out.println("'n' in this algorithm is the number of characters in the entered string");
		int result1 = IsReverse();
		System.out.println("The result of 2 strings inverse-comparison is: " + result1);
		System.out.println("End of testing for №1 (Arrays) Exercise 1");
		System.out.println("_______________________");
        // Excercise 2
		System.out.println("Testing №1 (Arrays) Exercise 2");
		System.out.println("The runing time of the algorithm of shortest_of_three() is o(n2) as it uses one for loops that are dependent on the number of space separated words. ");
		System.out.println("n in this algorithm is number of space separated words in the entered string");
		shortest_of_three();
		System.out.println("End of testing №1 (Arrays) Exercise 2");
		System.out.println("_______________________");

		
        
        // Part II (Recursion)
        // Excercise 1
		System.out.println("Testing №2 (Recursion) Excercise 1, Finding maximum of a given array with recursion");
		System.out.println("The runing time of the algorithm of maxWithRecursion is o(log(n)) as it uses recusion and splits the array by 2 everytime the recursive call is made");
		System.out.println("n in this algorithm is the lenght of the array that is put in the method");
		int[] testarray = { 4, 7, 8, -5, 9, 22, 0, 12, 101, 96, -10, 40, 14 };
		System.out.println("Test array like: { 4, 7, 8, -5, 9, 22, 0, 12, 101, 96, -10, 40, 14 }");
		System.out.println("the largest number in the test array is: " + maxWithRecursion(testarray, testarray.length));
		System.out.println("End of testing for №2 (Recursion) Excercise 1");
		System.out.println("_______________________");
        // Excercise 2
		System.out.println("Testing №2 (Recursion) Excercise 2, Finding number of zeroes in the binary representation of the N");
		System.out.println("The runing time of the algorithm of numberOfZeros is o(log(n)) as it uses recusion and keeps deviding number by 2 everytime the recursive call is made");
		System.out.println("n in this algorithm is the lenght of the array that is put in the method");
		int test_input_1 = 4;
		System.out.println("The number of zeros in binary representation of " + test_input_1 + " is: " + numberOfZeros(test_input_1));
		System.out.println("End of Testing №2 (Recursion) Excercise 2");
		System.out.println("__________________________");
        // Excercise 3
		System.out.println("Testing №2 (Recursion) Excercise 3, is a word a palindrome?");
		System.out.println("The runing time of the algorithm of numberOfZeros is o(log(n)) as it uses recusion and keeps checking to last characters.");
		System.out.println("n in this algorithm is the lenght of the input string that is put in the method");
		String test_input_2 = "kayak";
		System.out.println(test_input_2 + " status (1 = palindrome, 0 = not palindrome) is: " + isPalpalindrome(test_input_2, 0, 4));
		String test_input_3 = "radar";
		System.out.println(test_input_3 + " status (1 = palindrome, 0 = not palindrome) is: " + isPalpalindrome(test_input_3, 0, 4));
		String test_input_4 = "dad";
		System.out.println(test_input_4 + " status (1 = palindrome, 0 = not palindrome) is: " + isPalpalindrome(test_input_4, 0, 2));
		String test_input_5 = "funny";
		System.out.println(test_input_5 + " status (1 = palindrome, 0 = not palindrome) is: " + isPalpalindrome(test_input_5, 0, 4));
		System.out.println("End of Testing №2 (Recursion) Excercise 2");
		System.out.println("__________________________");
		 
		
	    // Part 3 (sorting methods).
		int [] arr1 = {4, 77, 98, 30, 20, 50, 77, 22, 49, 2};
		int [] arr2 = {4, 77, 98, 30, 20, 50, 77, 22, 49, 2};
		int [] arr3 = {4, 77, 98, 30, 20, 50, 77, 22, 49, 2};
		int [] arr4 = {4, 77, 98, 30, 20, 50, 77, 22, 49, 2};
        int [] arr5 = {4, 77, 98, 30, 20, 50, 77, 22, 49, 2};
		System.out.println("Original list looks like: {4, 77, 98, 30, 20, 50, 77, 22, 49, 2}");
        // Bubble sort test
		System.out.println("Bubble sort result: ");
		BubbleSort(arr4);
        //Selection sort test
		System.out.println("Selection sort result: ");
		SelectionSort(arr2);
		// Insertion sort test
		System.out.println("Insertion sort result: ");
		InsertionSort(arr1);
		// Merge sort test
		System.out.println("Merge sort result: ");
		MergeSort(arr3, 0, arr3.length-1);
        for(int i = 0; i <= arr3.length-1; i++){
            System.out.print(arr3[i]+" ");
        }
        System.out.println();
        // QuickSort Test
        System.out.println();
        System.out.println("QuickSort result: ");
		quickSort(arr5, 0, arr5.length-1);
        for(int i = 0; i <= arr5.length-1; i++){
            System.out.print(arr5[i]+" ");
        }
        System.out.println();
        System.out.println("_______________END OF PROGRAM__________________");
	}

	// Part 1 №1
	public static int IsReverse() {
		System.out.println("Enter 2 strings");
		Scanner scan = new Scanner(System.in);
		String First_String = scan.nextLine();
		String Second_String = scan.nextLine();
		int a = 0;
		if ((First_String.length()) != (Second_String.length())) {
			System.out.println("lenght is not the same");
			return a;
		}
		int number_of_iterations = First_String.length() - 1;
		int counter = Second_String.length() - 1;
		for (int i = 0; i <= number_of_iterations; i++) {
			if (First_String.charAt(i) == (Second_String.charAt(counter))) {
				a = 1;
				counter--;
			} else {
				return 0;
			}
		}
		return a;
	}

	// Part 1 №2
	public static void shortest_of_three() {
		System.out.println("Enter a string " + 
        "\n For example (Other entries include a historic district in Charlottesville Virginia cut-flower greenhouse complex)"+
        "\n should be entered as a single string to get the desirable results, the method will split it into a list of strings automatically: ");
		Scanner scan = new Scanner(System.in);
		String the_String = scan.nextLine();
		scan.close();
		String[] the_set = the_String.split(" ");
		int set_lenght = the_set.length;
		int number_of_triplets = set_lenght / 3;
		ArrayList<String> new_set = new ArrayList<String>();
		for (int i = 0; i < number_of_triplets; i++) {
			int lentgh_of_longest = 2147483647;
			int index_of_longest = 2147483647;
			for (int j = 0; j < 3; j++) {
				if (the_set[(i * 3) + j].length() < lentgh_of_longest) {
					lentgh_of_longest = the_set[(i * 3) + j].length();
					index_of_longest = (i * 3) + j;
				}
			}
			new_set.add(the_set[index_of_longest]);
		}

		System.out.println("The new string is: ");
		for (int i = 0; i < new_set.size(); i++) {
			System.out.print(new_set.get(i) + " ");
		}
		System.out.println("");
		System.out.println("");
	}

	// Part 2 №1
	// userArray is an input variable that holds all the values in the array. n is
	// the size of the array.
	public static int maxWithRecursion(int[] userArray, int n) {
		// once there is only one number in the array, we reach the base case
		if (n == 1) {
			return userArray[0];
		}
		// dive into the recursion loop
		return Math.max(userArray[n - 1], maxWithRecursion(userArray, n - 1));
	}

	// Part 2 №2
	// Finding number of zeroes in the binary representation of N.
	public static int numberOfZeros(int N) {
		// Case if the input is 0 also a BASE case
		if (N == 0) {
			return 0;
		}
		// If after devision by 2, the reminder is 1, it means that binary n is
		// ending with 1
		else if ((N % 2) == 1) {
			return numberOfZeros(N / 2) + 1;
		} // so we add one to return call
		else {
			return numberOfZeros(N / 2);
		} // if there is no reminder of 1, the binary representation on n ends with 0, so
			// we don't add 1 to our return call
	}

	// Part 2 №3
	// Check if the word is a palindrome
	static int isPalpalindrome(String InputString, int first, int last) {
		// In case there is one character - return 1 (as it is a polindrome0
		if (first == last)
			return 1;
		// then we test the first and last characters of the string (once they don't
		// match we know it is not a polindrome)
		if ((InputString.charAt(first)) != (InputString.charAt(last)))
			return 0;
		// once we check the border characters, we dive deeper into the string using the
		// recursion call.
		if (first < last + 1)
			return isPalpalindrome(InputString, first + 1, last - 1);

		return 1;
	}

	// Part 3 (Sorting)
	// Insertion Sort (Non-Recursive)
	public static void  InsertionSort(int [] InputArray) {
		for(int i = 1; i < InputArray.length; i++) {
			int tracer = InputArray[i];
			int j = i - 1;
			
			while(j >= 0 && InputArray[j] > tracer) {
				InputArray[j + 1] = InputArray[j];
				j--;
			}
			InputArray[j + 1] = tracer;
		}
		for (int i = 0; i < InputArray.length; i++) {
			System.out.print(InputArray[i] + " ");
		}
		System.out.println();
	}
	
	//Selection Sort (Non-Recursive)
	public static void  SelectionSort(int [] InputArray) {
		SelectionSort order = new SelectionSort();
		for(int i = 0; i < InputArray.length; i++) {
			
			int minimum = order.findMin(InputArray, i);
			order.swap(InputArray, i, minimum);
		}
		for (int i = 0; i < InputArray.length; i++) {
			System.out.print(InputArray[i] + " ");
		}
		System.out.println();
	}
	
	public static void swap(int [] InputArray, int i, int j) {
		int temp = InputArray[i];
		InputArray[i] = InputArray[j];
		InputArray[j] = temp;
	}
	
	public static int findMin(int [] InputArray, int i) {
		int minimum = i;
		while(i < InputArray.length) {
			if(InputArray[i] < InputArray [minimum]) {minimum = i;}
			i++;
		}
		return minimum;
	}
	// in separate class file (The way which we have used during the recitation)
	// I CANT GET WHAT NEEDS A FIX HERE.
	//MergeSort Sort
	 
	public static void MergeSort(int [] Array, int start, int end) {
		if (start < end){
            int mid = (start + end)/2;
            MergeSort(Array, start, mid);
            MergeSort(Array, mid+1, end);
            merge(Array, start, mid, end);
        }
	}
	 
	public static void merge(int [] Array, int start, int mid, int end) {
		int n1 = mid - start + 1;
		int n2 = end - mid;
		 
		int[] l = new int[n1];
		int[] r = new int[n2];
		
        for (int i = 0; i < n1; ++i)
            l[i] = Array[start + i];
        for (int j = 0; j < n2; ++j)
            r[j] = Array[mid + 1 + j];
		
		int i = 0, j = 0;
        int k = start;
	    while (i < n1 && j < n2) {
			if(l[i] <= r[j]) {
				Array[k] = l[i];
				i++;
			}
			else {
				Array[k] = r[j];
				j++;
			}
			k++;
		}
        while (i < n1) {
            Array[k] = l[i];
            i++;
            k++;
        }
        while (j < n2) {
            Array[k] = r[j];
            j++;
            k++;
        }
	}
	
	
	//Bubble Sort
	// used the pseudo code from the class slides
	public static void BubbleSort(int [] InputArray) { 
		int temp;
		int size = InputArray.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < (size - 1 - i); j++) {
				if (InputArray[j] > InputArray[j+1]) {
					temp = InputArray[j];
					InputArray[j] = InputArray[j+1];
					InputArray[j+1] = temp;
				}
			}
		}
		for (int a = 0; a < InputArray.length; a++) {
			System.out.print(InputArray[a] + " ");
		}
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

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {

		System.out.println("HW2, Kirill Dolgin");
		
																			// Part I
		System.out.println("Testing number 1, Arrays");
		System.out.println(
				"The runing time of the algorithm of IsReverse() is o(n) as it uses one for loop that runs thought the lenght of the strings. ");
		System.out.println("n in this algorithm is number of characters in the string");
		int result1 = IsReverse();
		System.out.println("The result of 2 strings inverse-comparison is: " + result1);
		System.out.println("End of test for №1 Part 1");
		System.out.println("___");

		
		
		System.out.println("Testing number 1, Smallest of the thee words gets to stay");
		System.out.println(
				"The runing time of the algorithm of everyThird() is o(n2) as it uses one for loops that are dependent on the number of space separated words. ");
		System.out.println("n in this algorithm is number of space separated words in the entered string");
		everyThird();
		System.out.println("End of test for №1 Part 2");
		System.out.println("___");

		
																			// Part II
		System.out.println("Testing number №2, Finding minimun with recursion");
		System.out.println(
				"The runing time of the algorithm of minWithRecursion is o(log(n)) as it uses recusion and splits the array by 2 everytime the recursion call is made");
		System.out.println("n in this algorithm is the lenght of the array that is put in the method");
		int[] testarray = { 2, 1, 3, 5, 7, 0, -1, 80, 3, 15, -10, 3, 40 };
		System.out.println("Test array like: { 2, 1, 3, 5, 7, 0, -1, 80, 3, 15, -10, 3, 40 }");
		System.out.println("the samllest number in the testarray is: " + minWithRecursion(testarray, testarray.length));
		System.out.println("End of the test for Part 2 №1");
		System.out.println("___");

		
		
		
		System.out.println("Testing number №2, Finding number of once in the binary representation of the code");
		System.out.println(
				"The runing time of the algorithm of numberOfZeros is o(log(n)) as it uses recusion and keeps deviding number by 2 everytime the recursion call is made");
		System.out.println("n in this algorithm is the lenght of the array that is put in the method");
		int testunput1 = 1;
		System.out.println(
				"The number of zeros in binary representation of " + testunput1 + " is: " + numberOfZeros(testunput1));
		System.out.println("End of the test for Part 2 №2");
		System.out.println("___");

		
		
		System.out.println("Testing number №2, is a word a palindrome?");
		System.out.println(
				"The runing time of the algorithm of numberOfZeros is o(log(n)) as it uses recusion and keeps checking to last characters.");
		System.out.println("n in this algorithm is the lenght of the input string that is put in the method");
		String testunput2 = "kayak";
		System.out.println(testunput2 + " status (1 = palindrome, 0 = not palindrome) is: " + isPalpalindrome(testunput2, 0, 4));
		String testunput3 = "radar";
		System.out.println(testunput3 + " status (1 = palindrome, 0 = not palindrome) is: " + isPalpalindrome(testunput3, 0, 4));
		String testunput4 = "dad";
		System.out.println(testunput4 + " status (1 = palindrome, 0 = not palindrome) is: " + isPalpalindrome(testunput4, 0, 2));
		String testunput5 = "funny";
		System.out.println(testunput5 + " status (1 = palindrome, 0 = not palindrome) is: " + isPalpalindrome(testunput5, 0, 4));
		System.out.println("End of the test for Part 2 №3");
		System.out.println("___");
		 
		
	
																		// Part 3 
		//sorting methods.
		int [] arr1 = {4, 77, 98, 30, 20, 50, 77, 22, 49, 2};
		int [] arr2 = {4, 77, 98, 30, 20, 50, 77, 22, 49, 2};
		int [] arr3 = {4, 77, 98, 30, 20, 50, 77, 22, 49, 2};
		int [] arr4 = {4, 77, 98, 30, 20, 50, 77, 22, 49, 2};
		System.out.println("Original list looks like: {4, 77, 98, 30, 20, 50, 77, 22, 49, 2}");
		// Insertion sort test
		System.out.println("Insertion sort result: ");
		InsertionSort(arr1);
		//Selection sort test
		System.out.println("Selection sort result: ");
		SelectionSort(arr2);
		// Merge sort test
		System.out.println("Merge sort result: ");
		MergeSort(arr3);
		// Bubble sort test
		System.out.println("Bubble sort result: ");
		BubbleSort(arr4);
		
		
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
		int first_counter = 0;
		int second_counter = Second_String.length() - 1;
		for (int i = 0; i <= number_of_iterations; i++) {
			if (First_String.charAt(i) == (Second_String.charAt(second_counter))) {
				a = 1;
				first_counter++;
				second_counter--;
			} else {
				return 0;
			}
		}
		return a;
	}

	// Part 1 №2
	public static void everyThird() {
		System.out.println("Enter a string");
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
	public static int minWithRecursion(int[] userArray, int n) {
		// once there is only one number in the array, we reach the base case
		if (n == 1) {
			return userArray[0];
		}
		// dive into the recursion loop
		return Math.min(userArray[n - 1], minWithRecursion(userArray, n - 1));
	}

	// Part 2 №2
	// Finding number of zeroes in the binary representation of N.
	public static int numberOfZeros(int N) {
		// Case if the input is 0 also a BASE case
		if (N == 0) {
			return 0;
		}
		// If there after devision by 2, the reminder is 1, it means that binary n is
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
		// match we, it is not a polindrome)
		if ((InputString.charAt(first)) != (InputString.charAt(last)))
			return 0;
		// once we check the border characters, we dive deeper into the string using the
		// recursion call.
		if (first < last + 1)
			return isPalpalindrome(InputString, first + 1, last - 1);

		return 1;
	}

	// Part 3
	// Insertion Sort
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
	
	//Selection Sort
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
	 public static void MergeSort(int[] Array) {
		 	mergeSort(Array, 0, Array.length-1);
		 	for (int i = 0; i < Array.length; i++) {
				System.out.print(Array[i] + " ");
			}
		 	System.out.println(" ");
	 }
	 
	 public static void mergeSort(int [] Array, int start, int end) {
		 if (start >= end) {
			 return;
		 }
		 int mid = (start + end)/2;
		 mergeSort(Array, start, mid);
		 mergeSort(Array, mid+1, end);
		 mergeSorted(Array, start, mid, end);
	 }
	 
	 public static void mergeSorted(int [] Array, int start, int mid, int end) {
		 int n1 = mid - start + 1;
		 int n2 = end - mid;
		 
		 int[] l = new int[n1];
		 int[] r = new int[n2];
		 
		 for (int i = 0; i < n1; i++) {
			 l[i] = Array[i+start];
		 }
		 for (int i = 0; i < n2; i++) {
			 r[i] = Array[i+start];
		 }
		 
		 int i = 0, j = 0, k = start;
		 while (i < n1 && j < n2) {
			 if(l[i] <= r[j]) {
				 Array[k] = l [i];
				 i++;
			 }
			 else {
				 Array[k] = r[j];
				 j++;
			 }
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
	
	
}// last one

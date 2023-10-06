////////////////////////////////////////////////////////////////
/// Program for exercise 1.
////////////////////////////////////////////////////////////////
import java.util.Scanner;



public class Exercise1 {
////////////////////////////////////////////////////////////////
// MAIN START 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("____________________________________________");
        System.out.println("Welcome to Excercise 1 program.");
        System.out.println("What would you like the size of random integer arrays for the test to be?");
        int array_size = input.nextInt();
        System.out.println("Generating 4 arrays of random integers of length: " + array_size +".");
        String s = "What do you want to do next?";
        int[] intArray1 = new int[array_size];
        int[] intArray2 = new int[array_size];
        int[] intArray3 = new int[array_size];
        int[] intArray4 = new int[array_size];
        for(int i = 0; i<array_size; i++){
            intArray1[i] = (int)(java.lang.Math.random()*100);
            intArray2[i] = (int)(java.lang.Math.random()*100);
            intArray3[i] = (int)(java.lang.Math.random()*100);
            intArray4[i] = (int)(java.lang.Math.random()*100);
        }
        Tree1 theTree = new Tree1();
        for(int i = 0; i < intArray4.length; i++){
            Tree1.insert(intArray4[i]);
        }
        System.out.println("Generated 4 original arrays for 4 tests:     ");
        printArray(intArray1);
        printArray(intArray2);
        printArray(intArray3);
        printArray(intArray4);
        System.out.println("Please make a selection of which algorythm you want to use to sort the array:");
        System.out.println("1. Recursively with O(n*log(n)) algorythm (Merge Sort)," + 
        "\n2. Recursively with O(n*log(n)) algorythm (Quick Sort)," + 
        "\n3. Recursively with O(n*log(n)) algorythm (Binary Heap)," + 
        "\n4. Sort using a Binary Search Tree (BST); in-order traversal of a binary search tree produces a sorted array." +
        "\n5. Exit.");
        int option_choice = 0;
        do{
            option_choice = input.nextInt();
            switch(option_choice){

                case 1:
                System.out.println("Original Array is:");
                printArray(intArray1);
                System.out.println("Sorting array using Merge Sort:");
                MergeSort(intArray1, 0, intArray1.length-1);
                System.out.println("Sorted Array is:");
                printArray(intArray1);
                System.out.println(s);
                break;

                case 2:
                System.out.println("Original Array is:");
                printArray(intArray2);
                System.out.println("Sorting array using Quick Sort");
                QuickSort(intArray2, 0, intArray2.length-1);
                System.out.println("Sorted Array is:");
                printArray(intArray2);
                System.out.println(s);
                break;

                case 3:
                System.out.println("Original Array is:");
                printArray(intArray3);
                System.out.println("Sorting array using Binary Heap:");
                heap_sort(intArray3);
                System.out.println("Sorted Array is:");
                printArray(intArray3);
                System.out.println(s);
                break;

                case 4:
                System.out.println("Original Array is:");
                printArray(intArray4);
                System.out.println("Sorting array using BST in-order traversal:");
                theTree.traverse_in_order();
                System.out.println(s);
                break;

                case 5:
                System.out.println("Thank you for using Excercise 1 program!");
                System.out.println("_________________________________________________");
                break;

                default:
                System.out.println("No such option, please try again");
                break;
            }
        }while(option_choice != 5);

        input.close();
        
    }
// MAIN END 
////////////////////////////////////////////////////////////////
	

////////////////////////////////////////////////////////////////
// Sorting Methods START:
//////////////////////////////////////////////////////////////// - MergeSort START
	public static void MergeSort(int [] Array, int start, int end) {
		if (start < end){
            int mid = (start + end)/2;
            MergeSort(Array, start, mid);
            MergeSort(Array, mid+1, end);
            merge(Array, start, mid, end);
        }
	}
//////////////////////////////////////////////////////////////// - MergeSort END
//////////////////////////////////////////////////////////////// - Quicksort START
    public static void QuickSort(int[] a, int start, int end) {
		if (a == null || a.length == 0){
            		return;
		}
		if (start >= end){
            		return;
        	}
		int mid = start + (end - start) / 2;
		int pivot = a[mid];
		int i = start; 
        int j = end;
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
            QuickSort(a, start, j);
        }
		if (end > i){
            QuickSort(a, i, end);

        }
	}
//////////////////////////////////////////////////////////////// - Quicksort END
//////////////////////////////////////////////////////////////// - Merge START
	public static void merge(int [] Array, int start, int mid, int end) {
		int n1 = mid - start + 1;
		int n2 = end - mid;
		 
		int[] l = new int[n1];
		int[] r = new int[n2];
		
        for (int i = 0; i < n1; ++i)
            l[i] = Array[start + i];
        for (int j = 0; j < n2; ++j)
            r[j] = Array[mid + 1 + j];
		
		int i = 0; 
        int j = 0;
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
//////////////////////////////////////////////////////////////// - Merge END
//////////////////////////////////////////////////////////////// - heap_sort START
    public static void heap_sort(int[] arr){
        int n = arr.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--){
            turn_to_heap(arr, n, i);
        }
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call max turn_to_heap on the reduced heap
            turn_to_heap(arr, i, 0);
        }
    }
//////////////////////////////////////////////////////////////// - heap_sort END
//////////////////////////////////////////////////////////////// - turn_to_heap START
    static void turn_to_heap(int[] arr, int n, int i){
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively turn_to_heap the affected sub-tree
         turn_to_heap(arr, n, largest);
        }
    }
//////////////////////////////////////////////////////////////// - turn_to_heap END
//////////////////////////////////////////////////////////////// - printArray START    /* A utility function to print array of size n */
    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
//////////////////////////////////////////////////////////////// - printArray END
// Sorting Methods END 
////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////
// Tree START 
class Tree1 {
    public static Node1 root; // first node of tree

    // -------------------------------------------------------------
    public Tree1() { // constructor
        root = null; // no nodes in tree yet
    }

    // Insert Method-------------------------------------------------------------
    public static void insert(int id) {
        Node1 newNode = new Node1(); // make new node
        newNode.iData = id; // insert data
        if (root == null) // no node in root
            root = newNode;
        else // root occupied
        {
            Node1 current = root; // start at root
            Node1 parent;
            while (true) // (exits internally)
            {
                parent = current;
                if (id < current.iData) // go left?
                {
                    current = current.leftChild;
                    if (current == null) // if end of the line,
                    { // insert on left
                        parent.leftChild = newNode;
                        return;
                    }
                } // end if go left
                else // or go right?
                {
                    current = current.rightChild;
                    if (current == null) // if end of the line
                    { // insert on right
                        parent.rightChild = newNode;
                        return;
                    }
                } // end else go right
            } // end while
        } // end else not root
    } // end insert()
    // Traverse in order utility Method-------------------------------------------------------------
    public void traverse_in_order() {
        System.out.println("Sorted Array is:");
        inOrder(root);
        System.out.println();
    }
    
    // Traverse in order Method-------------------------------------------------------------
    private void inOrder(Node1 localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }
}
// Tree END 
////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////
// Node START 
class Node1 {

    public int iData; // data item (key)
    public Node1 leftChild; // this node's left child
    public Node1 rightChild; // this node's right child
    // Display node Method-------------------------------------------------------------
    public void displayNode() // display ourself
    {
        System.out.print('{');
        System.out.print(iData);
        System.out.print("} ");
    }
} 
// Node END 
////////////////////////////////////////////////////////////////



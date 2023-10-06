public class SelectionSort {
	public static void SelectionSort(int[] InputArray) {
		SelectionSort order = new SelectionSort();
		for (int i = 0; i < InputArray.length; i++) {

			int minimum = order.findMin(InputArray, i);
			order.swap(InputArray, i, minimum);
		}
		for (int i = 0; i < InputArray.length; i++) {
			System.out.print(InputArray[i] + " ");
		}
		System.out.println();
	}

	public static void swap(int[] InputArray, int i, int j) {
		int temp = InputArray[i];
		InputArray[i] = InputArray[j];
		InputArray[j] = temp;
	}

	public static int findMin(int[] InputArray, int i) {
		int minimum = i;
		while (i < InputArray.length) {
			if (InputArray[i] < InputArray[minimum]) {
				minimum = i;
			}
			i++;
		}
		return minimum;
	}
}
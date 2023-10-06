
public class BubbleSort {
	void BubbleSort(int [] List) { 
		int temp;
		int size = List.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < (size - 1 - i); j++) {
				if (List[j] > List[j+1]) {
					temp = List[j];
					List[j] = List[j+1];
					List[j+1] = temp;
				}
			}
		}
	}
}
